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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.ItemDauViecPhongChuTriDaChiDaoChuaHoanThanh;
import com.vpdt.vpdt.presenter.NDVBDauViecPhongPhoiHopDaChiDaoChuaHTPresenter;
import com.vpdt.vpdt.presenter.NDVBDauViecPhongPhoiHopDaChiDaoChuaHTView;
import com.vpdt.vpdt.presenter.impl.NDVBDauViecPhongPhoiHopDaChiDaoChuaHTPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterChonChuyenVienPhoiHop;
import com.vpdt.vpdt.ui.adapter.AdapterChonPhoPhongPhoiHop;
import com.vpdt.vpdt.ui.adapter.AdapterTenChuyenVien;
import com.vpdt.vpdt.ui.adapter.AdapterTenGiamDoc;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDauViecPhongPhoiHopDaChiDaoChuaHTActivity extends BaseActivity<NDVBDauViecPhongPhoiHopDaChiDaoChuaHTPresenter> implements NDVBDauViecPhongPhoiHopDaChiDaoChuaHTView,
        DatePickerDialog.OnDateSetListener,
        AdapterChonChuyenVienPhoiHop.OnItemClickListenerChonChuyenVien,
        AdapterChonPhoPhongPhoiHop.OnItemClickListenerPhoPhongPhoiHop,
        AdapterTenGiamDoc.OnItemClickListener,
        AdapterTenChuyenVien.OnItemClickListenerChuyenVien {

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
    @BindView(R.id.tvChuyenPhoPhong)
    TextView tvChuyenPhoPhong;
    @BindView(R.id.tvChonChuyenVien1)
    TextView tvChonChuyenVien1;
    @BindView(R.id.tvNgayThangNam)
    TextView tvNgayThangNam;

    @BindView(R.id.edtChiDao1)
    EditText edtChiDao1;
    @BindView(R.id.edtChiDao2)
    EditText edtChiDao2;
    @BindView(R.id.edtChiDao3)
    EditText edtChiDao3;
    @BindView(R.id.edtChiDao4)
    EditText edtChiDao4;

    @BindView(R.id.rlChonPhoPhong)
    RelativeLayout rlChonPhoPhong;

    @BindView(R.id.btnChonPhoPhongPhoiHop)
    Button btnChonPhoPhongPhoiHop;

    AdapterChonChuyenVienPhoiHop adapterChonChuyenVienPhoiHop;
    AdapterChonPhoPhongPhoiHop adapterChonPhoPhongPhoiHop;
    AdapterTenChuyenVien adapterTenChuyenVien;
    AdapterTenGiamDoc adapterTenGiamDoc;
    ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdocArrayList = new ArrayList<>();
    int idChuyenVien, idPhoPhong;
    String idPhoPhongPhoiHop = "", tenPhoPhong, tenPhoPhongPhoiHop;
    String idChuyenVienPhoiHops = "", tenChuyenvien, tenChuyenvienPhoiHop;
    AlertDialog dialog;
    RecyclerView rcTenPhoPhong;
    RecyclerView rcTenPhoGiamDoc;
    RecyclerView rcTenChuyenVien;
    boolean click = false;
    int id, level;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbdau_viec_phong_phoi_hop_da_chi_dao_chua_ht;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        getPresenter().getAllChuyenVien();
        getPresenter().getAllPhoPhongBan();
        level = PrefUtil.getInt(this, Key.LEVEL, 0);
        if (level == 7) {
            rlChonPhoPhong.setVisibility(View.GONE);
            btnChonPhoPhongPhoiHop.setVisibility(View.GONE);
            edtChiDao1.setVisibility(View.GONE);
            edtChiDao2.setVisibility(View.GONE);
        }
        ItemDauViecPhongChuTriDaChiDaoChuaHoanThanh itemDauViecPhongChuTriDaChiDaoChuaHoanThanh = getIntent().getParcelableExtra("itemDauViecPhongChuTriDaChiDaoChuaHoanThanh");
        if (itemDauViecPhongChuTriDaChiDaoChuaHoanThanh != null) {

            String shortDate = itemDauViecPhongChuTriDaChiDaoChuaHoanThanh.getNgayNhap();
            id = itemDauViecPhongChuTriDaChiDaoChuaHoanThanh.getId();
            idPhoPhong = itemDauViecPhongChuTriDaChiDaoChuaHoanThanh.getIdPhoPhong();
            idChuyenVien = itemDauViecPhongChuTriDaChiDaoChuaHoanThanh.getIdChuyenVien();
            idPhoPhongPhoiHop = itemDauViecPhongChuTriDaChiDaoChuaHoanThanh.getIdPhoPhongPhoiHops();
            idChuyenVienPhoiHops = itemDauViecPhongChuTriDaChiDaoChuaHoanThanh.getIdChuyenVienPhoiHops();
            tvNgay.setText(shortDate.substring(0, 5));
            tvChuyenPhoPhong.setText(String.valueOf(itemDauViecPhongChuTriDaChiDaoChuaHoanThanh.getTenPhoPhong()));
            tvChonChuyenVien1.setText(String.valueOf(itemDauViecPhongChuTriDaChiDaoChuaHoanThanh.getTenChuyenVien()));
            tvNgayThangNam.setText(String.valueOf(itemDauViecPhongChuTriDaChiDaoChuaHoanThanh.getHanXuLy()));
            tvHanVanBan.setText(String.valueOf(itemDauViecPhongChuTriDaChiDaoChuaHoanThanh.getHanVanBan()));
            tvNguoiNhap.setText(String.valueOf(itemDauViecPhongChuTriDaChiDaoChuaHoanThanh.getNguoiNhap()));
            tvTrichYeu.setText(String.valueOf(itemDauViecPhongChuTriDaChiDaoChuaHoanThanh.getMoTa()));
            tvNgayNhap.setText(String.valueOf(itemDauViecPhongChuTriDaChiDaoChuaHoanThanh.getNgayNhap()));
            tvCanBoChiDao.setText(String.valueOf(itemDauViecPhongChuTriDaChiDaoChuaHoanThanh.getCanBoChiDao()));
            tvNoiDungChiDao.setText(String.valueOf(itemDauViecPhongChuTriDaChiDaoChuaHoanThanh.getNoiDungChiDao()));
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
            R.id.tvXemChiTiet, R.id.lnNoiDungVB, R.id.btnChonPhoPhongPhoiHop,
            R.id.btnChonPhoiHop, R.id.tvChuyenPhoPhong, R.id.tvChonChuyenVien1,
            R.id.tvNgayThangNam, R.id.btnDuyet})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btnBack:
                finish();
                break;

            case R.id.btnChonPhoPhongPhoiHop:
                AlertDialog.Builder builderphophong = new AlertDialog.Builder(this);
                LayoutInflater inflaterphophong = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewphophong = inflaterphophong.inflate(R.layout.dialog_chon_phong_ban_phoi_hop, null);
                builderphophong.setView(viewphophong);
                builderphophong.setCancelable(false);
                dialog = builderphophong.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                Button imgCancephophong = viewphophong.findViewById(R.id.ivCancel);
                Button btnGhiLaiphophong = viewphophong.findViewById(R.id.btnGhiLai);
                TextView tvTitle = viewphophong.findViewById(R.id.tvTitle);
                tvTitle.setText("CHỌN PHÓ PHÒNG PHỐI HỢP");

                LinearLayoutManager layoutManagerphophong = new LinearLayoutManager(getApplicationContext());
                layoutManagerphophong.setOrientation(LinearLayoutManager.VERTICAL);

                rcTenPhoPhong = viewphophong.findViewById(R.id.rcTenPhongPhoiHop);

                rcTenPhoPhong.setLayoutManager(layoutManagerphophong);
                rcTenPhoPhong.setAdapter(adapterChonPhoPhongPhoiHop);
                adapterChonPhoPhongPhoiHop.notifyDataSetChanged();

                imgCancephophong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        giamdocVaPhoGiamdocArrayList.clear();
                        dialog.dismiss();
                    }
                });
                btnGhiLaiphophong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String chidao2 = " ";
                        int index = 0;
                        idPhoPhongPhoiHop = "";
                        tenPhoPhongPhoiHop = "";
                        for (GiamdocVaPhoGiamdoc item : giamdocVaPhoGiamdocArrayList) {

                            index++;
                            if (index == giamdocVaPhoGiamdocArrayList.size()) {
                                idPhoPhongPhoiHop += "" + item.getId();
                                tenPhoPhongPhoiHop += "" + item.getHoTen();
                                chidao2 += item.getHoTen() + " phối hợp giải quyết";
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
                        edtChiDao4.setText(chidao2);
                        giamdocVaPhoGiamdocArrayList.clear();
                        dialog.dismiss();

                    }
                });
                break;

            case R.id.tvChuyenPhoPhong:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.dialog_ten_pho_phong, null);
                builder.setView(view1);
                dialog = builder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView btnChuyenPhoPhong = view1.findViewById(R.id.btnChuyenPhoPhong);
                btnChuyenPhoPhong.setText("-- Chọn Phó phòng --");
                btnChuyenPhoPhong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edtChiDao1.setText(" ");
                        tvChuyenPhoPhong.setText("-- Chọn Phó phòng --");

                        dialog.dismiss();
                    }
                });
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                rcTenPhoGiamDoc = view1.findViewById(R.id.rcTenGiamDoc);
                rcTenPhoGiamDoc.setLayoutManager(layoutManager);
                rcTenPhoGiamDoc.setAdapter(adapterTenGiamDoc);
                adapterTenGiamDoc.notifyDataSetChanged();

                dialog.show();
                break;

            case R.id.tvChonChuyenVien1:
                AlertDialog.Builder builderChuyenVien = new AlertDialog.Builder(this);
                LayoutInflater inflaterChuyenVien = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewChuyenVien = inflaterChuyenVien.inflate(R.layout.dialog_ten_chuyen_vien, null);
                builderChuyenVien.setView(viewChuyenVien);
                dialog = builderChuyenVien.create();
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
                        tvChonChuyenVien1.setText("-- Chọn chuyên viên --");
                        edtChiDao3.setText("");
                        edtChiDao4.setText("");
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
                if (level == 7) {
                    getPresenter().duyetDauViecPhongPhoHopDaChiDao(id, 0, "", "", "", idChuyenVien, tenChuyenvien, idChuyenVienPhoiHops, tenChuyenvienPhoiHop, tvNgayThangNam.getText().toString());
                } else {
                    getPresenter().duyetDauViecPhongPhoHopDaChiDao(id, idPhoPhong, tenPhoPhong, idPhoPhongPhoiHop, tenPhoPhongPhoiHop, idChuyenVien, tenChuyenvien, idChuyenVienPhoiHops, tenChuyenvienPhoiHop, tvNgayThangNam.getText().toString());
                }

                break;

            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBDauViecChoXuLyActivity.class);
                    intent.putExtra("DauViecChoXuLy", id);
                    startActivity(intent);
                    click = true;
                }

                break;
        }
    }

    @Override
    public void onGetPhoPhongBanSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterTenGiamDoc = new AdapterTenGiamDoc(this, giamdocVaPhoGiamdoc, this);
        adapterChonPhoPhongPhoiHop = new AdapterChonPhoPhongPhoiHop(giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void onGetChuyenvienSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterTenChuyenVien = new AdapterTenChuyenVien(giamdocVaPhoGiamdoc, this);
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
    public void onItemClick(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        idPhoPhong = giamdocVaPhoGiamdoc.getId();
        tenPhoPhong = giamdocVaPhoGiamdoc.getHoTen();
        tvChuyenPhoPhong.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        edtChiDao1.setText("Chuyển đ/c " + giamdocVaPhoGiamdoc.getHoTen() + " chủ trì giải quyết.");
        dialog.dismiss();
    }

    @Override
    public void onItemClickChuyenVien(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        idChuyenVien = giamdocVaPhoGiamdoc.getId();
        tenChuyenvien = giamdocVaPhoGiamdoc.getHoTen();
        tvChonChuyenVien1.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        edtChiDao3.setText("Chuyển đ/c " + giamdocVaPhoGiamdoc.getHoTen() + " chủ trì giải quyết.");
        dialog.dismiss();

    }


    @Override
    public NDVBDauViecPhongPhoiHopDaChiDaoChuaHTPresenter createPresenter() {
        return new NDVBDauViecPhongPhoiHopDaChiDaoChuaHTPresenterImpl(this);
    }
}
