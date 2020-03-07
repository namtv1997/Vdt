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
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.KetGiaiQuyetPhongThuLy;
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.model.TepDinhKem;
import com.vpdt.vpdt.model.TrinhTuChuyenNhanLuuVet;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyet;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetPhongPhoiHop;
import com.vpdt.vpdt.model.VanBanDenChoXuLy;
import com.vpdt.vpdt.presenter.NDVBDSVBDenChoLDXLPresenter;
import com.vpdt.vpdt.presenter.NDVBDSVBDenChoLDXLView;
import com.vpdt.vpdt.presenter.impl.NDVBDSVBDenChoLDXLPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterFileDinhKemChoLanhDaoXuLy;
import com.vpdt.vpdt.ui.adapter.AdapterKetGiaiQuyetPhongThuLy;
import com.vpdt.vpdt.ui.adapter.AdapterTepTinDinhKem;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuChuyenNhanLuuVet;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyet;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetPhongPhoiHop;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChiTietBietDeDonDocActivity extends BaseActivity<NDVBDSVBDenChoLDXLPresenter> implements NDVBDSVBDenChoLDXLView,
        AdapterTepTinDinhKem.OnItemClickListener, AdapterFileDinhKemChoLanhDaoXuLy.OnItemClickListenerFileDinhKem,
        AdapterKetGiaiQuyetPhongThuLy.OnItemketquaGiaiquyetPhongThulyClickListener {


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

    @BindView(R.id.imDownKetQuaGiaiQuyetPThuLy)
    ImageView imDownKetQuaGiaiQuyetPThuLy;
    @BindView(R.id.imUpKetQuaGiaiQuyetPThuLy)
    ImageView imUpKetQuaGiaiQuyetPThuLy;


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
    @BindView(R.id.lnKetQuaGiaiQuyetPThuLy)
    LinearLayout lnKetQuaGiaiQuyetPThuLy;


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

    @BindView(R.id.rcvTTGQTTVBDSVBDenChoLDXL)
    RecyclerView rcvTTGQTTVBDSVBDenChoLDXL;
    @BindView(R.id.rcvTTDKTTVBDSVBDenChoLDXL)
    RecyclerView rcvTTDKTTVBDSVBDenChoLDXL;
    @BindView(R.id.rcvTTTNLVTTVBDSVBDenChoLDXL)
    RecyclerView rcvTTTNLVTTVBDSVBDenChoLDXL;
    @BindView(R.id.rcvTTGQPPHTTVBDSVBDenChoLDXL)
    RecyclerView rcvTTGQPPHTTVBDSVBDenChoLDXL;
    @BindView(R.id.rcvKetQuaGiaiQuyetPThuLy)
    RecyclerView rcvKetQuaGiaiQuyetPThuLy;

    @BindView(R.id.rvFileDinhKem)
    RecyclerView rvFileDinhKem;

    @BindView(R.id.cbVbQPPL)
    CheckBox cbVbQPPL;
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


    private AdapterTrinhTuGiaiQuyet adapterTrinhTuGiaiQuyet;
    private AdapterTrinhTuChuyenNhanLuuVet adapterTrinhTuChuyenNhanLuuVet;
    private AdapterTrinhTuGiaiQuyetPhongPhoiHop adapterTrinhTuGiaiQuyetPhongPhoiHop;
    private AdapterTepTinDinhKem adapterTepTinDinhKem;
    private AdapterFileDinhKemChoLanhDaoXuLy adapterFileDinhKemChoLanhDaoXuLy;
    AdapterKetGiaiQuyetPhongThuLy adapterKetQuaGiaiQuyetPhongThuLy;

    int idvbdenchoxuly;

    @Override
    public int getContentViewId() {
        return R.layout.activity_chitiet_biet_de_don_doc;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("ID_VANBAN_CHOLANHDAOXULY")) {
                idvbdenchoxuly = intent.getIntExtra("ID_VANBAN_CHOLANHDAOXULY", 0);
                getPresenter().getbyidvbdenchoxuly(idvbdenchoxuly);

            }
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess(VanBanDenChoXuLy dsvb_daChiDao) {
        RecyclerViewTrinhTuGiaiQuyet((ArrayList<TrinhTuGiaiQuyet>) dsvb_daChiDao.getTrinhTuGiaiQuyets());
        RecyclerViewTrinhTuChuyenNhanLuuVet((ArrayList<TrinhTuChuyenNhanLuuVet>) dsvb_daChiDao.getTrinhTuChuyenNhanLuuVets());
        RecyclerViewTrinhTuGiaiQuyetPhongPhoiHop((ArrayList<TrinhTuGiaiQuyetPhongPhoiHop>) dsvb_daChiDao.getTrinhTuGiaiQuyetPhongPhoiHops());
        RecyclerViewTepTinDinhKem((ArrayList<TepDinhKem>) dsvb_daChiDao.getTepDinhKems());
        RecyclerViewFileDinhKem((ArrayList<TepDinhKem>) dsvb_daChiDao.getTepDinhKems());
        RecyclerViewKetQuaGiaiQuyetPhongThuLy((ArrayList<KetGiaiQuyetPhongThuLy>) dsvb_daChiDao.getKetGiaiQuyetPhongThuLys());
        if (dsvb_daChiDao.getISTCChuTri() == 1) {
            cbSTCChuTri.setChecked(true);
        }
        if (dsvb_daChiDao.getIsVanBanQPPL() == 1) {
            cbVbQPPL.setChecked(true);
        }
        if (dsvb_daChiDao.getIsVanBanTBKL() == 1) {
            cbTBKL.setChecked(true);
        }
        tvSoDenTTVBTTVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getSoDen()));
        tvKhuVucTTVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getKhuVuc()));
        tvSoKyHieuTTVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getSoKyHieu()));
        tvLoaiVanBanTTVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getLoaiVanBan()));
        tvTrichYeuTTVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getTrichYeu()));
        tvNguoiKyTTVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getNguoiKy()));
        tvNgayNhanTTVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getNgayNhan()));
        tvSoTrangTTVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getSoTrang()));
        tvDoMatTTVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getDoMat()));
        tvNoiGuiDenTTVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getNoiGuiDen()));
        tvNgayKyTTVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getNgayKy()));
        tvChucVuTTVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getChucVu()));
        tvHanGiaiQuyetTTVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getHanGiaiQuyet()));
        tvDoKhanTTVBDSVBDenChoLDXL.setText(String.valueOf(dsvb_daChiDao.getDoKhan()));


    }


    @OnClick({R.id.btnBack, R.id.tvThongTinVanBanTTVBDSVBDenChoLDXL,
            R.id.tvTrinhTuGiaiQuyetTTVBDSVBDenChoLDXL, R.id.tvTepDinhKemTTVBDSVBDenChoLDXL,
            R.id.tvTruyenNhanLuuVietTTVBDSVBDenChoLDXL, R.id.tvTrinhTuGiaiQuyetPPHTTVBDSVBDenChoLDXL,
            R.id.btnCVDangThucHienTTVBDSVBDenChoLDXL, R.id.btnCVDaHoanThanhTTVBDSVBDenChoLDXL, R.id.tvKetQuaGiaiQuyetPThuLy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
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

            case R.id.btnCVDangThucHienTTVBDSVBDenChoLDXL:
                if (rdVBChiDeLuuTTVBDSVBDenChoLDXL.isChecked()) {
                    getPresenter().luuketqua(idvbdenchoxuly, tvKetQuaGiaiQuyetTTVBDSVBDenChoLDXL.getText().toString(), 1, "", 0);

                } else if (rdVBYeuCauTraLoiTTVBDSVBDenChoLDXL.isChecked()) {
                    getPresenter().luuketqua(idvbdenchoxuly, tvKetQuaGiaiQuyetTTVBDSVBDenChoLDXL.getText().toString(), 2, "", 0);
                }
                break;

            case R.id.btnCVDaHoanThanhTTVBDSVBDenChoLDXL:
                getPresenter().luuketqua(idvbdenchoxuly, tvKetQuaGiaiQuyetTTVBDSVBDenChoLDXL.getText().toString(), 0, "", 1);
                break;
            case R.id.tvKetQuaGiaiQuyetPThuLy:
                Expand(lnKetQuaGiaiQuyetPThuLy, imUpKetQuaGiaiQuyetPThuLy, imDownKetQuaGiaiQuyetPThuLy);
                break;

        }
    }

    @Override
    public void onGetCongViecSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onGetThemNoiDungSuccess() {

    }

    @Override
    public void onGetGiamdocVaPhoGiamdocSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {

    }

    @Override
    public void onGetPhongBanSuccess(ArrayList<PhongBan> phongBan) {

    }

    @Override
    public void onGetDuyetVanBandenchoxuly() {

    }

    @Override
    public void onchonDeLuuVanBanchoxuly() {

    }

    @Override
    public NDVBDSVBDenChoLDXLPresenter createPresenter() {
        return new NDVBDSVBDenChoLDXLPresenterImpl(this);
    }


    @Override
    public void onItemClick(TepDinhKem dinhKem) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dinhKem.getDuongDan()));
        startActivity(browserIntent);
