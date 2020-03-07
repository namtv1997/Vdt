package com.vpdt.vpdt.ui.activity.VanBanDen;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DetailBaoCaoTongHop;
import com.vpdt.vpdt.model.TepTinVanBanDen;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.model.VanbanBaoCaoTongHop;
import com.vpdt.vpdt.presenter.TTVBBaoCaoTongHopPresenter;
import com.vpdt.vpdt.presenter.TTVBBaoCaoTongHopView;
import com.vpdt.vpdt.presenter.impl.TTVBBaoCaoTongHopPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterTepTinVanBanDen;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTVBBaoCaoTongHopActivity extends BaseActivity<TTVBBaoCaoTongHopPresenter> implements TTVBBaoCaoTongHopView,
        AdapterTepTinVanBanDen.OnItemClickListener {

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

    @BindView(R.id.imDownKetQuaGiaiQuyet)
    ImageView imDownKetQuaGiaiQuyet;
    @BindView(R.id.imUpKetQuaGiaiQuyet)
    ImageView imUpKetQuaGiaiQuyet;

    @BindView(R.id.lnThongTinVanBan)
    LinearLayout lnThongTinVanBan;
    @BindView(R.id.lnTrinhTuGiaiQuyet)
    LinearLayout lnTrinhTuGiaiQuyet;
    @BindView(R.id.lnKetQuaGiaiQuyet)
    LinearLayout lnKetQuaGiaiQuyet;
    @BindView(R.id.lnTepDinhKem)
    LinearLayout lnTepDinhKem;

    @BindView(R.id.tvSoVanBan)
    TextView tvSoVanBan;
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
    @BindView(R.id.tvNguoiChiDao)
    TextView tvNguoiChiDao;
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
    @BindView(R.id.tvVanBanTraLoi)
    TextView tvVanBanTraLoi;

    @BindView(R.id.rcvTTGQTTVB)
    RecyclerView rcvTTGQTTVB;
    @BindView(R.id.rcvTTDKTTVB)
    RecyclerView rcvTTDKTTVB;

    private AdapterTepTinVanBanDen adapterTepTinVanBanDen;
    AdapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet adapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet;


    int id;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ttvbbao_cao_tong_hop;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        VanbanBaoCaoTongHop vanbanBaoCaoTongHop = getIntent().getParcelableExtra("vanbanBaoCaoTongHop");
        if (vanbanBaoCaoTongHop != null) {
            id = vanbanBaoCaoTongHop.getMavb();
            getPresenter().getDetailVanBanDauRa(id);
        }
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("idvb")) {
                id = intent.getIntExtra("idvb", 0);
                getPresenter().getDetailVanBanDauRa(id);
            }
        }
    }

    @Override
    public void onGetDataSuccess(DetailBaoCaoTongHop detailBaoCaoTongHop) {
        RecyclerViewTrinhTuGiaiQuyet((ArrayList<TrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet>) detailBaoCaoTongHop.getTrinhTuGiaiQuyets());
        RecyclerViewTepTinDinhKem((ArrayList<TepTinVanBanDen>) detailBaoCaoTongHop.getTepTinVanBanDens());
        tvVanBanTraLoi.setText(String.valueOf("Văn bản trả lời: " + detailBaoCaoTongHop.getVanBanTraLoi()));
        tvVanBanTraLoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(detailBaoCaoTongHop.getUrlVanBanTraLoi()));
                    startActivity(browserIntent);
                } catch (Exception e) {
                    Toast.makeText(TTVBBaoCaoTongHopActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvSoVanBan.setText(String.valueOf(detailBaoCaoTongHop.getSoVanBan()));
        tvKhuVuc.setText(String.valueOf(detailBaoCaoTongHop.getKhuVuc()));
        tvSoKyHieu.setText(String.valueOf(detailBaoCaoTongHop.getSoKyHieu()));
        tvLoaiVanBan.setText(String.valueOf(detailBaoCaoTongHop.getLoaiVanBan()));
        tvTrichYeu.setText(String.valueOf(detailBaoCaoTongHop.getMoTa()));
        tvNguoiKy.setText(String.valueOf(detailBaoCaoTongHop.getTenNguoiKy()));
        tvNgayNhan.setText(String.valueOf(detailBaoCaoTongHop.getNgayNhan()));
        tvNguoiChiDao.setText(String.valueOf(detailBaoCaoTongHop.getTenNguoiChiDao()));
        tvDoMat.setText(String.valueOf(detailBaoCaoTongHop.getDoMat()));
        tvNoiGuiDen.setText(String.valueOf(detailBaoCaoTongHop.getNoiGuiDen()));
        tvNgayKy.setText(String.valueOf(detailBaoCaoTongHop.getNgayKy()));
        tvLinhVuc.setText(String.valueOf(detailBaoCaoTongHop.getLinhVuc()));
        tvChucVu.setText(String.valueOf(detailBaoCaoTongHop.getChucVu()));
        tvHanGiaiQuyet.setText(String.valueOf(detailBaoCaoTongHop.getHanGiaiQuyet()));
        tvDoKhan.setText(String.valueOf(detailBaoCaoTongHop.getDoKhan()));
        tvNgayPhanLoai.setText(String.valueOf(detailBaoCaoTongHop.getNgayPhanLoai()));
    }

    @Override
    public TTVBBaoCaoTongHopPresenter createPresenter() {
        return new TTVBBaoCaoTongHopPresenterImpl(this);
    }

    @Override
    public Context gContext() {
        return this;
    }

    @OnClick({R.id.imvBack, R.id.tvThongTinVanBan, R.id.tvTrinhTuGiaiQuyet, R.id.tvTepDinhKem, R.id.tvKetQuaGiaiQuyet})
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
            case R.id.tvKetQuaGiaiQuyet:
                Expand(lnKetQuaGiaiQuyet, imUpKetQuaGiaiQuyet, imDownKetQuaGiaiQuyet);
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

    void RecyclerViewTrinhTuGiaiQuyet(ArrayList<TrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet> trinhTuGiaiQuyets) {
        adapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet = new AdapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet(trinhTuGiaiQuyets);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTGQTTVB.setLayoutManager(layoutManager);
        rcvTTGQTTVB.setAdapter(adapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet);
        adapterTrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet.notifyDataSetChanged();
    }

    void RecyclerViewTepTinDinhKem(ArrayList<TepTinVanBanDen> tepTinVanBanDens) {
        adapterTepTinVanBanDen = new AdapterTepTinVanBanDen(tepTinVanBanDens, this);
        LinearLayoutManager layoutManagerTepTinDinhKem = new LinearLayoutManager(this);
        layoutManagerTepTinDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTDKTTVB.setLayoutManager(layoutManagerTepTinDinhKem);
        rcvTTDKTTVB.setAdapter(adapterTepTinVanBanDen);
        adapterTepTinVanBanDen.notifyDataSetChanged();
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
}
