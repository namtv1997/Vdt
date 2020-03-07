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
import com.vpdt.vpdt.model.DSGiayMoiDenCuaSo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDSGiayMoiDenCuaSo extends RecyclerView.Adapter<AdapterDSGiayMoiDenCuaSo.ViewHolder> {
    private ArrayList<DSGiayMoiDenCuaSo> dsGiayMoiDenCuaSos;
    private Context mContext;
    private OnItemClickListener listener;


    public AdapterDSGiayMoiDenCuaSo(Context mContext, ArrayList<DSGiayMoiDenCuaSo> dsGiayMoiDenCuaSos, OnItemClickListener listener) {
        this.mContext = mContext;
        this.dsGiayMoiDenCuaSos = dsGiayMoiDenCuaSos;
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
        DSGiayMoiDenCuaSo giaHanGiaiQuyet = dsGiayMoiDenCuaSos.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvSKH.setText(String.valueOf(giaHanGiaiQuyet.getSoKyhieu()));
        viewHolder.tvsodendo.setText(String.valueOf(giaHanGiaiQuyet.getSoDen()));
        viewHolder.tvnoigui.setText(String.valueOf(giaHanGiaiQuyet.getNoiGui()));
        viewHolder.tvLoaiVanBan.setText(String.valueOf("Loại văn bản: " + giaHanGiaiQuyet.getLoaiVanban()));
        if (giaHanGiaiQuyet.getLoaiVanban() == null) {
            viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getLoaiVanban().isEmpty()) {
                viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
            } else {
                viewHolder.tvLoaiVanBan.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvMoTa.setText(String.valueOf(giaHanGiaiQuyet.getMota()));
        if (giaHanGiaiQuyet.getMota() == null) {
            viewHolder.tvMoTa.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getMota().isEmpty()) {
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

//        if (giaHanGiaiQuyet.geth().isEmpty() || giaHanGiaiQuyet.getHanGiaiQuyet() == null) {
        viewHolder.tvHanXuLy.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvHanXuLy.setText(String.valueOf("Hạn giải quyết: " + giaHanGiaiQuyet.getHanGiaiQuyet()));
//        }

        viewHolder.tvNguoiNhap.setText(String.valueOf("Người nhập: " + giaHanGiaiQuyet.getNguoiNhap()));
        if (giaHanGiaiQuyet.getNguoiNhap() == null) {
            viewHolder.tvNguoiNhap.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getNguoiNhap().isEmpty()) {
                viewHolder.tvNguoiNhap.setVisibility(View.GONE);
            } else {
                viewHolder.tvNguoiNhap.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvNoiDung.setText(String.valueOf(giaHanGiaiQuyet.getNoiDung()));
        if (giaHanGiaiQuyet.getNoiDung() == null) {
            viewHolder.tvNoiDung.setVisibility(View.GONE);
            viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getNoiDung().isEmpty()) {
                viewHolder.tvNoiDung.setVisibility(View.GONE);
                viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
            } else {
                viewHolder.tvNoiDung.setVisibility(View.VISIBLE);
                viewHolder.tvTieuDeNoiDung.setVisibility(View.VISIBLE);
            }
        }

        if (giaHanGiaiQuyet.getSoTrang() == null) {
            if (giaHanGiaiQuyet.getGiayMoiGio() == null) {
                viewHolder.tvSoTrang.setVisibility(View.GONE);
            } else {
                if (giaHanGiaiQuyet.getGiayMoiGio().isEmpty()) {
                    viewHolder.tvSoTrang.setVisibility(View.GONE);
                } else {
                    viewHolder.tvSoTrang.setVisibility(View.VISIBLE);
                    viewHolder.tvSoTrang.setText(String.valueOf("(Vào hồi: "
                            + giaHanGiaiQuyet.getGiayMoiGio() + " ngày " + giaHanGiaiQuyet.getGiayMoiNgay() + ", tại "
                            + giaHanGiaiQuyet.getGiayMoiDiadiem() + ")"));
                }
            }
        } else {
            if (giaHanGiaiQuyet.getSoTrang().toString().isEmpty()) {
                if (giaHanGiaiQuyet.getGiayMoiGio() == null) {
                    viewHolder.tvSoTrang.setVisibility(View.GONE);
                } else {
                    if (giaHanGiaiQuyet.getGiayMoiGio().isEmpty()) {
                        viewHolder.tvSoTrang.setVisibility(View.GONE);
                    } else {
                        viewHolder.tvSoTrang.setVisibility(View.VISIBLE);
                        viewHolder.tvSoTrang.setText(String.valueOf("(Vào hồi: "
                                + giaHanGiaiQuyet.getGiayMoiGio() + " ngày " + giaHanGiaiQuyet.getGiayMoiNgay() + ", tại "
                                + giaHanGiaiQuyet.getGiayMoiDiadiem() + ")"));
                    }
                }
            } else {
                if (giaHanGiaiQuyet.getGiayMoiGio() == null) {
                    viewHolder.tvSoTrang.setVisibility(View.VISIBLE);
                    viewHolder.tvSoTrang.setText(String.valueOf("(Số trang: " + giaHanGiaiQuyet.getSoTrang() + ")"));
                } else {
                    if (giaHanGiaiQuyet.getGiayMoiGio().isEmpty()) {
                        viewHolder.tvSoTrang.setVisibility(View.VISIBLE);
                        viewHolder.tvSoTrang.setText(String.valueOf("(Số trang: " + giaHanGiaiQuyet.getSoTrang() + ")"));
                    } else {
                        viewHolder.tvSoTrang.setVisibility(View.VISIBLE);
                        viewHolder.tvSoTrang.setText(String.valueOf("(Số trang: " + giaHanGiaiQuyet.getSoTrang() + ") | (Vào hồi: "
                                + giaHanGiaiQuyet.getGiayMoiGio() + " ngày " + giaHanGiaiQuyet.getGiayMoiNgay() + ", tại "
                                + giaHanGiaiQuyet.getGiayMoiDiadiem() + ")"));
                    }
                }
            }
        }


        viewHolder.btnXemFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (dsGiayMoiDenCuaSos.size() > 0) {
                        listener.onItemClickXemFile(dsGiayMoiDenCuaSos.get(position));
                    }
                }
            }
        });
        viewHolder.btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (dsGiayMoiDenCuaSos.size() > 0) {
                        listener.onItemClickXuLy(dsGiayMoiDenCuaSos.get(position));
                    }
                }
            }
        });
        viewHolder.btnXemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (dsGiayMoiDenCuaSos.size() > 0) {
                        listener.onItemClickXemChiTiet(dsGiayMoiDenCuaSos.get(position));
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return dsGiayMoiDenCuaSos.size();
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
        void onItemClickXemFile(DSGiayMoiDenCuaSo dsGiayMoiDenCuaSo);

        void onItemClickXuLy(DSGiayMoiDenCuaSo dsGiayMoiDenCuaSo);

        void onItemClickXemChiTiet(DSGiayMoiDenCuaSo dsGiayMoiDenCuaSo);
    }
}