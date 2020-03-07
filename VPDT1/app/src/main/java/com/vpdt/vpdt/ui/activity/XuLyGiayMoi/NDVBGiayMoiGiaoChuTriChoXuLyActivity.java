package com.vpdt.vpdt.ui.activity.XuLyGiayMoi;

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
import com.vpdt.vpdt.model.GiayMoiGiaoChuTriChoXuLy;
import com.vpdt.vpdt.presenter.NDVBGiayMoiGiaoChuTriChoXuLyPresenter;
import com.vpdt.vpdt.presenter.NDVBGiayMoiGiaoChuTriChoXuLyView;
import com.vpdt.vpdt.presenter.impl.NDVBGiayMoiGiaoChuTriChoXuLyPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBGiayMoiGiaoChuTriChoXuLyActivity extends BaseActivity<NDVBGiayMoiGiaoChuTriChoXuLyPresenter> implements
        NDVBGiayMoiGiaoChuTriChoXuLyView {

    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvNoigui)
    TextView tvNoigui;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvNgayGio)
    TextView tvNgayGio;
    @BindView(R.id.tvHanGiaiQuyet)
    TextView tvHanGiaiQuyet;
    @BindView(R.id.tvXemChiTiet)
    TextView tvXemChiTiet;

    @BindView(R.id.rcvTTXL)
    RecyclerView rcvTTXL;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;

    EditText edtNoiDungTuChoi;

    int idCanBoChuyen;
    String filedinhkem;
    AlertDialog dialog;
    int idvb;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbgiay_moi_giao_chu_tri_cho_xu_ly;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        GiayMoiGiaoChuTriChoXuLy giayMoiGiaoChuTriChoXuLy = getIntent().getParcelableExtra("giayMoiGiaoChuTriChoXuLy");
        if (giayMoiGiaoChuTriChoXuLy != null) {
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) giayMoiGiaoChuTriChoXuLy.getTrinhTuXuLy());
            idvb = giayMoiGiaoChuTriChoXuLy.getId();
            idCanBoChuyen = giayMoiGiaoChuTriChoXuLy.getIdCanBoChuyen();
            filedinhkem = giayMoiGiaoChuTriChoXuLy.getUrlFile();
            tvNgay.setText(String.valueOf(giayMoiGiaoChuTriChoXuLy.getNgayNhap()));
            tvSKH.setText(String.valueOf(giayMoiGiaoChuTriChoXuLy.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(giayMoiGiaoChuTriChoXuLy.getSoDen()));
            tvNoigui.setText(String.valueOf(giayMoiGiaoChuTriChoXuLy.getNoiGui()));
            tvTrichYeu.setText(String.valueOf(giayMoiGiaoChuTriChoXuLy.getMoTa()));
            if (!giayMoiGiaoChuTriChoXuLy.getGiayMoiGio().isEmpty() && !giayMoiGiaoChuTriChoXuLy.getGiayMoiNgay().isEmpty() && !giayMoiGiaoChuTriChoXuLy.getGiayMoiDiaDiem().isEmpty()) {
                tvNgayGio.setText("( Vào hồi " + giayMoiGiaoChuTriChoXuLy.getGiayMoiGio() + " ngày " + giayMoiGiaoChuTriChoXuLy.getGiayMoiNgay() + ", tại" + giayMoiGiaoChuTriChoXuLy.getGiayMoiDiaDiem() + ")");
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

    @OnClick({R.id.btnBack, R.id.btnTuChoi, R.id.tvXemFileDinhKem, R.id.tvXemChiTiet})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btnBack:
                finish();
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
                AlertDialog.Builder buildertuchoi = new AlertDialog.Builder(this);
                LayoutInflater inflatertuchoi = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewtuchoi = inflatertuchoi.inflate(R.layout.dialog_tuchoi_ketquahoanthanh_cho_phe_duyet, null);
                buildertuchoi.setView(viewtuchoi);
                buildertuchoi.setCancelable(false);
                dialog = buildertuchoi.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                edtNoiDungTuChoi = viewtuchoi.findViewById(R.id.edtNoiDungTuChoi);
                Button btnDong1 = viewtuchoi.findViewById(R.id.btnDong);
                Button btnChuyenChanhVanBan = viewtuchoi.findViewById(R.id.btnChuyenChanhVanBan);
                btnChuyenChanhVanBan.setText("Gửi lãnh đạo");
                btnDong1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btnChuyenChanhVanBan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().tuChoiGMChuTriChoXuLyCV(idvb, edtNoiDungTuChoi.getText().toString(), idCanBoChuyen);
                    }
                });
                dialog.show();
                break;
            case R.id.tvXemFileDinhKem:
                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(filedinhkem));
                    startActivity(browserIntent);
                } catch (Exception e) {
                    Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void tuChoiGMChuTriChoXuLyCVSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NDVBGiayMoiGiaoChuTriChoXuLyPresenter createPresenter() {
        return new NDVBGiayMoiGiaoChuTriChoXuLyPresenterImpl(this);
    }


    void recyclerviewTrinhTuChuyenNhan(ArrayList<String> stringArrayList) {
        adapterDeXuatGiaHanChoXuLy = new AdapterDeXuatGiaHanChoXuLy(stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTXL.setLayoutManager(linearLayoutManager);
        rcvTTXL.setAdapter(adapterDeXuatGiaHanChoXuLy);
        adapterDeXuatGiaHanChoXuLy.notifyDataSetChanged();
    }
}
