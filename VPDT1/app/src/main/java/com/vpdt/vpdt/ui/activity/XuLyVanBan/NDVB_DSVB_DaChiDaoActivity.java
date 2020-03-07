package com.vpdt.vpdt.ui.activity.XuLyVanBan;

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
import android.text.Editable;
import android.text.TextWatcher;
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
import com.vpdt.vpdt.model.DSVB_DaChiDao;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.model.TepDinhKem;
import com.vpdt.vpdt.presenter.NDVB_DSVB_DaChiDaoPresenter;
import com.vpdt.vpdt.presenter.NDVB_DSVB_DaChiDaoView;
import com.vpdt.vpdt.presenter.impl.NDVB_DSVB_DaChiDaoPresenterImpl;
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

public class NDVB_DSVB_DaChiDaoActivity extends BaseActivity<NDVB_DSVB_DaChiDaoPresenter> implements NDVB_DSVB_DaChiDaoView,
        DatePickerDialog.OnDateSetListener, AdapterTenGiamDoc.OnItemClickListener, AdapterTenPhong.OnItemClickListener,
        AdapterTenPhongPhoiHop.OnItemClickListener1, AdapterFileDinhKemChoLanhDaoXuLy.OnItemClickListenerFileDinhKem {

    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvNoiGui)
    TextView tvNoiGui;
    @BindView(R.id.tvLoaiVanban)
    TextView tvLoaiVanban;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvTenNDVB_DSVB_DaChiDao)
    TextView tvTenNDVB_DSVB_DaChiDao;
    @BindView(R.id.tvPhongNDVB_DSVB_DaChiDao)
    TextView tvPhongNDVB_DSVB_DaChiDao;
    @BindView(R.id.tvNgayThangNamNDVB_DSVB_DaChiDao)
    TextView tvNgayThangNamNDVB_DSVB_DaChiDao;
    @BindView(R.id.tvXemChiTietNDVB_DSVB_DaChiDao)
    TextView tvXemChiTietNDVB_DSVB_DaChiDao;

    @BindView(R.id.edtChiDao1)
    EditText edtChiDao1;
    @BindView(R.id.edtChiDao2)
    EditText edtChiDao2;

    @BindView(R.id.btnChonPhoiHop)
    Button btnChonPhoiHop;
    @BindView(R.id.btnDuyet)
    Button btnDuyet;

    @BindView(R.id.lnNDVB_DSVB_DaChiDao)
    LinearLayout lnNDVB_DSVB_DaChiDao;
    @BindView(R.id.rvFileDinhKem)
    RecyclerView rvFileDinhKem;

    RecyclerView rcTenPhong;
    RecyclerView rcTenPhongPhoiHop;
    RecyclerView rcTenGiamDoc;

    String id_phongphoihop = "";
    private AdapterFileDinhKemChoLanhDaoXuLy adapterFileDinhKemChoLanhDaoXuLy;
    private AdapterTenPhong adapterTenPhong;
    private AdapterTenPhongPhoiHop adapterTenPhongPhoiHop;
    private AdapterTenGiamDoc adapterTenGiamDoc;
    AlertDialog dialog;
    private ArrayList<PhongBan> phongBansSelected = new ArrayList<>();
    int id;
    int id_phogiamdoc;
    int id_phongchutri;
    String chidao_phogiamdoc;
    String chidao_phongchutri;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvb__dsvb__da_chi_dao;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("ID_VANBAN")) {
                id = intent.getIntExtra("ID_VANBAN", 0);
                getPresenter().getbyidvblanhdaodachidao(id);
            }
        }
        edtChiDao2.addTextChangedListener(loginTextWatcher);
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
    public void onGetDataSuccess(DSVB_DaChiDao dsvbDaChiDao) {
        recyclerviewFileDinhKem((ArrayList<TepDinhKem>) dsvbDaChiDao.getTepDinhKems());
        getPresenter().getAllPhoGiamDoc();
        id_phogiamdoc = dsvbDaChiDao.getYKien().getIdGiamDoc();
        id_phongchutri = dsvbDaChiDao.getYKien().getIdChuTri();
        tvLoaiVanban.setText(String.valueOf(dsvbDaChiDao.getLoaiVanBan()));
        tvNoiGui.setText(String.valueOf(dsvbDaChiDao.getNoiGuiDen()));
        tvSKH.setText(String.valueOf(dsvbDaChiDao.getSoKyHieu()));
        String shortDate = dsvbDaChiDao.getNgayNhan();
        tvNgay.setText(String.valueOf(shortDate.substring(0, 5)));
        tvSoDen.setText(String.valueOf(dsvbDaChiDao.getSoDen()));
        tvNgayThangNamNDVB_DSVB_DaChiDao.setText(String.valueOf(dsvbDaChiDao.getHanGiaiQuyet()));
        tvTenNDVB_DSVB_DaChiDao.setText(String.valueOf(dsvbDaChiDao.getYKien().getPhoGiamDoc()));
        tvPhongNDVB_DSVB_DaChiDao.setText(String.valueOf(dsvbDaChiDao.getYKien().getPhongChuTri()));
        tvTrichYeu.setText(String.valueOf(dsvbDaChiDao.getTrichYeu()));
        if (dsvbDaChiDao.getChiDao1() != null) {
            chidao_phogiamdoc = edtChiDao1.getText().toString();
            edtChiDao1.setText(String.valueOf(dsvbDaChiDao.getChiDao1()));
        }
        if (dsvbDaChiDao.getChiDao2() != null) {
            chidao_phongchutri = edtChiDao2.getText().toString();
            edtChiDao2.setText(String.valueOf(dsvbDaChiDao.getChiDao2()));
        }
    }

    @Override
    public void onGetDataPhongSTCSuccess(DSVB_DaChiDao dsvbDaChiDao) {

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
    public void onGetDuyetVanBanLanhDaoDaChiDao() {
        Toast.makeText(this, "Duyệt thành công", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onGetDuyetduyetvbstcphoihopdachidao() {

    }

    @Override
    public void onGetCongViecSuccess() {

    }

    @Override
    public NDVB_DSVB_DaChiDaoPresenter createPresenter() {
        return new NDVB_DSVB_DaChiDaoPresenterImpl(this);
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
        tvNgayThangNamNDVB_DSVB_DaChiDao.setText(date);
    }

    @OnClick({R.id.btnChonPhoiHop, R.id.tvNgayThangNamNDVB_DSVB_DaChiDao, R.id.lnNDVB_DSVB_DaChiDao,
            R.id.imvBack, R.id.btnDuyet, R.id.tvXemChiTietNDVB_DSVB_DaChiDao,
            R.id.tvTenNDVB_DSVB_DaChiDao, R.id.tvPhongNDVB_DSVB_DaChiDao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvTenNDVB_DSVB_DaChiDao:
                AlertDialog.Builder builder = new AlertDialog.Builder(NDVB_DSVB_DaChiDaoActivity.this);
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
                        tvTenNDVB_DSVB_DaChiDao.setText("");
                        edtChiDao1.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.tvPhongNDVB_DSVB_DaChiDao:
                AlertDialog.Builder builderphong = new AlertDialog.Builder(NDVB_DSVB_DaChiDaoActivity.this);
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
                        tvPhongNDVB_DSVB_DaChiDao.setText("");
                        edtChiDao2.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.btnChonPhoiHop:
                if (tvPhongNDVB_DSVB_DaChiDao.getText().equals("")) {
                    Toast.makeText(this, "Chưa chọn chủ trì", Toast.LENGTH_SHORT).show();
                } else {
                    AlertDialog.Builder builderphongphoihop = new AlertDialog.Builder(NDVB_DSVB_DaChiDaoActivity.this);
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
                            String chidao2 = "Chuyển " + tvPhongNDVB_DSVB_DaChiDao.getText() + " chủ trì tham mưu. ";
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
                            edtChiDao2.setText(chidao2);
                            dialog.dismiss();
                            phongBansSelected.clear();
                        }
                    });
                }
                break;
            case R.id.tvNgayThangNamNDVB_DSVB_DaChiDao:
                showDatePickerDialog();
                break;
            case R.id.lnNDVB_DSVB_DaChiDao:
                closeKeyboard();
                break;
            case R.id.imvBack:
                finish();
                break;
            case R.id.tvXemChiTietNDVB_DSVB_DaChiDao:
                if (!click) {
                    Intent intent1 = new Intent(this, TTVBCongViecPhoiHopChoXuLyActivity.class);
                    intent1.putExtra("ID_VANBAN_CONGVIECPHOIHOPCHOXULY", id);
                    startActivity(intent1);
                    click = true;
                }
                break;
            case R.id.btnDuyet:
                chidao_phogiamdoc = edtChiDao1.getText().toString();
                chidao_phongchutri= edtChiDao2.getText().toString();
                getPresenter().duyetvbdenLanhdaodachidao(id, id_phogiamdoc, id_phongchutri,
                        id_phongphoihop,
                        chidao_phogiamdoc, chidao_phongchutri, true,
                        tvNgayThangNamNDVB_DSVB_DaChiDao.getText().toString(), true);
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
        id_phogiamdoc = giamdocVaPhoGiamdoc.getId();
        chidao_phogiamdoc = edtChiDao1.getText().toString();
        tvTenNDVB_DSVB_DaChiDao.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        edtChiDao1.setText("Chuyển " + giamdocVaPhoGiamdoc.getHoTen() + " chỉ đạo");
        dialog.dismiss();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onItemClick(PhongBan phongBan) {
        id_phongchutri = phongBan.getId();
        chidao_phongchutri = edtChiDao2.getText().toString();
        tvPhongNDVB_DSVB_DaChiDao.setText(String.valueOf(phongBan.getTenPhongBan()));
        edtChiDao2.setText("Chuyển " + phongBan.getTenPhongBan() + " chủ trì tham mưu.");
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

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String chidao2 = edtChiDao2.getText().toString().trim();
            btnChonPhoiHop.setEnabled(!chidao2.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

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
