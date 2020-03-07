package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.TrinhTuHoanThanhCVLuuVet;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTrinhTuHoanThanhLuuVetChoPhongPheDuyet extends RecyclerView.Adapter<AdapterTrinhTuHoanThanhLuuVetChoPhongPheDuyet.ViewHolder> {
    private ArrayList<TrinhTuHoanThanhCVLuuVet> trinhTuHoanThanhLuuVets;

    public AdapterTrinhTuHoanThanhLuuVetChoPhongPheDuyet(ArrayList<TrinhTuHoanThanhCVLuuVet> trinhTuHoanThanhLuuVets) {

        this.trinhTuHoanThanhLuuVets = trinhTuHoanThanhLuuVets;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_trinhtuhoanthanhcongviecluuviet, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        TrinhTuHoanThanhCVLuuVet trinhTuHoanThanhLuuVet = trinhTuHoanThanhLuuVets.get(position);

        viewHolder.tvSTT.setText(String.valueOf(position + 1));

        viewHolder.tvThoiGian.setText(String.valueOf(trinhTuHoanThanhLuuVet.getNgayNhan()));
        viewHolder.tvChuyenTu.setText(String.valueOf(trinhTuHoanThanhLuuVet.getChuyenTu()));
        viewHolder.tvNoiDung.setText(String.valueOf(trinhTuHoanThanhLuuVet.getNoiDung()));
        viewHolder.tvChuyenDen.setText(String.valueOf(trinhTuHoanThanhLuuVet.getChuyenDen()));

    }

    @Override
    public int getItemCount() {
        return trinhTuHoanThanhLuuVets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvRCVSTTTTHTCVLV)
        TextView tvSTT;
        @BindView(R.id.tvRCVThoiGianTTHTCVLV)
        TextView tvThoiGian;
        @BindView(R.id.tvRCVChuyenTuTTHTCVLV)
        TextView tvChuyenTu;
        @BindView(R.id.tvRCVNoiDungTTHTCVLV)
        TextView tvNoiDung;
        @BindView(R.id.tvRCVChuyenDenTTHTCVLV)
        TextView tvChuyenDen;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
