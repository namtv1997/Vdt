package com.vpdt.vpdt.ui.activity.XuLyVanBan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.NDVB_DonThu;
import com.vpdt.vpdt.model.TepDinhKem;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyet;
import com.vpdt.vpdt.presenter.NDVB_TongSoLuongDonThuView;
import com.vpdt.vpdt.presenter.NDVB_TongSoLuongDonThu_Presenter;
import com.vpdt.vpdt.presenter.impl.NDVB_TongSoLuongDonThuPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterFileDinhKemChoLanhDaoXuLy;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuXuLyDonThu;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBTongSoLuongDonThuActivity extends BaseActivity<NDVB_TongSoLuongDonThu_Presenter> implements NDVB_TongSoLuongDonThuView, AdapterFileDinhKemChoLanhDaoXuLy.OnItemClickListenerFileDinhKem {

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
    @BindView(R.id.tvLoaiVanBan)
    TextView tvLoaiVanBan;
    @BindView(R.id.tvXemChiTiet)
    TextView tvXemChiTiet;
    @BindView(R.id.tvNgayKy)
    TextView tvNgayKy;

    @BindView(R.id.rvFileDinhKem)
    RecyclerView rvFileDinhKem;

    int id;
    String status;
    AdapterTrinhTuXuLyDonThu adapterTrinhTuXuLyDonThu;
    private AdapterFileDinhKemChoLanhDaoXuLy adapterFileDinhKemChoLanhDaoXuLy;
    @BindView(R.id.rcvTTXL)
    RecyclerView rcvTTXL;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbtong_so_luong_don_thu;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("ID_VANBAN")) {
                id = intent.getIntExtra("ID_VANBAN", 0);
                status = intent.getStringExtra("STATUS");
                getPresenter().getbyiddonthukntc(id);

            }
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onGetDataSuccess(NDVB_DonThu ndvb_donThu) {
        recyclerviewFileDinhKem((ArrayList<TepDinhKem>) ndvb_donThu.getTepDinhKems());
        recyclerTrinhTuXuLy((ArrayList<TrinhTuGiaiQuyet>) ndvb_donThu.getTrinhTuGiaiQuyets());
        String shortdate = ndvb_donThu.getNgayNhan();
        ngay.setText(shortdate.substring(0, 5));
        soden.setText(String.valueOf(ndvb_donThu.getSoDen()));
        skh.setText(String.valueOf(ndvb_donThu.getSoKyHieu()));
        noigui.setText(String.valueOf(ndvb_donThu.getNoiGuiDen()));
        tvTrichYeu.setText(String.valueOf(ndvb_donThu.getTrichYeu()));
        tvLoaiVanBan.setText(ndvb_donThu.getLoaiVanBan());
        tvNgayKy.setText(ndvb_donThu.getNgayKy());
    }

    @Override
    public void onGetCongViecSuccess() {

    }

    @Override
    public void xoaKQPhongTLSuccess() {

    }

    @Override
    public NDVB_TongSoLuongDonThu_Presenter createPresenter() {
        return new NDVB_TongSoLuongDonThuPresenterImpl(this);
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
                    if (status.equals("Đã hoàn thành")) {
                        Intent intent = new Intent(NDVBTongSoLuongDonThuActivity.this, TTVBDeXuatCongViecPhoiHopChoDuyetActivity.class);
                        intent.putExtra("ID_VANBANDEXUATCVPHCHODUYET", id);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(NDVBTongSoLuongDonThuActivity.this, TTVBCongViecPhoiHopChoXuLyActivity.class);
                        intent.putExtra("ID_VANBAN_CONGVIECPHOIHOPCHOXULY", id);
                        startActivity(intent);
                    }
                    click = true;
                }
                break;
        }
    }

    void recyclerTrinhTuXuLy(ArrayList<TrinhTuGiaiQuyet> trinhTuGiaiQuyetArrayList) {
        adapterTrinhTuXuLyDonThu = new AdapterTrinhTuXuLyDonThu(this, trinhTuGiaiQuyetArrayList);
        LinearLayoutManager layoutManagerTrinhTuXuLy = new LinearLayoutManager(this);
        layoutManagerTrinhTuXuLy.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTXL.setLayoutManager(layoutManagerTrinhTuXuLy);
        rcvTTXL.setAdapter(adapterTrinhTuXuLyDonThu);
        adapterTrinhTuXuLyDonThu.notifyDataSetChanged();
    }

    @Override
    public void onItemClickFileDinhKem(TepDinhKem dinhKem) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dinhKem.getDuongDan()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    void recyclerviewFileDinhKem(ArrayList<TepDinhKem> tepDinhKems) {
        adapterFileDinhKemChoLanhDaoXuLy = new AdapterFileDinhKemChoLanhDaoXuLy(this, tepDinhKems, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvFileDinhKem.setLayoutManager(layoutManager);
        rvFileDinhKem.setAdapter(adapterFileDinhKemChoLanhDaoXuLy);
        adapterFileDinhKemChoLanhDaoXuLy.notifyDataSetChanged();
    }

}
