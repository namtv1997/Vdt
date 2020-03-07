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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.ChuyenNhanLuuVet;
import com.vpdt.vpdt.model.DetailGiayMoi;
import com.vpdt.vpdt.model.HoanThanhLuuVet;
import com.vpdt.vpdt.model.KetquaGiaiquyetPhongPhoihop;
import com.vpdt.vpdt.model.KetquaGiaiquyetPhongThuly;
import com.vpdt.vpdt.model.TepDinhKem;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetGiayMoi;
import com.vpdt.vpdt.presenter.TTVBGiayMoiChoLDXLPresenter;
import com.vpdt.vpdt.presenter.TTVBGiayMoiChoLDXLView;
import com.vpdt.vpdt.presenter.impl.TTVBGiayMoiChoLDXLPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterFileDinhKemChoLanhDaoXuLy;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaGiaiQuyetPhongPhoiHopGiayMoi;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaGiaiQuyetPhongThuLy;
import com.vpdt.vpdt.ui.adapter.AdapterTepTinDinhKem;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuChuyenNhanLuuVetGiayMoi;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetGiayMoi;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuHoanThanhLuuVetGiayMoi;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTVBGiayMoiChoLDXLActivity extends BaseActivity<TTVBGiayMoiChoLDXLPresenter> implements TTVBGiayMoiChoLDXLView,
        AdapterTepTinDinhKem.OnItemClickListener, AdapterFileDinhKemChoLanhDaoXuLy.OnItemClickListenerFileDinhKem,
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

    @BindView(R.id.imDownTruyenNhanLuuViet)
    ImageView imDownTruyenNhanLuuViet;
    @BindView(R.id.imUpTruyenNhanLuuViet)
    ImageView imUpTruyenNhanLuuViet;

    @BindView(R.id.imDownKetQuaGiaiQuyetPPH)
    ImageView imDownKetQuaGiaiQuyetPPH;
    @BindView(R.id.imUpKetQuaGiaiQuyetPPH)
    ImageView imUpKetQuaGiaiQuyetPPH;

    @BindView(R.id.imDownKetQuaGiaiQuyetPThuLy)
    ImageView imDownKetQuaGiaiQuyetPThuLy;
    @BindView(R.id.imUpKetQuaGiaiQuyetPThuLy)
    ImageView imUpKetQuaGiaiQuyetPThuLy;

    @BindView(R.id.imDownTrinhTuHoanThanhCV)
    ImageView imDownTrinhTuHoanThanhCV;
    @BindView(R.id.imUpTrinhTuHoanThanhCV)
    ImageView imUpTrinhTuHoanThanhCV;

    @BindView(R.id.tvKetQuaGiaiQuyet)
    EditText tvKetQuaGiaiQuyet;

    @BindView(R.id.rvFileDinhKem)
    RecyclerView rvFileDinhKem;
    @BindView(R.id.rcvTTGQTTVB)
    RecyclerView rcvTTGQTTVB;
    @BindView(R.id.rcvTTDKTTVB)
    RecyclerView rcvTTDKTTVB;
    @BindView(R.id.rcvTTTNLVTTVB)
    RecyclerView rcvTTTNLVTTVB;
    @BindView(R.id.rcvKetQuaGiaiQuyetPPH)
    RecyclerView rcvKetQuaGiaiQuyetPPH;
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
    @BindView(R.id.lnKetQuaGiaiQuyetPPH)
    LinearLayout lnKetQuaGiaiQuyetPPH;
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

    @BindView(R.id.rlTrinhTuGiaiQuyet)
    RelativeLayout rlTrinhTuGiaiQuyet;
    @BindView(R.id.rlTepDinhKem)
    RelativeLayout rlTepDinhKem;
    @BindView(R.id.rlTrinhTuTruyenNhanLuuVet)
    RelativeLayout rlTrinhTuTruyenNhanLuuVet;
    @BindView(R.id.rlKetQuaGiaiQuyetPhongPhoiHop)
    RelativeLayout rlKetQuaGiaiQuyetPhongPhoiHop;
    @BindView(R.id.rlTrinhTuHoanThanhCongViec)
    RelativeLayout rlTrinhTuHoanThanhCongViec;
    @BindView(R.id.rlKetQuaGiaiQuyetPhongThuLy)
    RelativeLayout rlKetQuaGiaiQuyetPhongThuLy;

    private AdapterTepTinDinhKem adapterTepTinDinhKem;
    private AdapterTrinhTuGiaiQuyetGiayMoi adapterTrinhTuGiaiQuyetGiayMoi;
    private AdapterTrinhTuChuyenNhanLuuVetGiayMoi adapterTrinhTuChuyenNhanLuuVet;
    private AdapterFileDinhKemChoLanhDaoXuLy adapterFileDinhKemChoLanhDaoXuLy;
    private AdapterKetQuaGiaiQuyetPhongPhoiHopGiayMoi adapterKetQuaGiaiQuyetPhongPhoiHopGiayMoi;
    private AdapterKetQuaGiaiQuyetPhongThuLy adapterKetQuaGiaiQuyetPhongThuLy;
    private AdapterTrinhTuHoanThanhLuuVetGiayMoi adapterTrinhTuHoanThanhLuuVet;
    int id;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ttvbgiay_moi_cho_ldxl;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("ID_GIAYMOI_CHO_LANHDAO_XULY")) {
                id = intent.getIntExtra("ID_GIAYMOI_CHO_LANHDAO_XULY", 0);
                getPresenter().getgiaymoicholanhdaoxulybyid(id);

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
        RecyclerViewTrinhTuChuyenNhanLuuVet((ArrayList<ChuyenNhanLuuVet>) detailGiayMoi.getChuyenNhanLuuVets());
        RecyclerViewTepTinDinhKem((ArrayList<TepDinhKem>) detailGiayMoi.getTepDinhKems());
        RecyclerViewFileDinhKem((ArrayList<TepDinhKem>) detailGiayMoi.getTepDinhKems());
        RecyclerViewKetQuaGiaiQuyetPhongPhoiHop((ArrayList<KetquaGiaiquyetPhongPhoihop>) detailGiayMoi.getKetquaGiaiquyetPhongPhoihops());
        RecyclerViewKetQuaGiaiQuyetPhongThuLy((ArrayList<KetquaGiaiquyetPhongThuly>) detailGiayMoi.getKetquaGiaiquyetPhongThulys());
        RecyclerViewTrinhTuHoanThanhLuuVet((ArrayList<HoanThanhLuuVet>) detailGiayMoi.getHoanThanhLuuVets());

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
        if (detailGiayMoi.getIsVbQppl() == true) {
            cbVBQPPL.setChecked(true);
        }
        if (detailGiayMoi.getIsStcChutri() == true) {
            cbSTCChuTri.setChecked(true);
        }
        if (detailGiayMoi.getIsTbkl() == true) {
            cbTBKL.setChecked(true);
        }
        if (detailGiayMoi.getTrinhTuGiaiQuyets().size() == 0) {
            rlTrinhTuGiaiQuyet.setVisibility(View.GONE);
            lnTrinhTuGiaiQuyet.setVisibility(View.GONE);
        }
        if (detailGiayMoi.getTepDinhKems().size() == 0) {
            rlTepDinhKem.setVisibility(View.GONE);
            lnTepDinhKem.setVisibility(View.GONE);
        }
        if (detailGiayMoi.getChuyenNhanLuuVets().size() == 0) {
            rlTrinhTuTruyenNhanLuuVet.setVisibility(View.GONE);
            lnTruyenNhanLuuViet.setVisibility(View.GONE);
        }
        if (detailGiayMoi.getKetquaGiaiquyetPhongThulys().size() == 0) {
            rlKetQuaGiaiQuyetPhongThuLy.setVisibility(View.GONE);
            lnKetQuaGiaiQuyetPThuLy.setVisibility(View.GONE);
        }
        if (detailGiayMoi.getKetquaGiaiquyetPhongPhoihops().size() == 0) {
            rlKetQuaGiaiQuyetPhongPhoiHop.setVisibility(View.GONE);
            lnKetQuaGiaiQuyetPPH.setVisibility(View.GONE);
        }
        if (detailGiayMoi.getHoanThanhLuuVets().size() == 0) {
            rlTrinhTuHoanThanhCongViec.setVisibility(View.GONE);
            lnTrinhTuHoanThanhCV.setVisibility(View.GONE);
        }
    }

    @Override
    public TTVBGiayMoiChoLDXLPresenter createPresenter() {
        return new TTVBGiayMoiChoLDXLPresenterImpl(this);
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

    @OnClick({R.id.imvBack, R.id.tvThongTinVanBan,
            R.id.tvTrinhTuGiaiQuyet, R.id.tvTepDinhKem,
            R.id.tvTruyenNhanLuuVet, R.id.tvKetQuaGiaiQuyetPPH,
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
            case R.id.tvKetQuaGiaiQuyetPPH:
                Expand(lnKetQuaGiaiQuyetPPH, imUpKetQuaGiaiQuyetPPH, imDownKetQuaGiaiQuyetPPH);
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
        rcvTTGQTTVB.setLayoutManager(layoutManager);
        rcvTTGQTTVB.setAdapter(adapterTrinhTuGiaiQuyetGiayMoi);
        adapterTrinhTuGiaiQuyetGiayMoi.notifyDataSetChanged();
    }

    void RecyclerViewTrinhTuChuyenNhanLuuVet(ArrayList<ChuyenNhanLuuVet> trinhTuChuyenNhanLuuVets) {
        adapterTrinhTuChuyenNhanLuuVet = new AdapterTrinhTuChuyenNhanLuuVetGiayMoi(this, trinhTuChuyenNhanLuuVets);
        LinearLayoutManager layoutManagerTrinhTuChuyenNhanLuuVet = new LinearLayoutManager(this);
        layoutManagerTrinhTuChuyenNhanLuuVet.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTTNLVTTVB.setLayoutManager(layoutManagerTrinhTuChuyenNhanLuuVet);
        rcvTTTNLVTTVB.setAdapter(adapterTrinhTuChuyenNhanLuuVet);
        adapterTrinhTuChuyenNhanLuuVet.notifyDataSetChanged();
    }

    void RecyclerViewFileDinhKem(ArrayList<TepDinhKem> tepDinhKems) {
        adapterFileDinhKemChoLanhDaoXuLy = new AdapterFileDinhKemChoLanhDaoXuLy(this, tepDinhKems, this);
        LinearLayoutManager layoutManagerFileDinhKem = new LinearLayoutManager(this);
        layoutManagerFileDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rvFileDinhKem.setLayoutManager(layoutManagerFileDinhKem);
        rvFileDinhKem.setAdapter(adapterFileDinhKemChoLanhDaoXuLy);
        adapterFileDinhKemChoLanhDaoXuLy.notifyDataSetChanged();
    }

    void RecyclerViewTrinhTuHoanThanhLuuVet(ArrayList<HoanThanhLuuVet> trinhTuGiaiQuyetPhongPhoiHops) {
        adapterTrinhTuHoanThanhLuuVet = new AdapterTrinhTuHoanThanhLuuVetGiayMoi(this, trinhTuGiaiQuyetPhongPhoiHops);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTrinhTuHoanThanhCV.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvTrinhTuHoanThanhCV.setAdapter(adapterTrinhTuHoanThanhLuuVet);
        adapterTrinhTuHoanThanhLuuVet.notifyDataSetChanged();
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
        rcvTTDKTTVB.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvTTDKTTVB.setAdapter(adapterTepTinDinhKem);
        adapterTepTinDinhKem.notifyDataSetChanged();
    }

    @Override
    public void onItemClickFileDinhKem(TepDinhKem dinhKem) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dinhKem.getDuongDan()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
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
    public void onItemketquaGiaiquyetPhongThulyClick(KetquaGiaiquyetPhongThuly ketquaGiaiquyetPhongThuly) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ketquaGiaiquyetPhongThuly.getTaiLieu()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
