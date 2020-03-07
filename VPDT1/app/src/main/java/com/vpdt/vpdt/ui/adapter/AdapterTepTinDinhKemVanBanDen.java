package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.TepTinVanBanDen;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTepTinDinhKemVanBanDen extends RecyclerView.Adapter<AdapterTepTinDinhKemVanBanDen.ViewHolder> {
    private ArrayList<TepTinVanBanDen> tepDinhKems;
    private OnItemClickListener listener;

    public AdapterTepTinDinhKemVanBanDen(ArrayList<TepTinVanBanDen> tepDinhKems, OnItemClickListener listener) {

        this.tepDinhKems = tepDinhKems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_teptindinhkem_vanbandi, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.tvRCVSTTTTDK.setText(String.valueOf(position + 1));
        TepTinVanBanDen tepDinhKem = tepDinhKems.get(position);
        viewHolder.tvRCVTenTepTinTTDK.setText(String.valueOf(tepDinhKem.getTenTepTin()));
        viewHolder.tvRCVNgayNhapTTDK.setText(String.valueOf(tepDinhKem.getNgayNhap()));
        viewHolder.tvRCVNguoiGui.setText(String.valueOf(tepDinhKem.getNguoiNhap()));

        viewHolder.tvTaiVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(tepDinhKems.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return tepDinhKems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvRCVSTTTTDK)
        TextView tvRCVSTTTTDK;
        @BindView(R.id.tvRCVTenTepTinTTDK)
        TextView tvRCVTenTepTinTTDK;
        @BindView(R.id.tvRCVNgayNhapTTDK)
        TextView tvRCVNgayNhapTTDK;
        @BindView(R.id.tvTaiVe)
        TextView tvTaiVe;
        @BindView(R.id.tvRCVNguoiGui)
        TextView tvRCVNguoiGui;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(TepTinVanBanDen tepTinVanBanDen);
    }
}
