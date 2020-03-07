package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.VanBanTheoLoaiNoiDen;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterThongKeTheoLoaiVanBanNoiDen extends RecyclerView.Adapter<AdapterThongKeTheoLoaiVanBanNoiDen.ViewHolder> {
    private ArrayList<VanBanTheoLoaiNoiDen> vanBanTheoLoaiNoiDenArrayList;

    private OnItemClickListenerThongKeTheoLoaiVanBanNoiDen listener;

    public AdapterThongKeTheoLoaiVanBanNoiDen(ArrayList<VanBanTheoLoaiNoiDen> vanBanTheoLoaiNoiDenArrayList, OnItemClickListenerThongKeTheoLoaiVanBanNoiDen listener) {
        this.vanBanTheoLoaiNoiDenArrayList = vanBanTheoLoaiNoiDenArrayList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_tkvb_theo_loai_noi_den, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        VanBanTheoLoaiNoiDen vanBanTheoLoaiNoiDen = vanBanTheoLoaiNoiDenArrayList.get(position);
        viewHolder.tvThongKePhanLoai.setText(String.valueOf(vanBanTheoLoaiNoiDen.getName()));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickThongKeTheoLoaiVanBanNoiDen(vanBanTheoLoaiNoiDenArrayList.get(position));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return vanBanTheoLoaiNoiDenArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvThongKePhanLoai)
        TextView tvThongKePhanLoai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public interface OnItemClickListenerThongKeTheoLoaiVanBanNoiDen {
        void onItemClickThongKeTheoLoaiVanBanNoiDen(VanBanTheoLoaiNoiDen vanBanTheoLoaiNoiDen);
    }
}
