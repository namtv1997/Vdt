package com.vpdt.vpdt.ui.activity.XuLyGiayMoi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DetailVanBanPhoiHopTraLai;
import com.vpdt.vpdt.model.KetQuaGiaiQuyetPhongPP;
import com.vpdt.vpdt.model.TepTinDinhKemPPH;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetPhoiHopTraLai;
import com.vpdt.vpdt.presenter.TTVBSoLuongVanBanGiaoPhongPhoiHop1Presenter;
import com.vpdt.vpdt.presenter.TTVBSoLuongVanBanGiaoPhongPhoiHop1View;
import com.vpdt.vpdt.presenter.impl.TTVBSoLuongVanBanGiaoPhongPhoiHop1PresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaGiaiQuyetPhongPH;
import com.vpdt.vpdt.ui.adapter.AdapterTepTinDinhKemPhongPH;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetPhoiHopTraLai;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTVBGiayMoiPhoiHopChoXuLyActivity extends BaseActivity<TTVBSoLuongVanBanGiaoPhongPhoiHop1Presenter> implements TTVBSoLuongVanBanGiaoPhongPhoiHop1View,
        AdapterTepTinDinhKemPhongPH.OnItemClickListener, AdapterKetQuaGiaiQuyetPhongPH.OnItemketquaGiaiquyetClickListener {

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


    @BindView(R.id.lnThongTinVanBan)
    LinearLayout lnThongTinVanBan;
    @BindView(R.id.lnTrinhTuGiaiQuyet)
    LinearLayout lnTrinhTuGiaiQuyet;
    @BindView(R.id.lnTepDinhKem)
    LinearLayout lnTepDinhKem;
    @BindView(R.id.lnKetQuaGiaiQuyetPPH)
    LinearLayout lnKetQuaGiaiQuyetPPH;


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

    @BindView(R.id.edtKetQuaGiaiQuyet)
    EditText edtKetQuaGiaiQuyet;

    @BindView(R.id.rcvTTGQTTVB)
    RecyclerView rcvTinhTuGiaiQuyet;
    @BindView(R.id.rcvKetQuaGiaiQuyetPPH)
    RecyclerView rcvKetQuaGiaiQuyetPPH;
    @BindView(R.id.rcvTTDKTTVB)
    RecyclerView rcvTTDKTTVB;


    @BindView(R.id.cbVBQPPL)
    CheckBox cbVbQPPL;
    @BindView(R.id.cbSTCChuTri)
    CheckBox cbSTCChuTri;
    @BindView(R.id.cbTBKL)
    CheckBox cbTBKL;

    int id;

    AdapterTepTinDinhKemPhongPH adapterTepTinDinhKemPhongPH;
    AdapterKetQuaGiaiQuyetPhongPH adapterKetQuaGiaiQuyetPhongPH;
    AdapterTrinhTuGiaiQuyetPhoiHopTraLai adapterTrinhTuGiaiQuyetPhoiHopTraLai;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ttvbgiay_moi_phoi_hop_cho_xu_ly;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("idvb")) {
                id = intent.getIntExtra("idvb", 0);
                getPresenter().getDetailGMChuyenVienXuLy(id);
            }
        }
    }

    @OnClick({R.id.imvBack, R.id.tvThongTinGiayMoi,
            R.id.tvTrinhTuGiaiQuyet, R.id.tvTepDinhKem, R.id.btnCVDaHoanThanh, R.id.tvKetQuaGiaiQuyetPPH})
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
            case R.id.tvKetQuaGiaiQuyetPPH:
                Expand(lnKetQuaGiaiQuyetPPH, imUpKetQuaGiaiQuyetPPH, imDownKetQuaGiaiQuyetPPH);
                break;

            case R.id.btnCVDaHoanThanh:
                getPresenter().hoanThanhGMChuyenVienXuLy(id, edtKetQuaGiaiQuyet.getText().toString(), "");
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
        RecyclerViewTepTinDinhKem((ArrayList<TepTinDinhKemPPH>) detailVanBanPhoiHopTraLai.getTepTinDinhKems());
        RecyclerViewKetQuaGiaiQuyetPhongPH((ArrayList<KetQuaGiaiQuyetPhongPP>) detailVanBanPhoiHopTraLai.getketQuaGiaiQuyetPhongPHs());
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
        if (detailVanBanPhoiHopTraLai.getSTCCT() == 1) {
            cbSTCChuTri.setChecked(true);
        }
        if (detailVanBanPhoiHopTraLai.getTBKL() == 1) {

            cbTBKL.setChecked(true);
        }
        if (detailVanBanPhoiHopTraLai.getVBQPPL() == 1) {
            cbVbQPPL.setChecked(true);
        }
    }

    @Override
    public void hoanThanhGMChuyenVienXuLySuccess() {

    }

    @Override
    public void xoaKQPhongTLSuccess() {

    }

    void RecyclerViewTrinhTuGiaiQuyet(ArrayList<TrinhTuGiaiQuyetPhoiHopTraLai> trinhTuGiaiQuyets) {
        adapterTrinhTuGiaiQuyetPhoiHopTraLai = new AdapterTrinhTuGiaiQuyetPhoiHopTraLai(trinhTuGiaiQuyets);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTinhTuGiaiQuyet.setLayoutManager(layoutManager);
        rcvTinhTuGiaiQuyet.setAdapter(adapterTrinhTuGiaiQuyetPhoiHopTraLai);
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

    void RecyclerViewKetQuaGiaiQuyetPhongPH(ArrayList<KetQuaGiaiQuyetPhongPP> ketQuaGiaiQuyetPhongPPArrayList) {
        adapterKetQuaGiaiQuyetPhongPH = new AdapterKetQuaGiaiQuyetPhongPH(ketQuaGiaiQuyetPhongPPArrayList, this);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvKetQuaGiaiQuyetPPH.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvKetQuaGiaiQuyetPPH.setAdapter(adapterKetQuaGiaiQuyetPhongPH);
        adapterKetQuaGiaiQuyetPhongPH.notifyDataSetChanged();
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
}