//        Intent intent=new Intent(this, WebViewActivity.class);
//        intent.putExtra("LINK_TEPTIN",dinhKem.getDuongDan());
//        startActivity(intent);
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
        rcvTTGQTTVBDSVBDenChoLDXL.setLayoutManager(layoutManager);
        rcvTTGQTTVBDSVBDenChoLDXL.setAdapter(adapterTrinhTuGiaiQuyet);
        adapterTrinhTuGiaiQuyet.notifyDataSetChanged();
    }

    void RecyclerViewTrinhTuChuyenNhanLuuVet(ArrayList<TrinhTuChuyenNhanLuuVet> trinhTuChuyenNhanLuuVets) {
        adapterTrinhTuChuyenNhanLuuVet = new AdapterTrinhTuChuyenNhanLuuVet(this, trinhTuChuyenNhanLuuVets);
        LinearLayoutManager layoutManagerTrinhTuChuyenNhanLuuVet = new LinearLayoutManager(this);
        layoutManagerTrinhTuChuyenNhanLuuVet.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTTNLVTTVBDSVBDenChoLDXL.setLayoutManager(layoutManagerTrinhTuChuyenNhanLuuVet);
        rcvTTTNLVTTVBDSVBDenChoLDXL.setAdapter(adapterTrinhTuChuyenNhanLuuVet);
        adapterTrinhTuChuyenNhanLuuVet.notifyDataSetChanged();
    }

    void RecyclerViewTrinhTuGiaiQuyetPhongPhoiHop(ArrayList<TrinhTuGiaiQuyetPhongPhoiHop> trinhTuGiaiQuyetPhongPhoiHops) {
        adapterTrinhTuGiaiQuyetPhongPhoiHop = new AdapterTrinhTuGiaiQuyetPhongPhoiHop(this, trinhTuGiaiQuyetPhongPhoiHops);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTGQPPHTTVBDSVBDenChoLDXL.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvTTGQPPHTTVBDSVBDenChoLDXL.setAdapter(adapterTrinhTuGiaiQuyetPhongPhoiHop);
        adapterTrinhTuGiaiQuyetPhongPhoiHop.notifyDataSetChanged();
    }

    void RecyclerViewTepTinDinhKem(ArrayList<TepDinhKem> tepDinhKems) {
        adapterTepTinDinhKem = new AdapterTepTinDinhKem(this, tepDinhKems, this);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTDKTTVBDSVBDenChoLDXL.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvTTDKTTVBDSVBDenChoLDXL.setAdapter(adapterTepTinDinhKem);
        adapterTepTinDinhKem.notifyDataSetChanged();
    }

    void RecyclerViewFileDinhKem(ArrayList<TepDinhKem> tepDinhKems) {
        adapterFileDinhKemChoLanhDaoXuLy = new AdapterFileDinhKemChoLanhDaoXuLy(this, tepDinhKems, this);
        LinearLayoutManager layoutManagerFileDinhKem = new LinearLayoutManager(this);
        layoutManagerFileDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rvFileDinhKem.setLayoutManager(layoutManagerFileDinhKem);
        rvFileDinhKem.setAdapter(adapterFileDinhKemChoLanhDaoXuLy);
        adapterFileDinhKemChoLanhDaoXuLy.notifyDataSetChanged();
    }

    void RecyclerViewKetQuaGiaiQuyetPhongThuLy(ArrayList<KetGiaiQuyetPhongThuLy> ketquaGiaiquyetPhongThulies) {
        adapterKetQuaGiaiQuyetPhongThuLy = new AdapterKetGiaiQuyetPhongThuLy(ketquaGiaiquyetPhongThulies, this);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvKetQuaGiaiQuyetPThuLy.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvKetQuaGiaiQuyetPThuLy.setAdapter(adapterKetQuaGiaiQuyetPhongThuLy);
        adapterKetQuaGiaiQuyetPhongThuLy.notifyDataSetChanged();
    }

    @Override
    public void onItemClickFileDinhKem(TepDinhKem dinhKem) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dinhKem.getDuongDan()));
        startActivity(browserIntent);
    }

    @Override
    public void onItemketquaGiaiquyetPhongThulyClick(KetGiaiQuyetPhongThuLy ketquaGiaiquyetPhongThuly) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ketquaGiaiquyetPhongThuly.getDuongDanfile()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
