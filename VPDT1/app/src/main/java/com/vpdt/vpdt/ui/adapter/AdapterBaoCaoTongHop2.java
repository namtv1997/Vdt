package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.PhongbanBaoCaoTongHop;
import com.vpdt.vpdt.model.VanbanBaoCaoTongHop;
import com.vpdt.vpdt.ui.activity.VanBanDen.TTVBBaoCaoTongHopActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterBaoCaoTongHop2 extends RecyclerView.Adapter<AdapterBaoCaoTongHop2.ViewHolder> implements AdapterBaoCaoTongHop3.OnItemClickListener {
    private ArrayList<PhongbanBaoCaoTongHop> baoCaoTongHopArrayList;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    Context context;

    public AdapterBaoCaoTongHop2(Context context, ArrayList<PhongbanBaoCaoTongHop> baoCaoTongHopArrayList) {
        this.baoCaoTongHopArrayList = baoCaoTongHopArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_bao_cao_tong_hop2, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        PhongbanBaoCaoTongHop phongbanBaoCaoTongHop = baoCaoTongHopArrayList.get(position);
        viewHolder.tvRCVPhong.setText(String.valueOf(phongbanBaoCaoTongHop.getTenpb()));
        viewHolder.tvRCVTongSo.setText(String.valueOf(phongbanBaoCaoTongHop.getTong()));
        viewHolder.tvRCVDangTrienKhaiChuaDenHan.setText(String.valueOf(phongbanBaoCaoTongHop.getDtkChuadenhan()));
        viewHolder.tvRCVDangTrienKhaiQuaHan.setText(String.valueOf(phongbanBaoCaoTongHop.getDtkDaquahan()));
        viewHolder.tvRCVHoanThanhTrongHan.setText(String.valueOf(phongbanBaoCaoTongHop.getHtTronghan()));
        viewHolder.tvRCVHoanThanhQuaHan.setText(String.valueOf(phongbanBaoCaoTongHop.getHtQuahan()));
//        viewHolder.tvRCVKhoKhanVuongMac.setText(String.valueOf(phongbanBaoCaoTongHop.get()));
//        viewHolder.tvRCVGhiChu.setText(String.valueOf(phongbanBaoCaoTongHop.get()));

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                viewHolder.rcv2.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager.setInitialPrefetchItemCount(phongbanBaoCaoTongHop.getVanbanBaoCaoTongHop().size());

        // Create sub item view adapter
        AdapterBaoCaoTongHop3 adapterBaoCaoTongHop3 = new AdapterBaoCaoTongHop3((ArrayList<VanbanBaoCaoTongHop>) phongbanBaoCaoTongHop.getVanbanBaoCaoTongHop(),
                this);

        viewHolder.rcv2.setLayoutManager(layoutManager);
        viewHolder.rcv2.setAdapter(adapterBaoCaoTongHop3);
        viewHolder.rcv2.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return baoCaoTongHopArrayList.size();
    }

    @Override
    public void onItemClickXemFile(VanbanBaoCaoTongHop vanbanBaoCaoTongHop) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanbanBaoCaoTongHop.getDuongdanNoidung()));
            context.startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(context, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClickXemFile1(VanbanBaoCaoTongHop vanbanBaoCaoTongHop) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanbanBaoCaoTongHop.getDuongdanKetqua()));
            context.startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(context, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClickNoiDung(VanbanBaoCaoTongHop vanbanBaoCaoTongHop) {
        Intent intent = new Intent(context, TTVBBaoCaoTongHopActivity.class);
        intent.putExtra("vanbanBaoCaoTongHop", vanbanBaoCaoTongHop);
        context.startActivity(intent);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvRCVPhong)
        TextView tvRCVPhong;
        @BindView(R.id.tvRCVTongSo)
        TextView tvRCVTongSo;
        @BindView(R.id.tvRCVDangTrienKhaiChuaDenHan)
        TextView tvRCVDangTrienKhaiChuaDenHan;
        @BindView(R.id.tvRCVDangTrienKhaiQuaHan)
        TextView tvRCVDangTrienKhaiQuaHan;
        @BindView(R.id.tvRCVHoanThanhTrongHan)
        TextView tvRCVHoanThanhTrongHan;
        @BindView(R.id.tvRCVHoanThanhQuaHan)
        TextView tvRCVHoanThanhQuaHan;
        @BindView(R.id.tvRCVKhoKhanVuongMac)
        TextView tvRCVKhoKhanVuongMac;
        @BindView(R.id.tvRCVGhiChu)
        TextView tvRCVGhiChu;
        @BindView(R.id.rcv2)
        RecyclerView rcv2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
