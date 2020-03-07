package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.SoLuongVanBanGiaoChiCucPhoChuTri;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterSoLuongVanBanGiaoChiCucPhoChuTri extends RecyclerView.Adapter<AdapterSoLuongVanBanGiaoChiCucPhoChuTri.ViewHolder> {
    private ArrayList<SoLuongVanBanGiaoChiCucPhoChuTri> vbPhoPhongPhoiHopChoXLArrayList;

    private OnItemClickListener listener;


    public AdapterSoLuongVanBanGiaoChiCucPhoChuTri(ArrayList<SoLuongVanBanGiaoChiCucPhoChuTri> vbPhoPhongPhoiHopChoXLArrayList, OnItemClickListener listener) {
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
        SoLuongVanBanGiaoChiCucPhoChuTri giaHanGiaiQuyet = vbPhoPhongPhoiHopChoXLArrayList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvSKH.setText(String.valueOf(giaHanGiaiQuyet.getSoKyHieu()));
        viewHolder.tvsodendo.setText(String.valueOf(giaHanGiaiQuyet.getSoDen()));
        viewHolder.tvnoigui.setText(String.valueOf(giaHanGiaiQuyet.getNoiGui()));

        viewHolder.tvSoTrang.setText(String.valueOf("(Vào hồi: " + giaHanGiaiQuyet.getGiayMoiGio()
                + " ngày " + giaHanGiaiQuyet.getGiayMoiNgay()
                + ", tại " + giaHanGiaiQuyet.getGiayMoiDiaDiem() + ")"));

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

        viewHolder.tvHanXuLy.setText(String.valueOf("Ngày ký: " + giaHanGiaiQuyet.getNgayKy()));
        if (giaHanGiaiQuyet.getNgayKy() == null) {
            viewHolder.tvHanXuLy.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getNgayKy().isEmpty()) {
                viewHolder.tvHanXuLy.setVisibility(View.GONE);
            } else {
                viewHolder.tvHanXuLy.setVisibility(View.VISIBLE);
            }
        }

//        if (giaHanGiaiQuyet.getng().isEmpty() || giaHanGiaiQuyet.getNguoiNhap() == null) {
        viewHolder.tvNguoiNhap.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvNguoiNhap.setText(String.valueOf("Người nhập: "+giaHanGiaiQuyet.getn()));
//        }

//        if (giaHanGiaiQuyet.getn() == null || giaHanGiaiQuyet.getNoiDung().isEmpty()) {
        viewHolder.tvNoiDung.setVisibility(View.GONE);
        viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvNoiDung.setText(String.valueOf(giaHanGiaiQuyet.getNoiDung()));
//        }
        if (giaHanGiaiQuyet.getGiayMoiGio() != null || !giaHanGiaiQuyet.getGiayMoiGio().isEmpty()) {
            viewHolder.tvSoTrang.setVisibility(View.VISIBLE);
        } else {
            viewHolder.tvSoTrang.setVisibility(View.GONE);
        }

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
        void onItemClickXemFile(SoLuongVanBanGiaoChiCucPhoChuTri soLuongVanBanGiaoChiCucPhoChuTri);

        void onItemClickXuLy(SoLuongVanBanGiaoChiCucPhoChuTri soLuongVanBanGiaoChiCucPhoChuTri);

        void onItemClickXemChiTiet(SoLuongVanBanGiaoChiCucPhoChuTri soLuongVanBanGiaoChiCucPhoChuTri);
    }
}
