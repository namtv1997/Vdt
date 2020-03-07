package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.KetquaGiaiQuyet;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterKetQuaGiaiQuyet extends RecyclerView.Adapter<AdapterKetQuaGiaiQuyet.ViewHolder> {
    private ArrayList<KetquaGiaiQuyet> trinhTuGiaiQuyets;

    private OnItemClickListener listener;

    public AdapterKetQuaGiaiQuyet(ArrayList<KetquaGiaiQuyet> trinhTuGiaiQuyets, OnItemClickListener listener) {
        this.trinhTuGiaiQuyets = trinhTuGiaiQuyets;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_ketquagiaiquyet, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        KetquaGiaiQuyet trinhTuGiaiQuyet = trinhTuGiaiQuyets.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvCanBoDonVi.setText(String.valueOf(trinhTuGiaiQuyet.getCanbo() + " - " + trinhTuGiaiQuyet.getPhongBan()));
        viewHolder.tvNoiDung.setText(String.valueOf(trinhTuGiaiQuyet.getNoiDung()));

        String duongdan = trinhTuGiaiQuyet.getDuongDan();
        viewHolder.tvFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(trinhTuGiaiQuyets.get(position));
                }
            }
        });
        viewHolder.tvNgayNhap.setText(String.valueOf(trinhTuGiaiQuyet.getNgayNhap()));
//        viewHolder.tvTacVu.setText(String.valueOf(trinhTuGiaiQuyet.get()));

    }

    @Override
    public int getItemCount() {
        return trinhTuGiaiQuyets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvSTT)
        TextView tvSTT;
        @BindView(R.id.tvCanBoDonVi)
        TextView tvCanBoDonVi;
        @BindView(R.id.tvNoiDung)
        TextView tvNoiDung;
        @BindView(R.id.tvFile)
        TextView tvFile;
        @BindView(R.id.tvNgayNhap)
        TextView tvNgayNhap;
        @BindView(R.id.tvTacVu)
        TextView tvTacVu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(KetquaGiaiQuyet ketquaGiaiQuyet);
    }
}
