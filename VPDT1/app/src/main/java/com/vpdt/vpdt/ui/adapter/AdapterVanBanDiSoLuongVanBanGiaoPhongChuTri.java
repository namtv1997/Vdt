package com.vpdt.vpdt.ui.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.VanBanDiChoLanhDaoPhongPheDuyet;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterVanBanDiSoLuongVanBanGiaoPhongChuTri extends RecyclerView.Adapter<AdapterVanBanDiSoLuongVanBanGiaoPhongChuTri.ViewHolder> {
    private ArrayList<VanBanDiChoLanhDaoPhongPheDuyet> detailVanBanDiTongTheArrayList;
    private OnItemClickListenerVanBanDiSoLuongVanBanGiaoPhongChuTri listener;


    public AdapterVanBanDiSoLuongVanBanGiaoPhongChuTri(ArrayList<VanBanDiChoLanhDaoPhongPheDuyet> detailVanBanDiTongTheArrayList, OnItemClickListenerVanBanDiSoLuongVanBanGiaoPhongChuTri listener) {
        this.detailVanBanDiTongTheArrayList = detailVanBanDiTongTheArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_vanbandi2, parent, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        VanBanDiChoLanhDaoPhongPheDuyet dsvb_daChiDao = detailVanBanDiTongTheArrayList.get(position);
        viewHolder.tvRCVSTT.setText(String.valueOf(position + 1));
        if (!dsvb_daChiDao.getSoVanBanDi().isEmpty()) {
            viewHolder.tvRCVSoVanBanDi.setText(String.valueOf(dsvb_daChiDao.getSoVanBanDi()));
        }
        viewHolder.tvRCVNgayVanBan.setText(String.valueOf(dsvb_daChiDao.getNgayVanBan()));
        viewHolder.tvRCVTrichYeu.setText(String.valueOf(dsvb_daChiDao.getMota()));
        if (!dsvb_daChiDao.getUrlFile().isEmpty()) {
            viewHolder.tvRCVXemFile.setVisibility(View.VISIBLE);
        }
        viewHolder.tvRCVXemFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (detailVanBanDiTongTheArrayList.size() > 0) {
                        listener.onItemClickVanBanDiSoLuongVanBanGiaoPhongChuTri(detailVanBanDiTongTheArrayList.get(position));

                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return detailVanBanDiTongTheArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvRCVSTT)
        TextView tvRCVSTT;
        @BindView(R.id.tvRCVSoVanBanDi)
        TextView tvRCVSoVanBanDi;
        @BindView(R.id.tvRCVNgayVanBan)
        TextView tvRCVNgayVanBan;
        @BindView(R.id.tvRCVTrichYeu)
        TextView tvRCVTrichYeu;
        @BindView(R.id.tvRCVXemFile)
        TextView tvRCVXemFile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public interface OnItemClickListenerVanBanDiSoLuongVanBanGiaoPhongChuTri {
        void onItemClickVanBanDiSoLuongVanBanGiaoPhongChuTri(VanBanDiChoLanhDaoPhongPheDuyet vanBanDiChoLanhDaoPhongPheDuyet);
    }
}
