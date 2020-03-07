package com.vpdt.vpdt.ui.activity.QuanLyDauViec;


import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DauViecHoanThanhBiTraLai;
import com.vpdt.vpdt.presenter.NoiDungDauViecHoanThanhBiTraLaiPresenter;
import com.vpdt.vpdt.presenter.NoiDungDauViecHoanThanhBiTraLaiView;
import com.vpdt.vpdt.presenter.impl.NoiDungDauViecHoanThanhBiTraLaiPresenterImpl;
import com.vpdt.vpdt.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoiDungDauViecHoanThanhBiTraLaiActivity extends BaseActivity<NoiDungDauViecHoanThanhBiTraLaiPresenter> implements NoiDungDauViecHoanThanhBiTraLaiView {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvNguoiNhap)
    TextView tvNguoiNhap;
    @BindView(R.id.tvLanhDao)
    TextView tvLanhDao;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvHanVanBan)
    TextView tvHanVanBan;
    @BindView(R.id.tvPhongChuTri)
    TextView tvPhongChuTri;
    @BindView(R.id.tvPhongPhoiHop)
    TextView tvPhongPhoiHop;

    @BindView(R.id.edtYKien)
    EditText edtYKien;
    int id, idLanhDao;
    String hanVanBan;

    @Override
    public int getContentViewId() {
        return R.layout.activity_noi_dung_dau_viec_hoan_thanh_bi_tra_lai;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        DauViecHoanThanhBiTraLai dauViecHoanThanhBiTraLai = getIntent().getParcelableExtra("dauViecHoanThanhBiTraLai");
        if (dauViecHoanThanhBiTraLai != null) {
            tvTrichYeu.setText(String.valueOf(dauViecHoanThanhBiTraLai.getMoTa()));
            id = dauViecHoanThanhBiTraLai.getId();
            idLanhDao = dauViecHoanThanhBiTraLai.getIdLanhDao();
            hanVanBan = dauViecHoanThanhBiTraLai.getHanVanBan();
            String shortDate = dauViecHoanThanhBiTraLai.getNgayNhap();
            tvNgay.setText(shortDate.substring(0, 5));
            tvNguoiNhap.setText(String.valueOf(dauViecHoanThanhBiTraLai.getNguoiNhap()));
            tvLanhDao.setText(String.valueOf(dauViecHoanThanhBiTraLai.getLanhDao()));
            tvHanVanBan.setText(String.valueOf(dauViecHoanThanhBiTraLai.getHanVanBan()));
            tvPhongChuTri.setText(String.valueOf(dauViecHoanThanhBiTraLai.getPhongChuTri()));
            tvPhongPhoiHop.setText(String.valueOf(dauViecHoanThanhBiTraLai.getPhongPhoiHop()));
        }
    }

    @OnClick({R.id.btnBack, R.id.lnNoiDungVB,
            R.id.btnTraLai, R.id.btnDuyet})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btnBack:
                finish();
                break;

            case R.id.lnNoiDungVB:
                closeKeyboard();
                break;

            case R.id.btnTraLai:
                getPresenter().traLaiDauViecHoanThanhBiTraLai(id, edtYKien.getText().toString());
                break;
            case R.id.btnDuyet:
                getPresenter().duyetDauViecHoanThanhBiTraLai(id, idLanhDao, hanVanBan);
                break;
        }
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void duyetDauViecHoanThanhBiTraLai() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void traLaiDauViecHoanThanhBiTraLai() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NoiDungDauViecHoanThanhBiTraLaiPresenter createPresenter() {
        return new NoiDungDauViecHoanThanhBiTraLaiPresenterImpl(this);
    }
}
