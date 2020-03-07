package com.vpdt.vpdt.ui.activity.VanBanDen;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.ThongKeVanBan;
import com.vpdt.vpdt.presenter.ClickThongKeVBTheoLDChiDaoPresenter;
import com.vpdt.vpdt.presenter.ClickThongKeVBTheoLDChiDaoView;
import com.vpdt.vpdt.presenter.impl.ClickThongKeVBTheoLDChiDaoPresenterImpl;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClickThongKeVBTheoLDChiDaoActivity extends BaseActivity<ClickThongKeVBTheoLDChiDaoPresenter> implements ClickThongKeVBTheoLDChiDaoView {

    @BindView(R.id.tvTen)
    TextView tvTen;
    @BindView(R.id.tvTongDangXuLy)
    TextView tvTongDangXuLy;
    @BindView(R.id.tvDangXuLyDungHan)
    TextView tvDangXuLyDungHan;
    @BindView(R.id.tvDangXuLyQuaHan)
    TextView tvDangXuLyQuaHan;
    @BindView(R.id.tvTongDaXuLy)
    TextView tvTongDaXuLy;
    @BindView(R.id.tvDaXuLyDungHan)
    TextView tvDaXuLyDungHan;
    @BindView(R.id.tvDaXuLyQuaHan)
    TextView tvDaXuLyQuaHan;

    int idTenPhoGiamDoc;
    int idTenPhongBan;
    String NamLamViec;

    @Override
    public int getContentViewId() {
        return R.layout.activity_click_thong_ke_vbtheo_ldchi_dao;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        NamLamViec = PrefUtil.getString(this, Key.NAM_LAM_VIEC, "");
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("ThongKeLanhDaoChiDao")) {
                idTenPhoGiamDoc = intent.getIntExtra("ThongKeLanhDaoChiDao", 0);
                getPresenter().thongke_vbLDdetail(NamLamViec, idTenPhoGiamDoc, 0);
            }
            if (intent.hasExtra("ThongKeLanhDaoChiDaoTheoPhong")) {
                idTenPhongBan = intent.getIntExtra("ThongKeLanhDaoChiDaoTheoPhong", 0);
                getPresenter().thongke_vbLDdetail(NamLamViec, 0, idTenPhongBan);
            }
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void clickThongKeVBTheoLDChiDaoSuccess(ThongKeVanBan thongKeVanBan) {
        tvTen.setText(String.valueOf(thongKeVanBan.getTen()));
        tvTongDangXuLy.setText(String.valueOf(thongKeVanBan.getTongdangxuly()));
        tvDaXuLyDungHan.setText(String.valueOf(thongKeVanBan.getDemdaxulyDunghan()));
        tvDaXuLyQuaHan.setText(String.valueOf(thongKeVanBan.getDemdaxulyQuahan()));
        tvDangXuLyDungHan.setText(String.valueOf(thongKeVanBan.getDemxulyDunghan()));
        tvDangXuLyQuaHan.setText(String.valueOf(thongKeVanBan.getDemxulyQuahan()));
    }

    @OnClick({R.id.btnBack, R.id.rlDangXuLyDungHan,
            R.id.rlDangXuLyQuahan, R.id.rlDaXuLyQuahan,
            R.id.rlDaXuLyDunghan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.rlDangXuLyDungHan:
                Intent intent = new Intent(this, ClickVanBanThongKeVBTheoLDCDActivity.class);
                intent.putExtra("dangXuLyDungHanPhoGiamDoc", idTenPhoGiamDoc);
                intent.putExtra("dangXuLyDungHanPhongBan", idTenPhongBan);
                startActivity(intent);

                break;
            case R.id.rlDangXuLyQuahan:
                Intent intent1 = new Intent(this, ClickVanBanThongKeVBTheoLDCDActivity.class);
                intent1.putExtra("dangXuLyQuaHanPhoGiamDoc", idTenPhoGiamDoc);
                intent1.putExtra("dangXuLyQuaHanPhongBan", idTenPhongBan);
                startActivity(intent1);
                break;
            case R.id.rlDaXuLyQuahan:
                Intent intent2 = new Intent(this, ClickVanBanThongKeVBTheoLDCDActivity.class);
                intent2.putExtra("daXuLyQuaHanPhoGiamDoc", idTenPhoGiamDoc);
                intent2.putExtra("daXuLyQuaHanPhongBan", idTenPhongBan);
                startActivity(intent2);
                break;
            case R.id.rlDaXuLyDunghan:
                Intent intent3 = new Intent(this, ClickVanBanThongKeVBTheoLDCDActivity.class);
                intent3.putExtra("daXuLyDungHanPhoGiamDoc", idTenPhoGiamDoc);
                intent3.putExtra("daXuLyDungHanPhongBan", idTenPhongBan);
                startActivity(intent3);
                break;

        }
    }

    @Override
    public ClickThongKeVBTheoLDChiDaoPresenter createPresenter() {
        return new ClickThongKeVBTheoLDChiDaoPresenterImpl(this);
    }
}
