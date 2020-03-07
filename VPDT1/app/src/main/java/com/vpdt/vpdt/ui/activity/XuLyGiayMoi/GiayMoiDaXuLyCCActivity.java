package com.vpdt.vpdt.ui.activity.XuLyGiayMoi;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.VanBanDaChiDaoChuaHT;
import com.vpdt.vpdt.presenter.NDVB_GiayMoiChoXuLyPresenter;
import com.vpdt.vpdt.presenter.NDVB_GiayMoiChoXuLyView;
import com.vpdt.vpdt.presenter.impl.NDVB_GiayMoiChoXuLyPresenterImpl;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.TTVBVanBanChuTriChoXuLyActivity;
import com.vpdt.vpdt.ui.adapter.AdapterChonChuyenVienPhoiHop;
import com.vpdt.vpdt.ui.adapter.AdapterTenChuyenVien;
import com.vpdt.vpdt.ui.adapter.AdapterTenGiamDoc;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GiayMoiDaXuLyCCActivity extends BaseActivity<NDVB_GiayMoiChoXuLyPresenter> implements NDVB_GiayMoiChoXuLyView,
        DatePickerDialog.OnDateSetListener, AdapterTenGiamDoc.OnItemClickListener, AdapterTenChuyenVien.OnItemClickListenerChuyenVien,
        AdapterChonChuyenVienPhoiHop.OnItemClickListenerChonChuyenVien {

    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvNoigui)
    TextView tvNoigui;
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvChuyenChiCucPho)
    TextView tvChuyenChiCucPho;
    @BindView(R.id.tvChuyenTruongPhong)
    TextView tvChuyenTruongPhong;
    @BindView(R.id.tvNgayThangNam)
    TextView tvNgayThangNam;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;
    @BindView(R.id.tvNoiDung)
    TextView tvNoiDung;

    @BindView(R.id.etChiDao1)
    EditText etChiDao1;
    @BindView(R.id.etChiDao2)
    EditText etChiDao2;

    int idvb, idChiCuc, idChiCucPho, idTruongPhong;
    String idTruongPhongPP;
    boolean click = false;
    AlertDialog dialog;
    AdapterTenGiamDoc adapterTenGiamDoc;
    AdapterTenChuyenVien adapterTenChuyenVien;
    AdapterChonChuyenVienPhoiHop adapterChonChuyenVienPhoiHop;
    RecyclerView rcvChiCucPho;
    RecyclerView rcvTruongPhong;
    RecyclerView rcvTruongPhongPH;
    ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdocArrayList = new ArrayList<>();

    @Override
    public int getContentViewId() {
        return R.layout.activity_giay_moi_da_xu_ly_cc;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        getPresenter().getAllTruongPhongChiCuc(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""));
        getPresenter().getAllChiCucPho(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""));
        VanBanDaChiDaoChuaHT phongChuTriChoXuLyCC = getIntent().getParcelableExtra("vanBanDaChiDaoChuaHT");
        if (phongChuTriChoXuLyCC != null) {
            idvb = phongChuTriChoXuLyCC.getId();
            idChiCuc = phongChuTriChoXuLyCC.getIdChiCuc();
            idChiCucPho = phongChuTriChoXuLyCC.getIdChiCucPho();
            idTruongPhong = phongChuTriChoXuLyCC.getIdTruongPhong();
            tvNgay.setText(String.valueOf(phongChuTriChoXuLyCC.getNgayNhap()));
            tvSKH.setText(String.valueOf(phongChuTriChoXuLyCC.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(phongChuTriChoXuLyCC.getSoDen()));
            tvNoigui.setText(String.valueOf(phongChuTriChoXuLyCC.getNoiGui()));
            tvTrichYeu.setText(String.valueOf(phongChuTriChoXuLyCC.getMoTa()));
            tvChuyenChiCucPho.setText(String.valueOf(phongChuTriChoXuLyCC.getTenChiCucPho()));
            tvChuyenTruongPhong.setText(String.valueOf(phongChuTriChoXuLyCC.getTenTruongPhong()));
            tvNgayThangNam.setText(String.valueOf(phongChuTriChoXuLyCC.getHanGiaiQuyet()));
            if (phongChuTriChoXuLyCC.getNoiDung() != null || !phongChuTriChoXuLyCC.getNoiDung().isEmpty()) {
                tvNoiDung.setText(String.valueOf(phongChuTriChoXuLyCC.getNoiDung()));
            } else {
                tvNoiDung.setVisibility(View.GONE);
            }
            if (phongChuTriChoXuLyCC.getChiDaoChiCucPho() != null || !phongChuTriChoXuLyCC.getChiDaoChiCucPho().isEmpty()) {
                etChiDao1.setText(String.valueOf(phongChuTriChoXuLyCC.getChiDaoChiCucPho()));
            }
            if (phongChuTriChoXuLyCC.getChiDaoChuTri() != null || !phongChuTriChoXuLyCC.getChiDaoChuTri().isEmpty()) {
                etChiDao2.setText(String.valueOf(phongChuTriChoXuLyCC.getChiDaoChuTri()));
            }
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(phongChuTriChoXuLyCC.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(GiayMoiDaXuLyCCActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
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

    @Override
    public Context gContext() {
        return this;
    }

    @OnClick({R.id.tvChuyenChiCucPho, R.id.tvChuyenTruongPhong, R.id.btnChonPhoiHop, R.id.tvNgayThangNam,
            R.id.lnNoiDungVB, R.id.btnBack, R.id.tvXemChiTiet, R.id.btnDuyet,})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvChuyenChiCucPho:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.dialog_ten_giam_doc, null);
                builder.setView(view1);
                dialog = builder.create();
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                rcvChiCucPho = view1.findViewById(R.id.rcTenGiamDoc);
                rcvChiCucPho.setLayoutManager(layoutManager);
                rcvChiCucPho.setAdapter(adapterTenGiamDoc);
                adapterTenGiamDoc.notifyDataSetChanged();
                dialog.show();
                TextView btnChuyenPGiamDoc = view1.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyenPGiamDoc.setText("Chuyển chi cục phó");
                btnChuyenPGiamDoc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvChuyenChiCucPho.setText("");
                        etChiDao1.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.tvChuyenTruongPhong:
                AlertDialog.Builder builderChuyenVien = new AlertDialog.Builder(this);
                LayoutInflater inflaterChuyenVien = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewChuyenVien = inflaterChuyenVien.inflate(R.layout.dialog_ten_chuyen_vien, null);
                builderChuyenVien.setView(viewChuyenVien);
                dialog = builderChuyenVien.create();
                LinearLayoutManager layoutManagerChuyenVien = new LinearLayoutManager(getApplicationContext());
                layoutManagerChuyenVien.setOrientation(LinearLayoutManager.VERTICAL);
                rcvTruongPhong = viewChuyenVien.findViewById(R.id.rcTenGiamDoc);
                rcvTruongPhong.setLayoutManager(layoutManagerChuyenVien);
                rcvTruongPhong.setAdapter(adapterTenChuyenVien);
                adapterTenChuyenVien.notifyDataSetChanged();
                dialog.show();
                TextView tvChonChuyenVien = viewChuyenVien.findViewById(R.id.tvChonChuyenVien);
                tvChonChuyenVien.setText("Chọn trưởng phòng");
                tvChonChuyenVien.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvChuyenTruongPhong.setText("");
                        etChiDao2.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.btnChonPhoiHop:
                if (tvChuyenChiCucPho.getText().equals("")) {
                    Toast.makeText(this, "Chưa chuyền Chi cục phó", Toast.LENGTH_SHORT).show();
                } else if (tvChuyenTruongPhong.getText().equals("")) {
                    Toast.makeText(this, "Chưa chọn trưởng phòng", Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder builderphongphoihop = new AlertDialog.Builder(this);
                    LayoutInflater inflaterphongphoihop = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    final View viewphongphoihop = inflaterphongphoihop.inflate(R.layout.dialog_chon_phong_ban_phoi_hop, null);
                    builderphongphoihop.setView(viewphongphoihop);
                    builderphongphoihop.setCancelable(false);
                    dialog = builderphongphoihop.create();
                    dialog.show();
                    Button imgCancel = viewphongphoihop.findViewById(R.id.ivCancel);
                    Button btnGhiLai = viewphongphoihop.findViewById(R.id.btnGhiLai);
                    LinearLayoutManager layoutManagerPhoihop = new LinearLayoutManager(getApplicationContext());
                    layoutManagerPhoihop.setOrientation(LinearLayoutManager.VERTICAL);
                    rcvTruongPhongPH = viewphongphoihop.findViewById(R.id.rcTenPhongPhoiHop);
                    rcvTruongPhongPH.setLayoutManager(layoutManagerPhoihop);
                    rcvTruongPhongPH.setAdapter(adapterChonChuyenVienPhoiHop);
                    adapterChonChuyenVienPhoiHop.notifyDataSetChanged();
                    imgCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            giamdocVaPhoGiamdocArrayList.clear();
                        }
                    });
                    btnGhiLai.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String chidao2 = "Chuyển đ/c " + tvChuyenTruongPhong.getText() + " chủ trì. ";
                            int index = 0;
                            idTruongPhongPP = "";
                            for (GiamdocVaPhoGiamdoc item : giamdocVaPhoGiamdocArrayList) {

                                index++;
                                if (index == giamdocVaPhoGiamdocArrayList.size()) {
                                    idTruongPhongPP += "" + item.getId();
                                    chidao2 += item.getHoTen() + " phối hợp";
                                } else {
                                    idTruongPhongPP += item.getId() + ",";
                                    chidao2 += item.getHoTen() + ", ";
                                }
                            }
                            etChiDao2.setText(chidao2);
                            giamdocVaPhoGiamdocArrayList.clear();
                            dialog.dismiss();
                        }
                    });
                }
                break;
            case R.id.tvNgayThangNam:
                showDatePickerDialog();
                break;
            case R.id.lnNoiDungVB:
                closeKeyboard();
                break;
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTiet:
                try {
                    if (!click) {
                        Intent intent = new Intent(this, TTVBVanBanChuTriChoXuLyActivity.class);
                        intent.putExtra("idvBChuTriChoXuLy", idvb);
                        startActivity(intent);
                        click = true;
                    }
                } catch (Exception e) {
                    Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnDuyet:
                String chiDaoChiCucPho = etChiDao1.getText().toString();
                String chiDaoChuTri = etChiDao2.getText().toString();
                String hanGiaiQuyet = tvNgayThangNam.getText().toString();
                getPresenter().duyetGMDaXuLyCC(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""), idvb, idChiCuc, idChiCucPho, idTruongPhong, idTruongPhongPP,
                        chiDaoChiCucPho, chiDaoChuTri, hanGiaiQuyet);
                break;
        }
    }

    @Override
    public void onGetTruongPhongChiCucSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterTenChuyenVien = new AdapterTenChuyenVien(giamdocVaPhoGiamdoc, this);
        adapterChonChuyenVienPhoiHop = new AdapterChonChuyenVienPhoiHop(giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void onGetChiCucPhoSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterTenGiamDoc = new AdapterTenGiamDoc(this, giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void duyetVBPhongChuTriChoXuLyCC() {
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
        tvNgayThangNam.setText(date);
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
    public void onItemClick(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        idChiCuc = giamdocVaPhoGiamdoc.getId();
        tvChuyenChiCucPho.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        etChiDao1.setText("Chuyển đ/c " + giamdocVaPhoGiamdoc.getHoTen());
        dialog.dismiss();
    }

    @Override
    public void onItemClickChuyenVien(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        idTruongPhong = giamdocVaPhoGiamdoc.getId();
        tvChuyenTruongPhong.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        etChiDao2.setText("Chuyển đ/c " + giamdocVaPhoGiamdoc.getHoTen() + " tham mưu giải quyết.");
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
    public NDVB_GiayMoiChoXuLyPresenter createPresenter() {
        return new NDVB_GiayMoiChoXuLyPresenterImpl(this);
    }
}
