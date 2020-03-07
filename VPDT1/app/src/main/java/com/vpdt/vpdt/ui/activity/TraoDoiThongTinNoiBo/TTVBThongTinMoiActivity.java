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
import com.vpdt.vpdt.model.CanBoByidPhongBan;
import com.vpdt.vpdt.model.FileDinhKem;
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.model.TraoDoiThongTinNoiBoDetail;
import com.vpdt.vpdt.model.VanBanTraLoi;
import com.vpdt.vpdt.model.YkienPhanHoi;
import com.vpdt.vpdt.presenter.TTVBThongTinMoiPresenter;
import com.vpdt.vpdt.presenter.TTVBThongTinMoiView;
import com.vpdt.vpdt.presenter.impl.TTVBThongTinMoiPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterCacFileDinhKem;
import com.vpdt.vpdt.ui.adapter.AdapterVanBanTraLoi;
import com.vpdt.vpdt.ui.adapter.AdapterYkienTraLoi;
import com.vpdt.vpdt.util.Util;

import org.sufficientlysecure.htmltextview.HtmlAssetsImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTVBThongTinMoiActivity extends BaseActivity<TTVBThongTinMoiPresenter> implements TTVBThongTinMoiView,
        AdapterCacFileDinhKem.OnItemClickListenerFileDinhKem {

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
    @BindView(R.id.lnYKienPhanHoi)
    LinearLayout lnYKienPhanHoi;

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
    @BindView(R.id.rcvDSCacVBTraLoi)
    RecyclerView rcvDSCacVBTraLoi;
    @BindView(R.id.rcvDSYKienTraLoi)
    RecyclerView rcvDSYKienTraLoi;

    private AdapterCacFileDinhKem adapterTepTinDinhKemVanBanDi;
    private AdapterVanBanTraLoi adapterVanBanTraLoi;
    private AdapterYkienTraLoi adapterYkienTraLoi;

    int idvb;
    int hien = 1;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ttvbthong_tin_moi;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("ThongTinMoi")) {
                idvb = intent.getIntExtra("ThongTinMoi", 0);
                getPresenter().getdetailvanbanbyidThongTinNoiBo(idvb);

            }
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess(TraoDoiThongTinNoiBoDetail traoDoiThongTinNoiBoDetail) {
        RecyclerViewFileDinhKem((ArrayList<FileDinhKem>) traoDoiThongTinNoiBoDetail.getFileDinhKems());
        RecyclerViewVanBanTraLoi((ArrayList<VanBanTraLoi>) traoDoiThongTinNoiBoDetail.getVanBanTraLois());
        RecyclerViewYkien((ArrayList<YkienPhanHoi>) traoDoiThongTinNoiBoDetail.getYkienPhanHois());
        tvNgayNhan.setText(String.valueOf(traoDoiThongTinNoiBoDetail.getNgayNhap()));
        tvSoKyHieu.setText(String.valueOf(traoDoiThongTinNoiBoDetail.getSoKyhieu()));
        tvLoaiVanBan.setText(String.valueOf(traoDoiThongTinNoiBoDetail.getLoaiVanban()));
        tvNguoiNhap.setText(String.valueOf(traoDoiThongTinNoiBoDetail.getNguoiNhap()));
        tvNgayKy.setText(String.valueOf(traoDoiThongTinNoiBoDetail.getNgayKy()));
        tvYKienChiDao.setHtml(traoDoiThongTinNoiBoDetail.getYkienChidao(), new HtmlAssetsImageGetter(tvYKienChiDao));
        tvNguoiKy.setText(String.valueOf(traoDoiThongTinNoiBoDetail.getNguoiKy()));
        tvChuThich.setText(String.valueOf(traoDoiThongTinNoiBoDetail.getGhiChu()));
        tvTrichYeu.setText(String.valueOf(traoDoiThongTinNoiBoDetail.getTrichYeu()));
    }

    @Override
    public void onGetPhongBanSuccess(ArrayList<PhongBan> phongBan) {

    }

    @Override
    public void onGetCanBoByIdPhongBanSuccess(ArrayList<CanBoByidPhongBan> canBoByidPhongBans) {

    }

    @OnClick({R.id.imvBack, R.id.tvThongTinGiayMoi,
            R.id.tvDSCacFileDinhKem, R.id.tvDSCacVBTraLoi,
            R.id.tvDSYKienTraLoi, R.id.btnYKienPhanHoi, R.id.btnChuyenTiep, R.id.btnThemMoi})
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
            case R.id.btnYKienPhanHoi:
                if (hien == 1) {
                    lnYKienPhanHoi.setVisibility(View.VISIBLE);
                    hien = 0;
                } else {
                    lnYKienPhanHoi.setVisibility(View.GONE);
                    hien = 1;
                }
                break;
            case R.id.btnChuyenTiep:
                Intent intent = new Intent(this, ChuyenTiepActivity.class);
                startActivity(intent);
                break;
            case R.id.btnThemMoi:
                Toast.makeText(this, "Chức năng đang phát triển", Toast.LENGTH_SHORT).show();

//                lnYKienPhanHoi.setVisibility(View.GONE);
//                hien = 1;
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

    void RecyclerViewFileDinhKem(ArrayList<FileDinhKem> trinhTuGiaiQuyets) {
        adapterTepTinDinhKemVanBanDi = new AdapterCacFileDinhKem(this, trinhTuGiaiQuyets, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvDSCacFileDinhKem.setLayoutManager(layoutManager);
        rcvDSCacFileDinhKem.setAdapter(adapterTepTinDinhKemVanBanDi);
        adapterTepTinDinhKemVanBanDi.notifyDataSetChanged();
    }

    void RecyclerViewVanBanTraLoi(ArrayList<VanBanTraLoi> vanBanTraLoiArrayList) {
        adapterVanBanTraLoi = new AdapterVanBanTraLoi(this, vanBanTraLoiArrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvDSCacVBTraLoi.setLayoutManager(layoutManager);
        rcvDSCacVBTraLoi.setAdapter(adapterVanBanTraLoi);
        adapterVanBanTraLoi.notifyDataSetChanged();
    }

    void RecyclerViewYkien(ArrayList<YkienPhanHoi> ykienPhanHoiArrayList) {
        adapterYkienTraLoi = new AdapterYkienTraLoi(this, ykienPhanHoiArrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvDSYKienTraLoi.setLayoutManager(layoutManager);
        rcvDSYKienTraLoi.setAdapter(adapterVanBanTraLoi);
        adapterVanBanTraLoi.notifyDataSetChanged();
    }

    @Override
    public TTVBThongTinMoiPresenter createPresenter() {
        return new TTVBThongTinMoiPresenterImpl(this);
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
}
