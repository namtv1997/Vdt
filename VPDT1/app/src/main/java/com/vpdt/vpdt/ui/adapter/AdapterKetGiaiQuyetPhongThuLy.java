package com.vpdt.vpdt.ui.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.KetGiaiQuyetPhongThuLy;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterKetGiaiQuyetPhongThuLy extends RecyclerView.Adapter<AdapterKetGiaiQuyetPhongThuLy.ViewHolder> {
    private ArrayList<KetGiaiQuyetPhongThuLy> ketquaGiaiquyetPhongThulyArrayList;
    private OnItemketquaGiaiquyetPhongThulyClickListener listener;

    public AdapterKetGiaiQuyetPhongThuLy(ArrayList<KetGiaiQuyetPhongThuLy> ketquaGiaiquyetPhongThulyArrayList,
                                         OnItemketquaGiaiquyetPhongThulyClickListener listener) {
        this.ketquaGiaiquyetPhongThulyArrayList = ketquaGiaiquyetPhongThulyArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_ketquagiaiquyetphongthuly, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {


        viewHolder.tvRCVSTTTTGQ.setText(String.valueOf(position + 1));


        KetGiaiQuyetPhongThuLy ketquaGiaiquyetPhongPhoihop = ketquaGiaiquyetPhongThulyArrayList.get(position);

        viewHolder.tvCanBoDonVi.setText(String.valueOf(ketquaGiaiquyetPhongPhoihop.getCanBoDonvi()));
        viewHolder.tvNoiDung.setText(String.valueOf(ketquaGiaiquyetPhongPhoihop.getNoiDung()));
        viewHolder.tvNgayNhap.setText(String.valueOf(ketquaGiaiquyetPhongPhoihop.getNgayNhap()));
        viewHolder.tvTacVu.setText(String.valueOf(ketquaGiaiquyetPhongPhoihop.getTrangThai()));
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
        @BindView(R.id.tvTacVu)
        TextView tvTacVu;
        @BindView(R.id.tvTaiVe)
        TextView tvTaiVe;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public interface OnItemketquaGiaiquyetPhongThulyClickListener {
        void onItemketquaGiaiquyetPhongThulyClick(KetGiaiQuyetPhongThuLy ketquaGiaiquyetPhongThuly);
    }
}
