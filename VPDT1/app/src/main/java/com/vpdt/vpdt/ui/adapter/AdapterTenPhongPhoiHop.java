package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.PhongBan;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTenPhongPhoiHop extends RecyclerView.Adapter<AdapterTenPhongPhoiHop.ViewHolder> {
    private ArrayList<PhongBan> listPhongban;
    private Context mContext;
    private OnItemClickListener1 listener;

    public AdapterTenPhongPhoiHop(Context context, ArrayList<PhongBan> listPhongban, OnItemClickListener1 listener) {
        this.mContext = context;
        this.listPhongban = listPhongban;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phongphoihop, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        PhongBan phongBan = listPhongban.get(position);

        viewHolder.cbTenPhongPhoiHop.setText(phongBan.getTenPhongBan());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick1(listPhongban.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPhongban.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cbTenPhongPhoiHop)
        CheckBox cbTenPhongPhoiHop;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public interface OnItemClickListener1 {
        void onItemClick1(PhongBan phongBan);
    }
}
