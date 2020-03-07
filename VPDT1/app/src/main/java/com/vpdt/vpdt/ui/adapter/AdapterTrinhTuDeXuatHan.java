package com.vpdt.vpdt.ui.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.TrinhTuDeXuatHan1;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTrinhTuDeXuatHan extends RecyclerView.Adapter<AdapterTrinhTuDeXuatHan.ViewHolder> {
    private ArrayList<TrinhTuDeXuatHan1> trinhTuGiaiQuyetDauViecArrayList;

    public AdapterTrinhTuDeXuatHan(ArrayList<TrinhTuDeXuatHan1> trinhTuGiaiQuyetDauViecArrayList) {
        this.trinhTuGiaiQuyetDauViecArrayList = trinhTuGiaiQuyetDauViecArrayList;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_trinhtugiaiquyet_quanlydauviec, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        TrinhTuDeXuatHan1 item = trinhTuGiaiQuyetDauViecArrayList.get(position);
        viewHolder.tvRCVSTT.setText(String.valueOf(position + 1));
        viewHolder.tvRCVNguoiNhan.setText(String.valueOf(item.getNguoiNhan()));
        viewHolder.tvRCVThoiGianChuyen.setText(String.valueOf(item.getThoiGian()));
        viewHolder.tvRCVNguoiChuyen.setText(item.getNguoiChuyen());
        viewHolder.tvRCVNoiDungChuyen.setText(item.getNoiDungChuyen());
        viewHolder.tvRCVHanXuLy.setText(item.getHanXuLy());

    }

    @Override
    public int getItemCount() {
        return trinhTuGiaiQuyetDauViecArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tvRCVSTT)
        TextView tvRCVSTT;
        @BindView(R.id.tvRCVThoiGianChuyen)
        TextView tvRCVThoiGianChuyen;
        @BindView(R.id.tvRCVNguoiChuyen)
        TextView tvRCVNguoiChuyen;
        @BindView(R.id.tvRCVNoiDungChuyen)
        TextView tvRCVNoiDungChuyen;
        @BindView(R.id.tvRCVNguoiNhan)
        TextView tvRCVNguoiNhan;
        @BindView(R.id.tvRCVHanXuLy)
        TextView tvRCVHanXuLy;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }
}
