package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.DeXuatCongViecPhoiHopChoDuyet;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDeXuatCongViecPhoiHopChoDuyet extends RecyclerView.Adapter<AdapterDeXuatCongViecPhoiHopChoDuyet.ViewHolder> {
    private ArrayList<DeXuatCongViecPhoiHopChoDuyet> deXuatCongViecPhoiHopChoDuyetArrayList;

    private OnItemClickListener listener;


    public AdapterDeXuatCongViecPhoiHopChoDuyet(ArrayList<DeXuatCongViecPhoiHopChoDuyet> deXuatCongViecPhoiHopChoDuyetArrayList, OnItemClickListener listener) {
        this.deXuatCongViecPhoiHopChoDuyetArrayList = deXuatCongViecPhoiHopChoDuyetArrayList;
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
        DeXuatCongViecPhoiHopChoDuyet giaHanGiaiQuyet = deXuatCongViecPhoiHopChoDuyetArrayList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.textView6s.setText("SỐ ĐẾN");
        viewHolder.textVifew6s.setText("NGƯỜI CHUYỂN");
        viewHolder.tvSKH.setText(String.valueOf(giaHanGiaiQuyet.getSoDen()));
        viewHolder.tvnoigui.setText(String.valueOf(giaHanGiaiQuyet.getNguoiChuyen()));
//        if (giaHanGiaiQuyet.getLoaiVanban().isEmpty() || giaHanGiaiQuyet.getLoaiVanban() == null) {
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
        viewHolder.tvNgayNhap.setText(String.valueOf("Thời gian: " + giaHanGiaiQuyet.getThoiGianChuyen()));
        if (giaHanGiaiQuyet.getThoiGianChuyen() == null) {
            viewHolder.tvNgayNhap.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getThoiGianChuyen().isEmpty()) {
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
        viewHolder.tvNguoiNhap.setText(String.valueOf("Người chuyển: " + giaHanGiaiQuyet.getNguoiChuyen()));
        if (giaHanGiaiQuyet.getNguoiChuyen() == null) {
            viewHolder.tvNguoiNhap.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getNguoiChuyen().isEmpty()) {
                viewHolder.tvNguoiNhap.setVisibility(View.GONE);
            } else {
                viewHolder.tvNguoiNhap.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvNoiDung.setText(String.valueOf(giaHanGiaiQuyet.getNoiDung()));
        if (giaHanGiaiQuyet.getNoiDung() == null) {
            viewHolder.tvNoiDung.setVisibility(View.GONE);
            viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getNoiDung().isEmpty()) {
                viewHolder.tvNoiDung.setVisibility(View.GONE);
                viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
            } else {
                viewHolder.tvNoiDung.setVisibility(View.VISIBLE);
                viewHolder.tvTieuDeNoiDung.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvSoTrang.setVisibility(View.GONE);

        viewHolder.btnXemFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (deXuatCongViecPhoiHopChoDuyetArrayList.size() > 0) {
                        listener.onItemClickXemFile(deXuatCongViecPhoiHopChoDuyetArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (deXuatCongViecPhoiHopChoDuyetArrayList.size() > 0) {
                        listener.onItemClickXuLy(deXuatCongViecPhoiHopChoDuyetArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (deXuatCongViecPhoiHopChoDuyetArrayList.size() > 0) {
                        listener.onItemClickXemChiTiet(deXuatCongViecPhoiHopChoDuyetArrayList.get(position));
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return deXuatCongViecPhoiHopChoDuyetArrayList.size();
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
        @BindView(R.id.textView6s)
        TextView textView6s;
        @BindView(R.id.textVifew6s)
        TextView textVifew6s;

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
        void onItemClickXemFile(DeXuatCongViecPhoiHopChoDuyet deXuatCongViecPhoiHopChoDuyet);

        void onItemClickXuLy(DeXuatCongViecPhoiHopChoDuyet deXuatCongViecPhoiHopChoDuyet);

        void onItemClickXemChiTiet(DeXuatCongViecPhoiHopChoDuyet deXuatCongViecPhoiHopChoDuyet);
    }
}
