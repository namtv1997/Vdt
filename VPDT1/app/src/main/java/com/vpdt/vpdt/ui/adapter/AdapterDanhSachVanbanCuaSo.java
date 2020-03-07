package com.vpdt.vpdt.ui.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.DetailVanBanDiTongThe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDanhSachVanbanCuaSo extends RecyclerView.Adapter<AdapterDanhSachVanbanCuaSo.ViewHolder> {
    private ArrayList<DetailVanBanDiTongThe> detailVanBanDiTongTheArrayList;
    private Context mContext;
    private OnItemClickListener listener;


    public AdapterDanhSachVanbanCuaSo(Context mContext, ArrayList<DetailVanBanDiTongThe> detailVanBanDiTongTheArrayList, OnItemClickListener listener) {
        this.mContext = mContext;
        this.detailVanBanDiTongTheArrayList = detailVanBanDiTongTheArrayList;
        this.listener = listener;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_vanbandi5, parent, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        DetailVanBanDiTongThe giaHanGiaiQuyet = detailVanBanDiTongTheArrayList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvSKH.setText(String.valueOf(giaHanGiaiQuyet.getKyhieu()));
        viewHolder.tvsodendo.setText(String.valueOf(giaHanGiaiQuyet.getSodi()));
        viewHolder.tvnoigui.setText(String.valueOf(giaHanGiaiQuyet.getSoden()));
        viewHolder.tvLoaiVanBan.setText(String.valueOf("Loại văn bản: " + giaHanGiaiQuyet.getTenloaivanban()));
        if (giaHanGiaiQuyet.getTenloaivanban() == null) {
            viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getTenloaivanban().isEmpty()) {
                viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
            } else {
                viewHolder.tvLoaiVanBan.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvMoTa.setText(String.valueOf(giaHanGiaiQuyet.getTy().getMota()));
        if (giaHanGiaiQuyet.getTy().getMota() == null) {
            viewHolder.tvMoTa.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getTy().getMota().isEmpty()) {
                viewHolder.tvMoTa.setVisibility(View.GONE);
            } else {
                viewHolder.tvMoTa.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvNgayNhap.setText(String.valueOf("Ngày nhập: " + giaHanGiaiQuyet.getNgaynhap()));
        if (giaHanGiaiQuyet.getNgaynhap() == null) {
            viewHolder.tvNgayNhap.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getNgaynhap().isEmpty()) {
                viewHolder.tvNgayNhap.setVisibility(View.GONE);
            } else {
                viewHolder.tvNgayNhap.setVisibility(View.VISIBLE);
            }
        }

//        if (giaHanGiaiQuyet.getHanGiaiQuyet().isEmpty() || giaHanGiaiQuyet.getHanGiaiQuyet() == null) {
        viewHolder.tvHanXuLy.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvHanXuLy.setText(String.valueOf("Hạn giải quyết: " + giaHanGiaiQuyet.getTy().));
//        }

        viewHolder.tvNguoiNhap.setText(String.valueOf("Người ký: " + giaHanGiaiQuyet.getTy().getNguoiKy()));
        if (giaHanGiaiQuyet.getTy().getNguoiKy() == null) {
            viewHolder.tvNguoiNhap.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getTy().getNguoiKy().isEmpty()) {
                viewHolder.tvNguoiNhap.setVisibility(View.GONE);
            } else {
                viewHolder.tvNguoiNhap.setVisibility(View.VISIBLE);
            }
        }

//        if (giaHanGiaiQuyet.getn().isEmpty() || giaHanGiaiQuyet.getNoiDung() == null) {
        viewHolder.tvNoiDung.setVisibility(View.GONE);
        viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvNoiDung.setText(String.valueOf(giaHanGiaiQuyet.getNoiDung()));
//        }

//        if (giaHanGiaiQuyet.getSoTrang().isEmpty() || giaHanGiaiQuyet.getSoTrang() == null) {
//            if (giaHanGiaiQuyet.getGiayMoiGio().isEmpty() || giaHanGiaiQuyet.getGiayMoiGio() == null) {
        viewHolder.tvSoTrang.setVisibility(View.GONE);
//            } else {
//                viewHolder.tvSoTrang.setText(String.valueOf("(Vào hồi: "
//                        + giaHanGiaiQuyet.getGiayMoiGio() + " ngày " + giaHanGiaiQuyet.getGiayMoiNgay() + ", tại "
//                        + giaHanGiaiQuyet.getGiayMoiDiaDiem() + ")"));
//            }
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
                    if (detailVanBanDiTongTheArrayList.size() > 0) {
                        listener.onItemClickXemFile(detailVanBanDiTongTheArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (detailVanBanDiTongTheArrayList.size() > 0) {
                        listener.onItemClickXuLy(detailVanBanDiTongTheArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (detailVanBanDiTongTheArrayList.size() > 0) {
                        listener.onItemClickXemChiTiet(detailVanBanDiTongTheArrayList.get(position));
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
        @BindView(R.id.tvSTT)
        TextView tvSTT;
        @BindView(R.id.tvSKH)
        TextView tvSKH;
        @BindView(R.id.tvsodendo)
        TextView tvsodendo;
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
        void onItemClickXemFile(DetailVanBanDiTongThe detailVanBanDiTongThe);

        void onItemClickXuLy(DetailVanBanDiTongThe detailVanBanDiTongThe);

        void onItemClickXemChiTiet(DetailVanBanDiTongThe detailVanBanDiTongThe);
    }
}
