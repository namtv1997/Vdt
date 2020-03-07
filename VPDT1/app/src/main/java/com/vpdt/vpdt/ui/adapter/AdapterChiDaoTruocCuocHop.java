package com.vpdt.vpdt.ui.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.Chidao;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterChiDaoTruocCuocHop extends RecyclerView.Adapter<AdapterChiDaoTruocCuocHop.ViewHolder> {
    private ArrayList<Chidao> chidaoArrayList;

    public AdapterChiDaoTruocCuocHop(ArrayList<Chidao> chidaoArrayList) {
        this.chidaoArrayList = chidaoArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chidaocuochop, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Chidao chidao = chidaoArrayList.get(position);
        viewHolder.tvTuan.setText(String.valueOf(chidao.getChuyennhan()));
    }

    @Override
    public int getItemCount() {
        return chidaoArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvTuan)
        TextView tvTuan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

}
