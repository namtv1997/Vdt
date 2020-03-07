package com.vpdt.vpdt.ui.activity.XuLyGiayMoi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DetailGiayMoi;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetGiayMoi;
import com.vpdt.vpdt.presenter.NDVBBaoCaoKetQuaCuocHopView;
import com.vpdt.vpdt.presenter.NDVBBaoCaoKetQuaCuocHop_Presenter;
import com.vpdt.vpdt.presenter.impl.NDVB_BaoCaoKetQuaCuocHopPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuXuLyGiayMoi;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBBaoCaoKetQuaCuocHopDaGuiDiActivity extends BaseActivity<NDVBBaoCaoKetQuaCuocHop_Presenter> implements NDVBBaoCaoKetQuaCuocHopView {

    @BindView(R.id.tvSKH)
    TextView skh;
    @BindView(R.id.tvNoiGui)
    TextView noigui;
    @BindView(R.id.tvNgay)
    TextView ngay;
    @BindView(R.id.tvSoDen)
    TextView soden;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvLoaiVanban)
    TextView tvLoaiVanban;
    @BindView(R.id.tvXemChiTiet)
    TextView tvXemChiTiet;
    @BindView(R.id.tvDiaDiem)
    TextView tvDiaDiem;
    boolean click = false;
    int id;
    AdapterTrinhTuXuLyGiayMoi adapterTrinhTuXuLyDonThu;
    @BindView(R.id.rvTrinhTuXuLy)
    RecyclerView rcvTTXL;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbbao_cao_ket_qua_cuoc_hop_da_gui_di;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("ID_VANBANBCKQCHDAGUIDI")) {
                id = intent.getIntExtra("ID_VANBANBCKQCHDAGUIDI", 0);
                soden.setText(getIntent().getStringExtra("SD"));
                skh.setText(getIntent().getStringExtra("SKH"));
                ngay.setText(getIntent().getStringExtra("NN"));
                noigui.setText(getIntent().getStringExtra("NG"));
                tvTrichYeu.setText(getIntent().getStringExtra("MT"));
                getPresenter().getgiaymoibyid(id);
            }
        }

    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess(DetailGiayMoi detailGiayMoi) {
        recyclerTrinhTuXuLy((ArrayList<TrinhTuGiaiQuyetGiayMoi>) detailGiayMoi.getTrinhTuGiaiQuyets());
        skh.setText(String.valueOf(detailGiayMoi.getSoKyhieu()));
        noigui.setText(String.valueOf(detailGiayMoi.getNoiGuiDen()));
        tvLoaiVanban.setText(String.valueOf(detailGiayMoi.getLoaiVanban()));
        tvDiaDiem.setText(String.valueOf("Vào hồi "
                + detailGiayMoi.getGiayMoiGio() + " ngày "
                + detailGiayMoi.getGiayMoiNgay() + ", tại "
                + detailGiayMoi.getGiayDiaDiem()));
    }

    @Override
    public void onGetNguoiKySuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {

    }

    @Override
    public void duyettuchoibaocaokequacuochopSuccess() {

    }

    @Override
    public void chuyenTiepKeQuaBaoCaoCuocHopSuccess() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack, R.id.tvXemChiTiet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(NDVBBaoCaoKetQuaCuocHopDaGuiDiActivity.this, TTVBBaoCaoCuocHopChoPheDuyetActivity.class);
                    intent.putExtra("idvb", id);
                    startActivity(intent);
                    click = true;
                }

                break;
        }
    }

    void recyclerTrinhTuXuLy(ArrayList<TrinhTuGiaiQuyetGiayMoi> trinhTuGiaiQuyetArrayList) {
        adapterTrinhTuXuLyDonThu = new AdapterTrinhTuXuLyGiayMoi(this, trinhTuGiaiQuyetArrayList);
        LinearLayoutManager layoutManagerTrinhTuXuLy = new LinearLayoutManager(this);
        layoutManagerTrinhTuXuLy.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTXL.setLayoutManager(layoutManagerTrinhTuXuLy);
        rcvTTXL.setAdapter(adapterTrinhTuXuLyDonThu);
        adapterTrinhTuXuLyDonThu.notifyDataSetChanged();
    }

    @Override
    public NDVBBaoCaoKetQuaCuocHop_Presenter createPresenter() {
        return new NDVB_BaoCaoKetQuaCuocHopPresenterImpl(this);
    }
}
