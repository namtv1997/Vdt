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

public class AdapterBaoCaoKetQuaCuocHop extends RecyclerView.Adapter<AdapterBaoCaoKetQuaCuocHop.ViewHolder> {
    private ArrayList<String> stringArrayList;

    public AdapterBaoCaoKetQuaCuocHop(ArrayList<String> stringArrayList) {
        this.stringArrayList = stringArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trinh_tu_xu_ly, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        String s = stringArrayList.get(position);
        viewHolder.tvTenTrinhTuXuLy.setText(String.valueOf(s));
        for (int stt = 1; stt <= position + 1; ++stt) {
            viewHolder.tvStt.setText(String.valueOf(stt));
        }
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
