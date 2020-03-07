package com.vpdt.vpdt.ui.activity.XuLyGiayMoi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DetailGiayMoiPhongChuTriChoXuLy;
import com.vpdt.vpdt.model.KetQuaGiaiQuyetPhongTL;
import com.vpdt.vpdt.model.TepTinDinhKemPPH;
import com.vpdt.vpdt.model.TrinhTuChuyenNhanLuuVetChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetPhoiHopTraLai;
import com.vpdt.vpdt.model.TrinhTuHoanThanhCVLuuVet;
import com.vpdt.vpdt.presenter.TTVBGiayMoiPhongChuTriChoXuLyPresenter;
import com.vpdt.vpdt.presenter.TTVBGiayMoiPhongChuTriChoXuLyView;
import com.vpdt.vpdt.presenter.impl.TTVBGiayMoiPhongChuTriChoXuLyPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaGiaiQuyetPhongTL;
import com.vpdt.vpdt.ui.adapter.AdapterTepTinDinhKemPhongPH;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuChuyenNhanLuuVetPhongPheDuyet;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetPhoiHopTraLai;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuHoanThanhLuuVetChoPhongPheDuyet;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTVBGiayMoiPhongChuTriChoXuLyActivity extends BaseActivity<TTVBGiayMoiPhongChuTriChoXuLyPresenter> implements TTVBGiayMoiPhongChuTriChoXuLyView,
        AdapterTepTinDinhKemPhongPH.OnItemClickListener, AdapterKetQuaGiaiQuyetPhongTL.OnItemketquaGiaiquyetPhongThulyClickListener {

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

    @BindView(R.id.imDownTruyenNhanLuuViet)
    ImageView imDownTruyenNhanLuuViet;
    @BindView(R.id.imUpTruyenNhanLuuViet)
    ImageView imUpTruyenNhanLuuViet;


    @BindView(R.id.imDownKetQuaGiaiQuyetPThuLy)
    ImageView imDownKetQuaGiaiQuyetPThuLy;
    @BindView(R.id.imUpKetQuaGiaiQuyetPThuLy)
    ImageView imUpKetQuaGiaiQuyetPThuLy;

    @BindView(R.id.imDownTrinhTuHoanThanhCV)
    ImageView imDownTrinhTuHoanThanhCV;
    @BindView(R.id.imUpTrinhTuHoanThanhCV)
    ImageView imUpTrinhTuHoanThanhCV;


    @BindView(R.id.rcvTTGQTTVB)
    RecyclerView rcvTTGQTTVB;
    @BindView(R.id.rcvTTDKTTVB)
    RecyclerView rcvTTDKTTVB;
    @BindView(R.id.rcvTTTNLVTTVB)
    RecyclerView rcvTTTNLVTTVB;
    @BindView(R.id.rcvKetQuaGiaiQuyetPThuLy)
    RecyclerView rcvKetQuaGiaiQuyetPThuLy;
    @BindView(R.id.rcvTrinhTuHoanThanhCV)
    RecyclerView rcvTrinhTuHoanThanhCV;

    @BindView(R.id.lnThongTinVanBan)
    LinearLayout lnThongTinVanBan;
    @BindView(R.id.lnTrinhTuGiaiQuyet)
    LinearLayout lnTrinhTuGiaiQuyet;
    @BindView(R.id.lnTepDinhKem)
    LinearLayout lnTepDinhKem;
    @BindView(R.id.lnTruyenNhanLuuViet)
    LinearLayout lnTruyenNhanLuuViet;
    @BindView(R.id.lnKetQuaGiaiQuyetPThuLy)
    LinearLayout lnKetQuaGiaiQuyetPThuLy;
    @BindView(R.id.lnTrinhTuHoanThanhCV)
    LinearLayout lnTrinhTuHoanThanhCV;

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
    @BindView(R.id.edtKetQuaGiaiQuyet)
    TextView edtKetQuaGiaiQuyet;

    @BindView(R.id.btnCVDaHoanThanh)
    Button btnCVDaHoanThanh;

    @BindView(R.id.rlTrinhTuGiaiQuyet)
    RelativeLayout rlTrinhTuGiaiQuyet;
    @BindView(R.id.rlTepDinhKem)
    RelativeLayout rlTepDinhKem;
    @BindView(R.id.rlTrinhTuTruyenNhanLuuVet)
    RelativeLayout rlTrinhTuTruyenNhanLuuVet;
    @BindView(R.id.rlKetQuaGiaiQuyetPhongThuLy)
    RelativeLayout rlKetQuaGiaiQuyetPhongThuLy;
    @BindView(R.id.rlTrinhTuHoanThanhCongViec)
    RelativeLayout rlTrinhTuHoanThanhCongViec;

    AdapterTrinhTuGiaiQuyetPhoiHopTraLai adapterTrinhTuGiaiQuyetPhoiHopTraLai;
    AdapterTepTinDinhKemPhongPH adapterTepTinDinhKemPhongPH;
    AdapterTrinhTuChuyenNhanLuuVetPhongPheDuyet adapterTrinhTuChuyenNhanLuuVetPhongPheDuyet;
    AdapterKetQuaGiaiQuyetPhongTL adapterKetQuaGiaiQuyetPhongTL;
    AdapterTrinhTuHoanThanhLuuVetChoPhongPheDuyet adapterTrinhTuHoanThanhLuuVetChoPhongPheDuyet;
    int id;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ttvbgiay_moi_phong_chu_tri_cho_xu_ly;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("idvb")) {
                id = intent.getIntExtra("idvb", 0);
                getPresenter().getDetailGMChuyenVienChuTriXuLy(id);
            }
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDaTaSuccess(DetailGiayMoiPhongChuTriChoXuLy detailGiayMoiPhongChuTriChoXuLy) {
        RecyclerViewTrinhTuGiaiQuyetGiayMoi((ArrayList<TrinhTuGiaiQuyetPhoiHopTraLai>) detailGiayMoiPhongChuTriChoXuLy.getTrinhTuGiaiQuyets());
        RecyclerViewTrinhTuChuyenNhanLuuVet((ArrayList<TrinhTuChuyenNhanLuuVetChoLanhDaoPhongPheDuyet>) detailGiayMoiPhongChuTriChoXuLy.getTrinhTuChuyenNhanLuuVets());
        RecyclerViewTepTinDinhKem((ArrayList<TepTinDinhKemPPH>) detailGiayMoiPhongChuTriChoXuLy.getTepTinDinhKems());
        RecyclerViewKetQuaGiaiQuyetPhongThuLy((ArrayList<KetQuaGiaiQuyetPhongTL>) detailGiayMoiPhongChuTriChoXuLy.getKetQuaGiaiQuyetPhongTLs());
        RecyclerViewTrinhTuHoanThanhLuuVet((ArrayList<TrinhTuHoanThanhCVLuuVet>) detailGiayMoiPhongChuTriChoXuLy.getTrinhTuHoanThanhCVLuuVets());

        tvHopVaoHoi.setText(detailGiayMoiPhongChuTriChoXuLy.getGiayMoiGio() + " - " + detailGiayMoiPhongChuTriChoXuLy.getGiayMoiNgay());
        tvPhongGiamDoc.setText(String.valueOf(detailGiayMoiPhongChuTriChoXuLy.getGiayMoiDiaDiem()));
        tvNoiDung.setText(String.valueOf(detailGiayMoiPhongChuTriChoXuLy.getNoiDung()));
        tvSoDen.setText(String.valueOf(detailGiayMoiPhongChuTriChoXuLy.getSoDen()));
        tvKhuVuc.setText(String.valueOf(detailGiayMoiPhongChuTriChoXuLy.getKhuVuc()));
        tvSoKyHieu.setText(String.valueOf(detailGiayMoiPhongChuTriChoXuLy.getSoKyHieu()));
        tvLoaiVanBan.setText(String.valueOf(detailGiayMoiPhongChuTriChoXuLy.getLoaiVanBan()));
        tvTrichYeu.setText(String.valueOf(detailGiayMoiPhongChuTriChoXuLy.getMoTa()));
        tvNguoiKy.setText(String.valueOf(detailGiayMoiPhongChuTriChoXuLy.getTenNguoiKy()));
        tvNgayNhan.setText(String.valueOf(detailGiayMoiPhongChuTriChoXuLy.getNgayNhan()));
        tvSoTrang.setText(String.valueOf(detailGiayMoiPhongChuTriChoXuLy.getSoTrang()));
        tvDoMat.setText(String.valueOf(detailGiayMoiPhongChuTriChoXuLy.getDoMat()));
        tvNoiGuiDen.setText(String.valueOf(detailGiayMoiPhongChuTriChoXuLy.getNoiGuiDen()));
        tvNgayKy.setText(String.valueOf(detailGiayMoiPhongChuTriChoXuLy.getNgayKy()));
        tvChucVu.setText(String.valueOf(detailGiayMoiPhongChuTriChoXuLy.getChucVu()));
        tvHanGiaiQuyet.setText(String.valueOf(detailGiayMoiPhongChuTriChoXuLy.getHanGiaiQuyet()));
        tvDoKhan.setText(String.valueOf(detailGiayMoiPhongChuTriChoXuLy.getDoKhan()));
        if (detailGiayMoiPhongChuTriChoXuLy.getVBQPPL() == 1) {
            cbVBQPPL.setChecked(true);
        }
        if (detailGiayMoiPhongChuTriChoXuLy.getSTCCT() == 1) {
            cbSTCChuTri.setChecked(true);
        }
        if (detailGiayMoiPhongChuTriChoXuLy.getTBKL() == 1) {
            cbTBKL.setChecked(true);
        }
        if (detailGiayMoiPhongChuTriChoXuLy.getShowfromHoanThanh()) {
            btnCVDaHoanThanh.setVisibility(View.VISIBLE);
        }
        if (detailGiayMoiPhongChuTriChoXuLy.getTrinhTuGiaiQuyets().size() == 0) {
            rlTrinhTuGiaiQuyet.setVisibility(View.GONE);
            lnTrinhTuGiaiQuyet.setVisibility(View.GONE);
        }
        if (detailGiayMoiPhongChuTriChoXuLy.getTepTinDinhKems().size() == 0) {
            rlTepDinhKem.setVisibility(View.GONE);
            lnTepDinhKem.setVisibility(View.GONE);
        }
        if (detailGiayMoiPhongChuTriChoXuLy.getTrinhTuChuyenNhanLuuVets().size() == 0) {
            rlTrinhTuTruyenNhanLuuVet.setVisibility(View.GONE);
            lnTruyenNhanLuuViet.setVisibility(View.GONE);
        }
        if (detailGiayMoiPhongChuTriChoXuLy.getKetQuaGiaiQuyetPhongTLs().size() == 0) {
            rlKetQuaGiaiQuyetPhongThuLy.setVisibility(View.GONE);
            lnKetQuaGiaiQuyetPThuLy.setVisibility(View.GONE);
        }
        if (detailGiayMoiPhongChuTriChoXuLy.getTrinhTuHoanThanhCVLuuVets().size() == 0) {
            rlTrinhTuHoanThanhCongViec.setVisibility(View.GONE);
            lnTrinhTuHoanThanhCV.setVisibility(View.GONE);
        }
    }

    @Override
    public void hoanThanhGMChuyenVienChuTriXuLySuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void xoaKQPhongTLSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        getPresenter().getDetailGMChuyenVienChuTriXuLy(id);
    }

    @Override
    public TTVBGiayMoiPhongChuTriChoXuLyPresenter createPresenter() {
        return new TTVBGiayMoiPhongChuTriChoXuLyPresenterImpl(this);
    }


    @OnClick({R.id.imvBack, R.id.tvThongTinVanBan,
            R.id.tvTrinhTuGiaiQuyet, R.id.tvTepDinhKem,
            R.id.tvTruyenNhanLuuVet,
            R.id.tvKetQuaGiaiQuyetPThuLy, R.id.tvTrinhTuHoanThanhCV, R.id.btnSoanBaoCao, R.id.btnCVDaHoanThanh})
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
            case R.id.tvTruyenNhanLuuVet:
                Expand(lnTruyenNhanLuuViet, imUpTruyenNhanLuuViet, imDownTruyenNhanLuuViet);
                break;

            case R.id.tvKetQuaGiaiQuyetPThuLy:
                Expand(lnKetQuaGiaiQuyetPThuLy, imUpKetQuaGiaiQuyetPThuLy, imDownKetQuaGiaiQuyetPThuLy);
                break;

            case R.id.tvTrinhTuHoanThanhCV:
                Expand(lnTrinhTuHoanThanhCV, imUpTrinhTuHoanThanhCV, imDownTrinhTuHoanThanhCV);
                break;
            case R.id.btnSoanBaoCao:
