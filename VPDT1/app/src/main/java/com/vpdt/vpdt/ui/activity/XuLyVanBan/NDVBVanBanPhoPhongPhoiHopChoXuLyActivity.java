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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.VBPhoPhongPhoiHopChoXL;
import com.vpdt.vpdt.presenter.NDVBVanBanPhoPhongPhoiHopChoXuLyPresenter;
import com.vpdt.vpdt.presenter.NDVBVanBanPhoPhongPhoiHopChoXuLyView;
import com.vpdt.vpdt.presenter.impl.NDVBVanBanPhoPhongPhoiHopChoXuLyPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterChonChuyenVienPhoiHop;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBVanBanPhoPhongPhoiHopChoXuLyActivity extends BaseActivity<NDVBVanBanPhoPhongPhoiHopChoXuLyPresenter> implements NDVBVanBanPhoPhongPhoiHopChoXuLyView,
        DatePickerDialog.OnDateSetListener, AdapterChonChuyenVienPhoiHop.OnItemClickListenerChonChuyenVien {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvNoigui)
    TextView tvNoigui;
    @BindView(R.id.tvTrichYeuNDVBDSVBDenChoLDXL)
    TextView tvTrichYeuNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvChuyenPhoPhong)
    TextView tvChuyenPhoPhong;
    @BindView(R.id.tvNgayThangNamNDVBDSVBDenChoLDXL)
    TextView tvNgayThangNamNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;

    @BindView(R.id.tvChiDao1)
    EditText tvChiDao1;
    @BindView(R.id.tvChiDao2)
    EditText tvChiDao2;

    @BindView(R.id.rcvTrinhTuXuLy)
    RecyclerView rcvTrinhTuXuLy;

    @BindView(R.id.lnNoiDungVB)
    LinearLayout lnNoiDungVB;
    boolean click = false;
    RecyclerView rcTenChuyenVien;
    int idvb, idPhoPhong;
    String idcChuyenVienPhoiHop, idPhoiHop;
    AlertDialog dialog;
    ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdocArrayList = new ArrayList<>();
    AdapterChonChuyenVienPhoiHop adapterChonChuyenVienPhoiHop;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbvan_ban_pho_phong_phoi_hop_cho_xu_ly;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        getPresenter().getAllChuyenVien();
        VBPhoPhongPhoiHopChoXL vbPhoPhongPhoiHopChoXL = getIntent().getParcelableExtra("vbPhoPhongPhoiHopChoXLZZz");
        if (vbPhoPhongPhoiHopChoXL != null) {
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) vbPhoPhongPhoiHopChoXL.getTrinhTuXuLy());
            idvb = vbPhoPhongPhoiHopChoXL.getId();
            idPhoPhong = vbPhoPhongPhoiHopChoXL.getIdPhoPhong();
            idcChuyenVienPhoiHop = vbPhoPhongPhoiHopChoXL.getIdChuyenVienPhoiHops();
            idPhoiHop = String.valueOf(vbPhoPhongPhoiHopChoXL.getIdPhoiHop());
            String shortdate = vbPhoPhongPhoiHopChoXL.getNgayNhap();
            tvNgay.setText(shortdate.substring(0, 5));
            tvSKH.setText(String.valueOf(vbPhoPhongPhoiHopChoXL.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(vbPhoPhongPhoiHopChoXL.getSoDen()));
            tvNoigui.setText(String.valueOf(vbPhoPhongPhoiHopChoXL.getNoiGui()));
            tvTrichYeuNDVBDSVBDenChoLDXL.setText(String.valueOf(vbPhoPhongPhoiHopChoXL.getMoTa()));
            tvChuyenPhoPhong.setText(String.valueOf(vbPhoPhongPhoiHopChoXL.getTenPhoPhong()));
            tvNgayThangNamNDVBDSVBDenChoLDXL.setText(String.valueOf(vbPhoPhongPhoiHopChoXL.getHanGiaiQuyet()));
            tvChiDao1.setText(String.valueOf(vbPhoPhongPhoiHopChoXL.getChiDao()));
            tvChiDao2.setText(String.valueOf(vbPhoPhongPhoiHopChoXL.getChiDaoChuTri()));
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vbPhoPhongPhoiHopChoXL.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBVanBanPhoPhongPhoiHopChoXuLyActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetChuyenvienSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterChonChuyenVienPhoiHop = new AdapterChonChuyenVienPhoiHop(giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void onDuyetSuccess() {
        Toast.makeText(this, "Đã duyệt", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NDVBVanBanPhoPhongPhoiHopChoXuLyPresenter createPresenter() {
        return new NDVBVanBanPhoPhongPhoiHopChoXuLyPresenterImpl(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnChonPhoPhong, R.id.tvNgayThangNamNDVBDSVBDenChoLDXL,
            R.id.tvXemChiTietNDVBDSVBDenChoLDXL,
            R.id.lnNoiDungVB, R.id.btnBack, R.id.btnDuyet,})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnChonPhoPhong:
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

                        String chidao2 = "Chuyển đ/c ";
                        int index = 0;
                        idcChuyenVienPhoiHop = "";
                        for (GiamdocVaPhoGiamdoc item : giamdocVaPhoGiamdocArrayList) {

                            index++;
                            if (index == giamdocVaPhoGiamdocArrayList.size()) {
                                idcChuyenVienPhoiHop += "" + item.getId();
                                chidao2 += item.getHoTen() + " phối hợp giải quyết.";
                            } else {
                                idcChuyenVienPhoiHop += item.getId() + ",";
                                chidao2 += item.getHoTen() + ", ";
                            }
                        }
                        tvChiDao2.setText(chidao2);
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
                    Intent intent = new Intent(this, TTVBVanBanPhoiHopDaChiDaoActivity.class);
                    intent.putExtra("idvb", idvb);
                    startActivity(intent);
                    click = true;
                }

                break;

            case R.id.btnDuyet:
                String chidao2 = tvChiDao2.getText().toString();
                String hxl = tvNgayThangNamNDVBDSVBDenChoLDXL.getText().toString();
                getPresenter().duyetVBPhoPhongPhoiHopChoXuLy(idvb, idPhoPhong, idPhoiHop, idcChuyenVienPhoiHop, chidao2, hxl);
                break;

        }
    }

    void recyclerviewTrinhTuChuyenNhan(ArrayList<String> stringArrayList) {
        adapterDeXuatGiaHanChoXuLy = new AdapterDeXuatGiaHanChoXuLy(stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTrinhTuXuLy.setLayoutManager(linearLayoutManager);
        rcvTrinhTuXuLy.setAdapter(adapterDeXuatGiaHanChoXuLy);
        adapterDeXuatGiaHanChoXuLy.notifyDataSetChanged();
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
