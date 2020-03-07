package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.QuaTrinhXuly;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterQuaTrinhXuLy extends RecyclerView.Adapter<AdapterQuaTrinhXuLy.ViewHolder> {
    private ArrayList<QuaTrinhXuly> quaTrinhXulyArrayList;
    private Context mContext;

    public AdapterQuaTrinhXuLy(Context mContext, ArrayList<QuaTrinhXuly> quaTrinhXulyArrayList) {
        this.mContext = mContext;
        this.quaTrinhXulyArrayList = quaTrinhXulyArrayList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_quatrinhxulyvanbanchinh, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        QuaTrinhXuly quaTrinhXuly = quaTrinhXulyArrayList.get(position);
        for (int stt = 1; stt <= position + 1; ++stt) {
            viewHolder.tvSTT.setText(String.valueOf(stt));
        }
        viewHolder.tvThoiGian.setText(String.valueOf(quaTrinhXuly.getThoiGian()));
        viewHolder.tvRCVNgioiGui.setText(String.valueOf(quaTrinhXuly.getNguoiGui()));
        viewHolder.tvRCVNoiDung.setText(String.valueOf(quaTrinhXuly.getNoiDung()));
        viewHolder.tvRCVNguoiNhan.setText(String.valueOf(quaTrinhXuly.getNguoiNhan()));

    }

    @Override
    public int getItemCount() {
        return quaTrinhXulyArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvRCVSTT)
        TextView tvSTT;
        @BindView(R.id.tvThoiGian)
        TextView tvThoiGian;
        @BindView(R.id.tvRCVNgioiGui)
        TextView tvRCVNgioiGui;
        @BindView(R.id.tvRCVNoiDung)
        TextView tvRCVNoiDung;
        @BindView(R.id.tvRCVNguoiNhan)
        TextView tvRCVNguoiNhan;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
