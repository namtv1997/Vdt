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
import com.vpdt.vpdt.model.GMGiaoPhoiHopChoXuLy;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.TTVBSoLuongVanBanGiaoPhongPhoiHop1Activity;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBGiayMoiGiaoPhoiHopChoXuLyActivity extends AppCompatActivity {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvNoiGui)
    TextView tvNoigui;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvHanGiaiQuyet)
    TextView tvHanGiaiQuyet;

    @BindView(R.id.rvTrinhTuXuLy)
    RecyclerView rvTrinhTuXuLy;
    int id;
    boolean click = false;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;
    String fileDinhKem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndvbgiay_moi_giao_phoi_hop_cho_xu_ly);
        ButterKnife.bind(this);
        Util.checkConnection(this);
        GMGiaoPhoiHopChoXuLy vanBanNguoiDungPhoiHopXuLy = getIntent().getParcelableExtra("gmGiaoPhoiHopChoXuLy");
        if (vanBanNguoiDungPhoiHopXuLy != null) {
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) vanBanNguoiDungPhoiHopXuLy.getTrinhTuXuLy());
            id = vanBanNguoiDungPhoiHopXuLy.getId();
            fileDinhKem = vanBanNguoiDungPhoiHopXuLy.getUrlFile();
            tvNgay.setText(String.valueOf(vanBanNguoiDungPhoiHopXuLy.getNgayNhap()));
            tvSKH.setText(String.valueOf(vanBanNguoiDungPhoiHopXuLy.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(vanBanNguoiDungPhoiHopXuLy.getSoDen()));
            tvNoigui.setText(String.valueOf(vanBanNguoiDungPhoiHopXuLy.getNoiGui()));
            tvTrichYeu.setText(String.valueOf(vanBanNguoiDungPhoiHopXuLy.getMoTa()));
            tvHanGiaiQuyet.setText(String.valueOf(vanBanNguoiDungPhoiHopXuLy.getHanGiaiQuyet()));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack, R.id.tvXemFileDinhKem, R.id.tvXemChiTiet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBSoLuongVanBanGiaoPhongPhoiHop1Activity.class);
                    intent.putExtra("idvb", id);
                    startActivity(intent);
                    click = true;
                }
                break;
            case R.id.tvXemFileDinhKem:
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