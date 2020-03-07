package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.VanBanTraLoi;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterVanBanTraLoi extends RecyclerView.Adapter<AdapterVanBanTraLoi.ViewHolder> {

    private ArrayList<VanBanTraLoi> vanBanTraLoiArrayList;
    private Context mContext;

    public AdapterVanBanTraLoi(Context mContext, ArrayList<VanBanTraLoi> vanBanTraLoiArrayList) {
        this.mContext = mContext;
        this.vanBanTraLoiArrayList = vanBanTraLoiArrayList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_dsvanbantraloi, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        VanBanTraLoi vanBanTraLoi = vanBanTraLoiArrayList.get(position);
        for (int stt = 1; stt <= position + 1; ++stt) {
            viewHolder.tvSTT.setText(String.valueOf(stt));
        }
        viewHolder.tvRCVNgayNhap.setText(String.valueOf(vanBanTraLoi.getNgayNhap()));
        if (vanBanTraLoi.getKyHieu() != null) {
            viewHolder.tvRCVKyHieu.setText(String.valueOf(vanBanTraLoi.getKyHieu()));
        }
        if (vanBanTraLoi.getTrichDan() != null) {
            viewHolder.tvRCVTrichDan.setText(String.valueOf(vanBanTraLoi.getTrichDan()));
        }
        if (vanBanTraLoi.getNgayKy() != null) {
            viewHolder.tvRCVNgayKy.setText(String.valueOf(vanBanTraLoi.getNgayKy()));
        }
        if (vanBanTraLoi.getNguoiKy() != null) {
            viewHolder.tvNguoiKyRCV.setText(String.valueOf(vanBanTraLoi.getNguoiKy()));
        }

    }

    @Override
    public int getItemCount() {
        return vanBanTraLoiArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvRCVSTT)
        TextView tvSTT;
        @BindView(R.id.tvRCVNgayNhap)
        TextView tvRCVNgayNhap;
        @BindView(R.id.tvRCVKyHieu)
        TextView tvRCVKyHieu;
        @BindView(R.id.tvRCVTrichDan)
        TextView tvRCVTrichDan;
        @BindView(R.id.tvRCVNgayKy)
        TextView tvRCVNgayKy;
        @BindView(R.id.tvRCVnguoiKy)
        TextView tvNguoiKyRCV;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
