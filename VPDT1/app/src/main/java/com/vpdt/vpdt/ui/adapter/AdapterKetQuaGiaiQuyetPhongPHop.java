package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.KetGiaiQuyetPhongPhoiHop;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterKetQuaGiaiQuyetPhongPHop extends RecyclerView.Adapter<AdapterKetQuaGiaiQuyetPhongPHop.ViewHolder> {
    private ArrayList<KetGiaiQuyetPhongPhoiHop> ketquaGiaiquyetPhongPhoihops;

    private OnItemketquaGiaiquyetClickListener listener;


    public AdapterKetQuaGiaiQuyetPhongPHop(ArrayList<KetGiaiQuyetPhongPhoiHop> ketquaGiaiquyetPhongPhoihops, OnItemketquaGiaiquyetClickListener listener) {

        this.ketquaGiaiquyetPhongPhoihops = ketquaGiaiquyetPhongPhoihops;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_ketquagiaiquyetphongphoihop, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.tvSTT.setText(String.valueOf(position + 1));

        KetGiaiQuyetPhongPhoiHop ketquaGiaiquyetPhongPhoihop = ketquaGiaiquyetPhongPhoihops.get(position);

        viewHolder.tvCanBoDonVi.setText(ketquaGiaiquyetPhongPhoihop.getCanbo() + " - " + ketquaGiaiquyetPhongPhoihop.getPhongBan());
        viewHolder.tvNoiDung.setText(String.valueOf(ketquaGiaiquyetPhongPhoihop.getNoiDung()));
        viewHolder.tvNgayNhap.setText(String.valueOf(ketquaGiaiquyetPhongPhoihop.getNgayNhap()));
        if (!ketquaGiaiquyetPhongPhoihop.getDuongDanfile().isEmpty()) {
            viewHolder.tvTaiVe.setVisibility(View.VISIBLE);
        }
        viewHolder.tvTaiVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemketquaGiaiquyetClick(ketquaGiaiquyetPhongPhoihops.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return ketquaGiaiquyetPhongPhoihops.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvSTT)
        TextView tvSTT;
        @BindView(R.id.tvCanBoDonVi)
        TextView tvCanBoDonVi;
        @BindView(R.id.tvNoiDung)
        TextView tvNoiDung;
        @BindView(R.id.tvNgayNhap)
        TextView tvNgayNhap;
        @BindView(R.id.tvTaiVe)
        TextView tvTaiVe;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public interface OnItemketquaGiaiquyetClickListener {
        void onItemketquaGiaiquyetClick(KetGiaiQuyetPhongPhoiHop ketquaGiaiquyetPhongPhoihop);
    }
}
