package com.vpdt.vpdt.ui.activity.VanBanDi;

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
import com.vpdt.vpdt.model.DetailVanBanDi;
import com.vpdt.vpdt.model.QuaTrinhXuly;
import com.vpdt.vpdt.model.SoDen;
import com.vpdt.vpdt.model.TepDinhKemVanBanDi;
import com.vpdt.vpdt.presenter.TTVBVanBanTrinhKyPresenter;
import com.vpdt.vpdt.presenter.TTVBVanBanTrinhKyView;
import com.vpdt.vpdt.presenter.impl.TTVBVanBanTrinhKyPresenterImpl;
import com.vpdt.vpdt.ui.activity.VanBanDen.TTVBBaoCaoTongHopActivity;
import com.vpdt.vpdt.ui.adapter.AdapterQuaTrinhXuLy;
import com.vpdt.vpdt.ui.adapter.AdapterSoDen;
import com.vpdt.vpdt.ui.adapter.AdapterTepTinDinhKemVanBanDi;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TTVBVanBanTrinhKyActivity extends BaseActivity<TTVBVanBanTrinhKyPresenter> implements TTVBVanBanTrinhKyView,
        AdapterTepTinDinhKemVanBanDi.OnItemClickListener, AdapterSoDen.OnItemClickListener {

    @BindView(R.id.imDownThongTinVanBan)
    ImageView imDownThongTinVanBan;
    @BindView(R.id.imUpThongTinVanBan)
    ImageView imUpThongTinVanBan;

    @BindView(R.id.imDownLaVBDauRaCuaVBDenSo)
    ImageView imDownLaVBDauRaCuaVBDenSo;
    @BindView(R.id.imUpLaVBDauRaCuaVBDenSo)
    ImageView imUpLaVBDauRaCuaVBDenSo;

    @BindView(R.id.imDownQuaTrinhXuLyVanBanChinh)
    ImageView imDownQuaTrinhXuLyVanBanChinh;
    @BindView(R.id.imUpQuaTrinhXuLyVanBanChinh)
    ImageView imUpQuaTrinhXuLyVanBanChinh;

    @BindView(R.id.imDownTepDinhKem)
    ImageView imDownTepDinhKem;
    @BindView(R.id.imUpTepDinhKem)
    ImageView imUpTepDinhKem;

    @BindView(R.id.lnThongTinVanBan)
    LinearLayout lnThongTinVanBan;
    @BindView(R.id.lnLaVBDauRaCuaVBDenSo)
    LinearLayout lnLaVBDauRaCuaVBDenSo;
    @BindView(R.id.lnQuaTrinhXuLyVanBanChinh)
    LinearLayout lnQuaTrinhXuLyVanBanChinh;
    @BindView(R.id.lnTepDinhKem)
    LinearLayout lnTepDinhKem;

    @BindView(R.id.tvNoiNhan)
    TextView tvNoiNhan;
    @BindView(R.id.tvSoKyHieu)
    TextView tvSoKyHieu;
    @BindView(R.id.tvLoaiVanBan)
    TextView tvLoaiVanBan;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvNguoiKy)
    TextView tvNguoiKy;
    @BindView(R.id.tvChuY)
    TextView tvChuY;
    @BindView(R.id.tvSoVanBan)
    TextView tvSoVanBan;
    @BindView(R.id.tvNgayKy)
    TextView tvNgayKy;
    @BindView(R.id.tvLinhVuc)
    TextView tvLinhVuc;

    @BindView(R.id.rcvLaVBDauRaCuaVBDenSo)
    RecyclerView rcvLaVBDauRaCuaVBDenSo;
    @BindView(R.id.rcvQuaTrinhXuLyVanBanChinh)
    RecyclerView rcvQuaTrinhXuLyVanBanChinh;
    @BindView(R.id.rcvTTDKTTVB)
    RecyclerView rcvTTDKTTVB;

    @BindView(R.id.rlLaVanBanDauRaCuaVBDenSo)
    RelativeLayout rlLaVanBanDauRaCuaVBDenSo;

    private AdapterTepTinDinhKemVanBanDi adapterTepTinDinhKemVanBanDi;
    private AdapterQuaTrinhXuLy adapterQuaTrinhXuLy;
    private AdapterSoDen adapterSoDen;

    int idvb;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ttvbvan_ban_trinh_ky;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("ID_VANBAN_DI")) {
                idvb = intent.getIntExtra("ID_VANBAN_DI", 0);
                getPresenter().getdetailvanbanbyid(idvb);

            }
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @OnClick({R.id.imvBack, R.id.tvThongTinVanBan,
            R.id.tvLaVBDauRaCuaVBDenSo, R.id.tvQuaTrinhXuLyVanBanChinh,
            R.id.tvTepDinhKem})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imvBack:
                finish();
                break;
            case R.id.tvThongTinVanBan:
                Expand(lnThongTinVanBan, imUpThongTinVanBan, imDownThongTinVanBan);
                break;
            case R.id.tvLaVBDauRaCuaVBDenSo:
                Expand(lnLaVBDauRaCuaVBDenSo, imUpLaVBDauRaCuaVBDenSo, imDownLaVBDauRaCuaVBDenSo);
                break;
            case R.id.tvQuaTrinhXuLyVanBanChinh:
                Expand(lnQuaTrinhXuLyVanBanChinh, imUpQuaTrinhXuLyVanBanChinh, imDownQuaTrinhXuLyVanBanChinh);
                break;
            case R.id.tvTepDinhKem:
                Expand(lnTepDinhKem, imUpTepDinhKem, imDownTepDinhKem);
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
    public void onGetDataSuccess(DetailVanBanDi detailVanBanDi) {
        RecyclerViewTepTinDinhKemVanBanDi((ArrayList<TepDinhKemVanBanDi>) detailVanBanDi.getTepDinhKems());
        RecyclerViewQuaTrinhXuLy((ArrayList<QuaTrinhXuly>) detailVanBanDi.getQuaTrinhXulys());
        RecyclerViewSoDen((ArrayList<SoDen>) detailVanBanDi.getSoDens());
        tvNoiNhan.setText(String.valueOf(detailVanBanDi.getNoiNhan()));
        tvSoKyHieu.setText(String.valueOf(detailVanBanDi.getSoKyhieu()));
        tvLoaiVanBan.setText(String.valueOf(detailVanBanDi.getLoaiVanban()));
        tvLinhVuc.setText(String.valueOf(detailVanBanDi.getLinhVuc()));
        tvNgayKy.setText(String.valueOf(detailVanBanDi.getNgayKy()));
        tvSoVanBan.setText(String.valueOf(detailVanBanDi.getSoVanban()));
        tvNguoiKy.setText(String.valueOf(detailVanBanDi.getNguoiKy()));
        tvChuY.setText(String.valueOf(detailVanBanDi.getGhiChu()));
        tvTrichYeu.setText(String.valueOf(detailVanBanDi.getMoTa()));
        if (detailVanBanDi.getSoDens().size() == 0) {
            rlLaVanBanDauRaCuaVBDenSo.setVisibility(View.GONE);
        }
    }

    void RecyclerViewQuaTrinhXuLy(ArrayList<QuaTrinhXuly> quaTrinhXulyArrayList) {
        adapterQuaTrinhXuLy = new AdapterQuaTrinhXuLy(this, quaTrinhXulyArrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvQuaTrinhXuLyVanBanChinh.setLayoutManager(layoutManager);
        rcvQuaTrinhXuLyVanBanChinh.setAdapter(adapterQuaTrinhXuLy);
        adapterQuaTrinhXuLy.notifyDataSetChanged();
    }

    void RecyclerViewTepTinDinhKemVanBanDi(ArrayList<TepDinhKemVanBanDi> trinhTuGiaiQuyets) {
        adapterTepTinDinhKemVanBanDi = new AdapterTepTinDinhKemVanBanDi(this, trinhTuGiaiQuyets, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTDKTTVB.setLayoutManager(layoutManager);
        rcvTTDKTTVB.setAdapter(adapterTepTinDinhKemVanBanDi);
        adapterTepTinDinhKemVanBanDi.notifyDataSetChanged();
    }

    void RecyclerViewSoDen(ArrayList<SoDen> soDenArrayList) {
        adapterSoDen = new AdapterSoDen(this, soDenArrayList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvLaVBDauRaCuaVBDenSo.setLayoutManager(layoutManager);
        rcvLaVBDauRaCuaVBDenSo.setAdapter(adapterSoDen);
        adapterSoDen.notifyDataSetChanged();
    }

    @Override
    public TTVBVanBanTrinhKyPresenter createPresenter() {
        return new TTVBVanBanTrinhKyPresenterImpl(this);
    }


    @Override
    public void onItemClick(TepDinhKemVanBanDi tepDinhKemVanBanDi) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(tepDinhKemVanBanDi.getDuongDan()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(SoDen soDen) {
        Intent intent = new Intent(this, TTVBBaoCaoTongHopActivity.class);
        intent.putExtra("ID_VANBAN_DI", String.valueOf(soDen));
        startActivity(intent);
    }
}
