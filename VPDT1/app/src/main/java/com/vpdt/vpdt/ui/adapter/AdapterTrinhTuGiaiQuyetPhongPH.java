package com.vpdt.vpdt.ui.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetPhongPH;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTrinhTuGiaiQuyetPhongPH extends RecyclerView.Adapter<AdapterTrinhTuGiaiQuyetPhongPH.ViewHolder> {
    private ArrayList<TrinhTuGiaiQuyetPhongPH> trinhTuGiaiQuyets;

    public AdapterTrinhTuGiaiQuyetPhongPH(ArrayList<TrinhTuGiaiQuyetPhongPH> trinhTuGiaiQuyets) {
        this.trinhTuGiaiQuyets = trinhTuGiaiQuyets;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_trinhtugiaiquyet, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        TrinhTuGiaiQuyetPhongPH trinhTuGiaiQuyet = trinhTuGiaiQuyets.get(position);
        viewHolder.tvRCVSTTTTGQ.setText(String.valueOf(position + 1));
        viewHolder.tvRCVNgayNhanTTGQ.setText(String.valueOf(trinhTuGiaiQuyet.getNgayNhan()));
        viewHolder.tvRCVChuyenTuTTGQ.setText(String.valueOf(trinhTuGiaiQuyet.getChuyenTu()));
        viewHolder.tvRCVNoiDungTTGQ.setText(String.valueOf(trinhTuGiaiQuyet.getNoiDung()));
        viewHolder.tvRCVChuyenDenTTGQ.setText(String.valueOf(trinhTuGiaiQuyet.getChuyenDen()));
        viewHolder.tvRCVHanXuLyTTGQ.setText(String.valueOf(trinhTuGiaiQuyet.getHanXuLy()));

    }

    @Override
    public int getItemCount() {
        return trinhTuGiaiQuyets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvRCVSTTTTGQ)
        TextView tvRCVSTTTTGQ;
        @BindView(R.id.tvRCVNgayNhanTTGQ)
        TextView tvRCVNgayNhanTTGQ;
        @BindView(R.id.tvRCVChuyenTuTTGQ)
        TextView tvRCVChuyenTuTTGQ;
        @BindView(R.id.tvRCVNoiDungTTGQ)
        TextView tvRCVNoiDungTTGQ;
        @BindView(R.id.tvRCVChuyenDenTTGQ)
        TextView tvRCVChuyenDenTTGQ;
        @BindView(R.id.tvRCVHanXuLyTTGQ)
        TextView tvRCVHanXuLyTTGQ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
