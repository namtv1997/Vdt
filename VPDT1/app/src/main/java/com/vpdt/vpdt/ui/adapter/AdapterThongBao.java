package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.ThongBao;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterThongBao extends RecyclerView.Adapter<AdapterThongBao.ViewHolder> {
    private ArrayList<ThongBao> deXuatCongViecPhoiHopChoDuyetArrayList;

    private OnItemClickListener listener;


    public AdapterThongBao(ArrayList<ThongBao> deXuatCongViecPhoiHopChoDuyetArrayList, OnItemClickListener listener) {
        this.deXuatCongViecPhoiHopChoDuyetArrayList = deXuatCongViecPhoiHopChoDuyetArrayList;
        this.listener = listener;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_thongbaoxanh, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ThongBao dsvb_daChiDao = deXuatCongViecPhoiHopChoDuyetArrayList.get(position);
        viewHolder.tvTieuDe.setText(String.valueOf(dsvb_daChiDao.getTieuDe()));
        viewHolder.tvNgayTao.setText(String.valueOf(dsvb_daChiDao.getNgayTao()));
        viewHolder.tvNoiDung.setText(String.valueOf(dsvb_daChiDao.getNoiDung()));

        if (dsvb_daChiDao.getTrangThai() == 1) {
            viewHolder.linearLayout.setBackgroundResource(R.drawable.round11);

        } else {
            viewHolder.linearLayout.setBackgroundResource(R.drawable.round10);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(deXuatCongViecPhoiHopChoDuyetArrayList.get(position));
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return deXuatCongViecPhoiHopChoDuyetArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tvTieuDe)
        TextView tvTieuDe;
        @BindView(R.id.tvNgayTao)
        TextView tvNgayTao;
        @BindView(R.id.tvNoiDung)
        TextView tvNoiDung;
        @BindView(R.id.linearLayout)
        LinearLayout linearLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public interface OnItemClickListener {
        void onItemClick(ThongBao thongBao);
    }
}
