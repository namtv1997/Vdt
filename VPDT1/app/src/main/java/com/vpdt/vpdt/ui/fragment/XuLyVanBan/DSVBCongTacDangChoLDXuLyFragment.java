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
import com.vpdt.vpdt.model.DSVB_DaChiDao;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.DSVBCongTacDangChoLDXuLyPresenter;
import com.vpdt.vpdt.presenter.DSVBCongTacDangChoLDXuLyView;
import com.vpdt.vpdt.presenter.impl.DSVBCongTacDangChoLDXuLyPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.NDVBDSVBCongTacDangChoLDXLActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.TTVBCongViecPhoiHopChoXuLyActivity;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.adapter.Adapter_DSVB_DaChiDao;
import com.vpdt.vpdt.util.EndlessRecyclerViewScrollListener;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DSVBCongTacDangChoLDXuLyFragment extends BaseFragment<DSVBCongTacDangChoLDXuLyPresenter> implements DSVBCongTacDangChoLDXuLyView,
        Adapter_DSVB_DaChiDao.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {
    @BindView(R.id.recyclerviewDSVBCongTacDangChoLDXL)
    RecyclerView recyclerviewDSVBCongTacDangChoLDXL;
    @BindView(R.id.btnNamLamViecDSVBCongTacDangChoLDXL)
    Button btnNamLamViecDSVBCongTacDangChoLDXL;
    @BindView(R.id.swipe_layoutDSVBCongTacDangChoLDXL)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.tvTSVBDSVBCongTacDangChoLDXL)
    TextView tvTSVB;

    private EndlessRecyclerViewScrollListener scrollListener;
    private Adapter_DSVB_DaChiDao listAdapter;

    String NamLamViec;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_dsvb_congtacdangcholanhdaoxuly;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);
        listAdapter = new Adapter_DSVB_DaChiDao(getContext(), getPresenter().dsvb_daChiDaos(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewDSVBCongTacDangChoLDXL.setLayoutManager(layoutManager);
        recyclerviewDSVBCongTacDangChoLDXL.setAdapter(listAdapter);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getallvbcongtacdangchoxuly(NamLamViec, true);
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getallvbcongtacdangchoxuly(NamLamViec, false);
            }
        };
        recyclerviewDSVBCongTacDangChoLDXL.addOnScrollListener(scrollListener);
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
        btnNamLamViecDSVBCongTacDangChoLDXL.setText("Năm làm việc: " + NamLamViec + " ");
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        getPresenter().getallvbcongtacdangchoxuly(NamLamViec, true);
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetDataSuccess() {
        listAdapter.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
        getPresenter().Countvbcongtacdangchoxuly(NamLamViec);

    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {
        if (response.getData() == 0 || response.getMessage() == "Lỗi hệ thống") {
            recyclerviewDSVBCongTacDangChoLDXL.setVisibility(View.GONE);
            Util.showMessenger("Không có văn bản nào", getActivity());
        } else {
            recyclerviewDSVBCongTacDangChoLDXL.setVisibility(View.VISIBLE);
        }
        tvTSVB.setText(String.valueOf(response.getData()));
    }

    @Override
    public DSVBCongTacDangChoLDXuLyPresenter createPresenter() {
        return new DSVBCongTacDangChoLDXuLyPresenterImpl(this);
    }

    @OnClick({R.id.btnNamLamViecDSVBCongTacDangChoLDXL, R.id.btnBackDSVBCongTacDangChoLDXL,
            R.id.lnctd, R.id.rlctd, R.id.vctd, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnNamLamViecDSVBCongTacDangChoLDXL:
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

            case R.id.btnBackDSVBCongTacDangChoLDXL:
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViecDSVBCongTacDangChoLDXL.setText("Năm làm việc: " + integer + " ");
        getPresenter().getallvbcongtacdangchoxuly(String.valueOf(integer), true);
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public void onItemClickXemFile(DSVB_DaChiDao dsvbDaChiDao) {
        try {
            if (dsvbDaChiDao.getTepDinhKems().size() == 0) {
                Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
            } else if (dsvbDaChiDao.getTepDinhKems().size() == 1) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dsvbDaChiDao.getTepDinhKems().get(0).getDuongDan()));
                startActivity(browserIntent);
            } else {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dsvbDaChiDao.getTepDinhKems().get(dsvbDaChiDao.getTepDinhKems().size() - 1).getDuongDan()));
                startActivity(browserIntent);
            }
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onItemClickXuLy(DSVB_DaChiDao dsvbDaChiDao) {
        if (!click) {
            Intent intent = new Intent(getActivity(), NDVBDSVBCongTacDangChoLDXLActivity.class);
            intent.putExtra("ID_VANBAN_CONGTACDANG", dsvbDaChiDao.getIdVanBan());
            startActivity(intent);
            click = true;
        }
    }

    @Override
    public void onItemClickXemChiTiet(DSVB_DaChiDao dsvbDaChiDao) {
        if (!click) {
            Intent intent = new Intent(getActivity(), TTVBCongViecPhoiHopChoXuLyActivity.class);
            intent.putExtra("ID_VANBAN_CONGVIECPHOIHOPCHOXULY", dsvbDaChiDao.getIdVanBan());
            startActivity(intent);
            click = true;
        }
    }
}
