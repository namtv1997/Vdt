package com.vpdt.vpdt.ui.adapter;


import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.LyDoChamMuonPhongThuLy;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterLyDoChamMuonPhongThuLy extends RecyclerView.Adapter<AdapterLyDoChamMuonPhongThuLy.ViewHolder> {
    private ArrayList<LyDoChamMuonPhongThuLy> ketquaGiaiquyetPhongThulyArrayList;

    public AdapterLyDoChamMuonPhongThuLy(ArrayList<LyDoChamMuonPhongThuLy> ketquaGiaiquyetPhongThulyArrayList) {
        this.ketquaGiaiquyetPhongThulyArrayList = ketquaGiaiquyetPhongThulyArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_lydochammuonphongthuly, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.tvRCVSTTTTGQ.setText(String.valueOf(position + 1));
        LyDoChamMuonPhongThuLy ketquaGiaiquyetPhongPhoihop = ketquaGiaiquyetPhongThulyArrayList.get(position);
        viewHolder.tvCanBoDonVi.setText(String.valueOf(ketquaGiaiquyetPhongPhoihop.getCanBo()));
        viewHolder.tvNoiDung.setText(String.valueOf(ketquaGiaiquyetPhongPhoihop.getNoiDung()));
        viewHolder.tvNgayNhap.setText(String.valueOf(ketquaGiaiquyetPhongPhoihop.getNgayNhap()));
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
