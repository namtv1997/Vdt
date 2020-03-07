package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTenChuyenVien extends RecyclerView.Adapter<AdapterTenChuyenVien.ViewHolder> {
    private ArrayList<GiamdocVaPhoGiamdoc> listTenGiamDoc;

    private OnItemClickListenerChuyenVien listener;

    public AdapterTenChuyenVien(ArrayList<GiamdocVaPhoGiamdoc> listTenGiamDoc, OnItemClickListenerChuyenVien listener) {

        this.listTenGiamDoc = listTenGiamDoc;
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
        GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc = listTenGiamDoc.get(position);
        viewHolder.tvTenGiamDoc.setText(giamdocVaPhoGiamdoc.getHoTen());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickChuyenVien(listTenGiamDoc.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTenGiamDoc.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvTenGiamDoc)
        TextView tvTenGiamDoc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public interface OnItemClickListenerChuyenVien {
        void onItemClickChuyenVien(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc);
    }
}
