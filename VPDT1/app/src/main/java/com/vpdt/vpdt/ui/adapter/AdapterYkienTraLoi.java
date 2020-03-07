package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.YkienPhanHoi;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterYkienTraLoi extends RecyclerView.Adapter<AdapterYkienTraLoi.ViewHolder> {
    private ArrayList<YkienPhanHoi> ykienPhanHoiArrayList;
    private Context mContext;

    public AdapterYkienTraLoi(Context mContext, ArrayList<YkienPhanHoi> ykienPhanHoiArrayList) {
        this.mContext = mContext;
        this.ykienPhanHoiArrayList = ykienPhanHoiArrayList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_dsykienphanhoi, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        YkienPhanHoi ykienPhanHoi = ykienPhanHoiArrayList.get(position);
        for (int stt = 1; stt <= position + 1; ++stt) {
            viewHolder.tvSTT.setText(String.valueOf(stt));
        }
        viewHolder.tvRCVNgayNhap.setText(String.valueOf(ykienPhanHoi.getNgayNhap()));
        if (ykienPhanHoi.getNgayNhap() != null) {
            viewHolder.tvRCVNgayNhap.setText(String.valueOf(ykienPhanHoi.getNgayNhap()));
        }
        if (ykienPhanHoi.getNoiDung() != null) {
            viewHolder.tvRCVNoiDung.setText(String.valueOf(ykienPhanHoi.getNoiDung()));
        }

        if (ykienPhanHoi.getNguoiKy() != null) {
            viewHolder.tvNguoiKyRCV.setText(String.valueOf(ykienPhanHoi.getNguoiKy()));
        }

    }

    @Override
    public int getItemCount() {
        return ykienPhanHoiArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvRCVSTT)
        TextView tvSTT;
        @BindView(R.id.tvRCVNgayNhap)
        TextView tvRCVNgayNhap;
        @BindView(R.id.tvRCVNoiDung)
        TextView tvRCVNoiDung;
        @BindView(R.id.tvRCVNguoiKy)
        TextView tvNguoiKyRCV;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
