package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.Detail;
import com.vpdt.vpdt.model.DetailDanhSachVanBanSoThamMuuTrinhThanhPho;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDanhSachVBSoThamMuuTrinhTP extends RecyclerView.Adapter<AdapterDanhSachVBSoThamMuuTrinhTP.ViewHolder> {
    private ArrayList<DetailDanhSachVanBanSoThamMuuTrinhThanhPho> detailDanhSachVanBanSoThamMuuTrinhThanhPhoArrayList;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private Context mContext;

    public AdapterDanhSachVBSoThamMuuTrinhTP(Context context, ArrayList<DetailDanhSachVanBanSoThamMuuTrinhThanhPho> detailDanhSachVanBanSoThamMuuTrinhThanhPhoArrayList) {
        this.mContext = context;
        this.detailDanhSachVanBanSoThamMuuTrinhThanhPhoArrayList = detailDanhSachVanBanSoThamMuuTrinhThanhPhoArrayList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_dsvbsothammuutrinhthanhpho, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        DetailDanhSachVanBanSoThamMuuTrinhThanhPho detailDanhSachVanBanSoThamMuuTrinhThanhPho = detailDanhSachVanBanSoThamMuuTrinhThanhPhoArrayList.get(position);

        viewHolder.tvSTT.setText(String.valueOf(position + 1));

        viewHolder.tvNguoiThucHien.setText(String.valueOf(detailDanhSachVanBanSoThamMuuTrinhThanhPho.getTen() + " - " + "Tổng số: " + detailDanhSachVanBanSoThamMuuTrinhThanhPho.getSolg() + " Văn Bản"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                viewHolder.recyclerview2.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager.setInitialPrefetchItemCount(detailDanhSachVanBanSoThamMuuTrinhThanhPho.getDetail().size());

        // Create sub item view adapter
        AdapterDanhSachVBSoThamMuuTrinhTP_Sub adapterSubLichHopSoChuTri = new AdapterDanhSachVBSoThamMuuTrinhTP_Sub((ArrayList<Detail>) detailDanhSachVanBanSoThamMuuTrinhThanhPho.getDetail());

        viewHolder.recyclerview2.setLayoutManager(layoutManager);
        viewHolder.recyclerview2.setAdapter(adapterSubLichHopSoChuTri);
        viewHolder.recyclerview2.setRecycledViewPool(viewPool);


    }

    @Override
    public int getItemCount() {
        return detailDanhSachVanBanSoThamMuuTrinhThanhPhoArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvSTT)
        TextView tvSTT;
        @BindView(R.id.tvNguoiThucHienDanhGia)
        TextView tvNguoiThucHien;
        @BindView(R.id.recyclerview2)
        RecyclerView recyclerview2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }
}
