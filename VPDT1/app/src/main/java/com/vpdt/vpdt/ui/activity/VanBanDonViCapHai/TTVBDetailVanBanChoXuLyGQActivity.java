package com.vpdt.vpdt.ui.activity.VanBanDonViCapHai;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DetailVanBanChoXuLyGQ;
import com.vpdt.vpdt.model.KetQuaGiaiQuyetPhongPhoiHop1;
import com.vpdt.vpdt.model.KetQuaGiaiQuyetPhongThuLy1;
import com.vpdt.vpdt.model.LyDoChamMuonPhongThuLy;
import com.vpdt.vpdt.model.TepTinVanBanDen;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetPPH;
import com.vpdt.vpdt.presenter.TTVBDetailVanBanChoXuLyGQPresenter;
import com.vpdt.vpdt.presenter.TTVBDetailVanBanChoXuLyGQView;
import com.vpdt.vpdt.presenter.impl.TTVBDetailCanbanChoXuLyGQPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterKetGiaiQuyetPhongThuLy1;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaGiaiQuyetPhongPhoiHop1;
import com.vpdt.vpdt.ui.adapter.AdapterLyDoChamMuonPhongThuLy;
import com.vpdt.vpdt.ui.adapter.AdapterTepTinDinhKemVanBanDen;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetPPH;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTVBDetailVanBanChoXuLyGQActivity extends BaseActivity<TTVBDetailVanBanChoXuLyGQPresenter> implements TTVBDetailVanBanChoXuLyGQView, AdapterTepTinDinhKemVanBanDen.OnItemClickListener, AdapterKetGiaiQuyetPhongThuLy1.OnItemketquaGiaiquyetPhongThulyClickListener, AdapterKetQuaGiaiQuyetPhongPhoiHop1.OnItemketquaGiaiquyetClickListener {

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

    @BindView(R.id.imDownKetQuaGiaiQuyetPhongThuLy)
    ImageView imDownKetQuaGiaiQuyetPhongThuLy;
    @BindView(R.id.imUpKetQuaGiaiQuyetPhongThuLy)
    ImageView imUpKetQuaGiaiQuyetPhongThuLy;

    @BindView(R.id.imDownKetQuaGiaiQuyetPhongPhoiHop)
    ImageView imDownKetQuaGiaiQuyetPhongPhoiHop;
    @BindView(R.id.imUpKetQuaGiaiQuyetPhongPhoiHop)
    ImageView imUpKetQuaGiaiQuyetPhongPhoiHop;

    @BindView(R.id.imDownLyDoChamMuonPhongThuLy)
    ImageView imDownLyDoChamMuonPhongThuLy;
    @BindView(R.id.imUpLyDoChamMuonPhongThuLy)
    ImageView imUpLyDoChamMuonPhongThuLy;

    @BindView(R.id.lnThongTinVanBan)
    LinearLayout lnThongTinVanBan;
    @BindView(R.id.lnTrinhTuGiaiQuyet)
    LinearLayout lnTrinhTuGiaiQuyet;
    @BindView(R.id.lnTepDinhKem)
    LinearLayout lnTepDinhKem;
    @BindView(R.id.lnKetQuaGiaiQuyetPhongThuLy)
    LinearLayout lnKetQuaGiaiQuyetPhongThuLy;
    @BindView(R.id.lnKetQuaGiaiQuyetPhongPhoiHop)
    LinearLayout lnKetQuaGiaiQuyetPhongPhoiHop;
    @BindView(R.id.lnLyDoChamMuonPhongThuLy)
    LinearLayout lnLyDoChamMuonPhongThuLy;
    @BindView(R.id.lnHoanThanh)
    LinearLayout lnHoanThanh;
    @BindView(R.id.lnLyDoChuaKetThuc)
    LinearLayout lnLyDoChuaKetThuc;

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

    @BindView(R.id.edtKetQuaGiaiQuyet)
    EditText edtKetQuaGiaiQuyet;
    @BindView(R.id.edtLyDoChuaKetThucVanBan)
    EditText edtLyDoChuaKetThucVanBan;

    @BindView(R.id.rcvTrinhTuGiaiQuyet)
    RecyclerView rcvTrinhTuGiaiQuyet;
    @BindView(R.id.rcvTepDinhKem)
    RecyclerView rcvTepDinhKem;
    @BindView(R.id.rcvKetQuaGiaiQuyetPhongThuLy)
    RecyclerView rcvKetQuaGiaiQuyetPhongThuLy;
    @BindView(R.id.rcvKetQuaGiaiQuyetPhongPhoiHop)
    RecyclerView rcvKetQuaGiaiQuyetPhongPhoiHop;
    @BindView(R.id.rcvLyDoChamMuonPhongThuLy)
    RecyclerView rcvLyDoChamMuonPhongThuLy;

    @BindView(R.id.rlTrinhTuGiaiQuyet)
    RelativeLayout rlTrinhTuGiaiQuyet;
    @BindView(R.id.rlTepTinDinhKem)
    RelativeLayout rlTepTinDinhKem;
    @BindView(R.id.rlKetQuaGiaiQuyetPhongThuLy)
    RelativeLayout rlKetQuaGiaiQuyetPhongThuLy;
    @BindView(R.id.rlKetQuaGiaiQuyetPhongPhoiHop)
    RelativeLayout rlKetQuaGiaiQuyetPhongPhoiHop;
    @BindView(R.id.rlLyDoChamMuonPhongThuLy)
    RelativeLayout rlLyDoChamMuonPhongThuLy;

    AdapterTrinhTuGiaiQuyetPPH adapterTrinhTuGiaiQuyetPPH;
    AdapterTepTinDinhKemVanBanDen adapterTepTinDinhKemVanBanDen;
    AdapterKetGiaiQuyetPhongThuLy1 adapterKetGiaiQuyetPhongThuLy1;
    AdapterKetQuaGiaiQuyetPhongPhoiHop1 adapterKetQuaGiaiQuyetPhongPhoiHop1;
    AdapterLyDoChamMuonPhongThuLy adapterLyDoChamMuonPhongThuLy;
    int id;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ttvbdetail_van_ban_cho_xu_ly_gq;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("idvb")) {
                id = intent.getIntExtra("idvb", 0);
                getPresenter().getDetailVanBanChoXuLyGQ(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""), id);
            }
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDaTaSuccess(DetailVanBanChoXuLyGQ detailVanBanChoXuLyGQ) {
        RecyclerViewTrinhTuGiaiQuyet((ArrayList<TrinhTuGiaiQuyetPPH>) detailVanBanChoXuLyGQ.getTrinhTuGiaiQuyets());
        RecyclerViewTepTinDinhKem((ArrayList<TepTinVanBanDen>) detailVanBanChoXuLyGQ.getTepTinVanBanDens());
        RecyclerViewKetQuaGiaiQuyetPhongThuLy((ArrayList<KetQuaGiaiQuyetPhongThuLy1>) detailVanBanChoXuLyGQ.getKetQuaGiaiQuyetPhongThuLys());
        RecyclerViewKetQuaGiaiQuyetPhongPhoiHop((ArrayList<KetQuaGiaiQuyetPhongPhoiHop1>) detailVanBanChoXuLyGQ.getKetQuaGiaiQuyetPhongPhoiHops());
        RecyclerViewLyDoChamMuonPhongThuLy((ArrayList<LyDoChamMuonPhongThuLy>) detailVanBanChoXuLyGQ.getLyDoChamMuonPhongThuLys());
        tvSoDen.setText(String.valueOf(detailVanBanChoXuLyGQ.getSoDen()));
        tvKhuVuc.setText(String.valueOf(detailVanBanChoXuLyGQ.getKhuVuc()));
        tvSoKyHieu.setText(String.valueOf(detailVanBanChoXuLyGQ.getSoKyHieu()));
        tvLoaiVanBan.setText(String.valueOf(detailVanBanChoXuLyGQ.getLoaiVanBan()));
        tvTrichYeu.setText(String.valueOf(detailVanBanChoXuLyGQ.getMoTa()));
        tvNguoiKy.setText(String.valueOf(detailVanBanChoXuLyGQ.getTenNguoiKy()));
        tvNgayNhan.setText(String.valueOf(detailVanBanChoXuLyGQ.getNgayNhan()));
        tvDoMat.setText(String.valueOf(detailVanBanChoXuLyGQ.getDoMat()));
        tvNoiGuiDen.setText(String.valueOf(detailVanBanChoXuLyGQ.getNoiGuiDen()));
        tvNgayKy.setText(String.valueOf(detailVanBanChoXuLyGQ.getNgayKy()));
        tvChucVu.setText(String.valueOf(detailVanBanChoXuLyGQ.getChucVu()));
        tvHanGiaiQuyet.setText(String.valueOf(detailVanBanChoXuLyGQ.getHanGiaiQuyet()));
        tvDoKhan.setText(String.valueOf(detailVanBanChoXuLyGQ.getDoKhan()));
        tvLinhVuc.setText(String.valueOf(detailVanBanChoXuLyGQ.getLinhVuc()));
        if (detailVanBanChoXuLyGQ.getTrinhTuGiaiQuyets().size() == 0) {
            rlTrinhTuGiaiQuyet.setVisibility(View.GONE);
        }
        if (detailVanBanChoXuLyGQ.getTepTinVanBanDens().size() == 0) {
            rlTepTinDinhKem.setVisibility(View.GONE);
        }
        if (detailVanBanChoXuLyGQ.getKetQuaGiaiQuyetPhongThuLys().size() == 0) {
            rlKetQuaGiaiQuyetPhongThuLy.setVisibility(View.GONE);
        }
        if (detailVanBanChoXuLyGQ.getKetQuaGiaiQuyetPhongPhoiHops().size() == 0) {
            rlKetQuaGiaiQuyetPhongPhoiHop.setVisibility(View.GONE);
        }
        if (detailVanBanChoXuLyGQ.getLyDoChamMuonPhongThuLys().size() == 0) {
            rlLyDoChamMuonPhongThuLy.setVisibility(View.GONE);
        }
        if (detailVanBanChoXuLyGQ.getShowFrom()) {
            lnHoanThanh.setVisibility(View.VISIBLE);
            lnLyDoChuaKetThuc.setVisibility(View.VISIBLE);
        } else {
            lnHoanThanh.setVisibility(View.GONE);
            lnLyDoChuaKetThuc.setVisibility(View.GONE);
        }
    }

    @Override
    public void hoanThanhSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void chamMuonSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public TTVBDetailVanBanChoXuLyGQPresenter createPresenter() {
        return new TTVBDetailCanbanChoXuLyGQPresenterImpl(this);
    }

    @OnClick({R.id.imvBack, R.id.tvThongTinVanBan,
            R.id.tvTrinhTuGiaiQuyet, R.id.tvTepDinhKem,
            R.id.tvKetQuaGiaiQuyetPhongThuLy,
            R.id.tvKetQuaGiaiQuyetPhongPhoiHop,
            R.id.tvLyDoChamMuonPhongThuLy,
            R.id.btnHoanThanh,
            R.id.btnLyDoChuaKetThuc})

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
            case R.id.tvKetQuaGiaiQuyetPhongThuLy:
                Expand(lnKetQuaGiaiQuyetPhongThuLy, imUpKetQuaGiaiQuyetPhongThuLy, imDownKetQuaGiaiQuyetPhongThuLy);
                break;
            case R.id.tvKetQuaGiaiQuyetPhongPhoiHop:
                Expand(lnKetQuaGiaiQuyetPhongPhoiHop, imUpKetQuaGiaiQuyetPhongPhoiHop, imDownKetQuaGiaiQuyetPhongPhoiHop);
                break;
            case R.id.tvLyDoChamMuonPhongThuLy:
                Expand(lnLyDoChamMuonPhongThuLy, imUpLyDoChamMuonPhongThuLy, imDownLyDoChamMuonPhongThuLy);
                break;
            case R.id.btnHoanThanh:
                getPresenter().hoanThanhVBChoXuLyGQ(id, PrefUtil.getString(TTVBDetailVanBanChoXuLyGQActivity.this, Key.NAM_LAM_VIEC, ""),
                        edtKetQuaGiaiQuyet.getText().toString());
                break;
            case R.id.btnLyDoChuaKetThuc:
                getPresenter().chamMuonVBChoXuLyGQ(id, PrefUtil.getString(TTVBDetailVanBanChoXuLyGQActivity.this, Key.NAM_LAM_VIEC, ""),
                        edtLyDoChuaKetThucVanBan.getText().toString());
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

    void RecyclerViewTrinhTuGiaiQuyet(ArrayList<TrinhTuGiaiQuyetPPH> trinhTuGiaiQuyetDauViecArrayList) {
        adapterTrinhTuGiaiQuyetPPH = new AdapterTrinhTuGiaiQuyetPPH(trinhTuGiaiQuyetDauViecArrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTrinhTuGiaiQuyet.setLayoutManager(layoutManager);
        rcvTrinhTuGiaiQuyet.setAdapter(adapterTrinhTuGiaiQuyetPPH);
        adapterTrinhTuGiaiQuyetPPH.notifyDataSetChanged();
    }

    void RecyclerViewTepTinDinhKem(ArrayList<TepTinVanBanDen> tepDinhKems) {
        adapterTepTinDinhKemVanBanDen = new AdapterTepTinDinhKemVanBanDen(tepDinhKems, this);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTepDinhKem.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvTepDinhKem.setAdapter(adapterTepTinDinhKemVanBanDen);
        adapterTepTinDinhKemVanBanDen.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(TepTinVanBanDen tepTinVanBanDen) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(tepTinVanBanDen.getUrlFile()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    void RecyclerViewKetQuaGiaiQuyetPhongThuLy(ArrayList<KetQuaGiaiQuyetPhongThuLy1> ketquaGiaiquyetPhongThulies) {
        adapterKetGiaiQuyetPhongThuLy1 = new AdapterKetGiaiQuyetPhongThuLy1(ketquaGiaiquyetPhongThulies, this);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvKetQuaGiaiQuyetPhongThuLy.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvKetQuaGiaiQuyetPhongThuLy.setAdapter(adapterKetGiaiQuyetPhongThuLy1);
        adapterKetGiaiQuyetPhongThuLy1.notifyDataSetChanged();
    }

    @Override
    public void onItemketquaGiaiquyetPhongThulyClick(KetQuaGiaiQuyetPhongThuLy1 ketquaGiaiquyetPhongThuly) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ketquaGiaiquyetPhongThuly.getUrlFile()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    void RecyclerViewKetQuaGiaiQuyetPhongPhoiHop(ArrayList<KetQuaGiaiQuyetPhongPhoiHop1> ketquaGiaiquyetPhongPhoihops) {
        adapterKetQuaGiaiQuyetPhongPhoiHop1 = new AdapterKetQuaGiaiQuyetPhongPhoiHop1(ketquaGiaiquyetPhongPhoihops, this);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvKetQuaGiaiQuyetPhongPhoiHop.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvKetQuaGiaiQuyetPhongPhoiHop.setAdapter(adapterKetQuaGiaiQuyetPhongPhoiHop1);
        adapterKetQuaGiaiQuyetPhongPhoiHop1.notifyDataSetChanged();
    }

    @Override
    public void onItemketquaGiaiquyetClick(KetQuaGiaiQuyetPhongPhoiHop1 ketquaGiaiquyetPhongPhoihop) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ketquaGiaiquyetPhongPhoihop.getUrlFile()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    void RecyclerViewLyDoChamMuonPhongThuLy(ArrayList<LyDoChamMuonPhongThuLy> ketquaGiaiquyetPhongPhoihops) {
        adapterLyDoChamMuonPhongThuLy = new AdapterLyDoChamMuonPhongThuLy(ketquaGiaiquyetPhongPhoihops);
        LinearLayoutManager layoutManagerTrinhTuGiaiQuyetPhongPhoiHop = new LinearLayoutManager(this);
        layoutManagerTrinhTuGiaiQuyetPhongPhoiHop.setOrientation(LinearLayoutManager.VERTICAL);
        rcvLyDoChamMuonPhongThuLy.setLayoutManager(layoutManagerTrinhTuGiaiQuyetPhongPhoiHop);
        rcvLyDoChamMuonPhongThuLy.setAdapter(adapterLyDoChamMuonPhongThuLy);
        adapterLyDoChamMuonPhongThuLy.notifyDataSetChanged();
    }
}
