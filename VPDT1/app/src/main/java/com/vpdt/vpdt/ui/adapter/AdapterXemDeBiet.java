package com.vpdt.vpdt.ui.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.XemDeBiet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterXemDeBiet extends RecyclerView.Adapter<AdapterXemDeBiet.ViewHolder> {
    private ArrayList<XemDeBiet> xemDeBietArrayList;
    private OnItemClickListenerXemDeBiet listener;


    public AdapterXemDeBiet(ArrayList<XemDeBiet> xemDeBietArrayList, OnItemClickListenerXemDeBiet listener) {
        this.xemDeBietArrayList = xemDeBietArrayList;
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
        XemDeBiet dsvb_daChiDao = xemDeBietArrayList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvSKH.setText(String.valueOf(dsvb_daChiDao.getSoKyHieu()));
        viewHolder.tvsodendo.setText(String.valueOf(dsvb_daChiDao.getSoDen()));
        viewHolder.tvnoigui.setText(String.valueOf(dsvb_daChiDao.getNoiGui()));
//        if (dsvb_daChiDao.get().isEmpty() || dsvb_daChiDao.getLoaiVanBan() == null) {
        viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvLoaiVanBan.setText(String.valueOf("Loại văn bản: " + dsvb_daChiDao.getLoaiVanBan()));
//        }

        viewHolder.tvMoTa.setText(String.valueOf(dsvb_daChiDao.getMota()));
        if (dsvb_daChiDao.getMota() == null) {
            viewHolder.tvMoTa.setVisibility(View.GONE);
        } else {
            if (dsvb_daChiDao.getMota().isEmpty()) {
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

//        if (dsvb_daChiDao.getNgayKy().isEmpty() || dsvb_daChiDao.getNgayKy() == null) {
        viewHolder.tvNguoiNhap.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvNguoiNhap.setText(String.valueOf("Ngày ký: "+dsvb_daChiDao.getng()));
//        }
//
        viewHolder.tvHanXuLy.setText(String.valueOf("Hạn giải quyết: " + dsvb_daChiDao.getHanGiaQuyet()));
        if (dsvb_daChiDao.getHanGiaQuyet() == null) {
            viewHolder.tvHanXuLy.setVisibility(View.GONE);
        } else {
            if (dsvb_daChiDao.getHanGiaQuyet().isEmpty()) {
                viewHolder.tvHanXuLy.setVisibility(View.GONE);
            } else {
                viewHolder.tvHanXuLy.setVisibility(View.VISIBLE);
            }
        }

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

        try {
            Date date2 = new Date();
            String date1 = dsvb_daChiDao.getHanGiaQuyet();
            String format = "dd/MM/yyyy";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date dateObj1 = sdf.parse(date1);
            long diff = date2.getTime() - dateObj1.getTime();
            int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
            if (diffDays >= -3 && diffDays <= 3) {
                viewHolder.lnSTT.setBackgroundResource(R.drawable.tvvang);
            } else if (diffDays >= 4) {
                viewHolder.lnSTT.setBackgroundResource(R.drawable.cvdth);
            } else {
                viewHolder.lnSTT.setBackgroundResource(R.drawable.duyet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        viewHolder.btnXemFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (xemDeBietArrayList.size() > 0) {
                        listener.onItemClickXemFile(xemDeBietArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (xemDeBietArrayList.size() > 0) {
                        listener.onItemClickXuLy(xemDeBietArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (xemDeBietArrayList.size() > 0) {
                        listener.onItemClickXemChiTiet(xemDeBietArrayList.get(position));
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return xemDeBietArrayList.size();
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

        @BindView(R.id.lnSTT)
        LinearLayout lnSTT;

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

    public interface OnItemClickListenerXemDeBiet {
        void onItemClickXemFile(XemDeBiet xemDeBiet);

        void onItemClickXuLy(XemDeBiet xemDeBiet);

        void onItemClickXemChiTiet(XemDeBiet xemDeBiet);
    }
}