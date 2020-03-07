package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDeXuatGiaHanChoXuLy extends RecyclerView.Adapter<AdapterDeXuatGiaHanChoXuLy.ViewHolder> {
    private ArrayList<String> stringArrayList;


    public AdapterDeXuatGiaHanChoXuLy(ArrayList<String> stringArrayList) {
        this.stringArrayList = stringArrayList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trinh_tu_xu_ly, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        String s = stringArrayList.get(position);
        viewHolder.tvStt.setText(String.valueOf(position + 1));
        viewHolder.tvTenTrinhTuXuLy.setText(String.valueOf(s));
    }

    @Override
    public int getItemCount() {
        return stringArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvStt)
        TextView tvStt;
        @BindView(R.id.tvTenTrinhTuXuLy)
        TextView tvTenTrinhTuXuLy;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
