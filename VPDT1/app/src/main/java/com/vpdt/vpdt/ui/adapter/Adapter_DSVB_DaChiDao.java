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
import com.vpdt.vpdt.model.DSVB_DaChiDao;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapter_DSVB_DaChiDao extends RecyclerView.Adapter<Adapter_DSVB_DaChiDao.ViewHolder> {
    private ArrayList<DSVB_DaChiDao> DSVB_DaChiDaoList;
    private Context mContext;
    private OnItemClickListener listener;


    public Adapter_DSVB_DaChiDao(Context mContext, ArrayList<DSVB_DaChiDao> DSVB_DaChiDaoList, OnItemClickListener listener) {
        this.mContext = mContext;
        this.DSVB_DaChiDaoList = DSVB_DaChiDaoList;
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
        DSVB_DaChiDao dsvb_daChiDao = DSVB_DaChiDaoList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvSKH.setText(String.valueOf(dsvb_daChiDao.getSoKyHieu()));
        viewHolder.tvsodendo.setText(String.valueOf(dsvb_daChiDao.getSoDen()));
        viewHolder.tvnoigui.setText(String.valueOf(dsvb_daChiDao.getNoiGuiDen()));
        viewHolder.tvLoaiVanBan.setText(String.valueOf("Loại văn bản: " + dsvb_daChiDao.getLoaiVanBan()));
        if (dsvb_daChiDao.getLoaiVanBan() == null) {
            viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
        } else {
            if (dsvb_daChiDao.getLoaiVanBan().isEmpty()) {
                viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
            } else {
                viewHolder.tvLoaiVanBan.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvMoTa.setText(String.valueOf(dsvb_daChiDao.getTrichYeu()));
        if (dsvb_daChiDao.getTrichYeu() == null) {
            viewHolder.tvMoTa.setVisibility(View.GONE);
        } else {
            if (dsvb_daChiDao.getTrichYeu().isEmpty()) {
                viewHolder.tvMoTa.setVisibility(View.GONE);
            } else {
                viewHolder.tvMoTa.setVisibility(View.VISIBLE);
            }
        }

        viewHolder.tvNgayNhap.setText(String.valueOf("Ngày nhận: " + dsvb_daChiDao.getNgayNhan()));
        if (dsvb_daChiDao.getNgayNhan() == null) {
            viewHolder.tvNgayNhap.setVisibility(View.GONE);
        } else {
            if (dsvb_daChiDao.getNgayNhan().isEmpty()) {
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

//        if (dsvb_quaHan.getNgayKy().isEmpty() || dsvb_quaHan.getNgayKy() == null) {
        viewHolder.tvNguoiNhap.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvNguoiNhap.setText(String.valueOf("Ngày ký: "+dsvb_daChiDao.getnguoi()));
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
                    if (DSVB_DaChiDaoList.size() > 0) {
                        listener.onItemClickXemFile(DSVB_DaChiDaoList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (DSVB_DaChiDaoList.size() > 0) {
                        listener.onItemClickXuLy(DSVB_DaChiDaoList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (DSVB_DaChiDaoList.size() > 0) {
                        listener.onItemClickXemChiTiet(DSVB_DaChiDaoList.get(position));
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return DSVB_DaChiDaoList.size();
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
        void onItemClickXemFile(DSVB_DaChiDao dsvbDaChiDao);

        void onItemClickXuLy(DSVB_DaChiDao dsvbDaChiDao);

        void onItemClickXemChiTiet(DSVB_DaChiDao dsvbDaChiDao);
    }

}
