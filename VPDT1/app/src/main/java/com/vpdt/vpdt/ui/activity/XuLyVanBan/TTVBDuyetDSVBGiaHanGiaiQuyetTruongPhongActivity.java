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
import com.vpdt.vpdt.model.DetailVanBanQuahan;
import com.vpdt.vpdt.model.FileVanbanLienquan;
import com.vpdt.vpdt.model.KetquaGiaiQuyet;
import com.vpdt.vpdt.model.TepDinhKem;
import com.vpdt.vpdt.model.TrinhTuChuyenNhanLuuVet;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyet;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetPhongPhoiHop;
import com.vpdt.vpdt.model.TrinhTuHoanThanhLuuVet;
import com.vpdt.vpdt.presenter.NDVBDuyetDSVBGiaHanGiaiQuyetPresenter;
import com.vpdt.vpdt.presenter.NDVBDuyetDSVBGiaHanGiaiQuyetView;
import com.vpdt.vpdt.presenter.impl.NDVBDuyetDSVBGiaHanGiaiQuyetPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterFileVanBanLienQuan;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaGiaiQuyet;
import com.vpdt.vpdt.ui.adapter.AdapterTepTinDinhKem;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuChuyenNhanLuuVet;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyet;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetPhongPhoiHop;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuHoanThanhLuuVet;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTVBDuyetDSVBGiaHanGiaiQuyetTruongPhongActivity extends BaseActivity<NDVBDuyetDSVBGiaHanGiaiQuyetPresenter>
        implements NDVBDuyetDSVBGiaHanGiaiQuyetView,
        AdapterTepTinDinhKem.OnItemClickListener, AdapterKetQuaGiaiQuyet.OnItemClickListener, AdapterFileVanBanLienQuan.OnItemClickListener {

    @BindView(R.id.imDownThongTinVanBan)
    ImageView imDownTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.imUpThongTinVanBan)
    ImageView imUpTTVBTTVBDuyetDSVBGiaHanGiaiQuyet;

    @BindView(R.id.imDownTrinhTuGiaiQuyet)
    ImageView imDownTTGQTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.imUpTrinhTuGiaiQuyet)
    ImageView imUpTTGQTTVBDuyetDSVBGiaHanGiaiQuyet;

    @BindView(R.id.imDownTepDinhKem)
    ImageView imDownTTDKTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.imUpTepDinhKem)
    ImageView imUpTTDKTTVBDuyetDSVBGiaHanGiaiQuyet;

    @BindView(R.id.imDownFileVanBanLienQuan)
    ImageView imDownFileVanBanLienQuan;
    @BindView(R.id.imUpFileVanBanLienQuan)
    ImageView imUpFileVanBanLienQuan;

    @BindView(R.id.imDownTruyenNhanLuuViet)
    ImageView imDownTTTNLVTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.imUpTruyenNhanLuuViet)
    ImageView imUpTTTNLVTTVBDuyetDSVBGiaHanGiaiQuyet;

    @BindView(R.id.imDownTrinhTuGiaiQuyetPPH)
    ImageView imDownTTGQPPHTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.imUpTrinhTuGiaiQuyetPPH)
    ImageView imUpTTGQPPHTTVBDuyetDSVBGiaHanGiaiQuyet;

    @BindView(R.id.imDownKetQuaGiaiQuyet)
    ImageView imDownKetQuaGiaiQuyet;
    @BindView(R.id.imUpKetQuaGiaiQuyet)
    ImageView imUpKetQuaGiaiQuyet;

    @BindView(R.id.imDownTrinhTuHoanThanhCV)
    ImageView imDownTTHTCVLVTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.imUpTrinhTuHoanThanhCV)
    ImageView imUpTTHTCVLVTTVBDuyetDSVBGiaHanGiaiQuyet;


    @BindView(R.id.lnThongTinVanBan)
    LinearLayout lnTTVBTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.lnTrinhTuGiaiQuyet)
    LinearLayout lnTTGQTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.lnTepDinhKem)
    LinearLayout lnTepDinhKemTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.lnTruyenNhanLuuViet)
    LinearLayout lnTTTNLVTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.lnTrinhTuGiaiQuyetPPH)
    LinearLayout lnTrinhTuGiaiQuyetPPHTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.lnTrinhTuHoanThanhCV)
    LinearLayout lnTrinhTuHoanThanhCVTTVBDuyetDSVBGiaHanGiaiQuyet;
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
    RecyclerView rcvTTGQTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.rcvTepDinhKem)
    RecyclerView rcvTTDKTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.rcvTruyenNhanLuuViet)
    RecyclerView rcvTTTNLVTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.rcvTrinhTuGiaiQuyetPPH)
    RecyclerView rcvTTGQPPHTTVBDuyetDSVBGiaHanGiaiQuyet;
    @BindView(R.id.rcvTrinhTuHoanThanhCV)
    RecyclerView rcvTTHTCVLVTTVBDuyetDSVBGiaHanGiaiQuyet;
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

    int idGiahan;
    private AdapterKetQuaGiaiQuyet adapterKetQuaGiaiQuyet;
    private AdapterFileVanBanLienQuan adapterFileVanBanLienQuan;
    private AdapterTrinhTuGiaiQuyet adapterTrinhTuGiaiQuyet;
    private AdapterTrinhTuChuyenNhanLuuVet adapterTrinhTuChuyenNhanLuuVet;
    private AdapterTrinhTuGiaiQuyetPhongPhoiHop adapterTrinhTuGiaiQuyetPhongPhoiHop;
    private AdapterTepTinDinhKem adapterTepTinDinhKem;
    private AdapterTrinhTuHoanThanhLuuVet adapterTrinhTuHoanThanhLuuVet;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ttvbduyet_dsvbgia_han_giai_quyet_truong_phong;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("hanGiaiQuyetTruongPhong")) {
                idGiahan = intent.getIntExtra("hanGiaiQuyetTruongPhong", 0);
                getPresenter().getbyidvbgiahangiaquyet(idGiahan);

            }
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess(DetailVanBanQuahan dsvbDaChiDao) {
        RecyclerViewTrinhTuGiaiQuyet((ArrayList<TrinhTuGiaiQuyet>) dsvbDaChiDao.getTrinhTuGiaiQuyets());
        RecyclerViewTrinhTuChuyenNhanLuuVet((ArrayList<TrinhTuChuyenNhanLuuVet>) dsvbDaChiDao.getTrinhTuChuyenNhanLuuVets());
        RecyclerViewTrinhTuGiaiQuyetPhongPhoiHop((ArrayList<TrinhTuGiaiQuyetPhongPhoiHop>) dsvbDaChiDao.getTrinhTuGiaiQuyetPhongPhoiHops());
        RecyclerViewTepTinDinhKem((ArrayList<TepDinhKem>) dsvbDaChiDao.getTepDinhKems());
        RecyclerViewTrinhTuHoanThanhLuuVet((ArrayList<TrinhTuHoanThanhLuuVet>) dsvbDaChiDao.getTrinhTuHoanThanhLuuVets());
        RecyclerViewFileVanBanLienQuan((ArrayList<FileVanbanLienquan>) dsvbDaChiDao.getFileVanbanLienquans());
        RecyclerViewKetQuaGiaiQuyet((ArrayList<KetquaGiaiQuyet>) dsvbDaChiDao.getKetquaGiaiQuyets());

        tvSoDenTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(dsvbDaChiDao.getSoDen()));
        tvKhuVucTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(dsvbDaChiDao.getKhuVuc()));
        tvSoKyHieuTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(dsvbDaChiDao.getSoKyHieu()));
        tvLoaiVanBanTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(dsvbDaChiDao.getLoaiVanBan()));
        tvTrichYeuTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(dsvbDaChiDao.getTrichYeu()));
        tvNguoiKyTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(dsvbDaChiDao.getNguoiKy()));
        tvNgayNhanTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(dsvbDaChiDao.getNgayNhan()));
        tvSoTrangTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(dsvbDaChiDao.getSoTrang()));
        tvDoMatTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(dsvbDaChiDao.getDoMat()));
        tvNoiGuiDenTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(dsvbDaChiDao.getNoiGuiDen()));
        tvNgayKyTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(dsvbDaChiDao.getNgayKy()));
        tvChucVuTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(dsvbDaChiDao.getChucVu()));
        tvHanGiaiQuyetTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(dsvbDaChiDao.getHanGiaiQuyet()));
        tvDoKhanTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(dsvbDaChiDao.getDoKhan()));
        tvNgayPhanLoaiTTVBDuyetDSVBGiaHanGiaiQuyet.setText(String.valueOf(dsvbDaChiDao.getNgayPhanLoai()));
        if (dsvbDaChiDao.getISTCChuTri() == 1) {
            cbSTCChuTri.setChecked(true);
        }
        if (dsvbDaChiDao.getIsVanBanQPPL() == 1) {
            cbQPPL.setChecked(true);
        }
        if (dsvbDaChiDao.getIsVanBanTBKL() == 1) {
            cbTBKL.setChecked(true);
        }
        if (dsvbDaChiDao.getIsToCongTac() == 1) {
            cbToCongTac.setChecked(true);
        }

        if (dsvbDaChiDao.getTrinhTuGiaiQuyets().size() == 0) {
            rlTrinhTuGiaiQuyet.setVisibility(View.GONE);
            lnTTGQTTVBDuyetDSVBGiaHanGiaiQuyet.setVisibility(View.GONE);
        }
        if (dsvbDaChiDao.getTepDinhKems().size() == 0) {
            rlTepDinhKem.setVisibility(View.GONE);
            lnTepDinhKemTTVBDuyetDSVBGiaHanGiaiQuyet.setVisibility(View.GONE);
        }
        if (dsvbDaChiDao.getFileVanbanLienquans().size() == 0) {
            rlFileVanBanLienQuan.setVisibility(View.GONE);
            lnFileVanBanLienQuan.setVisibility(View.GONE);
        }
        if (dsvbDaChiDao.getTrinhTuChuyenNhanLuuVets().size() == 0) {
            rlTrinhTuTruyenNhanLuuVet.setVisibility(View.GONE);
            lnTTTNLVTTVBDuyetDSVBGiaHanGiaiQuyet.setVisibility(View.GONE);
        }
        if (dsvbDaChiDao.getTrinhTuGiaiQuyetPhongPhoiHops().size() == 0) {
            rlTrinhTuGiaiQuyetPhongPhoiHop.setVisibility(View.GONE);
            lnTrinhTuGiaiQuyetPPHTTVBDuyetDSVBGiaHanGiaiQuyet.setVisibility(View.GONE);
        }
        if (dsvbDaChiDao.getKetquaGiaiQuyets().size() == 0) {
            rlKetQuaGiaiQuyet.setVisibility(View.GONE);
            lnKetQuaGiaiQuyet.setVisibility(View.GONE);
        }
        if (dsvbDaChiDao.getTrinhTuHoanThanhLuuVets().size() == 0) {
            rlTrinhTuHoanThanhCongViec.setVisibility(View.GONE);
            lnTrinhTuHoanThanhCVTTVBDuyetDSVBGiaHanGiaiQuyet.setVisibility(View.GONE);
        }
    }

    @Override
    public void tuChoiHanGiaiQuyet() {

    }

    @Override
    public void duyetHanGiaiQuyet() {

    }

    @Override
    public void duyetVBGiaHanGiaQuyetCB() {

    }

    @Override
    public void duyetVBGiaHanGiaQuyetTP() {

    }

    @Override
    public NDVBDuyetDSVBGiaHanGiaiQuyetPresenter createPresenter() {
        return new NDVBDuyetDSVBGiaHanGiaiQuyetPresenterImpl(this);
    }

    @Override
    public void onItemClick(TepDinhKem dinhKem) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dinhKem.getDuongDan()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick({R.id.imvBack, R.id.tvThongTinVanBan, R.id.tvFileVanBanLienQuan, R.id.tvKetQuaGiaiQuyet,
            R.id.tvTrinhTuGiaiQuyet, R.id.tvTepDinhKem,
            R.id.tvTruyenNhanLuuViet, R.id.tvTrinhTuGiaiQuyetPPH,
            R.id.tvTrinhTuHoanThanhCV})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imvBack:
                finish();
                break;
            case R.id.tvThongTinVanBan:
                Expand(lnTTVBTTVBDuyetDSVBGiaHanGiaiQuyet, imUpTTVBTTVBDuyetDSVBGiaHanGiaiQuyet, imDownTTVBDuyetDSVBGiaHanGiaiQuyet);
                break;
            case R.id.tvTrinhTuGiaiQuyet:
                Expand(lnTTGQTTVBDuyetDSVBGiaHanGiaiQuyet, imUpTTGQTTVBDuyetDSVBGiaHanGiaiQuyet, imDownTTGQTTVBDuyetDSVBGiaHanGiaiQuyet);
                break;
            case R.id.tvTepDinhKem:
                Expand(lnTepDinhKemTTVBDuyetDSVBGiaHanGiaiQuyet, imUpTTDKTTVBDuyetDSVBGiaHanGiaiQuyet, imDownTTDKTTVBDuyetDSVBGiaHanGiaiQuyet);
                break;
            case R.id.tvTruyenNhanLuuViet:
                Expand(lnTTTNLVTTVBDuyetDSVBGiaHanGiaiQuyet, imUpTTTNLVTTVBDuyetDSVBGiaHanGiaiQuyet, imDownTTTNLVTTVBDuyetDSVBGiaHanGiaiQuyet);
                break;
            case R.id.tvTrinhTuGiaiQuyetPPH:
                Expand(lnTrinhTuGiaiQuyetPPHTTVBDuyetDSVBGiaHanGiaiQuyet, imUpTTGQPPHTTVBDuyetDSVBGiaHanGiaiQuyet, imDownTTGQPPHTTVBDuyetDSVBGiaHanGiaiQuyet);
                break;
            case R.id.tvTrinhTuHoanThanhCV:
                Expand(lnTrinhTuHoanThanhCVTTVBDuyetDSVBGiaHanGiaiQuyet, imUpTTHTCVLVTTVBDuyetDSVBGiaHanGiaiQuyet, imDownTTHTCVLVTTVBDuyetDSVBGiaHanGiaiQuyet);
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

    void RecyclerViewTrinhTuGiaiQuyet(ArrayList<TrinhTuGiaiQuyet> trinhTuGiaiQuyets) {
        adapterTrinhTuGiaiQuyet = new AdapterTrinhTuGiaiQuyet(this, trinhTuGiaiQuyets);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTGQTTVBDuyetDSVBGiaHanGiaiQuyet.setLayoutManager(layoutManager);
        rcvTTGQTTVBDuyetDSVBGiaHanGiaiQuyet.setAdapter(adapterTrinhTuGiaiQuyet);
        adapterTrinhTuGiaiQuyet.notifyDataSetChanged();
    }

    void RecyclerViewTrinhTuChuyenNhanLuuVet(ArrayList<TrinhTuChuyenNhanLuuVet> trinhTuChuyenNhanLuuVets) {
        adapterTrinhTuChuyenNhanLuuVet = new AdapterTrinhTuChuyenNhanLuuVet(this, trinhTuChuyenNhanLuuVets);
        LinearLayoutManager layoutManagerTrinhTuChuyenNhanLuuVet = new LinearLayoutManager(this);
        layoutManagerTrinhTuChuyenNhanLuuVet.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTTNLVTTVBDuyetDSVBGiaHanGiaiQuyet.setLayoutManager(layoutManagerTrinhTuChuyenNhanLuuVet);
        rcvTTTNLVTTVBDuyetDSVBGiaHanGiaiQuyet.setAdapter(adapterTrinhTuChuyenNhanLuuVet);
        adapterTrinhTuChuyenNhanLuuVet.notifyDataSetChanged();
    }

    void RecyclerViewTrinhTuGiaiQuyetPhongPhoiHop(ArrayList<TrinhTuGiaiQuyetPhongPhoiHop> trinhTuGiaiQuyetPhongPhoiHops) {
        adapterTrinhTuGiaiQuyetPhongPhoiHop = new AdapterTrinhTuGiaiQuyetPhongPhoiHop(this, trinhTuGiaiQuyetPhongPhoiHops);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTGQPPHTTVBDuyetDSVBGiaHanGiaiQuyet.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvTTGQPPHTTVBDuyetDSVBGiaHanGiaiQuyet.setAdapter(adapterTrinhTuGiaiQuyetPhongPhoiHop);
        adapterTrinhTuGiaiQuyetPhongPhoiHop.notifyDataSetChanged();
    }

    void RecyclerViewTepTinDinhKem(ArrayList<TepDinhKem> tepDinhKems) {
        adapterTepTinDinhKem = new AdapterTepTinDinhKem(this, tepDinhKems, this);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTDKTTVBDuyetDSVBGiaHanGiaiQuyet.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvTTDKTTVBDuyetDSVBGiaHanGiaiQuyet.setAdapter(adapterTepTinDinhKem);
        adapterTepTinDinhKem.notifyDataSetChanged();
    }

    void RecyclerViewTrinhTuHoanThanhLuuVet(ArrayList<TrinhTuHoanThanhLuuVet> trinhTuHoanThanhLuuVets) {
        adapterTrinhTuHoanThanhLuuVet = new AdapterTrinhTuHoanThanhLuuVet(this, trinhTuHoanThanhLuuVets);
        LinearLayoutManager layoutManagerTrinhTuHoanThanhLuuVet = new LinearLayoutManager(this);
        layoutManagerTrinhTuHoanThanhLuuVet.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTHTCVLVTTVBDuyetDSVBGiaHanGiaiQuyet.setLayoutManager(layoutManagerTrinhTuHoanThanhLuuVet);
        rcvTTHTCVLVTTVBDuyetDSVBGiaHanGiaiQuyet.setAdapter(adapterTrinhTuHoanThanhLuuVet);
        adapterTrinhTuHoanThanhLuuVet.notifyDataSetChanged();
    }

    void RecyclerViewFileVanBanLienQuan(ArrayList<FileVanbanLienquan> fileVanbanLienquans) {
        adapterFileVanBanLienQuan = new AdapterFileVanBanLienQuan(fileVanbanLienquans, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvFileVanBanLienQuan.setLayoutManager(layoutManager);
        rcvFileVanBanLienQuan.setAdapter(adapterFileVanBanLienQuan);
        adapterFileVanBanLienQuan.notifyDataSetChanged();
    }

    void RecyclerViewKetQuaGiaiQuyet(ArrayList<KetquaGiaiQuyet> ketquaGiaiQuyets) {
        adapterKetQuaGiaiQuyet = new AdapterKetQuaGiaiQuyet(ketquaGiaiQuyets, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvKetQuaGiaiQuyet.setLayoutManager(layoutManager);
        rcvKetQuaGiaiQuyet.setAdapter(adapterKetQuaGiaiQuyet);
        adapterKetQuaGiaiQuyet.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(FileVanbanLienquan fileVanbanLienquan) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(fileVanbanLienquan.getDuongDan()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(KetquaGiaiQuyet ketquaGiaiQuyet) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ketquaGiaiQuyet.getDuongDan()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
