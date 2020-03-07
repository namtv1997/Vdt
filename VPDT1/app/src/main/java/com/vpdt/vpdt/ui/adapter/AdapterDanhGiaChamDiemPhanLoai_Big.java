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
import com.vpdt.vpdt.model.DetailDanhGiaKeHoach;
import com.vpdt.vpdt.model.ItemMoreDanhGiaKeHoach;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDanhGiaChamDiemPhanLoai_Big extends RecyclerView.Adapter<AdapterDanhGiaChamDiemPhanLoai_Big.ViewHolder> {
    private ArrayList<DetailDanhGiaKeHoach> detailDanhGiaKeHoachArrayList;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private Context mContext;

    public AdapterDanhGiaChamDiemPhanLoai_Big(Context context, ArrayList<DetailDanhGiaKeHoach> detailDanhGiaKeHoachArrayList) {
        this.mContext = context;
        this.detailDanhGiaKeHoachArrayList = detailDanhGiaKeHoachArrayList;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_danhgiachamdiemphanloaipgdtruongphong, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        DetailDanhGiaKeHoach itemMoreDanhGiaKeHoach = detailDanhGiaKeHoachArrayList.get(position);
        for (int i = 0; i <= position + 1; ++i) {
            viewHolder.tvSTT.setText(String.valueOf(i));
        }
        viewHolder.tvNguoiThucHien.setText(String.valueOf(itemMoreDanhGiaKeHoach.getName()));

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                viewHolder.recyclerview2.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager.setInitialPrefetchItemCount(itemMoreDanhGiaKeHoach.getItemMores().size());

        // Create sub item view adapter
        AdapterDanhGiaChamDiemPhanLoai adapterSubLichHopSoChuTri = new AdapterDanhGiaChamDiemPhanLoai((ArrayList<ItemMoreDanhGiaKeHoach>) itemMoreDanhGiaKeHoach.getItemMores());

        viewHolder.recyclerview2.setLayoutManager(layoutManager);
        viewHolder.recyclerview2.setAdapter(adapterSubLichHopSoChuTri);
        viewHolder.recyclerview2.setRecycledViewPool(viewPool);


    }

    @Override
    public int getItemCount() {
        return detailDanhGiaKeHoachArrayList.size();
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
