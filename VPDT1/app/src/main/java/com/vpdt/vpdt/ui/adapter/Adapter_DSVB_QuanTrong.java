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
import com.vpdt.vpdt.model.DSVB_QuanTrong;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapter_DSVB_QuanTrong extends RecyclerView.Adapter<Adapter_DSVB_QuanTrong.ViewHolder> {
    private ArrayList<DSVB_QuanTrong> DSVB_QuanTrongList;
    private Context mContext;
    private OnItemClickListener listener;


    public Adapter_DSVB_QuanTrong(Context mContext, ArrayList<DSVB_QuanTrong> DSVB_QuanTrongList, OnItemClickListener listener) {
        this.mContext = mContext;
        this.DSVB_QuanTrongList = DSVB_QuanTrongList;
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
        DSVB_QuanTrong dsvb_quanTrong = DSVB_QuanTrongList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvSKH.setText(String.valueOf(dsvb_quanTrong.getKyHieu()));
        viewHolder.tvsodendo.setText(String.valueOf(dsvb_quanTrong.getSoDen()));
        viewHolder.tvnoigui.setText(String.valueOf(dsvb_quanTrong.getNoiGui()));
        viewHolder.tvLoaiVanBan.setText(String.valueOf("Loại văn bản: " + dsvb_quanTrong.getLoaiVanban()));
        if (dsvb_quanTrong.getLoaiVanban() == null) {
            viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
        } else {
            if (dsvb_quanTrong.getLoaiVanban().isEmpty()) {
                viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
            } else {
                viewHolder.tvLoaiVanBan.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvMoTa.setText(String.valueOf(dsvb_quanTrong.getMota()));
        if (dsvb_quanTrong.getMota() == null) {
            viewHolder.tvMoTa.setVisibility(View.GONE);
        } else {
            if (dsvb_quanTrong.getMota().isEmpty()) {
                viewHolder.tvMoTa.setVisibility(View.GONE);
            } else {
                viewHolder.tvMoTa.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvNgayNhap.setText(String.valueOf("Ngày nhập: " + dsvb_quanTrong.getNgayNhap()));
        if (dsvb_quanTrong.getNgayNhap() == null) {
            viewHolder.tvNgayNhap.setVisibility(View.GONE);
        } else {
            if (dsvb_quanTrong.getNgayNhap().isEmpty()) {
                viewHolder.tvNgayNhap.setVisibility(View.GONE);
            } else {
                viewHolder.tvNgayNhap.setVisibility(View.VISIBLE);
            }
        }

//        if (dsvb_quanTrong.get().isEmpty() || dsvb_quanTrong.getHanChoDuyet() == null) {
        viewHolder.tvHanXuLy.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvHanXuLy.setText(String.valueOf("Hạn chờ duyệt: "+dsvb_quanTrong.getHanChoDuyet()));
//        }

        viewHolder.tvNguoiNhap.setText(String.valueOf("Người nhập: " + dsvb_quanTrong.getNguoiNhap()));
        if (dsvb_quanTrong.getNguoiNhap() == null) {
            viewHolder.tvNguoiNhap.setVisibility(View.GONE);
        } else {
            if (dsvb_quanTrong.getNguoiNhap().isEmpty()) {
                viewHolder.tvNguoiNhap.setVisibility(View.GONE);
            } else {
                viewHolder.tvNguoiNhap.setVisibility(View.VISIBLE);
            }
        }

//        if (dsvb_quanTrong.get().isEmpty()||dsvb_quanTrong.getNoiDung()==null){
        viewHolder.tvNoiDung.setVisibility(View.GONE);
        viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
//        }else {
//            viewHolder.tvNoiDung.setText(String.valueOf(dsvb_quanTrong.getNoiDung()));
//        }

        viewHolder.tvSoTrang.setVisibility(View.GONE);

        viewHolder.btnXemFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (DSVB_QuanTrongList.size() > 0) {
                        listener.onItemClickXemFile(DSVB_QuanTrongList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (DSVB_QuanTrongList.size() > 0) {
                        listener.onItemClickXuLy(DSVB_QuanTrongList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (DSVB_QuanTrongList.size() > 0) {
                        listener.onItemClickXemChiTiet(DSVB_QuanTrongList.get(position));
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return DSVB_QuanTrongList.size();
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
        void onItemClickXemFile(DSVB_QuanTrong dsvb_quanTrong);

        void onItemClickXuLy(DSVB_QuanTrong dsvb_quanTrong);

        void onItemClickXemChiTiet(DSVB_QuanTrong dsvb_quanTrong);
    }

}
