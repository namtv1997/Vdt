package com.vpdt.vpdt.ui.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.DauViecHoanThanhChoLanhDaoPhongDuyet;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDauViecHoanThanhChoLanhDaoPhongDuyet extends RecyclerView.Adapter<AdapterDauViecHoanThanhChoLanhDaoPhongDuyet.ViewHolder> {
    private ArrayList<DauViecHoanThanhChoLanhDaoPhongDuyet> DSKienNghiHDNDList;
    private OnItemClickListener listener;


    public AdapterDauViecHoanThanhChoLanhDaoPhongDuyet(ArrayList<DauViecHoanThanhChoLanhDaoPhongDuyet> DSKienNghiHDNDList, OnItemClickListener listener) {
        this.DSKienNghiHDNDList = DSKienNghiHDNDList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_traodoittnoibo5, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        DauViecHoanThanhChoLanhDaoPhongDuyet giaHanGiaiQuyet = DSKienNghiHDNDList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvSKH.setText(String.valueOf(giaHanGiaiQuyet.getTieuDe()));
        viewHolder.tvnoigui.setText(String.valueOf(giaHanGiaiQuyet.getThoiGian()));
        viewHolder.tvLoaiVanBan.setText(String.valueOf("Loại văn bản: " + giaHanGiaiQuyet.getLoaiVanBan()));
        if (giaHanGiaiQuyet.getLoaiVanBan() == null) {
            viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getLoaiVanBan().isEmpty()) {
                viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
            } else {
                viewHolder.tvLoaiVanBan.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvMoTa.setText(String.valueOf(giaHanGiaiQuyet.getMoTa()));
        if (giaHanGiaiQuyet.getMoTa() == null) {
            viewHolder.tvMoTa.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getMoTa().isEmpty()) {
                viewHolder.tvMoTa.setVisibility(View.GONE);
            } else {
                viewHolder.tvMoTa.setVisibility(View.VISIBLE);
            }
        }

//        if (giaHanGiaiQuyet.getNgayPhap().isEmpty() || giaHanGiaiQuyet.getNgayPhap() == null) {
        viewHolder.tvNgayNhap.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvNgayNhap.setText(String.valueOf("Ngày nhập: " + giaHanGiaiQuyet.getNgayPhap()));
//        }

//        if (giaHanGiaiQuyet.geth().isEmpty() || giaHanGiaiQuyet.getHanGiaiQuyet() == null) {
        viewHolder.tvHanXuLy.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvHanXuLy.setText(String.valueOf("Hạn giải quyết: " + giaHanGiaiQuyet.getHanGiaiQuyet()));
//        }

//        if (giaHanGiaiQuyet.getng().isEmpty() || giaHanGiaiQuyet.getNguoiNhap() == null) {
        viewHolder.tvNguoiNhap.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvNguoiNhap.setText(String.valueOf("Người nhập: " + giaHanGiaiQuyet.getNguoiNhap()));
//        }

//        if (giaHanGiaiQuyet.getNoiDung() == null || giaHanGiaiQuyet.getNoiDung().isEmpty()) {
        viewHolder.tvNoiDung.setVisibility(View.GONE);
        viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvNoiDung.setText(String.valueOf(giaHanGiaiQuyet.getNoiDung()));
//        }

//        if (giaHanGiaiQuyet.getSoTrang().isEmpty() || giaHanGiaiQuyet.getSoTrang() == null) {
//        if (giaHanGiaiQuyet.getGiayMoiGio().isEmpty() || giaHanGiaiQuyet.getGiayMoiGio() == null) {
        viewHolder.tvSoTrang.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvSoTrang.setText(String.valueOf("(Vào hồi: "
//                    + giaHanGiaiQuyet.getGiayMoiGio() + " ngày " + giaHanGiaiQuyet.getGiayMoiNgay() + ", tại "
//                    + giaHanGiaiQuyet.getGiayMoiDiadiem() + ")"));
//        }
//        } else {
//            if (giaHanGiaiQuyet.getGiayMoiGio().isEmpty() || giaHanGiaiQuyet.getGiayMoiGio() == null) {
//                viewHolder.tvSoTrang.setText(String.valueOf("(Số trang: " + giaHanGiaiQuyet.getSoTrang() + ")"));
//            } else {
//                viewHolder.tvSoTrang.setText(String.valueOf("(Số trang: " + giaHanGiaiQuyet.getSoTrang() + ") | (Vào hồi: "
//                        + giaHanGiaiQuyet.getGiayMoiGio() + " ngày " + giaHanGiaiQuyet.getGiayMoiNgay() + ", tại "
//                        + giaHanGiaiQuyet.getGiayMoiDiaDiem() + ")"));
//            }
//        }

        viewHolder.btnXemFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (DSKienNghiHDNDList.size() > 0) {
                        listener.onItemClickXemFile(DSKienNghiHDNDList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (DSKienNghiHDNDList.size() > 0) {
                        listener.onItemClickXuLy(DSKienNghiHDNDList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXemChiTiet.setVisibility(View.GONE);
        viewHolder.btnXemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (DSKienNghiHDNDList.size() > 0) {
                        listener.onItemClickXemChiTiet(DSKienNghiHDNDList.get(position));
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return DSKienNghiHDNDList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvSTT)
        TextView tvSTT;
        @BindView(R.id.tvSKH)
        TextView tvSKH;
        @BindView(R.id.tvnoigui)
        TextView tvnoigui;
        @BindView(R.id.tvLoaiVanBan)
        TextView tvLoaiVanBan;
        @BindView(R.id.tvMoTa)
        TextView tvMoTa;
        @BindView(R.id.tvSoTrang)
        TextView tvSoTrang;
        @BindView(R.id.tvNguoiNhap)
        TextView tvNguoiNhap;
        @BindView(R.id.tvTieuDeNoiDung)
        TextView tvTieuDeNoiDung;
        @BindView(R.id.tvNoiDung)
        TextView tvNoiDung;
        @BindView(R.id.tvNgayNhap)
        TextView tvNgayNhap;
        @BindView(R.id.tvHanXuLy)
        TextView tvHanXuLy;

        @BindView(R.id.btnXemFile)
        Button btnXemFile;
        @BindView(R.id.btnXuLy)
        Button btnXuLy;
        @BindView(R.id.btnXemChiTiet)
        Button btnXemChiTiet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public interface OnItemClickListener {
        void onItemClickXemFile(DauViecHoanThanhChoLanhDaoPhongDuyet dauViecHoanThanhChoLanhDaoPhongDuyet);

        void onItemClickXuLy(DauViecHoanThanhChoLanhDaoPhongDuyet dauViecHoanThanhChoLanhDaoPhongDuyet);

        void onItemClickXemChiTiet(DauViecHoanThanhChoLanhDaoPhongDuyet dauViecHoanThanhChoLanhDaoPhongDuyet);
    }
}