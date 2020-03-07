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
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.VanBanPhoiHopDaChiDao;
import com.vpdt.vpdt.presenter.NDVBVanBanPhoiHopDaChiDaoPresenter;
import com.vpdt.vpdt.presenter.NDVBVanBanPhoiHopDaChiDaoView;
import com.vpdt.vpdt.presenter.impl.NDVBVanBanPhoiHopDaChiDaoPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterChonChuyenVienPhoiHop;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.ui.adapter.AdapterTenGiamDoc;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBVanBanPhoiHopDaChiDaoPhoPhongActivity extends BaseActivity<NDVBVanBanPhoiHopDaChiDaoPresenter> implements NDVBVanBanPhoiHopDaChiDaoView,
        DatePickerDialog.OnDateSetListener,
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
    @BindView(R.id.tvChonPhoPhong)
    TextView tvChonPhoPhong;
    @BindView(R.id.tvNgayThangNam)
    TextView tvNgayThangNam;
    @BindView(R.id.tvChiDao1)
    TextView tvChiDao1;
    @BindView(R.id.tvChiDao2)
    TextView tvChiDao2;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;

    @BindView(R.id.rvTrinhTuXuLy)
    RecyclerView rvTrinhTuXuLy;

    RecyclerView rcTenPhoPhong;
    RecyclerView rcTenGiamDoc;

    AlertDialog dialog;
    AdapterTenGiamDoc adapterTenGiamDoc;
    AdapterChonChuyenVienPhoiHop adapterChonChuyenVienPhoiHop;
    //    AdapterChonPhoPhongPhoiHop adapterChonPhoPhongPhoiHop;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;
    ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdocArrayList = new ArrayList<>();
    int idvb, idPhoPhong, idPhoiHop;
    String idPhoPhongPhoiHop = "";
    String idChuyenVienPhoiHops = "";
    EditText edtNoiDungTuChoi;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbvan_ban_phoi_hop_da_chi_dao_pho_phong;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        VanBanPhoiHopDaChiDao vanBanPhoiHopDaChiDao = getIntent().getParcelableExtra("vanBanPhoiHopDaChiDao");
        getPresenter().getAllChuyenVien();
        getPresenter().getAllPhoPhongBan();
        if (vanBanPhoiHopDaChiDao != null) {
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) vanBanPhoiHopDaChiDao.getTrinhTuXuLy());
            idvb = vanBanPhoiHopDaChiDao.getId();
            idPhoPhong = vanBanPhoiHopDaChiDao.getIdPhoPhong();
            idPhoiHop = vanBanPhoiHopDaChiDao.getIdPhoiHop();
            idPhoPhongPhoiHop = vanBanPhoiHopDaChiDao.getIdPhoPhongPhoiHops();
            idChuyenVienPhoiHops = vanBanPhoiHopDaChiDao.getIdChuyenVienPhoiHops();
            tvSKH.setText(String.valueOf(vanBanPhoiHopDaChiDao.getSoKyHieu()));
            if (!vanBanPhoiHopDaChiDao.getHanGiaiQuyet().equals("01/01/1970")) {
                tvNgayThangNam.setText(String.valueOf(vanBanPhoiHopDaChiDao.getHanGiaiQuyet()));
            }
            tvChonPhoPhong.setText(String.valueOf(vanBanPhoiHopDaChiDao.getTenPhoPhong()));
            tvSoDen.setText(String.valueOf(vanBanPhoiHopDaChiDao.getSoDen()));
            tvNoigui.setText(String.valueOf(vanBanPhoiHopDaChiDao.getNoiGui()));
            tvNgay.setText(String.valueOf(vanBanPhoiHopDaChiDao.getNgayNhap()));
            tvChiDao1.setText(String.valueOf(vanBanPhoiHopDaChiDao.getChiDao()));
            tvChiDao2.setText(String.valueOf(vanBanPhoiHopDaChiDao.getChiDaoChuTri()));
            tvTrichYeu.setText(vanBanPhoiHopDaChiDao.getMoTa() + " . " + vanBanPhoiHopDaChiDao.getNoiDung());
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanPhoiHopDaChiDao.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBVanBanPhoiHopDaChiDaoPhoPhongActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
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
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnChonChuyenVien,
            R.id.tvNgayThangNam, R.id.lnNoiDungVB,
            R.id.btnBack,
            R.id.btnDuyet, R.id.btnTuChoiVeTP,
            R.id.tvXemChiTietNDVBDSVBDenChoLDXL})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnChonChuyenVien:
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
//                        Log.d("dd",idChuyenVienPhoiHops);
                        tvChiDao2.setText(chidao2);
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
                getPresenter().duyetVBPhongPhoiHopDaChiDao(idvb, idPhoPhong, idPhoPhongPhoiHop, idChuyenVienPhoiHops, tvChiDao1.getText().toString(), tvChiDao2.getText().toString(), tvNgayThangNam.getText().toString());
                break;
            case R.id.btnTuChoiVeTP:
                AlertDialog.Builder buildertuchoi = new AlertDialog.Builder(this);
                LayoutInflater inflatertuchoi = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewtuchoi = inflatertuchoi.inflate(R.layout.dialog_tuchoi_ketquahoanthanh_cho_phe_duyet, null);
                buildertuchoi.setView(viewtuchoi);
                buildertuchoi.setCancelable(false);
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
                        getPresenter().tuChoiVBPhoiHopDaChiDao(idPhoiHop, edtNoiDungTuChoi.getText().toString());
                    }
                });
                dialog.show();
                break;

        }
    }

    @Override
    public void onGetPhoPhongBanSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
    }

    @Override
    public void onGetChuyenvienSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterChonChuyenVienPhoiHop = new AdapterChonChuyenVienPhoiHop(giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void duyetVanBanSuccess() {
        Toast.makeText(this, "Đã duyệt", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void tuChoiSuccess() {
        Toast.makeText(this, "Đã từ chối", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NDVBVanBanPhoiHopDaChiDaoPresenter createPresenter() {
        return new NDVBVanBanPhoiHopDaChiDaoPresenterImpl(this);
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

    void recyclerviewTrinhTuChuyenNhan(ArrayList<String> stringArrayList) {
        adapterDeXuatGiaHanChoXuLy = new AdapterDeXuatGiaHanChoXuLy(stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvTrinhTuXuLy.setLayoutManager(linearLayoutManager);
        rvTrinhTuXuLy.setAdapter(adapterDeXuatGiaHanChoXuLy);
        adapterDeXuatGiaHanChoXuLy.notifyDataSetChanged();
    }
}
