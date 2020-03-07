package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.MucDanhGia;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterChonPhoiHopPhongChuTri extends RecyclerView.Adapter<AdapterChonPhoiHopPhongChuTri.ViewHolder> {
    private ArrayList<MucDanhGia> giamdocVaPhoGiamdocArrayList;
    private OnItemClickListenerPhoPhongPhoiHop listener;

    public AdapterChonPhoiHopPhongChuTri(ArrayList<MucDanhGia> giamdocVaPhoGiamdocArrayList, OnItemClickListenerPhoPhongPhoiHop listener) {

        this.giamdocVaPhoGiamdocArrayList = giamdocVaPhoGiamdocArrayList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ten_phong_phoi_hop, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        MucDanhGia phongBan = giamdocVaPhoGiamdocArrayList.get(position);

        viewHolder.cbTenPhongPhoiHop.setText(phongBan.getName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickPhoPhongPhoiHop(giamdocVaPhoGiamdocArrayList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return giamdocVaPhoGiamdocArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cbTenPhongPhoiHop)
        CheckBox cbTenPhongPhoiHop;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public interface OnItemClickListenerPhoPhongPhoiHop {
        void onItemClickPhoPhongPhoiHop(MucDanhGia mucDanhGia);
    }
}
