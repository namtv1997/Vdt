package com.vpdt.vpdt.ui.activity.VanBanDonViCapHai;

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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.VanBanChoXuLyVBChuTriLV4;
import com.vpdt.vpdt.presenter.NDVBVanBanChoXuLyLV4Presenter;
import com.vpdt.vpdt.presenter.impl.NDVBVanBanChoXuLyLV4PresenterImpl;
import com.vpdt.vpdt.presenter.NDVBVanBanChoXuLyLV4View;
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

public class NDVBVanBanChoXuLyVBChuTriLV4Activity extends BaseActivity<NDVBVanBanChoXuLyLV4Presenter> implements NDVBVanBanChoXuLyLV4View,
        DatePickerDialog.OnDateSetListener, AdapterTenChuyenVien.OnItemClickListenerChuyenVien,
        AdapterChonChuyenVienPhoiHop.OnItemClickListenerChonChuyenVien {

    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvNoiGui)
    TextView tvNoiGui;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvNgayThangNam)
    TextView tvNgayThangNam;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;
    @BindView(R.id.tvCanBoChiDao)
    TextView tvCanBoChiDao;
    @BindView(R.id.tvNoiDungChiDao)
    TextView tvNoiDungChiDao;
    @BindView(R.id.tvDiaDiem)
    TextView tvDiaDiem;
    @BindView(R.id.tvChonChuyenVien2)
    TextView tvChonChuyenVien2;

    @BindView(R.id.edtChiDao3)
    EditText edtChiDao3;
    @BindView(R.id.edtChiDao4)
    EditText edtChiDao4;

    RecyclerView rcTenPhong;
    RecyclerView rcTenPhongPhoiHop;

    AdapterChonChuyenVienPhoiHop adapterChonChuyenVienPhoiHop;
    AdapterTenChuyenVien adapterTenChuyenVien;
    ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdocArrayList = new ArrayList<>();
    AlertDialog dialog;
    int id, idChuyenVien;
    String idChuyenVienPhoiHops;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbvan_ban_cho_xu_ly_vbchu_tri_lv4;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        VanBanChoXuLyVBChuTriLV4 vanBanPhoiHopDaChiDao = getIntent().getParcelableExtra("vanBanChoXuLyVBChuTriLV4");
        getPresenter().getAllChuyenVienDonViCapHai(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""));
        if (vanBanPhoiHopDaChiDao != null) {
            id = vanBanPhoiHopDaChiDao.getId();
            idChuyenVien = vanBanPhoiHopDaChiDao.getIdChuyenVien();
            idChuyenVienPhoiHops = vanBanPhoiHopDaChiDao.getIdChuyenVienPhoiHops();
            tvChonChuyenVien2.setText(String.valueOf(vanBanPhoiHopDaChiDao.getTenChuyenVien()));
            edtChiDao3.setText(String.valueOf(vanBanPhoiHopDaChiDao.getChiDaoChuyenVien()));
            edtChiDao4.setText(String.valueOf(vanBanPhoiHopDaChiDao.getChiDaoChuyenVienPhoiHops()));
            tvSKH.setText(String.valueOf(vanBanPhoiHopDaChiDao.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(vanBanPhoiHopDaChiDao.getSoDen()));
            tvNoiGui.setText(String.valueOf(vanBanPhoiHopDaChiDao.getNoiGui()));
            tvNgay.setText(String.valueOf(vanBanPhoiHopDaChiDao.getNgayNhap()));
            tvTrichYeu.setText(String.valueOf(vanBanPhoiHopDaChiDao.getMoTa() + "\n" + vanBanPhoiHopDaChiDao.getNoiDungVanBan()));
            if (vanBanPhoiHopDaChiDao.getHanGiaiQuyet() != null) {
                if (!vanBanPhoiHopDaChiDao.getHanGiaiQuyet().isEmpty())
                    tvNgayThangNam.setText(String.valueOf(vanBanPhoiHopDaChiDao.getHanGiaiQuyet()));
            }
            tvCanBoChiDao.setText(String.valueOf("Nội dung chỉ đạo của đ/c " + vanBanPhoiHopDaChiDao.getCanBoChiDao()));
            tvNoiDungChiDao.setText(String.valueOf(vanBanPhoiHopDaChiDao.getNoiDungChiDao()));
            if (vanBanPhoiHopDaChiDao.getGiayMoiGio() == null) {
                if (vanBanPhoiHopDaChiDao.getGiayMoiGio().isEmpty()) {
                    tvDiaDiem.setVisibility(View.GONE);
                }
            } else {
                tvDiaDiem.setText(String.valueOf("(Vào hồi: "
                        + vanBanPhoiHopDaChiDao.getGiayMoiGio() + " ngày " + vanBanPhoiHopDaChiDao.getGiayMoiNgay() + ", tại "
                        + vanBanPhoiHopDaChiDao.getGiayMoiDiaDiem() + ")"));
            }

            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanPhoiHopDaChiDao.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBVanBanChoXuLyVBChuTriLV4Activity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onGetChuyenVienSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterTenChuyenVien = new AdapterTenChuyenVien(giamdocVaPhoGiamdoc, this);
        adapterChonChuyenVienPhoiHop = new AdapterChonChuyenVienPhoiHop(giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void onGetDuyetSuccess() {
        Toast.makeText(this, "Duyệt thành công", Toast.LENGTH_LONG).show();
        finish();
    }

    @OnClick({R.id.btnChonPhoiHop, R.id.tvNgayThangNam, R.id.lnNDVB_DSVB_DaChiDao, R.id.imvBack,
            R.id.btnDuyet, R.id.tvXemChiTiet, R.id.tvChonChuyenVien2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvChonChuyenVien2:
                AlertDialog.Builder buildercv = new AlertDialog.Builder(this);
                LayoutInflater inflatercv = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewcv = inflatercv.inflate(R.layout.dialog_ten_phong, null);
                buildercv.setView(viewcv);
                dialog = buildercv.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManagercv = new LinearLayoutManager(getApplicationContext());
                layoutManagercv.setOrientation(LinearLayoutManager.VERTICAL);
                rcTenPhong = viewcv.findViewById(R.id.rcTenPhong);
                rcTenPhong.setLayoutManager(layoutManagercv);
                rcTenPhong.setAdapter(adapterTenChuyenVien);
                adapterTenChuyenVien.notifyDataSetChanged();
                dialog.show();
                TextView tvChonChuTri1 = viewcv.findViewById(R.id.tvChonChuTri);
                tvChonChuTri1.setText("-- Chọn chuyên viên --");
                tvChonChuTri1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvChonChuyenVien2.setText("");
                        edtChiDao3.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.btnChonPhoiHop:
                AlertDialog.Builder builderphoihop = new AlertDialog.Builder(this);
                LayoutInflater inflaterphoihop = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewphoihop = inflaterphoihop.inflate(R.layout.dialog_chon_phong_ban_phoi_hop, null);
                builderphoihop.setView(viewphoihop);
                builderphoihop.setCancelable(false);
                dialog = builderphoihop.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                Button imgCancel1 = viewphoihop.findViewById(R.id.ivCancel);
                Button btnGhiLai1 = viewphoihop.findViewById(R.id.btnGhiLai);
                LinearLayoutManager layoutManagerPhoihop1 = new LinearLayoutManager(getApplicationContext());
                layoutManagerPhoihop1.setOrientation(LinearLayoutManager.VERTICAL);
                rcTenPhongPhoiHop = viewphoihop.findViewById(R.id.rcTenPhongPhoiHop);
                rcTenPhongPhoiHop.setLayoutManager(layoutManagerPhoihop1);
                rcTenPhongPhoiHop.setAdapter(adapterChonChuyenVienPhoiHop);
                adapterChonChuyenVienPhoiHop.notifyDataSetChanged();
                imgCancel1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        giamdocVaPhoGiamdocArrayList.clear();
                        edtChiDao4.setText("");
                        dialog.dismiss();
                    }
                });
                btnGhiLai1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String chidao2 = "";
                        int index = 0;
                        idChuyenVienPhoiHops = "";
                        for (GiamdocVaPhoGiamdoc item : giamdocVaPhoGiamdocArrayList) {
                            index++;
                            if (index == giamdocVaPhoGiamdocArrayList.size()) {
                                idChuyenVienPhoiHops += item.getId();
                                chidao2 += item.getHoTen() + " phối hợp giải quyết.";
                            } else {
                                idChuyenVienPhoiHops += item.getId() + ",";
                                chidao2 += item.getHoTen() + ", ";
                            }
                        }
                        edtChiDao4.setText(chidao2);
                        dialog.dismiss();
                        giamdocVaPhoGiamdocArrayList.clear();
                    }
                });
                break;
            case R.id.tvNgayThangNam:
                showDatePickerDialog();
                break;
            case R.id.lnNDVB_DSVB_DaChiDao:
                closeKeyboard();
                break;
            case R.id.imvBack:
                finish();
                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBDetailVanBanChoXuLyGQActivity.class);
                    intent.putExtra("idvb", id);
                    startActivity(intent);
                    click = true;
                }
                break;
            case R.id.btnDuyet:
                getPresenter().duyetVBChoXuLyPPChuTriDonViCapHai(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""),
                        id, idChuyenVien, edtChiDao3.getText().toString(), idChuyenVienPhoiHops, edtChiDao4.getText().toString(),
                        tvNgayThangNam.getText().toString());
                break;
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
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
    public void onItemClickChuyenVien(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        idChuyenVien = giamdocVaPhoGiamdoc.getId();
        tvChonChuyenVien2.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        edtChiDao3.setText(giamdocVaPhoGiamdoc.getHoTen() + " chủ trì giải quyết.");
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
    public NDVBVanBanChoXuLyLV4Presenter createPresenter() {
        return new NDVBVanBanChoXuLyLV4PresenterImpl(this);
    }
}