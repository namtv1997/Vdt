package com.vpdt.vpdt.ui.activity.XuLyGiayMoi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.FileBaoCao;
import com.vpdt.vpdt.model.GMDaHoanThanhChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.presenter.NDVBGiayMoiDaHoanThanhChoLanhDaoPheDuyetPresenter;
import com.vpdt.vpdt.presenter.NDVBGiayMoiDaHoanThanhChoLanhDaoPheDuyetView;
import com.vpdt.vpdt.presenter.impl.NDVBGiayMoiDaHoanThanhChoLanhDaoPheDuyetPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.ui.adapter.AdapterFileBaoCao;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBGiayMoiDaHoanThanhChoLanhDaoPheDuyetActivity extends BaseActivity<NDVBGiayMoiDaHoanThanhChoLanhDaoPheDuyetPresenter> implements NDVBGiayMoiDaHoanThanhChoLanhDaoPheDuyetView,
        AdapterFileBaoCao.OnItemClickListenerFileDinhKem {

    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvNoiGui)
    TextView tvNoiGui;
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvTrichYeuNDVBDSVBDenChoLDXL)
    TextView tvTrichYeuNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvNgayGio)
    TextView tvNgayGio;
    @BindView(R.id.tvTenChiDao)
    TextView tvTenChiDao;
    @BindView(R.id.tvNoiDungChiDao)
    TextView tvNoiDungChiDao;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;
    @BindView(R.id.btnDaDuyet)
    Button btnDaDuyet;
    @BindView(R.id.lnduyet)
    LinearLayout lnduyet;

    @BindView(R.id.rvFileDinhKem)
    RecyclerView rvFileDinhKem;
    @BindView(R.id.rcvTrinhTuXuLy)
    RecyclerView rcvTrinhTuXuLy;

    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;
    AdapterFileBaoCao adapterFileBaoCao;
    boolean click = false;
    int idvb, level;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbgiay_moi_da_hoan_thanh_cho_lanh_dao_phe_duyet;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        GMDaHoanThanhChoLanhDaoPhongPheDuyet gmDaHoanThanhChoLanhDaoPhongPheDuyet = getIntent().getParcelableExtra("gmDaHoanThanhChoLanhDaoPhongPheDuyet");
        level = PrefUtil.getInt(this, Key.LEVEL, 0);
        if (level == 8) {
            lnduyet.setVisibility(View.GONE);
            btnDaDuyet.setVisibility(View.VISIBLE);
        }
        if (gmDaHoanThanhChoLanhDaoPhongPheDuyet != null) {
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) gmDaHoanThanhChoLanhDaoPhongPheDuyet.getTrinhTuXuLy());
            recyclerviewFileBaocao((ArrayList<FileBaoCao>) gmDaHoanThanhChoLanhDaoPhongPheDuyet.getFileBaoCaos());
            idvb = gmDaHoanThanhChoLanhDaoPhongPheDuyet.getId();
            tvSKH.setText(String.valueOf(gmDaHoanThanhChoLanhDaoPhongPheDuyet.getSoKyHieu()));
            tvNoiGui.setText(String.valueOf(gmDaHoanThanhChoLanhDaoPhongPheDuyet.getNoiGui()));
            tvNgay.setText(gmDaHoanThanhChoLanhDaoPhongPheDuyet.getNgayNhap());
            tvSoDen.setText(String.valueOf(gmDaHoanThanhChoLanhDaoPhongPheDuyet.getSoDen()));
            tvNoiDungChiDao.setText(String.valueOf(gmDaHoanThanhChoLanhDaoPhongPheDuyet.getMoTaHoanThanh()));
            tvTrichYeuNDVBDSVBDenChoLDXL.setText(String.valueOf(gmDaHoanThanhChoLanhDaoPhongPheDuyet.getMoTa()));
            if (!gmDaHoanThanhChoLanhDaoPhongPheDuyet.getGiayMoiGio().isEmpty() && !gmDaHoanThanhChoLanhDaoPhongPheDuyet.getGiayMoiNgay().isEmpty() && !gmDaHoanThanhChoLanhDaoPhongPheDuyet.getGiayMoiDiaDiem().isEmpty()) {
                tvNgayGio.setText("Vào hồi " + gmDaHoanThanhChoLanhDaoPhongPheDuyet.getGiayMoiGio() + "ngày " + gmDaHoanThanhChoLanhDaoPhongPheDuyet.getGiayMoiNgay() + ", tại " + gmDaHoanThanhChoLanhDaoPhongPheDuyet.getGiayMoiDiaDiem());
            }
            tvTenChiDao.setText(String.valueOf(gmDaHoanThanhChoLanhDaoPhongPheDuyet.getTenNguoiHoanThanh()));
            btnDaDuyet.setText(String.valueOf(gmDaHoanThanhChoLanhDaoPhongPheDuyet.getTrangthai()));
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(gmDaHoanThanhChoLanhDaoPhongPheDuyet.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBGiayMoiDaHoanThanhChoLanhDaoPheDuyetActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.imvBack,
            R.id.tvXemChiTiet, R.id.btnTuChoi, R.id.btnDuyet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imvBack:
                finish();
                break;
            case R.id.btnDuyet:
                getPresenter().duyetGMDaHoanThanhChoLDPheDuyet(idvb);
                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBGiayMoiPhongChuTriChoXuLyActivity.class);
                    intent.putExtra("idvb", idvb);
                    startActivity(intent);
                    click = true;
                }
                break;
            case R.id.btnTuChoi:
                getPresenter().tuchoiGMDaHoanThanhChoLDPheDuyet(idvb);
                break;
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void duyetGMDaHoanThanhChoLDPheDuyetSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void tuchoiGMDaHoanThanhChoLDPheDuyetSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NDVBGiayMoiDaHoanThanhChoLanhDaoPheDuyetPresenter createPresenter() {
        return new NDVBGiayMoiDaHoanThanhChoLanhDaoPheDuyetPresenterImpl(this);
    }

    void recyclerviewTrinhTuChuyenNhan(ArrayList<String> stringArrayList) {
        adapterDeXuatGiaHanChoXuLy = new AdapterDeXuatGiaHanChoXuLy(stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTrinhTuXuLy.setLayoutManager(linearLayoutManager);
        rcvTrinhTuXuLy.setAdapter(adapterDeXuatGiaHanChoXuLy);
        adapterDeXuatGiaHanChoXuLy.notifyDataSetChanged();
    }

    void recyclerviewFileBaocao(ArrayList<FileBaoCao> fileBaoCaoArrayList) {
        adapterFileBaoCao = new AdapterFileBaoCao(fileBaoCaoArrayList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvFileDinhKem.setLayoutManager(linearLayoutManager);
        rvFileDinhKem.setAdapter(adapterFileBaoCao);
        adapterFileBaoCao.notifyDataSetChanged();
    }

    @Override
    public void onItemClickFileDinhKem(FileBaoCao fileDinhKem) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(fileDinhKem.getUrl()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(NDVBGiayMoiDaHoanThanhChoLanhDaoPheDuyetActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
