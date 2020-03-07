package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetPhongPhoiHop;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTrinhTuGiaiQuyetPhongPhoiHop extends RecyclerView.Adapter<AdapterTrinhTuGiaiQuyetPhongPhoiHop.ViewHolder> {

    private ArrayList<TrinhTuGiaiQuyetPhongPhoiHop> trinhTuGiaiQuyetPhongPhoiHops;
    private Context mContext;

    public AdapterTrinhTuGiaiQuyetPhongPhoiHop(Context mContext, ArrayList<TrinhTuGiaiQuyetPhongPhoiHop> trinhTuGiaiQuyetPhongPhoiHops) {
        this.mContext = mContext;
        this.trinhTuGiaiQuyetPhongPhoiHops = trinhTuGiaiQuyetPhongPhoiHops;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_trinhtugiaiquyetphongphoihop, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        TrinhTuGiaiQuyetPhongPhoiHop trinhTuGiaiQuyetPhongPhoiHop = trinhTuGiaiQuyetPhongPhoiHops.get(position);
        viewHolder.tvRCVSTTTTGQPPH.setText(String.valueOf(trinhTuGiaiQuyetPhongPhoiHop.getStt()));
        viewHolder.tvRCVNgayNhanTTGQPPH.setText(String.valueOf(trinhTuGiaiQuyetPhongPhoiHop.getNgayNhan()));
        viewHolder.tvRCVChuyenTuTTGQPPH.setText(String.valueOf(trinhTuGiaiQuyetPhongPhoiHop.getChuyenTu()));
        viewHolder.tvRCVNoiDungTTGQPPH.setText(String.valueOf(trinhTuGiaiQuyetPhongPhoiHop.getNoiDung()));
        viewHolder.tvRCVChuyenDenTTGQPPH.setText(String.valueOf(trinhTuGiaiQuyetPhongPhoiHop.getChuyenDen()));
    }

    @Override
    public int getItemCount() {
        return trinhTuGiaiQuyetPhongPhoiHops.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvRCVSTTTTGQPPH)
        TextView tvRCVSTTTTGQPPH;
        @BindView(R.id.tvRCVNgayNhanTTGQPPH)
        TextView tvRCVNgayNhanTTGQPPH;
        @BindView(R.id.tvRCVChuyenTuTTGQPPH)
        TextView tvRCVChuyenTuTTGQPPH;
        @BindView(R.id.tvRCVNoiDungTTGQPPH)
        TextView tvRCVNoiDungTTGQPPH;
        @BindView(R.id.tvRCVChuyenDenTTGQPPH)
        TextView tvRCVChuyenDenTTGQPPH;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
