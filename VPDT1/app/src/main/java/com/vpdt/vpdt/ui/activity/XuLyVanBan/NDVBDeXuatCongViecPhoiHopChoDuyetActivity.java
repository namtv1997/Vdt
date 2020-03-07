package com.vpdt.vpdt.ui.activity.XuLyVanBan;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DeXuatCongViecPhoiHopChoDuyet;
import com.vpdt.vpdt.presenter.NDVBDeXuatCongViecPhoiHopChoDuyetPresenter;
import com.vpdt.vpdt.presenter.NDVBDeXuatCongViecPhoiHopChoDuyetView;
import com.vpdt.vpdt.presenter.impl.NDVBDeXuatCongViecPhoiHopChoDuyetPresenterImpl;
import com.vpdt.vpdt.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDeXuatCongViecPhoiHopChoDuyetActivity extends BaseActivity<NDVBDeXuatCongViecPhoiHopChoDuyetPresenter> implements NDVBDeXuatCongViecPhoiHopChoDuyetView {

    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvNguoiChuyen)
    TextView tvNguoiChuyen;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvHanVanBan)
    TextView tvHanVanBan;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;
    @BindView(R.id.tvFileDinhKem1)
    TextView tvFileDinhKem1;
    @BindView(R.id.tvNoiDung)
    TextView tvNoiDung;
    @BindView(R.id.tvThoiGian)
    TextView tvThoiGian;

    @BindView(R.id.edtYKien)
    EditText edtYKien;

    @BindView(R.id.lnTraLaiDongY)
    LinearLayout lnTraLaiDongY;
    @BindView(R.id.lnTraLaiGuiDi)
    LinearLayout lnTraLaiGuiDi;
    int idvb, idPhongPhoiHop;
    String urlFileYeuCau;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbde_xuat_cong_viec_phoi_hop_cho_duyet;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        DeXuatCongViecPhoiHopChoDuyet deXuatCongViecPhoiHopChoDuyet = getIntent().getParcelableExtra("deXuatCongViecPhoiHopChoDuyet");
        if (deXuatCongViecPhoiHopChoDuyet != null) {
            idvb = deXuatCongViecPhoiHopChoDuyet.getIdVB();
            idPhongPhoiHop = deXuatCongViecPhoiHopChoDuyet.getIdPhongPhoiHop();
            urlFileYeuCau = deXuatCongViecPhoiHopChoDuyet.getUrlFileYeuCau();
            tvNoiDung.setText("Nội dung :" + deXuatCongViecPhoiHopChoDuyet.getNoiDung());
            edtYKien.setText(String.valueOf(deXuatCongViecPhoiHopChoDuyet.getNoiDung()));
            tvTrichYeu.setText(String.valueOf(deXuatCongViecPhoiHopChoDuyet.getMoTa()));
            String shortDate = deXuatCongViecPhoiHopChoDuyet.getHanVanBan();
            tvNgay.setText(shortDate.substring(0, 5));
            tvSoDen.setText(String.valueOf(deXuatCongViecPhoiHopChoDuyet.getSoDen()));
            tvNguoiChuyen.setText(String.valueOf(deXuatCongViecPhoiHopChoDuyet.getNguoiChuyen()));
            tvHanVanBan.setText(String.valueOf(deXuatCongViecPhoiHopChoDuyet.getHanVanBan()));
            tvThoiGian.setText(String.valueOf(deXuatCongViecPhoiHopChoDuyet.getThoiGianChuyen()));
            if (deXuatCongViecPhoiHopChoDuyet.getType() == 2) {
                lnTraLaiDongY.setVisibility(View.VISIBLE);
            } else {
                lnTraLaiGuiDi.setVisibility(View.VISIBLE);
            }
            if (!deXuatCongViecPhoiHopChoDuyet.getUrlFileTraLoi().isEmpty() || !deXuatCongViecPhoiHopChoDuyet.getUrlFileYeuCau().isEmpty()) {
                tvFileDinhKem1.setVisibility(View.VISIBLE);
            }
            if (!deXuatCongViecPhoiHopChoDuyet.getUrlFileTraLoi().isEmpty()) {
                tvFileDinhKem1.setText("Xem file Trả lời");
                tvFileDinhKem1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(deXuatCongViecPhoiHopChoDuyet.getUrlFileTraLoi()));
                            startActivity(browserIntent);
                        } catch (Exception e) {
                            Toast.makeText(NDVBDeXuatCongViecPhoiHopChoDuyetActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else if (!deXuatCongViecPhoiHopChoDuyet.getUrlFileYeuCau().isEmpty()) {
                tvFileDinhKem1.setText("Xem file Yêu cầu");
                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(deXuatCongViecPhoiHopChoDuyet.getUrlFileYeuCau()));
                    startActivity(browserIntent);
                } catch (Exception e) {
                    Toast.makeText(NDVBDeXuatCongViecPhoiHopChoDuyetActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                }
            }
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(deXuatCongViecPhoiHopChoDuyet.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBDeXuatCongViecPhoiHopChoDuyetActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack,
            R.id.tvXemChiTietNDVBDSVBDenChoLDXL, R.id.btnTraLaiGuiDi, R.id.lnNoiDungVB, R.id.btnGuiDi,
            R.id.btnTraLai, R.id.btnDongY})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btnBack:
                finish();
                break;

            case R.id.lnNoiDungVB:
                closeKeyboard();
                break;

            case R.id.tvXemChiTietNDVBDSVBDenChoLDXL:
                if (!click) {
                    Intent intent = new Intent(this, TTVBDeXuatCongViecPhoiHopChoDuyetActivity.class);
                    intent.putExtra("ID_VANBANDEXUATCVPHCHODUYET", idvb);
                    startActivity(intent);
                    click = true;
                }

                break;

            case R.id.btnTraLaiGuiDi:
                AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn muốn trả lại ?");
                builder.setCancelable(false);
                builder.setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getPresenter().traLaiDeXuatCV(idvb, idPhongPhoiHop, edtYKien.getText().toString(), urlFileYeuCau);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                break;
            case R.id.btnGuiDi:
                getPresenter().guiLenDeXuatCV(idvb, idPhongPhoiHop, edtYKien.getText().toString(), urlFileYeuCau);
                break;
            case R.id.btnTraLai:
                android.app.AlertDialog.Builder builder1 = new android.app.AlertDialog.Builder(this);
                builder1.setTitle("Thông báo");
                builder1.setMessage("Bạn muốn trả lại ?");
                builder1.setCancelable(false);
                builder1.setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                    }
                });
                builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getPresenter().guiLenDeXuatCV(idvb, idPhongPhoiHop, edtYKien.getText().toString(), urlFileYeuCau);
                    }
                });
                AlertDialog alertDialog1 = builder1.create();
                alertDialog1.show();
                break;
            case R.id.btnDongY:
                getPresenter().dongYDeXuatCV(idvb, idPhongPhoiHop);
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
    public void guiLenDeXuatCV() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void dongYDeXuatCV() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void traLaiDeXuatCV() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NDVBDeXuatCongViecPhoiHopChoDuyetPresenter createPresenter() {
        return new NDVBDeXuatCongViecPhoiHopChoDuyetPresenterImpl(this);
    }
}
