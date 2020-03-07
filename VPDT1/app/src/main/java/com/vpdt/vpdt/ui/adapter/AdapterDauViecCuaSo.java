package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.ItemDauViecCuaSo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDauViecCuaSo extends RecyclerView.Adapter<AdapterDauViecCuaSo.ViewHolder> {
    private ArrayList<ItemDauViecCuaSo> itemDauViecCuaSos;
    private Context mContext;


    public AdapterDauViecCuaSo(Context mContext, ArrayList<ItemDauViecCuaSo> itemDauViecCuaSos) {
        this.mContext = mContext;
        this.itemDauViecCuaSos = itemDauViecCuaSos;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_dsdauvieccuaso_quanlydauviec, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ItemDauViecCuaSo item = itemDauViecCuaSos.get(position);

        viewHolder.tvRCVSTT.setText(String.valueOf(position + 1));
        viewHolder.tvRCVSoKyHieu.setText(String.valueOf(item.getSoKyhieu()));
        viewHolder.tvRCVNgayBanHanh.setText(String.valueOf(item.getNgayBanhanh()));
        viewHolder.tvRCVTrichYeu.setText(String.valueOf(item.getTrichYeu()));
        viewHolder.rcvTongSoDauViec.setText(String.valueOf(item.getTongSo()));
        viewHolder.tvRCVTrongHan.setText(String.valueOf(item.getDthTronghan()));
        viewHolder.tvRCVQuaHan.setText(String.valueOf(item.getDthQuahan()));
        viewHolder.tvRCVSapDenHan.setText(String.valueOf(item.getSapdenHan()));
        viewHolder.tvRCVQuaHanht.setText(String.valueOf(item.getDhtQuahan()));
        viewHolder.tvRCVTrongHanht.setText(String.valueOf(item.getDhtTronghan()));
    }

    @Override
    public int getItemCount() {
        return itemDauViecCuaSos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tvRCVSTT)
        TextView tvRCVSTT;
        @BindView(R.id.tvRCVSoKyHieu)
        TextView tvRCVSoKyHieu;
        @BindView(R.id.tvRCVNgayBanHanh)
        TextView tvRCVNgayBanHanh;
        @BindView(R.id.tvRCVTrichYeu)
        TextView tvRCVTrichYeu;
        @BindView(R.id.rcvTongSoDauViec)
        TextView rcvTongSoDauViec;
        @BindView(R.id.tvRCVTrongHan)
        TextView tvRCVTrongHan;
        @BindView(R.id.tvRCVQuaHan)
        TextView tvRCVQuaHan;
        @BindView(R.id.tvRCVTrongHanht)
        TextView tvRCVTrongHanht;
        @BindView(R.id.tvRCVQuaHanht)
        TextView tvRCVQuaHanht;
        @BindView(R.id.tvRCVSapDenHan)
        TextView tvRCVSapDenHan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }
}
