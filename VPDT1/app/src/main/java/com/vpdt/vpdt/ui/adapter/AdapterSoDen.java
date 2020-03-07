package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.SoDen;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterSoDen extends RecyclerView.Adapter<AdapterSoDen.ViewHolder> {
    private ArrayList<SoDen> soDenArrayList;
    private Context mContext;
    private OnItemClickListener listener;

    public AdapterSoDen(Context mContext, ArrayList<SoDen> soDenArrayList, OnItemClickListener listener) {
        this.mContext = mContext;
        this.soDenArrayList = soDenArrayList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_lavbdauracuavbdenso, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        SoDen soDen = soDenArrayList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));

        viewHolder.tvRCVSoDen.setText(String.valueOf(soDen.getSoDen()));
        if (soDen.getKyHieu() != null) {
            viewHolder.tvRCVKyHieu.setText(String.valueOf(soDen.getKyHieu()));
        }
        if (soDen.getNoiGuiDen() != null) {
            viewHolder.tvRCVNoiGuiDen.setText(String.valueOf(soDen.getNoiGuiDen()));
        }
        if (soDen.getMoTa() != null) {
            viewHolder.tvRCVTrichYeu.setText(String.valueOf(soDen.getMoTa()));
        }
        if (soDen.getNguoiKy() != null) {
            viewHolder.tvNguoiKyRCV.setText(String.valueOf(soDen.getNguoiKy()));
        }
        viewHolder.tvRCVSoDen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(soDenArrayList.get(position));
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return soDenArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvRCVSTT)
        TextView tvSTT;
        @BindView(R.id.tvRCVSoDen)
        TextView tvRCVSoDen;
        @BindView(R.id.tvRCVKyHieu)
        TextView tvRCVKyHieu;
        @BindView(R.id.tvRCVNoiGuiDen)
        TextView tvRCVNoiGuiDen;
        @BindView(R.id.tvRCVTrichYeu)
        TextView tvRCVTrichYeu;
        @BindView(R.id.tvNguoiKyRCV)
        TextView tvNguoiKyRCV;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(SoDen soDen);
    }
}
