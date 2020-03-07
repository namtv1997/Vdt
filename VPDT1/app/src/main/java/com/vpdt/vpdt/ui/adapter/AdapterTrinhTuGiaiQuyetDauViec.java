package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.TrinhTuGiaiQuyetDauViec1;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTrinhTuGiaiQuyetDauViec extends RecyclerView.Adapter<AdapterTrinhTuGiaiQuyetDauViec.ViewHolder> {
    private ArrayList<TrinhTuGiaiQuyetDauViec1> trinhTuGiaiQuyetDauViecArrayList;
    private Context mContext;

    public AdapterTrinhTuGiaiQuyetDauViec(Context mContext, ArrayList<TrinhTuGiaiQuyetDauViec1> trinhTuGiaiQuyetDauViecArrayList) {
        this.mContext = mContext;
        this.trinhTuGiaiQuyetDauViecArrayList = trinhTuGiaiQuyetDauViecArrayList;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_trinhtugiaiquyet_quanlydauviec, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        TrinhTuGiaiQuyetDauViec1 item = trinhTuGiaiQuyetDauViecArrayList.get(position);
        viewHolder.tvRCVSTT.setText(String.valueOf(position + 1));
        viewHolder.tvRCVNguoiNhan.setText(String.valueOf(item.getNguoiNhan()));
        viewHolder.tvRCVThoiGianChuyen.setText(String.valueOf(item.getThoiGian()));
        viewHolder.tvRCVNguoiChuyen.setText(item.getNguoiChuyen());
        viewHolder.tvRCVNoiDungChuyen.setText(item.getNoiDungChuyen());
        viewHolder.tvRCVHanXuLy.setText(item.getHanXuLy());

    }

    @Override
    public int getItemCount() {
        return trinhTuGiaiQuyetDauViecArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tvRCVSTT)
        TextView tvRCVSTT;
        @BindView(R.id.tvRCVThoiGianChuyen)
        TextView tvRCVThoiGianChuyen;
        @BindView(R.id.tvRCVNguoiChuyen)
        TextView tvRCVNguoiChuyen;
        @BindView(R.id.tvRCVNoiDungChuyen)
        TextView tvRCVNoiDungChuyen;
        @BindView(R.id.tvRCVNguoiNhan)
        TextView tvRCVNguoiNhan;
        @BindView(R.id.tvRCVHanXuLy)
        TextView tvRCVHanXuLy;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }
}
