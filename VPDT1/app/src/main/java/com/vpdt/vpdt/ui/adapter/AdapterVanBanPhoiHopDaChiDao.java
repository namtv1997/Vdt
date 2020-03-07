package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.VanBanPhoiHopDaChiDao;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterVanBanPhoiHopDaChiDao extends RecyclerView.Adapter<AdapterVanBanPhoiHopDaChiDao.ViewHolder> {
    private ArrayList<VanBanPhoiHopDaChiDao> vanBanPhoiHopDaChiDaoArrayList;

    private OnItemClickListener listener;


    public AdapterVanBanPhoiHopDaChiDao(ArrayList<VanBanPhoiHopDaChiDao> vanBanPhoiHopDaChiDaoArrayList, OnItemClickListener listener) {

        this.vanBanPhoiHopDaChiDaoArrayList = vanBanPhoiHopDaChiDaoArrayList;
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
        VanBanPhoiHopDaChiDao dsvb_daChiDao = vanBanPhoiHopDaChiDaoArrayList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvSKH.setText(String.valueOf(dsvb_daChiDao.getSoKyHieu()));
        viewHolder.tvsodendo.setText(String.valueOf(dsvb_daChiDao.getSoDen()));
        viewHolder.tvnoigui.setText(String.valueOf(dsvb_daChiDao.getNoiGui()));
//        if (giaHanGiaiQuyet.getLoaiVanban().isEmpty() || giaHanGiaiQuyet.getLoaiVanban() == null) {
        viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvLoaiVanBan.setText(String.valueOf("Loại văn bản: " + dsvb_daChiDao.getl()));
//        }

        viewHolder.tvMoTa.setText(String.valueOf(dsvb_daChiDao.getMoTa()));
        if (dsvb_daChiDao.getMoTa() == null) {
            viewHolder.tvMoTa.setVisibility(View.GONE);
        } else {
            if (dsvb_daChiDao.getMoTa().isEmpty()) {
                viewHolder.tvMoTa.setVisibility(View.GONE);
            } else {
                viewHolder.tvMoTa.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvNgayNhap.setText(String.valueOf("Ngày nhập: " + dsvb_daChiDao.getNgayNhap()));
        if (dsvb_daChiDao.getNgayNhap() == null) {
            viewHolder.tvNgayNhap.setVisibility(View.GONE);
        } else {
            if (dsvb_daChiDao.getNgayNhap().isEmpty()) {
                viewHolder.tvNgayNhap.setVisibility(View.GONE);
            } else {
                viewHolder.tvNgayNhap.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvHanXuLy.setText(String.valueOf("Hạn giải quyết: " + dsvb_daChiDao.getHanGiaiQuyet()));
        if (dsvb_daChiDao.getHanGiaiQuyet() == null) {
            viewHolder.tvHanXuLy.setVisibility(View.GONE);
        } else {
            if (dsvb_daChiDao.getHanGiaiQuyet().isEmpty()) {
                viewHolder.tvHanXuLy.setVisibility(View.GONE);
            } else {
                viewHolder.tvHanXuLy.setVisibility(View.VISIBLE);
            }
        }

//        if (dsvb_daChiDao.getn().isEmpty() || dsvb_daChiDao.getNguoiNhap() == null) {
        viewHolder.tvNguoiNhap.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvNguoiNhap.setText(String.valueOf("Người nhập: "+dsvb_daChiDao.getNguoiNhap()));
//        }

        viewHolder.tvNoiDung.setText(String.valueOf(dsvb_daChiDao.getNoiDung()));
        if (dsvb_daChiDao.getNoiDung() == null) {
            viewHolder.tvNoiDung.setVisibility(View.GONE);
            viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
        } else {
            if (dsvb_daChiDao.getNoiDung().isEmpty()) {
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
                    if (vanBanPhoiHopDaChiDaoArrayList.size() > 0) {
                        listener.onItemClickXemFile(vanBanPhoiHopDaChiDaoArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (vanBanPhoiHopDaChiDaoArrayList.size() > 0) {
                        listener.onItemClickXuLy(vanBanPhoiHopDaChiDaoArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (vanBanPhoiHopDaChiDaoArrayList.size() > 0) {
                        listener.onItemClickXemChiTiet(vanBanPhoiHopDaChiDaoArrayList.get(position));
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return vanBanPhoiHopDaChiDaoArrayList.size();
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
        void onItemClickXemFile(VanBanPhoiHopDaChiDao vanBanPhoiHopDaChiDao);

        void onItemClickXuLy(VanBanPhoiHopDaChiDao vanBanPhoiHopDaChiDao);

        void onItemClickXemChiTiet(VanBanPhoiHopDaChiDao vanBanPhoiHopDaChiDao);
    }
}
