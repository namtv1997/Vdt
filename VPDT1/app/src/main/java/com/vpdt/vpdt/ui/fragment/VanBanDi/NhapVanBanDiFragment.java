package com.vpdt.vpdt.ui.fragment.VanBanDi;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseFragment;
import com.vpdt.vpdt.model.DSVB_ChoSoCuaSo;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.LoaiVanBan_Nhap;
import com.vpdt.vpdt.model.MailDonvus;
import com.vpdt.vpdt.model.MailQuanhuyen;
import com.vpdt.vpdt.model.MailSoBanNganh;
import com.vpdt.vpdt.model.NguoiKy_nhap;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.SelectNoiDuThao;
import com.vpdt.vpdt.presenter.NhapVanBanDiPresenter;
import com.vpdt.vpdt.presenter.NhapVanBanDiView;
import com.vpdt.vpdt.presenter.impl.NhapVanBanDiPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterLoaiVanBanNhap;
import com.vpdt.vpdt.ui.adapter.AdapterMailDonVi;
import com.vpdt.vpdt.ui.adapter.AdapterMailSoBanNganh;
import com.vpdt.vpdt.ui.adapter.AdapterMailquanHuyen;
import com.vpdt.vpdt.ui.adapter.AdapterNguoiKyNhap;
import com.vpdt.vpdt.ui.adapter.AdapterSelectNoiDuThao;
import com.vpdt.vpdt.ui.adapter.AdapterTenChuyenVien;
import com.vpdt.vpdt.ui.adapter.AdapterTenGiamDoc;
import com.vpdt.vpdt.util.Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NhapVanBanDiFragment extends BaseFragment<NhapVanBanDiPresenter> implements NhapVanBanDiView,
        AdapterLoaiVanBanNhap.OnItemLoaiVanBanClickListener,
        AdapterTenGiamDoc.OnItemClickListener,
        AdapterSelectNoiDuThao.OnItemNoiDuThaoClickListener,
        AdapterTenChuyenVien.OnItemClickListenerChuyenVien,
        AdapterMailSoBanNganh.OnItemClickListenerMailSoBanNganh,
        AdapterMailquanHuyen.OnItemClickListenerMailquanHuyen,
        AdapterMailDonVi.OnItemClickListenerMailDonVi,
        AdapterNguoiKyNhap.OnItemNguoiKyClickListener {

    @BindView(R.id.tvSoVanBan)
    TextView tvSoVanBan;
    @BindView(R.id.tvNgayThangNam)
    TextView tvNgayThangNam;
    @BindView(R.id.tvLoaiVanBan)
    TextView tvLoaiVanBan;
    @BindView(R.id.tvNoiDuThao)
    TextView tvNoiDuThao;
    @BindView(R.id.tvLanhDaoPhong)
    TextView tvLanhDaoPhong;
    @BindView(R.id.tvNguoiKy)
    TextView tvNguoiKy;
    @BindView(R.id.tvChucVu)
    TextView tvChucVu;
    @BindView(R.id.tvTraLoiVBSoDen)
    EditText tvTraLoiVBSoDen;
    @BindView(R.id.tvNguoiNhapVanBan)
    TextView tvNguoiNhapVanBan;
    @BindView(R.id.tvNgayMoi)
    EditText tvNgayMoi;

    @BindView(R.id.edtYkien)
    EditText edtYkien;
    @BindView(R.id.edtTrichYeu)
    EditText edtTrichYeu;
    @BindView(R.id.edtMailNgoai)
    EditText edtMailNgoai;
    @BindView(R.id.edtSoTrang)
    EditText edtSoTrang;
    @BindView(R.id.edtSoKyHieu)
    TextView edtSoKyHieu;
    @BindView(R.id.edtLinhVuc)
    EditText edtLinhVuc;
    @BindView(R.id.edtDiaDiem)
    EditText edtDiaDiem;
    @BindView(R.id.edtGioMoi)
    EditText edtGioMoi;

    @BindView(R.id.rvQuanHuyen)
    RecyclerView rvQuanHuyen;
    @BindView(R.id.rvBanHanh)
    RecyclerView rvBanHanh;
    @BindView(R.id.rvDonVi)
    RecyclerView rvDonVi;

    @BindView(R.id.rdCoDuThaoVbUyBan)
    RadioButton rdCoDuThaoVbUyBan;
    @BindView(R.id.rdKhongCoDuThao)
    RadioButton rdKhongCoDuThao;

    @BindView(R.id.lnNgay)
    LinearLayout lnNgay;
    @BindView(R.id.lnDiaDiem)
    LinearLayout lnDiaDiem;

    RecyclerView rcTenGiamDoc;

    int id_lvb, sovb, id_noiduthao, id_lanhdao,
            sotrang, id_loaivanban, id_lanhdaophong, id_nguoiky;
    String ngay_thang, linhvuc, trichyeu, ykien, skyhieu, chucvu, soden, ngaymoi, giomoi, diadiemmoi, tenVietTatDuThao;
    boolean click = false;
    private int mYear, mMonth, mDay;
    DatePickerDialog datePickerDialog;
    AlertDialog dialog;
    ArrayList<String> stringArrayList = new ArrayList<>();
    ArrayList<MailDonvus> mailDonviArrayList = new ArrayList<>();
    ArrayList<MailQuanhuyen> mailQuanHuyenArrayList = new ArrayList<>();
    ArrayList<MailSoBanNganh> mailBanHanhArrayList = new ArrayList<>();
    AdapterLoaiVanBanNhap adapterLoaiVanBan;
    AdapterTenGiamDoc adapterTenGiamDoc;
    AdapterSelectNoiDuThao adapterSelectNoiDuThao;
    AdapterTenChuyenVien adapterTenChuyenVien;
    AdapterMailSoBanNganh adapterMailSoBanNganh;
    AdapterMailquanHuyen adapterMailquanHuyen;
    AdapterMailDonVi adapterMailDonVi;
    AdapterNguoiKyNhap adapterNguoiKy;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_nhap_van_ban_di;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        getPresenter().getAllLoaiVanBan();
        getPresenter().getlanhdaophong();
        getPresenter().getallnoiduthao();
        getPresenter().getAllNguoiKy();
        getPresenter().nhapVB_suaVB(0);

        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        dateFormatter.setLenient(false);
        Date today = new Date();
        String s = dateFormatter.format(today);
        tvNgayThangNam.setText(s);
    }


    @Override
    public Context gContext() {
        return getActivity();
    }

    @Override
    public void NhapVanBanDiSuccess(DSVB_ChoSoCuaSo dsvb_choSoCuaSo) {
        tvNguoiNhapVanBan.setText(String.valueOf("Người nhập văn bản này là: " + dsvb_choSoCuaSo.getNguoinhapvb()));
        tvNoiDuThao.setText(dsvb_choSoCuaSo.getChonNoiduthaos());
        initRecyclerViewMailSoBanHanh((ArrayList<MailSoBanNganh>) dsvb_choSoCuaSo.getMailSoBanNganh());
        initRecyclerViewMailQuanHuyen((ArrayList<MailQuanhuyen>) dsvb_choSoCuaSo.getMailQuanhuyen());
        initRecyclerViewMailDonvi((ArrayList<MailDonvus>) dsvb_choSoCuaSo.getMailDonvi());

        if (dsvb_choSoCuaSo.getDuthao() == 1) {
            rdCoDuThaoVbUyBan.setChecked(true);
        } else if (dsvb_choSoCuaSo.getDuthao() == 0) {
            rdKhongCoDuThao.setChecked(true);
        }
        if (dsvb_choSoCuaSo.getChonLdPhongs() != null) {
            tvLanhDaoPhong.setText(String.valueOf(dsvb_choSoCuaSo.getChonLdPhongs()));
        }
        if (dsvb_choSoCuaSo.getChonLoaivbs().equals("Giấy mời")) {
            lnDiaDiem.setVisibility(View.VISIBLE);
            lnNgay.setVisibility(View.VISIBLE);
        } else {
            lnDiaDiem.setVisibility(View.GONE);
            lnNgay.setVisibility(View.GONE);
        }
        id_lvb = dsvb_choSoCuaSo.getChonIdLoaivbs();
        sovb = dsvb_choSoCuaSo.getSoVB();
        id_noiduthao = dsvb_choSoCuaSo.getChonIdNoiduthaos();
        id_lanhdao = dsvb_choSoCuaSo.getChonIdNguoiKy();
        ngay_thang = dsvb_choSoCuaSo.getNgayThang();
        linhvuc = dsvb_choSoCuaSo.getLinhvuc();
        sotrang = dsvb_choSoCuaSo.getSotrang();
        soden = dsvb_choSoCuaSo.getSoden();
        trichyeu = dsvb_choSoCuaSo.getTrichYeu();
        ngaymoi = dsvb_choSoCuaSo.getNgaymoi();
        giomoi = dsvb_choSoCuaSo.getGiomoi();
        diadiemmoi = dsvb_choSoCuaSo.getDiadiemmoi();
        id_nguoiky = dsvb_choSoCuaSo.getChonIdNguoiKy();
        ykien = dsvb_choSoCuaSo.getYKien();
        id_lanhdaophong = dsvb_choSoCuaSo.getChonIdLdPhongs();
        id_loaivanban = dsvb_choSoCuaSo.getChonIdLoaivbs();
        tvSoVanBan.setText(String.valueOf(dsvb_choSoCuaSo.getSoVB()));
        tvNgayThangNam.setText(String.valueOf(dsvb_choSoCuaSo.getNgayThang()));
        tvLoaiVanBan.setText(String.valueOf(dsvb_choSoCuaSo.getChonLoaivbs()));
        tvNoiDuThao.setText(String.valueOf(dsvb_choSoCuaSo.getChonNoiduthaos()));
        tvNguoiKy.setText(String.valueOf(dsvb_choSoCuaSo.getChonNguoiKy()));
        tvTraLoiVBSoDen.setText(String.valueOf(dsvb_choSoCuaSo.getSoden()));
        tvNgayMoi.setText(String.valueOf(dsvb_choSoCuaSo.getNgaymoi()));
        edtYkien.setText(String.valueOf(dsvb_choSoCuaSo.getYKien()));
        edtTrichYeu.setText(String.valueOf(dsvb_choSoCuaSo.getTrichYeu()));
        edtMailNgoai.setText(String.valueOf(dsvb_choSoCuaSo.getMailNgoai()));
        edtSoTrang.setText(String.valueOf(dsvb_choSoCuaSo.getSotrang()));
        edtLinhVuc.setText(String.valueOf(dsvb_choSoCuaSo.getLinhvuc()));
        edtDiaDiem.setText(String.valueOf(dsvb_choSoCuaSo.getDiadiemmoi()));
        edtGioMoi.setText(String.valueOf(dsvb_choSoCuaSo.getGiomoi()));
        getPresenter().getgetSokyhieu(id_lvb, sovb, id_noiduthao);
        getPresenter().getchucvu(id_lanhdao);
    }

    @OnClick({R.id.tvLoaiVanBan, R.id.tvLanhDaoPhong, R.id.tvNoiDuThao, R.id.tvNguoiKy, R.id.btnBack, R.id.tvNgayThangNam, R.id.btnCapNhat,
            R.id.lnNhapvb})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lnNhapvb:
                closeKeyboard();
                break;
            case R.id.tvLoaiVanBan:
                AlertDialog.Builder builderLoaiVanBan = new AlertDialog.Builder(getActivity());
                LayoutInflater inflaterLoaiVanBan = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewLoaiVanBan = inflaterLoaiVanBan.inflate(R.layout.dialog_ten_giam_doc, null);
                builderLoaiVanBan.setView(viewLoaiVanBan);
                dialog = builderLoaiVanBan.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManagerLoaiVanBan = new LinearLayoutManager(getActivity());
                layoutManagerLoaiVanBan.setOrientation(LinearLayoutManager.VERTICAL);
                rcTenGiamDoc = viewLoaiVanBan.findViewById(R.id.rcTenGiamDoc);
                rcTenGiamDoc.setLayoutManager(layoutManagerLoaiVanBan);
                rcTenGiamDoc.setAdapter(adapterLoaiVanBan);
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
            case R.id.tvLanhDaoPhong:
                AlertDialog.Builder builderanhDaoPhong = new AlertDialog.Builder(getActivity());
                LayoutInflater inflateranhDaoPhong = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewanhDaoPhong = inflateranhDaoPhong.inflate(R.layout.dialog_ten_giam_doc, null);
                builderanhDaoPhong.setView(viewanhDaoPhong);
                dialog = builderanhDaoPhong.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                rcTenGiamDoc = viewanhDaoPhong.findViewById(R.id.rcTenGiamDoc);
                rcTenGiamDoc.setLayoutManager(layoutManager);
                rcTenGiamDoc.setAdapter(adapterTenChuyenVien);
                adapterTenChuyenVien.notifyDataSetChanged();

                dialog.show();
                TextView btnChuyenPGiamDoc = viewanhDaoPhong.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyenPGiamDoc.setText("-- Chọn lãnh đạo --");
                btnChuyenPGiamDoc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvLanhDaoPhong.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.tvNoiDuThao:
                AlertDialog.Builder builderNoiDuThao = new AlertDialog.Builder(getActivity());
                LayoutInflater inflaterNoiDuThao = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewNoiDuThao = inflaterNoiDuThao.inflate(R.layout.dialog_ten_giam_doc, null);
                builderNoiDuThao.setView(viewNoiDuThao);
                dialog = builderNoiDuThao.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManagerNoiDuThao = new LinearLayoutManager(getActivity());
                layoutManagerNoiDuThao.setOrientation(LinearLayoutManager.VERTICAL);

                rcTenGiamDoc = viewNoiDuThao.findViewById(R.id.rcTenGiamDoc);
                rcTenGiamDoc.setLayoutManager(layoutManagerNoiDuThao);
                rcTenGiamDoc.setAdapter(adapterSelectNoiDuThao);
                adapterSelectNoiDuThao.notifyDataSetChanged();

                dialog.show();
                TextView btnChuyenPGiamDocNoiDuThao = viewNoiDuThao.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyenPGiamDocNoiDuThao.setVisibility(View.GONE);
                break;
            case R.id.tvNguoiKy:
                AlertDialog.Builder builderNguoiKy = new AlertDialog.Builder(getActivity());
                LayoutInflater inflaterNguoiKy = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewNguoiKy = inflaterNguoiKy.inflate(R.layout.dialog_ten_giam_doc, null);
                builderNguoiKy.setView(viewNguoiKy);
                dialog = builderNguoiKy.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManagerNguoiKy = new LinearLayoutManager(getActivity());
                layoutManagerNguoiKy.setOrientation(LinearLayoutManager.VERTICAL);

                rcTenGiamDoc = viewNguoiKy.findViewById(R.id.rcTenGiamDoc);
                rcTenGiamDoc.setLayoutManager(layoutManagerNguoiKy);
                rcTenGiamDoc.setAdapter(adapterNguoiKy);
                adapterNguoiKy.notifyDataSetChanged();

                dialog.show();
                TextView btnNguoiKy = viewNguoiKy.findViewById(R.id.btnChuyenPGiamDoc);
                btnNguoiKy.setText("-- Chọn người ký --");
                btnNguoiKy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvNguoiKy.setText("");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.btnBack:
                getActivity().onBackPressed();
                break;

            case R.id.tvNgayThangNam:
                final Calendar c1 = Calendar.getInstance();
                mYear = c1.get(Calendar.YEAR);
                mMonth = c1.get(Calendar.MONTH);
                mDay = c1.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(getActivity(),
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
            case R.id.btnCapNhat:

                int index = 0;
                String email = "";
                for (MailDonvus item : mailDonviArrayList) {
                    index++;
                    if (index == mailDonviArrayList.size()) {
                        email += "" + item.getEmail();

                    } else {
                        email += item.getEmail() + ",";

                    }
                    stringArrayList.add(email);
                }

                for (MailSoBanNganh item : mailBanHanhArrayList) {
                    index++;
                    if (index == mailBanHanhArrayList.size()) {
                        email += "" + item.getEmail();

                    } else {
                        email += item.getEmail() + ",";

                    }
                    stringArrayList.add(email);
                }

                for (MailQuanhuyen item : mailQuanHuyenArrayList) {
                    index++;
                    if (index == mailQuanHuyenArrayList.size()) {
                        email += "" + item.getEmail();

                    } else {
                        email += item.getEmail() + ",";

                    }
                    stringArrayList.add(email);
                }

                ngay_thang = tvNgayThangNam.getText().toString();
                linhvuc = edtLinhVuc.getText().toString();
                soden = tvTraLoiVBSoDen.getText().toString();
                trichyeu = edtTrichYeu.getText().toString();
                ykien = edtYkien.getText().toString();
                diadiemmoi = edtDiaDiem.getText().toString();
                ngaymoi = tvNgayMoi.getText().toString();
                giomoi = edtGioMoi.getText().toString();
                if (rdCoDuThaoVbUyBan.isChecked()) {
                    getPresenter().them_capnhapVB(0, sovb, ngay_thang, linhvuc, sotrang, soden, trichyeu, ykien, String.valueOf(id_loaivanban),
                            String.valueOf(id_lanhdaophong), String.valueOf(id_noiduthao), stringArrayList, edtMailNgoai.getText().toString(),
                            ngaymoi, giomoi, diadiemmoi, id_nguoiky, skyhieu, chucvu, 1);
                } else if (rdKhongCoDuThao.isChecked()) {
                    getPresenter().them_capnhapVB(0, sovb, ngay_thang, linhvuc, sotrang, soden, trichyeu, ykien, String.valueOf(id_loaivanban),
                            String.valueOf(id_lanhdaophong), String.valueOf(id_noiduthao), stringArrayList, edtMailNgoai.getText().toString(),
                            ngaymoi, giomoi, diadiemmoi, id_nguoiky, skyhieu, chucvu, 0);
                }

                break;
        }
    }

    private void closeKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void getAllLoaiVanBanSuccess(ArrayList<LoaiVanBan_Nhap> khuVucArrayList) {
        adapterLoaiVanBan = new AdapterLoaiVanBanNhap(khuVucArrayList, this);
    }

    @Override
    public void getgetallnoiduthaoSuccess(ArrayList<SelectNoiDuThao> selectNoiDuThaoArrayList) {
        adapterSelectNoiDuThao = new AdapterSelectNoiDuThao(selectNoiDuThaoArrayList, this);
    }

    @Override
    public void onGetLanhDaoPhongSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterTenGiamDoc = new AdapterTenGiamDoc(getActivity(), giamdocVaPhoGiamdoc, this);
        adapterTenChuyenVien = new AdapterTenChuyenVien(giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void onGetallNguoiKySuccess(ArrayList<NguoiKy_nhap> giamdocVaPhoGiamdoc) {
        adapterNguoiKy = new AdapterNguoiKyNhap(giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void onGetKyHieuSuccess(Response<String> response) {
        skyhieu = response.getData();
        edtSoKyHieu.setText(String.valueOf(response.getData()));
    }

    @Override
    public void onGetChucvuSuccess(Response<String> response) {
        chucvu = response.getData();
        tvChucVu.setText(String.valueOf(response.getData()));
    }

    @Override
    public void onCapNhatSuccess() {
        Toast.makeText(getActivity(), "Xong", Toast.LENGTH_SHORT).show();
        getActivity().finish();
    }

    @Override
    public NhapVanBanDiPresenter createPresenter() {
        return new NhapVanBanDiPresenterImpl(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onItemLoaiVanBanClick(LoaiVanBan_Nhap khuVuc) {
        if (khuVuc.getId() == 10) {
            lnDiaDiem.setVisibility(View.VISIBLE);
            lnNgay.setVisibility(View.VISIBLE);
        } else {
            lnDiaDiem.setVisibility(View.GONE);
            lnNgay.setVisibility(View.GONE);
        }
        tvLoaiVanBan.setText(String.valueOf(khuVuc.getTen()));
        if (tenVietTatDuThao != null) {
            edtSoKyHieu.setText(khuVuc.getTenviettat() + "/STC-" + tenVietTatDuThao);
        } else {
            edtSoKyHieu.setText(khuVuc.getTenviettat() + "/STC-");
        }
        id_lvb = khuVuc.getId();
        id_loaivanban = khuVuc.getId();
        dialog.dismiss();
    }

    @Override
    public void onItemClick(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        tvLanhDaoPhong.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        dialog.dismiss();
    }

    @Override
    public void onItemNoiDuThaoClick(SelectNoiDuThao selectNoiDuThao) {
        tenVietTatDuThao = selectNoiDuThao.getTenviettat();
        tvNoiDuThao.setText(String.valueOf(selectNoiDuThao.getTenPhong()));
        id_noiduthao = selectNoiDuThao.getIdPhong();
        dialog.dismiss();
    }

    @Override
    public void onItemClickChuyenVien(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        tvLanhDaoPhong.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        id_lanhdaophong = giamdocVaPhoGiamdoc.getId();
        dialog.dismiss();
    }

    @Override
    public void onItemClickMailDonVi(MailDonvus mailDonvus) {
        if (mailDonviArrayList.contains(mailDonvus)) {
            mailDonviArrayList.remove(mailDonvus);
        } else {
            mailDonviArrayList.add(mailDonvus);
        }
    }

    @Override
    public void onItemClickMailSoBanNganh(MailSoBanNganh mailDonvus) {
        if (mailBanHanhArrayList.contains(mailDonvus)) {
            mailBanHanhArrayList.remove(mailDonvus);
        } else {
            mailBanHanhArrayList.add(mailDonvus);
        }
    }

    @Override
    public void onItemClickMailquanHuyen(MailQuanhuyen mailDonvus) {
        if (mailQuanHuyenArrayList.contains(mailDonvus)) {
            mailQuanHuyenArrayList.remove(mailDonvus);
        } else {
            mailQuanHuyenArrayList.add(mailDonvus);
        }
    }

    @Override
    public void onItemNguoiKyClick(NguoiKy_nhap giamdocVaPhoGiamdoc) {
        id_nguoiky = giamdocVaPhoGiamdoc.getId();
        tvNguoiKy.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        getPresenter().getchucvu(giamdocVaPhoGiamdoc.getId());
        dialog.dismiss();
    }

    void initRecyclerViewMailSoBanHanh(ArrayList<MailSoBanNganh> mailBanHanhArrayList) {
        adapterMailSoBanNganh = new AdapterMailSoBanNganh(mailBanHanhArrayList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvBanHanh.setLayoutManager(layoutManager);
        rvBanHanh.setAdapter(adapterMailSoBanNganh);
        adapterMailSoBanNganh.notifyDataSetChanged();
    }

    void initRecyclerViewMailQuanHuyen(ArrayList<MailQuanhuyen> mailQuanHuyenArrayList) {
        adapterMailquanHuyen = new AdapterMailquanHuyen(mailQuanHuyenArrayList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvQuanHuyen.setLayoutManager(layoutManager);
        rvQuanHuyen.setAdapter(adapterMailquanHuyen);
        adapterMailquanHuyen.notifyDataSetChanged();
    }

    void initRecyclerViewMailDonvi(ArrayList<MailDonvus> mailDonviArrayList) {
        adapterMailDonVi = new AdapterMailDonVi(mailDonviArrayList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvDonVi.setLayoutManager(layoutManager);
        rvDonVi.setAdapter(adapterMailDonVi);
        adapterMailDonVi.notifyDataSetChanged();
    }

}
