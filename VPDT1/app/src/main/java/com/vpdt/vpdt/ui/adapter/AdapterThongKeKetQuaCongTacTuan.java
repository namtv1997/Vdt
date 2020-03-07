package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.ThongKeKetQuaCongTacTuan;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterThongKeKetQuaCongTacTuan extends RecyclerView.Adapter<AdapterThongKeKetQuaCongTacTuan.ViewHolder> {
    private ArrayList<ThongKeKetQuaCongTacTuan> thongKeKetQuaCongTacTuanArrayList;
    private Context mContext;
//    private AdapterTuan.OnItemClickListener listener;

    public AdapterThongKeKetQuaCongTacTuan(Context context, ArrayList<ThongKeKetQuaCongTacTuan> thongKeKetQuaCongTacTuanArrayList) {
        this.mContext = context;
        this.thongKeKetQuaCongTacTuanArrayList = thongKeKetQuaCongTacTuanArrayList;
//        this.listener=listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_thongkeketquacongtactuan, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ThongKeKetQuaCongTacTuan thongKeKetQuaCongTacTuan = thongKeKetQuaCongTacTuanArrayList.get(position);
        for (int i = 0; i <= position + 1; ++i) {
            viewHolder.tvRCVSTT.setText(String.valueOf(i));
        }
        viewHolder.tvRCVCanBo.setText(String.valueOf(thongKeKetQuaCongTacTuan.getCanBo()));
        viewHolder.tvRCVPhong.setText(String.valueOf(thongKeKetQuaCongTacTuan.getPhongBan()));
        viewHolder.tvRCVTuan.setText(String.valueOf(thongKeKetQuaCongTacTuan.getTuan()));
        viewHolder.tvRCVSoDiem.setText(String.valueOf(thongKeKetQuaCongTacTuan.getSoDiem()));
        viewHolder.tvRCVDanhGiaCuaLDDonVi.setText(String.valueOf(thongKeKetQuaCongTacTuan.getNhanSet() + "\nNhận xét của trưởng đơn vị: " + thongKeKetQuaCongTacTuan.getNhanSetTruongDv()));
    }

    @Override
    public int getItemCount() {
        return thongKeKetQuaCongTacTuanArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvRCVSTT)
        TextView tvRCVSTT;
        @BindView(R.id.tvRCVCanBo)
        TextView tvRCVCanBo;
        @BindView(R.id.tvRCVPhong)
        TextView tvRCVPhong;
        @BindView(R.id.tvRCVTuan)
        TextView tvRCVTuan;
        @BindView(R.id.tvRCVSoDiem)
        TextView tvRCVSoDiem;
        @BindView(R.id.tvRCVDanhGiaCuaLDDonVi)
        TextView tvRCVDanhGiaCuaLDDonVi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }
}
