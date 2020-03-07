package com.vpdt.vpdt.ui.activity.VanBanDonViCapHai;

import android.annotation.SuppressLint;
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
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.model.VanBanChoChiDao;
import com.vpdt.vpdt.presenter.NDVBVanBanChoChiDaoPresenter;
import com.vpdt.vpdt.presenter.NDVBVanBanChoChiDaoView;
import com.vpdt.vpdt.presenter.impl.NDVBVanBanChoChiDaoPresenterImpl;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.TTVBCongViecPhoiHopChoXuLyActivity;
import com.vpdt.vpdt.ui.adapter.AdapterTenGiamDoc;
import com.vpdt.vpdt.ui.adapter.AdapterTenPhong;
import com.vpdt.vpdt.ui.adapter.AdapterTenPhongPhoiHop;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBVanBanChoChiDaoActivity extends BaseActivity<NDVBVanBanChoChiDaoPresenter> implements NDVBVanBanChoChiDaoView,
        DatePickerDialog.OnDateSetListener, AdapterTenGiamDoc.OnItemClickListener, AdapterTenPhong.OnItemClickListener, AdapterTenPhongPhoiHop.OnItemClickListener1 {

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
    @BindView(R.id.tvTen)
    TextView tvTen;
    @BindView(R.id.tvPhong)
    TextView tvPhong;
    @BindView(R.id.tvNgayThangNam)
    TextView tvNgayThangNam;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;

    @BindView(R.id.edtChiDao1)
    EditText edtChiDao1;
    @BindView(R.id.edtChiDao2)
    EditText edtChiDao2;
    @BindView(R.id.edtChiDao3)
    EditText edtChiDao3;

    RecyclerView rcTenPhong;
    RecyclerView rcTenGiamDoc;
    RecyclerView rcTenPhongPhoiHop;

    private AdapterTenPhong adapterTenPhong;
    private AdapterTenPhongPhoiHop adapterTenPhongPhoiHop;
    private AdapterTenGiamDoc adapterTenGiamDoc;
    AlertDialog dialog;
    private ArrayList<PhongBan> phongBansSelected = new ArrayList<>();
    int id;
    int idLanhDao = 0;
    int idPhongChuTri = 0;
    String idPhongPhoiHop = "";
    String tenPhongPhoiHop = "";
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbvan_ban_cho_chi_dao;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        VanBanChoChiDao vanBanPhoiHopDaChiDao = getIntent().getParcelableExtra("vanBanChoChiDao");
        getPresenter().getAllPhongBanDonViCapHai(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""));
        getPresenter().getAllTruongPhongDonViCapHai(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""));
        if (vanBanPhoiHopDaChiDao != null) {
            id = vanBanPhoiHopDaChiDao.getId();
            idPhongPhoiHop = vanBanPhoiHopDaChiDao.getIdPhongPhoiHops();
            tvSKH.setText(String.valueOf(vanBanPhoiHopDaChiDao.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(vanBanPhoiHopDaChiDao.getSoDen()));
            tvNoiGui.setText(String.valueOf(vanBanPhoiHopDaChiDao.getNoiGui()));
            tvNgay.setText(String.valueOf(vanBanPhoiHopDaChiDao.getNgayNhap()));
            tvTrichYeu.setText(vanBanPhoiHopDaChiDao.getMoTa() + " . " + vanBanPhoiHopDaChiDao.getNoiDung());
            if (vanBanPhoiHopDaChiDao.getHanGiaiQuyet() != null) {
                if (!vanBanPhoiHopDaChiDao.getHanGiaiQuyet().isEmpty())
                    tvNgayThangNam.setText(String.valueOf(vanBanPhoiHopDaChiDao.getHanGiaiQuyet()));
            }

            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanPhoiHopDaChiDao.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBVanBanChoChiDaoActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
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
    public void onGetGiamdocVaPhoGiamdocSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterTenGiamDoc = new AdapterTenGiamDoc(this, giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void onGetPhongBanSuccess(ArrayList<PhongBan> phongBan) {
        adapterTenPhong = new AdapterTenPhong(this, phongBan, this);
        adapterTenPhongPhoiHop = new AdapterTenPhongPhoiHop(this, phongBan, this);
    }

    @Override
    public void onGetDuyetSuccess() {
        Toast.makeText(this, "Duyệt thành công", Toast.LENGTH_LONG).show();
        finish();
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

    @OnClick({R.id.btnChonPhoiHop, R.id.tvNgayThangNam, R.id.lnNDVB_DSVB_DaChiDao, R.id.imvBack,
            R.id.btnDuyet, R.id.tvXemChiTiet, R.id.tvTen, R.id.tvPhong})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvTen:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.dialog_ten_giam_doc, null);
                builder.setView(view1);
                dialog = builder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                rcTenGiamDoc = view1.findViewById(R.id.rcTenGiamDoc);
                rcTenGiamDoc.setLayoutManager(layoutManager);
                rcTenGiamDoc.setAdapter(adapterTenGiamDoc);
                adapterTenGiamDoc.notifyDataSetChanged();
                dialog.show();
                TextView btnChuyenPGiamDoc = view1.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyenPGiamDoc.setText("");
                btnChuyenPGiamDoc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvTen.setText("");
                        edtChiDao1.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.tvPhong:
                AlertDialog.Builder builderphong = new AlertDialog.Builder(this);
                LayoutInflater inflaterphong = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewphong = inflaterphong.inflate(R.layout.dialog_ten_phong, null);
                builderphong.setView(viewphong);
                dialog = builderphong.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManagerphong = new LinearLayoutManager(getApplicationContext());
                layoutManagerphong.setOrientation(LinearLayoutManager.VERTICAL);
                rcTenPhong = viewphong.findViewById(R.id.rcTenPhong);
                rcTenPhong.setLayoutManager(layoutManagerphong);
                rcTenPhong.setAdapter(adapterTenPhong);
                adapterTenPhong.notifyDataSetChanged();
                dialog.show();
                TextView tvChonChuTri = viewphong.findViewById(R.id.tvChonChuTri);
                tvChonChuTri.setText("-- Chọn phòng chủ trì --");
                tvChonChuTri.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvPhong.setText("");
                        edtChiDao2.setText("");
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
                rcTenPhongPhoiHop = viewphongphoihop.findViewById(R.id.rcTenPhongPhoiHop);
                rcTenPhongPhoiHop.setLayoutManager(layoutManagerPhoihop);
                rcTenPhongPhoiHop.setAdapter(adapterTenPhongPhoiHop);
                adapterTenPhongPhoiHop.notifyDataSetChanged();
                imgCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        phongBansSelected.clear();
                        edtChiDao3.setText("");
                        dialog.dismiss();
                    }
                });
                btnGhiLai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String chidao2 = "";
                        int index = 0;
                        for (PhongBan item : phongBansSelected) {
                            index++;
                            if (index == phongBansSelected.size()) {
                                idPhongPhoiHop += "" + item.getId();
                                tenPhongPhoiHop += "" + item.getTenPhongBan();
                                chidao2 += item.getTenPhongBan() + " phối hợp giải quyết.";
                            } else {
                                idPhongPhoiHop += item.getId() + ",";
                                tenPhongPhoiHop += item.getTenPhongBan() + ",";
                                chidao2 += item.getTenPhongBan() + ", ";
                            }
                        }
                        edtChiDao3.setText(chidao2);
                        dialog.dismiss();
                        phongBansSelected.clear();
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
                getPresenter().duyetVBChoChiDaoDonViCapHai(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""),
                        id, idLanhDao, tvTen.getText().toString(), idPhongChuTri, tvPhong.getText().toString(),
                        idPhongPhoiHop, tenPhongPhoiHop, tvNgayThangNam.getText().toString());
                break;
        }
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

    @SuppressLint("SetTextI18n")
    @Override
    public void onItemClick(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        idLanhDao = giamdocVaPhoGiamdoc.getId();
        tvTen.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        edtChiDao1.setText("Chuyển " + giamdocVaPhoGiamdoc.getHoTen() + " chỉ đạo");
        dialog.dismiss();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onItemClick(PhongBan phongBan) {
        idPhongChuTri = phongBan.getId();
        tvPhong.setText(String.valueOf(phongBan.getTenPhongBan()));
        edtChiDao2.setText(phongBan.getTenPhongBan() + " chủ trì giải quyết.");
        dialog.dismiss();
    }

    @Override
    public void onItemClick1(PhongBan phongBan) {
        if (phongBansSelected.contains(phongBan)) {
            phongBansSelected.remove(phongBan);
        } else {
            phongBansSelected.add(phongBan);
        }
    }

    @Override
    public NDVBVanBanChoChiDaoPresenter createPresenter() {
        return new NDVBVanBanChoChiDaoPresenterImpl(this);
    }
}