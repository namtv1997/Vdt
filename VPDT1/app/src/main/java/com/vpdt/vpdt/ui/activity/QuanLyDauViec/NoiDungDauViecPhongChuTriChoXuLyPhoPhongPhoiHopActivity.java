package com.vpdt.vpdt.ui.activity.QuanLyDauViec;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
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

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.ItemDauViecPhongChuTriChoXuLy;
import com.vpdt.vpdt.presenter.NoiDungDauViecPhongChuTriChoXuLyPhoPhongPhoiHopPresenter;
import com.vpdt.vpdt.presenter.NoiDungDauViecPhongChuTriChoXuLyPhoPhongPhoiHopView;
import com.vpdt.vpdt.presenter.impl.NoiDungDauViecPhongChuTriChoXuLyPhoPhongPhoiHopPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterChonChuyenVienPhoiHop;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoiDungDauViecPhongChuTriChoXuLyPhoPhongPhoiHopActivity extends BaseActivity<NoiDungDauViecPhongChuTriChoXuLyPhoPhongPhoiHopPresenter> implements
        NoiDungDauViecPhongChuTriChoXuLyPhoPhongPhoiHopView, DatePickerDialog.OnDateSetListener,
        AdapterChonChuyenVienPhoiHop.OnItemClickListenerChonChuyenVien {

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

    @BindView(R.id.edtChiDao1)
    EditText edtChiDao1;
    boolean click = false;
    AdapterChonChuyenVienPhoiHop adapterChonChuyenVienPhoiHop;

    ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdocArrayList = new ArrayList<>();
    int idChuyenVien;
    String idChuyenVienPhoiHops = "", tenChuyenvien, tenChuyenvienPhoiHop;
    AlertDialog dialog;
    RecyclerView rcTenChuyenVien;

    int id;

    @Override
    public int getContentViewId() {
        return R.layout.activity_noi_dung_dau_viec_phong_chu_tri_cho_xu_ly_pho_phong_phoi_hop;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        getPresenter().getAllChuyenVien();
        ItemDauViecPhongChuTriChoXuLy itemDanhSachDauViecQuaHanCuaPhong = getIntent().getParcelableExtra("itemDanhSachDauViecQuaHanCuaPhong");
        if (itemDanhSachDauViecQuaHanCuaPhong != null) {

            String shortDate = itemDanhSachDauViecQuaHanCuaPhong.getNgayNhap();
            id = itemDanhSachDauViecQuaHanCuaPhong.getId();
            idChuyenVien = itemDanhSachDauViecQuaHanCuaPhong.getIdChuyenVien();
            tenChuyenvien = itemDanhSachDauViecQuaHanCuaPhong.getTenChuyenVien();
            idChuyenVienPhoiHops = itemDanhSachDauViecQuaHanCuaPhong.getIdChuyenVienPhoiHops();
            tvNgay.setText(shortDate.substring(0, 5));
            tvHanVanBan.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getHanVanBan()));
            tvNgayThangNam.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getHanXuLy()));
            edtChiDao1.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getChiDao()));
            tvNguoiNhap.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getNguoiNhap()));
            tvTrichYeu.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getMoTa()));
            tvNgayNhap.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getNgayNhap()));
            tvCanBoChiDao.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getCanBoChiDao()));
            tvNoiDungChiDao.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getNoiDungChiDao()));
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack,
            R.id.tvXemChiTiet, R.id.lnNoiDungVB,
            R.id.btnChonPhoiHop,
            R.id.tvNgayThangNam, R.id.btnDuyet})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btnBack:
                finish();
                break;

            case R.id.btnChonPhoiHop:
                AlertDialog.Builder builderphongphoihop = new AlertDialog.Builder(this);
                LayoutInflater inflaterphongphoihop = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewphongphoihop = inflaterphongphoihop.inflate(R.layout.dialog_chon_phong_ban_phoi_hop, null);
                builderphongphoihop.setView(viewphongphoihop);
                dialog = builderphongphoihop.create();
                builderphongphoihop.setCancelable(false);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                Button imgCancel = viewphongphoihop.findViewById(R.id.ivCancel);
                Button btnGhiLai = viewphongphoihop.findViewById(R.id.btnGhiLai);

                LinearLayoutManager layoutManagerPhoihop = new LinearLayoutManager(getApplicationContext());
                layoutManagerPhoihop.setOrientation(LinearLayoutManager.VERTICAL);

                rcTenChuyenVien = viewphongphoihop.findViewById(R.id.rcTenPhongPhoiHop);

                rcTenChuyenVien.setLayoutManager(layoutManagerPhoihop);
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
                        idChuyenVienPhoiHops = "";
                        tenChuyenvienPhoiHop = "";
                        for (GiamdocVaPhoGiamdoc item : giamdocVaPhoGiamdocArrayList) {
                            index++;
                            if (index == giamdocVaPhoGiamdocArrayList.size()) {
                                idChuyenVienPhoiHops += item.getId();
                                tenChuyenvienPhoiHop += item.getHoTen();

                                chidao2 += item.getHoTen() + " phối hợp giải quyết.";
                            } else {
                                idChuyenVienPhoiHops += item.getId() + ",";
                                tenChuyenvienPhoiHop += item.getHoTen() + ",";

                                chidao2 += item.getHoTen() + ", ";
                            }
                        }

                        edtChiDao1.setText(chidao2);
                        giamdocVaPhoGiamdocArrayList.clear();
                        dialog.dismiss();

                    }
                });
                break;

            case R.id.tvNgayThangNam:
                showDatePickerDialog();
                break;
            case R.id.lnNoiDungVB:
                closeKeyboard();
                break;
            case R.id.btnDuyet:
                getPresenter().duyetDauViecPhongChuTriChoXuLyTPPP(id, idChuyenVienPhoiHops, tenChuyenvienPhoiHop, tvNgayThangNam.getText().toString());

                break;

            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, ChiTietDauViecChoXuLyActivity.class);
                    intent.putExtra("idvb", id);
                    startActivity(intent);
                    click = true;
                }

                break;
        }
    }

    @Override
    public void onGetChuyenvienSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterChonChuyenVienPhoiHop = new AdapterChonChuyenVienPhoiHop(giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void onDuyetSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NoiDungDauViecPhongChuTriChoXuLyPhoPhongPhoiHopPresenter createPresenter() {
        return new NoiDungDauViecPhongChuTriChoXuLyPhoPhongPhoiHopPresenterImpl(this);
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

}
