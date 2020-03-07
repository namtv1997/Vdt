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

public class AdapterChonThang extends RecyclerView.Adapter<AdapterChonThang.ViewHolder> {
    private ArrayList<Integer> integerArrayList;
    private OnItemClickListenerChonThang listener;

    public AdapterChonThang(ArrayList<Integer> integerArrayList, OnItemClickListenerChonThang listener) {
        this.integerArrayList = integerArrayList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nam, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Integer integer = integerArrayList.get(position);
        viewHolder.tvNam.setText("Tháng " + integer);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickChonThang(integerArrayList.get(position));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return integerArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvNam)
        TextView tvNam;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public interface OnItemClickListenerChonThang {
        void onItemClickChonThang(Integer integer);
    }
}
