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
import android.widget.CheckBox;
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
import com.vpdt.vpdt.model.PhongChuTri;
import com.vpdt.vpdt.model.PhongChuTriChoXL;
import com.vpdt.vpdt.presenter.NoiDungVanBanGiaoPhongChoXuLyPresenter;
import com.vpdt.vpdt.presenter.NoiDungVanBanGiaoPhongChoXuLyView;
import com.vpdt.vpdt.presenter.impl.NoiDungVanBanGiaoPhongChoXuLyPresenterImpl;
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

public class NoiDungVanBanGiaoPhongChoXuLyActivity extends BaseActivity<NoiDungVanBanGiaoPhongChoXuLyPresenter> implements
        NoiDungVanBanGiaoPhongChoXuLyView, AdapterTenGiamDoc.OnItemClickListener, DatePickerDialog.OnDateSetListener,
        AdapterTenChuyenVien.OnItemClickListenerChuyenVien, AdapterChonChuyenVienPhoiHop.OnItemClickListenerChonChuyenVien,
        AdapterChonPhoPhongPhoiHop.OnItemClickListenerPhoPhongPhoiHop {

    @BindView(R.id.tvSKH)
    TextView tvSKHNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvSoDen)
    TextView tvSoDenNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvNoigui)
    TextView tvNoiGuiNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvNgay)
    TextView tvNgayNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvTrichYeuNDVBDSVBDenChoLDXL)
    TextView tvTrichYeuNDVBDSVBDenChoLDXL;
    @BindView(R.id.spnTenNDVBDSVBDenChoLDXL)
    TextView spnTenNDVBDSVBDenChoLDXL;
    @BindView(R.id.spnPhongNDVBDSVBDenChoLDXL)
    TextView spnPhongNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvNgayThangNamNDVBDSVBDenChoLDXL)
    TextView tvNgayThangNamNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvNoiDung)
    TextView tvNoiDung;
    @BindView(R.id.tvTenChiDao)
    TextView tvTenChiDao;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;
    @BindView(R.id.tvLoaiVanban)
    TextView tvLoaiVanban;

    @BindView(R.id.btnDeXuat)
    Button btnDeXuat;

    @BindView(R.id.tvChiDao1NDVBDSVBDenChoLDXL)
    EditText tvChiDao1NDVBDSVBDenChoLDXL;
    @BindView(R.id.tvChiDao2NDVBDSVBDenChoLDXL)
    EditText tvChiDao2NDVBDSVBDenChoLDXL;

    @BindView(R.id.btnChonPhoiHopNDVBDSVBDenChoLDXL)
    Button btnChonPhoiHopNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvDuyetNDVBDSVBDenChoLDXL)
    Button tvDuyetNDVBDSVBDenChoLDXL;
    @BindView(R.id.cbVBQPPLNDVBDSVBDenChoLDXL)
    CheckBox cbVBQPPLNDVBDSVBDenChoLDXL;
    @BindView(R.id.cbPGDBietDeDonDoc)
    CheckBox cbPGDBietDeDonDoc;
    @BindView(R.id.cbVBDaLuu)
    CheckBox cbVBDaLuu;

    @BindView(R.id.lnNoiDungVB)
    LinearLayout lnNoiDungVB;
    @BindView(R.id.btnTuChoi)
    Button btnTuChoi;


    RecyclerView rcTenPhoPhong;
    RecyclerView rcTenChuyenVien;
    RecyclerView rcTenGiamDoc;

    EditText edtNoiDungTuChoi;
    EditText edtGhiChu;

    TextView tvNgayThangNam;
    EditText edtThemYKien;
    boolean click = false;
    AlertDialog dialog;
    AdapterTenGiamDoc adapterTenGiamDoc;
    AdapterTenChuyenVien adapterTenChuyenVien;
    AdapterChonChuyenVienPhoiHop adapterChonChuyenVienPhoiHop;
    AdapterChonPhoPhongPhoiHop adapterChonPhoPhongPhoiHop;
    ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdocArrayList = new ArrayList<>();
    int idvb, idChuyenVien, idPhoPhong;
    String idPhoPhongPhoiHop = "";
    String idChuyenVienPhoiHops = "";
    boolean tuChoiTP = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_noi_dung_van_ban_giao_phong_cho_xu_ly;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        getPresenter().getAllChuyenVien();
        getPresenter().getAllPhoPhongBan();
        PhongChuTriChoXL phongChuTri = getIntent().getParcelableExtra("phongChuTri");
        if (phongChuTri != null) {
            if (phongChuTri.getISTCChuTri() == 1) {
                tvLoaiVanban.setText("STC chủ trì");
            }
            if (phongChuTri.getIVanBanTBKL() == 1) {
                tvLoaiVanban.setText("Thông báo kết luận");
            }
            if (phongChuTri.getIToCongTac() == 1) {
                tvLoaiVanban.setText("Tổ công tác");
            }
            if (phongChuTri.getISTCPhoiHop() == 1) {
                tvLoaiVanban.setText("STC phối hợp");
            }
            if (phongChuTri.getIVanBanQPPL() == 1) {
                tvLoaiVanban.setText("VB QPPL");
            }
            idvb = phongChuTri.getId();
            tvSKHNDVBDSVBDenChoLDXL.setText(String.valueOf(phongChuTri.getSoKyHieu()));
            tvNoiGuiNDVBDSVBDenChoLDXL.setText(String.valueOf(phongChuTri.getNoiGui()));
            tvNgayNDVBDSVBDenChoLDXL.setText(phongChuTri.getNgayNhap());
            tvSoDenNDVBDSVBDenChoLDXL.setText(String.valueOf(phongChuTri.getSoDen()));
            tvNgayThangNamNDVBDSVBDenChoLDXL.setText(String.valueOf(phongChuTri.getHanGiaiQuyet()));
            tvTrichYeuNDVBDSVBDenChoLDXL.setText(String.valueOf(phongChuTri.getMoTa()));
            tvNoiDung.setText(String.valueOf(phongChuTri.getNoiDung()));
            tvTenChiDao.setText(String.valueOf(phongChuTri.getTenChiDao()));
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(phongChuTri.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NoiDungVanBanGiaoPhongChoXuLyActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            if (phongChuTri.getTrangThaiThemHan()) {
                btnDeXuat.setVisibility(View.VISIBLE);
            }
            if (phongChuTri.getTuChoiTP()) {
                tuChoiTP = true;
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.spnTenNDVBDSVBDenChoLDXL, R.id.spnPhongNDVBDSVBDenChoLDXL,
            R.id.btnChonPhoiHopNDVBDSVBDenChoLDXL,
            R.id.tvNgayThangNamNDVBDSVBDenChoLDXL, R.id.lnNoiDungVB,
            R.id.btnBack,
            R.id.tvDuyetNDVBDSVBDenChoLDXL,
            R.id.tvXemChiTietNDVBDSVBDenChoLDXL, R.id.btnChonPhoPhong, R.id.btnTuChoi, R.id.btnDeXuat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.spnTenNDVBDSVBDenChoLDXL:
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
                btnChuyenPGiamDoc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        spnTenNDVBDSVBDenChoLDXL.setText("");
                        dialog.dismiss();
                    }
                });
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
                        spnPhongNDVBDSVBDenChoLDXL.setText("");
                        dialog.dismiss();
                    }
                });

                break;
            case R.id.btnChonPhoiHopNDVBDSVBDenChoLDXL:
                if (spnTenNDVBDSVBDenChoLDXL.getText().equals("")) {
                    Toast.makeText(this, "Chưa chuyền P.Giám đốc", Toast.LENGTH_SHORT).show();
                } else if (spnPhongNDVBDSVBDenChoLDXL.getText().equals("")) {
                    Toast.makeText(this, "Chưa chọn chuyên viên", Toast.LENGTH_SHORT).show();
                } else {
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

                            String chidao2 = "Chuyển đ/c " + spnPhongNDVBDSVBDenChoLDXL.getText() + " chủ trì giải quyết.";
                            int index = 0;
                            idChuyenVienPhoiHops = "";
                            for (GiamdocVaPhoGiamdoc item : giamdocVaPhoGiamdocArrayList) {

                                index++;
                                if (index == giamdocVaPhoGiamdocArrayList.size()) {
                                    idChuyenVienPhoiHops += "" + item.getId();
                                    chidao2 += item.getHoTen() + " phối hợp";
                                } else {
                                    idChuyenVienPhoiHops += item.getId() + ",";
                                    chidao2 += item.getHoTen() + ", ";
                                }
                            }
                            tvChiDao2NDVBDSVBDenChoLDXL.setText(chidao2);
                            giamdocVaPhoGiamdocArrayList.clear();
                            dialog.dismiss();

                        }
                    });
                }
                break;
            case R.id.btnChonPhoPhong:
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

                        String chidao2 = "Chuyển PP " + spnTenNDVBDSVBDenChoLDXL.getText() + " chủ trì. ";
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
                        tvChiDao1NDVBDSVBDenChoLDXL.setText(chidao2);
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
                    Intent intent = new Intent(this, ChiTietBietDeDonDocActivity.class);
                    intent.putExtra("ID_VANBAN_CHOLANHDAOXULY", idvb);
                    startActivity(intent);
                    click = true;
                }

                break;

            case R.id.tvDuyetNDVBDSVBDenChoLDXL:
                if (cbVBDaLuu.isChecked() && cbVBQPPLNDVBDSVBDenChoLDXL.isChecked() && cbPGDBietDeDonDoc.isChecked()) {
                    getPresenter().duyetVBPhongChuTriChoXuLy(idvb, idPhoPhong, idPhoPhongPhoiHop, idChuyenVien, idChuyenVienPhoiHops, tvChiDao1NDVBDSVBDenChoLDXL.getText().toString(),
                            tvChiDao2NDVBDSVBDenChoLDXL.getText().toString(), true, true, true, tvNgayThangNamNDVBDSVBDenChoLDXL.getText().toString());
                } else if (cbVBDaLuu.isChecked() && cbVBQPPLNDVBDSVBDenChoLDXL.isChecked()) {
                    getPresenter().duyetVBPhongChuTriChoXuLy(idvb, idPhoPhong, idPhoPhongPhoiHop, idChuyenVien, idChuyenVienPhoiHops, tvChiDao1NDVBDSVBDenChoLDXL.getText().toString(),
                            tvChiDao2NDVBDSVBDenChoLDXL.getText().toString(), true, true, false, tvNgayThangNamNDVBDSVBDenChoLDXL.getText().toString());
                } else if (cbVBDaLuu.isChecked() && cbPGDBietDeDonDoc.isChecked()) {
                    getPresenter().duyetVBPhongChuTriChoXuLy(idvb, idPhoPhong, idPhoPhongPhoiHop, idChuyenVien, idChuyenVienPhoiHops, tvChiDao1NDVBDSVBDenChoLDXL.getText().toString(),
                            tvChiDao2NDVBDSVBDenChoLDXL.getText().toString(), true, false, true, tvNgayThangNamNDVBDSVBDenChoLDXL.getText().toString());
                } else if (cbVBQPPLNDVBDSVBDenChoLDXL.isChecked() && cbPGDBietDeDonDoc.isChecked()) {
                    getPresenter().duyetVBPhongChuTriChoXuLy(idvb, idPhoPhong, idPhoPhongPhoiHop, idChuyenVien, idChuyenVienPhoiHops, tvChiDao1NDVBDSVBDenChoLDXL.getText().toString(),
                            tvChiDao2NDVBDSVBDenChoLDXL.getText().toString(), false, true, true, tvNgayThangNamNDVBDSVBDenChoLDXL.getText().toString());
                } else if (cbVBDaLuu.isChecked()) {
                    getPresenter().duyetVBPhongChuTriChoXuLy(idvb, idPhoPhong, idPhoPhongPhoiHop, idChuyenVien, idChuyenVienPhoiHops, tvChiDao1NDVBDSVBDenChoLDXL.getText().toString(),
                            tvChiDao2NDVBDSVBDenChoLDXL.getText().toString(), true, false, false, tvNgayThangNamNDVBDSVBDenChoLDXL.getText().toString());
                } else if (cbVBQPPLNDVBDSVBDenChoLDXL.isChecked()) {
                    getPresenter().duyetVBPhongChuTriChoXuLy(idvb, idPhoPhong, idPhoPhongPhoiHop, idChuyenVien, idChuyenVienPhoiHops, tvChiDao1NDVBDSVBDenChoLDXL.getText().toString(),
                            tvChiDao2NDVBDSVBDenChoLDXL.getText().toString(), false, true, false, tvNgayThangNamNDVBDSVBDenChoLDXL.getText().toString());
                } else if (cbPGDBietDeDonDoc.isChecked()) {
                    getPresenter().duyetVBPhongChuTriChoXuLy(idvb, idPhoPhong, idPhoPhongPhoiHop, idChuyenVien, idChuyenVienPhoiHops, tvChiDao1NDVBDSVBDenChoLDXL.getText().toString(),
                            tvChiDao2NDVBDSVBDenChoLDXL.getText().toString(), false, false, true, tvNgayThangNamNDVBDSVBDenChoLDXL.getText().toString());
                } else {
                    getPresenter().duyetVBPhongChuTriChoXuLy(idvb, idPhoPhong, idPhoPhongPhoiHop, idChuyenVien, idChuyenVienPhoiHops, tvChiDao1NDVBDSVBDenChoLDXL.getText().toString(),
                            tvChiDao2NDVBDSVBDenChoLDXL.getText().toString(), false, false, false, tvNgayThangNamNDVBDSVBDenChoLDXL.getText().toString());
                }
                break;
            case R.id.btnTuChoi:
                AlertDialog.Builder buildertuchoi = new AlertDialog.Builder(this);
                LayoutInflater inflatertuchoi = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewtuchoi = inflatertuchoi.inflate(R.layout.dialog_tuchoicuaphong, null);
                buildertuchoi.setView(viewtuchoi);
                buildertuchoi.setCancelable(false);
                dialog = buildertuchoi.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                edtNoiDungTuChoi = viewtuchoi.findViewById(R.id.edtNoiDungTuChoi);
                edtGhiChu = viewtuchoi.findViewById(R.id.edtGhiChu);
                Button btnDong1 = viewtuchoi.findViewById(R.id.btnDong);
                Button btnChuyenChanhVanBan = viewtuchoi.findViewById(R.id.btnChuyenChanhVanBan);
                btnDong1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btnChuyenChanhVanBan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (tuChoiTP) {
                            getPresenter().tuChoiTPVBPhongChuTriChoXuLy(PrefUtil.getString(NoiDungVanBanGiaoPhongChoXuLyActivity.this, Key.NAM_LAM_VIEC, ""),
                                    idvb, edtNoiDungTuChoi.getText().toString(), edtGhiChu.getText().toString());
                        } else {
                            getPresenter().tuChoiVBPhongChuTriChoXuLy(idvb, edtNoiDungTuChoi.getText().toString(), edtGhiChu.getText().toString());
                        }
                    }
                });
                dialog.show();
                break;
            case R.id.btnDeXuat:
                AlertDialog.Builder builderDongYChiDao = new AlertDialog.Builder(this);
                LayoutInflater inflaterDongYChiDao = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewDongYChiDao = inflaterDongYChiDao.inflate(R.layout.dialog_dexuatgiahan, null);
                builderDongYChiDao.setView(viewDongYChiDao);
                dialog = builderDongYChiDao.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                tvNgayThangNam = viewDongYChiDao.findViewById(R.id.tvNgayThangNam);
                edtThemYKien = viewDongYChiDao.findViewById(R.id.edtThemYKien);
                Button btnDong = viewDongYChiDao.findViewById(R.id.btnDong);
                Button btnDongy = viewDongYChiDao.findViewById(R.id.btnDongy);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                tvNgayThangNam.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDatePickerDialog();
                    }
                });
                btnDongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().themHanVBPhongChuTriChoXuLy(idvb, tvNgayThangNam.getText().toString(), edtThemYKien.getText().toString());
                    }
                });

                dialog.show();
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
    public void onGetChuyenvienSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterTenChuyenVien = new AdapterTenChuyenVien(giamdocVaPhoGiamdoc, this);
        adapterChonChuyenVienPhoiHop = new AdapterChonChuyenVienPhoiHop(giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void duyetVanBanSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }


    @Override
    public void onItemClick(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        idPhoPhong = giamdocVaPhoGiamdoc.getId();
        spnTenNDVBDSVBDenChoLDXL.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        tvChiDao1NDVBDSVBDenChoLDXL.setText("Chuyển PP " + giamdocVaPhoGiamdoc.getHoTen());

        dialog.dismiss();
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
        spnPhongNDVBDSVBDenChoLDXL.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        tvChiDao2NDVBDSVBDenChoLDXL.setText("Chuyển đ/c " + giamdocVaPhoGiamdoc.getHoTen() + " chủ trì giải quyết.");
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
    public void onItemClickPhoPhongPhoiHop(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        if (giamdocVaPhoGiamdocArrayList.contains(giamdocVaPhoGiamdoc)) {
            giamdocVaPhoGiamdocArrayList.remove(giamdocVaPhoGiamdoc);
        } else {
            giamdocVaPhoGiamdocArrayList.add(giamdocVaPhoGiamdoc);
        }
    }


    @Override
    public void tuChoiVBPhongChuTriChoXuLySuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NoiDungVanBanGiaoPhongChoXuLyPresenter createPresenter() {
        return new NoiDungVanBanGiaoPhongChoXuLyPresenterImpl(this);
    }

    @Override
    public void themHanVBPhongChuTriChoXuLy() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

}
