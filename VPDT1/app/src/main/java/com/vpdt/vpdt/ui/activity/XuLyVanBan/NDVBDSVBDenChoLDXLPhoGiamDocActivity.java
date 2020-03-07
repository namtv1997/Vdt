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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.model.TepDinhKem;
import com.vpdt.vpdt.model.VanBanDenChoXuLy;
import com.vpdt.vpdt.presenter.NDVBDSVBDenChoLDXLPresenter;
import com.vpdt.vpdt.presenter.NDVBDSVBDenChoLDXLView;
import com.vpdt.vpdt.presenter.impl.NDVBDSVBDenChoLDXLPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterFileDinhKemChoLanhDaoXuLy;
import com.vpdt.vpdt.ui.adapter.AdapterTenGiamDoc;
import com.vpdt.vpdt.ui.adapter.AdapterTenPhong;
import com.vpdt.vpdt.ui.adapter.AdapterTenPhongPhoiHop;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDSVBDenChoLDXLPhoGiamDocActivity extends BaseActivity<NDVBDSVBDenChoLDXLPresenter> implements NDVBDSVBDenChoLDXLView,
        DatePickerDialog.OnDateSetListener, AdapterTenGiamDoc.OnItemClickListener,
        AdapterTenPhong.OnItemClickListener, AdapterTenPhongPhoiHop.OnItemClickListener1,
        AdapterFileDinhKemChoLanhDaoXuLy.OnItemClickListenerFileDinhKem {

    @BindView(R.id.tvSKH)
    TextView tvSKHNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvSoDen)
    TextView tvSoDenNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvNoigui)
    TextView tvNoiGuiNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvNgay)
    TextView tvNgayNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvLoaiVanBan)
    TextView tvLoaiVanBan;
    @BindView(R.id.tvTrichYeuNDVBDSVBDenChoLDXL)
    TextView tvTrichYeuNDVBDSVBDenChoLDXL;
    @BindView(R.id.spnTenNDVBDSVBDenChoLDXL)
    TextView spnTenNDVBDSVBDenChoLDXL;
    @BindView(R.id.spnPhongNDVBDSVBDenChoLDXL)
    TextView spnPhongNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvNgayThangNamNDVBDSVBDenChoLDXL)
    TextView tvNgayThangNamNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvNoiDungTuChoi)
    TextView tvNoiDungTuChoi;
    @BindView(R.id.tvPhongGuiLai)
    TextView tvPhongGuiLai;
    @BindView(R.id.tvChiDao)
    TextView tvChiDao;

    @BindView(R.id.tvChiDao1NDVBDSVBDenChoLDXL)
    EditText tvChiDao1NDVBDSVBDenChoLDXL;
    @BindView(R.id.tvChiDao2NDVBDSVBDenChoLDXL)
    EditText tvChiDao2NDVBDSVBDenChoLDXL;

    @BindView(R.id.btnChonPhoiHopNDVBDSVBDenChoLDXL)
    Button btnChonPhoiHopNDVBDSVBDenChoLDXL;
    @BindView(R.id.btnDuyet)
    Button btnDuyet;
    @BindView(R.id.btnChonDeLuu)
    Button btnChonDeLuu;
    @BindView(R.id.cbVBQPPLNDVBDSVBDenChoLDXL)
    CheckBox cbVBQPPLNDVBDSVBDenChoLDXL;

    @BindView(R.id.lnNoiDungVB)
    LinearLayout lnNoiDungVB;
    @BindView(R.id.lnChiDao)
    LinearLayout lnChiDao;
    @BindView(R.id.lnLuuY)
    LinearLayout lnLuuY;
    @BindView(R.id.lnVanBanThuocLoai)
    LinearLayout lnVanBanThuocLoai;
    @BindView(R.id.lnNoiDungTuChoi)
    LinearLayout lnNoiDungTuChoi;
    @BindView(R.id.lnPhongGuiLai)
    LinearLayout lnPhongGuiLai;

    @BindView(R.id.rvFileDinhKem)
    RecyclerView rvFileDinhKem;

    RecyclerView rcTenPhong;
    RecyclerView rcTenPhongPhoiHop;
    RecyclerView rcTenGiamDoc;

    String id_phongphoihop = "";
    private AdapterTenPhong adapterTenPhong;
    private AdapterTenPhongPhoiHop adapterTenPhongPhoiHop;
    private AdapterTenGiamDoc adapterTenGiamDoc;
    private AdapterFileDinhKemChoLanhDaoXuLy adapterFileDinhKemChoLanhDaoXuLy;
    AlertDialog dialog;
    private ArrayList<PhongBan> phongBansSelected = new ArrayList<>();

    int id_phogiamdoc;
    int id_phongchutri;
    String han_giai_quyet;
    int idvbdenchoxuly;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbdsvbden_cho_ldxlpho_giam_doc;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("ID_VANBAN_CHOLANHDAOXULY")) {
                idvbdenchoxuly = intent.getIntExtra("ID_VANBAN_CHOLANHDAOXULY", 0);
                getPresenter().getbyidvbdenchoxuly(idvbdenchoxuly);
            }
        }
        tvChiDao2NDVBDSVBDenChoLDXL.addTextChangedListener(loginTextWatcher);
    }

    @Override
    protected void onStart() {
        super.onStart();
        String chidao2 = tvChiDao2NDVBDSVBDenChoLDXL.getText().toString().trim();
        if (chidao2.isEmpty()) {
            btnChonPhoiHopNDVBDSVBDenChoLDXL.setEnabled(false);
        } else {
            btnChonPhoiHopNDVBDSVBDenChoLDXL.setEnabled(true);
        }
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String chidao2 = tvChiDao2NDVBDSVBDenChoLDXL.getText().toString().trim();

            btnChonPhoiHopNDVBDSVBDenChoLDXL.setEnabled(!chidao2.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess(VanBanDenChoXuLy dsvb_daChiDao) {

        recyclerviewFileDinhKem((ArrayList<TepDinhKem>) dsvb_daChiDao.getTepDinhKems());
        getPresenter().getAllPhoGiamDoc();
        if (dsvb_daChiDao.getVbBGD()) {
            lnLuuY.setVisibility(View.VISIBLE);
            tvChiDao.setVisibility(View.VISIBLE);
            btnChonDeLuu.setVisibility(View.VISIBLE);
            lnChiDao.setVisibility(View.GONE);
            cbVBQPPLNDVBDSVBDenChoLDXL.setVisibility(View.GONE);
            spnTenNDVBDSVBDenChoLDXL.setVisibility(View.GONE);
            lnNoiDungTuChoi.setVisibility(View.GONE);
            lnPhongGuiLai.setVisibility(View.GONE);
            btnChonPhoiHopNDVBDSVBDenChoLDXL.setEnabled(false);
            spnPhongNDVBDSVBDenChoLDXL.setEnabled(false);
        } else if (!dsvb_daChiDao.getVbBGD()) {
            btnDuyet.setVisibility(View.VISIBLE);
        }
        id_phogiamdoc = dsvb_daChiDao.getYKien().getIdGiamDoc();
        id_phongchutri = dsvb_daChiDao.getYKien().getIdChuTri();
        tvSKHNDVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getSoKyHieu()));
        tvNoiGuiNDVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getNoiGuiDen()));
        String shortDate = dsvb_daChiDao.getNgayNhan();
        tvNgayNDVBDSVBDenChoLDXL.setText(shortDate.substring(0, 5));
        tvSoDenNDVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getSoDen()));
        if (dsvb_daChiDao.getNoiDungTuchoi() == null) {
            lnNoiDungTuChoi.setVisibility(View.GONE);
        }
        tvNoiDungTuChoi.setText(String.valueOf(dsvb_daChiDao.getNoiDungTuchoi()));
        if (dsvb_daChiDao.getPhongGuiLai() == null) {
            lnPhongGuiLai.setVisibility(View.GONE);
        }
        tvPhongGuiLai.setText(String.valueOf(dsvb_daChiDao.getPhongGuiLai()));
        tvNgayThangNamNDVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getHanGiaiQuyet()));
        tvTrichYeuNDVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getTrichYeu()));
        spnTenNDVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getYKien().getPhoGiamDoc()));
        spnPhongNDVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getYKien().getPhongChuTri()));
        if (dsvb_daChiDao.getChiDao1() != null) {
            tvChiDao1NDVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getChiDao1()));
        }
        if (dsvb_daChiDao.getChiDao2() != null) {
            tvChiDao2NDVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getChiDao2()));
            tvChiDao.setText(String.valueOf(dsvb_daChiDao.getChiDao2()));
        }


    }


    @Override
    public void onGetGiamdocVaPhoGiamdocSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        getPresenter().getAllPhongBan();
        adapterTenGiamDoc = new AdapterTenGiamDoc(this, giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void onGetPhongBanSuccess(ArrayList<PhongBan> phongBan) {
        adapterTenPhong = new AdapterTenPhong(this, phongBan, this);
        adapterTenPhongPhoiHop = new AdapterTenPhongPhoiHop(this, phongBan, this);
    }

    @Override
    public void onGetDuyetVanBandenchoxuly() {
        Toast.makeText(this, "Duyệt thành công", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onchonDeLuuVanBanchoxuly() {
        Toast.makeText(this, "Duyệt thành công", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onGetCongViecSuccess() {

    }

    @Override
    public void onGetThemNoiDungSuccess() {

    }

    @Override
    public NDVBDSVBDenChoLDXLPresenter createPresenter() {
        return new NDVBDSVBDenChoLDXLPresenterImpl(this);
    }

    @OnClick({R.id.spnTenNDVBDSVBDenChoLDXL, R.id.spnPhongNDVBDSVBDenChoLDXL,
            R.id.btnChonPhoiHopNDVBDSVBDenChoLDXL,
            R.id.tvNgayThangNamNDVBDSVBDenChoLDXL, R.id.lnNoiDungVB,
            R.id.btnBack,
            R.id.btnDuyet, R.id.tvXemChiTietNDVBDSVBDenChoLDXL, R.id.btnChonDeLuu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.spnTenNDVBDSVBDenChoLDXL:
                AlertDialog.Builder builder = new AlertDialog.Builder(NDVBDSVBDenChoLDXLPhoGiamDocActivity.this);
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
                AlertDialog.Builder builderphong = new AlertDialog.Builder(NDVBDSVBDenChoLDXLPhoGiamDocActivity.this);
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
                tvChonChuTri.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(this, "Chưa chọn chủ trì", Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder builderphongphoihop = new AlertDialog.Builder(NDVBDSVBDenChoLDXLPhoGiamDocActivity.this);
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
                            dialog.dismiss();
                        }
                    });
                    btnGhiLai.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            String chidao2 = "Chuyển " + spnPhongNDVBDSVBDenChoLDXL.getText() + " chủ trì tham mưu.";
                            int index = 0;

                            for (PhongBan item : phongBansSelected) {

                                index++;
                                if (index == phongBansSelected.size()) {
                                    id_phongphoihop += "" + item.getId();
                                    chidao2 += item.getTenPhongBan() + " phối hợp.";
                                } else {
                                    id_phongphoihop += item.getId() + ",";
                                    chidao2 += item.getTenPhongBan() + ", ";
                                }
                            }
                            tvChiDao2NDVBDSVBDenChoLDXL.setText(chidao2);
                            phongBansSelected.clear();
                            dialog.dismiss();

                        }
                    });
                }
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
                Intent intent = new Intent(NDVBDSVBDenChoLDXLPhoGiamDocActivity.this, TTVBCongViecPhoiHopChoXuLyActivity.class);
                intent.putExtra("ID_VANBAN_CONGVIECPHOIHOPCHOXULY", idvbdenchoxuly);
                startActivity(intent);
                break;

            case R.id.btnDuyet:
                han_giai_quyet = tvNgayThangNamNDVBDSVBDenChoLDXL.getText().toString();
                if (cbVBQPPLNDVBDSVBDenChoLDXL.isChecked()) {
                    getPresenter().duyetvbdenchoxuly(idvbdenchoxuly, id_phogiamdoc, id_phongchutri, id_phongphoihop,
                            tvChiDao1NDVBDSVBDenChoLDXL.getText().toString(), tvChiDao2NDVBDSVBDenChoLDXL.getText().toString(), false,
                            han_giai_quyet, true);
                } else {
                    getPresenter().duyetvbdenchoxuly(idvbdenchoxuly, id_phogiamdoc, id_phongchutri, id_phongphoihop,
                            tvChiDao1NDVBDSVBDenChoLDXL.getText().toString(), tvChiDao2NDVBDSVBDenChoLDXL.getText().toString(), false,
                            han_giai_quyet, false);
                }
                break;
            case R.id.btnChonDeLuu:
                getPresenter().chonDeLuuVanBan(idvbdenchoxuly);
                break;
        }
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
    public void onItemClick(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        id_phogiamdoc = giamdocVaPhoGiamdoc.getId();
        spnTenNDVBDSVBDenChoLDXL.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        tvChiDao1NDVBDSVBDenChoLDXL.setText("Chuyển " + giamdocVaPhoGiamdoc.getHoTen() + " chỉ đạo");
        dialog.dismiss();
    }

    @Override
    public void onItemClick(PhongBan phongBan) {
        id_phongchutri = phongBan.getId();
        spnPhongNDVBDSVBDenChoLDXL.setText(String.valueOf(phongBan.getTenPhongBan()));
        tvChiDao2NDVBDSVBDenChoLDXL.setText("Chuyển " + phongBan.getTenPhongBan() + " chủ trì tham mưu.");
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
    public void onItemClickFileDinhKem(TepDinhKem dinhKem) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dinhKem.getDuongDan()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    void recyclerviewFileDinhKem(ArrayList<TepDinhKem> tepDinhKems) {
        adapterFileDinhKemChoLanhDaoXuLy = new AdapterFileDinhKemChoLanhDaoXuLy(this, tepDinhKems, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvFileDinhKem.setLayoutManager(layoutManager);
        rvFileDinhKem.setAdapter(adapterFileDinhKemChoLanhDaoXuLy);
        adapterFileDinhKemChoLanhDaoXuLy.notifyDataSetChanged();
    }
}
