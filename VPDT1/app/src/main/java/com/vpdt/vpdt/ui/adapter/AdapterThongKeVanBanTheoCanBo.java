package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.ThongKeTheoPhong;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterThongKeVanBanTheoCanBo extends RecyclerView.Adapter<AdapterThongKeVanBanTheoCanBo.ViewHolder> {
    private ArrayList<ThongKeTheoPhong> dsvb_theoPhongArrayList;
    private OnItemClickListener listener;

    public AdapterThongKeVanBanTheoCanBo(ArrayList<ThongKeTheoPhong> dsvb_theoPhongArrayList, OnItemClickListener listener) {
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
        ThongKeTheoPhong dsvb_quaHan = dsvb_theoPhongArrayList.get(position);
        viewHolder.stt.setText(String.valueOf(position + 1));
        viewHolder.tvPhongBan.setText(String.valueOf(dsvb_quaHan.getTen()));
        viewHolder.tvSoViecDuocGiao.setText(String.valueOf(dsvb_quaHan.getTongSV()));
        viewHolder.tvTongSoDaGiaiQuyet.setText(String.valueOf(dsvb_quaHan.getDgqTong()));

        viewHolder.tvDaGiaiQuyetDungHan.setText(String.valueOf(dsvb_quaHan.getDgqDunghan()));

        viewHolder.tvDaGiaiQuyetQuaHan.setText(String.valueOf(dsvb_quaHan.getDgqQuahan()));

        viewHolder.tvCoTinhSangTao.setText(String.valueOf(dsvb_quaHan.getDgqSangtao()));

        viewHolder.tvTongSoChuaGiaiQuyet.setText(String.valueOf(dsvb_quaHan.getCgqTong()));

        viewHolder.tvTrongHan.setText(String.valueOf(dsvb_quaHan.getCgqTronghan()));
        viewHolder.tvQuaHanChuaGiaiQuyet.setText(String.valueOf(dsvb_quaHan.getCgqQuahan()));

        viewHolder.tvSoViecDuocGiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onSoViecDuocGiaoClick(dsvb_theoPhongArrayList.get(position));
                }
            }
        });

        viewHolder.tvTongSoDaGiaiQuyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onTongSoViecDaGiaiQuyetClick(dsvb_theoPhongArrayList.get(position));
                }
            }
        });

        viewHolder.tvDaGiaiQuyetDungHan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onDungHanDaGiaiQuyetClick(dsvb_theoPhongArrayList.get(position));
                }
            }
        });

        viewHolder.tvDaGiaiQuyetQuaHan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onQuaHanDaGiaiQuyetClick(dsvb_theoPhongArrayList.get(position));
                }
            }
        });

        viewHolder.tvCoTinhSangTao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onCoSangTaoClick(dsvb_theoPhongArrayList.get(position));
                }
            }
        });

        viewHolder.tvTongSoChuaGiaiQuyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onTongSoViecChuaGiaiQuyetClick(dsvb_theoPhongArrayList.get(position));
                }
            }
        });

        viewHolder.tvTrongHan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onDungHanChuaGiaiQuyetClick(dsvb_theoPhongArrayList.get(position));
                }
            }
        });

        viewHolder.tvQuaHanChuaGiaiQuyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onQuaHanChuaGiaiQuyetClick(dsvb_theoPhongArrayList.get(position));
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
        void onSoViecDuocGiaoClick(ThongKeTheoPhong thongKeTheoPhong);

        void onTongSoViecDaGiaiQuyetClick(ThongKeTheoPhong thongKeTheoPhong);

        void onDungHanDaGiaiQuyetClick(ThongKeTheoPhong thongKeTheoPhong);

        void onQuaHanDaGiaiQuyetClick(ThongKeTheoPhong thongKeTheoPhong);

        void onCoSangTaoClick(ThongKeTheoPhong thongKeTheoPhong);

        void onTongSoViecChuaGiaiQuyetClick(ThongKeTheoPhong thongKeTheoPhong);

        void onDungHanChuaGiaiQuyetClick(ThongKeTheoPhong thongKeTheoPhong);

        void onQuaHanChuaGiaiQuyetClick(ThongKeTheoPhong thongKeTheoPhon);
    }
}
