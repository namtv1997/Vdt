package com.vpdt.vpdt.ui.activity.QuanLyDauViec;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DetailDauViec1;
import com.vpdt.vpdt.model.KetQuaGiaiQuyet1;
import com.vpdt.vpdt.model.KetQuaPhoiHop1;
import com.vpdt.vpdt.model.TrinhTuDeXuatHan1;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetDauViec1;
import com.vpdt.vpdt.presenter.TTVBDauViecChoXuLyPresenter;
import com.vpdt.vpdt.presenter.TTVBDauViecChoXuLyView;
import com.vpdt.vpdt.presenter.impl.TTVBDauViecChoXuLyPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaGiaiQuyetDauViec;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaPhoiHopDauViec;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuDeXuatHan;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetDauViec;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTVBDeXuatGiaHanChoXuLyActivity extends BaseActivity<TTVBDauViecChoXuLyPresenter> implements TTVBDauViecChoXuLyView,
        AdapterKetQuaGiaiQuyetDauViec.OnItemClickListenerKetQuaGiaiQuyetDauViec, AdapterKetQuaPhoiHopDauViec.OnItemClickListenerKetQuaPhoiHopDauViec {
    @BindView(R.id.imDownChiTietDauViec)
    ImageView imDownChiTietDauViec;
    @BindView(R.id.imUpChiTietDauViec)
    ImageView imUpChiTietDauViec;

    @BindView(R.id.imDownTrinhTuGiaiQuyet)
    ImageView imDownTrinhTuGiaiQuyet;
    @BindView(R.id.imUpTrinhTuGiaiQuyet)
    ImageView imUpTrinhTuGiaiQuyet;

    @BindView(R.id.imDownTrinhTuDeXuatHan)
    ImageView imDownTrinhTuDeXuatHan;
    @BindView(R.id.imUpTrinhTuDeXuatHan)
    ImageView imUpTrinhTuDeXuatHan;

    @BindView(R.id.imDownKetQuaGiaiQuyet)
    ImageView imDownKetQuaGiaiQuyet;
    @BindView(R.id.imUpKetQuaGiaiQuyet)
    ImageView imUpKetQuaGiaiQuyet;

    @BindView(R.id.imDownKetQuaPhoiHop)
    ImageView imDownKetQuaPhoiHop;
    @BindView(R.id.imUpKetQuaPhoiHop)
    ImageView imUpKetQuaPhoiHop;

    @BindView(R.id.lnChiTietDauViec)
    LinearLayout lnChiTietDauViec;
    @BindView(R.id.lnTrinhTuGiaiQuyet)
    LinearLayout lnTrinhTuGiaiQuyet;
    @BindView(R.id.lnTrinhTuDeXuatHan)
    LinearLayout lnTrinhTuDeXuatHan;
    @BindView(R.id.lnKetQuaGiaiQuyet)
    LinearLayout lnKetQuaGiaiQuyet;
    @BindView(R.id.lnKetQuaPhoiHop)
    LinearLayout lnKetQuaPhoiHop;


    @BindView(R.id.tvLoaiVanBan)
    TextView tvLoaiVanBan;
    @BindView(R.id.tvNgayVanBan)
    TextView tvNgayVanBan;
    @BindView(R.id.tvSoKyHieu)
    TextView tvSoKyHieu;
    @BindView(R.id.tvFileVanBan)
    TextView tvFileVanBan;
    @BindView(R.id.tvNoiDung)
    TextView tvNoiDung;
    @BindView(R.id.tvLanhDaoChuTri)
    TextView tvLanhDaoChuTri;
    @BindView(R.id.tvNguoiKy)
    TextView tvNguoiKy;
    @BindView(R.id.tvNgayNhap)
    TextView tvNgayNhap;
    @BindView(R.id.tvTieuDeDauViec)
    TextView tvTieuDeDauViec;
    @BindView(R.id.tvNoiDungDauViec)
    TextView tvNoiDungDauViec;
    @BindView(R.id.tvTieuDeViec)
    TextView tvTieuDeViec;
    @BindView(R.id.tvLanhDaoChiDao)
    TextView tvLanhDaoChiDao;
    @BindView(R.id.tvDonViChuTri)
    TextView tvDonViChuTri;
    @BindView(R.id.tvHanXuLy)
    TextView tvHanXuLy;
    @BindView(R.id.tvDonViPhoiHop)
    TextView tvDonViPhoiHop;

    @BindView(R.id.rcvTrinhTuGiaiQuyet)
    RecyclerView rcvTrinhTuGiaiQuyet;
    @BindView(R.id.rcvKetQuaGiaiQuyet)
    RecyclerView rcvKetQuaGiaiQuyet;
    @BindView(R.id.rcvTrinhTuDeXuatHan)
    RecyclerView rcvTrinhTuDeXuatHan;
    @BindView(R.id.rcvKetQuaPhoiHop)
    RecyclerView rcvKetQuaPhoiHop;

    @BindView(R.id.rlTrinhTuDeXuatHan)
    RelativeLayout rlTrinhTuDeXuatHan;

    int idvb;

    private AdapterTrinhTuGiaiQuyetDauViec adapterTrinhTuGiaiQuyetDauViec;
    private AdapterKetQuaGiaiQuyetDauViec adapterKetQuaGiaiQuyetDauViec;
    private AdapterKetQuaPhoiHopDauViec adapterKetQuaPhoiHopDauViec;
    private AdapterTrinhTuDeXuatHan adapterTrinhTuDeXuatHan;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ttvbde_xuat_gia_han_cho_xu_ly;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("DauViecChoXuLy")) {
                idvb = intent.getIntExtra("DauViecChoXuLy", 0);
                getPresenter().getdauviecdetail(idvb);

            }
            if (intent.hasExtra("idvb")) {
                idvb = intent.getIntExtra("idvb", 0);
                getPresenter().getdauviecdetail(idvb);

            }
        }
    }

    @Override
    public void onGetDataSuccess(DetailDauViec1 detailDauViec) {
        if (detailDauViec.getTrinhTuDeXuatHans().size() == 0) {
            rlTrinhTuDeXuatHan.setVisibility(View.GONE);
        }
        RecyclerViewTrinhTuGiaiQuyetDauViec((ArrayList<TrinhTuGiaiQuyetDauViec1>) detailDauViec.getTrinhTuGiaiQuyets());
        RecyclerViewTrinhTudeXuatHan((ArrayList<TrinhTuDeXuatHan1>) detailDauViec.getTrinhTuDeXuatHans());
        RecyclerViewKetQuaGiaiQuyetDauViec((ArrayList<KetQuaGiaiQuyet1>) detailDauViec.getKetQuaGiaiQuyets());
        RecyclerViewKetQuaPhoiHopDauViec((ArrayList<KetQuaPhoiHop1>) detailDauViec.getKetQuaPhoiHops());
        tvNgayVanBan.setText(String.valueOf(detailDauViec.getNgayVanBan()));
        tvSoKyHieu.setText(String.valueOf(detailDauViec.getSoKyHieu()));
        tvLoaiVanBan.setText(String.valueOf(detailDauViec.getLoaiVanBan()));
//        tvFileVanBan.setText(String.valueOf(detailDauViec.getFileVanban()));
        tvFileVanBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(detailDauViec.getFileVanBan()));
                    startActivity(browserIntent);
                } catch (Exception e) {
                    Toast.makeText(TTVBDeXuatGiaHanChoXuLyActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvNoiDung.setText(String.valueOf(detailDauViec.getNoiDung()));
        tvNguoiKy.setText(String.valueOf(detailDauViec.getNguoiKy()));
        tvLanhDaoChuTri.setText(String.valueOf(detailDauViec.getLanhDaoChuTri()));
        tvNgayNhap.setText(String.valueOf(detailDauViec.getNgayNhap()));
        for (int i = 0; i <= detailDauViec.getRoots().size(); i++) {
            tvTieuDeDauViec.setText(String.valueOf(detailDauViec.getRoots().get(i).getTieuDeDauViec()));

            for (i = 0; i <= detailDauViec.getRoots().get(i).getItemMores().size(); i++) {
                tvLanhDaoChiDao.setText(String.valueOf(detailDauViec.getRoots().get(i).getItemMores().get(i).getLanhDaoChiDao()));
                tvDonViChuTri.setText(String.valueOf(detailDauViec.getRoots().get(i).getItemMores().get(i).getDonViChuTri()));
                tvHanXuLy.setText(String.valueOf(detailDauViec.getRoots().get(i).getItemMores().get(i).getHanXuLy()));
                tvDonViPhoiHop.setText(String.valueOf(detailDauViec.getRoots().get(i).getItemMores().get(i).getDonViPhoiHop()));
            }
        }
    }

    @OnClick({R.id.imvBack, R.id.tvChiTietDauViec,
            R.id.tvTrinhTuGiaiQuyet, R.id.tvKetQuaGiaiQuyet, R.id.tvTrinhTuDeXuatHan,
            R.id.tvKetQuaPhoiHop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imvBack:
                finish();
                break;
            case R.id.tvChiTietDauViec:
                Expand(lnChiTietDauViec, imUpChiTietDauViec, imDownChiTietDauViec);
                break;
            case R.id.tvTrinhTuGiaiQuyet:
                Expand(lnTrinhTuGiaiQuyet, imUpTrinhTuGiaiQuyet, imDownTrinhTuGiaiQuyet);
                break;
            case R.id.tvTrinhTuDeXuatHan:
                Expand(lnTrinhTuDeXuatHan, imUpTrinhTuDeXuatHan, imDownTrinhTuDeXuatHan);
                break;
            case R.id.tvKetQuaGiaiQuyet:
                Expand(lnKetQuaGiaiQuyet, imUpKetQuaGiaiQuyet, imDownKetQuaGiaiQuyet);
                break;
            case R.id.tvKetQuaPhoiHop:
                Expand(lnKetQuaPhoiHop, imUpKetQuaPhoiHop, imDownKetQuaPhoiHop);
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

    void RecyclerViewTrinhTuGiaiQuyetDauViec(ArrayList<TrinhTuGiaiQuyetDauViec1> trinhTuGiaiQuyetDauViecArrayList) {
        adapterTrinhTuGiaiQuyetDauViec = new AdapterTrinhTuGiaiQuyetDauViec(this, trinhTuGiaiQuyetDauViecArrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTrinhTuGiaiQuyet.setLayoutManager(layoutManager);
        rcvTrinhTuGiaiQuyet.setAdapter(adapterTrinhTuGiaiQuyetDauViec);
        adapterTrinhTuGiaiQuyetDauViec.notifyDataSetChanged();
    }

    void RecyclerViewTrinhTudeXuatHan(ArrayList<TrinhTuDeXuatHan1> trinhTuGiaiQuyetDauViecArrayList) {
        adapterTrinhTuDeXuatHan = new AdapterTrinhTuDeXuatHan(trinhTuGiaiQuyetDauViecArrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTrinhTuDeXuatHan.setLayoutManager(layoutManager);
        rcvTrinhTuDeXuatHan.setAdapter(adapterTrinhTuDeXuatHan);
        adapterTrinhTuDeXuatHan.notifyDataSetChanged();
    }

    void RecyclerViewKetQuaGiaiQuyetDauViec(ArrayList<KetQuaGiaiQuyet1> ketQuaGiaiQuyetDauViecArrayList) {
        adapterKetQuaGiaiQuyetDauViec = new AdapterKetQuaGiaiQuyetDauViec(this, ketQuaGiaiQuyetDauViecArrayList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvKetQuaGiaiQuyet.setLayoutManager(layoutManager);
        rcvKetQuaGiaiQuyet.setAdapter(adapterKetQuaGiaiQuyetDauViec);
        adapterKetQuaGiaiQuyetDauViec.notifyDataSetChanged();
    }

    void RecyclerViewKetQuaPhoiHopDauViec(ArrayList<KetQuaPhoiHop1> ketQuaPhoiHopArrayList) {
        adapterKetQuaPhoiHopDauViec = new AdapterKetQuaPhoiHopDauViec(this, ketQuaPhoiHopArrayList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvKetQuaPhoiHop.setLayoutManager(layoutManager);
        rcvKetQuaPhoiHop.setAdapter(adapterKetQuaPhoiHopDauViec);
        adapterKetQuaPhoiHopDauViec.notifyDataSetChanged();
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onHoanThanhSuccess() {

    }

    @Override
    public TTVBDauViecChoXuLyPresenter createPresenter() {
        return new TTVBDauViecChoXuLyPresenterImpl(this);
    }

    @Override
    public void onItemClickKetQuaGiaiQuyetDauViec(KetQuaGiaiQuyet1 ketQuaGiaiQuyetDauViec) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ketQuaGiaiQuyetDauViec.getUrlFile()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClickKetQuaPhoiHopDauViec(KetQuaPhoiHop1 ketQuaPhoiHop) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ketQuaPhoiHop.getUrlFile()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
