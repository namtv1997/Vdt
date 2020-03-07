package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.DonViCanNhanVanban;
import com.vpdt.vpdt.model.NguoiNhan;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDonViCanNhanVanBan extends RecyclerView.Adapter<AdapterDonViCanNhanVanBan.ViewHolder> {
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private ArrayList<DonViCanNhanVanban> donViCanNhanVanbanArrayList;
    private Context mContext;
    int index = 0;

    public AdapterDonViCanNhanVanBan(Context mContext, ArrayList<DonViCanNhanVanban> donViCanNhanVanbanArrayList) {
        this.mContext = mContext;
        this.donViCanNhanVanbanArrayList = donViCanNhanVanbanArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_dsdonvicannhanvanban, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        index++;
        viewHolder.tvRCVSTT.setText(String.valueOf(index));


        DonViCanNhanVanban donViCanNhanVanban = donViCanNhanVanbanArrayList.get(position);

        viewHolder.tvRCVTenPhongBan.setText(String.valueOf(donViCanNhanVanban.getTenPhongBan()));
        viewHolder.tvRCVChuThich.setText(String.valueOf(donViCanNhanVanban.getGhiChu()));
        // Create layout manager with initial prefetch item count
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                viewHolder.rvNguoiNhan.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager.setInitialPrefetchItemCount(donViCanNhanVanban.getNguoiNhans().size());

        // Create sub item view adapter
        AdapterSubDonViCanNhanVanBan adapterSubDonViCanNhanVanBan = new AdapterSubDonViCanNhanVanBan((ArrayList<NguoiNhan>) donViCanNhanVanban.getNguoiNhans());

        viewHolder.rvNguoiNhan.setLayoutManager(layoutManager);
        viewHolder.rvNguoiNhan.setAdapter(adapterSubDonViCanNhanVanBan);
        viewHolder.rvNguoiNhan.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return donViCanNhanVanbanArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvRCVSTT)
        TextView tvRCVSTT;
        @BindView(R.id.tvRCVTenPhongBan)
        TextView tvRCVTenPhongBan;
        @BindView(R.id.rvNguoiNhan)
        RecyclerView rvNguoiNhan;
        @BindView(R.id.tvRCVChuThich)
        TextView tvRCVChuThich;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

}
