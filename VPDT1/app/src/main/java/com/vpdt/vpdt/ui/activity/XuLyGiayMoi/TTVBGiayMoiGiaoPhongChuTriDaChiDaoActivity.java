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
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DeatailVanBanSoLuongVanBanPhongChuTri;
import com.vpdt.vpdt.model.TepTinDinhKemPPH;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetPhoiHopTraLai;
import com.vpdt.vpdt.presenter.TTVBSoLuongVanBanGiaoPhongChuTriPresenter;
import com.vpdt.vpdt.presenter.TTVBSoLuongVanBanGiaoPhongChuTriView;
import com.vpdt.vpdt.presenter.impl.TTVBSoLuongVanBanGiaoPhongChuTriPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterTepTinDinhKemPhongPH;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetPhoiHopTraLai;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTVBGiayMoiGiaoPhongChuTriDaChiDaoActivity extends BaseActivity<TTVBSoLuongVanBanGiaoPhongChuTriPresenter> implements TTVBSoLuongVanBanGiaoPhongChuTriView,
        AdapterTepTinDinhKemPhongPH.OnItemClickListener {

    @BindView(R.id.cbVBQPPL)
    CheckBox cbVBQPPL;
    @BindView(R.id.cbSTCChuTri)
    CheckBox cbSTCChuTri;
    @BindView(R.id.cbTBKL)
    CheckBox cbTBKL;

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


    @BindView(R.id.rcvTTGQTTVB)
    RecyclerView rcvTTGQTTVB;
    @BindView(R.id.rcvTTDKTTVB)
    RecyclerView rcvTTDKTTVB;

    @BindView(R.id.lnThongTinVanBan)
    LinearLayout lnThongTinVanBan;
    @BindView(R.id.lnTrinhTuGiaiQuyet)
    LinearLayout lnTrinhTuGiaiQuyet;
    @BindView(R.id.lnTepDinhKem)
    LinearLayout lnTepDinhKem;

    @BindView(R.id.tvHopVaoHoi)
    TextView tvHopVaoHoi;
    @BindView(R.id.tvPhongGiamDoc)
    TextView tvPhongGiamDoc;
    @BindView(R.id.tvNoiDung)
    TextView tvNoiDung;
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

    AdapterTepTinDinhKemPhongPH adapterTepTinDinhKemPhongPH;
    AdapterTrinhTuGiaiQuyetPhoiHopTraLai adapterTrinhTuGiaiQuyetPhoiHopTraLai;
    int id;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ttvbgiay_moi_giao_phong_chu_tri_da_chi_dao;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("idvb")) {
                id = intent.getIntExtra("idvb", 0);
                getPresenter().getDetailGMQuyTrinhGiayMoi(id);
            }
        }
    }

    @OnClick({R.id.imvBack, R.id.tvThongTinGiayMoi,
            R.id.tvTrinhTuGiaiQuyet, R.id.tvTepDinhKem})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imvBack:
                finish();
                break;
            case R.id.tvThongTinGiayMoi:
                Expand(lnThongTinVanBan, imUpThongTinVanBan, imDownThongTinVanBan);
                break;
            case R.id.tvTrinhTuGiaiQuyet:
                Expand(lnTrinhTuGiaiQuyet, imUpTrinhTuGiaiQuyet, imDownTrinhTuGiaiQuyet);
                break;

            case R.id.tvTepDinhKem:
                Expand(lnTepDinhKem, imUpTepDinhKem, imDownTepDinhKem);
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
    public void onGetDaTaSuccess(DeatailVanBanSoLuongVanBanPhongChuTri deatailVanBanSoLuongVanBanPhongChuTri) {
        RecyclerViewTrinhTuGiaiQuyetGiayMoi((ArrayList<TrinhTuGiaiQuyetPhoiHopTraLai>) deatailVanBanSoLuongVanBanPhongChuTri.getTrinhTuGiaiQuyets());
        RecyclerViewTepTinDinhKem((ArrayList<TepTinDinhKemPPH>) deatailVanBanSoLuongVanBanPhongChuTri.getTepTinDinhKems());

        tvHopVaoHoi.setText(deatailVanBanSoLuongVanBanPhongChuTri.getGiayMoiGio() + " - " + deatailVanBanSoLuongVanBanPhongChuTri.getGiayMoiNgay());
        tvPhongGiamDoc.setText(String.valueOf(deatailVanBanSoLuongVanBanPhongChuTri.getGiayMoiDiaDiem()));
        tvNoiDung.setText(String.valueOf(deatailVanBanSoLuongVanBanPhongChuTri.getNoiDung()));
        tvSoDen.setText(String.valueOf(deatailVanBanSoLuongVanBanPhongChuTri.getSoDen()));
        tvKhuVuc.setText(String.valueOf(deatailVanBanSoLuongVanBanPhongChuTri.getKhuVuc()));
        tvSoKyHieu.setText(String.valueOf(deatailVanBanSoLuongVanBanPhongChuTri.getSoKyHieu()));
        tvLoaiVanBan.setText(String.valueOf(deatailVanBanSoLuongVanBanPhongChuTri.getLoaiVanBan()));
        tvTrichYeu.setText(String.valueOf(deatailVanBanSoLuongVanBanPhongChuTri.getMoTa()));
        tvNguoiKy.setText(String.valueOf(deatailVanBanSoLuongVanBanPhongChuTri.getTenNguoiKy()));
        tvNgayNhan.setText(String.valueOf(deatailVanBanSoLuongVanBanPhongChuTri.getNgayNhan()));
        tvSoTrang.setText(String.valueOf(deatailVanBanSoLuongVanBanPhongChuTri.getSoTrang()));
        tvDoMat.setText(String.valueOf(deatailVanBanSoLuongVanBanPhongChuTri.getDoMat()));
        tvNoiGuiDen.setText(String.valueOf(deatailVanBanSoLuongVanBanPhongChuTri.getNoiGuiDen()));
        tvNgayKy.setText(String.valueOf(deatailVanBanSoLuongVanBanPhongChuTri.getNgayKy()));
        tvChucVu.setText(String.valueOf(deatailVanBanSoLuongVanBanPhongChuTri.getChucVu()));
        tvHanGiaiQuyet.setText(String.valueOf(deatailVanBanSoLuongVanBanPhongChuTri.getHanGiaiQuyet()));
        tvDoKhan.setText(String.valueOf(deatailVanBanSoLuongVanBanPhongChuTri.getDoKhan()));
        if (deatailVanBanSoLuongVanBanPhongChuTri.getVBQPPL() == 1) {
            cbVBQPPL.setChecked(true);
        }
        if (deatailVanBanSoLuongVanBanPhongChuTri.getSTCCT() == 1) {
            cbSTCChuTri.setChecked(true);
        }
        if (deatailVanBanSoLuongVanBanPhongChuTri.getTBKL() == 1) {
            cbTBKL.setChecked(true);
        }
    }

    @Override
    public void xoaKQPhongTLSuccess() {

    }

    @Override
    public TTVBSoLuongVanBanGiaoPhongChuTriPresenter createPresenter() {
        return new TTVBSoLuongVanBanGiaoPhongChuTriPresenterImpl(this);
    }


    void RecyclerViewTrinhTuGiaiQuyetGiayMoi(ArrayList<TrinhTuGiaiQuyetPhoiHopTraLai> trinhTuGiaiQuyets) {
        adapterTrinhTuGiaiQuyetPhoiHopTraLai = new AdapterTrinhTuGiaiQuyetPhoiHopTraLai(trinhTuGiaiQuyets);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTGQTTVB.setLayoutManager(layoutManager);
        rcvTTGQTTVB.setAdapter(adapterTrinhTuGiaiQuyetPhoiHopTraLai);
        adapterTrinhTuGiaiQuyetPhoiHopTraLai.notifyDataSetChanged();
    }

    void RecyclerViewTepTinDinhKem(ArrayList<TepTinDinhKemPPH> tepDinhKems) {
        adapterTepTinDinhKemPhongPH = new AdapterTepTinDinhKemPhongPH(tepDinhKems, this);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTDKTTVB.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvTTDKTTVB.setAdapter(adapterTepTinDinhKemPhongPH);
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
}
