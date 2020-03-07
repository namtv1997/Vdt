package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.CanBoByidPhongBan;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTenCanBo extends RecyclerView.Adapter<AdapterTenCanBo.ViewHolder> {
    private ArrayList<CanBoByidPhongBan> canBoByidPhongBanArrayList;
    private Context mContext;
    private OnItemClickListener listener;

    public AdapterTenCanBo(Context context, ArrayList<CanBoByidPhongBan> canBoByidPhongBanArrayList, OnItemClickListener listener) {
        this.mContext = context;
        this.canBoByidPhongBanArrayList = canBoByidPhongBanArrayList;
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
        CanBoByidPhongBan phongBan = canBoByidPhongBanArrayList.get(position);
        viewHolder.tvTenPhong.setText(phongBan.getHoTen());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(canBoByidPhongBanArrayList.get(position));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return canBoByidPhongBanArrayList.size();
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
        void onItemClick(CanBoByidPhongBan canBoByidPhongBan);
    }
}
