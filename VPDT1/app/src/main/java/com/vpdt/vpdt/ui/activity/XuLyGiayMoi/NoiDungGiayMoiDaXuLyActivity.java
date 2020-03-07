package com.vpdt.vpdt.ui.activity.XuLyGiayMoi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.GiayMoiDaXuLy;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoiDungGiayMoiDaXuLyActivity extends AppCompatActivity {
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
    @BindView(R.id.tvHanGiaiQuyet)
    TextView tvHanGiaiQuyet;
    @BindView(R.id.tvNgayGio)
    TextView tvNgayGio;

    @BindView(R.id.rvTrinhTuXuLy)
    RecyclerView rvTrinhTuXuLy;
    int id;
    boolean click = false;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;
    String fileDinhKem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noi_dung_giay_moi_da_xu_ly);
        ButterKnife.bind(this);
        Util.checkConnection(this);
        GiayMoiDaXuLy giayMoiDaXuLy = getIntent().getParcelableExtra("giayMoiDaXuLy");
        if (giayMoiDaXuLy != null) {
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) giayMoiDaXuLy.getTrinhTuXuLy());
            id = giayMoiDaXuLy.getId();
            fileDinhKem = giayMoiDaXuLy.getUrlFile();
            tvNgay.setText(String.valueOf(giayMoiDaXuLy.getNgayNhap()));
            tvSKH.setText(String.valueOf(giayMoiDaXuLy.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(giayMoiDaXuLy.getSoDen()));
            tvNoigui.setText(String.valueOf(giayMoiDaXuLy.getNoiGui()));
            tvTrichYeu.setText(String.valueOf(giayMoiDaXuLy.getMoTa()));
            tvHanGiaiQuyet.setText(String.valueOf(giayMoiDaXuLy.getHanGiaiQuyet()));
            tvNgayGio.setText(String.valueOf("Vào hồi: " + giayMoiDaXuLy.getGiayMoiGio() + " ngày "
                    + giayMoiDaXuLy.getGiayMoiNgay() + ", tại "
                    + giayMoiDaXuLy.getGiayMoiDiaDiem()));
            if (giayMoiDaXuLy.getGiayMoiGio().isEmpty()){
                tvNgayGio.setVisibility(View.GONE);
            }else {
                tvNgayGio.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack, R.id.tvFileDinhKem, R.id.tvXemChiTietNDVBDSVBDenChoLDXL})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTietNDVBDSVBDenChoLDXL:
                if (!click) {
                    Intent intent = new Intent(this, ThongTinGiayMoiDaXuLyActivity.class);
                    intent.putExtra("idvb", id);
                    startActivity(intent);
                    click = true;
                }
                break;
            case R.id.tvFileDinhKem:
                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(fileDinhKem));
                    startActivity(browserIntent);
                } catch (Exception e) {
                    Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    void recyclerviewTrinhTuChuyenNhan(ArrayList<String> stringArrayList) {
        adapterDeXuatGiaHanChoXuLy = new AdapterDeXuatGiaHanChoXuLy(stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvTrinhTuXuLy.setLayoutManager(linearLayoutManager);
        rvTrinhTuXuLy.setAdapter(adapterDeXuatGiaHanChoXuLy);
        adapterDeXuatGiaHanChoXuLy.notifyDataSetChanged();
    }
}
