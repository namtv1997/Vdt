package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.PhongBanKeHoachDanhGia;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTenPhongKeHoach extends RecyclerView.Adapter<AdapterTenPhongKeHoach.ViewHolder> {
    private ArrayList<PhongBanKeHoachDanhGia> listPhongban;
    private Context mContext;
    private OnItemClickListener listener;

    public AdapterTenPhongKeHoach(Context context, ArrayList<PhongBanKeHoachDanhGia> listPhongban, OnItemClickListener listener) {
        this.mContext = context;
        this.listPhongban = listPhongban;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ten_phong, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        PhongBanKeHoachDanhGia phongBanKeHoachDanhGia = listPhongban.get(position);
        viewHolder.tvTenPhong.setText(phongBanKeHoachDanhGia.getTenpb());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(listPhongban.get(position));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return listPhongban.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvTenPhong)
        TextView tvTenPhong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public interface OnItemClickListener {
        void onItemClick(PhongBanKeHoachDanhGia phongBanKeHoachDanhGia);
    }
}
