package com.vpdt.vpdt.ui.activity.XuLyVanBan;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DeXuatCongViecPhoiHopChoDuyet;
import com.vpdt.vpdt.presenter.NDVBDeXuatCongViecPhoiHopChoDuyetPresenter;
import com.vpdt.vpdt.presenter.NDVBDeXuatCongViecPhoiHopChoDuyetView;
import com.vpdt.vpdt.presenter.impl.NDVBDeXuatCongViecPhoiHopChoDuyetPresenterImpl;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDeXuatCongViecPhoiHopChoDuyetCCActivity extends BaseActivity<NDVBDeXuatCongViecPhoiHopChoDuyetPresenter> implements NDVBDeXuatCongViecPhoiHopChoDuyetView {

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
    @BindView(R.id.tvNoiDung)
    TextView tvNoiDung;
    @BindView(R.id.tvThoiGian)
    TextView tvThoiGian;

    @BindView(R.id.edtYKien)
    EditText edtYKien;

    int idvb, idPhongPhoiHop;
    String urlFileYeuCau;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbde_xuat_cong_viec_phoi_hop_cho_duyet_cc;
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
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(deXuatCongViecPhoiHopChoDuyet.getUrlFileYeuCau()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBDeXuatCongViecPhoiHopChoDuyetCCActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
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

    @OnClick({R.id.btnBack, R.id.tvXemChiTietNDVBDSVBDenChoLDXL, R.id.btnTraLaiGuiDi, R.id.lnNoiDungVB, R.id.btnGuiDi})
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
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
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
                        getPresenter().traLaiDeXuatCVTPCC(PrefUtil.getString(NDVBDeXuatCongViecPhoiHopChoDuyetCCActivity.this, Key.NAM_LAM_VIEC, ""),
                                idvb, idPhongPhoiHop, edtYKien.getText().toString(), urlFileYeuCau);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                break;
            case R.id.btnGuiDi:
                getPresenter().guiLenDeXuatCVTPCC(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""),
                        idvb, idPhongPhoiHop, edtYKien.getText().toString(), urlFileYeuCau);
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
        Toast.makeText(this, "Đã gửi lên", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void dongYDeXuatCV() {
    }

    @Override
    public void traLaiDeXuatCV() {
        Toast.makeText(this, "Đã trả lại", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NDVBDeXuatCongViecPhoiHopChoDuyetPresenter createPresenter() {
        return new NDVBDeXuatCongViecPhoiHopChoDuyetPresenterImpl(this);
    }
}