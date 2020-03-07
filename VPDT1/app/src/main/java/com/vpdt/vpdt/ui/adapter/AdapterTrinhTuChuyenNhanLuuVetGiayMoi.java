package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.ChuyenNhanLuuVet;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTrinhTuChuyenNhanLuuVetGiayMoi extends RecyclerView.Adapter<AdapterTrinhTuChuyenNhanLuuVetGiayMoi.ViewHolder> {

    private ArrayList<ChuyenNhanLuuVet> trinhTuChuyenNhanLuuVets;
    private Context mContext;
    int index = 0;

    public AdapterTrinhTuChuyenNhanLuuVetGiayMoi(Context mContext, ArrayList<ChuyenNhanLuuVet> trinhTuChuyenNhanLuuVets) {
        this.mContext = mContext;
        this.trinhTuChuyenNhanLuuVets = trinhTuChuyenNhanLuuVets;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_trinhtuchuyennhanluuviet, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ChuyenNhanLuuVet trinhTuChuyenNhanLuuVet = trinhTuChuyenNhanLuuVets.get(position);
        index++;
        viewHolder.tvRCVSTTTTTNLV.setText(String.valueOf(index));
        viewHolder.tvRCVNgayNhanTTTNLV.setText(String.valueOf(trinhTuChuyenNhanLuuVet.getNgayNhan()));
        viewHolder.tvRCVChuyenTuTTTNLV.setText(String.valueOf(trinhTuChuyenNhanLuuVet.getChuyenTu()));
        viewHolder.tvRCVNoiDungTTTNLV.setText(String.valueOf(trinhTuChuyenNhanLuuVet.getNoiDung()));
        viewHolder.tvRCVChuyenDenTTTNLV.setText(String.valueOf(trinhTuChuyenNhanLuuVet.getChuyenDen()));

    }

    @Override
    public int getItemCount() {
        return trinhTuChuyenNhanLuuVets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvRCVSTTTTTNLV)
        TextView tvRCVSTTTTTNLV;
        @BindView(R.id.tvRCVNgayNhanTTTNLV)
        TextView tvRCVNgayNhanTTTNLV;
        @BindView(R.id.tvRCVChuyenTuTTTNLV)
        TextView tvRCVChuyenTuTTTNLV;
        @BindView(R.id.tvRCVNoiDungTTTNLV)
        TextView tvRCVNoiDungTTTNLV;
        @BindView(R.id.tvRCVChuyenDenTTTNLV)
        TextView tvRCVChuyenDenTTTNLV;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
