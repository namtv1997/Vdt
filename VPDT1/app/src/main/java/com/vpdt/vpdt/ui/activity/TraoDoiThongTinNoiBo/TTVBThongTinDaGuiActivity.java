package com.vpdt.vpdt.ui.activity.TraoDoiThongTinNoiBo;

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
import com.vpdt.vpdt.model.DetailVanBanGuiDi;
import com.vpdt.vpdt.model.DonViCanNhanVanban;
import com.vpdt.vpdt.model.FileDinhKem;
import com.vpdt.vpdt.model.YkienPhanHoi;
import com.vpdt.vpdt.presenter.TTVBThongTinDaGuiPresenter;
import com.vpdt.vpdt.presenter.TTVBThongTinDaGuiView;
import com.vpdt.vpdt.presenter.impl.TTVBThongTinDaGuiPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterCacFileDinhKem;
import com.vpdt.vpdt.ui.adapter.AdapterDonViCanNhanVanBan;
import com.vpdt.vpdt.ui.adapter.AdapterYkienTraLoi;
import com.vpdt.vpdt.util.Util;

import org.sufficientlysecure.htmltextview.HtmlAssetsImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTVBThongTinDaGuiActivity extends BaseActivity<TTVBThongTinDaGuiPresenter> implements TTVBThongTinDaGuiView, AdapterCacFileDinhKem.OnItemClickListenerFileDinhKem {

    @BindView(R.id.imDownThongTinVanBan)
    ImageView imDownThongTinVanBan;
    @BindView(R.id.imUpThongTinVanBan)
    ImageView imUpThongTinVanBan;

    @BindView(R.id.imDownDSCacFileDinhKem)
    ImageView imDownDSCacFileDinhKem;
    @BindView(R.id.imUpDSCacFileDinhKem)
    ImageView imUpDSCacFileDinhKem;

    @BindView(R.id.imDownDSCacVBTraLoi)
    ImageView imDownDSCacVBTraLoi;
    @BindView(R.id.imUpDSCacVBTraLoi)
    ImageView imUpDSCacVBTraLoi;

    @BindView(R.id.imDownDSYKienTraLoi)
    ImageView imDownDSYKienTraLoi;
    @BindView(R.id.imUpDSYKienTraLoi)
    ImageView imUpDSYKienTraLoi;

    @BindView(R.id.lnThongTinVanBan)
    LinearLayout lnThongTinVanBan;
    @BindView(R.id.lnDSCacFileDinhKem)
    LinearLayout lnDSCacFileDinhKem;
    @BindView(R.id.lnDSCacVBTraLoi)
    LinearLayout lnDSCacVBTraLoi;
    @BindView(R.id.lnDSYKienTraLoi)
    LinearLayout lnDSYKienTraLoi;


    @BindView(R.id.tvNgayNhan)
    TextView tvNgayNhan;
    @BindView(R.id.tvNguoiNhap)
    TextView tvNguoiNhap;
    @BindView(R.id.tvSoKyHieu)
    TextView tvSoKyHieu;
    @BindView(R.id.tvNguoiKy)
    TextView tvNguoiKy;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvYKienChiDao)
    HtmlTextView tvYKienChiDao;
    @BindView(R.id.tvChuThich)
    TextView tvChuThich;
    @BindView(R.id.tvNgayKy)
    TextView tvNgayKy;
    @BindView(R.id.tvLoaiVanBan)
    TextView tvLoaiVanBan;

    @BindView(R.id.rcvDSCacFileDinhKem)
    RecyclerView rcvDSCacFileDinhKem;
    @BindView(R.id.rcvDSYKienTraLoi)
    RecyclerView rcvDSYKienTraLoi;
    @BindView(R.id.rvDonViCanNhan)
    RecyclerView rvDonViCanNhan;

    private AdapterCacFileDinhKem adapterTepTinDinhKemVanBanDi;
    private AdapterDonViCanNhanVanBan adapterDonViCanNhanVanBan;
    private AdapterYkienTraLoi adapterYkienTraLoi;


    int idvb;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ttvbthong_tin_da_gui;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("TTVBThongTinDaGui")) {
                idvb = intent.getIntExtra("TTVBThongTinDaGui", 0);
                getPresenter().getvanbanguidibyid(idvb);

            }
        }
    }

    @OnClick({R.id.imvBack, R.id.tvThongTinGiayMoi, R.id.btnSuaLai,
            R.id.tvDSCacFileDinhKem, R.id.tvDSCacVBTraLoi,
            R.id.tvDSYKienTraLoi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imvBack:
                finish();
                break;
            case R.id.tvThongTinGiayMoi:
                Expand(lnThongTinVanBan, imUpThongTinVanBan, imDownThongTinVanBan);
                break;
            case R.id.tvDSCacFileDinhKem:
                Expand(lnDSCacFileDinhKem, imUpDSCacFileDinhKem, imDownDSCacFileDinhKem);
                break;
            case R.id.tvDSCacVBTraLoi:
                Expand(lnDSCacVBTraLoi, imUpDSCacVBTraLoi, imDownDSCacVBTraLoi);
                break;
            case R.id.tvDSYKienTraLoi:
                Expand(lnDSYKienTraLoi, imUpDSYKienTraLoi, imDownDSYKienTraLoi);
                break;
            case R.id.btnSuaLai:
                Toast.makeText(this, "Chức năng đang hoàn thiện!", Toast.LENGTH_SHORT).show();
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
    public void onGetDataSuccess(DetailVanBanGuiDi detailVanBanGuiDi) {
        RecyclerViewFileDinhKem((ArrayList<FileDinhKem>) detailVanBanGuiDi.getFileDinhKems());
        RecyclerViewDonViCanNhanVanBan((ArrayList<DonViCanNhanVanban>) detailVanBanGuiDi.getDonViCanNhanVanbans());
        RecyclerViewYkien((ArrayList<YkienPhanHoi>) detailVanBanGuiDi.getYkienPhanHois());
        tvNgayNhan.setText(String.valueOf(detailVanBanGuiDi.getNgayNhap()));
        tvSoKyHieu.setText(String.valueOf(detailVanBanGuiDi.getSoKyhieu()));
        tvLoaiVanBan.setText(String.valueOf(detailVanBanGuiDi.getLoaiVanban()));
        tvNguoiNhap.setText(String.valueOf(detailVanBanGuiDi.getNguoiNhap()));
        tvNgayKy.setText(String.valueOf(detailVanBanGuiDi.getNgayKy()));
        tvYKienChiDao.setHtml(detailVanBanGuiDi.getYkienChidao(), new HtmlAssetsImageGetter(tvYKienChiDao));
        tvNguoiKy.setText(String.valueOf(detailVanBanGuiDi.getNguoiKy()));
        tvChuThich.setText(String.valueOf(detailVanBanGuiDi.getGhiChu()));
        tvTrichYeu.setText(String.valueOf(detailVanBanGuiDi.getTrichYeu()));
    }

    @Override
    public TTVBThongTinDaGuiPresenter createPresenter() {
        return new TTVBThongTinDaGuiPresenterImpl(this);
    }

    @Override
    public void onItemClickFileDinhKem(FileDinhKem fileDinhKem) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(fileDinhKem.getDuongDan()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }


    void RecyclerViewFileDinhKem(ArrayList<FileDinhKem> trinhTuGiaiQuyets) {
        adapterTepTinDinhKemVanBanDi = new AdapterCacFileDinhKem(this, trinhTuGiaiQuyets, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvDSCacFileDinhKem.setLayoutManager(layoutManager);
        rcvDSCacFileDinhKem.setAdapter(adapterTepTinDinhKemVanBanDi);
        adapterTepTinDinhKemVanBanDi.notifyDataSetChanged();
    }

    void RecyclerViewYkien(ArrayList<YkienPhanHoi> ykienPhanHoiArrayList) {
        adapterYkienTraLoi = new AdapterYkienTraLoi(this, ykienPhanHoiArrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvDSYKienTraLoi.setLayoutManager(layoutManager);
        rcvDSYKienTraLoi.setAdapter(adapterYkienTraLoi);
        adapterYkienTraLoi.notifyDataSetChanged();
    }

    void RecyclerViewDonViCanNhanVanBan(ArrayList<DonViCanNhanVanban> donViCanNhanVanbanArrayList) {
        adapterDonViCanNhanVanBan = new AdapterDonViCanNhanVanBan(this, donViCanNhanVanbanArrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvDonViCanNhan.setLayoutManager(layoutManager);
        rvDonViCanNhan.setAdapter(adapterDonViCanNhanVanBan);
        adapterDonViCanNhanVanBan.notifyDataSetChanged();
    }
}
