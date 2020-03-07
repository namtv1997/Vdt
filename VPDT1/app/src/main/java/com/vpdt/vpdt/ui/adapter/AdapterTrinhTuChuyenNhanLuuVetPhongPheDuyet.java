package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.TrinhTuChuyenNhanLuuVetChoLanhDaoPhongPheDuyet;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTrinhTuChuyenNhanLuuVetPhongPheDuyet extends RecyclerView.Adapter<AdapterTrinhTuChuyenNhanLuuVetPhongPheDuyet.ViewHolder> {
    private ArrayList<TrinhTuChuyenNhanLuuVetChoLanhDaoPhongPheDuyet> trinhTuChuyenNhanLuuVets;

    public AdapterTrinhTuChuyenNhanLuuVetPhongPheDuyet(ArrayList<TrinhTuChuyenNhanLuuVetChoLanhDaoPhongPheDuyet> trinhTuChuyenNhanLuuVets) {
        this.trinhTuChuyenNhanLuuVets = trinhTuChuyenNhanLuuVets;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_trinhtuchuyennhanluuviet, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        TrinhTuChuyenNhanLuuVetChoLanhDaoPhongPheDuyet trinhTuChuyenNhanLuuVet = trinhTuChuyenNhanLuuVets.get(position);
        viewHolder.tvRCVSTTTTTNLV.setText(String.valueOf(position + 1));
        viewHolder.tvRCVNgayNhanTTTNLV.setText(String.valueOf(trinhTuChuyenNhanLuuVet.getNgayNhan()));
        viewHolder.tvRCVChuyenTuTTTNLV.setText(String.valueOf(trinhTuChuyenNhanLuuVet.getChuyenTu()));
        viewHolder.tvRCVNoiDungTTTNLV.setText(String.valueOf(trinhTuChuyenNhanLuuVet.getNoiDung()));
        viewHolder.tvRCVChuyenDenTTTNLV.setText(String.valueOf(trinhTuChuyenNhanLuuVet.getChuyenDen()));

    }

    @Override
    public int getItemCount() {
        return trinhTuChuyenNhanLuuVets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvRCVSTTTTTNLV)
        TextView tvRCVSTTTTTNLV;
        @BindView(R.id.tvRCVNgayNhanTTTNLV)
        TextView tvRCVNgayNhanTTTNLV;
        @BindView(R.id.tvRCVChuyenTuTTTNLV)
        TextView tvRCVChuyenTuTTTNLV;
        @BindView(R.id.tvRCVNoiDungTTTNLV)
        TextView tvRCVNoiDungTTTNLV;
        @BindView(R.id.tvRCVChuyenDenTTTNLV)
        TextView tvRCVChuyenDenTTTNLV;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
