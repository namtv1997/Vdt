package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.DSVB_TheoPhong;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDanhSachVanBanTheoPhong extends RecyclerView.Adapter<AdapterDanhSachVanBanTheoPhong.ViewHolder> {
    private ArrayList<DSVB_TheoPhong> dsvb_theoPhongArrayList;
    private Context mContext;
    private OnItemClickListener listener;

    public AdapterDanhSachVanBanTheoPhong(Context mContext, ArrayList<DSVB_TheoPhong> dsvb_theoPhongArrayList, OnItemClickListener listener) {
        this.mContext = mContext;
        this.dsvb_theoPhongArrayList = dsvb_theoPhongArrayList;
        this.listener = listener;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_theo_phong, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        DSVB_TheoPhong dsvb_quaHan = dsvb_theoPhongArrayList.get(position);
        viewHolder.stt.setText(String.valueOf(position + 1));
        viewHolder.tvPhongBan.setText(String.valueOf(dsvb_quaHan.getTenPhongban()));
        viewHolder.tvSoViecDuocGiao.setText(String.valueOf(dsvb_quaHan.getTongSoViec()));
        viewHolder.tvTongSoDaGiaiQuyet.setText(String.valueOf(dsvb_quaHan.getDgqTongSo()));
        viewHolder.tvDaGiaiQuyetDungHan.setText(String.valueOf(dsvb_quaHan.getDgqDungHan()));
        viewHolder.tvDaGiaiQuyetQuaHan.setText(String.valueOf(dsvb_quaHan.getDgqQuaHan()));
        viewHolder.tvCoTinhSangTao.setText(String.valueOf(dsvb_quaHan.getDgqCoSangTao()));
        viewHolder.tvTongSoChuaGiaiQuyet.setText(String.valueOf(dsvb_quaHan.getCgqTongSo()));
        viewHolder.tvTrongHan.setText(String.valueOf(dsvb_quaHan.getCgqTrongHan()));
        viewHolder.tvQuaHanChuaGiaiQuyet.setText(String.valueOf(dsvb_quaHan.getCgqQuaHan()));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(dsvb_theoPhongArrayList.get(position));
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return dsvb_theoPhongArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tvSTT)
        TextView stt;
        @BindView(R.id.tvPhongBan)
        TextView tvPhongBan;
        @BindView(R.id.tvSoViecDuocGiao)
        TextView tvSoViecDuocGiao;
        @BindView(R.id.tvTongSoDaGiaiQuyet)
        TextView tvTongSoDaGiaiQuyet;
        @BindView(R.id.tvDaGiaiQuyetDungHan)
        TextView tvDaGiaiQuyetDungHan;
        @BindView(R.id.tvDaGiaiQuyetQuaHan)
        TextView tvDaGiaiQuyetQuaHan;
        @BindView(R.id.tvCoTinhSangTao)
        TextView tvCoTinhSangTao;
        @BindView(R.id.tvTongSoChuaGiaiQuyet)
        TextView tvTongSoChuaGiaiQuyet;
        @BindView(R.id.tvTrongHan)
        TextView tvTrongHan;
        @BindView(R.id.tvQuaHanChuaGiaiQuyet)
        TextView tvQuaHanChuaGiaiQuyet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public interface OnItemClickListener {
        void onItemClick(DSVB_TheoPhong dsvb_theoPhong);
    }
}
