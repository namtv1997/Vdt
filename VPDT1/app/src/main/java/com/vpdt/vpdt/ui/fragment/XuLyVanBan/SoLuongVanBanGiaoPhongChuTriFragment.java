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
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.SoLuongVanBanGiaoPhongChuTri;
import com.vpdt.vpdt.presenter.SoLuongVanBanGiaoPhongChuTriPresenter;
import com.vpdt.vpdt.presenter.SoLuongVanBanGiaoPhongChuTriView;
import com.vpdt.vpdt.presenter.impl.SoLuongVanBanGiaoPhongChuTriPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.NDVBSoLuongVanBanGiaoPhongChuTriActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.TTVBSoLuongVanBanGiaoPhongChuTri1Activity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.TTVBSoLuongVanBanGiaoPhongChuTriActivity;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.adapter.AdapterSoLuongVanBanGiaoPhongChuTri;
import com.vpdt.vpdt.util.EndlessRecyclerViewScrollListener;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SoLuongVanBanGiaoPhongChuTriFragment extends BaseFragment<SoLuongVanBanGiaoPhongChuTriPresenter> implements SoLuongVanBanGiaoPhongChuTriView,
        AdapterSoLuongVanBanGiaoPhongChuTri.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {
    @BindView(R.id.recyclerviewChoXuLy)
    RecyclerView recyclerviewChoXuLy;

    @BindView(R.id.btnNamLamViecChoXuLy)
    Button btnNamLamViecChoXuLy;

    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.tvTSVB)
    TextView tvTSVB;

    String NamLamViec;

    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;
    boolean click = false;

    private EndlessRecyclerViewScrollListener scrollListener;
    private AdapterSoLuongVanBanGiaoPhongChuTri listAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_soluongvanbangiaophongchutri;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);
    }


    @Override
    public void onStart() {
        super.onStart();
        click = false;
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViecChoXuLy.setText("Năm làm việc: " + NamLamViec + "   ");
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }

        getPresenter().getAllVBGiaoPhongChuTri(NamLamViec, true);

        listAdapter = new AdapterSoLuongVanBanGiaoPhongChuTri(getPresenter().SO_LUONG_VAN_BAN_GIAO_PHONG_CHU_TRI_ARRAY_LIST(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewChoXuLy.setLayoutManager(layoutManager);
        recyclerviewChoXuLy.setAdapter(listAdapter);

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getAllVBGiaoPhongChuTri(NamLamViec, true);
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getAllVBGiaoPhongChuTri(NamLamViec, false);
            }
        };
        recyclerviewChoXuLy.addOnScrollListener(scrollListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        integerArrayList.clear();
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetDataSuccess() {
        listAdapter.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
        getPresenter().countAllVBGiaoPhongChuTri(NamLamViec);

    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {
        if (response.getData() == 0) {
            recyclerviewChoXuLy.setVisibility(View.GONE);
            Util.showMessenger("Không có văn bản nào", getActivity());
        } else {
            recyclerviewChoXuLy.setVisibility(View.VISIBLE);
        }
        tvTSVB.setText(String.valueOf(response.getData()));
    }


    @OnClick({R.id.btnNamLamViecChoXuLy, R.id.btnBackChoXuLy,
            R.id.vcldxl, R.id.rlcldxl, R.id.rlcldxl1, R.id.lncldxl, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnNamLamViecChoXuLy:
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
            case R.id.btnBackChoXuLy:
                Objects.requireNonNull(getActivity()).onBackPressed();

                break;

        }
    }


    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViecChoXuLy.setText("Năm làm việc: " + integer + " ");
        getPresenter().getAllVBGiaoPhongChuTri(String.valueOf(integer), true);
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public SoLuongVanBanGiaoPhongChuTriPresenter createPresenter() {
        return new SoLuongVanBanGiaoPhongChuTriPresenterImpl(this);
    }

    @Override
    public void onItemClickXemFile(SoLuongVanBanGiaoPhongChuTri soLuongVanBanGiaoPhongChuTri) {
        if (soLuongVanBanGiaoPhongChuTri.getUrlFile().isEmpty() || soLuongVanBanGiaoPhongChuTri.getUrlFile() == null) {
            Toast.makeText(getActivity(), "Không có file đính kèm", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(soLuongVanBanGiaoPhongChuTri.getUrlFile()));
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onItemClickXuLy(SoLuongVanBanGiaoPhongChuTri soLuongVanBanGiaoPhongChuTri) {
        if (!click) {
            Intent intent = new Intent(getActivity(), NDVBSoLuongVanBanGiaoPhongChuTriActivity.class);
            intent.putExtra("soLuongVanBanGiaoPhongChuTri", soLuongVanBanGiaoPhongChuTri);
            startActivity(intent);
            click = true;
        }

    }

    @Override
    public void onItemClickXemChiTiet(SoLuongVanBanGiaoPhongChuTri soLuongVanBanGiaoPhongChuTri) {
        if (!click) {
            if (!soLuongVanBanGiaoPhongChuTri.getGiayMoiGio().isEmpty() && !soLuongVanBanGiaoPhongChuTri.getGiayMoiNgay().isEmpty() && !soLuongVanBanGiaoPhongChuTri.getGiayMoiDiaDiem().isEmpty()) {
                Intent intent = new Intent(getActivity(), TTVBSoLuongVanBanGiaoPhongChuTriActivity.class);
                intent.putExtra("idvb", soLuongVanBanGiaoPhongChuTri.getId());
                startActivity(intent);
            } else {
                Intent intent = new Intent(getActivity(), TTVBSoLuongVanBanGiaoPhongChuTri1Activity.class);
                intent.putExtra("idvb", soLuongVanBanGiaoPhongChuTri.getId());
                startActivity(intent);
            }
            click = true;
        }
    }
}
