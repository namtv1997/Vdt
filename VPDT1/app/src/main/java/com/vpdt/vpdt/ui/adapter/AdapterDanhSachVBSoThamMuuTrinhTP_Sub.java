package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.Detail;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDanhSachVBSoThamMuuTrinhTP_Sub extends RecyclerView.Adapter<AdapterDanhSachVBSoThamMuuTrinhTP_Sub.ViewHolder> {
    private ArrayList<Detail> detailArrayList;


    public AdapterDanhSachVBSoThamMuuTrinhTP_Sub(ArrayList<Detail> detailArrayList) {
        this.detailArrayList = detailArrayList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_dsvbsothammuutrinhthanhpho1, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Detail detail = detailArrayList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvSoKyHieu.setText(String.valueOf(detail.getKyhieu()));
        viewHolder.tvNgayKy.setText(String.valueOf(detail.getNgayVbdi()));
        viewHolder.tvLoaiVanBan.setText(String.valueOf(detail.getLoaivanban()));
        viewHolder.tvTrichYeu.setText(String.valueOf(detail.getMota()));
        viewHolder.tvNguoiKy.setText(String.valueOf(detail.getNguoiky()));
        viewHolder.tvDonViBanHanh.setText(String.valueOf(detail.getTenPb()));

    }

    @Override
    public int getItemCount() {
        return detailArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvSTT)
        TextView tvSTT;
        @BindView(R.id.tvSoKyHieu)
        TextView tvSoKyHieu;
        @BindView(R.id.tvNgayKy)
        TextView tvNgayKy;
        @BindView(R.id.tvLoaiVanBan)
        TextView tvLoaiVanBan;
        @BindView(R.id.tvTrichYeu)
        TextView tvTrichYeu;
        @BindView(R.id.tvNguoiKy)
        TextView tvNguoiKy;
        @BindView(R.id.tvDonViBanHanh)
        TextView tvDonViBanHanh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }
}
