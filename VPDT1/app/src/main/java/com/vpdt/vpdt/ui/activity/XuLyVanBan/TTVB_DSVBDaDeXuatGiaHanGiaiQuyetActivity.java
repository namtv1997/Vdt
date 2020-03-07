package com.vpdt.vpdt.ui.activity.XuLyVanBan;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DetailVanBanChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.model.FileVanBanLienQuanChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.model.KetQuaGiaiQuyetChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.model.TepTinDinhKemPPH;
import com.vpdt.vpdt.model.TrinhTuChuyenNhanLuuVetChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetPhongPHChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.model.TrinhTuHoanThanhCVLuuVet;
import com.vpdt.vpdt.presenter.TTVB_DSVBDaHoanThanhChoLDPhongPheDuyetPresenter;
import com.vpdt.vpdt.presenter.TTVB_DSVBDaHoanThanhChoLDPhongPheDuyetView;
import com.vpdt.vpdt.presenter.impl.TTVB_DSVBDaHoanThanhChoLDPhongPheDuyetPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterFileVanBanLienQuanChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaGiaiQuyetPhongPheDuyet;
import com.vpdt.vpdt.ui.adapter.AdapterTepTinDinhKemPhongPH;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuChuyenNhanLuuVetPhongPheDuyet;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetPhongPhoiHopChoLanhDaoPheDuyet;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuHoanThanhLuuVetChoPhongPheDuyet;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity extends BaseActivity<TTVB_DSVBDaHoanThanhChoLDPhongPheDuyetPresenter>
        implements TTVB_DSVBDaHoanThanhChoLDPhongPheDuyetView, AdapterTepTinDinhKemPhongPH.OnItemClickListener,
        AdapterKetQuaGiaiQuyetPhongPheDuyet.OnItemketquaGiaiquyetClickListener, AdapterFileVanBanLienQuanChoLanhDaoPhongPheDuyet.OnItemClickListenerFileVanBanLienQuanChoLanhDaoPhongPheDuyet {

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


    @BindView(R.id.imDownFileVanBanLienQuan)
    ImageView imDownFileVanBanLienQuan;
    @BindView(R.id.imUpFileVanBanLienQuan)
    ImageView imUpFileVanBanLienQuan;

    @BindView(R.id.imDownKetQuaGiaiQuyet)
    ImageView imDownKetQuaGiaiQuyet;
    @BindView(R.id.imUpKetQuaGiaiQuyet)
    ImageView imUpKetQuaGiaiQuyet;

    @BindView(R.id.imDownTruyenNhanLuuViet)
    ImageView imDownTruyenNhanLuuViet;
    @BindView(R.id.imUpTruyenNhanLuuViet)
    ImageView imUpTruyenNhanLuuViet;

    @BindView(R.id.imDownTrinhTuGiaiQuyetPPH)
    ImageView imDownTrinhTuGiaiQuyetPPH;
    @BindView(R.id.imUpTrinhTuGiaiQuyetPPH)
    ImageView imUpTrinhTuGiaiQuyetPPH;

    @BindView(R.id.imDownTrinhTuHoanThanhCV)
    ImageView imDownTrinhTuHoanThanhCV;
    @BindView(R.id.imUpTrinhTuHoanThanhCV)
    ImageView imUpTrinhTuHoanThanhCV;

    @BindView(R.id.lnThongTinVanBan)
    LinearLayout lnThongTinVanBan;
    @BindView(R.id.lnTrinhTuGiaiQuyet)
    LinearLayout lnTrinhTuGiaiQuyet;
    @BindView(R.id.lnTepDinhKem)
    LinearLayout lnTepDinhKem;
    @BindView(R.id.lnTruyenNhanLuuViet)
    LinearLayout lnTruyenNhanLuuViet;
    @BindView(R.id.lnTrinhTuGiaiQuyetPPH)
    LinearLayout lnTrinhTuGiaiQuyetPPH;
    @BindView(R.id.lnTrinhTuHoanThanhCV)
    LinearLayout lnTrinhTuHoanThanhCV;
    @BindView(R.id.lnFileVanBanLienQuan)
    LinearLayout lnFileVanBanLienQuan;
    @BindView(R.id.lnKetQuaGiaiQuyet)
    LinearLayout lnKetQuaGiaiQuyet;


    @BindView(R.id.tvSoDen)
    TextView tvSoDenTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvKhuVuc)
    TextView tvKhuVucTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvSoKyHieu)
    TextView tvSoKyHieuTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvLoaiVanBan)
    TextView tvLoaiVanBanTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeuTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvNguoiKy)
    TextView tvNguoiKyTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvNgayNhan)
    TextView tvNgayNhanTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvSoTrang)
    TextView tvSoTrangTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvDoMat)
    TextView tvDoMatTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvNoiGuiDen)
    TextView tvNoiGuiDenTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvNgayKy)
    TextView tvNgayKyTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvChucVu)
    TextView tvChucVuTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvHanGiaiQuyet)
    TextView tvHanGiaiQuyetTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvDoKhan)
    TextView tvDoKhanTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.tvNgayPhanLoai)
    TextView tvNgayPhanLoaiTTVBDuyetDSVBGiaHanGiaiQuyet;

    @BindView(R.id.rcvTrinhTuGiaiQuyet)
    RecyclerView rcvTrinhTuGiaiQuyet;
    @BindView(R.id.rcvTepDinhKem)
    RecyclerView rcvTepDinhKem;
    @BindView(R.id.rcvTruyenNhanLuuViet)
    RecyclerView rcvTruyenNhanLuuViet;
    @BindView(R.id.rcvTrinhTuGiaiQuyetPPH)
    RecyclerView rcvTrinhTuGiaiQuyetPPH;
    @BindView(R.id.rcvTrinhTuHoanThanhCV)
    RecyclerView rcvTrinhTuHoanThanhCV;
    @BindView(R.id.rcvFileVanBanLienQuan)
    RecyclerView rcvFileVanBanLienQuan;
    @BindView(R.id.rcvKetQuaGiaiQuyet)
    RecyclerView rcvKetQuaGiaiQuyet;

    @BindView(R.id.cbQPPL)
    CheckBox cbQPPL;
    @BindView(R.id.cbSTCChuTri)
    CheckBox cbSTCChuTri;
    @BindView(R.id.cbTBKL)
    CheckBox cbTBKL;
    @BindView(R.id.cbToCongTac)
    CheckBox cbToCongTac;

    @BindView(R.id.rlTrinhTuGiaiQuyet)
    RelativeLayout rlTrinhTuGiaiQuyet;
    @BindView(R.id.rlTepDinhKem)
    RelativeLayout rlTepDinhKem;
    @BindView(R.id.rlFileVanBanLienQuan)
    RelativeLayout rlFileVanBanLienQuan;
    @BindView(R.id.rlTrinhTuTruyenNhanLuuVet)
    RelativeLayout rlTrinhTuTruyenNhanLuuVet;
    @BindView(R.id.rlTrinhTuGiaiQuyetPhongPhoiHop)
    RelativeLayout rlTrinhTuGiaiQuyetPhongPhoiHop;
    @BindView(R.id.rlKetQuaGiaiQuyet)
    RelativeLayout rlKetQuaGiaiQuyet;
    @BindView(R.id.rlTrinhTuHoanThanhCongViec)
    RelativeLayout rlTrinhTuHoanThanhCongViec;


    AdapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet adapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet;
    AdapterTepTinDinhKemPhongPH adapterTepTinDinhKemPhongPH;
    AdapterTrinhTuChuyenNhanLuuVetPhongPheDuyet adapterTrinhTuChuyenNhanLuuVetPhongPheDuyet;
    AdapterTrinhTuGiaiQuyetPhongPhoiHopChoLanhDaoPheDuyet adapterTrinhTuGiaiQuyetPhongPhoiHopChoLanhDaoPheDuyet;
    AdapterTrinhTuHoanThanhLuuVetChoPhongPheDuyet adapterTrinhTuHoanThanhLuuVetChoPhongPheDuyet;
    AdapterFileVanBanLienQuanChoLanhDaoPhongPheDuyet adapterFileVanBanLienQuanChoLanhDaoPhongPheDuyet;
    AdapterKetQuaGiaiQuyetPhongPheDuyet adapterKetQuaGiaiQuyetPhongPheDuyet;

    int id;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ttvb_dsvbda_de_xuat_gia_han_giai_quyet;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("vanBanDaDeXuatGiaHanGiaiQuyet")) {
                id = intent.getIntExtra("vanBanDaDeXuatGiaHanGiaiQuyet", 0);
                getPresenter().getDetailVBQuaTrinhXuLy(id);

            }
        }
    }

    @OnClick({R.id.imvBack, R.id.tvThongTinVanBan,
            R.id.tvTrinhTuGiaiQuyet, R.id.tvTepDinhKem,
            R.id.tvTruyenNhanLuuViet, R.id.tvTrinhTuGiaiQuyetPPH,
            R.id.tvTrinhTuHoanThanhCV, R.id.tvFileVanBanLienQuan, R.id.tvKetQuaGiaiQuyet})
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
            case R.id.tvTruyenNhanLuuViet:
                Expand(lnTruyenNhanLuuViet, imUpTruyenNhanLuuViet, imDownTruyenNhanLuuViet);
                break;
            case R.id.tvTrinhTuGiaiQuyetPPH:
                Expand(lnTrinhTuGiaiQuyetPPH, imUpTrinhTuGiaiQuyetPPH, imDownTrinhTuGiaiQuyetPPH);
                break;
            case R.id.tvTrinhTuHoanThanhCV:
                Expand(lnTrinhTuHoanThanhCV, imUpTrinhTuHoanThanhCV, imDownTrinhTuHoanThanhCV);
                break;
            case R.id.tvFileVanBanLienQuan:
                Expand(lnFileVanBanLienQuan, imUpFileVanBanLienQuan, imDownFileVanBanLienQuan);
                break;
            case R.id.tvKetQuaGiaiQuyet:
                Expand(lnKetQuaGiaiQuyet, imUpKetQuaGiaiQuyet, imDownKetQuaGiaiQuyet);
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
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDaTaSuccess(DetailVanBanChoLanhDaoPhongPheDuyet detailVanBanChoLanhDaoPhongPheDuyet) {
        RecyclerViewTrinhTuGiaiQuyet((ArrayList<TrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet>) detailVanBanChoLanhDaoPhongPheDuyet.getTrinhTuGiaiQuyets());
        RecyclerViewTepTinDinhKem((ArrayList<TepTinDinhKemPPH>) detailVanBanChoLanhDaoPhongPheDuyet.getTepTinDinhKems());
        RecyclerViewFileVanBanLienQuanChoLanhDaoPhongPheDuyet((ArrayList<FileVanBanLienQuanChoLanhDaoPhongPheDuyet>) detailVanBanChoLanhDaoPhongPheDuyet.getFileVanBanLienQuans());
        RecyclerViewTrinhTuChuyenNhanLuuVet((ArrayList<TrinhTuChuyenNhanLuuVetChoLanhDaoPhongPheDuyet>) detailVanBanChoLanhDaoPhongPheDuyet.getTrinhTuChuyenNhanLuuVets());
        RecyclerViewTrinhTuGiaiQuyetPhongPhoiHop((ArrayList<TrinhTuGiaiQuyetPhongPHChoLanhDaoPhongPheDuyet>) detailVanBanChoLanhDaoPhongPheDuyet.getTrinhTuGiaiQuyetPhongPHs());
        RecyclerViewKetQuaGiaiQuyetPhongPheDuyet((ArrayList<KetQuaGiaiQuyetChoLanhDaoPhongPheDuyet>) detailVanBanChoLanhDaoPhongPheDuyet.getKetQuaGiaiQuyets());
        RecyclerViewKTrinhTuHoanThanhLuuVetChoPhongPheDuyet((ArrayList<TrinhTuHoanThanhCVLuuVet>) detailVanBanChoLanhDaoPhongPheDuyet.getTrinhTuHoanThanhCVLuuVets());

        tvSoDenTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailVanBanChoLanhDaoPhongPheDuyet.getSoDen()));
        tvKhuVucTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailVanBanChoLanhDaoPhongPheDuyet.getKhuVuc()));
        tvSoKyHieuTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailVanBanChoLanhDaoPhongPheDuyet.getSoKyHieu()));
        tvLoaiVanBanTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailVanBanChoLanhDaoPhongPheDuyet.getLoaiVanBan()));
        tvTrichYeuTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailVanBanChoLanhDaoPhongPheDuyet.getMoTa()));
        tvNguoiKyTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailVanBanChoLanhDaoPhongPheDuyet.getTenNguoiKy()));
        tvNgayNhanTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailVanBanChoLanhDaoPhongPheDuyet.getNgayNhan()));
        tvSoTrangTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailVanBanChoLanhDaoPhongPheDuyet.getSoTrang()));
        tvDoMatTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailVanBanChoLanhDaoPhongPheDuyet.getDoMat()));
        tvNoiGuiDenTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailVanBanChoLanhDaoPhongPheDuyet.getNoiGuiDen()));
        tvNgayKyTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailVanBanChoLanhDaoPhongPheDuyet.getNgayKy()));
        tvChucVuTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailVanBanChoLanhDaoPhongPheDuyet.getChucVu()));
        tvHanGiaiQuyetTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailVanBanChoLanhDaoPhongPheDuyet.getHanGiaiQuyet()));
        tvDoKhanTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailVanBanChoLanhDaoPhongPheDuyet.getDoKhan()));
        tvNgayPhanLoaiTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(detailVanBanChoLanhDaoPhongPheDuyet.getNgayPhanLoai()));
        if (detailVanBanChoLanhDaoPhongPheDuyet.getSTCCT() == 1) {
            cbSTCChuTri.setChecked(true);
        }
        if (detailVanBanChoLanhDaoPhongPheDuyet.getVBQPPL() == 1) {
            cbQPPL.setChecked(true);
        }
        if (detailVanBanChoLanhDaoPhongPheDuyet.getTBKL() == 1) {
            cbTBKL.setChecked(true);
        }
        if (detailVanBanChoLanhDaoPhongPheDuyet.getToCongTac() == 1) {
            cbToCongTac.setChecked(true);
        }
        if (detailVanBanChoLanhDaoPhongPheDuyet.getTrinhTuGiaiQuyets().size() == 0) {
            rlTrinhTuGiaiQuyet.setVisibility(View.GONE);
            lnTrinhTuGiaiQuyet.setVisibility(View.GONE);
        }
        if (detailVanBanChoLanhDaoPhongPheDuyet.getTepTinDinhKems().size() == 0) {
            rlTepDinhKem.setVisibility(View.GONE);
            lnTepDinhKem.setVisibility(View.GONE);
        }
        if (detailVanBanChoLanhDaoPhongPheDuyet.getFileVanBanLienQuans().size() == 0) {
            rlFileVanBanLienQuan.setVisibility(View.GONE);
            lnFileVanBanLienQuan.setVisibility(View.GONE);
        }
        if (detailVanBanChoLanhDaoPhongPheDuyet.getTrinhTuChuyenNhanLuuVets().size() == 0) {
            rlTrinhTuTruyenNhanLuuVet.setVisibility(View.GONE);
            lnTruyenNhanLuuViet.setVisibility(View.GONE);
        }
        if (detailVanBanChoLanhDaoPhongPheDuyet.getTrinhTuGiaiQuyetPhongPHs().size() == 0) {
            rlTrinhTuGiaiQuyetPhongPhoiHop.setVisibility(View.GONE);
            lnTrinhTuGiaiQuyetPPH.setVisibility(View.GONE);
        }
        if (detailVanBanChoLanhDaoPhongPheDuyet.getKetQuaGiaiQuyets().size() == 0) {
            rlKetQuaGiaiQuyet.setVisibility(View.GONE);
            lnKetQuaGiaiQuyet.setVisibility(View.GONE);
        }
        if (detailVanBanChoLanhDaoPhongPheDuyet.getTrinhTuHoanThanhCVLuuVets().size() == 0) {
            rlTrinhTuHoanThanhCongViec.setVisibility(View.GONE);
            lnTrinhTuHoanThanhCV.setVisibility(View.GONE);
        }
    }

    @Override
    public void xoaKQPhongTLSuccess() {
        Toast.makeText(this, "Đã xóa", Toast.LENGTH_SHORT).show();
        getPresenter().getDetailVBQuaTrinhXuLy(id);
    }

    @Override
    public TTVB_DSVBDaHoanThanhChoLDPhongPheDuyetPresenter createPresenter() {
        return new TTVB_DSVBDaHoanThanhChoLDPhongPheDuyetPresenterImpl(this);
    }

    void RecyclerViewTrinhTuGiaiQuyet(ArrayList<TrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet> trinhTuGiaiQuyets) {
        adapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet = new AdapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet(trinhTuGiaiQuyets);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTrinhTuGiaiQuyet.setLayoutManager(layoutManager);
        rcvTrinhTuGiaiQuyet.setAdapter(adapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet);
        adapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet.notifyDataSetChanged();
    }


    void RecyclerViewTrinhTuChuyenNhanLuuVet(ArrayList<TrinhTuChuyenNhanLuuVetChoLanhDaoPhongPheDuyet> trinhTuChuyenNhanLuuVets) {
        adapterTrinhTuChuyenNhanLuuVetPhongPheDuyet = new AdapterTrinhTuChuyenNhanLuuVetPhongPheDuyet(trinhTuChuyenNhanLuuVets);
        LinearLayoutManager layoutManagerTrinhTuChuyenNhanLuuVet = new LinearLayoutManager(this);
        layoutManagerTrinhTuChuyenNhanLuuVet.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTruyenNhanLuuViet.setLayoutManager(layoutManagerTrinhTuChuyenNhanLuuVet);
        rcvTruyenNhanLuuViet.setAdapter(adapterTrinhTuChuyenNhanLuuVetPhongPheDuyet);
        adapterTrinhTuChuyenNhanLuuVetPhongPheDuyet.notifyDataSetChanged();
    }

    void RecyclerViewTrinhTuGiaiQuyetPhongPhoiHop(ArrayList<TrinhTuGiaiQuyetPhongPHChoLanhDaoPhongPheDuyet> trinhTuGiaiQuyetPhongPhoiHops) {
        adapterTrinhTuGiaiQuyetPhongPhoiHopChoLanhDaoPheDuyet = new AdapterTrinhTuGiaiQuyetPhongPhoiHopChoLanhDaoPheDuyet(trinhTuGiaiQuyetPhongPhoiHops);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTrinhTuGiaiQuyetPPH.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvTrinhTuGiaiQuyetPPH.setAdapter(adapterTrinhTuGiaiQuyetPhongPhoiHopChoLanhDaoPheDuyet);
        adapterTrinhTuGiaiQuyetPhongPhoiHopChoLanhDaoPheDuyet.notifyDataSetChanged();
    }

    void RecyclerViewTepTinDinhKem(ArrayList<TepTinDinhKemPPH> tepDinhKems) {
        adapterTepTinDinhKemPhongPH = new AdapterTepTinDinhKemPhongPH(tepDinhKems, this);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTepDinhKem.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvTepDinhKem.setAdapter(adapterTepTinDinhKemPhongPH);
        adapterTepTinDinhKemPhongPH.notifyDataSetChanged();
    }

    void RecyclerViewFileVanBanLienQuanChoLanhDaoPhongPheDuyet(ArrayList<FileVanBanLienQuanChoLanhDaoPhongPheDuyet> fileVanBanLienQuanChoLanhDaoPhongPheDuyets) {
        adapterFileVanBanLienQuanChoLanhDaoPhongPheDuyet = new AdapterFileVanBanLienQuanChoLanhDaoPhongPheDuyet(fileVanBanLienQuanChoLanhDaoPhongPheDuyets, this);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvFileVanBanLienQuan.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvFileVanBanLienQuan.setAdapter(adapterFileVanBanLienQuanChoLanhDaoPhongPheDuyet);
        adapterFileVanBanLienQuanChoLanhDaoPhongPheDuyet.notifyDataSetChanged();
    }

    void RecyclerViewKetQuaGiaiQuyetPhongPheDuyet(ArrayList<KetQuaGiaiQuyetChoLanhDaoPhongPheDuyet> ketQuaGiaiQuyetChoLanhDaoPhongPheDuyets) {
        adapterKetQuaGiaiQuyetPhongPheDuyet = new AdapterKetQuaGiaiQuyetPhongPheDuyet(ketQuaGiaiQuyetChoLanhDaoPhongPheDuyets, this);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvKetQuaGiaiQuyet.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvKetQuaGiaiQuyet.setAdapter(adapterKetQuaGiaiQuyetPhongPheDuyet);
        adapterKetQuaGiaiQuyetPhongPheDuyet.notifyDataSetChanged();
    }

    void RecyclerViewKTrinhTuHoanThanhLuuVetChoPhongPheDuyet(ArrayList<TrinhTuHoanThanhCVLuuVet> ketQuaGiaiQuyetChoLanhDaoPhongPheDuyets) {
        adapterTrinhTuHoanThanhLuuVetChoPhongPheDuyet = new AdapterTrinhTuHoanThanhLuuVetChoPhongPheDuyet(ketQuaGiaiQuyetChoLanhDaoPhongPheDuyets);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTrinhTuHoanThanhCV.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvTrinhTuHoanThanhCV.setAdapter(adapterTrinhTuHoanThanhLuuVetChoPhongPheDuyet);
        adapterTrinhTuHoanThanhLuuVetChoPhongPheDuyet.notifyDataSetChanged();
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
    public void onItemClickFileVanBanLienQuanChoLanhDaoPhongPheDuyet(FileVanBanLienQuanChoLanhDaoPhongPheDuyet fileVanBanLienQuanChoLanhDaoPhongPheDuyet) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(fileVanBanLienQuanChoLanhDaoPhongPheDuyet.getUrlFile()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemketquaGiaiquyetClick(KetQuaGiaiQuyetChoLanhDaoPhongPheDuyet ketquaGiaiquyetPhongPhoihop) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ketquaGiaiquyetPhongPhoihop.getUrlFile()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemTacVuClick(KetQuaGiaiQuyetChoLanhDaoPhongPheDuyet ketquaGiaiquyetPhongPhoihop) {
        getPresenter().xoaKQPhongTL(ketquaGiaiquyetPhongPhoihop.getId());
    }

}
