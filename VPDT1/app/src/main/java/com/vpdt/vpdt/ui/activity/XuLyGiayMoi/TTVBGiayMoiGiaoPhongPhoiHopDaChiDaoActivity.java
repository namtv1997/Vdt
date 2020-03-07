package com.vpdt.vpdt.ui.activity.XuLyGiayMoi;

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
import com.vpdt.vpdt.model.DetailVanBanPhoiHopTraLai;
import com.vpdt.vpdt.model.KetQuaGiaiQuyetPhongPP;
import com.vpdt.vpdt.model.KetQuaGiaiQuyetPhongTL;
import com.vpdt.vpdt.model.TepTinDinhKemPPH;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetPhoiHopTraLai;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetPhongPH;
import com.vpdt.vpdt.presenter.TTVBSoLuongVanBanGiaoPhongPhoiHop1Presenter;
import com.vpdt.vpdt.presenter.TTVBSoLuongVanBanGiaoPhongPhoiHop1View;
import com.vpdt.vpdt.presenter.impl.TTVBSoLuongVanBanGiaoPhongPhoiHop1PresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaGiaiQuyetPhongPH;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaGiaiQuyetPhongTL;
import com.vpdt.vpdt.ui.adapter.AdapterTepTinDinhKemPhongPH;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetPhoiHopTraLai;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetPhongPH;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTVBGiayMoiGiaoPhongPhoiHopDaChiDaoActivity extends BaseActivity<TTVBSoLuongVanBanGiaoPhongPhoiHop1Presenter> implements TTVBSoLuongVanBanGiaoPhongPhoiHop1View,
        AdapterTepTinDinhKemPhongPH.OnItemClickListener, AdapterKetQuaGiaiQuyetPhongPH.OnItemketquaGiaiquyetClickListener,
        AdapterKetQuaGiaiQuyetPhongTL.OnItemketquaGiaiquyetPhongThulyClickListener {

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

    @BindView(R.id.imDownKetQuaGiaiQuyetPPH)
    ImageView imDownKetQuaGiaiQuyetPPH;
    @BindView(R.id.imUpKetQuaGiaiQuyetPPH)
    ImageView imUpKetQuaGiaiQuyetPPH;

    @BindView(R.id.imDownTrinhTuGiaiQuyetPPH)
    ImageView imDownTrinhTuGiaiQuyetPPH;
    @BindView(R.id.imUpTrinhTuGiaiQuyetPPH)
    ImageView imUpTrinhTuGiaiQuyetPPH;

    @BindView(R.id.imDownKetQuaGiaiQuyetPThuLy)
    ImageView imDownKetQuaGiaiQuyetPThuLy;
    @BindView(R.id.imUpKetQuaGiaiQuyetPThuLy)
    ImageView imUpKetQuaGiaiQuyetPThuLy;

    @BindView(R.id.lnThongTinVanBan)
    LinearLayout lnThongTinVanBan;
    @BindView(R.id.lnTrinhTuGiaiQuyet)
    LinearLayout lnTrinhTuGiaiQuyet;
    @BindView(R.id.lnTepDinhKem)
    LinearLayout lnTepDinhKem;
    @BindView(R.id.lnKetQuaGiaiQuyetPPH)
    LinearLayout lnKetQuaGiaiQuyetPPH;
    @BindView(R.id.lnKetQuaGiaiQuyetPThuLy)
    LinearLayout lnKetQuaGiaiQuyetPThuLy;
    @BindView(R.id.lnTrinhTuGiaiQuyetPPH)
    LinearLayout lnTrinhTuGiaiQuyetPPH;

    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvKhuVuc)
    TextView tvKhuVuc;
    @BindView(R.id.tvSoKyHieu)
    TextView tvSoKyHieu;
    @BindView(R.id.tvLoaiVanBan)
    TextView tvLoaiVanBan;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvNguoiKy)
    TextView tvNguoiKy;
    @BindView(R.id.tvNgayNhan)
    TextView tvNgayNhan;
    @BindView(R.id.tvSoTrang)
    TextView tvSoTrang;
    @BindView(R.id.tvThamMuu)
    TextView tvThamMuu;
    @BindView(R.id.tvDoMat)
    TextView tvDoMat;
    @BindView(R.id.tvNoiGuiDen)
    TextView tvNoiGuiDen;
    @BindView(R.id.tvNgayKy)
    TextView tvNgayKy;
    @BindView(R.id.tvLinhVuc)
    TextView tvLinhVuc;
    @BindView(R.id.tvChucVu)
    TextView tvChucVu;
    @BindView(R.id.tvHanGiaiQuyet)
    TextView tvHanGiaiQuyet;
    @BindView(R.id.tvDoKhan)
    TextView tvDoKhan;
    @BindView(R.id.tvNgayPhanLoai)
    TextView tvNgayPhanLoai;
    @BindView(R.id.tvHopVaoHoi)
    TextView tvHopVaoHoi;
    @BindView(R.id.tvDiaDiem)
    TextView tvDiaDiem;
    @BindView(R.id.tvNguoiChuTri)
    TextView tvNguoiChuTri;
    @BindView(R.id.tvNoiDung)
    TextView tvNoiDung;

    @BindView(R.id.edtKetQuaGiaiQuyet)
    TextView edtKetQuaGiaiQuyet;

    @BindView(R.id.rcvTTGQTTVB)
    RecyclerView rcvTinhTuGiaiQuyet;

    @BindView(R.id.rcvKetQuaGiaiQuyetPPH)
    RecyclerView rcvKetQuaGiaiQuyetPPH;
    @BindView(R.id.rcvKetQuaGiaiQuyetPThuLy)
    RecyclerView rcvKetQuaGiaiQuyetPThuLy;
    @BindView(R.id.rcvTTDKTTVB)
    RecyclerView rcvTTDKTTVB;
    @BindView(R.id.rcvTrinhTuGiaiQuyetPPH)
    RecyclerView rcvTrinhTuGiaiQuyetPPH;

    @BindView(R.id.cbVBQPPL)
    CheckBox cbVbQPPL;
    @BindView(R.id.cbSTCChuTri)
    CheckBox cbSTCChuTri;
    @BindView(R.id.cbTBKL)
    CheckBox cbTBKL;

    @BindView(R.id.rlKetQuaGiaiQuyetPhongPhoiHop)
    RelativeLayout rlKetQuaGiaiQuyetPhongPhoiHop;
    @BindView(R.id.rlTrinhTuGiaiQuyet)
    RelativeLayout rlTrinhTuGiaiQuyet;
    @BindView(R.id.rlTepDinhKem)
    RelativeLayout rlTepDinhKem;
    @BindView(R.id.rlTrinhTuGiaiQuyetPhongPhoiHop)
    RelativeLayout rlTrinhTuGiaiQuyetPhongPhoiHop;
    @BindView(R.id.rlKetQuaGiaiQuyetPhongThuLy)
    RelativeLayout rlKetQuaGiaiQuyetPhongThuLy;

    int id;

    private AdapterTepTinDinhKemPhongPH adapterTepTinDinhKemPhongPH;
    private AdapterTrinhTuGiaiQuyetPhongPH adapterTrinhTuGiaiQuyetPhongPH;
    private AdapterKetQuaGiaiQuyetPhongPH adapterKetQuaGiaiQuyetPhongPH;
    private AdapterKetQuaGiaiQuyetPhongTL adapterKetQuaGiaiQuyetPhongTL;
    private AdapterTrinhTuGiaiQuyetPhoiHopTraLai adapterTrinhTuGiaiQuyetPhoiHopTraLai;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ttvbgiay_moi_giao_phong_phoi_hop_da_chi_dao;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("gmGiaoPhongPhoiHopDaChiDao")) {
                id = intent.getIntExtra("gmGiaoPhongPhoiHopDaChiDao", 0);
                getPresenter().getDetailGMChuyenVienXuLy(id);
            }

            if (intent.hasExtra("idvb")) {
                id = intent.getIntExtra("idvb", 0);
                getPresenter().getDetailGMChuyenVienXuLy(id);
                rlKetQuaGiaiQuyetPhongPhoiHop.setVisibility(View.GONE);
            }
        }
    }

    @OnClick({R.id.imvBack, R.id.tvThongTinVanBan,
            R.id.tvTrinhTuGiaiQuyet, R.id.tvTepDinhKem,
            R.id.tvKetQuaGiaiQuyetPThuLy, R.id.btnCVDaHoanThanh, R.id.tvTrinhTuGiaiQuyetPPH, R.id.tvKetQuaGiaiQuyetPPH})
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
            case R.id.tvKetQuaGiaiQuyetPPH:
                Expand(lnKetQuaGiaiQuyetPPH, imUpKetQuaGiaiQuyetPPH, imDownKetQuaGiaiQuyetPPH);
                break;
            case R.id.tvKetQuaGiaiQuyetPThuLy:
                Expand(lnKetQuaGiaiQuyetPThuLy, imUpKetQuaGiaiQuyetPThuLy, imDownKetQuaGiaiQuyetPThuLy);
                break;
            case R.id.btnCVDaHoanThanh:
                getPresenter().hoanThanhGMChuyenVienXuLy(id, edtKetQuaGiaiQuyet.getText().toString(), "");
                break;
            case R.id.tvTrinhTuGiaiQuyetPPH:
                Expand(lnTrinhTuGiaiQuyetPPH, imUpTrinhTuGiaiQuyetPPH, imDownTrinhTuGiaiQuyetPPH);
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
    public void onGetDaTaSuccess(DetailVanBanPhoiHopTraLai detailVanBanPhoiHopTraLai) {
        RecyclerViewTrinhTuGiaiQuyet((ArrayList<TrinhTuGiaiQuyetPhoiHopTraLai>) detailVanBanPhoiHopTraLai.getTrinhTuGiaiQuyets());
        RecyclerViewTrinhTuGiaiQuyettPhongPH((ArrayList<TrinhTuGiaiQuyetPhongPH>) detailVanBanPhoiHopTraLai.getTrinhTuGiaiQuyetPhongPHs());
        RecyclerViewTepTinDinhKem((ArrayList<TepTinDinhKemPPH>) detailVanBanPhoiHopTraLai.getTepTinDinhKems());
        RecyclerViewKetQuaGiaiQuyetPhongPH((ArrayList<KetQuaGiaiQuyetPhongPP>) detailVanBanPhoiHopTraLai.getketQuaGiaiQuyetPhongPHs());
        RecyclerViewKetQuaGiaiQuyetPhongThuLy((ArrayList<KetQuaGiaiQuyetPhongTL>) detailVanBanPhoiHopTraLai.getKetQuaGiaiQuyetPhongTLs());
        tvSoDen.setText(String.valueOf(detailVanBanPhoiHopTraLai.getSoDen()));
        tvKhuVuc.setText(String.valueOf(detailVanBanPhoiHopTraLai.getKhuVuc()));
        tvSoKyHieu.setText(String.valueOf(detailVanBanPhoiHopTraLai.getSoKyHieu()));
        tvLoaiVanBan.setText(String.valueOf(detailVanBanPhoiHopTraLai.getLoaiVanBan()));
        tvTrichYeu.setText(String.valueOf(detailVanBanPhoiHopTraLai.getMoTa()));
        tvNguoiKy.setText(String.valueOf(detailVanBanPhoiHopTraLai.getTenNguoiKy()));
        tvNgayNhan.setText(String.valueOf(detailVanBanPhoiHopTraLai.getNgayNhan()));
        tvSoTrang.setText(String.valueOf(detailVanBanPhoiHopTraLai.getSoTrang()));
        tvDoMat.setText(String.valueOf(detailVanBanPhoiHopTraLai.getDoMat()));
        tvNoiGuiDen.setText(String.valueOf(detailVanBanPhoiHopTraLai.getNoiGuiDen()));
        tvNgayKy.setText(String.valueOf(detailVanBanPhoiHopTraLai.getNgayKy()));
        tvChucVu.setText(String.valueOf(detailVanBanPhoiHopTraLai.getChucVu()));
        tvHanGiaiQuyet.setText(String.valueOf(detailVanBanPhoiHopTraLai.getHanGiaiQuyet()));
        tvDoKhan.setText(String.valueOf(detailVanBanPhoiHopTraLai.getDoKhan()));
        tvThamMuu.setText(String.valueOf(detailVanBanPhoiHopTraLai.getThamMuu()));
        tvLinhVuc.setText(String.valueOf(detailVanBanPhoiHopTraLai.getLinhVuc()));
        tvNgayPhanLoai.setText(String.valueOf(detailVanBanPhoiHopTraLai.getNgayPhanLoai()));
        tvDiaDiem.setText(String.valueOf(detailVanBanPhoiHopTraLai.getGiayMoiDiaDiem()));
        tvHopVaoHoi.setText(String.valueOf(detailVanBanPhoiHopTraLai.getGiayMoiGio() + " Ngày: " + detailVanBanPhoiHopTraLai.getGiayMoiNgay()));
//        tvNguoiChuTri.setText(String.valueOf(detailVanBanPhoiHopTraLai.get));
        tvNoiDung.setText(String.valueOf(detailVanBanPhoiHopTraLai.getNoiDung()));
        if (detailVanBanPhoiHopTraLai.getSTCCT() == 1) {
            cbSTCChuTri.setChecked(true);
        }
        if (detailVanBanPhoiHopTraLai.getTBKL() == 1) {

            cbTBKL.setChecked(true);
        }
        if (detailVanBanPhoiHopTraLai.getVBQPPL() == 1) {
            cbVbQPPL.setChecked(true);
        }
        if (detailVanBanPhoiHopTraLai.getTrinhTuGiaiQuyets().size() == 0) {
            rlTrinhTuGiaiQuyet.setVisibility(View.GONE);
            lnTrinhTuGiaiQuyet.setVisibility(View.GONE);
        }
        if (detailVanBanPhoiHopTraLai.getTepTinDinhKems().size() == 0) {
            rlTepDinhKem.setVisibility(View.GONE);
            lnTepDinhKem.setVisibility(View.GONE);
        }
        if (detailVanBanPhoiHopTraLai.getTrinhTuGiaiQuyetPhongPHs().size() == 0) {
            rlTrinhTuGiaiQuyetPhongPhoiHop.setVisibility(View.GONE);
            lnTrinhTuGiaiQuyetPPH.setVisibility(View.GONE);
        }
        if (detailVanBanPhoiHopTraLai.getKetQuaGiaiQuyetPhongTLs().size() == 0) {
            rlKetQuaGiaiQuyetPhongThuLy.setVisibility(View.GONE);
            lnKetQuaGiaiQuyetPThuLy.setVisibility(View.GONE);
        }
        if (detailVanBanPhoiHopTraLai.getketQuaGiaiQuyetPhongPHs().size() == 0) {
            rlKetQuaGiaiQuyetPhongPhoiHop.setVisibility(View.GONE);
            lnKetQuaGiaiQuyetPPH.setVisibility(View.GONE);
        }
    }

    @Override
    public void hoanThanhGMChuyenVienXuLySuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void xoaKQPhongTLSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        getPresenter().getDetailGMChuyenVienXuLy(id);
    }

    @Override
    public TTVBSoLuongVanBanGiaoPhongPhoiHop1Presenter createPresenter() {
        return new TTVBSoLuongVanBanGiaoPhongPhoiHop1PresenterImpl(this);
    }

    @Override
    public void onItemketquaGiaiquyetClick(KetQuaGiaiQuyetPhongPP ketquaGiaiquyetPhongPhoihop) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ketquaGiaiquyetPhongPhoihop.getUrlFile()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
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

    void RecyclerViewTrinhTuGiaiQuyet(ArrayList<TrinhTuGiaiQuyetPhoiHopTraLai> trinhTuGiaiQuyets) {
        adapterTrinhTuGiaiQuyetPhoiHopTraLai = new AdapterTrinhTuGiaiQuyetPhoiHopTraLai(trinhTuGiaiQuyets);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTinhTuGiaiQuyet.setLayoutManager(layoutManager);
        rcvTinhTuGiaiQuyet.setAdapter(adapterTrinhTuGiaiQuyetPhoiHopTraLai);
        adapterTrinhTuGiaiQuyetPhoiHopTraLai.notifyDataSetChanged();
    }

    void RecyclerViewTrinhTuGiaiQuyettPhongPH(ArrayList<TrinhTuGiaiQuyetPhongPH> trinhTuGiaiQuyets) {
        adapterTrinhTuGiaiQuyetPhongPH = new AdapterTrinhTuGiaiQuyetPhongPH(trinhTuGiaiQuyets);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTrinhTuGiaiQuyetPPH.setLayoutManager(layoutManager);
        rcvTrinhTuGiaiQuyetPPH.setAdapter(adapterTrinhTuGiaiQuyetPhongPH);
        adapterTrinhTuGiaiQuyetPhongPH.notifyDataSetChanged();
    }

    void RecyclerViewTepTinDinhKem(ArrayList<TepTinDinhKemPPH> tepDinhKems) {
        adapterTepTinDinhKemPhongPH = new AdapterTepTinDinhKemPhongPH(tepDinhKems, this);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTDKTTVB.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvTTDKTTVB.setAdapter(adapterTepTinDinhKemPhongPH);
        adapterTepTinDinhKemPhongPH.notifyDataSetChanged();
    }

    void RecyclerViewKetQuaGiaiQuyetPhongThuLy(ArrayList<KetQuaGiaiQuyetPhongTL> ketquaGiaiquyetPhongThulies) {
        adapterKetQuaGiaiQuyetPhongTL = new AdapterKetQuaGiaiQuyetPhongTL(ketquaGiaiquyetPhongThulies, this);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvKetQuaGiaiQuyetPThuLy.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvKetQuaGiaiQuyetPThuLy.setAdapter(adapterKetQuaGiaiQuyetPhongTL);
        adapterKetQuaGiaiQuyetPhongTL.notifyDataSetChanged();
    }

    void RecyclerViewKetQuaGiaiQuyetPhongPH(ArrayList<KetQuaGiaiQuyetPhongPP> ketQuaGiaiQuyetPhongPPArrayList) {
        adapterKetQuaGiaiQuyetPhongPH = new AdapterKetQuaGiaiQuyetPhongPH(ketQuaGiaiQuyetPhongPPArrayList, this);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvKetQuaGiaiQuyetPPH.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvKetQuaGiaiQuyetPPH.setAdapter(adapterKetQuaGiaiQuyetPhongPH);
        adapterKetQuaGiaiQuyetPhongPH.notifyDataSetChanged();
    }

    @Override
    public void onItemketquaGiaiquyetPhongThulyClick(KetQuaGiaiQuyetPhongTL ketquaGiaiquyetPhongThuly) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ketquaGiaiquyetPhongThuly.getUrlFile()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemTacVuClick(KetQuaGiaiQuyetPhongTL ketquaGiaiquyetPhongThuly) {
        getPresenter().xoaKQPhongTL(ketquaGiaiquyetPhongThuly.getId());
    }
}
