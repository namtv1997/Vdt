package com.vpdt.vpdt.ui.activity.VanBanDen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.InSoLuuTruVanBanDen;
import com.vpdt.vpdt.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChiTietInSoLuuTruVanBanDenActivity extends AppCompatActivity {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvNoiGui)
    TextView tvNoiGui;
    @BindView(R.id.tvLoaiVanban)
    TextView tvLoaiVanban;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvNgayKy)
    TextView tvNgayKy;
    @BindView(R.id.tvNguoiKy)
    TextView tvNguoiKy;
    @BindView(R.id.tvHanGiaiQuyet)
    TextView tvHanGiaiQuyet;
    @BindView(R.id.tvTinhTrang)
    TextView tvTinhTrang;
    @BindView(R.id.tvNguoiGiaiQuyetCuoiCung)
    TextView tvNguoiGiaiQuyetCuoiCung;


    @BindView(R.id.btnBack)
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_in_so_luu_tru_van_ban_den);
        ButterKnife.bind(this);
        Util.checkConnection(this);
        InSoLuuTruVanBanDen inSoLuuTruVanbanDi = getIntent().getParcelableExtra("InSoLuuTruVanBanDen");
        if (inSoLuuTruVanbanDi != null) {
            if (!inSoLuuTruVanbanDi.getNgaynhan().isEmpty()) {
                String shortDate = inSoLuuTruVanbanDi.getNgaynhan();
                tvNgay.setText(shortDate.substring(0, 5));
            }
            tvNgayKy.setText(String.valueOf(inSoLuuTruVanbanDi.getNgayky()));
            tvSKH.setText(String.valueOf(inSoLuuTruVanbanDi.getKyhieu()));
            tvNoiGui.setText(String.valueOf(inSoLuuTruVanbanDi.getDonviBH()));
            tvLoaiVanban.setText(String.valueOf(inSoLuuTruVanbanDi.getLoaiVB()));
            tvNguoiKy.setText(String.valueOf(inSoLuuTruVanbanDi.getNguoiky()));
            tvHanGiaiQuyet.setText(String.valueOf(inSoLuuTruVanbanDi.getHangiaiquyet()));
            tvTrichYeu.setText(String.valueOf(inSoLuuTruVanbanDi.getMota()));
            tvTinhTrang.setText(String.valueOf(inSoLuuTruVanbanDi.getTrangthai()));
            tvNguoiGiaiQuyetCuoiCung.setText(String.valueOf(inSoLuuTruVanbanDi.getNguoigiaiquyetcuoicung()));

        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