//                Intent intent = new Intent(this, SoanBaoCaoActivity.class);
//                intent.putExtra("ID_GIAYMOI_CHO_LANHDAO_XULY", id);
//                startActivity(intent);
                Util.showMessenger("Chức năng đang hoàn thiện", this);
                break;
            case R.id.btnCVDaHoanThanh:
                getPresenter().hoanThanhGMChuyenVienChuTriXuLy(id, edtKetQuaGiaiQuyet.getText().toString(), "");
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

    void RecyclerViewTrinhTuGiaiQuyetGiayMoi(ArrayList<TrinhTuGiaiQuyetPhoiHopTraLai> trinhTuGiaiQuyets) {
        adapterTrinhTuGiaiQuyetPhoiHopTraLai = new AdapterTrinhTuGiaiQuyetPhoiHopTraLai(trinhTuGiaiQuyets);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTGQTTVB.setLayoutManager(layoutManager);
        rcvTTGQTTVB.setAdapter(adapterTrinhTuGiaiQuyetPhoiHopTraLai);
        adapterTrinhTuGiaiQuyetPhoiHopTraLai.notifyDataSetChanged();
    }

    void RecyclerViewTrinhTuChuyenNhanLuuVet(ArrayList<TrinhTuChuyenNhanLuuVetChoLanhDaoPhongPheDuyet> trinhTuChuyenNhanLuuVets) {
        adapterTrinhTuChuyenNhanLuuVetPhongPheDuyet = new AdapterTrinhTuChuyenNhanLuuVetPhongPheDuyet(trinhTuChuyenNhanLuuVets);
        LinearLayoutManager layoutManagerTrinhTuChuyenNhanLuuVet = new LinearLayoutManager(this);
        layoutManagerTrinhTuChuyenNhanLuuVet.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTTNLVTTVB.setLayoutManager(layoutManagerTrinhTuChuyenNhanLuuVet);
        rcvTTTNLVTTVB.setAdapter(adapterTrinhTuChuyenNhanLuuVetPhongPheDuyet);
        adapterTrinhTuChuyenNhanLuuVetPhongPheDuyet.notifyDataSetChanged();
    }


    void RecyclerViewTrinhTuHoanThanhLuuVet(ArrayList<TrinhTuHoanThanhCVLuuVet> trinhTuGiaiQuyetPhongPhoiHops) {
        adapterTrinhTuHoanThanhLuuVetChoPhongPheDuyet = new AdapterTrinhTuHoanThanhLuuVetChoPhongPheDuyet(trinhTuGiaiQuyetPhongPhoiHops);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTrinhTuHoanThanhCV.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvTrinhTuHoanThanhCV.setAdapter(adapterTrinhTuHoanThanhLuuVetChoPhongPheDuyet);
        adapterTrinhTuHoanThanhLuuVetChoPhongPheDuyet.notifyDataSetChanged();
    }

    void RecyclerViewKetQuaGiaiQuyetPhongThuLy(ArrayList<KetQuaGiaiQuyetPhongTL> ketquaGiaiquyetPhongThulies) {
        adapterKetQuaGiaiQuyetPhongTL = new AdapterKetQuaGiaiQuyetPhongTL(ketquaGiaiquyetPhongThulies, this);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvKetQuaGiaiQuyetPThuLy.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvKetQuaGiaiQuyetPThuLy.setAdapter(adapterKetQuaGiaiQuyetPhongTL);
        adapterKetQuaGiaiQuyetPhongTL.notifyDataSetChanged();
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
