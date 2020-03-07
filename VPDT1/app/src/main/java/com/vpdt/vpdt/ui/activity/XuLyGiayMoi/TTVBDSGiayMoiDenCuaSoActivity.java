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
import com.vpdt.vpdt.model.KetquaGiaiquyetPhongPhoihop;
import com.vpdt.vpdt.model.KetquaGiaiquyetPhongThuly;
import com.vpdt.vpdt.model.TepDinhKem;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetGiayMoi;
import com.vpdt.vpdt.presenter.NDVBDanhSachGiayMoiDenCuaSoPresenter;
import com.vpdt.vpdt.presenter.NDVBDanhSachGiayMoiDenCuaSoView;
import com.vpdt.vpdt.presenter.impl.NDVBDanhSachGiayMoiDenCuaSoPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaGiaiQuyetPhongPhoiHopGiayMoi;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaGiaiQuyetPhongThuLy;
import com.vpdt.vpdt.ui.adapter.AdapterTepTinDinhKem;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetGiayMoi;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTVBDSGiayMoiDenCuaSoActivity extends BaseActivity<NDVBDanhSachGiayMoiDenCuaSoPresenter> implements NDVBDanhSachGiayMoiDenCuaSoView,
        AdapterTepTinDinhKem.OnItemClickListener,
        AdapterKetQuaGiaiQuyetPhongPhoiHopGiayMoi.OnItemketquaGiaiquyetClickListener, AdapterKetQuaGiaiQuyetPhongThuLy.OnItemketquaGiaiquyetPhongThulyClickListener {

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

    @BindView(R.id.imDownKetQuaGiaiQuyetPPH)
    ImageView imDownKetQuaGiaiQuyetPPH;
    @BindView(R.id.imUpKetQuaGiaiQuyetPPH)
    ImageView imUpKetQuaGiaiQuyetPPH;

    @BindView(R.id.imDownKetQuaGiaiQuyetPThuLy)
    ImageView imDownKetQuaGiaiQuyetPThuLy;
    @BindView(R.id.imUpKetQuaGiaiQuyetPThuLy)
    ImageView imUpKetQuaGiaiQuyetPThuLy;

    @BindView(R.id.rcvTTGQTTVB)
    RecyclerView rcvTTGQTTVB;
    @BindView(R.id.rcvTTDKTTVB)
    RecyclerView rcvTTDKTTVB;
    @BindView(R.id.rcvKetQuaGiaiQuyetPPH)
    RecyclerView rcvKetQuaGiaiQuyetPPH;
    @BindView(R.id.rcvKetQuaGiaiQuyetPThuLy)
    RecyclerView rcvKetQuaGiaiQuyetPThuLy;

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
    @BindView(R.id.tvNguoiChuTri)
    TextView tvNguoiChuTri;
    @BindView(R.id.tvLinhVuc)
    TextView tvLinhVuc;

    private AdapterTepTinDinhKem adapterTepTinDinhKem;
    private AdapterTrinhTuGiaiQuyetGiayMoi adapterTrinhTuGiaiQuyetGiayMoi;
    private AdapterKetQuaGiaiQuyetPhongPhoiHopGiayMoi adapterKetQuaGiaiQuyetPhongPhoiHopGiayMoi;
    private AdapterKetQuaGiaiQuyetPhongThuLy adapterKetQuaGiaiQuyetPhongThuLy;

    int id;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ttvbdsgiay_moi_den_cua_so;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("GiayMoiDenCuaSo")) {
                id = intent.getIntExtra("GiayMoiDenCuaSo", 0);
                getPresenter().getgiaymoibyid(id);
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
        RecyclerViewKetQuaGiaiQuyetPhongPhoiHop((ArrayList<KetquaGiaiquyetPhongPhoihop>) detailGiayMoi.getKetquaGiaiquyetPhongPhoihops());
        RecyclerViewTepTinDinhKem((ArrayList<TepDinhKem>) detailGiayMoi.getTepDinhKems());
        RecyclerViewKetQuaGiaiQuyetPhongThuLy((ArrayList<KetquaGiaiquyetPhongThuly>) detailGiayMoi.getKetquaGiaiquyetPhongThulys());

        tvHopVaoHoi.setText(detailGiayMoi.getGiayMoiGio() + " - " + detailGiayMoi.getGiayMoiNgay());
        tvPhongGiamDoc.setText(String.valueOf(detailGiayMoi.getGiayDiaDiem()));
        tvNoiDung.setText(String.valueOf(detailGiayMoi.getNoiDung()));
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
        tvNguoiChuTri.setText(String.valueOf(detailGiayMoi.getNguoiChuTri()));
        tvLinhVuc.setText(String.valueOf(detailGiayMoi.getLinhVuc()));

        if (detailGiayMoi.getIsVbQppl() == true) {
            cbVBQPPL.setChecked(true);
        }
        if (detailGiayMoi.getIsStcChutri() == true) {
            cbSTCChuTri.setChecked(true);
        }
        if (detailGiayMoi.getIsTbkl() == true) {
            cbTBKL.setChecked(true);
        }
    }


    @Override
    public NDVBDanhSachGiayMoiDenCuaSoPresenter createPresenter() {
        return new NDVBDanhSachGiayMoiDenCuaSoPresenterImpl(this);
    }

    @OnClick({R.id.imvBack, R.id.tvThongTinVanBan, R.id.tvKetQuaGiaiQuyetPThuLy,
            R.id.tvTrinhTuGiaiQuyet, R.id.tvTepDinhKem,
            R.id.tvKetQuaGiaiQuyetPPH})
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
    public void onItemClick(TepDinhKem dinhKem) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dinhKem.getDuongDan()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    void RecyclerViewTrinhTuGiaiQuyetGiayMoi(ArrayList<TrinhTuGiaiQuyetGiayMoi> trinhTuGiaiQuyets) {
        adapterTrinhTuGiaiQuyetGiayMoi = new AdapterTrinhTuGiaiQuyetGiayMoi(this, trinhTuGiaiQuyets);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTGQTTVB.setLayoutManager(layoutManager);
        rcvTTGQTTVB.setAdapter(adapterTrinhTuGiaiQuyetGiayMoi);
        adapterTrinhTuGiaiQuyetGiayMoi.notifyDataSetChanged();
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
        rcvTTDKTTVB.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvTTDKTTVB.setAdapter(adapterTepTinDinhKem);
        adapterTepTinDinhKem.notifyDataSetChanged();
    }

    void RecyclerViewKetQuaGiaiQuyetPhongThuLy(ArrayList<KetquaGiaiquyetPhongThuly> ketquaGiaiquyetPhongThulies) {
        adapterKetQuaGiaiQuyetPhongThuLy = new AdapterKetQuaGiaiQuyetPhongThuLy(this, ketquaGiaiquyetPhongThulies, this);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvKetQuaGiaiQuyetPThuLy.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvKetQuaGiaiQuyetPThuLy.setAdapter(adapterKetQuaGiaiQuyetPhongThuLy);
        adapterKetQuaGiaiQuyetPhongThuLy.notifyDataSetChanged();
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
