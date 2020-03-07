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
import com.vpdt.vpdt.model.DetailVanBanDiTongThe;
import com.vpdt.vpdt.model.Noinhan;
import com.vpdt.vpdt.ui.adapter.AdapterNoiNhanCuaSo;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDSGiayMoiCuaSoActivity extends AppCompatActivity {
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
    @BindView(R.id.tvXemFilePDF)
    TextView tvXemFilePDF;

    int id;
    boolean click = false;
    @BindView(R.id.rvNoiNhan)
    RecyclerView rvNoiNhan;
    AdapterNoiNhanCuaSo adapterNoiNhanCuaSo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndvbdsgiay_moi_cua_so);
        ButterKnife.bind(this);
        Util.checkConnection(this);
        DetailVanBanDiTongThe detailVanBanDiTongThe = getIntent().getParcelableExtra("detailVanBanDiTongThe");
        if (detailVanBanDiTongThe != null) {
            RecyclerviewNoiNhanCuaSo((ArrayList<Noinhan>) detailVanBanDiTongThe.getNoinhan());
            id = detailVanBanDiTongThe.getPKIMaVBDi();
            String shortDate = detailVanBanDiTongThe.getNgayVBdi();
            tvNgay.setText(shortDate.substring(0, 5));
            tvSoDi.setText(String.valueOf(detailVanBanDiTongThe.getSodi()));
            tvSoKyHieu.setText(String.valueOf(detailVanBanDiTongThe.getKyhieu()));
            tvSoDen.setText(String.valueOf(detailVanBanDiTongThe.getSoden()));
            tvLoaiVanban.setText(String.valueOf(detailVanBanDiTongThe.getTenloaivanban()));
            tvTrichYeu.setText(String.valueOf(detailVanBanDiTongThe.getTy().getMota()));
            tvNguoiKy.setText("(Người ký:" + detailVanBanDiTongThe.getTy().getNguoiKy() + ")");
            tvXemFilePDF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(detailVanBanDiTongThe.getTy().getDuongdan()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBDSGiayMoiCuaSoActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
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
                    Intent intent = new Intent(this, TTVBVanBanXemDeBietActivity.class);
                    intent.putExtra("ID_VANBAN_XEM_DE_BIET", id);
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
