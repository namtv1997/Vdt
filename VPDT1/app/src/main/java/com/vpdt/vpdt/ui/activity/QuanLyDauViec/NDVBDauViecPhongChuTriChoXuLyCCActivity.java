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

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.ItemDauViecPhongChuTriChoXuLy;
import com.vpdt.vpdt.model.ItemDauViecPhongChuTriChoXuLyCC;
import com.vpdt.vpdt.model.MucDanhGia;
import com.vpdt.vpdt.presenter.NDVBDauViecPhongChuTriChoXuLyCCPresenter;
import com.vpdt.vpdt.presenter.NDVBDauViecPhongChuTriChoXuLyCCView;
import com.vpdt.vpdt.presenter.NDVBDauViecPhongChuTriChoXuLyPresenter;
import com.vpdt.vpdt.presenter.NDVBDauViecPhongChuTriChoXuLyView;
import com.vpdt.vpdt.presenter.impl.NDVBDauViecPhongChuTriChoXuLyCCPresenterImpl;
import com.vpdt.vpdt.presenter.impl.NDVBDauViecPhongChuTriChoXuLyPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterChonChuyenVienPhoiHop;
import com.vpdt.vpdt.ui.adapter.AdapterChonPhoPhongPhoiHop;
import com.vpdt.vpdt.ui.adapter.AdapterChonPhoiHopPhongChuTri;
import com.vpdt.vpdt.ui.adapter.AdapterMucDanhGia;
import com.vpdt.vpdt.ui.adapter.AdapterTenChuyenVien;
import com.vpdt.vpdt.ui.adapter.AdapterTenGiamDoc;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDauViecPhongChuTriChoXuLyCCActivity extends BaseActivity<NDVBDauViecPhongChuTriChoXuLyCCPresenter> implements NDVBDauViecPhongChuTriChoXuLyCCView,
        DatePickerDialog.OnDateSetListener, AdapterMucDanhGia.OnItemClickListener, AdapterChonPhoiHopPhongChuTri.OnItemClickListenerPhoPhongPhoiHop {
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
    @BindView(R.id.tvChonPhongChuTri)
    TextView tvChonPhongChuTri;
    @BindView(R.id.tvNgayThangNam)
    TextView tvNgayThangNam;

    @BindView(R.id.edtChiDao1)
    EditText edtChiDao1;
    @BindView(R.id.edtChiDao2)
    EditText edtChiDao2;

    AdapterMucDanhGia adapterMucDanhGia;
    AdapterChonPhoiHopPhongChuTri adapterChonPhoiHopPhongChuTri;
    ArrayList<MucDanhGia> giamdocVaPhoGiamdocArrayList = new ArrayList<>();
    AlertDialog dialog;
    RecyclerView rcTenPhoPhong;
    RecyclerView rcTenChuyenVien;
    String idPhongPhoiHop, tenPhongPhoiHop, tenPhongBan;
    boolean click = false;
    int id, idPhongBan;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvb_dau_viec_phong_chu_tri_cho_xu_ly_cc;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        getPresenter().getAllPhongBanChiCuc();
        ItemDauViecPhongChuTriChoXuLyCC itemDanhSachDauViecQuaHanCuaPhong = getIntent().getParcelableExtra("itemDauViecPhongChuTriChoXuLyCC");
        if (itemDanhSachDauViecQuaHanCuaPhong != null) {
            String shortDate = itemDanhSachDauViecQuaHanCuaPhong.getNgayNhap();
            id = itemDanhSachDauViecQuaHanCuaPhong.getId();
            tvNgay.setText(shortDate.substring(0, 5));
            tvHanVanBan.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getHanVanBan()));
            tvChonPhongChuTri.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getTenPhongChuTri()));
            tvNgayThangNam.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getHanXuLy()));
            tvNguoiNhap.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getNguoiNhap()));
            tvTrichYeu.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getMoTa()));
            tvNgayNhap.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getNgayNhap()));
            tvCanBoChiDao.setText(String.valueOf("Nội dung chỉ đạo cảu đ/c " + itemDanhSachDauViecQuaHanCuaPhong.getCanBoChiDao() + ": "));
            tvNoiDungChiDao.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getNoiDungChiDao()));
            edtChiDao1.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getChiDao()));
            edtChiDao2.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getChidaoChuTri()));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack, R.id.tvXemChiTiet, R.id.lnNoiDungVB, R.id.btnChonPhoiHop,
            R.id.tvChonPhongChuTri, R.id.tvNgayThangNam, R.id.btnDuyet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvNgayThangNam:
                showDatePickerDialog();
                break;
            case R.id.lnNoiDungVB:
                closeKeyboard();
                break;
            case R.id.btnChonPhoiHop:
                if (tvChonPhongChuTri.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Chưa chọn phòng chủ trì", Toast.LENGTH_SHORT).show();
                } else {
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
                    rcTenPhoPhong.setAdapter(adapterChonPhoiHopPhongChuTri);
                    adapterChonPhoiHopPhongChuTri.notifyDataSetChanged();
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
                            for (MucDanhGia item : giamdocVaPhoGiamdocArrayList) {
                                index++;
                                if (index == giamdocVaPhoGiamdocArrayList.size()) {
                                    idPhongPhoiHop += item.getId();
                                    tenPhongPhoiHop += item.getName();
                                    chidao2 += item.getName() + " phối hợp giải quyết.";
                                } else {
                                    idPhongPhoiHop += item.getId() + ",";
                                    tenPhongPhoiHop += item.getName() + ",";
                                    chidao2 += item.getName() + ", ";
                                }
                            }
                            edtChiDao2.setText(chidao2);
                            giamdocVaPhoGiamdocArrayList.clear();
                            dialog.dismiss();
                        }
                    });
                }
                break;
            case R.id.tvChonPhongChuTri:
                AlertDialog.Builder builderChuyenVien = new AlertDialog.Builder(this);
                LayoutInflater inflaterChuyenVien = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewChuyenVien = inflaterChuyenVien.inflate(R.layout.dialog_ten_chuyen_vien, null);
                builderChuyenVien.setView(viewChuyenVien);
                dialog = builderChuyenVien.create();
                LinearLayoutManager layoutManagerChuyenVien = new LinearLayoutManager(getApplicationContext());
                layoutManagerChuyenVien.setOrientation(LinearLayoutManager.VERTICAL);
                rcTenChuyenVien = viewChuyenVien.findViewById(R.id.rcTenGiamDoc);
                rcTenChuyenVien.setLayoutManager(layoutManagerChuyenVien);
                rcTenChuyenVien.setAdapter(adapterMucDanhGia);
                adapterMucDanhGia.notifyDataSetChanged();
                dialog.show();
                TextView tvChonChuyenVien = viewChuyenVien.findViewById(R.id.tvChonChuyenVien);
                tvChonChuyenVien.setText("-- Chọn phòng chủ trì --");
                tvChonChuyenVien.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvChonPhongChuTri.setText("");
                        edtChiDao1.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.btnDuyet:
                getPresenter().duyetDauViecPhongChuTriChoXuLyCC(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""), id, idPhongBan, tenPhongBan, idPhongPhoiHop, tenPhongPhoiHop, tvNgayThangNam.getText().toString());
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
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetPhongBanChiCucSuccess(ArrayList<MucDanhGia> mucDanhGias) {
        adapterMucDanhGia = new AdapterMucDanhGia(this, mucDanhGias, this);
        adapterChonPhoiHopPhongChuTri = new AdapterChonPhoiHopPhongChuTri(mucDanhGias, this);
    }

    @Override
    public void onDuyetSuccess() {
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
    public NDVBDauViecPhongChuTriChoXuLyCCPresenter createPresenter() {
        return new NDVBDauViecPhongChuTriChoXuLyCCPresenterImpl(this);
    }

    @Override
    public void onItemClick(MucDanhGia mucDanhGia) {
        idPhongBan = mucDanhGia.getId();
        tenPhongBan = mucDanhGia.getName();
        tvChonPhongChuTri.setText(String.valueOf(mucDanhGia.getName()));
        edtChiDao1.setText(mucDanhGia.getName() + " chủ trì giải quyết.");
        dialog.dismiss();
    }

    @Override
    public void onItemClickPhoPhongPhoiHop(MucDanhGia mucDanhGia) {
        if (giamdocVaPhoGiamdocArrayList.contains(mucDanhGia)) {
            giamdocVaPhoGiamdocArrayList.remove(mucDanhGia);
        } else {
            giamdocVaPhoGiamdocArrayList.add(mucDanhGia);
        }
    }
}