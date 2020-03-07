package com.vpdt.vpdt.ui.activity.XuLyGiayMoi;

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
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DoMat;
import com.vpdt.vpdt.model.GiayMoiCapNhat;
import com.vpdt.vpdt.model.KhuVuc;
import com.vpdt.vpdt.model.TepTinDinhKemPPH;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetPhoiHopTraLai;
import com.vpdt.vpdt.presenter.TTVBGiayMoiChoPhanLoaiPresenter;
import com.vpdt.vpdt.presenter.TTVBGiayMoiChoPhanLoaiView;
import com.vpdt.vpdt.presenter.impl.TTVBGiayMoiChoPhanLoaiPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterChucVu;
import com.vpdt.vpdt.ui.adapter.AdapterDoKhan;
import com.vpdt.vpdt.ui.adapter.AdapterDoMat;
import com.vpdt.vpdt.ui.adapter.AdapterDonVi;
import com.vpdt.vpdt.ui.adapter.AdapterKhuVuc;
import com.vpdt.vpdt.ui.adapter.AdapterLinhVuc;
import com.vpdt.vpdt.ui.adapter.AdapterLoaiVanBan;
import com.vpdt.vpdt.ui.adapter.AdapterNguoiKyVB;
import com.vpdt.vpdt.ui.adapter.AdapterTepTinDinhKemPhongPH;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetPhoiHopTraLai;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTVBGiayMoiChoPhanLoaiActivity extends BaseActivity<TTVBGiayMoiChoPhanLoaiPresenter> implements TTVBGiayMoiChoPhanLoaiView,
        AdapterTepTinDinhKemPhongPH.OnItemClickListener, AdapterKhuVuc.OnItemKhuVucClickListener,
        AdapterDoKhan.OnItemDoKhanClickListener, AdapterDoMat.OnItemDoMatClickListener,
        AdapterLoaiVanBan.OnItemLoaiVanBanClickListener, AdapterDonVi.OnItemDonViClickListener, AdapterLinhVuc.OnItemLinhVucClickListener,
        AdapterNguoiKyVB.OnItemNguoiKyVBClickListener, AdapterChucVu.OnItemChucVuClickListener {

    @BindView(R.id.imDownThongTinVanBan)
    ImageView imDownThongTinVanBan;
    @BindView(R.id.imUpThongTinVanBan)
    ImageView imUpThongTinVanBan;

    @BindView(R.id.imDownTrinhTuGiaiQuyet)
    ImageView imDownTrinhTuGiaiQuyet;
    @BindView(R.id.imUpTrinhTuGiaiQuyet)
    ImageView imUpTrinhTuGiaiQuyet;

    @BindView(R.id.imDownTepDinhKem)
    ImageView imDownTepDinhKem;
    @BindView(R.id.imUpTepDinhKem)
    ImageView imUpTepDinhKem;

    @BindView(R.id.lnThongTinVanBan)
    LinearLayout lnThongTinVanBan;
    @BindView(R.id.lnTrinhTuGiaiQuyet)
    LinearLayout lnTrinhTuGiaiQuyet;
    @BindView(R.id.lnTepDinhKem)
    LinearLayout lnTepDinhKem;

    @BindView(R.id.tvHopVaoHoi)
    EditText tvHopVaoHoi;
    @BindView(R.id.tvNoiDung)
    EditText tvNoiDung;
    @BindView(R.id.tvSoDen)
    EditText tvSoDen;
    @BindView(R.id.tvKhuVuc)
    TextView tvKhuVuc;
    @BindView(R.id.tvSoKyHieu)
    EditText tvSoKyHieu;
    @BindView(R.id.tvLoaiVanBan)
    TextView tvLoaiVanBan;
    @BindView(R.id.tvTrichYeu)
    EditText tvTrichYeu;
    @BindView(R.id.tvNguoiKy)
    TextView tvNguoiKy;
    @BindView(R.id.tvNgayNhan)
    TextView tvNgayNhan;
    @BindView(R.id.tvSoTrang)
    EditText tvSoTrang;
    @BindView(R.id.tvDoMat)
    TextView tvDoMat;
    @BindView(R.id.tvNoiGuiDen)
    TextView tvNoiGuiDen;
    @BindView(R.id.tvNgayKy)
    TextView tvNgayKy;
    @BindView(R.id.tvChucVu)
    TextView tvChucVu;
    @BindView(R.id.tvHanGiaiQuyet)
    TextView tvHanGiaiQuyet;
    @BindView(R.id.tvDoKhan)
    TextView tvDoKhan;
    @BindView(R.id.tvThamMuu)
    EditText tvThamMuu;
    @BindView(R.id.tvLinhVuc)
    TextView tvLinhVuc;
    @BindView(R.id.tvNgayPhanLoai)
    EditText tvNgayPhanLoai;
    @BindView(R.id.tvDiaDiem)
    EditText tvDiaDiem;
    @BindView(R.id.tvNguoiChuTri)
    EditText tvNguoiChuTri;

    @BindView(R.id.tvNgay)
    TextView tvNgay;

    @BindView(R.id.cbVBQPPL)
    CheckBox cbVBQPPL;
    @BindView(R.id.cbSTCChuTri)
    CheckBox cbSTCChuTri;
    @BindView(R.id.cbTBKL)
    CheckBox cbTBKL;

    @BindView(R.id.rcvTepDinhKem)
    RecyclerView rcvTepDinhKem;
    @BindView(R.id.rvTrinhTuGiaiQuyet)
    RecyclerView rvTrinhTuGiaiQuyet;

    int id, idkhuVuc, idDoMat, idDoKhan, vBQPPL, STC_CT, TBKL;
    String soKyHieu, noiGuiDen, loaiVanBan, ngayKy, trichYeu, nguoiKy, gioHop, ngayHop, noiDung,
            diaDiem, nguoiChuTri, chucVu, hanGiaiQuyet, ngayNhan, soTrang, soDen;

    private int mYear, mMonth, mDay;
    DatePickerDialog datePickerDialog;
    RecyclerView rcTenPhong;
    RecyclerView rcTenPhongPhoiHop;
    RecyclerView rcTenGiamDoc;

    AlertDialog dialog;

    AdapterTrinhTuGiaiQuyetPhoiHopTraLai adapterTrinhTuGiaiQuyetPhoiHopTraLai;
    AdapterTepTinDinhKemPhongPH adapterTepTinDinhKemPhongPH;
    AdapterKhuVuc adapterKhuVuc;
    AdapterDoKhan adapterDoKhan;
    AdapterDoMat adapterDoMat;
    AdapterLoaiVanBan adapterLoaiVanBan;
    AdapterDonVi adapterDonVi;
    AdapterLinhVuc adapterLinhVuc;
    AdapterNguoiKyVB adapterNguoiKyVB;
    AdapterChucVu adapterChucVu;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ttvbgiay_moi_cho_phan_loai;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        getPresenter().getAllDoKhan();
        getPresenter().getAllDoMat();
        getPresenter().getAllKhuVuc();
        getPresenter().getAllChucVu();
        getPresenter().getAllDonVi();
        getPresenter().getAllLoaiVanBan();
        getPresenter().getAllNguoiKyVB();
        getPresenter().getAllLinhVuc();
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("idvb")) {
                id = intent.getIntExtra("idvb", 0);
                getPresenter().getGMCapNhat(id);
            }
        }
        tvKhuVuc.setText("-- Chọn cấp ban hành -- ");
        tvDoKhan.setText("Bình thường");
        tvDoMat.setText("Bình thường");

    }

    @Override
    public Context gContext() {
        return this;
    }


    @Override
    public void getDoKhanSuccess(ArrayList<DoMat> doMatArrayList) {
        adapterDoKhan = new AdapterDoKhan(doMatArrayList, this);
    }

    @Override
    public void getDoMatSuccess(ArrayList<DoMat> doMatArrayList) {
        adapterDoMat = new AdapterDoMat(doMatArrayList, this);
    }

    @Override
    public void getKhuVucSuccess(ArrayList<KhuVuc> khuVucArrayList) {
        adapterKhuVuc = new AdapterKhuVuc(khuVucArrayList, this);
    }

    @Override
    public void getAllLoaiVanBanSuccess(ArrayList<KhuVuc> khuVucArrayList) {
        adapterLoaiVanBan = new AdapterLoaiVanBan(khuVucArrayList, this);
    }

    @Override
    public void getAllChucVuSuccess(ArrayList<KhuVuc> khuVucArrayList) {
        adapterChucVu = new AdapterChucVu(khuVucArrayList, this);

    }

    @Override
    public void getAllNguoiKyVBSuccess(ArrayList<KhuVuc> khuVucArrayList) {
        adapterNguoiKyVB = new AdapterNguoiKyVB(khuVucArrayList, this);
    }

    @Override
    public void getAllLinhVucSuccess(ArrayList<KhuVuc> khuVucArrayList) {
        adapterLinhVuc = new AdapterLinhVuc(khuVucArrayList, this);
    }

    @Override
    public void getAllDonViSuccess(ArrayList<KhuVuc> khuVucArrayList) {
        adapterDonVi = new AdapterDonVi(khuVucArrayList, this);
    }

    @Override
    public void getGMCapNhatSucsess(GiayMoiCapNhat giayMoiCapNhat) {
        RecyclerViewTrinhTuGiaiQuyetGiayMoi((ArrayList<TrinhTuGiaiQuyetPhoiHopTraLai>) giayMoiCapNhat.getTrinhTuGiaiQuyets());
        RecyclerViewTepTinDinhKem((ArrayList<TepTinDinhKemPPH>) giayMoiCapNhat.getTepTinDinhKems());
        idkhuVuc = giayMoiCapNhat.getIdKhuVuc();
        soKyHieu = giayMoiCapNhat.getSoKyHieu();
        noiGuiDen = giayMoiCapNhat.getNoiGuiDen();
        loaiVanBan = giayMoiCapNhat.getLoaiVanBan();
        ngayKy = giayMoiCapNhat.getNgayKy();
        nguoiKy = giayMoiCapNhat.getTenNguoiKy();
        gioHop = giayMoiCapNhat.getGiayMoiGio();
        ngayHop = giayMoiCapNhat.getGiayMoiNgay();
        diaDiem = giayMoiCapNhat.getGiayMoiDiaDiem();
        hanGiaiQuyet = giayMoiCapNhat.getHanGiaiQuyet();
        soDen = giayMoiCapNhat.getSoDen();
        ngayNhan = giayMoiCapNhat.getNgayNhan();
        idDoMat = giayMoiCapNhat.getIdDoMat();
        idDoKhan = giayMoiCapNhat.getIdDoKhan();
        chucVu = giayMoiCapNhat.getChucVu();
        soTrang = giayMoiCapNhat.getSoTrang();
        noiDung = giayMoiCapNhat.getNoiDung();
        trichYeu = giayMoiCapNhat.getMoTa();
        tvHopVaoHoi.setText(String.valueOf(giayMoiCapNhat.getGiayMoiGio()));
        tvNgay.setText(String.valueOf(giayMoiCapNhat.getGiayMoiNgay()));
        tvNoiDung.setText(String.valueOf(giayMoiCapNhat.getNoiDung()));
        tvDiaDiem.setText(String.valueOf(giayMoiCapNhat.getGiayMoiDiaDiem()));
        tvSoDen.setText(String.valueOf(giayMoiCapNhat.getSoDen()));
        tvLinhVuc.setText(String.valueOf(giayMoiCapNhat.getLinhVuc()));
        tvNgayPhanLoai.setText(String.valueOf(giayMoiCapNhat.getNgayPhanLoai()));
        tvThamMuu.setText(String.valueOf(giayMoiCapNhat.getThamMuu()));
        tvKhuVuc.setText(String.valueOf(giayMoiCapNhat.getKhuVuc()));
        tvSoKyHieu.setText(String.valueOf(giayMoiCapNhat.getSoKyHieu()));
        tvLoaiVanBan.setText(String.valueOf(giayMoiCapNhat.getLoaiVanBan()));
        tvTrichYeu.setText(String.valueOf(giayMoiCapNhat.getMoTa()));
        tvNguoiKy.setText(String.valueOf(giayMoiCapNhat.getTenNguoiKy()));
        tvNgayNhan.setText(String.valueOf(giayMoiCapNhat.getNgayNhan()));
        tvSoTrang.setText(String.valueOf(giayMoiCapNhat.getSoTrang()));
        tvDoMat.setText(String.valueOf(giayMoiCapNhat.getDoMat()));
        tvNoiGuiDen.setText(String.valueOf(giayMoiCapNhat.getNoiGuiDen()));
        tvNgayKy.setText(String.valueOf(giayMoiCapNhat.getNgayKy()));
        tvChucVu.setText(String.valueOf(giayMoiCapNhat.getChucVu()));
        tvHanGiaiQuyet.setText(String.valueOf(giayMoiCapNhat.getHanGiaiQuyet()));
        tvDoKhan.setText(String.valueOf(giayMoiCapNhat.getDoKhan()));
        if (giayMoiCapNhat.getVBQPPL() == 1) {
            cbVBQPPL.setChecked(true);
        }
        if (giayMoiCapNhat.getSTCCT() == 1) {
            cbSTCChuTri.setChecked(true);
        }
        if (giayMoiCapNhat.getTBKL() == 1) {
            cbTBKL.setChecked(true);
        }
    }

    @OnClick({R.id.imvBack, R.id.tvThongTinVanBan,
            R.id.tvTrinhTuGiaiQuyet, R.id.tvTepDinhKem, R.id.tvKhuVuc, R.id.tvDoMat, R.id.tvDoKhan,
            R.id.tvHanGiaiQuyet, R.id.btnCapNhat, R.id.tvLoaiVanBan, R.id.tvNoiGuiDen, R.id.tvLinhVuc, R.id.tvNguoiKy, R.id.tvChucVu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imvBack:
                finish();
                break;
            case R.id.tvThongTinVanBan:
                Expand(lnThongTinVanBan, imUpThongTinVanBan, imDownThongTinVanBan);
                break;
            case R.id.tvTrinhTuGiaiQuyet:
                Expand(lnTrinhTuGiaiQuyet, imUpTrinhTuGiaiQuyet, imDownTrinhTuGiaiQuyet);
                break;

            case R.id.tvTepDinhKem:
                Expand(lnTepDinhKem, imUpTepDinhKem, imDownTepDinhKem);
                break;

            case R.id.btnCapNhat:
                nguoiChuTri = tvNguoiChuTri.getText().toString();
                noiDung = tvNoiDung.getText().toString();
                hanGiaiQuyet = tvHanGiaiQuyet.getText().toString();
                if (cbVBQPPL.isChecked() && cbSTCChuTri.isChecked() && cbTBKL.isChecked()) {
                    getPresenter().getduyetGMCapNhat(id, idkhuVuc,
                            soKyHieu,
                            noiGuiDen, loaiVanBan,
                            ngayKy, trichYeu, nguoiKy,
                            gioHop, ngayHop, noiDung, diaDiem,
                            nguoiChuTri, chucVu,
                            hanGiaiQuyet,
                            soTrang,
                            soDen,
                            ngayNhan, idDoMat,
                            idDoKhan,
                            1, 1, 1);
                } else if (cbVBQPPL.isChecked() && cbSTCChuTri.isChecked()) {
                    getPresenter().getduyetGMCapNhat(id, idkhuVuc,
                            soKyHieu,
                            noiGuiDen, loaiVanBan,
                            ngayKy, trichYeu, nguoiKy,
                            gioHop, ngayHop, noiDung, diaDiem,
                            nguoiChuTri, chucVu,
                            hanGiaiQuyet,
                            soTrang,
                            soDen,
                            ngayNhan, idDoMat,
                            idDoKhan,
                            1, 1, 0);
                } else if (cbVBQPPL.isChecked() && cbTBKL.isChecked()) {
                    getPresenter().getduyetGMCapNhat(id, idkhuVuc,
                            soKyHieu,
                            noiGuiDen, loaiVanBan,
                            ngayKy, trichYeu, nguoiKy,
                            gioHop, ngayHop, noiDung, diaDiem,
                            nguoiChuTri, chucVu,
                            hanGiaiQuyet,
                            soTrang,
                            soDen,
                            ngayNhan, idDoMat,
                            idDoKhan,
                            1, 0, 1);
                } else if (cbSTCChuTri.isChecked() && cbTBKL.isChecked()) {
                    getPresenter().getduyetGMCapNhat(id, idkhuVuc,
                            soKyHieu,
                            noiGuiDen, loaiVanBan,
                            ngayKy, trichYeu, nguoiKy,
                            gioHop, ngayHop, noiDung, diaDiem,
                            nguoiChuTri, chucVu,
                            hanGiaiQuyet,
                            soTrang,
                            soDen,
                            ngayNhan, idDoMat,
                            idDoKhan,
                            0, 1, 1);
                } else if (cbVBQPPL.isChecked()) {
                    getPresenter().getduyetGMCapNhat(id, idkhuVuc,
                            soKyHieu,
                            noiGuiDen, loaiVanBan,
                            ngayKy, trichYeu, nguoiKy,
                            gioHop, ngayHop, noiDung, diaDiem,
                            nguoiChuTri, chucVu,
                            hanGiaiQuyet,
                            soTrang,
                            soDen,
                            ngayNhan, idDoMat,
                            idDoKhan,
                            1, 0, 0);
                } else if (cbSTCChuTri.isChecked()) {
                    getPresenter().getduyetGMCapNhat(id, idkhuVuc,
                            soKyHieu,
                            noiGuiDen, loaiVanBan,
                            ngayKy, trichYeu, nguoiKy,
                            gioHop, ngayHop, noiDung, diaDiem,
                            nguoiChuTri, chucVu,
                            hanGiaiQuyet,
                            soTrang,
                            soDen,
                            ngayNhan, idDoMat,
                            idDoKhan,
                            0, 1, 0);
                } else if (cbTBKL.isChecked()) {
                    getPresenter().getduyetGMCapNhat(id, idkhuVuc,
                            soKyHieu,
                            noiGuiDen, loaiVanBan,
                            ngayKy, trichYeu, nguoiKy,
                            gioHop, ngayHop, noiDung, diaDiem,
                            nguoiChuTri, chucVu,
                            hanGiaiQuyet,
                            soTrang,
                            soDen,
                            ngayNhan, idDoMat,
                            idDoKhan,
                            0, 0, 1);
                } else {
                    getPresenter().getduyetGMCapNhat(id, idkhuVuc,
                            soKyHieu,
                            noiGuiDen, loaiVanBan,
                            ngayKy, trichYeu, nguoiKy,
                            gioHop, ngayHop, noiDung, diaDiem,
                            nguoiChuTri, chucVu,
                            hanGiaiQuyet,
                            soTrang,
                            soDen,
                            ngayNhan, idDoMat,
                            idDoKhan,
                            0, 0, 0);
                }

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

                rcTenGiamDoc = viewChucVu.findViewById(R.id.rcTenGiamDoc);
                rcTenGiamDoc.setLayoutManager(layoutManagerChucVu);
                rcTenGiamDoc.setAdapter(adapterChucVu);
                adapterChucVu.notifyDataSetChanged();

                dialog.show();
                TextView btnChuyenChucVu = viewChucVu.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyenChucVu.setVisibility(View.GONE);
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

                rcTenGiamDoc = viewNguoiKy.findViewById(R.id.rcTenGiamDoc);
                rcTenGiamDoc.setLayoutManager(layoutManagerNguoiKy);
                rcTenGiamDoc.setAdapter(adapterNguoiKyVB);
                adapterNguoiKyVB.notifyDataSetChanged();

                dialog.show();
                TextView btnChuyenNguoiKy = viewNguoiKy.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyenNguoiKy.setVisibility(View.GONE);
                break;

            case R.id.tvLinhVuc:
                AlertDialog.Builder builderLinhVuc = new AlertDialog.Builder(this);
                LayoutInflater inflaterLinhVuc = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewLinhVuc = inflaterLinhVuc.inflate(R.layout.dialog_ten_giam_doc, null);
                builderLinhVuc.setView(viewLinhVuc);
                dialog = builderLinhVuc.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManagerLinhVuc = new LinearLayoutManager(getApplicationContext());
                layoutManagerLinhVuc.setOrientation(LinearLayoutManager.VERTICAL);

                rcTenGiamDoc = viewLinhVuc.findViewById(R.id.rcTenGiamDoc);
                rcTenGiamDoc.setLayoutManager(layoutManagerLinhVuc);
                rcTenGiamDoc.setAdapter(adapterLinhVuc);
                adapterLinhVuc.notifyDataSetChanged();

                dialog.show();
                TextView btnChuyentvLinhVuc = viewLinhVuc.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyentvLinhVuc.setVisibility(View.GONE);
                break;

            case R.id.tvNoiGuiDen:
                AlertDialog.Builder builderNoiGuiDen = new AlertDialog.Builder(this);
                LayoutInflater inflaterNoiGuiDen = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewNoiGuiDen = inflaterNoiGuiDen.inflate(R.layout.dialog_ten_giam_doc, null);
                builderNoiGuiDen.setView(viewNoiGuiDen);
                dialog = builderNoiGuiDen.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManagerNoiGuiDen = new LinearLayoutManager(getApplicationContext());
                layoutManagerNoiGuiDen.setOrientation(LinearLayoutManager.VERTICAL);

                rcTenGiamDoc = viewNoiGuiDen.findViewById(R.id.rcTenGiamDoc);
                rcTenGiamDoc.setLayoutManager(layoutManagerNoiGuiDen);
                rcTenGiamDoc.setAdapter(adapterDonVi);
                adapterDonVi.notifyDataSetChanged();

                dialog.show();
                TextView btnChuyenNoiGuiDen = viewNoiGuiDen.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyenNoiGuiDen.setVisibility(View.GONE);
                break;

            case R.id.tvLoaiVanBan:
                AlertDialog.Builder builderLoaiVanBan = new AlertDialog.Builder(this);
                LayoutInflater inflaterLoaiVanBan = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewLoaiVanBan = inflaterLoaiVanBan.inflate(R.layout.dialog_ten_giam_doc, null);
                builderLoaiVanBan.setView(viewLoaiVanBan);
                dialog = builderLoaiVanBan.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManagerLoaiVanBan = new LinearLayoutManager(getApplicationContext());
                layoutManagerLoaiVanBan.setOrientation(LinearLayoutManager.VERTICAL);

                rcTenGiamDoc = viewLoaiVanBan.findViewById(R.id.rcTenGiamDoc);
                rcTenGiamDoc.setLayoutManager(layoutManagerLoaiVanBan);
                rcTenGiamDoc.setAdapter(adapterLoaiVanBan);
                adapterLoaiVanBan.notifyDataSetChanged();

                dialog.show();
                TextView btnChuyenPGiamDocLoaiVanBan = viewLoaiVanBan.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyenPGiamDocLoaiVanBan.setVisibility(View.GONE);


                break;

            case R.id.tvHanGiaiQuyet:
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
                                tvHanGiaiQuyet.setText(date);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;

            case R.id.tvKhuVuc:
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
                rcTenGiamDoc.setAdapter(adapterKhuVuc);
                adapterKhuVuc.notifyDataSetChanged();

                dialog.show();
                TextView btnChuyenPGiamDoc = view1.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyenPGiamDoc.setText("-- Chọn cấp ban hành -- ");
                btnChuyenPGiamDoc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvKhuVuc.setText("-- Chọn cấp ban hành -- ");
                        dialog.dismiss();
                    }
                });
                break;

            case R.id.tvDoMat:
                AlertDialog.Builder builderDoMat = new AlertDialog.Builder(this);
                LayoutInflater inflaterDoMat = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewDoMat = inflaterDoMat.inflate(R.layout.dialog_ten_giam_doc, null);
                builderDoMat.setView(viewDoMat);
                dialog = builderDoMat.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManagerDoMat = new LinearLayoutManager(getApplicationContext());
                layoutManagerDoMat.setOrientation(LinearLayoutManager.VERTICAL);

                rcTenPhongPhoiHop = viewDoMat.findViewById(R.id.rcTenGiamDoc);
                rcTenPhongPhoiHop.setLayoutManager(layoutManagerDoMat);
                rcTenPhongPhoiHop.setAdapter(adapterDoMat);
                adapterDoMat.notifyDataSetChanged();

                dialog.show();
                TextView btnChuyenPGiamDocDoMat = viewDoMat.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyenPGiamDocDoMat.setVisibility(View.GONE);
                break;

            case R.id.tvDoKhan:
                AlertDialog.Builder builderDoKhan = new AlertDialog.Builder(this);
                LayoutInflater inflaterDoKhan = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewDoKhan = inflaterDoKhan.inflate(R.layout.dialog_ten_giam_doc, null);
                builderDoKhan.setView(viewDoKhan);
                dialog = builderDoKhan.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManagerDoKhan = new LinearLayoutManager(getApplicationContext());
                layoutManagerDoKhan.setOrientation(LinearLayoutManager.VERTICAL);

                rcTenPhong = viewDoKhan.findViewById(R.id.rcTenGiamDoc);
                rcTenPhong.setLayoutManager(layoutManagerDoKhan);
                rcTenPhong.setAdapter(adapterDoMat);
                adapterDoMat.notifyDataSetChanged();

                dialog.show();
                TextView btnChuyenPGiamDocDoKhan = viewDoKhan.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyenPGiamDocDoKhan.setVisibility(View.GONE);
                break;

        }
    }

    void Expand(LinearLayout linearLayout, ImageView imgGone, ImageView imgVisible) {
        if (linearLayout.getVisibility() == View.GONE) {
            imgGone.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.VISIBLE);
            imgVisible.setVisibility(View.GONE);
        } else {
            linearLayout.setVisibility(View.GONE);
            imgGone.setVisibility(View.GONE);
            imgVisible.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void capNhatSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public TTVBGiayMoiChoPhanLoaiPresenter createPresenter() {
        return new TTVBGiayMoiChoPhanLoaiPresenterImpl(this);
    }

    void RecyclerViewTrinhTuGiaiQuyetGiayMoi(ArrayList<TrinhTuGiaiQuyetPhoiHopTraLai> trinhTuGiaiQuyets) {
        adapterTrinhTuGiaiQuyetPhoiHopTraLai = new AdapterTrinhTuGiaiQuyetPhoiHopTraLai(trinhTuGiaiQuyets);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvTrinhTuGiaiQuyet.setLayoutManager(layoutManager);
        rvTrinhTuGiaiQuyet.setAdapter(adapterTrinhTuGiaiQuyetPhoiHopTraLai);
        adapterTrinhTuGiaiQuyetPhoiHopTraLai.notifyDataSetChanged();
    }

    void RecyclerViewTepTinDinhKem(ArrayList<TepTinDinhKemPPH> tepDinhKems) {
        adapterTepTinDinhKemPhongPH = new AdapterTepTinDinhKemPhongPH(tepDinhKems, this);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTepDinhKem.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvTepDinhKem.setAdapter(adapterTepTinDinhKemPhongPH);
        adapterTepTinDinhKemPhongPH.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(TepTinDinhKemPPH tepTinDinhKemPPH) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(tepTinDinhKemPPH.getUrlFile()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemDoKhanClick(DoMat doMat) {
        idDoKhan = doMat.getId();
        tvDoKhan.setText(String.valueOf(doMat.getName()));
        dialog.dismiss();
    }

    @Override
    public void onItemDoMatClick(DoMat doMat) {
        idDoMat = doMat.getId();
        tvDoMat.setText(String.valueOf(doMat.getName()));
        dialog.dismiss();
    }

    @Override
    public void onItemKhuVucClick(KhuVuc khuVuc) {
        tvKhuVuc.setText(String.valueOf(khuVuc.getTen()));
        idkhuVuc = khuVuc.getId();
        dialog.dismiss();
    }

    @Override
    public void onItemChucVuClick(KhuVuc khuVuc) {
        chucVu = khuVuc.getTen();
        tvChucVu.setText(String.valueOf(khuVuc.getTen()));
        dialog.dismiss();
    }

    @Override
    public void onItemDonViClick(KhuVuc khuVuc) {
        tvNoiGuiDen.setText(String.valueOf(khuVuc.getTen()));
        dialog.dismiss();
    }

    @Override
    public void onItemLinhVucClick(KhuVuc khuVuc) {
        tvLinhVuc.setText(String.valueOf(khuVuc.getTen()));
        dialog.dismiss();
    }

    @Override
    public void onItemLoaiVanBanClick(KhuVuc khuVuc) {
        loaiVanBan = khuVuc.getTen();
        tvLoaiVanBan.setText(String.valueOf(khuVuc.getTen()));
        dialog.dismiss();
    }

    @Override
    public void onItemNguoiKyVBClick(KhuVuc khuVuc) {
        nguoiKy = khuVuc.getTen();
        tvNguoiKy.setText(String.valueOf(khuVuc.getTen()));
        dialog.dismiss();
    }
}
