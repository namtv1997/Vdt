package com.vpdt.vpdt.ui.adapter;


import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.KetQuaGiaiQuyetPhongThuLy1;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterKetGiaiQuyetPhongThuLy1 extends RecyclerView.Adapter<AdapterKetGiaiQuyetPhongThuLy1.ViewHolder> {
    private ArrayList<KetQuaGiaiQuyetPhongThuLy1> ketquaGiaiquyetPhongThulyArrayList;
    private OnItemketquaGiaiquyetPhongThulyClickListener listener;

    public AdapterKetGiaiQuyetPhongThuLy1(ArrayList<KetQuaGiaiQuyetPhongThuLy1> ketquaGiaiquyetPhongThulyArrayList,
                                          OnItemketquaGiaiquyetPhongThulyClickListener listener) {
        this.ketquaGiaiquyetPhongThulyArrayList = ketquaGiaiquyetPhongThulyArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_ketquagiaiquyetphongthuly2, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.tvRCVSTTTTGQ.setText(String.valueOf(position + 1));
        KetQuaGiaiQuyetPhongThuLy1 ketquaGiaiquyetPhongPhoihop = ketquaGiaiquyetPhongThulyArrayList.get(position);
        viewHolder.tvCanBoDonVi.setText(String.valueOf(ketquaGiaiquyetPhongPhoihop.getCanBo()));
        viewHolder.tvNoiDung.setText(String.valueOf(ketquaGiaiquyetPhongPhoihop.getNoiDung()));
        viewHolder.tvNgayNhap.setText(String.valueOf(ketquaGiaiquyetPhongPhoihop.getThoiGian()));
        if (ketquaGiaiquyetPhongPhoihop.getUrlFile().isEmpty()) {
            viewHolder.tvTaiVe.setText("");
        } else {
            viewHolder.tvTaiVe.setText("[Tải tài liệu]");
        }
        viewHolder.tvTaiVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemketquaGiaiquyetPhongThulyClick(ketquaGiaiquyetPhongThulyArrayList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return ketquaGiaiquyetPhongThulyArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvRCVSTTTTGQ)
        TextView tvRCVSTTTTGQ;
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

    public interface OnItemketquaGiaiquyetPhongThulyClickListener {
        void onItemketquaGiaiquyetPhongThulyClick(KetQuaGiaiQuyetPhongThuLy1 ketquaGiaiquyetPhongThuly);
    }
}
