package com.vpdt.vpdt.ui.activity.XuLyGiayMoi;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.BaoCaoKetQuaCuocHop;
import com.vpdt.vpdt.model.DetailGiayMoi;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetGiayMoi;
import com.vpdt.vpdt.presenter.NDVBBaoCaoKetQuaCuocHopView;
import com.vpdt.vpdt.presenter.NDVBBaoCaoKetQuaCuocHop_Presenter;
import com.vpdt.vpdt.presenter.impl.NDVB_BaoCaoKetQuaCuocHopPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterBaoCaoKetQuaCuocHop;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuXuLyGiayMoi;
import com.vpdt.vpdt.util.Util;

import org.sufficientlysecure.htmltextview.HtmlAssetsImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBBaoCaoKetQuaCuocHopMoiActivity extends BaseActivity<NDVBBaoCaoKetQuaCuocHop_Presenter> implements NDVBBaoCaoKetQuaCuocHopView {

    @BindView(R.id.tvSKH)
    TextView skh;
    @BindView(R.id.tvNoiGui)
    TextView noigui;
    @BindView(R.id.tvNgay)
    TextView ngay;
    @BindView(R.id.tvSoDen)
    TextView soden;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvLoaiVanban)
    TextView tvLoaiVanban;
    @BindView(R.id.tvXemChiTiet)
    TextView tvXemChiTiet;
    @BindView(R.id.tvDiaDiem)
    TextView tvDiaDiem;

    int id;
    AdapterBaoCaoKetQuaCuocHop adapterBaoCaoKetQuaCuocHop;
    AdapterTrinhTuXuLyGiayMoi adapterTrinhTuXuLyDonThu;
    @BindView(R.id.rvTrinhTuXuLy)
    RecyclerView rcvTTXL;
    @BindView(R.id.rcvBaoCaoGuiCacPhong)
    RecyclerView rcvBaoCaoGuiCacPhong;
    AlertDialog.Builder builder;
    String deXuatPhong;
    String ketLuanCuocHop;
    String yKienGiamDoc;
    String fileBaoCao;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbbao_cao_ket_qua_cuoc_hop_moi;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        BaoCaoKetQuaCuocHop baoCaoKetQuaCuocHop = getIntent().getParcelableExtra("ID_VANBANBCKQCHMOI");
        if (baoCaoKetQuaCuocHop != null) {
            recyclerviewBaoCaoKQCuocHop((ArrayList<String>) baoCaoKetQuaCuocHop.getGuiPhongs());
            id = baoCaoKetQuaCuocHop.getId();
            getPresenter().getgiaymoibyid(id);
        }
        deXuatPhong = baoCaoKetQuaCuocHop.getDexuatPhong();
        ketLuanCuocHop = baoCaoKetQuaCuocHop.getNoiDung();
        yKienGiamDoc = baoCaoKetQuaCuocHop.getYkienGiamdoc();
        fileBaoCao = baoCaoKetQuaCuocHop.getFileBaocao();
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess(DetailGiayMoi detailGiayMoi) {
        recyclerTrinhTuXuLy((ArrayList<TrinhTuGiaiQuyetGiayMoi>) detailGiayMoi.getTrinhTuGiaiQuyets());
        tvLoaiVanban.setText(String.valueOf(detailGiayMoi.getLoaiVanban()));
        ngay.setText(String.valueOf(detailGiayMoi.getNgayNhan()));
        soden.setText(String.valueOf(detailGiayMoi.getSoDen()));
        skh.setText(String.valueOf(detailGiayMoi.getSoKyhieu()));
        noigui.setText(String.valueOf(detailGiayMoi.getNoiGuiDen()));
        tvTrichYeu.setText(String.valueOf(detailGiayMoi.getTrichYeu()));
        tvDiaDiem.setText(String.valueOf("Vào hồi "
                + detailGiayMoi.getGiayMoiGio() + " ngày "
                + detailGiayMoi.getGiayMoiNgay() + ", tại "
                + detailGiayMoi.getGiayDiaDiem()));
    }

    @Override
    public void onGetNguoiKySuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {

    }

    @Override
    public void duyettuchoibaocaokequacuochopSuccess() {

    }

    @Override
    public void chuyenTiepKeQuaBaoCaoCuocHopSuccess() {

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
                    Intent intent = new Intent(NDVBBaoCaoKetQuaCuocHopMoiActivity.this, TTVBBaoCaoKetQuaCuocHopMoiActivity.class);
                    intent.putExtra("ID_VANBANBCKQCHMOI", id);
                    startActivity(intent);
                    click = true;
                }

                break;
            case R.id.btnChiTiet:
                builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.dialog_chi_tiet, null);
                builder.setView(view1);
                Dialog dialog1 = builder.create();
                Objects.requireNonNull(dialog1.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                HtmlTextView tvDeXuatCuaPhong = view1.findViewById(R.id.tvDeXuatCuaPhong);
                HtmlTextView tvKetLuanCuocHop = view1.findViewById(R.id.tvKetLuanCuocHop);
                TextView tvYKienGiamDoc = view1.findViewById(R.id.tvYKienGiamDoc);
                TextView tvFileBaoCao = view1.findViewById(R.id.tvFileBaoCao);
                tvFileBaoCao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(fileBaoCao));
                            startActivity(browserIntent);
                        } catch (Exception e) {
                            Toast.makeText(NDVBBaoCaoKetQuaCuocHopMoiActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                tvDeXuatCuaPhong.setHtml(deXuatPhong, new HtmlAssetsImageGetter(tvDeXuatCuaPhong));
                tvKetLuanCuocHop.setHtml(ketLuanCuocHop, new HtmlAssetsImageGetter(tvKetLuanCuocHop));
                tvYKienGiamDoc.setText(yKienGiamDoc);
                dialog1.show();
                break;
        }
    }

    void recyclerTrinhTuXuLy(ArrayList<TrinhTuGiaiQuyetGiayMoi> trinhTuGiaiQuyetArrayList) {
        adapterTrinhTuXuLyDonThu = new AdapterTrinhTuXuLyGiayMoi(this, trinhTuGiaiQuyetArrayList);
        LinearLayoutManager layoutManagerTrinhTuXuLy = new LinearLayoutManager(this);
        layoutManagerTrinhTuXuLy.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTXL.setLayoutManager(layoutManagerTrinhTuXuLy);
        rcvTTXL.setAdapter(adapterTrinhTuXuLyDonThu);
        adapterTrinhTuXuLyDonThu.notifyDataSetChanged();
    }

    void recyclerviewBaoCaoKQCuocHop(ArrayList<String> stringArrayList) {
        adapterBaoCaoKetQuaCuocHop = new AdapterBaoCaoKetQuaCuocHop(stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvBaoCaoGuiCacPhong.setLayoutManager(linearLayoutManager);
        rcvBaoCaoGuiCacPhong.setAdapter(adapterBaoCaoKetQuaCuocHop);
        adapterBaoCaoKetQuaCuocHop.notifyDataSetChanged();
    }

    @Override
    public NDVBBaoCaoKetQuaCuocHop_Presenter createPresenter() {
        return new NDVB_BaoCaoKetQuaCuocHopPresenterImpl(this);
    }
}
