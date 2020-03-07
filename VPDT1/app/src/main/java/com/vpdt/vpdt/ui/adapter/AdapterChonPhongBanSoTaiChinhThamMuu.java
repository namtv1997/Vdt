package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.DetailDanhSachVanBanSoThamMuuTrinhThanhPho;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterChonPhongBanSoTaiChinhThamMuu extends RecyclerView.Adapter<AdapterChonPhongBanSoTaiChinhThamMuu.ViewHolder> {
    private ArrayList<DetailDanhSachVanBanSoThamMuuTrinhThanhPho> detailDanhSachVanBanSoThamMuuTrinhThanhPhoArrayList;
    private Context mContext;
    private OnItemClickListener listener;

    public AdapterChonPhongBanSoTaiChinhThamMuu(Context context, ArrayList<DetailDanhSachVanBanSoThamMuuTrinhThanhPho> detailDanhSachVanBanSoThamMuuTrinhThanhPhoArrayList, OnItemClickListener listener) {
        this.mContext = context;
        this.detailDanhSachVanBanSoThamMuuTrinhThanhPhoArrayList = detailDanhSachVanBanSoThamMuuTrinhThanhPhoArrayList;
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
        DetailDanhSachVanBanSoThamMuuTrinhThanhPho detailDanhSachVanBanSoThamMuuTrinhThanhPho = detailDanhSachVanBanSoThamMuuTrinhThanhPhoArrayList.get(position);
        viewHolder.tvNam.setText(String.valueOf(detailDanhSachVanBanSoThamMuuTrinhThanhPho.getTen()));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(detailDanhSachVanBanSoThamMuuTrinhThanhPhoArrayList.get(position));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return detailDanhSachVanBanSoThamMuuTrinhThanhPhoArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvNam)
        TextView tvNam;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public interface OnItemClickListener {
        void onItemClick(DetailDanhSachVanBanSoThamMuuTrinhThanhPho detailDanhSachVanBanSoThamMuuTrinhThanhPhoArrayList);
    }
}
