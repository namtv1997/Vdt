package com.vpdt.vpdt.ui.activity.QuanLyDauViec;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.Item;
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.presenter.NDVBDauViecChoXuLyPresenter;
import com.vpdt.vpdt.presenter.NDVBDauViecChoXuLyView;
import com.vpdt.vpdt.presenter.impl.NDVBDauViecChoXuLyPresenterImpl;
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

public class NDVBDauViecChoXuLyActivity extends BaseActivity<NDVBDauViecChoXuLyPresenter> implements NDVBDauViecChoXuLyView,
        DatePickerDialog.OnDateSetListener,
        AdapterTenGiamDoc.OnItemClickListener,
        AdapterTenPhong.OnItemClickListener,
        AdapterTenPhongPhoiHop.OnItemClickListener1 {

    @BindView(R.id.tvHanVanBan)
    TextView tvHanVanBan;
    @BindView(R.id.tvNguoiNhap)
    TextView tvNguoiNhap;
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvNgayThangNam)
    TextView tvNgayThangNam;
    @BindView(R.id.tvTenGD)
    TextView tvTenGD;
    @BindView(R.id.tvPhong)
    TextView tvPhong;
    @BindView(R.id.tvNgayNhap)
    TextView tvNgayNhap;

    @BindView(R.id.edtChiDao1)
    EditText edtChiDao1;
    @BindView(R.id.edtChiDao2)
    EditText edtChiDao2;
    @BindView(R.id.edtChiDao3)
    EditText edtChiDao3;

    @BindView(R.id.btnChonPhoiHop)
    Button btnChonPhoiHop;
    @BindView(R.id.btnDuyet)
    Button btnDuyet;


    @BindView(R.id.tvXemChiTiet)
    TextView tvXemChiTiet;
    @BindView(R.id.btnBack)
    ImageView btnBack;
    int id, level;
    int idPhoGiamDoc;
    int idPhongChuTri;

    private AdapterTenPhong adapterTenPhong;
    private AdapterTenPhongPhoiHop adapterTenPhongPhoiHop;
    private AdapterTenGiamDoc adapterTenGiamDoc;
    boolean click = false;
    RecyclerView rcTenPhong;
    RecyclerView rcTenPhongPhoiHop;
    RecyclerView rcTenGiamDoc;
    AlertDialog dialog;

    private ArrayList<PhongBan> phongBansSelected = new ArrayList<>();
    String id_phongphoihop = "";


    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbdau_viec_cho_xu_ly;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Item item = getIntent().getParcelableExtra("item");
        if (item != null) {
            level = PrefUtil.getInt(this, Key.LEVEL, 0);
            id = item.getId();
            idPhoGiamDoc = item.getPhoGiamDocId();
            idPhongChuTri = item.getPhongChuTriId();
            String shortdate = item.getNgayNhap();
            tvNgay.setText(shortdate.substring(0, 5));
            tvTrichYeu.setText(item.getMota());
            tvHanVanBan.setText(item.getHanVanban());
            tvNguoiNhap.setText(item.getNguoiNhap());
            tvNgayThangNam.setText(String.valueOf(item.getHanXuly()));
            tvTenGD.setText(String.valueOf(item.getPhoGiamDoc()));
            tvPhong.setText(String.valueOf(item.getPhongChuTri()));
            tvNgayNhap.setText(String.valueOf(item.getNgayNhap()));
            edtChiDao1.setText(String.valueOf(item.getNoiDungChuyenPgd()));
            edtChiDao2.setText(String.valueOf(item.getNoiDungChuyenPct()));
            edtChiDao3.setText(String.valueOf(item.getNoiDungPhongPh()));
            if (level == 5) {
                tvTenGD.setVisibility(View.GONE);
                edtChiDao1.setVisibility(View.GONE);
            }
        }

        getPresenter().getAllPhoGiamDoc();
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
        edtChiDao2.addTextChangedListener(loginTextWatcher);
        String edtChiDao = edtChiDao2.getText().toString().trim();
        if (edtChiDao.isEmpty()) {
            btnChonPhoiHop.setEnabled(false);
        } else {
            btnChonPhoiHop.setEnabled(true);
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetGiamdocVaPhoGiamdocSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {

        adapterTenGiamDoc = new AdapterTenGiamDoc(this, giamdocVaPhoGiamdoc, this);
        getPresenter().getAllPhongBan();
    }

    @Override
    public void onGetPhongBanSuccess(ArrayList<PhongBan> phongBan) {
        adapterTenPhong = new AdapterTenPhong(this, phongBan, this);
        adapterTenPhongPhoiHop = new AdapterTenPhongPhoiHop(this, phongBan, this);
    }

    @Override
    public void duyetdauviecSuccess() {
        Toast.makeText(this, "Duyệt thành công", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NDVBDauViecChoXuLyPresenter createPresenter() {
        return new NDVBDauViecChoXuLyPresenterImpl(this);
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

    @Override
    public void onItemClick(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        idPhoGiamDoc = giamdocVaPhoGiamdoc.getId();
        tvTenGD.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        edtChiDao1.setText("Chuyển PGD" + giamdocVaPhoGiamdoc.getHoTen() + " chủ trì giải quyết");
        dialog.dismiss();
    }

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

    @OnClick({R.id.tvTenGD, R.id.tvPhong,
            R.id.btnChonPhoiHop,
            R.id.tvNgayThangNam, R.id.lnNoiDungVB,
            R.id.btnBack,
            R.id.btnDuyet, R.id.tvXemChiTiet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvTenGD:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.dialog_ten_giam_doc, null);
                builder.setView(view1);
                dialog = builder.create();
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
                        tvTenGD.setText("");
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
                if (level == 4) {
                    if (tvTenGD.getText().equals("")) {
                        Toast.makeText(this, "Chưa chuyền P.Giám đốc", Toast.LENGTH_SHORT).show();
                    } else if (tvPhong.getText().equals("")) {
                        Toast.makeText(this, "Chưa chọn chủ trì", Toast.LENGTH_SHORT).show();
                    } else {
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
                                        id_phongphoihop += "" + item.getId();
                                        chidao2 += item.getTenPhongBan() + " phối hợp giải quyết.";
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
                    }
                } else {
                    if (tvPhong.getText().equals("")) {
                        Toast.makeText(this, "Chưa chọn chủ trì", Toast.LENGTH_SHORT).show();
                    } else {
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
                                        id_phongphoihop += "" + item.getId();
                                        chidao2 += item.getTenPhongBan() + " phối hợp giải quyết.";
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
                    }
                }
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
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBDauViecChoXuLyActivity.class);
                    intent.putExtra("DauViecChoXuLy", id);
                    startActivity(intent);
                    click = true;
                }

                break;
            case R.id.btnDuyet:
                if (level == 5) {
                    getPresenter().duyetdauviec(id, 0, "", idPhongChuTri,
                            id_phongphoihop, edtChiDao3.getText().toString(), tvNgayThangNam.getText().toString());
                } else {
                    getPresenter().duyetdauviec(id, idPhoGiamDoc, edtChiDao1.getText().toString(), idPhongChuTri,
                            id_phongphoihop, edtChiDao3.getText().toString(), tvNgayThangNam.getText().toString());
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
}
