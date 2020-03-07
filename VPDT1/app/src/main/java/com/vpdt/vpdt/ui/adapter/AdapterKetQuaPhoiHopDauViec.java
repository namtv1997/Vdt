package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.KetQuaPhoiHop1;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterKetQuaPhoiHopDauViec extends RecyclerView.Adapter<AdapterKetQuaPhoiHopDauViec.ViewHolder> {
    private ArrayList<KetQuaPhoiHop1> ketQuaPhoiHopArrayList;
    private Context mContext;
    private OnItemClickListenerKetQuaPhoiHopDauViec listener;

    public AdapterKetQuaPhoiHopDauViec(Context mContext, ArrayList<KetQuaPhoiHop1> ketQuaPhoiHopArrayList, OnItemClickListenerKetQuaPhoiHopDauViec listener) {
        this.mContext = mContext;
        this.ketQuaPhoiHopArrayList = ketQuaPhoiHopArrayList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_ketquaphoihop_quanlydauviec, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        KetQuaPhoiHop1 item = ketQuaPhoiHopArrayList.get(position);
        viewHolder.tvRCVSTTTTGQ.setText(String.valueOf(position + 1));
        viewHolder.tvNoiDung.setText(String.valueOf(item.getNoiDung()));
        viewHolder.tvCanBoDonVi.setText(String.valueOf(item.getCanBoGiaiQuyet()));
        viewHolder.tvThoiGianGiaiQuyet.setText(item.getThoiGianGiaiQuyet());
        viewHolder.tvTepTin.setText(item.getUrlFile());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickKetQuaPhoiHopDauViec(ketQuaPhoiHopArrayList.get(position));
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return ketQuaPhoiHopArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tvRCVSTTTTGQ)
        TextView tvRCVSTTTTGQ;
        @BindView(R.id.tvNoiDung)
        TextView tvNoiDung;
        @BindView(R.id.tvCanBoDonVi)
        TextView tvCanBoDonVi;
        @BindView(R.id.tvThoiGianGiaiQuyet)
        TextView tvThoiGianGiaiQuyet;
        @BindView(R.id.tvTepTin)
        TextView tvTepTin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public interface OnItemClickListenerKetQuaPhoiHopDauViec {
        void onItemClickKetQuaPhoiHopDauViec(KetQuaPhoiHop1 ketQuaPhoiHop);
    }
}
