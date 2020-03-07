package com.vpdt.vpdt.ui.activity.VanBanDen;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DetailVanBanTheoLanhDao;
import com.vpdt.vpdt.presenter.ClickVanBanThongKeVBTheoLDCDPresenter;
import com.vpdt.vpdt.presenter.ClickVanBanThongKeVBTheoLDCDView;
import com.vpdt.vpdt.presenter.impl.ClickVanBanThongKeVBTheoLDCDPresenterImpl;
import com.vpdt.vpdt.ui.activity.XuLyGiayMoi.TTVBGiayMoiChoLDXLActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.TTVBDSVBQuaHanActivity;
import com.vpdt.vpdt.ui.adapter.AdapterVanBanThongkeTheoLanhDaoChiDao;
import com.vpdt.vpdt.util.EndlessRecyclerViewScrollListener;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClickVanBanThongKeVBTheoLDCDActivity extends BaseActivity<ClickVanBanThongKeVBTheoLDCDPresenter> implements ClickVanBanThongKeVBTheoLDCDView,
        AdapterVanBanThongkeTheoLanhDaoChiDao.OnItemClickListener {

    @BindView(R.id.rcvVanBan)
    RecyclerView rcvVanBan;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipe_layout;

    @BindView(R.id.btnBack)
    ImageView btnBack;
    boolean click = false;
    String NamLamViec;
    int idTenPhoGiamDoc;
    int idTenPhongBan;
    private EndlessRecyclerViewScrollListener scrollListener;
    AdapterVanBanThongkeTheoLanhDaoChiDao adapterVanBanThongkeTheoLanhDaoChiDao;

    @Override
    public int getContentViewId() {
        return R.layout.activity_click_van_ban_thong_ke_vbtheo_ldcd;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
        NamLamViec = PrefUtil.getString(this, Key.NAM_LAM_VIEC, "");
        getData(true);

        adapterVanBanThongkeTheoLanhDaoChiDao = new AdapterVanBanThongkeTheoLanhDaoChiDao(getPresenter().detailVanBanTheoLanhDaoArraylist(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvVanBan.setLayoutManager(layoutManager);
        rcvVanBan.setAdapter(adapterVanBanThongkeTheoLanhDaoChiDao);

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
        rcvVanBan.addOnScrollListener(scrollListener);
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess() {
        adapterVanBanThongkeTheoLanhDaoChiDao.notifyDataSetChanged();
        swipe_layout.setRefreshing(false);
    }

    @Override
    public ClickVanBanThongKeVBTheoLDCDPresenter createPresenter() {
        return new ClickVanBanThongKeVBTheoLDCDPresenterImpl(this);
    }

    void getData(boolean isRefresh) {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("dangXuLyDungHanPhoGiamDoc")) {
                idTenPhoGiamDoc = intent.getIntExtra("dangXuLyDungHanPhoGiamDoc", 0);
                idTenPhongBan = intent.getIntExtra("dangXuLyDungHanPhongBan", 0);
                getPresenter().getVB_TKVB_theoLD(NamLamViec, 1, 0, idTenPhoGiamDoc, idTenPhongBan, isRefresh);
            }


            if (intent.hasExtra("dangXuLyQuaHanPhoGiamDoc")) {
                idTenPhoGiamDoc = intent.getIntExtra("dangXuLyQuaHanPhoGiamDoc", 0);
                idTenPhongBan = intent.getIntExtra("dangXuLyQuaHanPhongBan", 0);
                getPresenter().getVB_TKVB_theoLD(NamLamViec, 0, 0, idTenPhoGiamDoc, idTenPhongBan, isRefresh);
            }

            if (intent.hasExtra("daXuLyQuaHanPhoGiamDoc")) {
                idTenPhoGiamDoc = intent.getIntExtra("daXuLyQuaHanPhoGiamDoc", 0);
                idTenPhongBan = intent.getIntExtra("daXuLyQuaHanPhongBan", 0);
                getPresenter().getVB_TKVB_theoLD(NamLamViec, 1, 1, idTenPhoGiamDoc, idTenPhongBan, isRefresh);

            }

            if (intent.hasExtra("daXuLyDungHanPhoGiamDoc")) {
                idTenPhoGiamDoc = intent.getIntExtra("daXuLyDungHanPhoGiamDoc", 0);
                idTenPhongBan = intent.getIntExtra("daXuLyDungHanPhongBan", 0);
                getPresenter().getVB_TKVB_theoLD(NamLamViec, 0, 1, idTenPhoGiamDoc, idTenPhongBan, isRefresh);
            }
        }
    }

    @Override
    public void onItemClickXemFile(DetailVanBanTheoLanhDao detailVanBanTheoLanhDao) {
    }

    @Override
    public void onItemClickXuLy(DetailVanBanTheoLanhDao detailVanBanTheoLanhDao) {

    }

    @Override
    public void onItemClickXemChiTiet(DetailVanBanTheoLanhDao detailVanBanTheoLanhDao) {
        if (!click) {
            if (detailVanBanTheoLanhDao.getTrichYeu().getIgiaymoi() == 1) {
                Intent intent = new Intent(this, TTVBGiayMoiChoLDXLActivity.class);
                intent.putExtra("ID_GIAYMOI_CHO_LANHDAO_XULY", detailVanBanTheoLanhDao.getMaVb());
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, TTVBDSVBQuaHanActivity.class);
                intent.putExtra("ID_VANBAN_QUAHAN", detailVanBanTheoLanhDao.getMaVb());
                startActivity(intent);
            }
            click = true;
        }
    }
}
