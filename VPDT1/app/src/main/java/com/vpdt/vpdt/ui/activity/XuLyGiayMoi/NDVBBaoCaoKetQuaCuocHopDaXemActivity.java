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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
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
import com.vpdt.vpdt.ui.adapter.AdapterChonChuyenVienPhoiHop;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuXuLyGiayMoi;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import org.sufficientlysecure.htmltextview.HtmlAssetsImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBBaoCaoKetQuaCuocHopDaXemActivity extends BaseActivity<NDVBBaoCaoKetQuaCuocHop_Presenter> implements NDVBBaoCaoKetQuaCuocHopView,
        AdapterChonChuyenVienPhoiHop.OnItemClickListenerChonChuyenVien {

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

    @BindView(R.id.btnChuyenTiep)
    Button btnChuyenTiep;

    AdapterBaoCaoKetQuaCuocHop adapterBaoCaoKetQuaCuocHop;
    AdapterTrinhTuXuLyGiayMoi adapterTrinhTuXuLyDonThu;
    @BindView(R.id.rvTrinhTuXuLy)
    RecyclerView rcvTTXL;
    @BindView(R.id.rcvBaoCaoGuiCacPhong)
    RecyclerView rcvBaoCaoGuiCacPhong;

    AlertDialog.Builder builder;
    RecyclerView rcTenPhoPhong;
    int id, level, idNoiDung, id_vb;

    String deXuatPhong;
    String ketLuanCuocHop;
    String yKienGiamDoc;
    String fileBaoCao, idCanBoNhans;
    Dialog dialog;
    Dialog dialog1;
    boolean click = false;
    ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdocArrayList = new ArrayList<>();
    AdapterChonChuyenVienPhoiHop adapterChonChuyenVienPhoiHop;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbbao_cao_ket_qua_cuoc_hop_da_xem;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        getPresenter().getAllCanBoPhong();
        BaoCaoKetQuaCuocHop baoCaoKetQuaCuocHop = getIntent().getParcelableExtra("ID_VANBANBCKQCHDAXEM");
        if (baoCaoKetQuaCuocHop != null) {
            recyclerviewBaoCaoKQCuocHop((ArrayList<String>) baoCaoKetQuaCuocHop.getGuiPhongs());
            id = baoCaoKetQuaCuocHop.getId();
            idNoiDung = baoCaoKetQuaCuocHop.getIdNoidung();
            id_vb = baoCaoKetQuaCuocHop.getIdVb();
            getPresenter().getgiaymoibyid(id);
            soden.setText(String.valueOf(baoCaoKetQuaCuocHop.getSoDen()));
            skh.setText(String.valueOf(baoCaoKetQuaCuocHop.getSoKyhieu()));
            noigui.setText(String.valueOf(baoCaoKetQuaCuocHop.getNoiGui()));
            tvTrichYeu.setText(String.valueOf(baoCaoKetQuaCuocHop.getMota()));
            tvDiaDiem.setText(String.valueOf("Vào hồi "
                    + baoCaoKetQuaCuocHop.getGiayMoiGio() + " ngày "
                    + baoCaoKetQuaCuocHop.getGiayMoiNgay() + ", tại "
                    + baoCaoKetQuaCuocHop.getGiayMoiDiadiem()));
            if (!baoCaoKetQuaCuocHop.getDexuatPhong().isEmpty()) {
                deXuatPhong = baoCaoKetQuaCuocHop.getDexuatPhong();
            }
            if (baoCaoKetQuaCuocHop.getNoiDung() != null || !baoCaoKetQuaCuocHop.getNoiDung().isEmpty()) {
                ketLuanCuocHop = baoCaoKetQuaCuocHop.getNoiDung();
            }
            if (!baoCaoKetQuaCuocHop.getYkienGiamdoc().isEmpty()) {
                yKienGiamDoc = baoCaoKetQuaCuocHop.getYkienGiamdoc();
            }
            fileBaoCao = baoCaoKetQuaCuocHop.getFileBaocao();
        }
        level = PrefUtil.getInt(this, Key.LEVEL, 0);
        if (level == 6) {
            btnChuyenTiep.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess(DetailGiayMoi detailGiayMoi) {
        recyclerTrinhTuXuLy((ArrayList<TrinhTuGiaiQuyetGiayMoi>) detailGiayMoi.getTrinhTuGiaiQuyets());
        tvLoaiVanban.setText(String.valueOf(detailGiayMoi.getLoaiVanban()));
        ngay.setText(String.valueOf(detailGiayMoi.getGiayMoiNgay()));

    }

    @Override
    public void onGetNguoiKySuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterChonChuyenVienPhoiHop = new AdapterChonChuyenVienPhoiHop(giamdocVaPhoGiamdoc, this);
    }

    @Override
    public void duyettuchoibaocaokequacuochopSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void chuyenTiepKeQuaBaoCaoCuocHopSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack, R.id.tvXemChiTiet, R.id.btnChiTiet, R.id.btnChuyenTiep})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBBaoCaoCuocHopChoPheDuyetActivity.class);
                    intent.putExtra("idvb", id_vb);
                    startActivity(intent);
                    click = true;
                }

                break;
            case R.id.btnChiTiet:
                builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.dialog_chi_tiet, null);
                builder.setView(view1);
                dialog = builder.create();
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView tvDeXuatCuaPhong = view1.findViewById(R.id.tvDeXuatCuaPhong);
                HtmlTextView tvKetLuanCuocHop = view1.findViewById(R.id.tvKetLuanCuocHop);
                TextView tvYKienGiamDoc = view1.findViewById(R.id.tvYKienGiamDoc);
                TextView tvFileBaoCao = view1.findViewById(R.id.tvFileBaoCao);
                EditText etYKienCuaLanhDao = view1.findViewById(R.id.etYKienCuaLanhDao);
                Button btnTuChoi = view1.findViewById(R.id.btnTuChoi);
                Button btnDuyet = view1.findViewById(R.id.btnDuyet);
                btnTuChoi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().duyettuchoibaocaokequacuochop(id, idNoiDung, id_vb, etYKienCuaLanhDao.getText().toString(), 2);
                    }
                });
                btnDuyet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().duyettuchoibaocaokequacuochop(id, idNoiDung, id_vb, etYKienCuaLanhDao.getText().toString(), 1);
                    }
                });
                tvFileBaoCao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(fileBaoCao));
                            startActivity(browserIntent);
                        } catch (Exception e) {
                            Toast.makeText(NDVBBaoCaoKetQuaCuocHopDaXemActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                tvDeXuatCuaPhong.setText(deXuatPhong);
                tvKetLuanCuocHop.setHtml(ketLuanCuocHop, new HtmlAssetsImageGetter(tvKetLuanCuocHop));
                tvYKienGiamDoc.setText(yKienGiamDoc);
                dialog.show();
                break;
            case R.id.btnChuyenTiep:

                AlertDialog.Builder buildertuchoi = new AlertDialog.Builder(this);
                LayoutInflater inflatertuchoi = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewtuchoi = inflatertuchoi.inflate(R.layout.dialog_chuyentiep, null);
                buildertuchoi.setView(viewtuchoi);
                dialog = buildertuchoi.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView tvChonNguoiNhan = viewtuchoi.findViewById(R.id.tvChonNguoiNhan);
                EditText edtGhiChu = viewtuchoi.findViewById(R.id.edtGhiChu);
                Button btnDong = viewtuchoi.findViewById(R.id.btnDong);
                Button btnGui = viewtuchoi.findViewById(R.id.btnGui);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

                    }
                });
                btnGui.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().chuyenTiepKeQuaBaoCaoCuocHop(id, idNoiDung, id_vb, idCanBoNhans, edtGhiChu.getText().toString());
                    }
                });

                tvChonNguoiNhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builderphongphoihop = new AlertDialog.Builder(NDVBBaoCaoKetQuaCuocHopDaXemActivity.this);
                        LayoutInflater inflaterphongphoihop = (LayoutInflater) NDVBBaoCaoKetQuaCuocHopDaXemActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        final View viewphongphoihop = inflaterphongphoihop.inflate(R.layout.dialog_chon_phong_ban_phoi_hop, null);
                        builderphongphoihop.setView(viewphongphoihop);
                        dialog1 = builderphongphoihop.create();
                        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog1.show();
                        Button imgCancel = viewphongphoihop.findViewById(R.id.ivCancel);
                        Button btnGhiLai = viewphongphoihop.findViewById(R.id.btnGhiLai);

                        LinearLayoutManager layoutManagerPhoihop = new LinearLayoutManager(getApplicationContext());
                        layoutManagerPhoihop.setOrientation(LinearLayoutManager.VERTICAL);

                        rcTenPhoPhong = viewphongphoihop.findViewById(R.id.rcTenPhongPhoiHop);

                        rcTenPhoPhong.setLayoutManager(layoutManagerPhoihop);
                        rcTenPhoPhong.setAdapter(adapterChonChuyenVienPhoiHop);
                        adapterChonChuyenVienPhoiHop.notifyDataSetChanged();

                        imgCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog1.dismiss();
                            }
                        });
                        btnGhiLai.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                String chidao2 = "";
                                int index = 0;
                                idCanBoNhans = "";
                                for (GiamdocVaPhoGiamdoc item : giamdocVaPhoGiamdocArrayList) {
                                    index++;
                                    if (index == giamdocVaPhoGiamdocArrayList.size()) {
                                        idCanBoNhans += item.getId();
                                        chidao2 += item.getHoTen() + ".";
                                    } else {
                                        idCanBoNhans += item.getId() + ",";
                                        chidao2 += item.getHoTen() + ", ";
                                    }
                                }
                                tvChonNguoiNhan.setText(chidao2);
                                giamdocVaPhoGiamdocArrayList.clear();
                                dialog1.dismiss();

                            }
                        });
                    }
                });
                dialog.show();
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

    @Override
    public void onItemClickChonChuyenVien(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        if (giamdocVaPhoGiamdocArrayList.contains(giamdocVaPhoGiamdoc)) {
            giamdocVaPhoGiamdocArrayList.remove(giamdocVaPhoGiamdoc);
        } else {
            giamdocVaPhoGiamdocArrayList.add(giamdocVaPhoGiamdoc);
        }
    }
}

