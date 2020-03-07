package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.NguoiKy_nhap;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterNguoiKyNhap extends RecyclerView.Adapter<AdapterNguoiKyNhap.ViewHolder> {
    private ArrayList<NguoiKy_nhap> khuVucArrayList;
    private OnItemNguoiKyClickListener listener;

    public AdapterNguoiKyNhap(ArrayList<NguoiKy_nhap> khuVucArrayList, OnItemNguoiKyClickListener listener) {
        this.khuVucArrayList = khuVucArrayList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ten_giam_doc, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        NguoiKy_nhap giamdocVaPhoGiamdoc = khuVucArrayList.get(position);
        viewHolder.tvTenGiamDoc.setText(giamdocVaPhoGiamdoc.getHoTen());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemNguoiKyClick(khuVucArrayList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return khuVucArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvTenGiamDoc)
        TextView tvTenGiamDoc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public interface OnItemNguoiKyClickListener {
        void onItemNguoiKyClick(NguoiKy_nhap giamdocVaPhoGiamdoc);
    }
}
