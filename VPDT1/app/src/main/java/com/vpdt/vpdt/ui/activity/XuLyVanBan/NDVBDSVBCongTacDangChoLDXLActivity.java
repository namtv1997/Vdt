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
import com.vpdt.vpdt.model.DSVB_DaChiDao;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.model.TepDinhKem;
import com.vpdt.vpdt.presenter.NDVBDSVBCongTacDangChoLDXLPresenter;
import com.vpdt.vpdt.presenter.NDVBDSVBCongTacDangChoLDXLView;
import com.vpdt.vpdt.presenter.impl.NDVBDSVBCongTacDangChoLDXLPresenterImpl;
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

public class NDVBDSVBCongTacDangChoLDXLActivity extends BaseActivity<NDVBDSVBCongTacDangChoLDXLPresenter> implements NDVBDSVBCongTacDangChoLDXLView,
        DatePickerDialog.OnDateSetListener,
        AdapterTenGiamDoc.OnItemClickListener,
        AdapterTenPhong.OnItemClickListener,
        AdapterTenPhongPhoiHop.OnItemClickListener1,
        AdapterFileDinhKemChoLanhDaoXuLy.OnItemClickListenerFileDinhKem {

    @BindView(R.id.tvSKH)
    TextView tvSKHNDVBDSVBCongTacDangChoLDXL;
    @BindView(R.id.tvSoDen)
    TextView tvSoDenNDVBDSVBCongTacDangChoLDXL;
    @BindView(R.id.tvNoiGui)
    TextView tvNoiGuiNDVBDSVBCongTacDangChoLDXL;
    @BindView(R.id.tvNgay)
    TextView tvNgayNDVBDSVBCongTacDangChoLDXL;
    @BindView(R.id.tvLoaiVanban)
    TextView tvTenVBNDVBDSVBCongTacDangChoLDXL;
    @BindView(R.id.tvTrichYeuNDVBDSVBCongTacDangChoLDXL)
    TextView tvTrichYeuNDVBDSVBCongTacDangChoLDXL;
    @BindView(R.id.spnTenNDVBDSVBCongTacDangChoLDXL)
    TextView spnTenNDVBDSVBCongTacDangChoLDXL;
    @BindView(R.id.spnPhongNDVBDSVBCongTacDangChoLDXL)
    TextView spnPhongNDVBDSVBCongTacDangChoLDXL;
    @BindView(R.id.tvNgayThangNamNDVBDSVBCongTacDangChoLDXL)
    TextView tvNgayThangNamNDVBDSVBCongTacDangChoLDXL;

    @BindView(R.id.edtChiDao1NDVBDSVBCongTacDangChoLDXL)
    EditText edtChiDao1NDVBDSVBCongTacDangChoLDXL;
    @BindView(R.id.edtChiDao2NDVBDSVBCongTacDangChoLDXL)
    EditText edtChiDao2NDVBDSVBCongTacDangChoLDXL;

    @BindView(R.id.btnChonPhoiHopNDVBDSVBCongTacDangChoLDXL)
    Button btnChonPhoiHopNDVBDSVBCongTacDangChoLDXL;
    @BindView(R.id.btnDuyetNDVBDSVBCongTacDangChoLDXL)
    Button btnDuyetNDVBDSVBCongTacDangChoLDXL;

    @BindView(R.id.lnNoiDungVB)
    LinearLayout lnNoiDungVB;

    @BindView(R.id.rvFileDinhKem)
    RecyclerView rvFileDinhKem;

    @BindView(R.id.cbVBQTNDVBDSVBCongTacDangChoLDXL)
    CheckBox cbVBQTNDVBDSVBCongTacDangChoLDXL;

    RecyclerView rcTenPhong;
    RecyclerView rcTenPhongPhoiHop;
    RecyclerView rcTenGiamDoc;
    boolean click = false;
    DSVB_DaChiDao daChiDao;
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


    int idvbcongtacdang;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbdsvbcong_tac_dang_cho_ldxl;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("ID_VANBAN_CONGTACDANG")) {
                idvbcongtacdang = intent.getIntExtra("ID_VANBAN_CONGTACDANG", 0);
                getPresenter().getbyidvbcongtacdangchoxuly(idvbcongtacdang);

            }
        }
        edtChiDao2NDVBDSVBCongTacDangChoLDXL.addTextChangedListener(loginTextWatcher);
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess(DSVB_DaChiDao dsvb_daChiDao) {
        recyclerviewFileDinhKem((ArrayList<TepDinhKem>) dsvb_daChiDao.getTepDinhKems());
        getPresenter().getAllPhoGiamDoc();
        id_phogiamdoc = dsvb_daChiDao.getYKien().getIdGiamDoc();
        id_phongchutri = dsvb_daChiDao.getYKien().getIdChuTri();
        tvSKHNDVBDSVBCongTacDangChoLDXL.setText(String.valueOf(dsvb_daChiDao.getSoKyHieu()));
        tvTenVBNDVBDSVBCongTacDangChoLDXL.setText(String.valueOf(dsvb_daChiDao.getLoaiVanBan()));
        String shortDate = dsvb_daChiDao.getNgayNhan();
        tvNgayNDVBDSVBCongTacDangChoLDXL.setText(shortDate.substring(0, 5));
        tvSoDenNDVBDSVBCongTacDangChoLDXL.setText(String.valueOf(dsvb_daChiDao.getSoDen()));
        han_giai_quyet = tvNgayThangNamNDVBDSVBCongTacDangChoLDXL.getText().toString();
        tvNgayThangNamNDVBDSVBCongTacDangChoLDXL.setText(String.valueOf(dsvb_daChiDao.getHanGiaiQuyet()));
        tvTrichYeuNDVBDSVBCongTacDangChoLDXL.setText(String.valueOf(dsvb_daChiDao.getTrichYeu()));
        spnTenNDVBDSVBCongTacDangChoLDXL.setText(String.valueOf(dsvb_daChiDao.getYKien().getPhoGiamDoc()));
        spnPhongNDVBDSVBCongTacDangChoLDXL.setText(String.valueOf(dsvb_daChiDao.getYKien().getPhongChuTri()));
        if (dsvb_daChiDao.getChiDao1() != null) {
            edtChiDao1NDVBDSVBCongTacDangChoLDXL.setText(String.valueOf(dsvb_daChiDao.getChiDao1()));
        }
        if (dsvb_daChiDao.getChiDao2() != null) {
            edtChiDao2NDVBDSVBCongTacDangChoLDXL.setText(String.valueOf(dsvb_daChiDao.getChiDao2()));
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
    public void onGetDuyetVanBanCongTacDangChoXuLy() {
        finish();
        Toast.makeText(this, "Duyệt thành công", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onGetCongViecSuccess() {

    }

    @Override
    public NDVBDSVBCongTacDangChoLDXLPresenter createPresenter() {
        return new NDVBDSVBCongTacDangChoLDXLPresenterImpl(this);
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
        tvNgayThangNamNDVBDSVBCongTacDangChoLDXL.setText(date);
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

    @Override
    public void onItemClick(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        id_phogiamdoc = giamdocVaPhoGiamdoc.getId();
        spnTenNDVBDSVBCongTacDangChoLDXL.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        edtChiDao1NDVBDSVBCongTacDangChoLDXL.setText("Chuyển " + giamdocVaPhoGiamdoc.getHoTen() + " chỉ đạo");
        dialog.dismiss();
    }

    @Override
    public void onItemClick(PhongBan phongBan) {
        id_phongchutri = phongBan.getId();
        spnPhongNDVBDSVBCongTacDangChoLDXL.setText(String.valueOf(phongBan.getTenPhongBan()));
        edtChiDao2NDVBDSVBCongTacDangChoLDXL.setText("Chuyển " + phongBan.getTenPhongBan() + " chủ trì tham mưu.");
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
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.spnTenNDVBDSVBCongTacDangChoLDXL, R.id.spnPhongNDVBDSVBCongTacDangChoLDXL,
            R.id.btnChonPhoiHopNDVBDSVBCongTacDangChoLDXL,
            R.id.tvNgayThangNamNDVBDSVBCongTacDangChoLDXL, R.id.lnNoiDungVB,
            R.id.btnBack,
            R.id.btnDuyetNDVBDSVBCongTacDangChoLDXL, R.id.tvXemChiTietNDVBDSVBCongTacDangChoLDXL})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.spnTenNDVBDSVBCongTacDangChoLDXL:
                AlertDialog.Builder builder = new AlertDialog.Builder(NDVBDSVBCongTacDangChoLDXLActivity.this);
                LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.dialog_ten_giam_doc, null);
                builder.setView(view1);
                dialog = builder.create();
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                rcTenGiamDoc = view1.findViewById(R.id.rcTenGiamDoc);
                rcTenGiamDoc.setLayoutManager(layoutManager);
                rcTenGiamDoc.setAdapter(adapterTenGiamDoc);
                adapterTenPhong.notifyDataSetChanged();

                dialog.show();
                TextView btnChuyenPGiamDoc = view1.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyenPGiamDoc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        spnTenNDVBDSVBCongTacDangChoLDXL.setText("");
                        dialog.dismiss();
                    }
                });
                break;

            case R.id.spnPhongNDVBDSVBCongTacDangChoLDXL:
                AlertDialog.Builder builderphong = new AlertDialog.Builder(NDVBDSVBCongTacDangChoLDXLActivity.this);
                LayoutInflater inflaterphong = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewphong = inflaterphong.inflate(R.layout.dialog_ten_phong, null);
                builderphong.setView(viewphong);
                dialog = builderphong.create();

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
                        spnPhongNDVBDSVBCongTacDangChoLDXL.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.btnChonPhoiHopNDVBDSVBCongTacDangChoLDXL:
                if (spnTenNDVBDSVBCongTacDangChoLDXL.getText().equals("")) {
                    Toast.makeText(this, "Chưa chuyền P.Giám đốc", Toast.LENGTH_SHORT).show();
                } else if (spnPhongNDVBDSVBCongTacDangChoLDXL.getText().equals("")) {
                    Toast.makeText(this, "Chưa chọn chủ trì", Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder builderphongphoihop = new AlertDialog.Builder(NDVBDSVBCongTacDangChoLDXLActivity.this);
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

                            String chidao2 = "Chuyển " + spnPhongNDVBDSVBCongTacDangChoLDXL.getText() + " chủ trì tham mưu. ";
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
                            edtChiDao2NDVBDSVBCongTacDangChoLDXL.setText(chidao2);

                            dialog.dismiss();
                            phongBansSelected.clear();
                        }
                    });
                }
                break;

            case R.id.tvNgayThangNamNDVBDSVBCongTacDangChoLDXL:
                showDatePickerDialog();
                break;

            case R.id.lnNoiDungVB:
                closeKeyboard();
                break;
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTietNDVBDSVBCongTacDangChoLDXL:
                if (!click) {
                    Intent intent = new Intent(NDVBDSVBCongTacDangChoLDXLActivity.this, TTVBCongViecPhoiHopChoXuLyActivity.class);
                    intent.putExtra("ID_VANBAN_CONGVIECPHOIHOPCHOXULY", idvbcongtacdang);
                    startActivity(intent);
                    click = true;
                }

                break;

            case R.id.btnDuyetNDVBDSVBCongTacDangChoLDXL:
                if (cbVBQTNDVBDSVBCongTacDangChoLDXL.isChecked()) {
                    getPresenter().duyetvbdencongTacDangChoXuLy(idvbcongtacdang, id_phogiamdoc, id_phongchutri,
                            id_phongphoihop,
                            edtChiDao1NDVBDSVBCongTacDangChoLDXL.getText().toString(), edtChiDao2NDVBDSVBCongTacDangChoLDXL.getText().toString(), true,
                            tvNgayThangNamNDVBDSVBCongTacDangChoLDXL.getText().toString(), true);
                } else {
                    getPresenter().duyetvbdencongTacDangChoXuLy(idvbcongtacdang, id_phogiamdoc, id_phongchutri,
                            id_phongphoihop,
                            edtChiDao1NDVBDSVBCongTacDangChoLDXL.getText().toString(), edtChiDao2NDVBDSVBCongTacDangChoLDXL.getText().toString(), true,
                            tvNgayThangNamNDVBDSVBCongTacDangChoLDXL.getText().toString(), false);
                }


                break;
        }
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
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

    void recyclerviewFileDinhKem(ArrayList<TepDinhKem> tepDinhKems) {
        adapterFileDinhKemChoLanhDaoXuLy = new AdapterFileDinhKemChoLanhDaoXuLy(this, tepDinhKems, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvFileDinhKem.setLayoutManager(layoutManager);
        rvFileDinhKem.setAdapter(adapterFileDinhKemChoLanhDaoXuLy);
        adapterFileDinhKemChoLanhDaoXuLy.notifyDataSetChanged();
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String chidao2 = edtChiDao2NDVBDSVBCongTacDangChoLDXL.getText().toString().trim();

            btnChonPhoiHopNDVBDSVBCongTacDangChoLDXL.setEnabled(!chidao2.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
