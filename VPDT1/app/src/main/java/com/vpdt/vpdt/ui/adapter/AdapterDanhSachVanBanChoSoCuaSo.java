package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.DeatailDauSoCuaSo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDanhSachVanBanChoSoCuaSo extends RecyclerView.Adapter<AdapterDanhSachVanBanChoSoCuaSo.ViewHolder> {
    private ArrayList<DeatailDauSoCuaSo> deatailDauSoCuaSoArrayList;
    private OnItemClickListener listener;


    public AdapterDanhSachVanBanChoSoCuaSo(ArrayList<DeatailDauSoCuaSo> deatailDauSoCuaSoArrayList, OnItemClickListener listener) {

        this.deatailDauSoCuaSoArrayList = deatailDauSoCuaSoArrayList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_vanbandi4, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        DeatailDauSoCuaSo giaHanGiaiQuyet = deatailDauSoCuaSoArrayList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvSKH.setText(String.valueOf(giaHanGiaiQuyet.getKyhieu()));
        viewHolder.tvnoigui.setText(String.valueOf(giaHanGiaiQuyet.getTrichyeu().getSoden()));
        viewHolder.tvLoaiVanBan.setText(String.valueOf("Loại văn bản: " + giaHanGiaiQuyet.getLoaiVB()));
        if (giaHanGiaiQuyet.getLoaiVB() == null) {
            viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getLoaiVB().isEmpty()) {
                viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
            } else {
                viewHolder.tvLoaiVanBan.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvMoTa.setText(String.valueOf(giaHanGiaiQuyet.getTrichyeu().getMota()));
        if (giaHanGiaiQuyet.getTrichyeu().getMota() == null) {
            viewHolder.tvMoTa.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getTrichyeu().getMota().isEmpty()) {
                viewHolder.tvMoTa.setVisibility(View.GONE);
            } else {
                viewHolder.tvMoTa.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvNgayNhap.setText(String.valueOf("Ngày nhập: " + giaHanGiaiQuyet.getTrichyeu().getNgaynhap()));
        if (giaHanGiaiQuyet.getTrichyeu().getNgaynhap() == null) {
            viewHolder.tvNgayNhap.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getTrichyeu().getNgaynhap().isEmpty()) {
                viewHolder.tvNgayNhap.setVisibility(View.GONE);
            } else {
                viewHolder.tvNgayNhap.setVisibility(View.VISIBLE);
            }
        }

//        if (giaHanGiaiQuyet.getHanGiaiQuyet().isEmpty() || giaHanGiaiQuyet.getHanGiaiQuyet() == null) {
        viewHolder.tvHanXuLy.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvHanXuLy.setText(String.valueOf("Hạn giải quyết: " + giaHanGiaiQuyet.getTrichyeu().get));
//        }

        viewHolder.tvNguoiNhap.setText(String.valueOf("Người ký: " + giaHanGiaiQuyet.getTrichyeu().getNguoiky()));
        if (giaHanGiaiQuyet.getTrichyeu().getNguoiky() == null) {
            viewHolder.tvNguoiNhap.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getTrichyeu().getNguoiky().isEmpty()) {
                viewHolder.tvNguoiNhap.setVisibility(View.GONE);
            } else {
                viewHolder.tvNguoiNhap.setVisibility(View.VISIBLE);
            }
        }

//        if (giaHanGiaiQuyet.getn().isEmpty() || giaHanGiaiQuyet.getNoiDung() == null) {
        viewHolder.tvNoiDung.setVisibility(View.GONE);
        viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvNoiDung.setText(String.valueOf(giaHanGiaiQuyet.getn()));
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
                    if (deatailDauSoCuaSoArrayList.size() > 0) {
                        listener.onItemClickXemFile(deatailDauSoCuaSoArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (deatailDauSoCuaSoArrayList.size() > 0) {
                        listener.onItemClickXuLy(deatailDauSoCuaSoArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (deatailDauSoCuaSoArrayList.size() > 0) {
                        listener.onItemClickXemChiTiet(deatailDauSoCuaSoArrayList.get(position));
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return deatailDauSoCuaSoArrayList.size();
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
        void onItemClickXemFile(DeatailDauSoCuaSo deatailDauSoCuaSo);

        void onItemClickXuLy(DeatailDauSoCuaSo deatailDauSoCuaSo);

        void onItemClickXemChiTiet(DeatailDauSoCuaSo deatailDauSoCuaSo);
    }
}
