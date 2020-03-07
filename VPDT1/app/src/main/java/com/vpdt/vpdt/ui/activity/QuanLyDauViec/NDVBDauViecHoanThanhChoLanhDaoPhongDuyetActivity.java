package com.vpdt.vpdt.ui.activity.QuanLyDauViec;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DauViecHoanThanhChoLanhDaoPhongDuyet;
import com.vpdt.vpdt.presenter.NDVBDauViecHoanThanhChoLanhDaoPhongDuyetPresenter;
import com.vpdt.vpdt.presenter.NDVBDauViecHoanThanhChoLanhDaoPhongDuyetView;
import com.vpdt.vpdt.presenter.impl.NDVBDauViecHoanThanhChoLanhDaoPhongDuyetPresenterImpl;
import com.vpdt.vpdt.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDauViecHoanThanhChoLanhDaoPhongDuyetActivity extends BaseActivity<NDVBDauViecHoanThanhChoLanhDaoPhongDuyetPresenter> implements NDVBDauViecHoanThanhChoLanhDaoPhongDuyetView {

    @BindView(R.id.tvTieuDe)
    TextView tvTieuDe;
    @BindView(R.id.tvThoiGian)
    TextView tvThoiGian;
    @BindView(R.id.tvLoaiVanBan)
    TextView tvLoaiVanBan;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvXemFile)
    TextView tvXemFile;
    String urlFile;
    int id;
    EditText edtNoiDungTuChoi;
    AlertDialog dialog;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbdau_viec_hoan_thanh_cho_lanh_dao_phong_duyet;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        DauViecHoanThanhChoLanhDaoPhongDuyet dauViecHoanThanhChoLanhDaoPhongDuyet = getIntent().getParcelableExtra("dauViecHoanThanhChoLanhDaoPhongDuyet");
        if (dauViecHoanThanhChoLanhDaoPhongDuyet != null) {
            tvTieuDe.setText(String.valueOf(dauViecHoanThanhChoLanhDaoPhongDuyet.getTieuDe()));
            tvThoiGian.setText(String.valueOf(dauViecHoanThanhChoLanhDaoPhongDuyet.getThoiGian()));
            tvLoaiVanBan.setText(String.valueOf(dauViecHoanThanhChoLanhDaoPhongDuyet.getLoaiVanBan()));
            tvTrichYeu.setText(String.valueOf(dauViecHoanThanhChoLanhDaoPhongDuyet.getMoTa()));
            urlFile = dauViecHoanThanhChoLanhDaoPhongDuyet.getUrlFile();
            id = dauViecHoanThanhChoLanhDaoPhongDuyet.getId();

        }
    }

    @OnClick({R.id.btnTraLai, R.id.btnBack, R.id.btnDuyet, R.id.tvXemFile})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnDuyet:
                getPresenter().duyetDauViecHoanThanhChoLDDuyet(id);
                break;
            case R.id.tvXemFile:
                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlFile));
                    startActivity(browserIntent);
                } catch (Exception e) {
                    Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnBack:
                finish();

                break;
            case R.id.btnTraLai:
                AlertDialog.Builder buildertuchoi = new AlertDialog.Builder(this);
                LayoutInflater inflatertuchoi = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewtuchoi = inflatertuchoi.inflate(R.layout.dialog_lydo_tralai, null);
                buildertuchoi.setView(viewtuchoi);
                dialog = buildertuchoi.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                edtNoiDungTuChoi = viewtuchoi.findViewById(R.id.edtNoiDungTuChoi);
                Button btnDong1 = viewtuchoi.findViewById(R.id.btnDong);
                Button btnChuyenChanhVanBan = viewtuchoi.findViewById(R.id.btnChuyenChanhVanBan);
                btnDong1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btnChuyenChanhVanBan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().tuChoiDauViecHoanThanhChoLDDuyet(id, edtNoiDungTuChoi.getText().toString());
                    }
                });
                dialog.show();
                break;


        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void ontuChoiDauViecHoanThanhChoLDDuyetSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onduyetDauViecHoanThanhChoLDDuyetSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public NDVBDauViecHoanThanhChoLanhDaoPhongDuyetPresenter createPresenter() {
        return new NDVBDauViecHoanThanhChoLanhDaoPhongDuyetPresenterImpl(this);
    }
}
