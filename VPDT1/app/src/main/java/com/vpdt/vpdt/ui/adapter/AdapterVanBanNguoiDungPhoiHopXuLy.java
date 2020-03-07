package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.VanBanNguoiDungPhoiHopXuLy;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterVanBanNguoiDungPhoiHopXuLy extends RecyclerView.Adapter<AdapterVanBanNguoiDungPhoiHopXuLy.ViewHolder> {
    private ArrayList<VanBanNguoiDungPhoiHopXuLy> ToCongTacList;
    private OnItemClickListener listener;


    public AdapterVanBanNguoiDungPhoiHopXuLy(ArrayList<VanBanNguoiDungPhoiHopXuLy> ToCongTacList, OnItemClickListener listener) {
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
        VanBanNguoiDungPhoiHopXuLy giaHanGiaiQuyet = ToCongTacList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvSKH.setText(String.valueOf(giaHanGiaiQuyet.getSoKyHieu()));
        viewHolder.tvsodendo.setText(String.valueOf(giaHanGiaiQuyet.getSoDen()));
        viewHolder.tvnoigui.setText(String.valueOf(giaHanGiaiQuyet.getNoiGui()));
//        if (giaHanGiaiQuyet.getl().isEmpty() || giaHanGiaiQuyet.getLoaiVanBan() == null) {
        viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvLoaiVanBan.setText(String.valueOf("Loại văn bản: " + giaHanGiaiQuyet.getLoaiVanBan()));
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
        if (giaHanGiaiQuyet.getHanGiaiQuyet().equals("01/01/1970")){
            viewHolder.tvHanXuLy.setVisibility(View.GONE);
        }

        viewHolder.tvNguoiNhap.setText(String.valueOf("Chỉ đạo của phòng: "+giaHanGiaiQuyet.getPhongChiDao()));
        if (giaHanGiaiQuyet.getPhongChiDao() == null) {
            viewHolder.tvNguoiNhap.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getPhongChiDao().isEmpty()) {
                viewHolder.tvNguoiNhap.setVisibility(View.GONE);
            } else {
                viewHolder.tvNguoiNhap.setVisibility(View.VISIBLE);
            }
        }


//        if (giaHanGiaiQuyet.getNoiDung().isEmpty() || giaHanGiaiQuyet.getno() == null) {
        viewHolder.tvNoiDung.setVisibility(View.GONE);
        viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvNoiDung.setText(String.valueOf(giaHanGiaiQuyet.getNoiDung()));
//        }

//        if (giaHanGiaiQuyet.getSoTrang().isEmpty() || giaHanGiaiQuyet.getSoTrang() == null) {
        viewHolder.tvSoTrang.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvSoTrang.setText(String.valueOf("(Số trang: " + giaHanGiaiQuyet.getSoTrang() + ")"));
//        }

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
        void onItemClickXemFile(VanBanNguoiDungPhoiHopXuLy vanBanNguoiDungXuLy);

        void onItemClickXuLy(VanBanNguoiDungPhoiHopXuLy vanBanNguoiDungXuLy);

        void onItemClickXemChiTiet(VanBanNguoiDungPhoiHopXuLy vanBanNguoiDungXuLy);
    }
}
