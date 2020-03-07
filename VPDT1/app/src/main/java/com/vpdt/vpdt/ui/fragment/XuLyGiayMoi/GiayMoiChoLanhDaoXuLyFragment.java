package com.vpdt.vpdt.ui.fragment.XuLyGiayMoi;

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
import com.vpdt.vpdt.model.GiayMoiChoLanhDaoXuLy;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.GiayMoiChoLanhDaoXuLyPresenter;
import com.vpdt.vpdt.presenter.GiayMoiChoLanhDaoXuLyView;
import com.vpdt.vpdt.presenter.impl.GiayMoiChoLanhDaoXuLyPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.XuLyGiayMoi.NDVBGiayMoiChoLDXLActivity;
import com.vpdt.vpdt.ui.activity.XuLyGiayMoi.ThongTinGiayMoiDaXuLyActivity;
import com.vpdt.vpdt.ui.adapter.AdapterGiayMoiChoLanhDaoXuLy;
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

public class GiayMoiChoLanhDaoXuLyFragment extends BaseFragment<GiayMoiChoLanhDaoXuLyPresenter> implements GiayMoiChoLanhDaoXuLyView,
        AdapterGiayMoiChoLanhDaoXuLy.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.tvTongSoVanBan)
    TextView tvTongSoVanBan;
    boolean click = false;

    String NamLamViec;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;
    String loaivanban = "", sokyhieu = "", donvi = "", ngayky = "", ngaynhap = "", ngayden = "", trichyeu = "", nguoiky = "", soden = "", chucvu = "", nguoinhap = "";

    AdapterGiayMoiChoLanhDaoXuLy adapterGiayMoiChoLanhDaoXuLy;

    private EndlessRecyclerViewScrollListener scrollListener;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_giay_moi_cho_lanh_dao_xu_ly;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);
        adapterGiayMoiChoLanhDaoXuLy = new AdapterGiayMoiChoLanhDaoXuLy(getActivity(), getPresenter().giayMoiChoLanhDaoXuLyArrayList(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterGiayMoiChoLanhDaoXuLy);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getallgiaymoicholanhdaoxuly(NamLamViec, true, loaivanban, sokyhieu, donvi, ngayky, ngaynhap, ngayden, trichyeu, nguoiky, soden, chucvu, nguoinhap);
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getallgiaymoicholanhdaoxuly(NamLamViec, false, loaivanban, sokyhieu, donvi, ngayky, ngaynhap, ngayden, trichyeu, nguoiky, soden, chucvu, nguoinhap);
            }
        };
        recyclerview.addOnScrollListener(scrollListener);
    }

    @Override
    public void onStart() {
        super.onStart();
        click = false;
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }

        getPresenter().getallgiaymoicholanhdaoxuly(NamLamViec, true, loaivanban, sokyhieu, donvi, ngayky, ngaynhap, ngayden, trichyeu, nguoiky, soden, chucvu, nguoinhap);
    }

    @Override
    public void onStop() {
        super.onStop();
        integerArrayList.clear();
    }

    @OnClick({R.id.btnNamLamViec, R.id.btnBack, R.id.vcldxl, R.id.rlgmldxl, R.id.lncldxl, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnNamLamViec:
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
            case R.id.btnBack:
                Objects.requireNonNull(getActivity()).onBackPressed();

                break;
        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        getPresenter().getallgiaymoicholanhdaoxuly(String.valueOf(integer), true, loaivanban, sokyhieu, donvi, ngayky, ngaynhap, ngayden, trichyeu, nguoiky, soden, chucvu, nguoinhap);
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public GiayMoiChoLanhDaoXuLyPresenter createPresenter() {
        return new GiayMoiChoLanhDaoXuLyPresenterImpl(this);
    }

    @Override
    public Context gContext() {
        return getActivity();
    }

    @Override
    public void onGetDataSuccess() {
        swipeLayout.setRefreshing(false);
        adapterGiayMoiChoLanhDaoXuLy.notifyDataSetChanged();
        getPresenter().countgiaymoicholanhdaoxuly(NamLamViec, loaivanban, sokyhieu, donvi, ngayky, ngaynhap, ngayden, trichyeu, nguoiky, soden, chucvu, nguoinhap);

    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {
        if (response.getData() == 0 || response.getMessage() == "Lỗi hệ thống") {
            recyclerview.setVisibility(View.GONE);
            Util.showMessenger("Không có văn bản nào", getActivity());
        } else {
            recyclerview.setVisibility(View.VISIBLE);
        }
        tvTongSoVanBan.setText(String.valueOf(response.getData()));
    }

    @Override
    public void onItemClickXemFile(GiayMoiChoLanhDaoXuLy giayMoiChoLanhDaoXuLy) {
        try {
            if (giayMoiChoLanhDaoXuLy.getTepDinhKems().size() == 0) {
                Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
            } else if (giayMoiChoLanhDaoXuLy.getTepDinhKems().size() == 1) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(giayMoiChoLanhDaoXuLy.getTepDinhKems().get(0).getDuongDan()));
                startActivity(browserIntent);
            } else {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(giayMoiChoLanhDaoXuLy.getTepDinhKems().get(giayMoiChoLanhDaoXuLy.getTepDinhKems().size() - 1).getDuongDan()));
                startActivity(browserIntent);
            }
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClickXuLy(GiayMoiChoLanhDaoXuLy giayMoiChoLanhDaoXuLy) {
        if (!click) {
            Intent i = new Intent(getContext(), NDVBGiayMoiChoLDXLActivity.class);
            i.putExtra("giayMoiChoLanhDao", giayMoiChoLanhDaoXuLy);
            startActivity(i);
            click = true;
        }

    }

    @Override
    public void onItemClickXemChiTiet(GiayMoiChoLanhDaoXuLy giayMoiChoLanhDaoXuLy) {
        if (!click) {
            Intent intent = new Intent(getActivity(), ThongTinGiayMoiDaXuLyActivity.class);
            intent.putExtra("idvb", giayMoiChoLanhDaoXuLy.getId());
            startActivity(intent);
            click = true;
        }

    }
}
