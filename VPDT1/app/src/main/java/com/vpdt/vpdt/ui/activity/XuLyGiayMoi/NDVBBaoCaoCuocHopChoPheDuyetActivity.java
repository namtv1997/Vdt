package com.vpdt.vpdt.ui.activity.XuLyGiayMoi;

import android.annotation.SuppressLint;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.BaoCaoCuocHopChoPheDuyet;
import com.vpdt.vpdt.presenter.NDVBBaoCaoCuocHopChoPheDuyetPresenter;
import com.vpdt.vpdt.presenter.NDVBBaoCaoCuocHopChoPheDuyetView;
import com.vpdt.vpdt.presenter.impl.NDVBBaoCaoCuocHopChoPheDuyetPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterBaoCaoKetQuaCuocHop;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.Util;

import org.sufficientlysecure.htmltextview.HtmlAssetsImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBBaoCaoCuocHopChoPheDuyetActivity extends BaseActivity<NDVBBaoCaoCuocHopChoPheDuyetPresenter> implements NDVBBaoCaoCuocHopChoPheDuyetView {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvNoiGui)
    TextView tvNoiGui;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvVaoHoi)
    TextView tvVaoHoi;
    @BindView(R.id.tvYKienGiamDoc)
    TextView tvYKienGiamDoc;

    @BindView(R.id.rcvBaoCaoGuiCacPhong)
    RecyclerView rcvBaoCaoGuiCacPhong;
    @BindView(R.id.rvTrinhTuXuLy)
    RecyclerView rvTrinhTuXuLy;

    EditText edtNoiDungTuChoi;
    AlertDialog dialog;

    boolean click = false;
    int idvb;
    String idNoiDung, filebaocao, deXuatCuaPhong, ketLuanCuocHop, yKienGiamDoc;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;
    AdapterBaoCaoKetQuaCuocHop adapterBaoCaoKetQuaCuocHop;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbbao_cao_cuoc_hop_cho_phe_duyet;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        BaoCaoCuocHopChoPheDuyet baoCaoCuocHopChoPheDuyet = getIntent().getParcelableExtra("baoCaoCuocHopChoPheDuyet");
        if (baoCaoCuocHopChoPheDuyet != null) {
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) baoCaoCuocHopChoPheDuyet.getTrinhTuXuLy());
            recyclerviewBaoCaoKQCuocHop((ArrayList<String>) baoCaoCuocHopChoPheDuyet.getBaoCaoGuiCacPhongs());
            idvb = baoCaoCuocHopChoPheDuyet.getId();
            idNoiDung = baoCaoCuocHopChoPheDuyet.getIdNoiDungDeXuat();
            filebaocao = baoCaoCuocHopChoPheDuyet.getFileBaoCao();
            deXuatCuaPhong = baoCaoCuocHopChoPheDuyet.getNoiDungDeXuat();
            ketLuanCuocHop = baoCaoCuocHopChoPheDuyet.getMieuTa();
            yKienGiamDoc = baoCaoCuocHopChoPheDuyet.getYKienGiamDoc();
            tvSKH.setText(String.valueOf(baoCaoCuocHopChoPheDuyet.getSoKyHieu()));

            tvNoiGui.setText(String.valueOf(baoCaoCuocHopChoPheDuyet.getNoiGui()));
            tvNgay.setText(baoCaoCuocHopChoPheDuyet.getNgayNhap());
            tvSoDen.setText(String.valueOf(baoCaoCuocHopChoPheDuyet.getSoDen()));
            tvYKienGiamDoc.setText("Ý kiến Giám đốc từ chối trước khi chỉnh sửa: " + baoCaoCuocHopChoPheDuyet.getYKienGiamDoc());
            tvTrichYeu.setText(String.valueOf(baoCaoCuocHopChoPheDuyet.getMoTa() + "." + baoCaoCuocHopChoPheDuyet.getNoiDung()));
            if (!baoCaoCuocHopChoPheDuyet.getGiayMoiGio().isEmpty() && !baoCaoCuocHopChoPheDuyet.getGiayMoiNgay().isEmpty() && !baoCaoCuocHopChoPheDuyet.getGiayMoiDiaDiem().isEmpty()) {
                tvVaoHoi.setText("Vào hồi " + baoCaoCuocHopChoPheDuyet.getGiayMoiGio() + "ngày " + baoCaoCuocHopChoPheDuyet.getGiayMoiNgay() + ", tại " + baoCaoCuocHopChoPheDuyet.getGiayMoiDiaDiem());
            }
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.tvXemChiTiet, R.id.btnBack, R.id.btnTuChoi, R.id.btnDuyet, R.id.btnChiTiet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBBaoCaoCuocHopChoPheDuyetActivity.class);
                    intent.putExtra("idvb", idvb);
                    startActivity(intent);
                    click = true;
                }
                break;
            case R.id.btnBack:
                finish();

                break;
            case R.id.btnTuChoi:
                AlertDialog.Builder buildertuchoi = new AlertDialog.Builder(this);
                LayoutInflater inflatertuchoi = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewtuchoi = inflatertuchoi.inflate(R.layout.dialog_tuchoibaocao, null);
                buildertuchoi.setView(viewtuchoi);
                dialog = buildertuchoi.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                edtNoiDungTuChoi = viewtuchoi.findViewById(R.id.edtNoiDungTuChoi);
                Button btnDong1 = viewtuchoi.findViewById(R.id.btnDong);
                Button btnChuyenChanhVanBan = viewtuchoi.findViewById(R.id.btnChuyenChanhVanBan);
                btnDong1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btnChuyenChanhVanBan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().tuChoiBaoCaoCuocHopChoDuyet(idvb, edtNoiDungTuChoi.getText().toString(), idNoiDung);
                    }
                });
                dialog.show();
                break;
            case R.id.btnDuyet:
                getPresenter().duyetBaoCaoCuocHopChoDuyet(idvb, idNoiDung);
                break;

            case R.id.btnChiTiet:
                AlertDialog.Builder builderChiTiet = new AlertDialog.Builder(this);
                LayoutInflater inflaterChiTiet = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewChiTiet = inflaterChiTiet.inflate(R.layout.dialog_chi_tiet1, null);
                builderChiTiet.setView(viewChiTiet);
                dialog = builderChiTiet.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Button btnDong = viewChiTiet.findViewById(R.id.btnDong);
                HtmlTextView tvDeXuatCuaPhong = viewChiTiet.findViewById(R.id.tvDeXuatCuaPhong);
                HtmlTextView tvKetLuanCuocHop = viewChiTiet.findViewById(R.id.tvKetLuanCuocHop);
                TextView tvFileBaoCao = viewChiTiet.findViewById(R.id.tvFileBaoCao);
                TextView tvYKienGiamDoc1 = viewChiTiet.findViewById(R.id.tvYKienGiamDoc);
                tvDeXuatCuaPhong.setHtml(deXuatCuaPhong, new HtmlAssetsImageGetter(tvDeXuatCuaPhong));
                tvKetLuanCuocHop.setHtml(ketLuanCuocHop, new HtmlAssetsImageGetter(tvKetLuanCuocHop));
                tvYKienGiamDoc1.setText(yKienGiamDoc);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                tvFileBaoCao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(filebaocao));
                            startActivity(browserIntent);
                        } catch (Exception e) {
                            Toast.makeText(NDVBBaoCaoCuocHopChoPheDuyetActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.show();
                break;

        }
    }

    @Override
    public void duyetBaoCaoCuocHopChoDuyetSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void tuChoiBaoCaoCuocHopChoDuyetSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NDVBBaoCaoCuocHopChoPheDuyetPresenter createPresenter() {
        return new NDVBBaoCaoCuocHopChoPheDuyetPresenterImpl(this);
    }

    void recyclerviewTrinhTuChuyenNhan(ArrayList<String> stringArrayList) {
        adapterDeXuatGiaHanChoXuLy = new AdapterDeXuatGiaHanChoXuLy(stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvTrinhTuXuLy.setLayoutManager(linearLayoutManager);
        rvTrinhTuXuLy.setAdapter(adapterDeXuatGiaHanChoXuLy);
        adapterDeXuatGiaHanChoXuLy.notifyDataSetChanged();
    }

    void recyclerviewBaoCaoKQCuocHop(ArrayList<String> stringArrayList) {
        adapterBaoCaoKetQuaCuocHop = new AdapterBaoCaoKetQuaCuocHop(stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvBaoCaoGuiCacPhong.setLayoutManager(linearLayoutManager);
        rcvBaoCaoGuiCacPhong.setAdapter(adapterBaoCaoKetQuaCuocHop);
        adapterBaoCaoKetQuaCuocHop.notifyDataSetChanged();
    }

}
