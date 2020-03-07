package com.vpdt.vpdt.ui.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.NguoiNhan;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterSubDonViCanNhanVanBan extends RecyclerView.Adapter<AdapterSubDonViCanNhanVanBan.ViewHolder> {
    private ArrayList<NguoiNhan> nguoiNhanArrayList;

    public AdapterSubDonViCanNhanVanBan(ArrayList<NguoiNhan> nguoiNhanArrayList) {

        this.nguoiNhanArrayList = nguoiNhanArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_don_vi_can_nhan_sub, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {


        NguoiNhan nguoiNhan = nguoiNhanArrayList.get(position);

        viewHolder.tvNameCanBo.setText(String.valueOf(nguoiNhan.getTenCanbo()));
        viewHolder.tvTime.setText(String.valueOf(nguoiNhan.getThoiGianXem()));
        if (nguoiNhan.getThoiGianXem().equals("")) {
            viewHolder.tvTime.setText("Chưa Xem");
            viewHolder.tvTime.setTextColor(Color.RED);
        }

    }

    @Override
    public int getItemCount() {
        return nguoiNhanArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvNameCanBo)
        TextView tvNameCanBo;
        @BindView(R.id.tvTime)
        TextView tvTime;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
