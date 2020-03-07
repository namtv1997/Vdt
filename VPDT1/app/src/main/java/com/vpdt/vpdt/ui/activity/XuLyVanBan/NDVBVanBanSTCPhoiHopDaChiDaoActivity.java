package com.vpdt.vpdt.ui.activity.XuLyVanBan;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.PhongChuTriDaChiDao;
import com.vpdt.vpdt.presenter.NDVBVBSTCPhoiHopDaChiDaoPresenter;
import com.vpdt.vpdt.presenter.NDVBVBSTCPhoiHopDaChiDaoView;
import com.vpdt.vpdt.presenter.impl.NDVBVBSTCPhoiHopDaChiDaoPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterChonChuyenVienPhoiHop;
import com.vpdt.vpdt.ui.adapter.AdapterTenChuyenVien;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBVanBanSTCPhoiHopDaChiDaoActivity extends BaseActivity<NDVBVBSTCPhoiHopDaChiDaoPresenter> implements NDVBVBSTCPhoiHopDaChiDaoView,
        DatePickerDialog.OnDateSetListener, AdapterTenChuyenVien.OnItemClickListenerChuyenVien, AdapterChonChuyenVienPhoiHop.OnItemClickListenerChonChuyenVien {

    @BindView(R.id.tvSKH)
    TextView tvSKHNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvSoDen)
    TextView tvSoDenNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvNoigui)
    TextView tvNoiGuiNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvNgay)
    TextView tvNgayNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvTrichYeuNDVBDSVBDenChoLDXL)
    TextView tvTrichYeuNDVBDSVBDenChoLDXL;
    @BindView(R.id.spnPhongNDVBDSVBDenChoLDXL)
    TextView spnPhongNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvNgayThangNamNDVBDSVBDenChoLDXL)
    TextView tvNgayThangNamNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;

    @BindView(R.id.btnDeXuat)
    Button btnDeXuat;

    @BindView(R.id.tvChiDao1NDVBDSVBDenChoLDXL)
    EditText tvChiDao1NDVBDSVBDenChoLDXL;

    @BindView(R.id.cbVBQPPLNDVBDSVBDenChoLDXL)
    CheckBox cbVbQuanTrong;
    @BindView(R.id.cbVanBanLuu)
    CheckBox cbVanBanLuu;
    boolean click = false;

    @BindView(R.id.lnNoiDungVB)
    LinearLayout lnNoiDungVB;

    RecyclerView rcTenPhoPhong;
    RecyclerView rcTenChuyenVien;

    AlertDialog dialog;
    AdapterTenChuyenVien adapterTenChuyenVien;
    AdapterChonChuyenVienPhoiHop adapterChonChuyenVienPhoiHop;
    ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdocArrayList = new ArrayList<>();
    int idvb, idChuyenVien, idPhoPhong;
    String idPhoPhongPhoiHop = "";
    String idChuyenVienPhoiHops = "";
    String vanbandauraTruongPhong = "";

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbvan_ban_stcphoi_hop_da_chi_dao;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        getPresenter().getAllChuyenVien();
        PhongChuTriDaChiDao phongChuTriDaChiDao = getIntent().getParcelableExtra("phongChuTriDaChiDao");
        if (phongChuTriDaChiDao != null) {
            vanbandauraTruongPhong = phongChuTriDaChiDao.getVanBanDauRaTruongPhong();
            idvb = phongChuTriDaChiDao.getId();
            idPhoPhong = phongChuTriDaChiDao.getIdPhoPhong();
            idChuyenVien = phongChuTriDaChiDao.getIdChuyenVien();
            idPhoPhongPhoiHop = phongChuTriDaChiDao.getIdPhoPhongPhoiHops();
            idChuyenVienPhoiHops = phongChuTriDaChiDao.getIdChuyenVienPhoiHops();
            spnPhongNDVBDSVBDenChoLDXL.setText(String.valueOf(phongChuTriDaChiDao.getTenChuyenVien()));
            tvSKHNDVBDSVBDenChoLDXL.setText(String.valueOf(phongChuTriDaChiDao.getSoKyHieu()));
            tvChiDao1NDVBDSVBDenChoLDXL.setText(String.valueOf(phongChuTriDaChiDao.getChiDaoChuTri()));
            tvNoiGuiNDVBDSVBDenChoLDXL.setText(String.valueOf(phongChuTriDaChiDao.getNoiGui()));
            tvNgayNDVBDSVBDenChoLDXL.setText(phongChuTriDaChiDao.getNgayNhap());
            tvSoDenNDVBDSVBDenChoLDXL.setText(String.valueOf(phongChuTriDaChiDao.getSoDen()));
            tvNgayThangNamNDVBDSVBDenChoLDXL.setText(String.valueOf(phongChuTriDaChiDao.getHanGiaiQuyet()));
            tvTrichYeuNDVBDSVBDenChoLDXL.setText(String.valueOf(phongChuTriDaChiDao.getMoTa()));
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(phongChuTriDaChiDao.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBVanBanSTCPhoiHopDaChiDaoActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
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

    @OnClick({R.id.spnPhongNDVBDSVBDenChoLDXL,
            R.id.btnChonPhoiHop,
            R.id.tvNgayThangNamNDVBDSVBDenChoLDXL, R.id.lnNoiDungVB,
            R.id.btnBack,
            R.id.tvDuyet,
            R.id.tvXemChiTietNDVBDSVBDenChoLDXL})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.spnPhongNDVBDSVBDenChoLDXL:
                AlertDialog.Builder builderChuyenVien = new AlertDialog.Builder(this);
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
                tvChonChuyenVien.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        spnPhongNDVBDSVBDenChoLDXL.setText("");
                        dialog.dismiss();
                    }
                });

                break;
            case R.id.btnChonPhoiHop:
                AlertDialog.Builder builderphongphoihop = new AlertDialog.Builder(this);
                LayoutInflater inflaterphongphoihop = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewphongphoihop = inflaterphongphoihop.inflate(R.layout.dialog_chon_phong_ban_phoi_hop, null);
                builderphongphoihop.setView(viewphongphoihop);
                builderphongphoihop.setCancelable(false);
                dialog = builderphongphoihop.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                Button imgCancel = viewphongphoihop.findViewById(R.id.ivCancel);
                Button btnGhiLai = viewphongphoihop.findViewById(R.id.btnGhiLai);

                LinearLayoutManager layoutManagerPhoihop = new LinearLayoutManager(getApplicationContext());
                layoutManagerPhoihop.setOrientation(LinearLayoutManager.VERTICAL);

                rcTenPhoPhong = viewphongphoihop.findViewById(R.id.rcTenPhongPhoiHop);

                rcTenPhoPhong.setLayoutManager(layoutManagerPhoihop);
                rcTenPhoPhong.setAdapter(adapterChonChuyenVienPhoiHop);
                adapterChonChuyenVienPhoiHop.notifyDataSetChanged();

                imgCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        giamdocVaPhoGiamdocArrayList.clear();
                        dialog.dismiss();
                    }
                });
                btnGhiLai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String chidao2 = "Chuyển đ/c " + spnPhongNDVBDSVBDenChoLDXL.getText() + " chủ trì giải quyết. ";
                        int index = 0;
                        idChuyenVienPhoiHops = "";
                        for (GiamdocVaPhoGiamdoc item : giamdocVaPhoGiamdocArrayList) {

                            index++;
                            if (index == giamdocVaPhoGiamdocArrayList.size()) {
                                idChuyenVienPhoiHops += "" + item.getId();
                                chidao2 += item.getHoTen() + " phối hợp";
                            } else {
                                idChuyenVienPhoiHops += item.getId() + ",";
                                chidao2 += item.getHoTen() + ", ";
                            }
                        }
                        tvChiDao1NDVBDSVBDenChoLDXL.setText(chidao2);
                        giamdocVaPhoGiamdocArrayList.clear();
                        dialog.dismiss();

                    }
                });
                break;

            case R.id.tvNgayThangNamNDVBDSVBDenChoLDXL:
                showDatePickerDialog();
                break;

            case R.id.lnNoiDungVB:
                closeKeyboard();
                break;
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTietNDVBDSVBDenChoLDXL:
                if (!click) {
                    Intent intent = new Intent(this, TTVBVBPhongCHuTriDaChiDaoActivity.class);
                    intent.putExtra("idvb", idvb);
                    startActivity(intent);
                    click = true;
                }

                break;

            case R.id.tvDuyet:

                if (cbVbQuanTrong.isChecked() && cbVanBanLuu.isChecked()) {
                    getPresenter().duyetVBSTCPhoiHopDaChiDaoPhong(idvb, idPhoPhong, idPhoPhongPhoiHop, idChuyenVien, idChuyenVienPhoiHops, "", tvChiDao1NDVBDSVBDenChoLDXL.getText().toString(),
                            vanbandauraTruongPhong, true, true, tvNgayThangNamNDVBDSVBDenChoLDXL.getText().toString());
                } else if (cbVanBanLuu.isChecked()) {
                    getPresenter().duyetVBSTCPhoiHopDaChiDaoPhong(idvb, idPhoPhong, idPhoPhongPhoiHop, idChuyenVien, idChuyenVienPhoiHops, "", tvChiDao1NDVBDSVBDenChoLDXL.getText().toString(),
                            vanbandauraTruongPhong, false, true, tvNgayThangNamNDVBDSVBDenChoLDXL.getText().toString());
                } else if (cbVbQuanTrong.isChecked()) {
                    getPresenter().duyetVBSTCPhoiHopDaChiDaoPhong(idvb, idPhoPhong, idPhoPhongPhoiHop, idChuyenVien, idChuyenVienPhoiHops, "", tvChiDao1NDVBDSVBDenChoLDXL.getText().toString(),
                            vanbandauraTruongPhong, true, false, tvNgayThangNamNDVBDSVBDenChoLDXL.getText().toString());
                } else {
                    getPresenter().duyetVBSTCPhoiHopDaChiDaoPhong(idvb, idPhoPhong, idPhoPhongPhoiHop, idChuyenVien, idChuyenVienPhoiHops, "", tvChiDao1NDVBDSVBDenChoLDXL.getText().toString(),
                            vanbandauraTruongPhong, false, false, tvNgayThangNamNDVBDSVBDenChoLDXL.getText().toString());
                }

                break;

        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetPhoPhongBanSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
    }

    @Override
    public void onGetChuyenvienSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterTenChuyenVien = new AdapterTenChuyenVien(giamdocVaPhoGiamdoc, this);
        adapterChonChuyenVienPhoiHop = new AdapterChonChuyenVienPhoiHop(giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void duyetVanBanSuccess() {
        Toast.makeText(this, "Đã duyệt", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onDateSet(DatePicker view, int year,
                          int monthOfYear, int dayOfMonth) {
        String date;
        if (monthOfYear + 1 < 10) {
            if (dayOfMonth < 10) {
                date = "0" + dayOfMonth + "/" + "0" + (monthOfYear + 1) + "/" + year;
            } else {
                date = dayOfMonth + "/" + "0" + (monthOfYear + 1) + "/" + year;
            }
        } else {
            if (dayOfMonth < 10) {
                date = "0" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
            } else {
                date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
            }
        }
        tvNgayThangNamNDVBDSVBDenChoLDXL.setText(date);
//        tvNgayThangNam.setText(date);
    }

    public void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void onItemClickChuyenVien(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        idChuyenVien = giamdocVaPhoGiamdoc.getId();
        spnPhongNDVBDSVBDenChoLDXL.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        tvChiDao1NDVBDSVBDenChoLDXL.setText("Chuyển đ/c " + giamdocVaPhoGiamdoc.getHoTen() + " chủ trì giải quyết.");
        dialog.dismiss();

    }

    @Override
    public void onItemClickChonChuyenVien(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        if (giamdocVaPhoGiamdocArrayList.contains(giamdocVaPhoGiamdoc)) {
            giamdocVaPhoGiamdocArrayList.remove(giamdocVaPhoGiamdoc);
        } else {
            giamdocVaPhoGiamdocArrayList.add(giamdocVaPhoGiamdoc);
        }
    }

    @Override
    public NDVBVBSTCPhoiHopDaChiDaoPresenter createPresenter() {
        return new NDVBVBSTCPhoiHopDaChiDaoPresenterImpl(this);
    }
}
