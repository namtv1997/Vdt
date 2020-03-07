package com.vpdt.vpdt.ui.fragment.XuLyVanBan;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseFragment;
import com.vpdt.vpdt.model.GiaHanGiaiQuyet;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.DuyetDSVB_GiaHanGiaiQuyetPresenter;
import com.vpdt.vpdt.presenter.DuyetDSVB_GiaHanGiaiQuyetView;
import com.vpdt.vpdt.presenter.impl.DuyetDSVB_GiaHanGiaiQuyetImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.NDVBDuyetDSVBGiaHanGiaiQuyetActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.NDVBDuyetDSVBGiaHanGiaiQuyetTruongPhongActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.TTVBDuyetDSVBGiaHanGiaiQuyetTruongPhongActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.TTVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity;
import com.vpdt.vpdt.ui.adapter.AdapterGiaHanGiaiQuyet;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.util.EndlessRecyclerViewScrollListener;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DuyetDSVB_GiaHanGiaiQuyetFragment extends BaseFragment<DuyetDSVB_GiaHanGiaiQuyetPresenter> implements DuyetDSVB_GiaHanGiaiQuyetView,
        AdapterGiaHanGiaiQuyet.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.recyclerviewDuyetDSVB_GiaHanGiaiQuyet)
    RecyclerView recyclerviewDuyetDSVB_GiaHanGiaiQuyet;

    @BindView(R.id.btnNamLamViecDuyetDSVB_GiaHanGiaiQuyet)
    Button btnNamLamViecDuyetDSVB_GiaHanGiaiQuyet;
    @BindView(R.id.swipe_layoutDuyetDSVB_GiaHanGiaiQuyet)
    SwipeRefreshLayout swipe_layoutDuyetDSVB_GiaHanGiaiQuyet;
    @BindView(R.id.tvTSVBDuyetDSVB_GiaHanGiaiQuyet)
    TextView tvTSVBDuyetDSVB_GiaHanGiaiQuyet;

    private EndlessRecyclerViewScrollListener scrollListener;
    private AdapterGiaHanGiaiQuyet adapterGiaHanGiaiQuyet;

    String NamLamViec;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;
    int level;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_duyetdsvb_giahangiaiquyet;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);
        adapterGiaHanGiaiQuyet = new AdapterGiaHanGiaiQuyet(getActivity(), getPresenter().giaHanGiaiQuyets(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewDuyetDSVB_GiaHanGiaiQuyet.setLayoutManager(layoutManager);
        recyclerviewDuyetDSVB_GiaHanGiaiQuyet.setAdapter(adapterGiaHanGiaiQuyet);
        swipe_layoutDuyetDSVB_GiaHanGiaiQuyet.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getallvbgiahangiaiquyet(NamLamViec, true);
            }
        });

        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getallvbgiahangiaiquyet(NamLamViec, false);
            }
        };
        recyclerviewDuyetDSVB_GiaHanGiaiQuyet.addOnScrollListener(scrollListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        integerArrayList.clear();
    }

    @Override
    public void onStart() {
        super.onStart();
        click = false;
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        level = PrefUtil.getInt(getContext(), Key.LEVEL, 0);
        btnNamLamViecDuyetDSVB_GiaHanGiaiQuyet.setText("Năm làm việc: " + NamLamViec + " ");
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        getPresenter().getallvbgiahangiaiquyet(NamLamViec, true);
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetDataSuccess() {
        adapterGiaHanGiaiQuyet.notifyDataSetChanged();
        swipe_layoutDuyetDSVB_GiaHanGiaiQuyet.setRefreshing(false);
        getPresenter().countvbgiahangiaiquyet(NamLamViec);

    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {
        if (response.getData() == 0 || response.getMessage() == "Lỗi hệ thống") {
            recyclerviewDuyetDSVB_GiaHanGiaiQuyet.setVisibility(View.GONE);
            Util.showMessenger("Không có văn bản nào", getActivity());
        } else {
            recyclerviewDuyetDSVB_GiaHanGiaiQuyet.setVisibility(View.VISIBLE);
        }
        tvTSVBDuyetDSVB_GiaHanGiaiQuyet.setText(String.valueOf(response.getData()));
    }

    @Override
    public DuyetDSVB_GiaHanGiaiQuyetPresenter createPresenter() {
        return new DuyetDSVB_GiaHanGiaiQuyetImpl(this);
    }

    @OnClick({R.id.btnNamLamViecDuyetDSVB_GiaHanGiaiQuyet, R.id.btnBackDuyetDSVB_GiaHanGiaiQuyet,
            R.id.rlghgq, R.id.vghgq, R.id.lnghgq, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnNamLamViecDuyetDSVB_GiaHanGiaiQuyet:
                android.support.v7.app.AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.recyclerview_nam_selected, null);
                builder.setView(view1);
                dialog = builder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                rvSelectNam = view1.findViewById(R.id.rvSelectNam);
                rvSelectNam.setLayoutManager(layoutManager);
                rvSelectNam.setAdapter(adapterNamLamViec);
                adapterNamLamViec.notifyDataSetChanged();
                break;
            case R.id.btnBackDuyetDSVB_GiaHanGiaiQuyet:
                Objects.requireNonNull(getActivity()).onBackPressed();

                break;
        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViecDuyetDSVB_GiaHanGiaiQuyet.setText("Năm làm việc: " + integer + " ");
        getPresenter().getallvbgiahangiaiquyet(String.valueOf(integer), true);
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public void onItemClickXemFile(GiaHanGiaiQuyet giaHanGiaiQuyet) {
        try {
            if (giaHanGiaiQuyet.getTepDinhKems().size() == 0) {
                Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
            } else if (giaHanGiaiQuyet.getTepDinhKems().size() == 1) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(giaHanGiaiQuyet.getTepDinhKems().get(0).getDuongDan()));
                startActivity(browserIntent);
            } else {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(giaHanGiaiQuyet.getTepDinhKems().get(giaHanGiaiQuyet.getTepDinhKems().size() - 1).getDuongDan()));
                startActivity(browserIntent);
            }
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClickXuLy(GiaHanGiaiQuyet giaHanGiaiQuyet) {
        try {
            if (!click) {
                if (level == 4 || level == 5) {
                    Intent i = new Intent(getContext(), NDVBDuyetDSVBGiaHanGiaiQuyetActivity.class);
                    i.putExtra("hanGiaiQuyet", giaHanGiaiQuyet);
                    startActivity(i);
                } else if (level == 6 || level == 7 || level == 3) {
                    Intent i = new Intent(getContext(), NDVBDuyetDSVBGiaHanGiaiQuyetTruongPhongActivity.class);
                    i.putExtra("hanGiaiQuyetTruongPhong", giaHanGiaiQuyet);
                    startActivity(i);
                }
                click = true;
            }
        } catch (Exception e) {
            Toast.makeText(getContext(), "Lỗi hệ thống", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClickXemChiTiet(GiaHanGiaiQuyet giaHanGiaiQuyet) {
        try {
            if (!click) {
                if (level == 4 || level == 5) {
                    Intent intent1 = new Intent(getActivity(), TTVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity.class);
                    intent1.putExtra("vanBanDaDeXuatGiaHanGiaiQuyet", giaHanGiaiQuyet.getIdVanBan());
                    startActivity(intent1);
                } else if (level == 6 || level == 7 || level == 3) {
                    Intent intent1 = new Intent(getActivity(), TTVBDuyetDSVBGiaHanGiaiQuyetTruongPhongActivity.class);
                    intent1.putExtra("hanGiaiQuyetTruongPhong", giaHanGiaiQuyet.getIdVanBan());
                    startActivity(intent1);
                }
                click = true;
            }
        } catch (Exception e) {
            Toast.makeText(getContext(), "Lỗi hệ thống", Toast.LENGTH_SHORT).show();
        }
    }
}
