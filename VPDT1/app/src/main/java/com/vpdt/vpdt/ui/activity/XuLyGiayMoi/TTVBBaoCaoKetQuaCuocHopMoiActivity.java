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
import com.vpdt.vpdt.model.DetailGiayMoi;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.KetquaGiaiquyetPhongPhoihop;
import com.vpdt.vpdt.model.KetquaGiaiquyetPhongThuly;
import com.vpdt.vpdt.model.TepDinhKem;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetGiayMoi;
import com.vpdt.vpdt.presenter.NDVBBaoCaoKetQuaCuocHopView;
import com.vpdt.vpdt.presenter.NDVBBaoCaoKetQuaCuocHop_Presenter;
import com.vpdt.vpdt.presenter.impl.NDVB_BaoCaoKetQuaCuocHopPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaGiaiQuyetPhongPhoiHopGiayMoi;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaGiaiQuyetPhongThuLy;
import com.vpdt.vpdt.ui.adapter.AdapterTepTinDinhKem;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetGiayMoi;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTVBBaoCaoKetQuaCuocHopMoiActivity extends BaseActivity<NDVBBaoCaoKetQuaCuocHop_Presenter> implements NDVBBaoCaoKetQuaCuocHopView,
        AdapterTepTinDinhKem.OnItemClickListener,
        AdapterKetQuaGiaiQuyetPhongPhoiHopGiayMoi.OnItemketquaGiaiquyetClickListener, AdapterKetQuaGiaiQuyetPhongThuLy.OnItemketquaGiaiquyetPhongThulyClickListener {

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

    @BindView(R.id.rcvTTGQTTVB)
    RecyclerView rcvTinhTuGiaiQuyet;
    @BindView(R.id.rcvTTDKTTVB)
    RecyclerView rcvTepDinhKem;
    @BindView(R.id.rcvKetQuaGiaiQuyetPPH)
    RecyclerView rcvKetQuaGiaiQuyetPPH;
    @BindView(R.id.rcvKetQuaGiaiQuyetPThuLy)
    RecyclerView rcvKetQuaGiaiQuyetPThuLy;

    @BindView(R.id.cbVBQPPL)
    CheckBox cbVbQPPL;
    @BindView(R.id.cbSTCChuTri)
    CheckBox cbSTCChuTri;
    @BindView(R.id.cbTBKL)
    CheckBox cbTBKL;

    private AdapterTepTinDinhKem adapterTepTinDinhKem;
    private AdapterTrinhTuGiaiQuyetGiayMoi adapterTrinhTuGiaiQuyetGiayMoi;
    private AdapterKetQuaGiaiQuyetPhongPhoiHopGiayMoi adapterKetQuaGiaiQuyetPhongPhoiHopGiayMoi;
    private AdapterKetQuaGiaiQuyetPhongThuLy adapterKetQuaGiaiQuyetPhongThuLy;

    int idvb;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ttvbbao_cao_ket_qua_cuoc_hop_moi;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("ID_VANBANBCKQCHMOI")) {
                idvb = intent.getIntExtra("ID_VANBANBCKQCHMOI", 0);
                getPresenter().getgiaymoibyid(idvb);

            }
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess(DetailGiayMoi detailGiayMoi) {
        RecyclerViewTrinhTuGiaiQuyetGiayMoi((ArrayList<TrinhTuGiaiQuyetGiayMoi>) detailGiayMoi.getTrinhTuGiaiQuyets());
        RecyclerViewTepTinDinhKem((ArrayList<TepDinhKem>) detailGiayMoi.getTepDinhKems());
        RecyclerViewKetQuaGiaiQuyetPhongPhoiHop((ArrayList<KetquaGiaiquyetPhongPhoihop>) detailGiayMoi.getKetquaGiaiquyetPhongPhoihops());
        RecyclerViewKetQuaGiaiQuyetPhongThuLy((ArrayList<KetquaGiaiquyetPhongThuly>) detailGiayMoi.getKetquaGiaiquyetPhongThulys());

        tvSoDen.setText(String.valueOf(detailGiayMoi.getSoDen()));
        tvKhuVuc.setText(String.valueOf(detailGiayMoi.getKhuVuc()));
        tvSoKyHieu.setText(String.valueOf(detailGiayMoi.getSoKyhieu()));
        tvLoaiVanBan.setText(String.valueOf(detailGiayMoi.getLoaiVanban()));
        tvTrichYeu.setText(String.valueOf(detailGiayMoi.getTrichYeu()));
        tvNguoiKy.setText(String.valueOf(detailGiayMoi.getNguoiKy()));
        tvNgayNhan.setText(String.valueOf(detailGiayMoi.getNgayNhan()));
        tvSoTrang.setText(String.valueOf(detailGiayMoi.getSoTrang()));
        tvDoMat.setText(String.valueOf(detailGiayMoi.getDoMat()));
        tvNoiGuiDen.setText(String.valueOf(detailGiayMoi.getNoiGuiDen()));
        tvNgayKy.setText(String.valueOf(detailGiayMoi.getNgayKy()));
        tvChucVu.setText(String.valueOf(detailGiayMoi.getChucVu()));
        tvHanGiaiQuyet.setText(String.valueOf(detailGiayMoi.getHanGiaiQuet()));
        tvDoKhan.setText(String.valueOf(detailGiayMoi.getDoMat2()));
//        tvThamMuu.setText(String.valueOf(detailGiayMoi.get()));
        tvLinhVuc.setText(String.valueOf(detailGiayMoi.getLinhVuc()));
//        tvNgayPhanLoai.setText(String.valueOf(detailGiayMoi.get()));
        tvNoiDung.setText(String.valueOf(detailGiayMoi.getNoiDung()));
//        tvNguoiChuTri.setText(String.valueOf(detailGiayMoi.get()));
        tvHopVaoHoi.setText(String.valueOf(detailGiayMoi.getGiayMoiGio() + " - " + detailGiayMoi.getGiayMoiNgay()));
        tvDiaDiem.setText(String.valueOf(detailGiayMoi.getGiayDiaDiem()));
        cbSTCChuTri.setChecked(detailGiayMoi.getIsStcChutri());
        cbTBKL.setChecked(detailGiayMoi.getIsTbkl());
        cbVbQPPL.setChecked(detailGiayMoi.getIsVbQppl());
    }

    @Override
    public void onGetNguoiKySuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {

    }

    @Override
    public void duyettuchoibaocaokequacuochopSuccess() {

    }

    @Override
    public void chuyenTiepKeQuaBaoCaoCuocHopSuccess() {

    }

    @Override
    public NDVBBaoCaoKetQuaCuocHop_Presenter createPresenter() {
        return new NDVB_BaoCaoKetQuaCuocHopPresenterImpl(this);
    }

    @Override
    public void onItemClick(TepDinhKem dinhKem) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dinhKem.getDuongDan()));
        startActivity(browserIntent);
    }

    @OnClick({R.id.imvBack, R.id.tvThongTinVanBan,
            R.id.tvTrinhTuGiaiQuyet, R.id.tvTepDinhKem,
            R.id.tvKetQuaGiaiQuyetPPH, R.id.tvKetQuaGiaiQuyetPThuLy})
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

    void RecyclerViewTrinhTuGiaiQuyetGiayMoi(ArrayList<TrinhTuGiaiQuyetGiayMoi> trinhTuGiaiQuyets) {
        adapterTrinhTuGiaiQuyetGiayMoi = new AdapterTrinhTuGiaiQuyetGiayMoi(this, trinhTuGiaiQuyets);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTinhTuGiaiQuyet.setLayoutManager(layoutManager);
        rcvTinhTuGiaiQuyet.setAdapter(adapterTrinhTuGiaiQuyetGiayMoi);
        adapterTrinhTuGiaiQuyetGiayMoi.notifyDataSetChanged();
    }

    void RecyclerViewKetQuaGiaiQuyetPhongThuLy(ArrayList<KetquaGiaiquyetPhongThuly> ketquaGiaiquyetPhongThulies) {
        adapterKetQuaGiaiQuyetPhongThuLy = new AdapterKetQuaGiaiQuyetPhongThuLy(this, ketquaGiaiquyetPhongThulies, this);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvKetQuaGiaiQuyetPThuLy.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvKetQuaGiaiQuyetPThuLy.setAdapter(adapterKetQuaGiaiQuyetPhongThuLy);
        adapterKetQuaGiaiQuyetPhongThuLy.notifyDataSetChanged();
    }

    void RecyclerViewKetQuaGiaiQuyetPhongPhoiHop(ArrayList<KetquaGiaiquyetPhongPhoihop> ketquaGiaiquyetPhongPhoihops) {
        adapterKetQuaGiaiQuyetPhongPhoiHopGiayMoi = new AdapterKetQuaGiaiQuyetPhongPhoiHopGiayMoi(this, ketquaGiaiquyetPhongPhoihops, this);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvKetQuaGiaiQuyetPPH.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvKetQuaGiaiQuyetPPH.setAdapter(adapterKetQuaGiaiQuyetPhongPhoiHopGiayMoi);
        adapterKetQuaGiaiQuyetPhongPhoiHopGiayMoi.notifyDataSetChanged();
    }

    void RecyclerViewTepTinDinhKem(ArrayList<TepDinhKem> tepDinhKems) {
        adapterTepTinDinhKem = new AdapterTepTinDinhKem(this, tepDinhKems, this);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTepDinhKem.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvTepDinhKem.setAdapter(adapterTepTinDinhKem);
        adapterTepTinDinhKem.notifyDataSetChanged();
    }

    @Override
    public void onItemketquaGiaiquyetClick(KetquaGiaiquyetPhongPhoihop ketquaGiaiquyetPhongPhoihop) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ketquaGiaiquyetPhongPhoihop.getTaiLieu()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemketquaGiaiquyetPhongThulyClick(KetquaGiaiquyetPhongThuly ketquaGiaiquyetPhongThuly) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ketquaGiaiquyetPhongThuly.getTaiLieu()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }
}