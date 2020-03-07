package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.KetQuaGiaiQuyet1;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterKetQuaGiaiQuyetDauViec extends RecyclerView.Adapter<AdapterKetQuaGiaiQuyetDauViec.ViewHolder> {
    private ArrayList<KetQuaGiaiQuyet1> ketQuaGiaiQuyetDauViecArrayList;
    private Context mContext;
    private OnItemClickListenerKetQuaGiaiQuyetDauViec listener;

    public AdapterKetQuaGiaiQuyetDauViec(Context mContext, ArrayList<KetQuaGiaiQuyet1> ketQuaGiaiQuyetDauViecArrayList, OnItemClickListenerKetQuaGiaiQuyetDauViec listener) {
        this.mContext = mContext;
        this.ketQuaGiaiQuyetDauViecArrayList = ketQuaGiaiQuyetDauViecArrayList;
        this.listener = listener;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_ketquagiaiquyet_quanlydauviec, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        KetQuaGiaiQuyet1 item = ketQuaGiaiQuyetDauViecArrayList.get(position);
        viewHolder.tvRCVSTTTTGQ.setText(String.valueOf(position + 1));
        viewHolder.tvNoiDung.setText(String.valueOf(item.getNoiDung()));
        viewHolder.tvCanBoGiaiQuyet.setText(String.valueOf(item.getCanBoGiaiQuyet()));
        viewHolder.tvThoiGianGiaiQuyet.setText(item.getThoiGianGiaiQuyet());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickKetQuaGiaiQuyetDauViec(ketQuaGiaiQuyetDauViecArrayList.get(position));
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return ketQuaGiaiQuyetDauViecArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tvRCVSTTTTGQ)
        TextView tvRCVSTTTTGQ;
        @BindView(R.id.tvNoiDung)
        TextView tvNoiDung;
        @BindView(R.id.tvCanBoGiaiQuyet)
        TextView tvCanBoGiaiQuyet;
        @BindView(R.id.tvThoiGianGiaiQuyet)
        TextView tvThoiGianGiaiQuyet;
        @BindView(R.id.tvTepTin)
        TextView tvTepTin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public interface OnItemClickListenerKetQuaGiaiQuyetDauViec {
        void onItemClickKetQuaGiaiQuyetDauViec(KetQuaGiaiQuyet1 ketQuaGiaiQuyetDauViec);
    }
}
