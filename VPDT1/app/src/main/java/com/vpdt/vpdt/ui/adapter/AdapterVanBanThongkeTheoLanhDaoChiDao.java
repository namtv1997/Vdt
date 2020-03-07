package com.vpdt.vpdt.ui.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.DetailVanBanTheoLanhDao;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterVanBanThongkeTheoLanhDaoChiDao extends RecyclerView.Adapter<AdapterVanBanThongkeTheoLanhDaoChiDao.ViewHolder> {
    private ArrayList<DetailVanBanTheoLanhDao> detailVanBanTheoLanhDaoArrayList;
    private OnItemClickListener listener;


    public AdapterVanBanThongkeTheoLanhDaoChiDao(ArrayList<DetailVanBanTheoLanhDao> detailVanBanTheoLanhDaoArrayList, OnItemClickListener listener) {

        this.detailVanBanTheoLanhDaoArrayList = detailVanBanTheoLanhDaoArrayList;
        this.listener = listener;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_xulyvanban5, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        DetailVanBanTheoLanhDao giaHanGiaiQuyet = detailVanBanTheoLanhDaoArrayList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvSKH.setText(String.valueOf(giaHanGiaiQuyet.getKyhieu()));
        viewHolder.tvsodendo.setText(String.valueOf(giaHanGiaiQuyet.getSoden()));
        viewHolder.tvnoigui.setText(String.valueOf(giaHanGiaiQuyet.getNoiGui()));
        viewHolder.tvLoaiVanBan.setText(String.valueOf("Loại văn bản: " + giaHanGiaiQuyet.getTenlvb()));
        if (giaHanGiaiQuyet.getTenlvb() == null) {
            viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getTenlvb().isEmpty()) {
                viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
            } else {
                viewHolder.tvLoaiVanBan.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvMoTa.setText(String.valueOf(giaHanGiaiQuyet.getTrichYeu().getMota()));
        if (giaHanGiaiQuyet.getTrichYeu().getMota() == null) {
            viewHolder.tvMoTa.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getTrichYeu().getMota().isEmpty()) {
                viewHolder.tvMoTa.setVisibility(View.GONE);
            } else {
                viewHolder.tvMoTa.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvNgayNhap.setText(String.valueOf("Ngày nhập: " + giaHanGiaiQuyet.getTrichYeu().getNgaynhap()));
        if (giaHanGiaiQuyet.getTrichYeu().getNgaynhap() == null) {
            viewHolder.tvNgayNhap.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getTrichYeu().getNgaynhap().isEmpty()) {
                viewHolder.tvNgayNhap.setVisibility(View.GONE);
            } else {
                viewHolder.tvNgayNhap.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvHanXuLy.setText(String.valueOf("Ngày giải quyết: " + giaHanGiaiQuyet.getNgaygiaiquyet()));
        if (giaHanGiaiQuyet.getNgaygiaiquyet() == null) {
            viewHolder.tvHanXuLy.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getNgaygiaiquyet().isEmpty()) {
                viewHolder.tvHanXuLy.setVisibility(View.GONE);
            } else {
                viewHolder.tvHanXuLy.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvNguoiNhap.setText(String.valueOf("Người nhập: " + giaHanGiaiQuyet.getTrichYeu().getNguoinhap()));
        if (giaHanGiaiQuyet.getTrichYeu().getNguoinhap() == null) {
            viewHolder.tvNguoiNhap.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getTrichYeu().getNguoinhap().isEmpty()) {
                viewHolder.tvNguoiNhap.setVisibility(View.GONE);
            } else {
                viewHolder.tvNguoiNhap.setVisibility(View.VISIBLE);
            }
        }
        viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
        viewHolder.tvNoiDung.setText(String.valueOf("(Vào hồi: "
                + giaHanGiaiQuyet.getTrichYeu().getSGiayMoiGio() + " ngày " + giaHanGiaiQuyet.getTrichYeu().getSGiayMoiNgay() + ", tại "
                + giaHanGiaiQuyet.getTrichYeu().getSGiayMoiDiaDiem() + ")"));
        if (giaHanGiaiQuyet.getTrichYeu().getSGiayMoiGio() == null) {
            viewHolder.tvNoiDung.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getTrichYeu().getSGiayMoiGio().isEmpty()) {
                viewHolder.tvNoiDung.setVisibility(View.GONE);
            } else {
                viewHolder.tvNoiDung.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvSoTrang.setText(String.valueOf("Hạn văn bản: " + giaHanGiaiQuyet.getHanVb()));
        if (giaHanGiaiQuyet.getHanVb() == null) {
            viewHolder.tvSoTrang.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getHanVb().isEmpty()) {
                viewHolder.tvSoTrang.setVisibility(View.GONE);
            } else {
                viewHolder.tvSoTrang.setVisibility(View.VISIBLE);
            }
        }
        viewHolder.btnXemFile.setVisibility(View.GONE);
        viewHolder.btnXemFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (detailVanBanTheoLanhDaoArrayList.size() > 0) {
                        listener.onItemClickXemFile(detailVanBanTheoLanhDaoArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXuLy.setVisibility(View.GONE);
        viewHolder.btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (detailVanBanTheoLanhDaoArrayList.size() > 0) {
                        listener.onItemClickXuLy(detailVanBanTheoLanhDaoArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (detailVanBanTheoLanhDaoArrayList.size() > 0) {
                        listener.onItemClickXemChiTiet(detailVanBanTheoLanhDaoArrayList.get(position));
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return detailVanBanTheoLanhDaoArrayList.size();
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
        void onItemClickXemFile(DetailVanBanTheoLanhDao detailVanBanTheoLanhDao);

        void onItemClickXuLy(DetailVanBanTheoLanhDao detailVanBanTheoLanhDao);

        void onItemClickXemChiTiet(DetailVanBanTheoLanhDao detailVanBanTheoLanhDao);
    }
}
