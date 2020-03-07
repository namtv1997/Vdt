package com.vpdt.vpdt.ui.activity.XuLyVanBan;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DeXuatCongViecPhoiHopChoDuyet;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.presenter.NDVBCongViecPhoiHopChoXuLyPresenter;
import com.vpdt.vpdt.presenter.NDVBCongViecPhoiHopChoXuLyView;
import com.vpdt.vpdt.presenter.impl.NDVBCongViecPhoiHopChoXuLyPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterTenChuyenVien;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBCongViecPhoiHopChoXuLyActivity extends BaseActivity<NDVBCongViecPhoiHopChoXuLyPresenter> implements NDVBCongViecPhoiHopChoXuLyView,
        AdapterTenChuyenVien.OnItemClickListenerChuyenVien {

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
    @BindView(R.id.tvChonPhoPhong)
    TextView tvChonPhoPhong;
    @BindView(R.id.rlText)
    RelativeLayout rlText;

    @BindView(R.id.edtYKien)
    EditText edtYKien;

    @BindView(R.id.lnTraLaiDongY)
    LinearLayout lnTraLaiDongY;

    @BindView(R.id.btnGuiDi)
    Button btnGuiDi;
    @BindView(R.id.btnDongY)
    Button btnDongY;
    @BindView(R.id.btnTraLai)
    Button btnTraLai;
    int idvb, idPhongPhoiHop, IdCBGiaQuyet;
    String urlFileYeuCau, urlFileTraLoi;
    boolean click = false;
    RecyclerView rcTenChuyenVien;
    android.support.v7.app.AlertDialog dialog;
    AdapterTenChuyenVien adapterTenChuyenVien;
    int CH_TL, level;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbcong_viec_phoi_hop_cho_xu_ly;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        getPresenter().getAllCanBoPhong();
        DeXuatCongViecPhoiHopChoDuyet deXuatCongViecPhoiHopChoDuyet = getIntent().getParcelableExtra("deXuatCongViecPhoiHopChoDuyet");
        if (deXuatCongViecPhoiHopChoDuyet != null) {
            idvb = deXuatCongViecPhoiHopChoDuyet.getIdVB();
            level = PrefUtil.getInt(this, Key.LEVEL, 0);
            CH_TL = deXuatCongViecPhoiHopChoDuyet.getType();
            idPhongPhoiHop = deXuatCongViecPhoiHopChoDuyet.getIdPhongPhoiHop();
            urlFileYeuCau = deXuatCongViecPhoiHopChoDuyet.getUrlFileYeuCau();
            urlFileTraLoi = deXuatCongViecPhoiHopChoDuyet.getUrlFileTraLoi();
            tvNoiDung.setText("Nội dung: " + deXuatCongViecPhoiHopChoDuyet.getNoiDung());
            edtYKien.setText(String.valueOf(deXuatCongViecPhoiHopChoDuyet.getNoiDung()));
            tvTrichYeu.setText(String.valueOf(deXuatCongViecPhoiHopChoDuyet.getMoTa()));
            String shortDate = deXuatCongViecPhoiHopChoDuyet.getHanVanBan();
            tvNgay.setText(shortDate.substring(0, 5));
            tvSoDen.setText(String.valueOf(deXuatCongViecPhoiHopChoDuyet.getSoDen()));
            tvNguoiChuyen.setText(String.valueOf(deXuatCongViecPhoiHopChoDuyet.getNguoiChuyen()));
            tvHanVanBan.setText(String.valueOf(deXuatCongViecPhoiHopChoDuyet.getHanVanBan()));
            tvThoiGian.setText(String.valueOf(deXuatCongViecPhoiHopChoDuyet.getThoiGianChuyen()));
            if (deXuatCongViecPhoiHopChoDuyet.getType() == 2) {
                btnTraLai.setVisibility(View.VISIBLE);
            } else if (deXuatCongViecPhoiHopChoDuyet.getType() == 1) {
                btnGuiDi.setVisibility(View.VISIBLE);
                rlText.setVisibility(View.VISIBLE);
            } else {
                btnTraLai.setVisibility(View.VISIBLE);
                btnDongY.setVisibility(View.VISIBLE);
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
                            Toast.makeText(NDVBCongViecPhoiHopChoXuLyActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else if (!deXuatCongViecPhoiHopChoDuyet.getUrlFileYeuCau().isEmpty()) {
                tvFileDinhKem1.setText("Xem file Yêu cầu");
                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(deXuatCongViecPhoiHopChoDuyet.getUrlFileYeuCau()));
                    startActivity(browserIntent);
                } catch (Exception e) {
                    Toast.makeText(NDVBCongViecPhoiHopChoXuLyActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                }
            }

            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(deXuatCongViecPhoiHopChoDuyet.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBCongViecPhoiHopChoXuLyActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
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
            R.id.tvXemChiTietNDVBDSVBDenChoLDXL, R.id.tvChonPhoPhong, R.id.lnNoiDungVB, R.id.btnGuiDi,
            R.id.btnTraLai, R.id.btnDongY})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btnBack:
                finish();
                break;

            case R.id.lnNoiDungVB:
                closeKeyboard();
                break;

            case R.id.tvChonPhoPhong:
                android.support.v7.app.AlertDialog.Builder builderChuyenVien = new android.support.v7.app.AlertDialog.Builder(this);
                LayoutInflater inflaterChuyenVien = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewChuyenVien = inflaterChuyenVien.inflate(R.layout.dialog_ten_chuyen_vien, null);
                builderChuyenVien.setView(viewChuyenVien);
                dialog = builderChuyenVien.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManagerChuyenVien = new LinearLayoutManager(getApplicationContext());
                layoutManagerChuyenVien.setOrientation(LinearLayoutManager.VERTICAL);

                rcTenChuyenVien = viewChuyenVien.findViewById(R.id.rcTenGiamDoc);
                rcTenChuyenVien.setLayoutManager(layoutManagerChuyenVien);
                rcTenChuyenVien.setAdapter(adapterTenChuyenVien);
                adapterTenChuyenVien.notifyDataSetChanged();

                dialog.show();
                TextView tvChonChuyenVien = viewChuyenVien.findViewById(R.id.tvChonChuyenVien);
                tvChonChuyenVien.setText("-- Chọn cán bộ giải quyết --");
                tvChonChuyenVien.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvChonPhoPhong.setText("");
                        dialog.dismiss();
                    }
                });
                break;

            case R.id.tvXemChiTietNDVBDSVBDenChoLDXL:
                if (!click) {
                    Intent intent = new Intent(this, TTVBCongViecPhoiHopChoXuLyActivity.class);
                    intent.putExtra("ID_VANBAN_CONGVIECPHOIHOPCHOXULY", idvb);
                    startActivity(intent);
                    click = true;
                }

                break;

            case R.id.btnGuiDi:
                getPresenter().guiLenCVPhoiHopChoXuLy(idvb, idPhongPhoiHop, IdCBGiaQuyet, edtYKien.getText().toString(), urlFileYeuCau);
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
                        if (CH_TL == 1) {
                            getPresenter().traLaiCVPhoiHopChoXuLy(idvb, idPhongPhoiHop, edtYKien.getText().toString(), urlFileYeuCau);
                        } else {
                            if (level == 10 || level == 11) {
                                getPresenter().traLaiDeXuatPhoiHopTPCC(PrefUtil.getString(NDVBCongViecPhoiHopChoXuLyActivity.this, Key.NAM_LAM_VIEC, ""),
                                        idvb, idPhongPhoiHop, edtYKien.getText().toString(), urlFileYeuCau);
                            } else {
                                getPresenter().traLaiCVPhoiHopChoXuLy(idvb, idPhongPhoiHop, edtYKien.getText().toString(), urlFileYeuCau);
                            }
                        }
                    }
                });
                AlertDialog alertDialog1 = builder1.create();
                alertDialog1.show();
                break;
            case R.id.btnDongY:
                getPresenter().dongYCVPhoiHopChoXuLy(idvb, idPhongPhoiHop, edtYKien.getText().toString(), urlFileYeuCau, urlFileTraLoi);
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
    public void onGetNguoiKySuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterTenChuyenVien = new AdapterTenChuyenVien(giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void guiLenCVPhoiHopChoXuLy() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void dongYCVPhoiHopChoXuLy() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void traLaiCVPhoiHopChoXuLy() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NDVBCongViecPhoiHopChoXuLyPresenter createPresenter() {
        return new NDVBCongViecPhoiHopChoXuLyPresenterImpl(this);
    }

    @Override
    public void onItemClickChuyenVien(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        IdCBGiaQuyet = giamdocVaPhoGiamdoc.getId();
        tvChonPhoPhong.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        dialog.dismiss();
    }
}
