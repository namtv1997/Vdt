package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.PhongBan;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDanhSachVanBanCanNhanVanBan extends RecyclerView.Adapter<AdapterDanhSachVanBanCanNhanVanBan.ViewHolder> {
    private ArrayList<PhongBan> listPhongban;
    private Context mContext;
    private OnItemClickListenerDanhSachVanBanCanNhanVanBan listener;

    public AdapterDanhSachVanBanCanNhanVanBan(Context context, ArrayList<PhongBan> listPhongban, OnItemClickListenerDanhSachVanBanCanNhanVanBan listener) {
        this.mContext = context;
        this.listPhongban = listPhongban;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_soanbaocao, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        PhongBan phongBan = listPhongban.get(position);
        viewHolder.tvTenPhongBan.setText(phongBan.getTenPhongBan());
        if (position == 0) {
            viewHolder.tvNguoiNhan.setVisibility(View.VISIBLE);
        } else {
            viewHolder.tvNguoiNhan.setVisibility(View.GONE);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(listPhongban.get(position), position, v);
                }
            }
        });
        viewHolder.tvNguoiNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onNguoiNhanClick(listPhongban.get(position), 0, v);
                }
            }
        });
        viewHolder.cbChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onCheckBoxClick(listPhongban.get(position), 0, v);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return listPhongban.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cbChon)
        CheckBox cbChon;

        @BindView(R.id.tvTenPhongBan)
        TextView tvTenPhongBan;
        @BindView(R.id.tvNguoiNhan)
        TextView tvNguoiNhan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public interface OnItemClickListenerDanhSachVanBanCanNhanVanBan {
        void onItemClick(PhongBan phongBan, int position, View v);

        void onNguoiNhanClick(PhongBan phongBan, int position, View v);

        void onCheckBoxClick(PhongBan phongBan, int position, View v);
    }
}
