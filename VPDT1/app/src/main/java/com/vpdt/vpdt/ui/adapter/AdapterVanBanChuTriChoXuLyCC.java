package com.vpdt.vpdt.ui.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.VanBanChuTriChoXuLyCC;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterVanBanChuTriChoXuLyCC extends RecyclerView.Adapter<AdapterVanBanChuTriChoXuLyCC.ViewHolder> {
    private ArrayList<VanBanChuTriChoXuLyCC> vanBanDiDaXulyArrayList;
    private OnItemClickListener listener;

    public AdapterVanBanChuTriChoXuLyCC(ArrayList<VanBanChuTriChoXuLyCC> vanBanDiDaXulyArrayList, OnItemClickListener listener) {
        this.vanBanDiDaXulyArrayList = vanBanDiDaXulyArrayList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_vanbandi3, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        VanBanChuTriChoXuLyCC giaHanGiaiQuyet = vanBanDiDaXulyArrayList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvSKH.setText(String.valueOf(giaHanGiaiQuyet.getSoKyHieu()));
        viewHolder.tvsodendo.setText(String.valueOf(giaHanGiaiQuyet.getNguoiNhap()));
//        if (giaHanGiaiQuyet.get.isEmpty() || giaHanGiaiQuyet.getLoaiVB() == null) {
        viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvLoaiVanBan.setText(String.valueOf("Loại văn bản: " + giaHanGiaiQuyet.getLoaiVB()));
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

        viewHolder.tvNgayNhap.setText(String.valueOf(giaHanGiaiQuyet.getThoiGian()));
        if (giaHanGiaiQuyet.getThoiGian() == null) {
            viewHolder.tvNgayNhap.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getThoiGian().isEmpty()) {
                viewHolder.tvNgayNhap.setVisibility(View.GONE);
            } else {
                viewHolder.tvNgayNhap.setVisibility(View.VISIBLE);
            }
        }

//        if (giaHanGiaiQuyet.getHanGiaiQuyet().isEmpty() || giaHanGiaiQuyet.getHanGiaiQuyet() == null) {
        viewHolder.tvHanXuLy.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvHanXuLy.setText(String.valueOf("Hạn giải quyết: " + giaHanGiaiQuyet.get()));
//        }

        viewHolder.tvNguoiNhap.setText(String.valueOf("Người gửi: " + giaHanGiaiQuyet.getNguoiGui()));
        if (giaHanGiaiQuyet.getNguoiGui() == null) {
            viewHolder.tvNguoiNhap.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getNguoiGui().isEmpty()) {
                viewHolder.tvNguoiNhap.setVisibility(View.GONE);
            } else {
                viewHolder.tvNguoiNhap.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvTieuDeNoiDung.setText("Ý kiến");
        viewHolder.tvNoiDung.setText(String.valueOf(giaHanGiaiQuyet.getYKien()));
        if (giaHanGiaiQuyet.getYKien() == null) {
            viewHolder.tvNoiDung.setVisibility(View.GONE);
            viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getYKien().isEmpty()) {
                viewHolder.tvNoiDung.setVisibility(View.GONE);
                viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
            } else {
                viewHolder.tvNoiDung.setVisibility(View.VISIBLE);
                viewHolder.tvTieuDeNoiDung.setVisibility(View.VISIBLE);
            }
        }


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
                    if (vanBanDiDaXulyArrayList.size() > 0) {
                        listener.onItemClickXemFile(vanBanDiDaXulyArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (vanBanDiDaXulyArrayList.size() > 0) {
                        listener.onItemClickXuLy(vanBanDiDaXulyArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (vanBanDiDaXulyArrayList.size() > 0) {
                        listener.onItemClickXemChiTiet(vanBanDiDaXulyArrayList.get(position));
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return vanBanDiDaXulyArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvSTT)
        TextView tvSTT;
        @BindView(R.id.tvSKH)
        TextView tvSKH;
        @BindView(R.id.tvsodendo)
        TextView tvsodendo;
        @BindView(R.id.tvLoaiVanBan)
        TextView tvLoaiVanBan;
        @BindView(R.id.tvMoTa)
        TextView tvMoTa;
        @BindView(R.id.tvSoTrang)
        TextView tvSoTrang;
        @BindView(R.id.tvTieuDeNoiDung)
        TextView tvTieuDeNoiDung;
        @BindView(R.id.tvNguoiNhap)
        TextView tvNguoiNhap;
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
        void onItemClickXemFile(VanBanChuTriChoXuLyCC vanBanChuTriChoXuLyCC);

        void onItemClickXuLy(VanBanChuTriChoXuLyCC vanBanChuTriChoXuLyCC);

        void onItemClickXemChiTiet(VanBanChuTriChoXuLyCC vanBanChuTriChoXuLyCC);
    }
}
