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

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.VanBanPhoiHopChoXuLy;
import com.vpdt.vpdt.presenter.NDVBVanBanPhoiHopChoXuLyPresenter;
import com.vpdt.vpdt.presenter.NDVBVanBanPhoiHopChoXuLyView;
import com.vpdt.vpdt.presenter.impl.NDVBVanBanPhoiHopChoXuLyPresenterImpl;
import com.vpdt.vpdt.ui.activity.XuLyGiayMoi.TTVBGiayMoiGiaoPhongPhoiHopDaChiDaoActivity;
import com.vpdt.vpdt.ui.adapter.AdapterChonChuyenVienPhoiHop;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBVanBanPhoiHopChoXuLyActivity extends BaseActivity<NDVBVanBanPhoiHopChoXuLyPresenter> implements NDVBVanBanPhoiHopChoXuLyView,
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

    @BindView(R.id.tvChiDao1NDVBDSVBDenChoLDXL)
    EditText tvChiDao1NDVBDSVBDenChoLDXL;
    @BindView(R.id.tvChiDao2NDVBDSVBDenChoLDXL)
    EditText tvChiDao2NDVBDSVBDenChoLDXL;

    @BindView(R.id.rcvTrinhTuXuLy1)
    RecyclerView rcvTrinhTuXuLy1;

    @BindView(R.id.btnTuChoi)
    Button btnTuChoi;

    @BindView(R.id.lnNoiDungVB)
    LinearLayout lnNoiDungVB;
    @BindView(R.id.imDown)
    ImageView imDown;


    EditText edtNoiDungTuChoi;
    RecyclerView rcTenChuyenVien;
    int idvb, idPhoPhong, level;
    String idcChuyenVienPhoiHop, idPhoiHop;
    AlertDialog dialog;
    ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdocArrayList = new ArrayList<>();
    AdapterChonChuyenVienPhoiHop adapterChonChuyenVienPhoiHop;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbvan_ban_phoi_hop_cho_xu_ly;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        level = PrefUtil.getInt(this, Key.LEVEL, 0);
        if (level == 7) {
            imDown.setVisibility(View.GONE);
            btnTuChoi.setVisibility(View.VISIBLE);
        }
        getPresenter().getAllChuyenVien();
        VanBanPhoiHopChoXuLy vanBanPhoiHopChoXuLy = getIntent().getParcelableExtra("vanBanPhoiHopChoXuLy");
        if (vanBanPhoiHopChoXuLy != null) {
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) vanBanPhoiHopChoXuLy.getTrinhTuXuLy());
            if (vanBanPhoiHopChoXuLy.getAllowTuChoi()) {
                btnTuChoi.setVisibility(View.VISIBLE);
            }
            idvb = vanBanPhoiHopChoXuLy.getId();
            idPhoPhong = vanBanPhoiHopChoXuLy.getIdPhoPhong();
            idcChuyenVienPhoiHop = vanBanPhoiHopChoXuLy.getIdChuyenVienPhoiHops();
            idPhoiHop = String.valueOf(vanBanPhoiHopChoXuLy.getIdPhoiHop());
            String shortdate = vanBanPhoiHopChoXuLy.getNgayNhap();
            tvNgay.setText(shortdate.substring(0, 5));
            tvSKH.setText(String.valueOf(vanBanPhoiHopChoXuLy.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(vanBanPhoiHopChoXuLy.getSoDen()));
            tvNoigui.setText(String.valueOf(vanBanPhoiHopChoXuLy.getNoiGui()));
            tvTrichYeuNDVBDSVBDenChoLDXL.setText(String.valueOf(vanBanPhoiHopChoXuLy.getMoTa()));
            tvChuyenPhoPhong.setText(String.valueOf(vanBanPhoiHopChoXuLy.getTenPhoPhong()));
            tvNgayThangNamNDVBDSVBDenChoLDXL.setText(String.valueOf(vanBanPhoiHopChoXuLy.getHanGiaiQuyet()));
            tvChiDao1NDVBDSVBDenChoLDXL.setText(String.valueOf(vanBanPhoiHopChoXuLy.getChiDao()));
            tvChiDao2NDVBDSVBDenChoLDXL.setText(String.valueOf(vanBanPhoiHopChoXuLy.getChiDaoChuTri()));
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanPhoiHopChoXuLy.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBVanBanPhoiHopChoXuLyActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
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
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onTuChoiSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NDVBVanBanPhoiHopChoXuLyPresenter createPresenter() {
        return new NDVBVanBanPhoiHopChoXuLyPresenterImpl(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnChonPhoPhong, R.id.tvNgayThangNamNDVBDSVBDenChoLDXL,
            R.id.tvXemChiTietNDVBDSVBDenChoLDXL,
            R.id.lnNoiDungVB, R.id.btnBack, R.id.tvDuyetNDVBDSVBDenChoLDXL, R.id.btnTuChoi})
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
                        tvChiDao2NDVBDSVBDenChoLDXL.setText(chidao2);
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
                    Intent intent = new Intent(this, TTVBGiayMoiGiaoPhongPhoiHopDaChiDaoActivity.class);
                    intent.putExtra("gmGiaoPhongPhoiHopDaChiDao", idvb);
                    startActivity(intent);
                    click = true;
                }

                break;

            case R.id.tvDuyetNDVBDSVBDenChoLDXL:

                getPresenter().duyetVBPhongPhoiHopChoXuLy(idvb, idPhoPhong, "", idcChuyenVienPhoiHop, tvChiDao1NDVBDSVBDenChoLDXL.getText().toString(), tvChiDao2NDVBDSVBDenChoLDXL.getText().toString(), tvNgayThangNamNDVBDSVBDenChoLDXL.getText().toString());
                break;
            case R.id.btnTuChoi:
                AlertDialog.Builder buildertuchoi = new AlertDialog.Builder(this);
                LayoutInflater inflatertuchoi = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewtuchoi = inflatertuchoi.inflate(R.layout.dialog_tuchoi_ketquahoanthanh_cho_phe_duyet, null);
                buildertuchoi.setView(viewtuchoi);
                dialog = buildertuchoi.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                edtNoiDungTuChoi = viewtuchoi.findViewById(R.id.edtNoiDungTuChoi);
                Button btnDong1 = viewtuchoi.findViewById(R.id.btnDong);
                Button btnChuyenChanhVanBan = viewtuchoi.findViewById(R.id.btnChuyenChanhVanBan);
                btnChuyenChanhVanBan.setText("Chuyển về Trưởng phòng");
                btnDong1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btnChuyenChanhVanBan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().tuChoiVBPhoiHopChoXuLy(idPhoiHop, edtNoiDungTuChoi.getText().toString());
                    }
                });
                dialog.show();
                break;

        }
    }

    void recyclerviewTrinhTuChuyenNhan(ArrayList<String> stringArrayList) {
        adapterDeXuatGiaHanChoXuLy = new AdapterDeXuatGiaHanChoXuLy(stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTrinhTuXuLy1.setLayoutManager(linearLayoutManager);
        rcvTrinhTuXuLy1.setAdapter(adapterDeXuatGiaHanChoXuLy);
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
