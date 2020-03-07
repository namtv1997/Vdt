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
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DetailVbphongPhoiHopChoXuLy;
import com.vpdt.vpdt.model.KetQuaGiaiQuyetPhongPP;
import com.vpdt.vpdt.model.KetQuaGiaiQuyetPhongTL;
import com.vpdt.vpdt.model.TepTinDinhKemPPH;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetPhongPH;
import com.vpdt.vpdt.presenter.TTVB_VBGiaoPhongPhoiHopXuLyPresenter;
import com.vpdt.vpdt.presenter.TTVB_VBGiaoPhongPhoiHopXuLyView;
import com.vpdt.vpdt.presenter.impl.TTVB_VBGiaoPhongPhoiHopXuLyPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaGiaiQuyetPhongPH;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaGiaiQuyetPhongTL;
import com.vpdt.vpdt.ui.adapter.AdapterTepTinDinhKemPhongPH;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetPhongPH;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTVB_VBGiaoPhongPhoiHopXuLyActivity extends BaseActivity<TTVB_VBGiaoPhongPhoiHopXuLyPresenter> implements
        TTVB_VBGiaoPhongPhoiHopXuLyView, AdapterTepTinDinhKemPhongPH.OnItemClickListener, AdapterKetQuaGiaiQuyetPhongPH.OnItemketquaGiaiquyetClickListener,
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

    @BindView(R.id.edtKetQuaGiaiQuyet)
    TextView edtKetQuaGiaiQuyet;

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

    int id;


    private AdapterTepTinDinhKemPhongPH adapterTepTinDinhKemPhongPH;
    private AdapterTrinhTuGiaiQuyetPhongPH adapterTrinhTuGiaiQuyetPhongPH;
    private AdapterKetQuaGiaiQuyetPhongPH adapterKetQuaGiaiQuyetPhongPH;
    private AdapterKetQuaGiaiQuyetPhongTL adapterKetQuaGiaiQuyetPhongTL;


    @Override
    public int getContentViewId() {
        return R.layout.activity_ttvb_vbgiao_phong_phoi_hop_xu_ly;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            intent.hasExtra("idVbPhongPhoiHop");
            id = intent.getIntExtra("idVbPhongPhoiHop", 0);
            getPresenter().getVBPhongPhoiHopChoXuLyById(id);
        }

    }

    @OnClick({R.id.imvBack, R.id.tvThongTinVanBan,
            R.id.tvTrinhTuGiaiQuyet, R.id.tvTepDinhKem,
            R.id.tvKetQuaGiaiQuyetPThuLy, R.id.btnCVDaHoanThanh})
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
                getPresenter().hoanThanhVBPhongPhoiHopChoXuLy(id, edtKetQuaGiaiQuyet.getText().toString());
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
    public void ongetVBPhongPhoiHopChoXuLyByIdSuccess(DetailVbphongPhoiHopChoXuLy detailVbphongPhoiHopChoXuLy) {
        RecyclerViewTrinhTuGiaiQuyettPhongPH((ArrayList<TrinhTuGiaiQuyetPhongPH>) detailVbphongPhoiHopChoXuLy.getTrinhTuGiaiQuyets());
        RecyclerViewTepTinDinhKem((ArrayList<TepTinDinhKemPPH>) detailVbphongPhoiHopChoXuLy.getTepTinDinhKems());
        RecyclerViewKetQuaGiaiQuyetPhongPhoiHop((ArrayList<KetQuaGiaiQuyetPhongPP>) detailVbphongPhoiHopChoXuLy.getketQuaGiaiQuyetPhongPHs());
        RecyclerViewKetQuaGiaiQuyetPhongThuLy((ArrayList<KetQuaGiaiQuyetPhongTL>) detailVbphongPhoiHopChoXuLy.getKetQuaGiaiQuyetPhongTLs());
        tvSoDen.setText(String.valueOf(detailVbphongPhoiHopChoXuLy.getSoDen()));
        tvKhuVuc.setText(String.valueOf(detailVbphongPhoiHopChoXuLy.getKhuVuc()));
        tvSoKyHieu.setText(String.valueOf(detailVbphongPhoiHopChoXuLy.getSoKyHieu()));
        tvLoaiVanBan.setText(String.valueOf(detailVbphongPhoiHopChoXuLy.getLoaiVanBan()));
        tvTrichYeu.setText(String.valueOf(detailVbphongPhoiHopChoXuLy.getMoTa()));
        tvNguoiKy.setText(String.valueOf(detailVbphongPhoiHopChoXuLy.getTenNguoiKy()));
        tvNgayNhan.setText(String.valueOf(detailVbphongPhoiHopChoXuLy.getNgayNhan()));
        tvSoTrang.setText(String.valueOf(detailVbphongPhoiHopChoXuLy.getSoTrang()));
        tvDoMat.setText(String.valueOf(detailVbphongPhoiHopChoXuLy.getDoMat()));
        tvNoiGuiDen.setText(String.valueOf(detailVbphongPhoiHopChoXuLy.getNoiGuiDen()));
        tvNgayKy.setText(String.valueOf(detailVbphongPhoiHopChoXuLy.getNgayKy()));
        tvChucVu.setText(String.valueOf(detailVbphongPhoiHopChoXuLy.getChucVu()));
        tvHanGiaiQuyet.setText(String.valueOf(detailVbphongPhoiHopChoXuLy.getHanGiaiQuyet()));
        tvDoKhan.setText(String.valueOf(detailVbphongPhoiHopChoXuLy.getDoKhan()));
        tvThamMuu.setText(String.valueOf(detailVbphongPhoiHopChoXuLy.getThamMuu()));
        tvLinhVuc.setText(String.valueOf(detailVbphongPhoiHopChoXuLy.getLinhVuc()));
        tvNgayPhanLoai.setText(String.valueOf(detailVbphongPhoiHopChoXuLy.getNgayPhanLoai()));
        if (detailVbphongPhoiHopChoXuLy.getSTCCT() == 1) {
            cbSTCChuTri.setChecked(true);
        }
        if (detailVbphongPhoiHopChoXuLy.getTBKL() == 1) {

            cbTBKL.setChecked(true);
        }
        if (detailVbphongPhoiHopChoXuLy.getVBQPPL() == 1) {
            cbVbQPPL.setChecked(true);
        }
    }

    @Override
    public void xoaKQPhongTLSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        getPresenter().getVBPhongPhoiHopChoXuLyById(id);
    }

    @Override
    public void duyetVanBanSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public TTVB_VBGiaoPhongPhoiHopXuLyPresenter createPresenter() {
        return new TTVB_VBGiaoPhongPhoiHopXuLyPresenterImpl(this);
    }

    void RecyclerViewTrinhTuGiaiQuyettPhongPH(ArrayList<TrinhTuGiaiQuyetPhongPH> trinhTuGiaiQuyets) {
        adapterTrinhTuGiaiQuyetPhongPH = new AdapterTrinhTuGiaiQuyetPhongPH(trinhTuGiaiQuyets);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTinhTuGiaiQuyet.setLayoutManager(layoutManager);
        rcvTinhTuGiaiQuyet.setAdapter(adapterTrinhTuGiaiQuyetPhongPH);
        adapterTrinhTuGiaiQuyetPhongPH.notifyDataSetChanged();
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

    void RecyclerViewKetQuaGiaiQuyetPhongThuLy(ArrayList<KetQuaGiaiQuyetPhongTL> ketquaGiaiquyetPhongThulies) {
        adapterKetQuaGiaiQuyetPhongTL = new AdapterKetQuaGiaiQuyetPhongTL(ketquaGiaiquyetPhongThulies, this);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvKetQuaGiaiQuyetPThuLy.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvKetQuaGiaiQuyetPThuLy.setAdapter(adapterKetQuaGiaiQuyetPhongTL);
        adapterKetQuaGiaiQuyetPhongTL.notifyDataSetChanged();
    }

    void RecyclerViewKetQuaGiaiQuyetPhongPhoiHop(ArrayList<KetQuaGiaiQuyetPhongPP> ketquaGiaiquyetPhongPhoihops) {
        adapterKetQuaGiaiQuyetPhongPH = new AdapterKetQuaGiaiQuyetPhongPH(ketquaGiaiquyetPhongPhoihops, this);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvKetQuaGiaiQuyetPPH.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvKetQuaGiaiQuyetPPH.setAdapter(adapterKetQuaGiaiQuyetPhongPH);
        adapterKetQuaGiaiQuyetPhongPH.notifyDataSetChanged();
    }

    void RecyclerViewTepTinDinhKem(ArrayList<TepTinDinhKemPPH> tepDinhKems) {
        adapterTepTinDinhKemPhongPH = new AdapterTepTinDinhKemPhongPH(tepDinhKems, this);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTepDinhKem.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvTepDinhKem.setAdapter(adapterTepTinDinhKemPhongPH);
        adapterTepTinDinhKemPhongPH.notifyDataSetChanged();
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
