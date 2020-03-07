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
import com.vpdt.vpdt.model.DonThuKNTC;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapter_DonThuKNTC extends RecyclerView.Adapter<Adapter_DonThuKNTC.ViewHolder> {
    private ArrayList<DonThuKNTC> DonThuKNTCList;
    private Context mContext;
    private OnItemClickListener listener;


    public Adapter_DonThuKNTC(Context mContext, ArrayList<DonThuKNTC> DonThuKNTCList, OnItemClickListener listener) {
        this.mContext = mContext;
        this.DonThuKNTCList = DonThuKNTCList;
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
        DonThuKNTC donThuKNTC = DonThuKNTCList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvSKH.setText(String.valueOf(donThuKNTC.getKyHieu()));
        viewHolder.tvsodendo.setText(String.valueOf(donThuKNTC.getSoDen()));
        viewHolder.tvnoigui.setText(String.valueOf(donThuKNTC.getNoiGui()));
//        if (donThuKNTC.get().isEmpty() || donThuKNTC.getLoaiVanban() == null) {
        viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvLoaiVanBan.setText(String.valueOf("Loại văn bản: " + donThuKNTC.getLoaiVanban()));
//        }

        viewHolder.tvMoTa.setText(String.valueOf(donThuKNTC.getMota()));
        if (donThuKNTC.getMota() == null) {
            viewHolder.tvMoTa.setVisibility(View.GONE);
        } else {
            if (donThuKNTC.getMota().isEmpty()) {
                viewHolder.tvMoTa.setVisibility(View.GONE);
            } else {
                viewHolder.tvMoTa.setVisibility(View.VISIBLE);
            }
        }


        viewHolder.tvNgayNhap.setText(String.valueOf("Ngày nhập: " + donThuKNTC.getNgayNhap()));
        if (donThuKNTC.getNgayNhap() == null) {
            viewHolder.tvNgayNhap.setVisibility(View.GONE);
        } else {
            if (donThuKNTC.getNgayNhap().isEmpty()) {
                viewHolder.tvNgayNhap.setVisibility(View.GONE);
            } else {
                viewHolder.tvNgayNhap.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvHanXuLy.setText(String.valueOf("Ngày ký: " + donThuKNTC.getNgayKy()));
        if (donThuKNTC.getNgayKy() == null) {
            viewHolder.tvHanXuLy.setVisibility(View.GONE);
        } else {
            if (donThuKNTC.getNgayKy().isEmpty()) {
                viewHolder.tvHanXuLy.setVisibility(View.GONE);
            } else {
                viewHolder.tvHanXuLy.setVisibility(View.VISIBLE);
            }
        }

//        if (donThuKNTC.get().isEmpty() || donThuKNTC.getNguoiNhap() == null) {
        viewHolder.tvNguoiNhap.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvNguoiNhap.setText(String.valueOf("Người nhập: "+donThuKNTC.getNguoiNhap()));
//        }

//        if (donThuKNTC.get().isEmpty()||donThuKNTC.getNoiDung()==null){
        viewHolder.tvNoiDung.setVisibility(View.GONE);
        viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
//        }else {
//            viewHolder.tvNoiDung.setText(String.valueOf(donThuKNTC.getNoiDung()));
//        }

        viewHolder.tvSoTrang.setVisibility(View.GONE);

        viewHolder.btnXemFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (DonThuKNTCList.size() > 0) {
                        listener.onItemClickXemFile(DonThuKNTCList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (DonThuKNTCList.size() > 0) {
                        listener.onItemClickXuLy(DonThuKNTCList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (DonThuKNTCList.size() > 0) {
                        listener.onItemClickXemChiTiet(DonThuKNTCList.get(position));
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return DonThuKNTCList.size();
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
        void onItemClickXemFile(DonThuKNTC donThuKNTC);

        void onItemClickXuLy(DonThuKNTC donThuKNTC);

        void onItemClickXemChiTiet(DonThuKNTC donThuKNTC);
    }

}
