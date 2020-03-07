package com.vpdt.vpdt.ui.activity.XuLyVanBan;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.VanBanPhoPhongBietDeDonDoc;
import com.vpdt.vpdt.presenter.NDVBVanBanPhoPhongBietDeDonDocPresenter;
import com.vpdt.vpdt.presenter.NDVBVanBanPhoPhongBietDeDonDocView;
import com.vpdt.vpdt.presenter.impl.NDVBVanBanPhoPhongBietDeDonDocPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterChonChuyenVienPhoiHop;
import com.vpdt.vpdt.ui.adapter.AdapterTenChuyenVien;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBVanBanPhoPhongBietDeDonDocActivity extends BaseActivity<NDVBVanBanPhoPhongBietDeDonDocPresenter> implements NDVBVanBanPhoPhongBietDeDonDocView,
        AdapterTenChuyenVien.OnItemClickListenerChuyenVien, AdapterChonChuyenVienPhoiHop.OnItemClickListenerChonChuyenVien {

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
    @BindView(R.id.tvNgayThangNamNDVBDSVBDenChoLDXL)
    TextView tvNgayThangNamNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvChiDao1NDVBDSVBDenChoLDXL)
    TextView tvChiDao1NDVBDSVBDenChoLDXL;
    @BindView(R.id.spnPhongNDVBDSVBDenChoLDXL)
    TextView spnPhongNDVBDSVBDenChoLDXL;

    @BindView(R.id.btnChonPhoiHopNDVBDSVBDenChoLDXL)
    Button btnChonPhoiHopNDVBDSVBDenChoLDXL;

    String filedinhkem;
    int id;
    AlertDialog dialog;
    RecyclerView rcTenChuyenVien;
    RecyclerView rcTenPhoPhong;
    AdapterTenChuyenVien adapterTenChuyenVien;
    AdapterChonChuyenVienPhoiHop adapterChonChuyenVienPhoiHop;
    ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdocArrayList = new ArrayList<>();
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbvan_ban_pho_phong_biet_de_don_doc;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        getPresenter().getAllChuyenVien();
        VanBanPhoPhongBietDeDonDoc vanBanPhoPhongBietDeDonDoc = getIntent().getParcelableExtra("vanBanPhoPhongBietDeDonDoc");
        if (vanBanPhoPhongBietDeDonDoc != null) {
            filedinhkem = vanBanPhoPhongBietDeDonDoc.getUrlFile();
            id = vanBanPhoPhongBietDeDonDoc.getId();
            tvNgay.setText(String.valueOf(vanBanPhoPhongBietDeDonDoc.getNgayNhap()));
            tvSKH.setText(String.valueOf(vanBanPhoPhongBietDeDonDoc.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(vanBanPhoPhongBietDeDonDoc.getSoDen()));
            tvNoigui.setText(String.valueOf(vanBanPhoPhongBietDeDonDoc.getNoiGui()));
            tvTrichYeuNDVBDSVBDenChoLDXL.setText(vanBanPhoPhongBietDeDonDoc.getMoTa() + "." + vanBanPhoPhongBietDeDonDoc.getNoiDung());
            spnPhongNDVBDSVBDenChoLDXL.setText(String.valueOf(vanBanPhoPhongBietDeDonDoc.getTenChuyenVien()));
            tvChiDao1NDVBDSVBDenChoLDXL.setText(String.valueOf(vanBanPhoPhongBietDeDonDoc.getChiDaoChuTri()));
            tvNgayThangNamNDVBDSVBDenChoLDXL.setText(String.valueOf(vanBanPhoPhongBietDeDonDoc.getHanGiaiQuyet()));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
        String chidao2 = tvChiDao1NDVBDSVBDenChoLDXL.getText().toString().trim();
        if (chidao2.isEmpty()) {
            btnChonPhoiHopNDVBDSVBDenChoLDXL.setEnabled(false);
        } else {
            btnChonPhoiHopNDVBDSVBDenChoLDXL.setEnabled(true);
        }
        tvChiDao1NDVBDSVBDenChoLDXL.addTextChangedListener(loginTextWatcher);
    }

    TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String chidao2 = tvChiDao1NDVBDSVBDenChoLDXL.getText().toString().trim();

            btnChonPhoiHopNDVBDSVBDenChoLDXL.setEnabled(!chidao2.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @OnClick({R.id.spnPhongNDVBDSVBDenChoLDXL,
            R.id.btnChonPhoiHopNDVBDSVBDenChoLDXL,
            R.id.tvNgayThangNamNDVBDSVBDenChoLDXL, R.id.lnNoiDungVB,
            R.id.btnBack,
            R.id.tvXemChiTietNDVBDSVBDenChoLDXL, R.id.tvFileDinhKem})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.tvFileDinhKem:
                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(filedinhkem));
                    startActivity(browserIntent);
                } catch (Exception e) {
                    Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.spnPhongNDVBDSVBDenChoLDXL:

                AlertDialog.Builder builderChuyenVien = new AlertDialog.Builder(this);
                LayoutInflater inflaterChuyenVien = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewChuyenVien = inflaterChuyenVien.inflate(R.layout.dialog_ten_chuyen_vien, null);
                builderChuyenVien.setView(viewChuyenVien);
                dialog = builderChuyenVien.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
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
                        spnPhongNDVBDSVBDenChoLDXL.setText("Chọn chuyên viên");
                        tvChiDao1NDVBDSVBDenChoLDXL.setText("");
                        dialog.dismiss();
                    }
                });

                break;
            case R.id.btnChonPhoiHopNDVBDSVBDenChoLDXL:

                AlertDialog.Builder builderphongphoihop = new AlertDialog.Builder(this);
                LayoutInflater inflaterphongphoihop = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewphongphoihop = inflaterphongphoihop.inflate(R.layout.dialog_chon_phong_ban_phoi_hop, null);
                builderphongphoihop.setView(viewphongphoihop);
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

                imgCancel.setOnClickListener(v -> dialog.dismiss());
                btnGhiLai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String chidao2 = "Chuyển đ/c " + spnPhongNDVBDSVBDenChoLDXL.getText() + " chủ trì giải quyết.";
                        int index = 0;

                        for (GiamdocVaPhoGiamdoc item : giamdocVaPhoGiamdocArrayList) {

                            index++;
                            if (index == giamdocVaPhoGiamdocArrayList.size()) {

                                chidao2 += item.getHoTen() + " phối hợp";
                            } else {

                                chidao2 += item.getHoTen() + ", ";
                            }
                        }
                        tvChiDao1NDVBDSVBDenChoLDXL.setText(chidao2);
                        giamdocVaPhoGiamdocArrayList.clear();
                        dialog.dismiss();

                    }
                });

                break;


            case R.id.lnNoiDungVB:
                closeKeyboard();
                break;
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTietNDVBDSVBDenChoLDXL:
                if (!click) {
                    Intent intent = new Intent(this, TTVBVanBanChuTriChoXuLyActivity.class);
                    intent.putExtra("idvBChuTriChoXuLy", id);
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
    public void onGetChuyenvienSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterTenChuyenVien = new AdapterTenChuyenVien(giamdocVaPhoGiamdoc, this);
        adapterChonChuyenVienPhoiHop = new AdapterChonChuyenVienPhoiHop(giamdocVaPhoGiamdoc, this);
    }

    @Override
    public NDVBVanBanPhoPhongBietDeDonDocPresenter createPresenter() {
        return new NDVBVanBanPhoPhongBietDeDonDocPresenterImpl(this);
    }

    @Override
    public void onItemClickChuyenVien(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {

        spnPhongNDVBDSVBDenChoLDXL.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        tvChiDao1NDVBDSVBDenChoLDXL.setText("Chuyển đ/c " + giamdocVaPhoGiamdoc.getHoTen() + " chủ trì giải quyết.");
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

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
