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
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.model.VanBanDaPhanLoai;
import com.vpdt.vpdt.presenter.NoiDungVanBanDaPhanLoaiPresenter;
import com.vpdt.vpdt.presenter.NoiDungVanBanDaPhanLoaiView;
import com.vpdt.vpdt.presenter.impl.NoiDungVanBanDaPhanLoaiPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterTenCuaPhoGiamDoc;
import com.vpdt.vpdt.ui.adapter.AdapterTenGiamDoc;
import com.vpdt.vpdt.ui.adapter.AdapterTenPhong;
import com.vpdt.vpdt.ui.adapter.AdapterTenPhongPhoiHop;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoiDungVanBanDaPhanLoaiActivity extends BaseActivity<NoiDungVanBanDaPhanLoaiPresenter> implements NoiDungVanBanDaPhanLoaiView,
        AdapterTenGiamDoc.OnItemClickListener,
        AdapterTenPhong.OnItemClickListener,
        AdapterTenPhongPhoiHop.OnItemClickListener1,
        AdapterTenCuaPhoGiamDoc.OnItemTenCuaPhoGiamDocClickListener {

    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvNoigui)
    TextView tvNoigui;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;

    @BindView(R.id.tvNgayThangNam)
    TextView tvNgayThangNam;
    @BindView(R.id.tvChuyenGiamDoc)
    TextView tvChuyenGiamDoc;
    @BindView(R.id.tvChuyenPGiamDoc)
    TextView tvChuyenPGiamDoc;
    @BindView(R.id.tvChonChuTri)
    TextView tvChonChuTri;

    @BindView(R.id.edtChiDao1)
    EditText edtChiDao1;
    @BindView(R.id.edtChiDao2)
    EditText edtChiDao2;
    @BindView(R.id.edtChiDao3)
    EditText edtChiDao3;

    @BindView(R.id.btnChonPhoiHop)
    Button btnChonPhoiHop;

    @BindView(R.id.cbVbQuanTrong)
    CheckBox cbVbQuanTrong;

    int id;
    int idGiamDoc;
    int idPhoGiamDoc;
    int idPhongChuTri;
    private int mYear, mMonth, mDay;
    DatePickerDialog datePickerDialog;

    private AdapterTenPhong adapterTenPhong;
    private AdapterTenPhongPhoiHop adapterTenPhongPhoiHop;
    private AdapterTenGiamDoc adapterTenGiamDoc;
    private AdapterTenCuaPhoGiamDoc adapterTenCuaPhoGiamDoc;

    RecyclerView rcTenPhong;
    RecyclerView rcTenPhongPhoiHop;
    RecyclerView rcTenGiamDoc;

    AlertDialog dialog;
    private ArrayList<PhongBan> phongBansSelected = new ArrayList<>();
    String id_phongphoihop = "", hangiaiquyet, fileDinhKem;

    @Override
    public int getContentViewId() {
        return R.layout.activity_noi_dung_van_ban_da_phan_loai;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        getPresenter().getAllGiamDoc();
        getPresenter().getAllPhoGiamDoc();
        getPresenter().getAllPhongBan();
        VanBanDaPhanLoai vanBanDaPhanLoai = getIntent().getParcelableExtra("vanBanDaPhanLoai");
        if (vanBanDaPhanLoai != null) {
            if (vanBanDaPhanLoai.getIsVBQT()) {
                cbVbQuanTrong.setChecked(true);
            }
            id = vanBanDaPhanLoai.getId();
            idGiamDoc = vanBanDaPhanLoai.getIdGiamDoc();
            idPhoGiamDoc = vanBanDaPhanLoai.getIdPhoGiamDoc();
            idPhongChuTri = vanBanDaPhanLoai.getIdPhongChuTri();
            fileDinhKem = vanBanDaPhanLoai.getUrlFile();
            id_phongphoihop = vanBanDaPhanLoai.getIdPhongPhoiHop();
            tvNgay.setText(String.valueOf(vanBanDaPhanLoai.getNgayNhap()));
            tvChuyenGiamDoc.setText(String.valueOf(vanBanDaPhanLoai.getTenGiamDoc()));
            tvChuyenPGiamDoc.setText(String.valueOf(vanBanDaPhanLoai.getTenPhoGiamDoc()));
            tvChonChuTri.setText(String.valueOf(vanBanDaPhanLoai.getTenPhongChuTri()));
            edtChiDao1.setText(String.valueOf(vanBanDaPhanLoai.getChiDaoGiamDoc()));
            edtChiDao2.setText(String.valueOf(vanBanDaPhanLoai.getChiDaoPhoGiamDoc()));
            edtChiDao3.setText(String.valueOf(vanBanDaPhanLoai.getChiChuTri()));
            tvSKH.setText(String.valueOf(vanBanDaPhanLoai.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(vanBanDaPhanLoai.getSoDen()));
            tvNoigui.setText(String.valueOf(vanBanDaPhanLoai.getNoiGui()));
            tvNgayThangNam.setText(String.valueOf(vanBanDaPhanLoai.getHanGiaiQuyet()));
            tvTrichYeu.setText(vanBanDaPhanLoai.getMoTa() + "." + vanBanDaPhanLoai.getNoiDung());
            hangiaiquyet = vanBanDaPhanLoai.getHanGiaiQuyet();

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        edtChiDao3.addTextChangedListener(loginTextWatcher);
        String edtChiDao = edtChiDao3.getText().toString().trim();
        if (edtChiDao.isEmpty()) {
            btnChonPhoiHop.setEnabled(false);
        } else {
            btnChonPhoiHop.setEnabled(true);
        }
    }

    TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String chidao2 = edtChiDao3.getText().toString().trim();

            btnChonPhoiHop.setEnabled(!chidao2.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @OnClick({R.id.tvChuyenGiamDoc, R.id.tvChuyenPGiamDoc, R.id.tvChonChuTri,
            R.id.btnChonPhoiHop,
            R.id.tvNgayThangNam, R.id.lnNoiDungVB,
            R.id.btnBack, R.id.btnDuyet, R.id.tvFileDinhKem})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvChuyenGiamDoc:
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
                btnChuyenPGiamDoc.setText("Chuyển giám đốc");
                btnChuyenPGiamDoc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvChuyenGiamDoc.setText("");
                        edtChiDao1.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.tvChuyenPGiamDoc:
                AlertDialog.Builder builderPGiamDoc = new AlertDialog.Builder(this);
                LayoutInflater inflaterPGiamDoc = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewPGiamDoc = inflaterPGiamDoc.inflate(R.layout.dialog_ten_giam_doc, null);
                builderPGiamDoc.setView(viewPGiamDoc);
                dialog = builderPGiamDoc.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManagerPGiamDoc = new LinearLayoutManager(getApplicationContext());
                layoutManagerPGiamDoc.setOrientation(LinearLayoutManager.VERTICAL);

                rcTenGiamDoc = viewPGiamDoc.findViewById(R.id.rcTenGiamDoc);
                rcTenGiamDoc.setLayoutManager(layoutManagerPGiamDoc);
                rcTenGiamDoc.setAdapter(adapterTenCuaPhoGiamDoc);
                adapterTenCuaPhoGiamDoc.notifyDataSetChanged();

                dialog.show();
                TextView btnChuyenPGiamDocPGiamDoc = viewPGiamDoc.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyenPGiamDocPGiamDoc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvChuyenPGiamDoc.setText("");
                        edtChiDao2.setText("");
                        dialog.dismiss();
                    }
                });
                break;

            case R.id.tvChonChuTri:
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
                TextView tvChonChuTri1 = viewphong.findViewById(R.id.tvChonChuTri);
                tvChonChuTri1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvChonChuTri.setText("");
                        edtChiDao3.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.btnChonPhoiHop:

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

                rcTenPhongPhoiHop = viewphongphoihop.findViewById(R.id.rcTenPhongPhoiHop);

                rcTenPhongPhoiHop.setLayoutManager(layoutManagerPhoihop);
                rcTenPhongPhoiHop.setAdapter(adapterTenPhongPhoiHop);
                adapterTenPhongPhoiHop.notifyDataSetChanged();

                imgCancel.setOnClickListener(v -> dialog.dismiss());
                btnGhiLai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String chidao2 = "Chuyển " + tvChonChuTri.getText() + " chủ trì tham mưu. ";
                        int index = 0;
                        id_phongphoihop = "";
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
                        edtChiDao3.setText(chidao2);

                        dialog.dismiss();
                        phongBansSelected.clear();
                    }
                });

                break;

            case R.id.tvNgayThangNam:
                final Calendar c1 = Calendar.getInstance();
                mYear = c1.get(Calendar.YEAR);
                mMonth = c1.get(Calendar.MONTH);
                mDay = c1.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(NoiDungVanBanDaPhanLoaiActivity.this,
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
                break;

            case R.id.lnNoiDungVB:
                closeKeyboard();
                break;

            case R.id.btnBack:
                finish();
                break;

            case R.id.tvFileDinhKem:
                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(fileDinhKem));
                    startActivity(browserIntent);
                } catch (Exception e) {
                    Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnDuyet:
                hangiaiquyet = tvNgayThangNam.getText().toString();
                if (cbVbQuanTrong.isChecked()) {

                    getPresenter().duyetVanBanDaPhanLoai(id, idGiamDoc, idPhoGiamDoc, idPhongChuTri, hangiaiquyet, id_phongphoihop, edtChiDao1.getText().toString(), edtChiDao2.getText().toString(), edtChiDao3.getText().toString(), 1);
                } else {
                    getPresenter().duyetVanBanDaPhanLoai(id, idGiamDoc, idPhoGiamDoc, idPhongChuTri, hangiaiquyet, id_phongphoihop, edtChiDao1.getText().toString(), edtChiDao2.getText().toString(), edtChiDao3.getText().toString(), 2);
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

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetGiamdoccSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterTenGiamDoc = new AdapterTenGiamDoc(this, giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void onGetPhoGiamdocSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterTenCuaPhoGiamDoc = new AdapterTenCuaPhoGiamDoc(giamdocVaPhoGiamdoc, this);
    }


    @Override
    public void onGetPhongBanSuccess(ArrayList<PhongBan> phongBan) {
        adapterTenPhong = new AdapterTenPhong(this, phongBan, this);
        adapterTenPhongPhoiHop = new AdapterTenPhongPhoiHop(this, phongBan, this);
    }

    @Override
    public void duyetVanBanDaPhanLoaiSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NoiDungVanBanDaPhanLoaiPresenter createPresenter() {
        return new NoiDungVanBanDaPhanLoaiPresenterImpl(this);
    }

    @Override
    public void onItemClick(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        idGiamDoc = giamdocVaPhoGiamdoc.getId();
        tvChuyenGiamDoc.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        edtChiDao1.setText("Chuyển GĐ " + giamdocVaPhoGiamdoc.getHoTen() + " chỉ đạo");
        dialog.dismiss();
    }

    @Override
    public void onItemClick(PhongBan phongBan) {
        idPhongChuTri = phongBan.getId();
        tvChonChuTri.setText(String.valueOf(phongBan.getTenPhongBan()));
        edtChiDao3.setText("Chuyển " + phongBan.getTenPhongBan() + " chủ trì tham mưu.");
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
    public void onItemTenCuaPhoGiamDocClick(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        idPhoGiamDoc = giamdocVaPhoGiamdoc.getId();
        tvChuyenPGiamDoc.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        edtChiDao2.setText("Chuyển PGĐ " + giamdocVaPhoGiamdoc.getHoTen() + " chỉ đạo");
        dialog.dismiss();
    }
}
