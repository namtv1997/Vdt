package com.vpdt.vpdt.ui.activity.QuanLyDauViec;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.vpdt.vpdt.model.ItemDanhSachPhongPhoiHopDaChiDaoTPCC;
import com.vpdt.vpdt.model.ItemDauViecPhongChuTriChoXuLyTCC;
import com.vpdt.vpdt.presenter.NDVBDauViecPhongChuTriChoXuLyTPCCPresenter;
import com.vpdt.vpdt.presenter.NDVBDauViecPhongChuTriChoXuLyViewTPCC;
import com.vpdt.vpdt.presenter.impl.NDVBDauViecPhongChuTriChoXuLyTPCCPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterChonChuyenVienPhoiHop;
import com.vpdt.vpdt.ui.adapter.AdapterChonPhoPhongPhoiHop;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDanhSachPhongPhoiHopDaChiDaoTPCCActivity extends BaseActivity<NDVBDauViecPhongChuTriChoXuLyTPCCPresenter> implements NDVBDauViecPhongChuTriChoXuLyViewTPCC,
        DatePickerDialog.OnDateSetListener,
        AdapterChonChuyenVienPhoiHop.OnItemClickListenerChonChuyenVien,
        AdapterChonPhoPhongPhoiHop.OnItemClickListenerPhoPhongPhoiHop {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvHanVanBan)
    TextView tvHanVanBan;
    @BindView(R.id.tvNguoiNhap)
    TextView tvNguoiNhap;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvNgayNhap)
    TextView tvNgayNhap;
    @BindView(R.id.tvCanBoChiDao)
    TextView tvCanBoChiDao;
    @BindView(R.id.tvNoiDungChiDao)
    TextView tvNoiDungChiDao;

    @BindView(R.id.tvNgayThangNam)
    TextView tvNgayThangNam;

    @BindView(R.id.edtChiDao2)
    EditText edtChiDao2;

    AdapterChonChuyenVienPhoiHop adapterChonChuyenVienPhoiHop;
    AdapterChonPhoPhongPhoiHop adapterChonPhoPhongPhoiHop;
    ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdocArrayList = new ArrayList<>();
    int id;
    String idPhoPhongPhoiHop = "", tenPhoPhongPhoiHop;
    AlertDialog dialog;
    RecyclerView rcTenPhoPhong;
    RecyclerView rcTenChuyenVien;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbdanh_sach_phong_phoi_hop_da_chi_dao_tpcc;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        getPresenter().getAlCVPhongBanCC(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""));
        getPresenter().getAllPhoPhongBanCC(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""));
        ItemDanhSachPhongPhoiHopDaChiDaoTPCC itemDanhSachDauViecQuaHanCuaPhong = getIntent().getParcelableExtra("itemDauViecPhongChuTriChoXuLyTCC");
        if (itemDanhSachDauViecQuaHanCuaPhong != null) {
            String shortDate = itemDanhSachDauViecQuaHanCuaPhong.getNgayNhap();
            id = itemDanhSachDauViecQuaHanCuaPhong.getId();
            idPhoPhongPhoiHop = itemDanhSachDauViecQuaHanCuaPhong.getIdPhoPhongPhoiHops();
            tenPhoPhongPhoiHop = itemDanhSachDauViecQuaHanCuaPhong.getTenPhoPhongPhoiHops();
            tvNgay.setText(shortDate.substring(0, 5));
            tvHanVanBan.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getHanVanBan()));
            tvNgayThangNam.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getHanXuLy()));
            tvNguoiNhap.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getNguoiNhap()));
            tvTrichYeu.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getMoTa()));
            tvNgayNhap.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getNgayNhap()));
            tvCanBoChiDao.setText(String.valueOf("*Nội dung chỉ đạo của đ/c " + itemDanhSachDauViecQuaHanCuaPhong.getCanBoChiDao() + ":"));
            tvNoiDungChiDao.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getNoiDungChiDao()));
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack,
            R.id.tvXemChiTiet,
            R.id.lnNoiDungVB,
            R.id.btnChonPhoiHop,
            R.id.tvNgayThangNam,
            R.id.btnDuyet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, ChiTietDauViecPhongPhoiHopChoXuLyCVPHActivity.class);
                    intent.putExtra("idvb", id);
                    startActivity(intent);
                    click = true;
                }
                break;
            case R.id.lnNoiDungVB:
                closeKeyboard();
                break;
            case R.id.btnChonPhoiHop:
                AlertDialog.Builder builderphongphoihop = new AlertDialog.Builder(this);
                LayoutInflater inflaterphongphoihop = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewphongphoihop = inflaterphongphoihop.inflate(R.layout.dialog_chon_phong_ban_phoi_hop_2rcv, null);
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
                rcTenPhoPhong.setAdapter(adapterChonPhoPhongPhoiHop);
                adapterChonPhoPhongPhoiHop.notifyDataSetChanged();

                rcTenChuyenVien = viewphongphoihop.findViewById(R.id.rcTenChuyenVien);
                LinearLayoutManager layoutManagerPhoihop1 = new LinearLayoutManager(getApplicationContext());
                layoutManagerPhoihop1.setOrientation(LinearLayoutManager.VERTICAL);
                rcTenChuyenVien.setLayoutManager(layoutManagerPhoihop1);
                rcTenChuyenVien.setAdapter(adapterChonChuyenVienPhoiHop);
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
                        String chidao2 = "";
                        int index = 0;
                        idPhoPhongPhoiHop = "";
                        tenPhoPhongPhoiHop = "";
                        for (GiamdocVaPhoGiamdoc item : giamdocVaPhoGiamdocArrayList) {
                            index++;
                            if (index == giamdocVaPhoGiamdocArrayList.size()) {
                                idPhoPhongPhoiHop += item.getId();
                                tenPhoPhongPhoiHop += item.getHoTen();
                                chidao2 += item.getHoTen() + " phối hợp giải quyết.";
                            } else {
                                idPhoPhongPhoiHop += item.getId() + ",";
                                tenPhoPhongPhoiHop += item.getHoTen() + ",";
                                chidao2 += item.getHoTen() + ", ";
                            }
                        }
                        edtChiDao2.setText(chidao2);
                        giamdocVaPhoGiamdocArrayList.clear();
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.tvNgayThangNam:
                showDatePickerDialog();
                break;
            case R.id.btnDuyet:
                getPresenter().duyetDauViecPhongPhoHopChoXuLyTPCC(PrefUtil.getString(NDVBDanhSachPhongPhoiHopDaChiDaoTPCCActivity.this, Key.NAM_LAM_VIEC, ""),
                        id, idPhoPhongPhoiHop, tenPhoPhongPhoiHop, tvNgayThangNam.getText().toString());
                break;

        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetPhoPhongBanSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterChonPhoPhongPhoiHop = new AdapterChonPhoPhongPhoiHop(giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void onGetPhongBanSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterChonChuyenVienPhoiHop = new AdapterChonChuyenVienPhoiHop(giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void onDuyetSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
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
    public void onItemClickChonChuyenVien(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        if (giamdocVaPhoGiamdocArrayList.contains(giamdocVaPhoGiamdoc)) {
            giamdocVaPhoGiamdocArrayList.remove(giamdocVaPhoGiamdoc);
        } else {
            giamdocVaPhoGiamdocArrayList.add(giamdocVaPhoGiamdoc);
        }
    }

    @Override
    public void onItemClickPhoPhongPhoiHop(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        if (giamdocVaPhoGiamdocArrayList.contains(giamdocVaPhoGiamdoc)) {
            giamdocVaPhoGiamdocArrayList.remove(giamdocVaPhoGiamdoc);
        } else {
            giamdocVaPhoGiamdocArrayList.add(giamdocVaPhoGiamdoc);
        }
    }

    @Override
    public NDVBDauViecPhongChuTriChoXuLyTPCCPresenter createPresenter() {
        return new NDVBDauViecPhongChuTriChoXuLyTPCCPresenterImpl(this);
    }
}