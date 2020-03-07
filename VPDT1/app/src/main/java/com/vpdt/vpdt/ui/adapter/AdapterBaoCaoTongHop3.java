package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.VanbanBaoCaoTongHop;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterBaoCaoTongHop3 extends RecyclerView.Adapter<AdapterBaoCaoTongHop3.ViewHolder> {
    private ArrayList<VanbanBaoCaoTongHop> vanbanBaoCaoTongHopArrayList;
    private OnItemClickListener listener;

    public AdapterBaoCaoTongHop3(ArrayList<VanbanBaoCaoTongHop> vanbanBaoCaoTongHopArrayList, OnItemClickListener listener) {
        this.vanbanBaoCaoTongHopArrayList = vanbanBaoCaoTongHopArrayList;
        this.listener = listener;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_bao_cao_tong_hop3, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        VanbanBaoCaoTongHop vanbanBaoCaoTongHop = vanbanBaoCaoTongHopArrayList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvRCVSoDen.setText(String.valueOf(vanbanBaoCaoTongHop.getSoden()));
        viewHolder.tvRCVSoKyHieu.setText(String.valueOf(vanbanBaoCaoTongHop.getKyhieu()));
        viewHolder.tvRCVNgayBanHanh.setText(String.valueOf(vanbanBaoCaoTongHop.getNgayBanHanh()));
        viewHolder.tvRCVNoiDung.setText(String.valueOf(vanbanBaoCaoTongHop.getNoidung()));
//        viewHolder.tvXemFile.setText(String.valueOf(vanbanBaoCaoTongHop.getDuongdanNoidung()));
        viewHolder.tvRCVNgayGiao.setText(String.valueOf(vanbanBaoCaoTongHop.getNgaygiao()));
        viewHolder.tvRCVPhongBanDonViChuTri.setText(String.valueOf(vanbanBaoCaoTongHop.getDonvi()));
        viewHolder.tvRCVPhongBanDonViPhoiHop.setText(String.valueOf(vanbanBaoCaoTongHop.getDonviPhoihop()));

        if (vanbanBaoCaoTongHop.getTgianGiahan() == null) {
            viewHolder.tvRCVThoiHanHoanThanh.setText(String.valueOf(vanbanBaoCaoTongHop.getTgianHt()));
        } else {
            viewHolder.tvRCVThoiHanHoanThanh.setText(String.valueOf(vanbanBaoCaoTongHop.getTgianHt()
                    + " (VB được gia hạn: " + vanbanBaoCaoTongHop.getTgianGiahan() + ")"));
        }
        viewHolder.tvRCVTinhHinhTrienKhai.setText(String.valueOf(vanbanBaoCaoTongHop.getKetqua()));

        if (vanbanBaoCaoTongHop.getDuongdanKetqua().isEmpty()) {
            viewHolder.tvXemFile1.setVisibility(View.GONE);
        } else {
            viewHolder.tvXemFile1.setVisibility(View.VISIBLE);
        }
//        viewHolder.tvXemFile1.setText(String.valueOf(vanbanBaoCaoTongHop.getDuongdanKetqua()));
//        viewHolder.tvRCVTongSo.setText(String.valueOf(vanbanBaoCaoTongHop.getT()));
        viewHolder.tvRCVDangTrienKhaiChuaDenHan.setText(String.valueOf(vanbanBaoCaoTongHop.getDangtrienkhaiTronghan()));
        viewHolder.tvRCVDangTrienKhaiQuaHan.setText(String.valueOf(vanbanBaoCaoTongHop.getDangtrienkhaiQuahan()));
        viewHolder.tvRCVHoanThanhTrongHan.setText(String.valueOf(vanbanBaoCaoTongHop.getHoanthanhTronghan()));
        viewHolder.tvRCVHoanThanhQuaHan.setText(String.valueOf(vanbanBaoCaoTongHop.getHoanthanhQuahan()));
        //        viewHolder.tvRCVKhoKhanVuongMac.setText(String.valueOf(phongbanBaoCaoTongHop.get()));
//        viewHolder.tvRCVGhiChu.setText(String.valueOf(phongbanBaoCaoTongHop.get()));
        viewHolder.tvXemFile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickXemFile1(vanbanBaoCaoTongHopArrayList.get(position));
                }
            }
        });

        viewHolder.tvXemFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickXemFile(vanbanBaoCaoTongHopArrayList.get(position));
                }
            }
        });
        viewHolder.tvRCVNoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickNoiDung(vanbanBaoCaoTongHopArrayList.get(position));
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return vanbanBaoCaoTongHopArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvSTT)
        TextView tvSTT;
        @BindView(R.id.tvRCVSoDen)
        TextView tvRCVSoDen;
        @BindView(R.id.tvRCVSoKyHieu)
        TextView tvRCVSoKyHieu;
        @BindView(R.id.tvRCVNgayBanHanh)
        TextView tvRCVNgayBanHanh;
        @BindView(R.id.tvRCVNoiDung)
        TextView tvRCVNoiDung;
        @BindView(R.id.tvXemFile)
        TextView tvXemFile;
        @BindView(R.id.tvXemFile1)
        TextView tvXemFile1;
        @BindView(R.id.tvRCVNgayGiao)
        TextView tvRCVNgayGiao;
        @BindView(R.id.tvRCVPhongBanDonViChuTri)
        TextView tvRCVPhongBanDonViChuTri;
        @BindView(R.id.tvRCVPhongBanDonViPhoiHop)
        TextView tvRCVPhongBanDonViPhoiHop;
        @BindView(R.id.tvRCVThoiHanHoanThanh)
        TextView tvRCVThoiHanHoanThanh;
        @BindView(R.id.tvRCVTinhHinhTrienKhai)
        TextView tvRCVTinhHinhTrienKhai;
        @BindView(R.id.tvRCVTongSo)
        TextView tvRCVTongSo;
        @BindView(R.id.tvRCVDangTrienKhaiChuaDenHan)
        TextView tvRCVDangTrienKhaiChuaDenHan;
        @BindView(R.id.tvRCVDangTrienKhaiQuaHan)
        TextView tvRCVDangTrienKhaiQuaHan;
        @BindView(R.id.tvRCVHoanThanhTrongHan)
        TextView tvRCVHoanThanhTrongHan;
        @BindView(R.id.tvRCVHoanThanhQuaHan)
        TextView tvRCVHoanThanhQuaHan;
        @BindView(R.id.tvRCVKhoKhanVuongMac)
        TextView tvRCVKhoKhanVuongMac;
        @BindView(R.id.tvRCVGhiChu)
        TextView tvRCVGhiChu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public interface OnItemClickListener {
        void onItemClickXemFile(VanbanBaoCaoTongHop vanbanBaoCaoTongHop);

        void onItemClickXemFile1(VanbanBaoCaoTongHop vanbanBaoCaoTongHop);

        void onItemClickNoiDung(VanbanBaoCaoTongHop vanbanBaoCaoTongHop);
    }
}
