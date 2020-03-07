package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.QuaTrinhChuyenNhanPH;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapter_QuaTrinhChuyenNhanPhoiHop extends RecyclerView.Adapter<Adapter_QuaTrinhChuyenNhanPhoiHop.ViewHolder> {
    private ArrayList<QuaTrinhChuyenNhanPH> quaTrinhChuyenNhanPHArrayList;
    private OnItemClickListener listener;


    public Adapter_QuaTrinhChuyenNhanPhoiHop(ArrayList<QuaTrinhChuyenNhanPH> quaTrinhChuyenNhanPHArrayList, OnItemClickListener listener) {
        this.quaTrinhChuyenNhanPHArrayList = quaTrinhChuyenNhanPHArrayList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_qua_trinh_chuyen_nhan_phoi_hop, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        QuaTrinhChuyenNhanPH baoCaoKetQuaCuocHop = quaTrinhChuyenNhanPHArrayList.get(position);
        viewHolder.tvRCVSTT.setText(String.valueOf(position + 1));
        viewHolder.tvRCVNguoiGui.setText(String.valueOf(baoCaoKetQuaCuocHop.getNguoiGui()));
        viewHolder.tvRCVNguoiNhan.setText(String.valueOf(baoCaoKetQuaCuocHop.getNguoiNhan()));
        viewHolder.tvRCVThoiGian.setText(String.valueOf(baoCaoKetQuaCuocHop.getThoiGianGui()));
        viewHolder.tvRCVNoiDung.setText(String.valueOf(baoCaoKetQuaCuocHop.getNoiDung()));
//        viewHolder.tvRCVFileYeuCau.setText(String.valueOf(baoCaoKetQuaCuocHop.getUrlFileYeuCau()));
//        viewHolder.tvRCVFileTraLoi.setText(String.valueOf(baoCaoKetQuaCuocHop.getUrlFileTraLoi()));
        if (baoCaoKetQuaCuocHop.getTrangThai() == 3) {
            viewHolder.tvTrangThai.setVisibility(View.VISIBLE);
            viewHolder.tvTrangThai.setText(" Kết Thúc ");
        }

        viewHolder.tvRCVFileYeuCau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClicktvRCVFileYeuCau(quaTrinhChuyenNhanPHArrayList.get(position));
                }

            }
        });
        viewHolder.tvRCVFileTraLoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClicktvRCVFileTraLoi(quaTrinhChuyenNhanPHArrayList.get(position));
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return quaTrinhChuyenNhanPHArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvRCVSTT)
        TextView tvRCVSTT;
        @BindView(R.id.tvRCVNguoiGui)
        TextView tvRCVNguoiGui;
        @BindView(R.id.tvRCVNguoiNhan)
        TextView tvRCVNguoiNhan;
        @BindView(R.id.tvRCVThoiGian)
        TextView tvRCVThoiGian;
        @BindView(R.id.tvRCVNoiDung)
        TextView tvRCVNoiDung;
        @BindView(R.id.tvRCVFileYeuCau)
        TextView tvRCVFileYeuCau;
        @BindView(R.id.tvRCVFileTraLoi)
        TextView tvRCVFileTraLoi;
        @BindView(R.id.tvTrangThai)
        TextView tvTrangThai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public interface OnItemClickListener {
        void onItemClicktvRCVFileYeuCau(QuaTrinhChuyenNhanPH quaTrinhChuyenNhanPH);

        void onItemClicktvRCVFileTraLoi(QuaTrinhChuyenNhanPH quaTrinhChuyenNhanPH);
    }

}
