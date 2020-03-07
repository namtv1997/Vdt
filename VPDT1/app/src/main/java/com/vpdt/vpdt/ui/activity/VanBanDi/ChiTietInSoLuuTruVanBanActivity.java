package com.vpdt.vpdt.ui.activity.VanBanDi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.InSoLuuTruVanbanDi;
import com.vpdt.vpdt.model.Noinhan;
import com.vpdt.vpdt.ui.adapter.AdapterNoiNhanCuaSo;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChiTietInSoLuuTruVanBanActivity extends AppCompatActivity {
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

    @BindView(R.id.rcvNoiNhan)
    RecyclerView rcvNoiNhan;
    AdapterNoiNhanCuaSo adapterNoiNhanCuaSo;

    @BindView(R.id.btnBack)
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_thong_ke_vbtheo_ldchi_dao);
        ButterKnife.bind(this);
        Util.checkConnection(this);
        InSoLuuTruVanbanDi inSoLuuTruVanbanDi = getIntent().getParcelableExtra("InSoLuuTruVanbanDi");
        if (inSoLuuTruVanbanDi != null) {
            RecyclerviewNoiNhanCuaSo((ArrayList<Noinhan>) inSoLuuTruVanbanDi.getNoinhan());
            String shortDate = inSoLuuTruVanbanDi.getNgayky();
            tvNgay.setText(shortDate.substring(0, 5));
            tvNgayKy.setText(String.valueOf(inSoLuuTruVanbanDi.getNgayky()));
            tvSKH.setText(String.valueOf(inSoLuuTruVanbanDi.getKyhieu()));
            tvNoiGui.setText(String.valueOf(inSoLuuTruVanbanDi.getDonvi()));
            tvLoaiVanban.setText(String.valueOf(inSoLuuTruVanbanDi.getLoaivb()));
            tvNguoiKy.setText(String.valueOf(inSoLuuTruVanbanDi.getNguoiky()));
            tvTrichYeu.setText(String.valueOf(inSoLuuTruVanbanDi.getMota()));

        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void RecyclerviewNoiNhanCuaSo(ArrayList<Noinhan> noinhanArrayList) {
        adapterNoiNhanCuaSo = new AdapterNoiNhanCuaSo(this, (ArrayList<Noinhan>) noinhanArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvNoiNhan.setLayoutManager(linearLayoutManager);
        rcvNoiNhan.setAdapter(adapterNoiNhanCuaSo);
        adapterNoiNhanCuaSo.notifyDataSetChanged();
    }
}
