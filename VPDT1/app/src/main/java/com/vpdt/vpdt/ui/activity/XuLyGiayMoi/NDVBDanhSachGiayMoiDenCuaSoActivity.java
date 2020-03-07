package com.vpdt.vpdt.ui.activity.XuLyGiayMoi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DSGiayMoiDenCuaSo;
import com.vpdt.vpdt.model.DetailGiayMoi;
import com.vpdt.vpdt.model.TepDinhKem;
import com.vpdt.vpdt.presenter.NDVBDanhSachGiayMoiDenCuaSoPresenter;
import com.vpdt.vpdt.presenter.NDVBDanhSachGiayMoiDenCuaSoView;
import com.vpdt.vpdt.presenter.impl.NDVBDanhSachGiayMoiDenCuaSoPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterFileDinhKemChoLanhDaoXuLy;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDanhSachGiayMoiDenCuaSoActivity extends BaseActivity<NDVBDanhSachGiayMoiDenCuaSoPresenter> implements NDVBDanhSachGiayMoiDenCuaSoView,
        AdapterFileDinhKemChoLanhDaoXuLy.OnItemClickListenerFileDinhKem {

    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvNoiGui)
    TextView tvNoiGui;
    @BindView(R.id.tvLoaiVanban)
    TextView tvLoaiVanban;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvDiaDiem)
    TextView tvDiaDiem;
    @BindView(R.id.tvNguoiNhap)
    TextView tvNguoiNhap;
    @BindView(R.id.tvNoiDung)
    TextView tvNoiDung;
    @BindView(R.id.tvPhongChuTri)
    TextView tvPhongChuTri;
    @BindView(R.id.tvKetQuaThucHien)
    TextView tvKetQuaThucHien;

    @BindView(R.id.rvFileDinhKem)
    RecyclerView rvFileDinhKem;
    int idgiaymoi;
    private AdapterFileDinhKemChoLanhDaoXuLy adapterFileDinhKemChoLanhDaoXuLy;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbdanh_sach_giay_moi_den_cua_so;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        DSGiayMoiDenCuaSo dsGiayMoiDenCuaSo = getIntent().getParcelableExtra("DanhSachGiayMoiDenCuaSo");
        if (dsGiayMoiDenCuaSo != null) {
            tvNguoiNhap.setText(dsGiayMoiDenCuaSo.getNguoiNhap());
            tvPhongChuTri.setText(dsGiayMoiDenCuaSo.getPhongChuTri());
            tvNoiDung.setText(dsGiayMoiDenCuaSo.getNoiDung());
            tvDiaDiem.setText(String.valueOf("Vào hồi "
                    + dsGiayMoiDenCuaSo.getGiayMoiGio() + " ngày "
                    + dsGiayMoiDenCuaSo.getGiayMoiNgay() + ", tại "
                    + dsGiayMoiDenCuaSo.getGiayMoiDiadiem() + " | Số trang: "
                    + dsGiayMoiDenCuaSo.getSoTrang() + " | "
                    + dsGiayMoiDenCuaSo.getMota2()));
            idgiaymoi = dsGiayMoiDenCuaSo.getId();
            tvKetQuaThucHien.setText(dsGiayMoiDenCuaSo.getKetQuaThuchien());
            getPresenter().getgiaymoibyid(idgiaymoi);
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess(DetailGiayMoi detailGiayMoi) {
        RecyclerViewFileDinhKem((ArrayList<TepDinhKem>) detailGiayMoi.getTepDinhKems());
        String shortDate = detailGiayMoi.getNgayNhan();
        tvNgay.setText(String.valueOf(shortDate.substring(0, 5)));
        tvSKH.setText(String.valueOf(detailGiayMoi.getSoKyhieu()));
        tvSoDen.setText(String.valueOf(detailGiayMoi.getSoDen()));
        tvNoiGui.setText(String.valueOf(detailGiayMoi.getNoiGuiDen()));
        tvLoaiVanban.setText(String.valueOf(detailGiayMoi.getLoaiVanban()));
        tvTrichYeu.setText(String.valueOf(detailGiayMoi.getTrichYeu()));
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack, R.id.tvXemChiTiet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBBaoCaoCuocHopChoPheDuyetActivity.class);
                    intent.putExtra("idvb", idgiaymoi);
                    startActivity(intent);
                    click = true;
                }
                break;
        }
    }

    @Override
    public NDVBDanhSachGiayMoiDenCuaSoPresenter createPresenter() {
        return new NDVBDanhSachGiayMoiDenCuaSoPresenterImpl(this);
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

    void RecyclerViewFileDinhKem(ArrayList<TepDinhKem> tepDinhKems) {
        adapterFileDinhKemChoLanhDaoXuLy = new AdapterFileDinhKemChoLanhDaoXuLy(this, tepDinhKems, this);
        LinearLayoutManager layoutManagerFileDinhKem = new LinearLayoutManager(this);
        layoutManagerFileDinhKem.setOrientation(LinearLayoutManager.VERTICAL);
        rvFileDinhKem.setLayoutManager(layoutManagerFileDinhKem);
        rvFileDinhKem.setAdapter(adapterFileDinhKemChoLanhDaoXuLy);
        adapterFileDinhKemChoLanhDaoXuLy.notifyDataSetChanged();
    }
}
