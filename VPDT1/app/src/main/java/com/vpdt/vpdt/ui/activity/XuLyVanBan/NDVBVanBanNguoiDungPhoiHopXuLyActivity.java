package com.vpdt.vpdt.ui.activity.XuLyVanBan;

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
import com.vpdt.vpdt.model.VanBanNguoiDungPhoiHopXuLy;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBVanBanNguoiDungPhoiHopXuLyActivity extends AppCompatActivity {


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
    @BindView(R.id.tvChiDaoCuaPhong)
    TextView tvChiDaoCuaPhong;

    @BindView(R.id.rvTrinhTuXuLy)
    RecyclerView rvTrinhTuXuLy;
    int id;
    boolean click = false;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;
    String fileDinhKem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndvbvan_ban_nguoi_dung_phoi_hop_xu_ly);
        ButterKnife.bind(this);
        Util.checkConnection(this);
        VanBanNguoiDungPhoiHopXuLy vanBanNguoiDungPhoiHopXuLy = getIntent().getParcelableExtra("vanBanNguoiDungXuLy");
        if (vanBanNguoiDungPhoiHopXuLy != null) {
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) vanBanNguoiDungPhoiHopXuLy.getTrinhTuXuLy());
            id = vanBanNguoiDungPhoiHopXuLy.getId();
            fileDinhKem = vanBanNguoiDungPhoiHopXuLy.getUrlFile();
            tvNgay.setText(String.valueOf(vanBanNguoiDungPhoiHopXuLy.getNgayNhap()));
            tvSKH.setText(String.valueOf(vanBanNguoiDungPhoiHopXuLy.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(vanBanNguoiDungPhoiHopXuLy.getSoDen()));
            tvNoigui.setText(String.valueOf(vanBanNguoiDungPhoiHopXuLy.getNoiGui()));
            tvTrichYeu.setText(String.valueOf(vanBanNguoiDungPhoiHopXuLy.getMoTa()));
            if (!vanBanNguoiDungPhoiHopXuLy.getHanGiaiQuyet().equals("01/01/1970")) {
                tvHanGiaiQuyet.setText(String.valueOf(vanBanNguoiDungPhoiHopXuLy.getHanGiaiQuyet()));
            }
            tvChiDaoCuaPhong.setText("Chỉ đạo của phòng : " + vanBanNguoiDungPhoiHopXuLy.getPhongChiDao());
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
                    Intent intent = new Intent(this, TTVB_DSVBDaHoanThanhChoLDPhongPheDuyetActivity.class);
                    intent.putExtra("id_vb", id);
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
