package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.DSVB_QuaHan;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Adapter_DSVB_QuaHan extends RecyclerView.Adapter<Adapter_DSVB_QuaHan.ViewHolder> {
    private ArrayList<DSVB_QuaHan> dsvb_quaHanArrayList;
    private Context mContext;
    private OnItemClickListener listener;


    public Adapter_DSVB_QuaHan(Context mContext, ArrayList<DSVB_QuaHan> dsvb_quaHanArrayList, OnItemClickListener listener) {
        this.mContext = mContext;
        this.dsvb_quaHanArrayList = dsvb_quaHanArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public Adapter_DSVB_QuaHan.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_xulyvanban5, parent, false);
        return new Adapter_DSVB_QuaHan.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_DSVB_QuaHan.ViewHolder viewHolder, int position) {
        DSVB_QuaHan dsvb_quaHan = dsvb_quaHanArrayList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvSKH.setText(String.valueOf(dsvb_quaHan.getSoKyHieu()));
        viewHolder.tvsodendo.setText(String.valueOf(dsvb_quaHan.getSoDen()));
        viewHolder.tvnoigui.setText(String.valueOf(dsvb_quaHan.getNoiGui()));
        if (dsvb_quaHan.getLoaiVanban() == null) {
            viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
        } else {
            if (dsvb_quaHan.getLoaiVanban().isEmpty()) {
                viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
            } else {
                viewHolder.tvLoaiVanBan.setVisibility(View.VISIBLE);
            }
        }
        viewHolder.tvLoaiVanBan.setText(String.valueOf("Loại văn bản: " + dsvb_quaHan.getLoaiVanban()));

        viewHolder.tvMoTa.setText(String.valueOf(dsvb_quaHan.getTrichYeu()));
        if (dsvb_quaHan.getTrichYeu() == null) {
            viewHolder.tvMoTa.setVisibility(View.GONE);
        } else {
            if (dsvb_quaHan.getTrichYeu().isEmpty()) {
                viewHolder.tvMoTa.setVisibility(View.GONE);
            } else {
                viewHolder.tvMoTa.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvNgayNhap.setText(String.valueOf("Ngày nhập: " + dsvb_quaHan.getNgayNhap()));
        if (dsvb_quaHan.getNgayNhap() == null) {
            viewHolder.tvNgayNhap.setVisibility(View.GONE);
        } else {
            if (dsvb_quaHan.getNgayNhap().isEmpty()) {
                viewHolder.tvNgayNhap.setVisibility(View.GONE);
            } else {
                viewHolder.tvNgayNhap.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvHanXuLy.setText(String.valueOf("Hạn xử lý: " + dsvb_quaHan.getHanXuLy()));
        if (dsvb_quaHan.getHanXuLy() == null) {
            viewHolder.tvHanXuLy.setVisibility(View.GONE);
        } else {
            if (dsvb_quaHan.getHanXuLy().isEmpty()) {
                viewHolder.tvHanXuLy.setVisibility(View.GONE);
            } else {
                viewHolder.tvHanXuLy.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvNguoiNhap.setText(String.valueOf("Ngày ký: " + dsvb_quaHan.getNgayKy()));
        if (dsvb_quaHan.getNgayKy() == null) {
            viewHolder.tvNguoiNhap.setVisibility(View.GONE);
        } else {
            if (dsvb_quaHan.getNgayKy().isEmpty()) {
                viewHolder.tvNguoiNhap.setVisibility(View.GONE);
            } else {
                viewHolder.tvNguoiNhap.setVisibility(View.VISIBLE);
            }
        }
//        } else {
//            viewHolder.tvNguoiNhap.setText(String.valueOf("Người nhập: "+dsvb_quaHan.getNgayKy()));
//        }

//        if (dsvb_daChiDao.getNoiDung().isEmpty()||dsvb_daChiDao.getNoiDung()==null){
        viewHolder.tvNoiDung.setVisibility(View.GONE);
        viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
//        }else {
//            viewHolder.tvNoiDung.setText(String.valueOf(dsvb_daChiDao.getNoiDung()));
//        }

        viewHolder.tvSoTrang.setVisibility(View.GONE);

        viewHolder.btnXemFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (dsvb_quaHanArrayList.size() > 0) {
                        listener.onItemClickXemFile(dsvb_quaHanArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (dsvb_quaHanArrayList.size() > 0) {
                        listener.onItemClickXuLy(dsvb_quaHanArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (dsvb_quaHanArrayList.size() > 0) {
                        listener.onItemClickXemChiTiet(dsvb_quaHanArrayList.get(position));
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dsvb_quaHanArrayList.size();
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
        void onItemClickXemFile(DSVB_QuaHan dsvb_quaHan);

        void onItemClickXuLy(DSVB_QuaHan dsvb_quaHan);

        void onItemClickXemChiTiet(DSVB_QuaHan dsvb_quaHan);
    }

}