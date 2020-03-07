package com.vpdt.vpdt.ui.activity.XuLyGiayMoi;

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

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.GMGiaoPhongPhoiHopDaChiDao;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.presenter.NDVB_GMGiaoPhongPhoiHopDaChiDaoPresenter;
import com.vpdt.vpdt.presenter.NDVB_GMGiaoPhongPhoiHopDaChiDaoView;
import com.vpdt.vpdt.presenter.impl.NDVB_GMGiaoPhongPhoiHopDaChiDaoPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterChonChuyenVienPhoiHop;
import com.vpdt.vpdt.ui.adapter.AdapterChonPhoPhongPhoiHop;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.ui.adapter.AdapterTenGiamDoc;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBGiayMoiGiaoPhongPhoiHopDaChiDaoActivity extends BaseActivity<NDVB_GMGiaoPhongPhoiHopDaChiDaoPresenter> implements
        NDVB_GMGiaoPhongPhoiHopDaChiDaoView,
        DatePickerDialog.OnDateSetListener,
        AdapterChonChuyenVienPhoiHop.OnItemClickListenerChonChuyenVien,
        AdapterChonPhoPhongPhoiHop.OnItemClickListenerPhoPhongPhoiHop, AdapterTenGiamDoc.OnItemClickListener {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvNoiGui)
    TextView tvNoiGui;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.edtChiDao1)
    EditText edtChiDao1;
    @BindView(R.id.edtChiDao2)
    EditText edtChiDao2;
    @BindView(R.id.tvChuyenPhoPhong)
    TextView tvChuyenPhoPhong;
    @BindView(R.id.tvNgayThangNam)
    TextView tvNgayThangNam;
    @BindView(R.id.tvXemFileDinhKem)
    TextView tvXemFileDinhKem;
    @BindView(R.id.rcvTrinhTuXuLy)
    RecyclerView rcvTrinhTuXuLy;

    AdapterChonChuyenVienPhoiHop adapterChonChuyenVienPhoiHop;
    AdapterChonPhoPhongPhoiHop adapterChonPhoPhongPhoiHop;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;
    AdapterTenGiamDoc adapterTenGiamDoc;
    ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdocArrayList = new ArrayList<>();
    int idgiaymoi, idPhoPhong;
    String idPhoPhongPhoiHop = "";
    String idChuyenVienPhoiHops = "";
    AlertDialog dialog;
    RecyclerView rcTenPhoPhong;
    RecyclerView rcTenPhoGiamDoc;
    boolean click = false;


    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbgiay_moi_giao_phong_phoi_hop_da_chi_dao;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        GMGiaoPhongPhoiHopDaChiDao gmGiaoPhongPhoiHopDaChiDao = getIntent().getParcelableExtra("gmGiaoPhongPhoiHopDaChiDao");
        getPresenter().getAllChuyenVien();
        getPresenter().getAllPhoPhongBan();
        if (gmGiaoPhongPhoiHopDaChiDao != null) {
            idgiaymoi = gmGiaoPhongPhoiHopDaChiDao.getId();
            idPhoPhong = gmGiaoPhongPhoiHopDaChiDao.getIdPhoPhong();
            idChuyenVienPhoiHops = gmGiaoPhongPhoiHopDaChiDao.getIdChuyenVienPhoiHops();
            idPhoPhongPhoiHop = gmGiaoPhongPhoiHopDaChiDao.getIdPhoPhongPhoiHops();
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) gmGiaoPhongPhoiHopDaChiDao.getTrinhTuXuLy());
            String shortdate = gmGiaoPhongPhoiHopDaChiDao.getNgayNhap();
            tvNgay.setText(String.valueOf(shortdate.substring(0, 5)));
            tvSKH.setText(String.valueOf(gmGiaoPhongPhoiHopDaChiDao.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(gmGiaoPhongPhoiHopDaChiDao.getSoDen()));
            tvNoiGui.setText(String.valueOf(gmGiaoPhongPhoiHopDaChiDao.getNoiGui()));
            tvTrichYeu.setText(String.valueOf(gmGiaoPhongPhoiHopDaChiDao.getMoTa()));
            tvChuyenPhoPhong.setText(String.valueOf(gmGiaoPhongPhoiHopDaChiDao.getTenPhoPhong()));
            edtChiDao2.setText(String.valueOf(gmGiaoPhongPhoiHopDaChiDao.getChiDaoChuTri()));
            edtChiDao1.setText(String.valueOf(gmGiaoPhongPhoiHopDaChiDao.getChiDao()));
            tvNgayThangNam.setText(String.valueOf(gmGiaoPhongPhoiHopDaChiDao.getHanGiaiQuyet()));
            tvXemFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(gmGiaoPhongPhoiHopDaChiDao.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBGiayMoiGiaoPhongPhoiHopDaChiDaoActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
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

    @OnClick({R.id.tvXemChiTiet, R.id.imvBack, R.id.tvNgayThangNam, R.id.tvChuyenPhoPhong, R.id.lnNoiDungVB,
            R.id.btnChonPhoPhongPhoiHop, R.id.btnChonChuyenVienPhoiHop, R.id.btnDuyet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBGiayMoiGiaoPhongPhoiHopDaChiDaoActivity.class);
                    intent.putExtra("gmGiaoPhongPhoiHopDaChiDao", idgiaymoi);
                    startActivity(intent);
                    click = true;
                }

                break;
            case R.id.imvBack:
                finish();
                break;
            case R.id.tvNgayThangNam:
                showDatePickerDialog();
                break;
            case R.id.lnNoiDungVB:
                closeKeyboard();
                break;
            case R.id.tvChuyenPhoPhong:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.dialog_ten_pho_phong, null);
                builder.setView(view1);
                dialog = builder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView btnChuyenPhoPhong = view1.findViewById(R.id.btnChuyenPhoPhong);
                btnChuyenPhoPhong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edtChiDao1.setText("");
                        tvChuyenPhoPhong.setText("");
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
            case R.id.btnChonPhoPhongPhoiHop:
                AlertDialog.Builder builderphophong = new AlertDialog.Builder(this);
                LayoutInflater inflaterphophong = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewphophong = inflaterphophong.inflate(R.layout.dialog_chon_phong_ban_phoi_hop, null);
                builderphophong.setView(viewphophong);
                builderphophong.setCancelable(false);
                dialog = builderphophong.create();
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

                        String chidao2 = "Chuyển PP " + tvChuyenPhoPhong.getText() + " chủ trì. ";
                        int index = 0;
                        idPhoPhongPhoiHop = "";
                        for (GiamdocVaPhoGiamdoc item : giamdocVaPhoGiamdocArrayList) {

                            index++;
                            if (index == giamdocVaPhoGiamdocArrayList.size()) {
                                idPhoPhongPhoiHop += "" + item.getId();
                                chidao2 += item.getHoTen() + " phối hợp";
                            } else {
                                idPhoPhongPhoiHop += item.getId() + ",";
                                chidao2 += item.getHoTen() + ", ";
                            }
                        }
                        edtChiDao1.setText(chidao2);
                        giamdocVaPhoGiamdocArrayList.clear();
                        dialog.dismiss();

                    }
                });
                break;
            case R.id.btnChonChuyenVienPhoiHop:
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
                        String chidao2 = "Chuyển đ/c ";
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
                        edtChiDao2.setText(chidao2);
                        giamdocVaPhoGiamdocArrayList.clear();
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.btnDuyet:
                String chidao1 = edtChiDao1.getText().toString();
                String chidao2 = edtChiDao2.getText().toString();
                String hangiaiquyet = tvNgayThangNam.getText().toString();
                getPresenter().duyetAllGMGiaoPhongPhoiHopDaChiDao(idgiaymoi, idPhoPhong, idPhoPhongPhoiHop, idChuyenVienPhoiHops, chidao1, chidao2, hangiaiquyet);
                break;
        }
    }

    void recyclerviewTrinhTuChuyenNhan(ArrayList<String> stringArrayList) {
        adapterDeXuatGiaHanChoXuLy = new AdapterDeXuatGiaHanChoXuLy(stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTrinhTuXuLy.setLayoutManager(linearLayoutManager);
        rcvTrinhTuXuLy.setAdapter(adapterDeXuatGiaHanChoXuLy);
        rcvTrinhTuXuLy.setHasFixedSize(true);
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
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetPhoPhongBanSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterTenGiamDoc = new AdapterTenGiamDoc(this, giamdocVaPhoGiamdoc, this);
        adapterChonPhoPhongPhoiHop = new AdapterChonPhoPhongPhoiHop(giamdocVaPhoGiamdoc, this);
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
    public NDVB_GMGiaoPhongPhoiHopDaChiDaoPresenter createPresenter() {
        return new NDVB_GMGiaoPhongPhoiHopDaChiDaoPresenterImpl(this);
    }

    @Override
    public void onItemClick(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        idPhoPhong = giamdocVaPhoGiamdoc.getId();
        tvChuyenPhoPhong.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        edtChiDao1.setText("Chuyển PP " + giamdocVaPhoGiamdoc.getHoTen());
        dialog.dismiss();
    }
}
