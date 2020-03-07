package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.TepDinhKem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTepTinDinhKem extends RecyclerView.Adapter<AdapterTepTinDinhKem.ViewHolder> {
    private ArrayList<TepDinhKem> tepDinhKems;
    private Context mContext;
    private OnItemClickListener listener;

    public AdapterTepTinDinhKem(Context mContext, ArrayList<TepDinhKem> tepDinhKems, OnItemClickListener listener) {
        this.mContext = mContext;
        this.tepDinhKems = tepDinhKems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_teptindinhkem, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.tvRCVSTTTTDK.setText(String.valueOf(position + 1));
        TepDinhKem tepDinhKem = tepDinhKems.get(position);

        viewHolder.tvRCVTenTepTinTTDK.setText(String.valueOf(tepDinhKem.getTenTep()));
        viewHolder.tvRCVNgayNhapTTDK.setText(String.valueOf(tepDinhKem.getNgayNhap()));
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(TepDinhKem dinhKem);
    }
}
