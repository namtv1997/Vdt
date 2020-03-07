package com.vpdt.vpdt.ui.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.VanBanChoDuyetLV3;
import com.vpdt.vpdt.model.VanBanChoXuLyLV3;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterVanBanChoDuyetLV3 extends RecyclerView.Adapter<AdapterVanBanChoDuyetLV3.ViewHolder> {
    private ArrayList<VanBanChoDuyetLV3> vbPhoPhongPhoiHopChoXLArrayList;

    private OnItemClickListener listener;


    public AdapterVanBanChoDuyetLV3(ArrayList<VanBanChoDuyetLV3> vbPhoPhongPhoiHopChoXLArrayList, OnItemClickListener listener) {
        this.vbPhoPhongPhoiHopChoXLArrayList = vbPhoPhongPhoiHopChoXLArrayList;
        this.listener = listener;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_xulyvanban5, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        VanBanChoDuyetLV3 giaHanGiaiQuyet = vbPhoPhongPhoiHopChoXLArrayList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvSKH.setText(String.valueOf(giaHanGiaiQuyet.getSoKyHieu()));
        viewHolder.tvsodendo.setText(String.valueOf(giaHanGiaiQuyet.getSoDen()));
        viewHolder.tvnoigui.setText(String.valueOf(giaHanGiaiQuyet.getNoiGui()));
//        if (giaHanGiaiQuyet.getLoaiVanban().isEmpty() || giaHanGiaiQuyet.get() == null) {
        viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvLoaiVanBan.setText(String.valueOf("Loại văn bản: " + giaHanGiaiQuyet.getLoaiVanban()));
//        }

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

        viewHolder.tvNgayNhap.setText(String.valueOf("Ngày nhập: " + giaHanGiaiQuyet.getNgayNhap()));
        if (giaHanGiaiQuyet.getNgayNhap() == null) {
            viewHolder.tvNgayNhap.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getNgayNhap().isEmpty()) {
                viewHolder.tvNgayNhap.setVisibility(View.GONE);
            } else {
                viewHolder.tvNgayNhap.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvHanXuLy.setText(String.valueOf("Hạn văn bản: " + giaHanGiaiQuyet.getHanVanBan()));
        if (giaHanGiaiQuyet.getHanVanBan() == null) {
            viewHolder.tvHanXuLy.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getHanVanBan().isEmpty()) {
                viewHolder.tvHanXuLy.setVisibility(View.GONE);
            } else {
                viewHolder.tvHanXuLy.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvNguoiNhap.setText(String.valueOf("*Đ/c hoàn thành: " + giaHanGiaiQuyet.getCanBoHoanThanh() + ":\n" + giaHanGiaiQuyet.getNoiDungChiDao()));
        if (giaHanGiaiQuyet.getNoiDungChiDao() == null) {
            viewHolder.tvNguoiNhap.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getNoiDungChiDao().isEmpty()) {
                viewHolder.tvNguoiNhap.setVisibility(View.GONE);
            } else {
                viewHolder.tvNguoiNhap.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvNoiDung.setText(String.valueOf(giaHanGiaiQuyet.getNoiDungVanBan()));
        if (giaHanGiaiQuyet.getNoiDungVanBan() == null) {
            viewHolder.tvNoiDung.setVisibility(View.GONE);
            viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getNoiDungVanBan().isEmpty()) {
                viewHolder.tvNoiDung.setVisibility(View.GONE);
                viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
            } else {
                viewHolder.tvNoiDung.setVisibility(View.VISIBLE);
                viewHolder.tvTieuDeNoiDung.setVisibility(View.VISIBLE);
            }
        }

//        if (giaHanGiaiQuyet.gets().isEmpty() || giaHanGiaiQuyet.getSoTrang() == null) {
        viewHolder.tvSoTrang.setText(String.valueOf("(Vào hồi: "
                + giaHanGiaiQuyet.getGiayMoiGio() + " ngày " + giaHanGiaiQuyet.getGiayMoiNgay() + ", tại "
                + giaHanGiaiQuyet.getGiayMoiDiaDiem() + ")"));
        if (giaHanGiaiQuyet.getGiayMoiGio() == null) {
            viewHolder.tvSoTrang.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getGiayMoiGio().isEmpty()) {
                viewHolder.tvSoTrang.setVisibility(View.GONE);
            } else {
                viewHolder.tvSoTrang.setVisibility(View.VISIBLE);
            }
        }
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
                    if (vbPhoPhongPhoiHopChoXLArrayList.size() > 0) {
                        listener.onItemClickXemFile(vbPhoPhongPhoiHopChoXLArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (vbPhoPhongPhoiHopChoXLArrayList.size() > 0) {
                        listener.onItemClickXuLy(vbPhoPhongPhoiHopChoXLArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (vbPhoPhongPhoiHopChoXLArrayList.size() > 0) {
                        listener.onItemClickXemChiTiet(vbPhoPhongPhoiHopChoXLArrayList.get(position));
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return vbPhoPhongPhoiHopChoXLArrayList.size();
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
        void onItemClickXemFile(VanBanChoDuyetLV3 vanBanChoDuyetLV3);

        void onItemClickXuLy(VanBanChoDuyetLV3 vanBanChoDuyetLV3);

        void onItemClickXemChiTiet(VanBanChoDuyetLV3 vanBanChoDuyetLV3);
    }
}
