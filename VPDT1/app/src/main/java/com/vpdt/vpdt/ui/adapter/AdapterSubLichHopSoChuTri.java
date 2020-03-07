package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.ItemmoreSang;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterSubLichHopSoChuTri extends RecyclerView.Adapter<AdapterSubLichHopSoChuTri.ViewHolder> {
    private ArrayList<ItemmoreSang> itemmoreSangArrayList;
    OnItemClickListener listener;

    public AdapterSubLichHopSoChuTri(ArrayList<ItemmoreSang> itemmoreSangArrayList, OnItemClickListener listener) {

        this.itemmoreSangArrayList = itemmoreSangArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_sang_chieu, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        ItemmoreSang itemmoreSang = itemmoreSangArrayList.get(position);
        viewHolder.tvChuTri.setText(String.valueOf(itemmoreSang.getChuTri()));
        viewHolder.tvMota.setText(String.valueOf(itemmoreSang.getMota()));
        viewHolder.tvNgayGio.setText(String.valueOf(itemmoreSang.getNgayGiayMoi() + "-" + itemmoreSang.getGioGiayMoi()));
        viewHolder.tvDiaDiem.setText(String.valueOf(itemmoreSang.getDiaDiemGiayMoi()));
        viewHolder.tvPhongBan.setText(String.valueOf(itemmoreSang.getPhongBan()));

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(itemmoreSangArrayList.get(position));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemmoreSangArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvChuTri)
        TextView tvChuTri;
        @BindView(R.id.tvMota)
        TextView tvMota;
        @BindView(R.id.tvNgayGio)
        TextView tvNgayGio;
        @BindView(R.id.tvDiaDiem)
        TextView tvDiaDiem;
        @BindView(R.id.tvPhongBan)
        TextView tvPhongBan;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(ItemmoreSang itemmoreSang);
    }
}
