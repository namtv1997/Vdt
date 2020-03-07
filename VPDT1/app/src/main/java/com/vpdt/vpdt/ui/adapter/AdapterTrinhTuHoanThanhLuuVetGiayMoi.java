package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.HoanThanhLuuVet;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTrinhTuHoanThanhLuuVetGiayMoi extends RecyclerView.Adapter<AdapterTrinhTuHoanThanhLuuVetGiayMoi.ViewHolder> {
    private ArrayList<HoanThanhLuuVet> trinhTuHoanThanhLuuVets;
    private Context mContext;

    public AdapterTrinhTuHoanThanhLuuVetGiayMoi(Context mContext, ArrayList<HoanThanhLuuVet> trinhTuHoanThanhLuuVets) {
        this.mContext = mContext;
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
        HoanThanhLuuVet trinhTuHoanThanhLuuVet = trinhTuHoanThanhLuuVets.get(position);
        for (int stt = 1; stt <= position + 1; ++stt) {
            viewHolder.tvSTT.setText(String.valueOf(stt));
        }
        viewHolder.tvThoiGian.setText(String.valueOf(trinhTuHoanThanhLuuVet.getThoiGian()));
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
