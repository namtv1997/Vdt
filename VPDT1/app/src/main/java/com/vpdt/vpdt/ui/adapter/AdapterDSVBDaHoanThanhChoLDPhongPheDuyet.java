package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.VanBanHoanThanhChoLanhDaoPhongPheDuyet;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDSVBDaHoanThanhChoLDPhongPheDuyet extends RecyclerView.Adapter<AdapterDSVBDaHoanThanhChoLDPhongPheDuyet.ViewHolder> {
    private ArrayList<VanBanHoanThanhChoLanhDaoPhongPheDuyet> vanBanHoanThanhChoLanhDaoPhongPheDuyetArrayList;
    private OnItemClickListener listener;


    public AdapterDSVBDaHoanThanhChoLDPhongPheDuyet(ArrayList<VanBanHoanThanhChoLanhDaoPhongPheDuyet> vanBanHoanThanhChoLanhDaoPhongPheDuyetArrayList, OnItemClickListener listener) {
        this.vanBanHoanThanhChoLanhDaoPhongPheDuyetArrayList = vanBanHoanThanhChoLanhDaoPhongPheDuyetArrayList;
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
        VanBanHoanThanhChoLanhDaoPhongPheDuyet giaHanGiaiQuyet = vanBanHoanThanhChoLanhDaoPhongPheDuyetArrayList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvSKH.setText(String.valueOf(giaHanGiaiQuyet.getSoKyHieu()));
        viewHolder.tvsodendo.setText(String.valueOf(giaHanGiaiQuyet.getSoDen()));
        viewHolder.tvnoigui.setText(String.valueOf(giaHanGiaiQuyet.getNoiGui()));
//        if (giaHanGiaiQuyet.getLoaiVanban().isEmpty() || giaHanGiaiQuyet.getLoaiVanban() == null) {
        viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvLoaiVanBan.setText(String.valueOf("Loại văn bản: " + giaHanGiaiQuyet.getlo()));
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

        viewHolder.tvHanXuLy.setText(String.valueOf("Hạn giải quyết: " + giaHanGiaiQuyet.getHanGiaiQuyet()));
        if (giaHanGiaiQuyet.getHanGiaiQuyet() == null) {
            viewHolder.tvHanXuLy.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getHanGiaiQuyet().isEmpty()) {
                viewHolder.tvHanXuLy.setVisibility(View.GONE);
            } else {
                viewHolder.tvHanXuLy.setVisibility(View.VISIBLE);
            }
        }

//        if (giaHanGiaiQuyet.getng().isEmpty() || giaHanGiaiQuyet.getNguoiNhap() == null) {
        viewHolder.tvNguoiNhap.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvNguoiNhap.setText(String.valueOf("Người nhập: "+giaHanGiaiQuyet.getNguoiNhap()));
//        }

        viewHolder.tvTieuDeNoiDung.setText(String.valueOf("*Nội dung chỉ đạo của đ/c "+giaHanGiaiQuyet.getTenNguoiHoanThanh()));
        viewHolder.tvNoiDung.setText(String.valueOf(giaHanGiaiQuyet.getMoTaHoanThanh()));
        if (giaHanGiaiQuyet.getMoTaHoanThanh() == null) {
            viewHolder.tvNoiDung.setVisibility(View.GONE);
            viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getMoTaHoanThanh().isEmpty()) {
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
                    if (vanBanHoanThanhChoLanhDaoPhongPheDuyetArrayList.size() > 0) {
                        listener.onItemClickXemFile(vanBanHoanThanhChoLanhDaoPhongPheDuyetArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (vanBanHoanThanhChoLanhDaoPhongPheDuyetArrayList.size() > 0) {
                        listener.onItemClickXuLy(vanBanHoanThanhChoLanhDaoPhongPheDuyetArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (vanBanHoanThanhChoLanhDaoPhongPheDuyetArrayList.size() > 0) {
                        listener.onItemClickXemChiTiet(vanBanHoanThanhChoLanhDaoPhongPheDuyetArrayList.get(position));
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return vanBanHoanThanhChoLanhDaoPhongPheDuyetArrayList.size();
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
        void onItemClickXemFile(VanBanHoanThanhChoLanhDaoPhongPheDuyet vanBanHoanThanhChoLanhDaoPhongPheDuyet);

        void onItemClickXuLy(VanBanHoanThanhChoLanhDaoPhongPheDuyet vanBanHoanThanhChoLanhDaoPhongPheDuyet);

        void onItemClickXemChiTiet(VanBanHoanThanhChoLanhDaoPhongPheDuyet vanBanHoanThanhChoLanhDaoPhongPheDuyet);
    }
}
