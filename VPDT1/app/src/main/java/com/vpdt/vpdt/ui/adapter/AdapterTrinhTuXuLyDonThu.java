package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyet;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTrinhTuXuLyDonThu extends RecyclerView.Adapter<AdapterTrinhTuXuLyDonThu.ViewHolder> {
    private ArrayList<TrinhTuGiaiQuyet> trinhTuKyArrayList;
    private Context mContext;

    public AdapterTrinhTuXuLyDonThu(Context mContext, ArrayList<TrinhTuGiaiQuyet> trinhTuKyArrayList) {
        this.mContext = mContext;
        this.trinhTuKyArrayList = trinhTuKyArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trinh_tu_xu_ly, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        TrinhTuGiaiQuyet trinhTuKy = trinhTuKyArrayList.get(position);
        viewHolder.tvTenTrinhTuXuLy.setText(String.valueOf(trinhTuKy.getChuyenDen()));
        viewHolder.tvStt.setText(String.valueOf(position + 1));

    }

    @Override
    public int getItemCount() {
        return trinhTuKyArrayList.size();
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
