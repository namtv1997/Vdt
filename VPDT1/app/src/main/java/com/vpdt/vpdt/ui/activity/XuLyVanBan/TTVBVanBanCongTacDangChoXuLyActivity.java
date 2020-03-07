package com.vpdt.vpdt.ui.activity.XuLyVanBan;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DetailDeXuatCongViecPhoiHopChoDuyet;
import com.vpdt.vpdt.model.TepTinDinhKemPPH;
import com.vpdt.vpdt.model.TrinhTuChuyenNhanLuuVetChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetPhongPHChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.model.VanBanDiChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.presenter.TTVBVanBanCongTacDangChoXuLyPresenter;
import com.vpdt.vpdt.presenter.TTVBVanBanCongTacDangChoXuLyView;
import com.vpdt.vpdt.presenter.impl.TTVBVanBanCongTacDangChoXuLyPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterTepTinDinhKemPhongPH;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuChuyenNhanLuuVetPhongPheDuyet;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetPhongPhoiHopChoLanhDaoPheDuyet;
import com.vpdt.vpdt.ui.adapter.AdapterVanBanDiSoLuongVanBanGiaoPhongChuTri;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTVBVanBanCongTacDangChoXuLyActivity extends BaseActivity<TTVBVanBanCongTacDangChoXuLyPresenter> implements TTVBVanBanCongTacDangChoXuLyView,
        AdapterTepTinDinhKemPhongPH.OnItemClickListener, AdapterVanBanDiSoLuongVanBanGiaoPhongChuTri.OnItemClickListenerVanBanDiSoLuongVanBanGiaoPhongChuTri {

    @BindView(R.id.imDownTTVBTTVBDSVBDenChoLDXL)
    ImageView imDownTTVBTTVBDSVBDenChoLDXL;
    @BindView(R.id.imUpTTVBTTVBDSVBDenChoLDXL)
    ImageView imUpTTVBTTVBDSVBDenChoLDXL;

    @BindView(R.id.imDownTTGQTTVBDSVBDenChoLDXL)
    ImageView imDownTTGQTTVBDSVBDenChoLDXL;
    @BindView(R.id.imUpTTGQTTVBDSVBDenChoLDXL)
    ImageView imUpTTGQTTVBDSVBDenChoLDXL;

    @BindView(R.id.imDownTTDKTTVBDSVBDenChoLDXL)
    ImageView imDownTTDKTTVBDSVBDenChoLDXL;
    @BindView(R.id.imUpTTDKTTVBDSVBDenChoLDXL)
    ImageView imUpTTDKTTVBDSVBDenChoLDXL;

    @BindView(R.id.imDownTTTNLVTTVBDSVBDenChoLDXL)
    ImageView imDownTTTNLVTTVBDSVBDenChoLDXL;
    @BindView(R.id.imUpTTTNLVTTVBDSVBDenChoLDXL)
    ImageView imUpTTTNLVTTVBDSVBDenChoLDXL;

    @BindView(R.id.imDownTTGQPPHTTVBDSVBDenChoLDXL)
    ImageView imDownTTGQPPHTTVBDSVBDenChoLDXL;
    @BindView(R.id.imUpTTGQPPHTTVBDSVBDenChoLDXL)
    ImageView imUpTTGQPPHTTVBDSVBDenChoLDXL;

    @BindView(R.id.imDownVanBanDi)
    ImageView imDownVanBanDi;
    @BindView(R.id.imUpVanBanDi)
    ImageView imUpVanBanDi;


    @BindView(R.id.lnTTVBTTVBDSVBDenChoLDXL)
    LinearLayout lnTTVBTTVBDSVBDenChoLDXL;
    @BindView(R.id.lnTTGQTTVBDSVBDenChoLDXL)
    LinearLayout lnTTGQTTVBDSVBDenChoLDXL;
    @BindView(R.id.lnTepDinhKemTTVBDSVBDenChoLDXL)
    LinearLayout lnTepDinhKemTTVBDSVBDenChoLDXL;
    @BindView(R.id.lnTTTNLVTTVBDSVBDenChoLDXL)
    LinearLayout lnTTTNLVTTVBDSVBDenChoLDXL;
    @BindView(R.id.lnTrinhTuGiaiQuyetPPHTTVBDSVBDenChoLDXL)
    LinearLayout lnTrinhTuGiaiQuyetPPHTTVBDSVBDenChoLDXL;
    @BindView(R.id.lnVanBanDi)
    LinearLayout lnVanBanDi;


    @BindView(R.id.tvSoDenTTVBTTVBDSVBDenChoLDXL)
    TextView tvSoDenTTVBTTVBDSVBDenChoLDXL;
    @BindView(R.id.tvKhuVucTTVBDSVBDenChoLDXL)
    TextView tvKhuVucTTVBDSVBDenChoLDXL;
    @BindView(R.id.tvSoKyHieuTTVBDSVBDenChoLDXL)
    TextView tvSoKyHieuTTVBDSVBDenChoLDXL;
    @BindView(R.id.tvLoaiVanBanTTVBDSVBDenChoLDXL)
    TextView tvLoaiVanBanTTVBDSVBDenChoLDXL;
    @BindView(R.id.tvTrichYeuTTVBDSVBDenChoLDXL)
    TextView tvTrichYeuTTVBDSVBDenChoLDXL;
    @BindView(R.id.tvNguoiKyTTVBDSVBDenChoLDXL)
    TextView tvNguoiKyTTVBDSVBDenChoLDXL;
    @BindView(R.id.tvNgayNhanTTVBDSVBDenChoLDXL)
    TextView tvNgayNhanTTVBDSVBDenChoLDXL;
    @BindView(R.id.tvSoTrangTTVBDSVBDenChoLDXL)
    TextView tvSoTrangTTVBDSVBDenChoLDXL;
    @BindView(R.id.tvDoMatTTVBDSVBDenChoLDXL)
    TextView tvDoMatTTVBDSVBDenChoLDXL;
    @BindView(R.id.tvNoiGuiDenTTVBDSVBDenChoLDXL)
    TextView tvNoiGuiDenTTVBDSVBDenChoLDXL;
    @BindView(R.id.tvNgayKyTTVBDSVBDenChoLDXL)
    TextView tvNgayKyTTVBDSVBDenChoLDXL;
    @BindView(R.id.tvChucVuTTVBDSVBDenChoLDXL)
    TextView tvChucVuTTVBDSVBDenChoLDXL;
    @BindView(R.id.tvHanGiaiQuyetTTVBDSVBDenChoLDXL)
    TextView tvHanGiaiQuyetTTVBDSVBDenChoLDXL;
    @BindView(R.id.tvDoKhanTTVBDSVBDenChoLDXL)
    TextView tvDoKhanTTVBDSVBDenChoLDXL;
    @BindView(R.id.tvNgayPhanLoaiTTVBDSVBDenChoLDXL)
    TextView tvNgayPhanLoaiTTVBDSVBDenChoLDXL;


    @BindView(R.id.rcvTTGQTTVBDSVBDenChoLDXL)
    RecyclerView rcvTTGQTTVBDSVBDenChoLDXL;
    @BindView(R.id.rcvTTDKTTVBDSVBDenChoLDXL)
    RecyclerView rcvTTDKTTVBDSVBDenChoLDXL;
    @BindView(R.id.rcvTTTNLVTTVBDSVBDenChoLDXL)
    RecyclerView rcvTTTNLVTTVBDSVBDenChoLDXL;
    @BindView(R.id.rcvTTGQPPHTTVBDSVBDenChoLDXL)
    RecyclerView rcvTTGQPPHTTVBDSVBDenChoLDXL;
    @BindView(R.id.rcvVanBanDi)
    RecyclerView rcvVanBanDi;

    @BindView(R.id.cbVBQPPL)
    CheckBox cbVBQPPL;
    @BindView(R.id.cbSTCChuTri)
    CheckBox cbSTCChuTri;
    @BindView(R.id.cbTBKL)
    CheckBox cbTBKL;

    @BindView(R.id.rdVBChiDeLuuTTVBDSVBDenChoLDXL)
    RadioButton rdVBChiDeLuuTTVBDSVBDenChoLDXL;
    @BindView(R.id.rdVBYeuCauTraLoiTTVBDSVBDenChoLDXL)
    RadioButton rdVBYeuCauTraLoiTTVBDSVBDenChoLDXL;


    @BindView(R.id.btnCVDaHoanThanhTTVBDSVBDenChoLDXL)
    Button btnCVDaHoanThanhTTVBDSVBDenChoLDXL;

    @BindView(R.id.tvKetQuaGiaiQuyetTTVBDSVBDenChoLDXL)
    EditText tvKetQuaGiaiQuyetTTVBDSVBDenChoLDXL;


    AdapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet adapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet;
    AdapterTrinhTuChuyenNhanLuuVetPhongPheDuyet adapterTrinhTuChuyenNhanLuuVetPhongPheDuyet;
    AdapterTrinhTuGiaiQuyetPhongPhoiHopChoLanhDaoPheDuyet adapterTrinhTuGiaiQuyetPhongPhoiHopChoLanhDaoPheDuyet;
    AdapterTepTinDinhKemPhongPH adapterTepTinDinhKemPhongPH;
    AdapterVanBanDiSoLuongVanBanGiaoPhongChuTri adapterVanBanDiSoLuongVanBanGiaoPhongChuTri;

    int idvb;


    @Override
    public int getContentViewId() {
        return R.layout.activity_ttvbvan_ban_cong_tac_dang_cho_xu_ly;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("idvb")) {
                idvb = intent.getIntExtra("idvb", 0);
                getPresenter().getDetailVBChuyenVienChuTriXuLy(idvb);
            }
        }

    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetCongViecSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onGetDaTaSuccess(DetailDeXuatCongViecPhoiHopChoDuyet detailDeXuatCongViecPhoiHopChoDuyet) {
        RecyclerViewTrinhTuGiaiQuyet((ArrayList<TrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet>) detailDeXuatCongViecPhoiHopChoDuyet.getTrinhTuGiaiQuyets());
        RecyclerViewTrinhTuChuyenNhanLuuVet((ArrayList<TrinhTuChuyenNhanLuuVetChoLanhDaoPhongPheDuyet>) detailDeXuatCongViecPhoiHopChoDuyet.getTrinhTuChuyenNhanLuuVets());
        RecyclerViewTrinhTuGiaiQuyetPhongPhoiHop((ArrayList<TrinhTuGiaiQuyetPhongPHChoLanhDaoPhongPheDuyet>) detailDeXuatCongViecPhoiHopChoDuyet.getTrinhTuGiaiQuyetPhongPHs());
        RecyclerViewTepTinDinhKem((ArrayList<TepTinDinhKemPPH>) detailDeXuatCongViecPhoiHopChoDuyet.getTepTinDinhKems());
        RecyclerViewKVanBanDiSoLuongVanBanGiaoPhongChuTri((ArrayList<VanBanDiChoLanhDaoPhongPheDuyet>) detailDeXuatCongViecPhoiHopChoDuyet.getVanBanDis());
        tvSoDenTTVBTTVBDSVBDenChoLDXL.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getSoDen()));
        tvKhuVucTTVBDSVBDenChoLDXL.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getKhuVuc()));
        tvSoKyHieuTTVBDSVBDenChoLDXL.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getSoKyHieu()));
        tvLoaiVanBanTTVBDSVBDenChoLDXL.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getLoaiVanBan()));
        tvTrichYeuTTVBDSVBDenChoLDXL.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getMoTa()));
        tvNguoiKyTTVBDSVBDenChoLDXL.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getTenNguoiKy()));
        tvNgayNhanTTVBDSVBDenChoLDXL.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getNgayNhan()));
        tvSoTrangTTVBDSVBDenChoLDXL.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getSoTrang()));
        tvDoMatTTVBDSVBDenChoLDXL.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getDoMat()));
        tvNoiGuiDenTTVBDSVBDenChoLDXL.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getNoiGuiDen()));
        tvNgayKyTTVBDSVBDenChoLDXL.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getNgayKy()));
        tvChucVuTTVBDSVBDenChoLDXL.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getChucVu()));
        tvHanGiaiQuyetTTVBDSVBDenChoLDXL.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getHanGiaiQuyet()));
        tvDoKhanTTVBDSVBDenChoLDXL.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getDoKhan()));
        tvNgayPhanLoaiTTVBDSVBDenChoLDXL.setText(String.valueOf(detailDeXuatCongViecPhoiHopChoDuyet.getNgayPhanLoai()));
        if (detailDeXuatCongViecPhoiHopChoDuyet.getSTCCT() == 1) {
            cbSTCChuTri.setChecked(true);
        }
        if (detailDeXuatCongViecPhoiHopChoDuyet.getVBQPPL() == 1) {
            cbVBQPPL.setChecked(true);
        }
        if (detailDeXuatCongViecPhoiHopChoDuyet.getTBKL() == 1) {
            cbTBKL.setChecked(true);
        }
    }

    @Override
    public void xoaKQPhongTLSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        getPresenter().getDetailVBChuyenVienChuTriXuLy(idvb);
    }

    @Override
    public TTVBVanBanCongTacDangChoXuLyPresenter createPresenter() {
        return new TTVBVanBanCongTacDangChoXuLyPresenterImpl(this);
    }

    @OnClick({R.id.imvBack, R.id.tvThongTinVanBanTTVBDSVBDenChoLDXL,
            R.id.tvTrinhTuGiaiQuyetTTVBDSVBDenChoLDXL, R.id.tvTepDinhKemTTVBDSVBDenChoLDXL,
            R.id.tvTruyenNhanLuuVietTTVBDSVBDenChoLDXL, R.id.tvTrinhTuGiaiQuyetPPHTTVBDSVBDenChoLDXL,
            R.id.btnCVDangThucHienTTVBDSVBDenChoLDXL, R.id.btnCVDaHoanThanhTTVBDSVBDenChoLDXL, R.id.tvVanBanDi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imvBack:
                finish();
                break;
            case R.id.tvThongTinVanBanTTVBDSVBDenChoLDXL:
                Expand(lnTTVBTTVBDSVBDenChoLDXL, imUpTTVBTTVBDSVBDenChoLDXL, imDownTTVBTTVBDSVBDenChoLDXL);
                break;
            case R.id.tvTrinhTuGiaiQuyetTTVBDSVBDenChoLDXL:
                Expand(lnTTGQTTVBDSVBDenChoLDXL, imUpTTGQTTVBDSVBDenChoLDXL, imDownTTGQTTVBDSVBDenChoLDXL);
                break;
            case R.id.tvTepDinhKemTTVBDSVBDenChoLDXL:
                Expand(lnTepDinhKemTTVBDSVBDenChoLDXL, imUpTTDKTTVBDSVBDenChoLDXL, imDownTTDKTTVBDSVBDenChoLDXL);
                break;
            case R.id.tvTruyenNhanLuuVietTTVBDSVBDenChoLDXL:
                Expand(lnTTTNLVTTVBDSVBDenChoLDXL, imUpTTTNLVTTVBDSVBDenChoLDXL, imDownTTTNLVTTVBDSVBDenChoLDXL);
                break;
            case R.id.tvTrinhTuGiaiQuyetPPHTTVBDSVBDenChoLDXL:
                Expand(lnTrinhTuGiaiQuyetPPHTTVBDSVBDenChoLDXL, imUpTTGQPPHTTVBDSVBDenChoLDXL, imDownTTGQPPHTTVBDSVBDenChoLDXL);
                break;

            case R.id.tvVanBanDi:
                Expand(lnVanBanDi, imUpVanBanDi, imDownVanBanDi);
                break;

            case R.id.btnCVDangThucHienTTVBDSVBDenChoLDXL:
                if (rdVBChiDeLuuTTVBDSVBDenChoLDXL.isChecked()) {
                    getPresenter().luuketqua(idvb, tvKetQuaGiaiQuyetTTVBDSVBDenChoLDXL.getText().toString(), 1, "", 0);

                } else if (rdVBYeuCauTraLoiTTVBDSVBDenChoLDXL.isChecked()) {
                    getPresenter().luuketqua(idvb, tvKetQuaGiaiQuyetTTVBDSVBDenChoLDXL.getText().toString(), 2, "", 0);
                }
                break;

            case R.id.btnCVDaHoanThanhTTVBDSVBDenChoLDXL:
                getPresenter().luuketqua(idvb, tvKetQuaGiaiQuyetTTVBDSVBDenChoLDXL.getText().toString(), 0, "", 1);
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

    void RecyclerViewTrinhTuGiaiQuyet(ArrayList<TrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet> trinhTuGiaiQuyets) {
        adapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet = new AdapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet(trinhTuGiaiQuyets);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTGQTTVBDSVBDenChoLDXL.setLayoutManager(layoutManager);
        rcvTTGQTTVBDSVBDenChoLDXL.setAdapter(adapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet);
        adapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet.notifyDataSetChanged();
    }

    void RecyclerViewTrinhTuChuyenNhanLuuVet(ArrayList<TrinhTuChuyenNhanLuuVetChoLanhDaoPhongPheDuyet> trinhTuChuyenNhanLuuVets) {
        adapterTrinhTuChuyenNhanLuuVetPhongPheDuyet = new AdapterTrinhTuChuyenNhanLuuVetPhongPheDuyet(trinhTuChuyenNhanLuuVets);
        LinearLayoutManager layoutManagerTrinhTuChuyenNhanLuuVet = new LinearLayoutManager(this);
        layoutManagerTrinhTuChuyenNhanLuuVet.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTTNLVTTVBDSVBDenChoLDXL.setLayoutManager(layoutManagerTrinhTuChuyenNhanLuuVet);
        rcvTTTNLVTTVBDSVBDenChoLDXL.setAdapter(adapterTrinhTuChuyenNhanLuuVetPhongPheDuyet);
        adapterTrinhTuChuyenNhanLuuVetPhongPheDuyet.notifyDataSetChanged();
    }

    void RecyclerViewTrinhTuGiaiQuyetPhongPhoiHop(ArrayList<TrinhTuGiaiQuyetPhongPHChoLanhDaoPhongPheDuyet> trinhTuGiaiQuyetPhongPhoiHops) {
        adapterTrinhTuGiaiQuyetPhongPhoiHopChoLanhDaoPheDuyet = new AdapterTrinhTuGiaiQuyetPhongPhoiHopChoLanhDaoPheDuyet(trinhTuGiaiQuyetPhongPhoiHops);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTGQPPHTTVBDSVBDenChoLDXL.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvTTGQPPHTTVBDSVBDenChoLDXL.setAdapter(adapterTrinhTuGiaiQuyetPhongPhoiHopChoLanhDaoPheDuyet);
        adapterTrinhTuGiaiQuyetPhongPhoiHopChoLanhDaoPheDuyet.notifyDataSetChanged();
    }

    void RecyclerViewTepTinDinhKem(ArrayList<TepTinDinhKemPPH> tepDinhKems) {
        adapterTepTinDinhKemPhongPH = new AdapterTepTinDinhKemPhongPH(tepDinhKems, this);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTDKTTVBDSVBDenChoLDXL.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvTTDKTTVBDSVBDenChoLDXL.setAdapter(adapterTepTinDinhKemPhongPH);
        adapterTepTinDinhKemPhongPH.notifyDataSetChanged();
    }

    void RecyclerViewKVanBanDiSoLuongVanBanGiaoPhongChuTri(ArrayList<VanBanDiChoLanhDaoPhongPheDuyet> vanBanDiChoLanhDaoPhongPheDuyetArrayList) {
        adapterVanBanDiSoLuongVanBanGiaoPhongChuTri = new AdapterVanBanDiSoLuongVanBanGiaoPhongChuTri(vanBanDiChoLanhDaoPhongPheDuyetArrayList, this);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvVanBanDi.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvVanBanDi.setAdapter(adapterVanBanDiSoLuongVanBanGiaoPhongChuTri);
        adapterVanBanDiSoLuongVanBanGiaoPhongChuTri.notifyDataSetChanged();
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
    public void onItemClickVanBanDiSoLuongVanBanGiaoPhongChuTri(VanBanDiChoLanhDaoPhongPheDuyet vanBanDiChoLanhDaoPhongPheDuyet) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanDiChoLanhDaoPhongPheDuyet.getUrlFile()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
