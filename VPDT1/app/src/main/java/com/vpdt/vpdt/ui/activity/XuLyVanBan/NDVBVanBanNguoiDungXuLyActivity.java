package com.vpdt.vpdt.ui.activity.XuLyVanBan;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.VanBanNguoiDungXuLy;
import com.vpdt.vpdt.presenter.NDVBVanBanNguoiDungXuLyPresenter;
import com.vpdt.vpdt.presenter.NDVBVanBanNguoiDungXuLyView;
import com.vpdt.vpdt.presenter.impl.NDVBVanBanNguoiDungXuLyPresenterImpl;
import com.vpdt.vpdt.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBVanBanNguoiDungXuLyActivity extends BaseActivity<NDVBVanBanNguoiDungXuLyPresenter> implements NDVBVanBanNguoiDungXuLyView {

    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvNoiGui)
    TextView tvNoiGui;
    @BindView(R.id.tvLoaiVanBan)
    TextView tvLoaiVanBan;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvChuTri)
    TextView tvChuTri;
    @BindView(R.id.tvNgayGio)
    TextView tvNgayGio;
    @BindView(R.id.tvNguoiNhap)
    TextView tvNguoiNhap;
    @BindView(R.id.tvPhongChuTri)
    TextView tvPhongChuTri;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;
    @BindView(R.id.tvXemChiTietNDVBDSVBDenChoLDXL)
    TextView tvXemChiTietNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvSoTrang)
    TextView tvSoTrang;
    @BindView(R.id.tvHanNhap)
    TextView tvHanNhap;
    @BindView(R.id.tvKetQuaThucHien)
    TextView tvKetQuaThucHien;

    @BindView(R.id.btnTraLai)
    Button btnTraLai;
    int idvb;
    boolean click = false;

    EditText edtNoiDungTuChoi;
    AlertDialog dialog;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbvan_ban_nguoi_dung_xu_ly;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        VanBanNguoiDungXuLy vanBanNguoiDungXuLy = getIntent().getParcelableExtra("vanBanNguoiDungXuLy");
        if (vanBanNguoiDungXuLy != null) {
            idvb = vanBanNguoiDungXuLy.getId();
            tvNgay.setText(String.valueOf(vanBanNguoiDungXuLy.getNgayNhap()));
            tvSKH.setText(String.valueOf(vanBanNguoiDungXuLy.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(vanBanNguoiDungXuLy.getSoDen()));
            tvNoiGui.setText(String.valueOf(vanBanNguoiDungXuLy.getNoiGui()));
            tvLoaiVanBan.setText(String.valueOf(vanBanNguoiDungXuLy.getLoaiVanBan()));
            tvNguoiNhap.setText(String.valueOf(vanBanNguoiDungXuLy.getNguoiNhap()));
            tvSoTrang.setText(String.valueOf(vanBanNguoiDungXuLy.getSoTrang()));
            tvHanNhap.setText(String.valueOf(vanBanNguoiDungXuLy.getHanGiaiQuyet()));
            tvPhongChuTri.setText(String.valueOf(vanBanNguoiDungXuLy.getPhongChuTri()));
            tvTrichYeu.setText(vanBanNguoiDungXuLy.getMoTa() + "." + vanBanNguoiDungXuLy.getNoiDung());
            tvChuTri.setText(String.valueOf(vanBanNguoiDungXuLy.getChuTri()));
            if (vanBanNguoiDungXuLy.getAllowTraLai()) {
                btnTraLai.setVisibility(View.VISIBLE);
                tvKetQuaThucHien.setVisibility(View.VISIBLE);
            }
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanNguoiDungXuLy.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBVanBanNguoiDungXuLyActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            if (!vanBanNguoiDungXuLy.getGiayMoiGio().isEmpty() && !vanBanNguoiDungXuLy.getGiayMoiNgay().isEmpty() && !vanBanNguoiDungXuLy.getGiayMoiDiaDiem().isEmpty()) {
                tvNgayGio.setText("( Vào hồi " + vanBanNguoiDungXuLy.getGiayMoiGio() + " ngày " + vanBanNguoiDungXuLy.getGiayMoiNgay() + ", tại" + vanBanNguoiDungXuLy.getGiayMoiDiaDiem() + ")");
                tvXemChiTietNDVBDSVBDenChoLDXL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!click) {
                            Intent intent = new Intent(NDVBVanBanNguoiDungXuLyActivity.this, TTVBSoLuongVanBanGiaoPhongChuTriActivity.class);
                            intent.putExtra("idvb", idvb);
                            startActivity(intent);
                            click = true;
                        }

                    }
                });
            } else {
                tvXemChiTietNDVBDSVBDenChoLDXL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!click) {
                            Intent intent = new Intent(NDVBVanBanNguoiDungXuLyActivity.this, TTVBSoLuongVanBanGiaoPhongChuTri1Activity.class);
                            intent.putExtra("idvb", idvb);
                            startActivity(intent);
                            click = true;
                        }

                    }
                });
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.imvBack, R.id.btnTraLai, R.id.lnNoiDungVB})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.imvBack:
                finish();
                break;

            case R.id.lnNoiDungVB:
                closeKeyboard();
                break;

            case R.id.btnTraLai:
                AlertDialog.Builder buildertuchoi = new AlertDialog.Builder(this);
                LayoutInflater inflatertuchoi = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewtuchoi = inflatertuchoi.inflate(R.layout.dialog_tuchoi_ketquahoanthanh_cho_phe_duyet, null);
                buildertuchoi.setView(viewtuchoi);
                dialog = buildertuchoi.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                edtNoiDungTuChoi = viewtuchoi.findViewById(R.id.edtNoiDungTuChoi);
                TextView tvTieuDe = viewtuchoi.findViewById(R.id.tvTieuDe);
                TextView tvTieuDeNoiDung = viewtuchoi.findViewById(R.id.tvTieuDeNoiDung);
                tvTieuDe.setText("Trả lại kết quả để phòng thực hiện lại");
                tvTieuDeNoiDung.setText("Lý do trả lại");
                Button btnDong1 = viewtuchoi.findViewById(R.id.btnDong);
                Button btnChuyenChanhVanBan = viewtuchoi.findViewById(R.id.btnChuyenChanhVanBan);
                btnChuyenChanhVanBan.setText("Trả lại");
                btnDong1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btnChuyenChanhVanBan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().traLaiVBNguoiDungXuLy(idvb, edtNoiDungTuChoi.getText().toString(), tvHanNhap.getText().toString());
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
    public void traLaiVBNguoiDungXuLySuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
        finish();
    }

    @Override
    public NDVBVanBanNguoiDungXuLyPresenter createPresenter() {
        return new NDVBVanBanNguoiDungXuLyPresenterImpl(this);
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
