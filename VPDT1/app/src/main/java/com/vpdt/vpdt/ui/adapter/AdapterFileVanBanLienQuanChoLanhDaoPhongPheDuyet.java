package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.FileVanBanLienQuanChoLanhDaoPhongPheDuyet;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterFileVanBanLienQuanChoLanhDaoPhongPheDuyet extends RecyclerView.Adapter<AdapterFileVanBanLienQuanChoLanhDaoPhongPheDuyet.ViewHolder> {
    private ArrayList<FileVanBanLienQuanChoLanhDaoPhongPheDuyet> trinhTuGiaiQuyets;

    private OnItemClickListenerFileVanBanLienQuanChoLanhDaoPhongPheDuyet listener;

    public AdapterFileVanBanLienQuanChoLanhDaoPhongPheDuyet(ArrayList<FileVanBanLienQuanChoLanhDaoPhongPheDuyet> trinhTuGiaiQuyets, OnItemClickListenerFileVanBanLienQuanChoLanhDaoPhongPheDuyet listener) {
        this.trinhTuGiaiQuyets = trinhTuGiaiQuyets;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_filevanbanlienquan, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        FileVanBanLienQuanChoLanhDaoPhongPheDuyet trinhTuGiaiQuyet = trinhTuGiaiQuyets.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvCanBoDonVi.setText(String.valueOf(trinhTuGiaiQuyet.getTenCanBo() + " - " + trinhTuGiaiQuyet.getDonVi()));
        viewHolder.tvTaiVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickFileVanBanLienQuanChoLanhDaoPhongPheDuyet(trinhTuGiaiQuyets.get(position));
                }
            }
        });
        viewHolder.tvNgayNhap.setText(String.valueOf(trinhTuGiaiQuyet.getNgayNhap()));
        viewHolder.tvTenFile.setText(String.valueOf(trinhTuGiaiQuyet.getTenTepTin()));

    }

    @Override
    public int getItemCount() {
        return trinhTuGiaiQuyets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvSTT)
        TextView tvSTT;
        @BindView(R.id.tvCanBoDonVi)
        TextView tvCanBoDonVi;
        @BindView(R.id.tvTenFile)
        TextView tvTenFile;
        @BindView(R.id.tvNgayNhap)
        TextView tvNgayNhap;
        @BindView(R.id.tvTaiVe)
        TextView tvTaiVe;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public interface OnItemClickListenerFileVanBanLienQuanChoLanhDaoPhongPheDuyet {
        void onItemClickFileVanBanLienQuanChoLanhDaoPhongPheDuyet(FileVanBanLienQuanChoLanhDaoPhongPheDuyet fileVanBanLienQuanChoLanhDaoPhongPheDuyet);
    }
}
