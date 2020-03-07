package com.vpdt.vpdt.ui.activity.VanBanDen;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DetailVanBanDenTongThe;
import com.vpdt.vpdt.presenter.ThongKeVanBanPresenter;
import com.vpdt.vpdt.presenter.ThongKeVanBanView;
import com.vpdt.vpdt.presenter.impl.ThongKeVanBanPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.TTVBDSVBQuaHanActivity;
import com.vpdt.vpdt.ui.adapter.AdapterDanhSachCongTacDang;
import com.vpdt.vpdt.util.EndlessRecyclerViewScrollListener;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThongKeVanBanActivity extends BaseActivity<ThongKeVanBanPresenter> implements ThongKeVanBanView,
        AdapterDanhSachCongTacDang.OnItemClickListener {

    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipe_layout;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    @BindView(R.id.btnBack)
    Button btnBack;
    @BindView(R.id.btnHome)
    Button btnHome;
    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;

    @BindView(R.id.tvTSVB)
    TextView tvTSVB;
    boolean click = false;
    AdapterDanhSachCongTacDang adapterDanhSachCongTacDang;

    String NamLamViec, tuNgay, denNgay;
    int id, tongSo;
    private EndlessRecyclerViewScrollListener scrollListener;

    @Override
    public int getContentViewId() {
        return R.layout.activity_thong_ke_van_ban;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        NamLamViec = PrefUtil.getString(this, Key.NAM_LAM_VIEC, "");
        tuNgay = PrefUtil.getString(this, Key.TU_NGAY, "");
        denNgay = PrefUtil.getString(this, Key.DEN_NGAY, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + "   ");
        adapterDanhSachCongTacDang = new AdapterDanhSachCongTacDang(this, getPresenter().detailVanBanDenTongTheArrayList(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterDanhSachCongTacDang);
        getData(true);
        swipe_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData(true);

            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getData(false);

            }
        };
        recyclerview.addOnScrollListener(scrollListener);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainActivity.getCallingIntent(ThongKeVanBanActivity.this));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess() {
        adapterDanhSachCongTacDang.notifyDataSetChanged();
        swipe_layout.setRefreshing(false);
    }


    @Override
    public ThongKeVanBanPresenter createPresenter() {
        return new ThongKeVanBanPresenterImpl(this);
    }
    void getData(boolean isRefresh) {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("SoViecDuocGiao")) {
                id = intent.getIntExtra("SoViecDuocGiao", 0);
                tongSo = intent.getIntExtra("SoViecDuocGiaoTong", 0);
                getPresenter().getVB_thongKetheoPhong(NamLamViec, id, 0, String.valueOf(0), 0, 0, tuNgay, denNgay, isRefresh);
                tvTSVB.setText(String.valueOf(tongSo));
            }

            if (intent.hasExtra("TongSoViecDaGiaiQuyet")) {
                id = intent.getIntExtra("TongSoViecDaGiaiQuyet", 0);
                tongSo = intent.getIntExtra("TongSoViecDaGiaiQuyetTong", 0);
                getPresenter().getVB_thongKetheoPhong(NamLamViec, id, 0, String.valueOf(0), 0, 3, tuNgay, denNgay, isRefresh);
                tvTSVB.setText(String.valueOf(tongSo));
            }

            if (intent.hasExtra("DungHanDaGiaiQuyet")) {
                id = intent.getIntExtra("DungHanDaGiaiQuyet", 0);
                tongSo = intent.getIntExtra("DungHanDaGiaiQuyet1", 0);
                getPresenter().getVB_thongKetheoPhong(NamLamViec, id, 0, String.valueOf(0), 0, 1, tuNgay, denNgay, isRefresh);
                tvTSVB.setText(String.valueOf(tongSo));
            }

            if (intent.hasExtra("QuaHanDaGiaiQuyet")) {
                id = intent.getIntExtra("QuaHanDaGiaiQuyet", 0);
                tongSo = intent.getIntExtra("QuaHanDaGiaiQuyet1", 0);
                getPresenter().getVB_thongKetheoPhong(NamLamViec, id, 0, String.valueOf(0), 0, 2, tuNgay, denNgay, isRefresh);
                tvTSVB.setText(String.valueOf(tongSo));
            }

            if (intent.hasExtra("CoSangTao")) {
                id = intent.getIntExtra("CoSangTao", 0);
                tongSo = intent.getIntExtra("CoSangTao1", 0);
                tvTSVB.setText(String.valueOf(tongSo));
                getPresenter().getVB_thongKetheoPhong(NamLamViec, id, 1, String.valueOf(0), 0, 0, tuNgay, denNgay, isRefresh);
            }

            if (intent.hasExtra("TongSoViecChuaGiaiQuyet")) {
                id = intent.getIntExtra("TongSoViecChuaGiaiQuyet", 0);
                tongSo = intent.getIntExtra("TongSoViecChuaGiaiQuyet1", 0);
                tvTSVB.setText(String.valueOf(tongSo));
                getPresenter().getVB_thongKetheoPhong(NamLamViec, id, 0, String.valueOf(0), 3, 0, tuNgay, denNgay, isRefresh);
            }

            if (intent.hasExtra("DungHanChuaGiaiQuyet")) {
                id = intent.getIntExtra("DungHanChuaGiaiQuyet", 0);
                tongSo = intent.getIntExtra("DungHanChuaGiaiQuyet1", 0);
                tvTSVB.setText(String.valueOf(tongSo));
                getPresenter().getVB_thongKetheoPhong(NamLamViec, id, 0, String.valueOf(0), 1, 0, tuNgay, denNgay, isRefresh);
            }

            if (intent.hasExtra("QuaHanChuaGiaiQuyet")) {
                id = intent.getIntExtra("QuaHanChuaGiaiQuyet", 0);
                tongSo = intent.getIntExtra("QuaHanChuaGiaiQuyet", 0);
                tvTSVB.setText(String.valueOf(tongSo));
                getPresenter().getVB_thongKetheoPhong(NamLamViec, id, 0, String.valueOf(0), 2, 0, tuNgay, denNgay, isRefresh);
            }
        }
    }

    @Override
    public void onItemClickXemFile(DetailVanBanDenTongThe detailVanBanDenTongThe) {

    }

    @Override
    public void onItemClickXuLy(DetailVanBanDenTongThe detailVanBanDenTongThe) {

    }

    @Override
    public void onItemClickXemChiTiet(DetailVanBanDenTongThe detailVanBanDenTongThe) {
        if (!click) {
            Intent intent = new Intent(this, TTVBDSVBQuaHanActivity.class);
            intent.putExtra("ID_VANBAN_QUAHAN", detailVanBanDenTongThe.getPKIMaVBDen());
            startActivity(intent);
            click = true;
        }
    }
}
