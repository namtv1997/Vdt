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

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DetailDauViec1;
import com.vpdt.vpdt.model.KetQuaGiaiQuyet1;
import com.vpdt.vpdt.model.KetQuaPhoiHop1;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetDauViec1;
import com.vpdt.vpdt.presenter.TTVBDauViecChoXuLyPresenter;
import com.vpdt.vpdt.presenter.TTVBDauViecChoXuLyView;
import com.vpdt.vpdt.presenter.impl.TTVBDauViecChoXuLyPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaGiaiQuyetDauViec;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaPhoiHopDauViec;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuGiaiQuyetDauViec;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTVBDauViecChoXuLyActivity extends BaseActivity<TTVBDauViecChoXuLyPresenter> implements TTVBDauViecChoXuLyView,
        AdapterKetQuaGiaiQuyetDauViec.OnItemClickListenerKetQuaGiaiQuyetDauViec, AdapterKetQuaPhoiHopDauViec.OnItemClickListenerKetQuaPhoiHopDauViec {

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
        return R.layout.activity_ttvbdau_viec_cho_xu_ly;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("DauViecChoXuLy")) {
                idvb = intent.getIntExtra("DauViecChoXuLy", 0);
                getPresenter().getdauviecdetail(idvb);

            }
            if (intent.hasExtra("iddv")) {
                idvb = intent.getIntExtra("iddv", 0);
                getPresenter().getdauviecdetail(idvb);

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
                getPresenter().hoanThanhDauViec(idvb, edtNoiDungHoanThanhCongViec.getText().toString());
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
    public void onGetDataSuccess(DetailDauViec1 detailDauViec) {

        if (intent.hasExtra("iddv")) {
            if (detailDauViec.getTrangThai() == 0) {
                edtNoiDungHoanThanhCongViec.setVisibility(View.GONE);
                btnHoanThanh.setVisibility(View.GONE);
            }
        } else {
            if (detailDauViec.getTrangThai() == 0) {
                edtNoiDungHoanThanhCongViec.setVisibility(View.VISIBLE);
                btnHoanThanh.setVisibility(View.VISIBLE);
            }
        }
        RecyclerViewTrinhTuGiaiQuyetDauViec((ArrayList<TrinhTuGiaiQuyetDauViec1>) detailDauViec.getTrinhTuGiaiQuyets());
        RecyclerViewKetQuaGiaiQuyetDauViec((ArrayList<KetQuaGiaiQuyet1>) detailDauViec.getKetQuaGiaiQuyets());
        RecyclerViewKetQuaPhoiHopDauViec((ArrayList<KetQuaPhoiHop1>) detailDauViec.getKetQuaPhoiHops());
        tvNgayVanBan.setText(String.valueOf(detailDauViec.getNgayVanBan()));
        tvNoiDungDauViec.setText(String.valueOf(detailDauViec.getRoots().get(0).getItemMores().get(0).getNoiDungDauViec()));
        tvTieuDeViec.setText(String.valueOf(detailDauViec.getRoots().get(0).getTieuDeDauViec()));
        tvSoKyHieu.setText(String.valueOf(detailDauViec.getSoKyHieu()));
        tvLoaiVanBan.setText(String.valueOf(detailDauViec.getLoaiVanBan()));
        tvFileVanBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(detailDauViec.getFileVanBan()));
                    startActivity(browserIntent);
                } catch (Exception e) {
                    Toast.makeText(TTVBDauViecChoXuLyActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvNoiDung.setText(String.valueOf(detailDauViec.getNoiDung()));
        tvNguoiKy.setText(String.valueOf(detailDauViec.getNguoiKy()));
        tvLanhDaoChuTri.setText(String.valueOf(detailDauViec.getLanhDaoChuTri()));
        tvNgayNhap.setText(String.valueOf(detailDauViec.getNgayNhap()));
        for (int i = 0; i < detailDauViec.getRoots().size(); i++) {
            tvTieuDeDauViec.setText(String.valueOf(detailDauViec.getRoots().get(i).getTieuDeDauViec()));

            for (i = 0; i < detailDauViec.getRoots().get(i).getItemMores().size(); i++) {
                tvLanhDaoChiDao.setText(String.valueOf(detailDauViec.getRoots().get(i).getItemMores().get(i).getLanhDaoChiDao()));
                tvDonViChuTri.setText(String.valueOf(detailDauViec.getRoots().get(i).getItemMores().get(i).getDonViChuTri()));
                tvHanXuLy.setText(String.valueOf(detailDauViec.getRoots().get(i).getItemMores().get(i).getHanXuLy()));
                tvDonViPhoiHop.setText(String.valueOf(detailDauViec.getRoots().get(i).getItemMores().get(i).getDonViPhoiHop()));
            }
        }

    }

    @Override
    public void onHoanThanhSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public TTVBDauViecChoXuLyPresenter createPresenter() {
        return new TTVBDauViecChoXuLyPresenterImpl(this);
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
