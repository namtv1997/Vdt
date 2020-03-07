package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.ItemThang;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterThongKeKetQuaCongTacThang extends RecyclerView.Adapter<AdapterThongKeKetQuaCongTacThang.ViewHolder> {
    private ArrayList<ItemThang> itemThangArrayList;

//    private AdapterTuan.OnItemClickListener listener;

    public AdapterThongKeKetQuaCongTacThang(ArrayList<ItemThang> itemThangArrayList) {

        this.itemThangArrayList = itemThangArrayList;
//        this.listener=listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_thongkeketquacongtacthang, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ItemThang itemThang = itemThangArrayList.get(position);

        viewHolder.tvRCVSTT.setText(String.valueOf(position + 1));

        viewHolder.tvRCVCanBo.setText(String.valueOf(itemThang.getCanBo()));
        viewHolder.tvRCVPhong.setText(String.valueOf(itemThang.getPhongBan()));
        viewHolder.tvRCVThang.setText(String.valueOf(itemThang.getThang()));
        viewHolder.tvRCVSoDiem.setText(String.valueOf(itemThang.getSoDiem()));
        viewHolder.tvRCVDanhGiaCuaLDDonVi.setText(String.valueOf(itemThang.getDanhgiaLanhdao()));

        if (itemThang.getNhanxetLanhdao() != null) ;

    }

    @Override
    public int getItemCount() {
        return itemThangArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvRCVSTT)
        TextView tvRCVSTT;
        @BindView(R.id.tvRCVCanBo)
        TextView tvRCVCanBo;
        @BindView(R.id.tvRCVPhong)
        TextView tvRCVPhong;
        @BindView(R.id.tvRCVThang)
        TextView tvRCVThang;
        @BindView(R.id.tvRCVSoDiem)
        TextView tvRCVSoDiem;
        @BindView(R.id.tvRCVDanhGiaCuaLDDonVi)
        TextView tvRCVDanhGiaCuaLDDonVi;
        @BindView(R.id.tvRCVKetQuaPhanLoai)
        TextView tvRCVKetQuaPhanLoai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
