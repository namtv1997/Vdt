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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.VanBanChuTriChoXuLy;
import com.vpdt.vpdt.presenter.NDVBVanBanChuTriChoXuLyXLVBPresenter;
import com.vpdt.vpdt.presenter.NDVBVanBanChuTriChoXuLyXLVView;
import com.vpdt.vpdt.presenter.impl.NDVBVanBanChuTriChoXuLyXLVBPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterChonChuyenVienPhoiHop;
import com.vpdt.vpdt.ui.adapter.AdapterTenChuyenVien;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBVanBanChuTriChoXuLyXLVBActivity extends BaseActivity<NDVBVanBanChuTriChoXuLyXLVBPresenter> implements NDVBVanBanChuTriChoXuLyXLVView,
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
    @BindView(R.id.tvNoiDungChiDao)
    TextView tvNoiDungChiDao;
    @BindView(R.id.tvNoiDungChiDaoCuaDC)
    TextView tvNoiDungChiDaoCuaDC;
    @BindView(R.id.spnPhongNDVBDSVBDenChoLDXL)
    TextView spnPhongNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvNgayThangNamNDVBDSVBDenChoLDXL)
    TextView tvNgayThangNamNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvChiDao1NDVBDSVBDenChoLDXL)
    TextView tvChiDao1NDVBDSVBDenChoLDXL;
    @BindView(R.id.tvVanBanDauRa)
    TextView tvVanBanDauRa;
    @BindView(R.id.tvLoaiVanban)
    TextView tvLoaiVanban;

    @BindView(R.id.cbVanBanLuu)
    CheckBox cbVanBanLuu;

    @BindView(R.id.btnDeXuatThemHanGiaiQuyet)
    Button btnDeXuatThemHanGiaiQuyet;
    @BindView(R.id.btnTuChoiVeTP)
    Button btnTuChoiVeTP;
    @BindView(R.id.btnChonPhoiHopNDVBDSVBDenChoLDXL)
    Button btnChonPhoiHopNDVBDSVBDenChoLDXL;

    TextView tvNgayThangNam;
    EditText edtThemYKien;
    EditText edtNoiDungTuChoi;
    EditText edtGhiChu;
    boolean click = false;
    AlertDialog dialog;
    RecyclerView rcTenChuyenVien;
    RecyclerView rcTenPhoPhong;
    AdapterTenChuyenVien adapterTenChuyenVien;
    AdapterChonChuyenVienPhoiHop adapterChonChuyenVienPhoiHop;
    ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdocArrayList = new ArrayList<>();
    int id, idChuyenVien;
    String idChuyenVienPhoiHops = "", chiDaoChuTri, filedinhkem;
    private int mYear, mMonth, mDay;
    DatePickerDialog datePickerDialog;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbvan_ban_chu_tri_cho_xu_ly2;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        getPresenter().getAllChuyenVien();
        VanBanChuTriChoXuLy vanBanChuTriChoXuLy = getIntent().getParcelableExtra("vanBanChuTriChoXuLy");
        if (vanBanChuTriChoXuLy != null) {
            if (vanBanChuTriChoXuLy.getVBDauRaTP() == 1) {
                tvVanBanDauRa.setVisibility(View.VISIBLE);
            }
            if (vanBanChuTriChoXuLy.getAllowThemHan()) {
                btnDeXuatThemHanGiaiQuyet.setVisibility(View.VISIBLE);
            }
            if (vanBanChuTriChoXuLy.getAllowTuChoi()) {
                btnTuChoiVeTP.setVisibility(View.VISIBLE);
            }
            if (vanBanChuTriChoXuLy.getISTCChuTri() == 1) {
                tvLoaiVanban.setText("STC chủ trì");
            }
            if (vanBanChuTriChoXuLy.getIVanBanTBKL() == 1) {
                tvLoaiVanban.setText("Thông báo kết luận");
            }
            if (vanBanChuTriChoXuLy.getIToCongTac() == 1) {
                tvLoaiVanban.setText("Tổ công tác");
            }
            if (vanBanChuTriChoXuLy.getISTCPhoiHop() == 1) {
                tvLoaiVanban.setText("STC phối hợp");
            }
            if (vanBanChuTriChoXuLy.getIVanBanQPPL() == 1) {
                tvLoaiVanban.setText("VB QPPL");
            }
            id = vanBanChuTriChoXuLy.getId();
            idChuyenVien = vanBanChuTriChoXuLy.getIdChuyenVien();
            idChuyenVienPhoiHops = vanBanChuTriChoXuLy.getIdPhoiHops();
            chiDaoChuTri = vanBanChuTriChoXuLy.getChidaoChuTri();
            chiDaoChuTri = tvChiDao1NDVBDSVBDenChoLDXL.getText().toString();
            filedinhkem = vanBanChuTriChoXuLy.getUrlFile();
            tvNgay.setText(String.valueOf(vanBanChuTriChoXuLy.getNgayNhap()));
            tvSKH.setText(String.valueOf(vanBanChuTriChoXuLy.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(vanBanChuTriChoXuLy.getSoDen()));
            tvNoiDungChiDao.setText(String.valueOf(vanBanChuTriChoXuLy.getNoiDungChiDao()));
            tvNoiDungChiDaoCuaDC.setText(String.valueOf("Nội dung chỉ đạo của đ/c: " + vanBanChuTriChoXuLy.getTenChiDao()));
            tvNoigui.setText(String.valueOf(vanBanChuTriChoXuLy.getNoiGui()));
            tvNgayThangNamNDVBDSVBDenChoLDXL.setText(String.valueOf(vanBanChuTriChoXuLy.getHanXuLy()));
            spnPhongNDVBDSVBDenChoLDXL.setText(String.valueOf(vanBanChuTriChoXuLy.getTenChuyenVien()));
            tvVanBanDauRa.setText(String.valueOf(vanBanChuTriChoXuLy.getVBDauRaTPText()));
            if (vanBanChuTriChoXuLy.getChidaoChuTri() != null) {
                if (!vanBanChuTriChoXuLy.getChidaoChuTri().isEmpty()) {
                    tvChiDao1NDVBDSVBDenChoLDXL.setText(String.valueOf(vanBanChuTriChoXuLy.getChidaoChuTri()));
                }
            }
            tvTrichYeuNDVBDSVBDenChoLDXL.setText(vanBanChuTriChoXuLy.getMoTa() + "." + vanBanChuTriChoXuLy.getNoiDung());

        }
        tvChiDao1NDVBDSVBDenChoLDXL.addTextChangedListener(loginTextWatcher);
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
            R.id.tvDuyetNDVBDSVBDenChoLDXL,
            R.id.tvXemChiTietNDVBDSVBDenChoLDXL, R.id.btnTuChoiVeTP, R.id.btnDeXuatThemHanGiaiQuyet, R.id.tvFileDinhKem})
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
                        tvChiDao1NDVBDSVBDenChoLDXL.setText(chidao2);
                        giamdocVaPhoGiamdocArrayList.clear();
                        dialog.dismiss();

                    }
                });

                break;


            case R.id.tvNgayThangNamNDVBDSVBDenChoLDXL:
                final Calendar c1 = Calendar.getInstance();
                mYear = c1.get(Calendar.YEAR);
                mMonth = c1.get(Calendar.MONTH);
                mDay = c1.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {

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
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
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

            case R.id.tvDuyetNDVBDSVBDenChoLDXL:
                chiDaoChuTri = tvChiDao1NDVBDSVBDenChoLDXL.getText().toString();
                if (cbVanBanLuu.isChecked()) {
                    getPresenter().duyetVBChuTriChoXuLy(id, idChuyenVien, idChuyenVienPhoiHops, chiDaoChuTri, true, true, tvNgayThangNamNDVBDSVBDenChoLDXL.getText().toString());
                } else {
                    getPresenter().duyetVBChuTriChoXuLy(id, idChuyenVien, idChuyenVienPhoiHops, chiDaoChuTri, false, true, tvNgayThangNamNDVBDSVBDenChoLDXL.getText().toString());
                }
                break;
            case R.id.btnTuChoiVeTP:
                AlertDialog.Builder buildertuchoi = new AlertDialog.Builder(this);
                LayoutInflater inflatertuchoi = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewtuchoi = inflatertuchoi.inflate(R.layout.dialog_tuchoicuaphong, null);
                buildertuchoi.setView(viewtuchoi);
                buildertuchoi.setCancelable(false);
                dialog = buildertuchoi.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                edtNoiDungTuChoi = viewtuchoi.findViewById(R.id.edtNoiDungTuChoi);
                TextView tvTieuDe = viewtuchoi.findViewById(R.id.tvTieuDe);
                edtGhiChu = viewtuchoi.findViewById(R.id.edtGhiChu);
                Button btnDong1 = viewtuchoi.findViewById(R.id.btnDong);
                Button btnChuyenChanhVanBan = viewtuchoi.findViewById(R.id.btnChuyenChanhVanBan);
                tvTieuDe.setText("Từ chối văn bản");
                btnChuyenChanhVanBan.setText("Chuyển trưởng phòng");
                btnDong1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btnChuyenChanhVanBan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().tuChoiVBChuTriChoXuLy(id, edtNoiDungTuChoi.getText().toString(), edtGhiChu.getText().toString());
                    }
                });
                dialog.show();
                break;
            case R.id.btnDeXuatThemHanGiaiQuyet:
                AlertDialog.Builder builderDongYChiDao = new AlertDialog.Builder(this);
                LayoutInflater inflaterDongYChiDao = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewDongYChiDao = inflaterDongYChiDao.inflate(R.layout.dialog_dexuatgiahan, null);
                builderDongYChiDao.setView(viewDongYChiDao);
                builderDongYChiDao.setCancelable(false);
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
                        // Get Current Date
                        final Calendar c = Calendar.getInstance();
                        mYear = c.get(Calendar.YEAR);
                        mMonth = c.get(Calendar.MONTH);
                        mDay = c.get(Calendar.DAY_OF_MONTH);
                        datePickerDialog = new DatePickerDialog(NDVBVanBanChuTriChoXuLyXLVBActivity.this,
                                new DatePickerDialog.OnDateSetListener() {
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
                                }, mYear, mMonth, mDay);
                        datePickerDialog.show();
                    }
                });
                btnDongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().themHanVBChuTriChoXuLy(id, tvNgayThangNam.getText().toString(), edtThemYKien.getText().toString());
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
    public void tuChoiVBChuTriChoXuLySuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void themHanVBChuTriChoXuLySuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
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


    @Override
    public NDVBVanBanChuTriChoXuLyXLVBPresenter createPresenter() {
        return new NDVBVanBanChuTriChoXuLyXLVBPresenterImpl(this);
    }


}
