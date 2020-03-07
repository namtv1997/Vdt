package com.vpdt.vpdt.ui.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.KhuVuc;
import com.vpdt.vpdt.model.LoaiVanBan_Nhap;
import com.vpdt.vpdt.model.NguoiKy_nhap;
import com.vpdt.vpdt.presenter.SearchPresenter;
import com.vpdt.vpdt.presenter.SearchView;
import com.vpdt.vpdt.presenter.impl.SearchPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterChucVu;
import com.vpdt.vpdt.ui.adapter.AdapterLoaiVanBanNhap;
import com.vpdt.vpdt.ui.adapter.AdapterNguoiKyNhap;
import com.vpdt.vpdt.util.PrefUtil;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity<SearchPresenter> implements SearchView,
        AdapterLoaiVanBanNhap.OnItemLoaiVanBanClickListener, AdapterNguoiKyNhap.OnItemNguoiKyClickListener, AdapterChucVu.OnItemChucVuClickListener {

    @BindView(R.id.tvLoaiVanBan)
    TextView tvLoaiVanBan;
    @BindView(R.id.tvNoiGuiDen)
    TextView tvNoiGuiDen;
    @BindView(R.id.tvNgayKy)
    TextView tvNgayKy;
    @BindView(R.id.tvNgayNhap)
    TextView tvNgayNhap;
    @BindView(R.id.tvNgayDen)
    TextView tvNgayDen;
    @BindView(R.id.tvNguoiKy)
    TextView tvNguoiKy;
    @BindView(R.id.tvChucVu)
    TextView tvChucVu;
    @BindView(R.id.tvNguoiNhap)
    TextView tvNguoiNhap;
    @BindView(R.id.etSoKyHieu)
    EditText etSoKyHieu;
    @BindView(R.id.etTrichYeu)
    EditText etTrichYeu;
    @BindView(R.id.etSoDen)
    EditText etSoDen;

    private int mYear, mMonth, mDay;
    DatePickerDialog datePickerDialog;
    AlertDialog dialog;
    RecyclerView rcLoaiVanBan;
    RecyclerView rcNguoiKy;
    RecyclerView rvChucVu;
    AdapterNguoiKyNhap adapterNguoiKy;
    AdapterLoaiVanBanNhap adapterLoaiVanBan;
    AdapterChucVu adapterChucVu;

    @Override
    public int getContentViewId() {
        return R.layout.activity_search;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        getPresenter().getAllLoaiVanBan(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""));
        getPresenter().getAllNguoiKy();
        getPresenter().getAllChucVu();
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void getAllLoaiVanBanSuccess(ArrayList<LoaiVanBan_Nhap> khuVucArrayList) {
        adapterLoaiVanBan = new AdapterLoaiVanBanNhap(khuVucArrayList, this);
    }

    @Override
    public void onGetallNguoiKySuccess(ArrayList<NguoiKy_nhap> giamdocVaPhoGiamdoc) {
        adapterNguoiKy = new AdapterNguoiKyNhap(giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void getAllChucVuSuccess(ArrayList<KhuVuc> khuVucArrayList) {
        adapterChucVu = new AdapterChucVu(khuVucArrayList,this);
    }

    @Override
    public SearchPresenter createPresenter() {
        return new SearchPresenterImpl(this);
    }

    @OnClick({R.id.btnBack, R.id.tvLoaiVanBan, R.id.tvNoiGuiDen, R.id.tvNgayKy, R.id.tvNgayNhap, R.id.tvNgayDen, R.id.tvNguoiKy,
            R.id.tvChucVu, R.id.tvNguoiNhap, R.id.lnSearch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                onBackPressed();
                break;
            case R.id.lnSearch:
                closeKeyboard();
                break;
            case R.id.tvLoaiVanBan:
                AlertDialog.Builder builderLoaiVanBan = new AlertDialog.Builder(this);
                LayoutInflater inflaterLoaiVanBan = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewLoaiVanBan = inflaterLoaiVanBan.inflate(R.layout.dialog_ten_giam_doc, null);
                builderLoaiVanBan.setView(viewLoaiVanBan);
                dialog = builderLoaiVanBan.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManagerLoaiVanBan = new LinearLayoutManager(this);
                layoutManagerLoaiVanBan.setOrientation(LinearLayoutManager.VERTICAL);
                rcLoaiVanBan = viewLoaiVanBan.findViewById(R.id.rcTenGiamDoc);
                rcLoaiVanBan.setLayoutManager(layoutManagerLoaiVanBan);
                rcLoaiVanBan.setAdapter(adapterLoaiVanBan);
                adapterLoaiVanBan.notifyDataSetChanged();
                dialog.show();
                TextView btnChuyenPGiamDocLoaiVanBan = viewLoaiVanBan.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyenPGiamDocLoaiVanBan.setText("-- Chọn loại văn bản --");
                btnChuyenPGiamDocLoaiVanBan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvLoaiVanBan.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.tvNgayKy:
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
                                tvNgayKy.setText(date);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.tvNgayNhap:
                final Calendar c2 = Calendar.getInstance();
                mYear = c2.get(Calendar.YEAR);
                mMonth = c2.get(Calendar.MONTH);
                mDay = c2.get(Calendar.DAY_OF_MONTH);
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
                                tvNgayNhap.setText(date);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.tvNgayDen:
                final Calendar c3 = Calendar.getInstance();
                mYear = c3.get(Calendar.YEAR);
                mMonth = c3.get(Calendar.MONTH);
                mDay = c3.get(Calendar.DAY_OF_MONTH);
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
                                tvNgayDen.setText(date);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.tvNguoiKy:
                AlertDialog.Builder builderNguoiKy = new AlertDialog.Builder(this);
                LayoutInflater inflaterNguoiKy = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewNguoiKy = inflaterNguoiKy.inflate(R.layout.dialog_ten_giam_doc, null);
                builderNguoiKy.setView(viewNguoiKy);
                dialog = builderNguoiKy.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManagerNguoiKy = new LinearLayoutManager(getApplicationContext());
                layoutManagerNguoiKy.setOrientation(LinearLayoutManager.VERTICAL);

                rcNguoiKy = viewNguoiKy.findViewById(R.id.rcTenGiamDoc);
                rcNguoiKy.setLayoutManager(layoutManagerNguoiKy);
                rcNguoiKy.setAdapter(adapterNguoiKy);
                adapterNguoiKy.notifyDataSetChanged();

                dialog.show();
                TextView btnNguoiKy = viewNguoiKy.findViewById(R.id.btnChuyenPGiamDoc);
                btnNguoiKy.setText("-- Chọn Người ký --");
                btnNguoiKy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvNguoiKy.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.tvChucVu:
                AlertDialog.Builder builderChucVu = new AlertDialog.Builder(this);
                LayoutInflater inflaterChucVu = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewChucVu = inflaterChucVu.inflate(R.layout.dialog_ten_giam_doc, null);
                builderChucVu.setView(viewChucVu);
                dialog = builderChucVu.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManagerChucVu = new LinearLayoutManager(getApplicationContext());
                layoutManagerChucVu.setOrientation(LinearLayoutManager.VERTICAL);

                rvChucVu = viewChucVu.findViewById(R.id.rcTenGiamDoc);
                rvChucVu.setLayoutManager(layoutManagerChucVu);
                rvChucVu.setAdapter(adapterChucVu);
                adapterChucVu.notifyDataSetChanged();

                dialog.show();
                TextView btnChuyenChucVu = viewChucVu.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyenChucVu.setText("Chọn chức vụ");
                btnChuyenChucVu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvChucVu.setText("");
                        dialog.dismiss();
                    }
                });
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
    public void onItemLoaiVanBanClick(LoaiVanBan_Nhap khuVuc) {
        tvLoaiVanBan.setText(khuVuc.getTen());
        dialog.dismiss();
    }

    @Override
    public void onItemNguoiKyClick(NguoiKy_nhap giamdocVaPhoGiamdoc) {
        tvNguoiKy.setText(giamdocVaPhoGiamdoc.getHoTen());
        dialog.dismiss();
    }

    @Override
    public void onItemChucVuClick(KhuVuc khuVuc) {
        tvChucVu.setText(khuVuc.getTen());
        dialog.dismiss();
    }
}
