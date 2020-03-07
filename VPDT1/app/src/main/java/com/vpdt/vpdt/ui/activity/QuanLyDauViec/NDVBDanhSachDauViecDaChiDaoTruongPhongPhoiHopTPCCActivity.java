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
import com.vpdt.vpdt.model.ItemDauViecPhongChuTriDaChiDaoChuaHoanThanh;
import com.vpdt.vpdt.presenter.NDVBDauViecPhongChuTriChoXuLyTPCCPresenter;
import com.vpdt.vpdt.presenter.NDVBDauViecPhongChuTriChoXuLyViewTPCC;
import com.vpdt.vpdt.presenter.impl.NDVBDauViecPhongChuTriChoXuLyTPCCPresenterImpl;
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

public class NDVBDanhSachDauViecDaChiDaoTruongPhongPhoiHopTPCCActivity extends BaseActivity<NDVBDauViecPhongChuTriChoXuLyTPCCPresenter> implements NDVBDauViecPhongChuTriChoXuLyViewTPCC,
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

    @BindView(R.id.tvChonPhoPhong)
    TextView tvChonPhoPhong;
    @BindView(R.id.tvChonChuyenVien2)
    TextView tvChonChuyenVien2;
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

    AdapterChonChuyenVienPhoiHop adapterChonChuyenVienPhoiHop;
    AdapterChonPhoPhongPhoiHop adapterChonPhoPhongPhoiHop;
    AdapterTenChuyenVien adapterTenChuyenVien;
    AdapterTenGiamDoc adapterTenGiamDoc;
    ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdocArrayList = new ArrayList<>();
    int idChuyenVien, idPhoPhong, id;
    String idPhoPhongPhoiHop = "", tenPhoPhongPhoiHop, tenChuyenvienPhoiHop;
    String idChuyenVienPhoiHops = "";
    AlertDialog dialog;
    RecyclerView rcTenPhoPhong;
    RecyclerView rcTenPhoGiamDoc;
    RecyclerView rcTenChuyenVien;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvb_danh_sach_dau_viec_da_chi_dao_truong_phong_phoi_hop_tpcc;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        getPresenter().getAlCVPhongBanCC(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""));
        getPresenter().getAllPhoPhongBanCC(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""));
        ItemDauViecPhongChuTriDaChiDaoChuaHoanThanh itemDanhSachDauViecQuaHanCuaPhong = getIntent().getParcelableExtra("itemDauViecPhongChuTriChoXuLyTCC");
        if (itemDanhSachDauViecQuaHanCuaPhong != null) {
            String shortDate = itemDanhSachDauViecQuaHanCuaPhong.getNgayNhap();
            id = itemDanhSachDauViecQuaHanCuaPhong.getId();
            idPhoPhong = itemDanhSachDauViecQuaHanCuaPhong.getIdPhoPhong();
            idChuyenVien = itemDanhSachDauViecQuaHanCuaPhong.getIdPhoPhong();
            idPhoPhongPhoiHop = itemDanhSachDauViecQuaHanCuaPhong.getIdPhoPhongPhoiHops();
            idChuyenVienPhoiHops = itemDanhSachDauViecQuaHanCuaPhong.getIdChuyenVienPhoiHops();
            tenPhoPhongPhoiHop = itemDanhSachDauViecQuaHanCuaPhong.getTenPhoPhongPhoiHops();
            tenChuyenvienPhoiHop = itemDanhSachDauViecQuaHanCuaPhong.getTenPhoPhongPhoiHops();
            tvNgay.setText(shortDate.substring(0, 5));
            tvHanVanBan.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getHanVanBan()));
            tvNgayThangNam.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getHanXuLy()));
            tvNguoiNhap.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getNguoiNhap()));
            tvTrichYeu.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getMoTa()));
            tvNgayNhap.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getNgayNhap()));
            tvCanBoChiDao.setText(String.valueOf("*Nội dung chỉ đạo của đ/c " + itemDanhSachDauViecQuaHanCuaPhong.getCanBoChiDao() + ":"));
            tvNoiDungChiDao.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getNoiDungChiDao()));
            tvChonPhoPhong.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getTenPhoPhong()));
            tvChonChuyenVien2.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getTenChuyenVien()));
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
            R.id.btnChonPhoPhongPhoiHop,
            R.id.btnChonPhoiHop,
            R.id.tvChonPhoPhong,
            R.id.tvChonChuyenVien2,
            R.id.tvNgayThangNam,
            R.id.btnDuyet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBDauViecChoXuLyActivity.class);
                    intent.putExtra("DauViecChoXuLy", id);
                    startActivity(intent);
                    click = true;
                }
                break;
            case R.id.lnNoiDungVB:
                closeKeyboard();
                break;
            case R.id.btnChonPhoPhongPhoiHop:
                if (tvChonPhoPhong.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Chưa chọn Phó phòng", Toast.LENGTH_SHORT).show();
                } else {
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
                }
                break;
            case R.id.btnChonPhoiHop:
                if (tvChonChuyenVien2.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Chưa chọn chuyên viên", Toast.LENGTH_SHORT).show();
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
                }
                break;
            case R.id.tvChonPhoPhong:
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
                        edtChiDao1.setText("");
                        tvChonPhoPhong.setText("");

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
            case R.id.tvChonChuyenVien2:
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
                        tvChonChuyenVien2.setText("");
                        edtChiDao3.setText("");

                        dialog.dismiss();
                    }
                });
                break;
            case R.id.tvNgayThangNam:
                showDatePickerDialog();
                break;
            case R.id.btnDuyet:
                getPresenter().duyetDauViecTruongPhongPhoHopCT(PrefUtil.getString(NDVBDanhSachDauViecDaChiDaoTruongPhongPhoiHopTPCCActivity.this, Key.NAM_LAM_VIEC, ""),
                        id, idPhoPhong, tvChonPhoPhong.getText().toString(), idPhoPhongPhoiHop, tenPhoPhongPhoiHop, idChuyenVien, tvChonChuyenVien2.getText().toString(),
                        idChuyenVienPhoiHops, tenChuyenvienPhoiHop, tvNgayThangNam.getText().toString());
                break;

        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetPhoPhongBanSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterTenGiamDoc = new AdapterTenGiamDoc(this, giamdocVaPhoGiamdoc, this);
        adapterChonPhoPhongPhoiHop = new AdapterChonPhoPhongPhoiHop(giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void onGetPhongBanSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
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
        tvChonPhoPhong.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        edtChiDao1.setText("Chuyển đ/c " + giamdocVaPhoGiamdoc.getHoTen() + " chủ trì giải quyết.");
        dialog.dismiss();
    }

    @Override
    public void onItemClickChuyenVien(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        idChuyenVien = giamdocVaPhoGiamdoc.getId();
        tvChonChuyenVien2.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        edtChiDao3.setText("Chuyển đ/c " + giamdocVaPhoGiamdoc.getHoTen() + " chủ trì giải quyết.");
        dialog.dismiss();

    }

    @Override
    public NDVBDauViecPhongChuTriChoXuLyTPCCPresenter createPresenter() {
        return new NDVBDauViecPhongChuTriChoXuLyTPCCPresenterImpl(this);
    }
}