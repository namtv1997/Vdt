package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.KeHoachCongTacTuan;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterKetQuaCongTacTuanCuaPhong extends RecyclerView.Adapter<AdapterKetQuaCongTacTuanCuaPhong.ViewHolder> {
    private ArrayList<KeHoachCongTacTuan> keHoachCongTacTuanArrayList;
    private Context mContext;
    private OnItemClickListener listener;

    public AdapterKetQuaCongTacTuanCuaPhong(Context context, ArrayList<KeHoachCongTacTuan> keHoachCongTacTuanArrayList, OnItemClickListener listener) {
        this.mContext = context;
        this.keHoachCongTacTuanArrayList = keHoachCongTacTuanArrayList;
        this.listener = listener;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_danhsachkehoachcongtactuan, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        KeHoachCongTacTuan keHoachCongTacTuan = keHoachCongTacTuanArrayList.get(position);

        viewHolder.tvSTT.setText(String.valueOf(position + 1));

        viewHolder.tvPhongBanDonVi.setText(String.valueOf(keHoachCongTacTuan.getPhongBan()));
        viewHolder.tvTongSoViec.setText(String.valueOf(keHoachCongTacTuan.getTsKehoach()));
        viewHolder.tvSoLuong.setText(String.valueOf(keHoachCongTacTuan.getSlCvHoanthanh()));
        viewHolder.tvTronghan.setText(String.valueOf(keHoachCongTacTuan.getCvHoanthanhTronghan()));
        viewHolder.tvQuaHan.setText(String.valueOf(keHoachCongTacTuan.getCvHoanthanhQuahan()));
        viewHolder.tvDamBao.setText(String.valueOf(keHoachCongTacTuan.getCvHoanthanhClDambao()));
        viewHolder.tvChuaDamBao.setText(String.valueOf(keHoachCongTacTuan.getCvHoanthanhClChuadambao()));
        viewHolder.tvCoTinhSangTao.setText(String.valueOf(keHoachCongTacTuan.getCvHoanthanhSangtao()));
        viewHolder.tvSoLuongCvConTon.setText(String.valueOf(keHoachCongTacTuan.getSlCvTon()));
        viewHolder.tvTronghanCvConTon.setText(String.valueOf(keHoachCongTacTuan.getCvTonTronghan()));
        viewHolder.tvChamTienDo.setText(String.valueOf(keHoachCongTacTuan.getCvTonChamtiendo()));
        viewHolder.tvTyLeHoanThanh.setText(String.valueOf(keHoachCongTacTuan.getTileHoanthanh()));
        viewHolder.tvPhongBanDonVi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickPhongBan(keHoachCongTacTuanArrayList.get(position));
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return keHoachCongTacTuanArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvSTT)
        TextView tvSTT;
        @BindView(R.id.tvPhongBanDonVi)
        TextView tvPhongBanDonVi;
        @BindView(R.id.tvTongSoViec)
        TextView tvTongSoViec;
        @BindView(R.id.tvSoLuong)
        TextView tvSoLuong;
        @BindView(R.id.tvTronghan)
        TextView tvTronghan;
        @BindView(R.id.tvQuaHan)
        TextView tvQuaHan;
        @BindView(R.id.tvDamBao)
        TextView tvDamBao;
        @BindView(R.id.tvChuaDamBao)
        TextView tvChuaDamBao;
        @BindView(R.id.tvCoTinhSangTao)
        TextView tvCoTinhSangTao;
        @BindView(R.id.tvSoLuongCvConTon)
        TextView tvSoLuongCvConTon;
        @BindView(R.id.tvTronghanCvConTon)
        TextView tvTronghanCvConTon;
        @BindView(R.id.tvChamTienDo)
        TextView tvChamTienDo;
        @BindView(R.id.tvTyLeHoanThanh)
        TextView tvTyLeHoanThanh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public interface OnItemClickListener {
        void onItemClickPhongBan(KeHoachCongTacTuan keHoachCongTacTuan);
    }
}
