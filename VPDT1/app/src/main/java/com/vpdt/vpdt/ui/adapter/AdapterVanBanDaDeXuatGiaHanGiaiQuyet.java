package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.VanBanDaDeXuatGiaHanGiaiQuyet;

import org.sufficientlysecure.htmltextview.HtmlAssetsImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterVanBanDaDeXuatGiaHanGiaiQuyet extends RecyclerView.Adapter<AdapterVanBanDaDeXuatGiaHanGiaiQuyet.ViewHolder> {
    private ArrayList<VanBanDaDeXuatGiaHanGiaiQuyet> ToCongTacList;
    private OnItemClickListener listener;


    public AdapterVanBanDaDeXuatGiaHanGiaiQuyet(ArrayList<VanBanDaDeXuatGiaHanGiaiQuyet> ToCongTacList, OnItemClickListener listener) {
        this.ToCongTacList = ToCongTacList;
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
        VanBanDaDeXuatGiaHanGiaiQuyet giaHanGiaiQuyet = ToCongTacList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvSKH.setText(String.valueOf(giaHanGiaiQuyet.getSoKyHieu()));
        viewHolder.tvsodendo.setText(String.valueOf(giaHanGiaiQuyet.getSoDen()));
        viewHolder.tvnoigui.setText(String.valueOf(giaHanGiaiQuyet.getNoiGui()));
//        if (giaHanGiaiQuyet.get().isEmpty() || giaHanGiaiQuyet.getLoaiVanban() == null) {
        viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvLoaiVanBan.setText(String.valueOf("Loại văn bản: " + giaHanGiaiQuyet.getl()));
//        }

        viewHolder.tvMoTa.setText(String.valueOf(giaHanGiaiQuyet.getMoTa()+"\nHạn giải quyết: "+giaHanGiaiQuyet.getHanGiaiQuyet()));
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

        viewHolder.tvHanXuLy.setText(String.valueOf("Hạn đề xuất: " + giaHanGiaiQuyet.getHanDeXuat()));
        if (giaHanGiaiQuyet.getHanDeXuat() == null) {
            viewHolder.tvHanXuLy.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getHanDeXuat().isEmpty()) {
                viewHolder.tvHanXuLy.setVisibility(View.GONE);
            } else {
                viewHolder.tvHanXuLy.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvNguoiNhap.setText(String.valueOf("Hạn đề xuất: " + giaHanGiaiQuyet.getHanDeXuat()));
        if (giaHanGiaiQuyet.getHanDeXuat() == null) {
            viewHolder.tvNguoiNhap.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getHanDeXuat().isEmpty()) {
                viewHolder.tvNguoiNhap.setVisibility(View.GONE);
            } else {
                viewHolder.tvNguoiNhap.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvNoiDung.setVisibility(View.GONE);
        viewHolder.tvTieuDeNoiDung.setText("Lý do từ chối hạn: ");
        viewHolder.tvHtmlNoiDung.setHtml(giaHanGiaiQuyet.getLyDoTuChoiHan(), new HtmlAssetsImageGetter(viewHolder.tvHtmlNoiDung));
        if (giaHanGiaiQuyet.getLyDoTuChoiHan() == null) {
            viewHolder.tvHtmlNoiDung.setVisibility(View.GONE);
            viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getLyDoTuChoiHan().isEmpty()) {
                viewHolder.tvHtmlNoiDung.setVisibility(View.GONE);
                viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
            } else {
                viewHolder.tvHtmlNoiDung.setVisibility(View.VISIBLE);
                viewHolder.tvTieuDeNoiDung.setVisibility(View.VISIBLE);
            }
        }

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


        viewHolder.btnXemFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (ToCongTacList.size() > 0) {
                        listener.onItemClickXemFile(ToCongTacList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (ToCongTacList.size() > 0) {
                        listener.onItemClickXuLy(ToCongTacList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (ToCongTacList.size() > 0) {
                        listener.onItemClickXemChiTiet(ToCongTacList.get(position));
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return ToCongTacList.size();
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
        @BindView(R.id.tvHtmlNoiDung)
        HtmlTextView tvHtmlNoiDung;

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
        void onItemClickXemFile(VanBanDaDeXuatGiaHanGiaiQuyet vanBanDaDeXuatGiaHanGiaiQuyet);

        void onItemClickXuLy(VanBanDaDeXuatGiaHanGiaiQuyet vanBanDaDeXuatGiaHanGiaiQuyet);

        void onItemClickXemChiTiet(VanBanDaDeXuatGiaHanGiaiQuyet vanBanDaDeXuatGiaHanGiaiQuyet);
    }
}
