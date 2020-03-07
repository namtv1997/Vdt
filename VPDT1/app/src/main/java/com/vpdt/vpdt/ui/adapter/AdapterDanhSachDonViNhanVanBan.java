package com.vpdt.vpdt.ui.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.PhongBan;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDanhSachDonViNhanVanBan extends RecyclerView.Adapter<AdapterDanhSachDonViNhanVanBan.ViewHolder> {
    private ArrayList<PhongBan> phongBanArrayList;
    private OnItemClickListener listener;

    public AdapterDanhSachDonViNhanVanBan(ArrayList<PhongBan> phongBanArrayList, OnItemClickListener listener) {
        this.phongBanArrayList = phongBanArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_danhsachdonvinhanvanban, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        PhongBan phongBan = phongBanArrayList.get(position);
        viewHolder.tvTenPhongBan.setText(String.valueOf(phongBan.getTenPhongBan()));
        viewHolder.tvNguoiNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickNguoiNhan(phongBanArrayList.get(position), v);
                }
            }
        });
        viewHolder.cbChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickcbChon(phongBanArrayList.get(position));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return phongBanArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cbChon)
        CheckBox cbChon;
        @BindView(R.id.tvTenPhongBan)
        TextView tvTenPhongBan;
        @BindView(R.id.tvNguoiNhan)
        TextView tvNguoiNhan;
        @BindView(R.id.etGhiChu)
        TextView etGhiChu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public interface OnItemClickListener {
        void onItemClickcbChon(PhongBan phongBan);

        void onItemClickNguoiNhan(PhongBan phongBan, View v);
    }
}
