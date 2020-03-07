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
import com.vpdt.vpdt.model.TepDinhKem;
import com.vpdt.vpdt.model.TrinhTuChuyenNhanLuuVet;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyet;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetPhongPhoiHop;
import com.vpdt.vpdt.model.TrinhTuHoanThanhLuuVet;
import com.vpdt.vpdt.presenter.TTVBDSVBQuaHanPresenter;
import com.vpdt.vpdt.presenter.TTVBDSVBQuaHanView;
import com.vpdt.vpdt.presenter.impl.TTVBDSVBQuaHanPresenterImpl;
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

public class TTVBDSVBQuaHanActivity extends BaseActivity<TTVBDSVBQuaHanPresenter> implements TTVBDSVBQuaHanView, AdapterTepTinDinhKem.OnItemClickListener {

    @BindView(R.id.imDownTTVBTTVBDSVBQuaHan)
    ImageView imDownTTVBTTVBDSVBQuaHan;
    @BindView(R.id.imUpTTVBTTVBDSVBQuaHan)
    ImageView imUpTTVBTTVBDSVBQuaHan;

    @BindView(R.id.imDownTTGQTTVBDSVBQuaHan)
    ImageView imDownTTGQTTVBDSVBQuaHan;
    @BindView(R.id.imUpTTGQTTVBDSVBQuaHan)
    ImageView imUpTTGQTTVBDSVBQuaHan;

    @BindView(R.id.imDownTTDKTTVBDSVBQuaHan)
    ImageView imDownTTDKTTVBDSVBQuaHan;
    @BindView(R.id.imUpTTDKTTVBDSVBQuaHan)
    ImageView imUpTTDKTTVBDSVBQuaHan;

    @BindView(R.id.imDownTTTNLVTTVBDSVBQuaHan)
    ImageView imDownTTTNLVTTVBDSVBQuaHan;
    @BindView(R.id.imUpTTTNLVTTVBDSVBQuaHan)
    ImageView imUpTTTNLVTTVBDSVBQuaHan;

    @BindView(R.id.imDownTTGQPPHTTVBDSVBQuaHan)
    ImageView imDownTTGQPPHTTVBDSVBQuaHan;
    @BindView(R.id.imUpTTGQPPHTTVBDSVBQuaHan)
    ImageView imUpTTGQPPHTTVBDSVBQuaHan;

    @BindView(R.id.imDownTTHTCVLVTTVBDSVBQuaHan)
    ImageView imDownTTHTCVLVTTVBDSVBQuaHan;
    @BindView(R.id.imUpTTHTCVLVTTVBDSVBQuaHan)
    ImageView imUpTTHTCVLVTTVBDSVBQuaHan;

    @BindView(R.id.lnTTVBTTVBDSVBQuaHan)
    LinearLayout lnTTVBTTVBDSVBQuaHan;
    @BindView(R.id.lnTTGQTTVBDSVBQuaHan)
    LinearLayout lnTTGQTTVBDSVBQuaHan;
    @BindView(R.id.llTepDinhKem)
    LinearLayout llTepDinhKem;
    @BindView(R.id.lnTTTNLVTTVBDSVBQuaHan)
    LinearLayout lnTTTNLVTTVBDSVBQuaHan;
    @BindView(R.id.lnTrinhTuGiaiQuyetPPHTTVBDSVBQuaHan)
    LinearLayout lnTrinhTuGiaiQuyetPPHTTVBDSVBQuaHan;
    @BindView(R.id.lnTrinhTuHoanThanhCVTTVBDSVBQuaHan)
    LinearLayout lnTrinhTuHoanThanhCVTTVBDSVBQuaHan;

