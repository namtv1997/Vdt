package com.vpdt.vpdt.ui.activity.QuanLyDauViec;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DetailDauViecPhongCT;
import com.vpdt.vpdt.model.KetQuaGiaiQuyet1;
import com.vpdt.vpdt.model.KetQuaPhoiHop1;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetDauViec1;
import com.vpdt.vpdt.presenter.ChiTietDauViecChoXuLyPresenter;
import com.vpdt.vpdt.presenter.ChiTietDauViecChoXuLyView;
import com.vpdt.vpdt.presenter.impl.ChiTietDauViecChoXuLyPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaGiaiQuyetDauViec;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaPhoiHopDauViec;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetDauViec;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChiTietDauViecChoXuLyActivity extends BaseActivity<ChiTietDauViecChoXuLyPresenter> implements ChiTietDauViecChoXuLyView,
        AdapterKetQuaGiaiQuyetDauViec.OnItemClickListenerKetQuaGiaiQuyetDauViec,
        AdapterKetQuaPhoiHopDauViec.OnItemClickListenerKetQuaPhoiHopDauViec {

    @BindView(R.id.imDownThongTinVanBan)
    ImageView imDownThongTinVanBan;
    @BindView(R.id.imUpThongTinVanBan)
    ImageView imUpThongTinVanBan;

    @BindView(R.id.imDownTrinhTuGiaiQuyet)
    ImageView imDownTrinhTuGiaiQuyet;
    @BindView(R.id.imUpTrinhTuGiaiQuyet)
    ImageView imUpTrinhTuGiaiQuyet;

    @BindView(R.id.imDownKetQuaGiaiQuyet)
    ImageView imDownKetQuaGiaiQuyet;
    @BindView(R.id.imUpKetQuaGiaiQuyet)
    ImageView imUpKetQuaGiaiQuyet;

    @BindView(R.id.imDownKetQuaPhoiHop)
    ImageView imDownKetQuaPhoiHop;
    @BindView(R.id.imUpKetQuaPhoiHop)
    ImageView imUpKetQuaPhoiHop;

    @BindView(R.id.lnThongTinVanBan)
    LinearLayout lnThongTinVanBan;
    @BindView(R.id.lnTrinhTuGiaiQuyet)
    LinearLayout lnTrinhTuGiaiQuyet;
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
    @BindView(R.id.tvLvChinh)
    TextView tvLvChinh;
    @BindView(R.id.tvLvChiTiet)
    TextView tvLvChiTiet;

    @BindView(R.id.edtNoiDungHoanThanhCongViec)
    EditText edtNoiDungHoanThanhCongViec;

    @BindView(R.id.btnHoanThanh)
    Button btnHoanThanh;

    Intent intent;

    @BindView(R.id.rcvTrinhTuGiaiQuyet)
    RecyclerView rcvTrinhTuGiaiQuyet;
    @BindView(R.id.rcvKetQuaGiaiQuyet)
    RecyclerView rcvKetQuaGiaiQuyet;
    @BindView(R.id.rcvKetQuaPhoiHop)
    RecyclerView rcvKetQuaPhoiHop;
    private AdapterTrinhTuGiaiQuyetDauViec adapterTrinhTuGiaiQuyetDauViec;
    private AdapterKetQuaGiaiQuyetDauViec adapterKetQuaGiaiQuyetDauViec;
    private AdapterKetQuaPhoiHopDauViec adapterKetQuaPhoiHopDauViec;

    int idvb;

    @Override
    public int getContentViewId() {
        return R.layout.activity_chi_tiet_dau_viec_cho_xu_ly;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("idvb")) {
                idvb = intent.getIntExtra("idvb", 0);
                getPresenter().getChiTietDauViecPHCT(idvb, PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""));
            }
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @OnClick({R.id.btnBack, R.id.tvThongTinVanBan,
            R.id.tvTrinhTuGiaiQuyet, R.id.tvKetQuaGiaiQuyet,
            R.id.tvKetQuaPhoiHop, R.id.btnHoanThanh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvThongTinVanBan:
                Expand(lnThongTinVanBan, imUpThongTinVanBan, imDownThongTinVanBan);
                break;
            case R.id.tvTrinhTuGiaiQuyet:
                Expand(lnTrinhTuGiaiQuyet, imUpTrinhTuGiaiQuyet, imDownTrinhTuGiaiQuyet);
                break;
            case R.id.tvKetQuaGiaiQuyet:
                Expand(lnKetQuaGiaiQuyet, imUpKetQuaGiaiQuyet, imDownKetQuaGiaiQuyet);
                break;
            case R.id.tvKetQuaPhoiHop:
                Expand(lnKetQuaPhoiHop, imUpKetQuaPhoiHop, imDownKetQuaPhoiHop);
                break;
            case R.id.btnHoanThanh:
                getPresenter().hoanThanhDauViecPHCT(idvb, edtNoiDungHoanThanhCongViec.getText().toString());
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
    public void onGetDataSuccess(DetailDauViecPhongCT detailDauViecPhongCT) {
        RecyclerViewTrinhTuGiaiQuyetDauViec((ArrayList<TrinhTuGiaiQuyetDauViec1>) detailDauViecPhongCT.getTrinhTuGiaiQuyets());
        RecyclerViewKetQuaGiaiQuyetDauViec((ArrayList<KetQuaGiaiQuyet1>) detailDauViecPhongCT.getKetQuaGiaiQuyets());
        RecyclerViewKetQuaPhoiHopDauViec((ArrayList<KetQuaPhoiHop1>) detailDauViecPhongCT.getKetQuaPhoiHops());
        tvNgayVanBan.setText(String.valueOf(detailDauViecPhongCT.getNgayVanBan()));
        tvNoiDungDauViec.setText(String.valueOf(detailDauViecPhongCT.getRoots().get(0).getItemMores().get(0).getNoiDungDauViec()));
        tvTieuDeViec.setText(String.valueOf(detailDauViecPhongCT.getRoots().get(0).getTieuDeDauViec()));
        tvSoKyHieu.setText(String.valueOf(detailDauViecPhongCT.getSoKyHieu()));
        tvLvChinh.setText(String.valueOf(detailDauViecPhongCT.getRoots().get(0).getLinhVuc()));
        tvLvChiTiet.setText(String.valueOf(detailDauViecPhongCT.getRoots().get(0).getLinhVucChiTiet()));
        tvLoaiVanBan.setText(String.valueOf(detailDauViecPhongCT.getLoaiVanBan()));
        tvFileVanBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(detailDauViecPhongCT.getFileVanBan()));
                    startActivity(browserIntent);
                } catch (Exception e) {
                    Toast.makeText(ChiTietDauViecChoXuLyActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvNoiDung.setText(String.valueOf(detailDauViecPhongCT.getNoiDung()));
        tvNguoiKy.setText(String.valueOf(detailDauViecPhongCT.getNguoiKy()));
        tvLanhDaoChuTri.setText(String.valueOf(detailDauViecPhongCT.getLanhDaoChuTri()));
        tvNgayNhap.setText(String.valueOf(detailDauViecPhongCT.getNgayNhap()));
        for (int i = 0; i < detailDauViecPhongCT.getRoots().size(); i++) {
            tvTieuDeDauViec.setText(String.valueOf(detailDauViecPhongCT.getRoots().get(i).getTieuDeDauViec()));

            for (i = 0; i < detailDauViecPhongCT.getRoots().get(i).getItemMores().size(); i++) {
                tvLanhDaoChiDao.setText(String.valueOf(detailDauViecPhongCT.getRoots().get(i).getItemMores().get(i).getLanhDaoChiDao()));
                tvDonViChuTri.setText(String.valueOf(detailDauViecPhongCT.getRoots().get(i).getItemMores().get(i).getDonViChuTri()));
                tvHanXuLy.setText(String.valueOf(detailDauViecPhongCT.getRoots().get(i).getItemMores().get(i).getHanXuLy()));
                tvDonViPhoiHop.setText(String.valueOf(detailDauViecPhongCT.getRoots().get(i).getItemMores().get(i).getDonViPhoiHop()));
            }
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
    public void onHoanThanhSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public ChiTietDauViecChoXuLyPresenter createPresenter() {
        return new ChiTietDauViecChoXuLyPresenterImpl(this);
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
