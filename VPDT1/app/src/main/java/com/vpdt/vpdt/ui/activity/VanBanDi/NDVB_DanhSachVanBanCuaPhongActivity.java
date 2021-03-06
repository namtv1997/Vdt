package com.vpdt.vpdt.ui.activity.VanBanDi;

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
import com.vpdt.vpdt.model.DSVBCuaPhong;
import com.vpdt.vpdt.model.Noinhan;
import com.vpdt.vpdt.ui.adapter.AdapterNoiNhanCuaSo;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVB_DanhSachVanBanCuaPhongActivity extends AppCompatActivity {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSoDi)
    TextView tvSoDi;
    @BindView(R.id.tvSoKyHieu)
    TextView tvSoKyHieu;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvLoaiVanban)
    TextView tvLoaiVanban;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvNguoiKy)
    TextView tvNguoiKy;
    @BindView(R.id.tvXemFileDinhKem)
    TextView tvXemFileDinhKem;
    @BindView(R.id.rvNoiNhan)
    RecyclerView rvNoiNhan;
    AdapterNoiNhanCuaSo adapterNoiNhanCuaSo;

    int id;
    boolean click = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndvb_danh_sach_van_ban_cua_phong);
        ButterKnife.bind(this);
        Util.checkConnection(this);
        DSVBCuaPhong dsvbCuaPhong = getIntent().getParcelableExtra("dsvbCuaPhong");
        if (dsvbCuaPhong != null) {
            id = dsvbCuaPhong.getMavb();
            String shortDate = dsvbCuaPhong.getNgaythang();
            RecyclerviewNoiNhanCuaSo((ArrayList<Noinhan>) dsvbCuaPhong.getNoinhan());
            tvNgay.setText(shortDate.substring(0, 5));
            tvSoDi.setText(String.valueOf(dsvbCuaPhong.getSodi()));
            tvSoKyHieu.setText(String.valueOf(dsvbCuaPhong.getKyhieu()));
            tvSoDen.setText(String.valueOf(dsvbCuaPhong.getSoden()));
            tvLoaiVanban.setText(String.valueOf(dsvbCuaPhong.getLoaiVB()));
            tvTrichYeu.setText(String.valueOf(dsvbCuaPhong.getTrichYeu()));
            tvNguoiKy.setText(dsvbCuaPhong.getNguoiky());
            tvXemFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dsvbCuaPhong.getDuongdan()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVB_DanhSachVanBanCuaPhongActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.tvXemChiTiet, R.id.btnBack})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVB_DanhSachVanBanCuaPhongActivity.class);
                    intent.putExtra("dsvbCuaPhong", id);
                    startActivity(intent);
                    click = true;
                }
                break;
            case R.id.btnBack:
                finish();

                break;

        }
    }

    void RecyclerviewNoiNhanCuaSo(ArrayList<Noinhan> noinhanArrayList) {
        adapterNoiNhanCuaSo = new AdapterNoiNhanCuaSo(this, (ArrayList<Noinhan>) noinhanArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvNoiNhan.setLayoutManager(linearLayoutManager);
        rvNoiNhan.setAdapter(adapterNoiNhanCuaSo);
        adapterNoiNhanCuaSo.notifyDataSetChanged();
    }
}