    @BindView(R.id.tvSoDenTTVBDSVBQuaHan)
    TextView tvSoDenTTVBDSVBQuaHan;
    @BindView(R.id.tvKhuVucTTVBDSVBQuaHan)
    TextView tvKhuVucTTVBDSVBQuaHan;
    @BindView(R.id.tvSoKyHieuTTVBDSVBQuaHan)
    TextView tvSoKyHieuTTVBDSVBQuaHan;
    @BindView(R.id.tvLoaiVanBanTTVBDSVBQuaHan)
    TextView tvLoaiVanBanTTVBDSVBQuaHan;
    @BindView(R.id.tvTrichYeuTTVBDSVBQuaHan)
    TextView tvTrichYeuTTVBDSVBQuaHan;
    @BindView(R.id.tvNguoiKyTTVBDSVBQuaHan)
    TextView tvNguoiKyTTVBDSVBQuaHan;
    @BindView(R.id.tvNgayNhanTTVBDSVBQuaHan)
    TextView tvNgayNhanTTVBDSVBQuaHan;
    @BindView(R.id.tvSoTrangTTVBDSVBQuaHan)
    TextView tvSoTrangTTVBDSVBQuaHan;
    @BindView(R.id.tvDoMatTTVBDSVBQuaHan)
    TextView tvDoMatTTVBDSVBQuaHan;
    @BindView(R.id.tvNoiGuiDenTTVBDSVBQuaHan)
    TextView tvNoiGuiDenTTVBDSVBQuaHan;
    @BindView(R.id.tvNgayKyTTVBDSVBQuaHan)
    TextView tvNgayKyTTVBDSVBQuaHan;
    @BindView(R.id.tvChucVuTTVBDSVBQuaHan)
    TextView tvChucVuTTVBDSVBQuaHan;
    @BindView(R.id.tvHanGiaiQuyetTTVBDSVBQuaHan)
    TextView tvHanGiaiQuyetTTVBDSVBQuaHan;
    @BindView(R.id.tvDoKhanTTVBDSVBQuaHan)
    TextView tvDoKhanTTVBDSVBQuaHan;
    @BindView(R.id.tvNgayPhanLoaiTTVBDSVBQuaHan)
    TextView tvNgayPhanLoaiTTVBDSVBQuaHan;

    @BindView(R.id.rcvTrinhTuGiaiQuyet)
    RecyclerView rcvTrinhTuGiaiQuyet;
    @BindView(R.id.rcvTrinhTuTruyenNhanLuuVet)
    RecyclerView rcvTrinhTuTruyenNhanLuuVet;
    @BindView(R.id.rcvTrinhTuGiaiQuyetPhongPhoiHop)
    RecyclerView rcvTrinhTuGiaiQuyetPhongPhoiHop;
    @BindView(R.id.rcvTepTinDinhKem)
    RecyclerView rcvTepTinDinhKem;
    @BindView(R.id.rcvTTHTCVLVTTVBDSVBQuaHan)
    RecyclerView rcvTTHTCVLVTTVBDSVBQuaHan;

    @BindView(R.id.cbVbQPPL)
    CheckBox cbVbQPPL;
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
    @BindView(R.id.rlTrinhTuTruyenNhanLuuVet)
    RelativeLayout rlTrinhTuTruyenNhanLuuVet;
    @BindView(R.id.rlTrinhTuGiaiQuyetPhongPhoiHop)
    RelativeLayout rlTrinhTuGiaiQuyetPhongPhoiHop;
    @BindView(R.id.rlTrinhTuHoanThanhCongViec)
    RelativeLayout rlTrinhTuHoanThanhCongViec;

    private AdapterTrinhTuGiaiQuyet adapterTrinhTuGiaiQuyet;
    private AdapterTrinhTuChuyenNhanLuuVet adapterTrinhTuChuyenNhanLuuVet;
    private AdapterTrinhTuGiaiQuyetPhongPhoiHop adapterTrinhTuGiaiQuyetPhongPhoiHop;
    private AdapterTepTinDinhKem adapterTepTinDinhKem;
    private AdapterTrinhTuHoanThanhLuuVet adapterTrinhTuHoanThanhLuuVet;

    int id;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ttvbdsvbqua_han;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("ID_VANBAN_QUAHAN")) {
                id = intent.getIntExtra("ID_VANBAN_QUAHAN", 0);
                getPresenter().getDetailbyidvbquahandolanhdaochidao(id);

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

        tvSoDenTTVBDSVBQuaHan.setText(String.valueOf(dsvbDaChiDao.getSoDen()));
        tvKhuVucTTVBDSVBQuaHan.setText(String.valueOf(dsvbDaChiDao.getKhuVuc()));
        tvSoKyHieuTTVBDSVBQuaHan.setText(String.valueOf(dsvbDaChiDao.getSoKyHieu()));
        tvLoaiVanBanTTVBDSVBQuaHan.setText(String.valueOf(dsvbDaChiDao.getLoaiVanBan()));
        tvTrichYeuTTVBDSVBQuaHan.setText(String.valueOf(dsvbDaChiDao.getTrichYeu()));
        tvNguoiKyTTVBDSVBQuaHan.setText(String.valueOf(dsvbDaChiDao.getNguoiKy()));
        tvNgayNhanTTVBDSVBQuaHan.setText(String.valueOf(dsvbDaChiDao.getNgayNhan()));
        tvSoTrangTTVBDSVBQuaHan.setText(String.valueOf(dsvbDaChiDao.getSoTrang()));
        tvDoMatTTVBDSVBQuaHan.setText(String.valueOf(dsvbDaChiDao.getDoMat()));
        tvNoiGuiDenTTVBDSVBQuaHan.setText(String.valueOf(dsvbDaChiDao.getNoiGuiDen()));
        tvNgayKyTTVBDSVBQuaHan.setText(String.valueOf(dsvbDaChiDao.getNgayKy()));
        tvChucVuTTVBDSVBQuaHan.setText(String.valueOf(dsvbDaChiDao.getChucVu()));
        tvHanGiaiQuyetTTVBDSVBQuaHan.setText(String.valueOf(dsvbDaChiDao.getHanGiaiQuyet()));
        tvDoKhanTTVBDSVBQuaHan.setText(String.valueOf(dsvbDaChiDao.getDoKhan()));
        tvNgayPhanLoaiTTVBDSVBQuaHan.setText(String.valueOf(dsvbDaChiDao.getNgayPhanLoai()));

        if (dsvbDaChiDao.getISTCChuTri() == 1) {
            cbSTCChuTri.setChecked(true);
        }
        if (dsvbDaChiDao.getIsVanBanQPPL() == 1) {
            cbVbQPPL.setChecked(true);
        }
        if (dsvbDaChiDao.getIsVanBanTBKL() == 1) {
            cbTBKL.setChecked(true);
        }
        if (dsvbDaChiDao.getIsToCongTac() == 1) {
            cbToCongTac.setChecked(true);
        }
        if (dsvbDaChiDao.getTrinhTuGiaiQuyets().size() == 0) {
            rlTrinhTuGiaiQuyet.setVisibility(View.GONE);
            lnTrinhTuGiaiQuyetPPHTTVBDSVBQuaHan.setVisibility(View.GONE);
        }
        if (dsvbDaChiDao.getTepDinhKems().size() == 0) {
            rlTepDinhKem.setVisibility(View.GONE);
            llTepDinhKem.setVisibility(View.GONE);
        }
        if (dsvbDaChiDao.getTrinhTuChuyenNhanLuuVets().size() == 0) {
            rlTrinhTuTruyenNhanLuuVet.setVisibility(View.GONE);
            lnTTTNLVTTVBDSVBQuaHan.setVisibility(View.GONE);
        }
        if (dsvbDaChiDao.getTrinhTuGiaiQuyetPhongPhoiHops().size() == 0) {
            rlTrinhTuGiaiQuyetPhongPhoiHop.setVisibility(View.GONE);
            lnTrinhTuGiaiQuyetPPHTTVBDSVBQuaHan.setVisibility(View.GONE);
        }
        if (dsvbDaChiDao.getTrinhTuHoanThanhLuuVets().size() == 0) {
            rlTrinhTuHoanThanhCongViec.setVisibility(View.GONE);
            lnTrinhTuHoanThanhCVTTVBDSVBQuaHan.setVisibility(View.GONE);
        }
    }

    @Override
    public TTVBDSVBQuaHanPresenter createPresenter() {
        return new TTVBDSVBQuaHanPresenterImpl(this);
    }

    @OnClick({R.id.btnBack, R.id.tvThongTinVanBanTTVBDSVBQuaHan,
            R.id.tvTrinhTuGiaiQuyetTTVBDSVBQuaHan, R.id.tvTepDinhKemTTVBDSVBQuaHan,
            R.id.tvTruyenNhanLuuVietTTVBDSVBQuaHan, R.id.tvTrinhTuGiaiQuyetPPHTTVBDSVBQuaHan,
            R.id.tvTrinhTuHoanThanhCVTTVBDSVBQuaHan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvThongTinVanBanTTVBDSVBQuaHan:
                Expand(lnTTVBTTVBDSVBQuaHan, imUpTTVBTTVBDSVBQuaHan, imDownTTVBTTVBDSVBQuaHan);
                break;
            case R.id.tvTrinhTuGiaiQuyetTTVBDSVBQuaHan:
                Expand(lnTTGQTTVBDSVBQuaHan, imUpTTGQTTVBDSVBQuaHan, imDownTTGQTTVBDSVBQuaHan);
                break;
            case R.id.tvTepDinhKemTTVBDSVBQuaHan:
                Expand(llTepDinhKem, imUpTTDKTTVBDSVBQuaHan, imDownTTDKTTVBDSVBQuaHan);
                break;
            case R.id.tvTruyenNhanLuuVietTTVBDSVBQuaHan:
                Expand(lnTTTNLVTTVBDSVBQuaHan, imUpTTTNLVTTVBDSVBQuaHan, imDownTTTNLVTTVBDSVBQuaHan);
                break;
            case R.id.tvTrinhTuGiaiQuyetPPHTTVBDSVBQuaHan:
                Expand(lnTrinhTuGiaiQuyetPPHTTVBDSVBQuaHan, imUpTTGQPPHTTVBDSVBQuaHan, imDownTTGQPPHTTVBDSVBQuaHan);
                break;
            case R.id.tvTrinhTuHoanThanhCVTTVBDSVBQuaHan:
                Expand(lnTrinhTuHoanThanhCVTTVBDSVBQuaHan, imUpTTHTCVLVTTVBDSVBQuaHan, imDownTTHTCVLVTTVBDSVBQuaHan);
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
    public void onItemClick(TepDinhKem dinhKem) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dinhKem.getDuongDan()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    void RecyclerViewTrinhTuGiaiQuyet(ArrayList<TrinhTuGiaiQuyet> trinhTuGiaiQuyets) {
        adapterTrinhTuGiaiQuyet = new AdapterTrinhTuGiaiQuyet(this, trinhTuGiaiQuyets);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTrinhTuGiaiQuyet.setLayoutManager(layoutManager);
        rcvTrinhTuGiaiQuyet.setAdapter(adapterTrinhTuGiaiQuyet);
        adapterTrinhTuGiaiQuyet.notifyDataSetChanged();
    }

    void RecyclerViewTrinhTuChuyenNhanLuuVet(ArrayList<TrinhTuChuyenNhanLuuVet> trinhTuChuyenNhanLuuVets) {
        adapterTrinhTuChuyenNhanLuuVet = new AdapterTrinhTuChuyenNhanLuuVet(this, trinhTuChuyenNhanLuuVets);
        LinearLayoutManager layoutManagerTrinhTuChuyenNhanLuuVet = new LinearLayoutManager(this);
        layoutManagerTrinhTuChuyenNhanLuuVet.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTrinhTuTruyenNhanLuuVet.setLayoutManager(layoutManagerTrinhTuChuyenNhanLuuVet);
        rcvTrinhTuTruyenNhanLuuVet.setAdapter(adapterTrinhTuChuyenNhanLuuVet);
        adapterTrinhTuChuyenNhanLuuVet.notifyDataSetChanged();
    }

    void RecyclerViewTrinhTuGiaiQuyetPhongPhoiHop(ArrayList<TrinhTuGiaiQuyetPhongPhoiHop> trinhTuGiaiQuyetPhongPhoiHops) {
        adapterTrinhTuGiaiQuyetPhongPhoiHop = new AdapterTrinhTuGiaiQuyetPhongPhoiHop(this, trinhTuGiaiQuyetPhongPhoiHops);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTrinhTuGiaiQuyetPhongPhoiHop.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvTrinhTuGiaiQuyetPhongPhoiHop.setAdapter(adapterTrinhTuGiaiQuyetPhongPhoiHop);
        adapterTrinhTuGiaiQuyetPhongPhoiHop.notifyDataSetChanged();
    }

    void RecyclerViewTepTinDinhKem(ArrayList<TepDinhKem> tepDinhKems) {
        adapterTepTinDinhKem = new AdapterTepTinDinhKem(this, tepDinhKems, this);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTepTinDinhKem.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvTepTinDinhKem.setAdapter(adapterTepTinDinhKem);
        adapterTepTinDinhKem.notifyDataSetChanged();
    }

    void RecyclerViewTrinhTuHoanThanhLuuVet(ArrayList<TrinhTuHoanThanhLuuVet> trinhTuHoanThanhLuuVets) {
        adapterTrinhTuHoanThanhLuuVet = new AdapterTrinhTuHoanThanhLuuVet(this, trinhTuHoanThanhLuuVets);
        LinearLayoutManager layoutManagerTrinhTuHoanThanhLuuVet = new LinearLayoutManager(this);
        layoutManagerTrinhTuHoanThanhLuuVet.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTHTCVLVTTVBDSVBQuaHan.setLayoutManager(layoutManagerTrinhTuHoanThanhLuuVet);
        rcvTTHTCVLVTTVBDSVBQuaHan.setAdapter(adapterTrinhTuHoanThanhLuuVet);
        adapterTrinhTuHoanThanhLuuVet.notifyDataSetChanged();
    }
}
