package com.vpdt.vpdt.ui.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.DanhGiaGD;

import org.sufficientlysecure.htmltextview.HtmlAssetsImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterGDSoTuNhanXetDanhGiaKetQuaThang extends RecyclerView.Adapter<AdapterGDSoTuNhanXetDanhGiaKetQuaThang.ViewHolder> {
    private ArrayList<DanhGiaGD> keHoachCongTacTuanArrayList;
    private OnItemClickListenerDanhGiaGiamDoc listener;

    public AdapterGDSoTuNhanXetDanhGiaKetQuaThang(ArrayList<DanhGiaGD> keHoachCongTacTuanArrayList, OnItemClickListenerDanhGiaGiamDoc listener) {

        this.keHoachCongTacTuanArrayList = keHoachCongTacTuanArrayList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_gdtunhanxet, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.setIsRecyclable(true);
        DanhGiaGD keHoachCongTacTuan = keHoachCongTacTuanArrayList.get(position);
        viewHolder.tvStt.setText(String.valueOf(keHoachCongTacTuan.getSTT()));

        viewHolder.tvNoiDung.setHtml(keHoachCongTacTuan.getNoidung(), new HtmlAssetsImageGetter(viewHolder.tvNoiDung));
        if (keHoachCongTacTuan.getTsKehoach() != 0) {
            viewHolder.tvts_kehoach.setText(String.valueOf(keHoachCongTacTuan.getTsKehoach()));
        }
        if (keHoachCongTacTuan.getSlCvHoanthanh() != 0) {
            viewHolder.tvsl_cv_hoanthanh.setText(String.valueOf(keHoachCongTacTuan.getSlCvHoanthanh()));
        }
        if (keHoachCongTacTuan.getCvHoanthanhTronghan() != 0) {

            viewHolder.tvcv_hoanthanh_tronghan.setText(String.valueOf(keHoachCongTacTuan.getCvHoanthanhTronghan()));
        }
        if (keHoachCongTacTuan.getCvHoanthanhQuahan() != 0) {

            viewHolder.tvcv_hoanthanh_quahan.setText(String.valueOf(keHoachCongTacTuan.getCvHoanthanhQuahan()));
        }
        if (keHoachCongTacTuan.getCvHoanthanhClDambao() != 0) {

            viewHolder.tvcv_hoanthanh_cl_dambao.setText(String.valueOf(keHoachCongTacTuan.getCvHoanthanhClDambao()));
        }
        if (keHoachCongTacTuan.getCvHoanthanhClChuadambao() != 0) {

            viewHolder.tvcv_hoanthanh_cl_chuadambao.setText(String.valueOf(keHoachCongTacTuan.getCvHoanthanhClChuadambao()));
        }
        if (keHoachCongTacTuan.getCvHoanthanhSangtao() != 0) {

            viewHolder.tvcv_hoanthanh_sangtao.setText(String.valueOf(keHoachCongTacTuan.getCvHoanthanhSangtao()));
        }
        if (keHoachCongTacTuan.getSlCvTon() != 0) {

            viewHolder.tvsl_cv_ton.setText(String.valueOf(keHoachCongTacTuan.getSlCvTon()));
        }
        if (keHoachCongTacTuan.getCvTonTronghan() != 0) {

            viewHolder.tvcv_ton_tronghan.setText(String.valueOf(keHoachCongTacTuan.getCvTonTronghan()));
        }
        if (keHoachCongTacTuan.getCvTonChamtiendo() != 0) {

            viewHolder.tvcv_ton_chamtiendo.setText(String.valueOf(keHoachCongTacTuan.getCvTonChamtiendo()));
        }
        if (keHoachCongTacTuan.getTileHoanthanh() != 0) {

            viewHolder.tvtile_hoanthanh.setText(String.valueOf(keHoachCongTacTuan.getTileHoanthanh()));
        }
        if (keHoachCongTacTuan.getMaychamTudong() != 0) {

            viewHolder.tvmaycham_tudong.setText(String.valueOf(keHoachCongTacTuan.getMaychamTudong()));
        }
        if (keHoachCongTacTuan.getCanhanTucham() != null) {

            viewHolder.tvCaNhanTuCham.setText(String.valueOf(keHoachCongTacTuan.getCanhanTucham()));

        }
        if (!keHoachCongTacTuan.getSTT().equals("B") && !keHoachCongTacTuan.getSTT().equals("C")) {
            viewHolder.tvCaNhanTuCham.setText("[Chọn điểm]");
        }
        viewHolder.tvCaNhanTuCham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickDanhGiaGiamDoc(keHoachCongTacTuanArrayList.get(position), v);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return keHoachCongTacTuanArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvStt)
        TextView tvStt;
        @BindView(R.id.tvNoiDung)
        HtmlTextView tvNoiDung;
        @BindView(R.id.tvts_kehoach)
        TextView tvts_kehoach;
        @BindView(R.id.tvsl_cv_hoanthanh)
        TextView tvsl_cv_hoanthanh;
        @BindView(R.id.tvcv_hoanthanh_tronghan)
        TextView tvcv_hoanthanh_tronghan;
        @BindView(R.id.tvcv_hoanthanh_quahan)
        TextView tvcv_hoanthanh_quahan;
        @BindView(R.id.tvcv_hoanthanh_cl_dambao)
        TextView tvcv_hoanthanh_cl_dambao;
        @BindView(R.id.tvcv_hoanthanh_cl_chuadambao)
        TextView tvcv_hoanthanh_cl_chuadambao;
        @BindView(R.id.tvcv_hoanthanh_sangtao)
        TextView tvcv_hoanthanh_sangtao;
        @BindView(R.id.tvsl_cv_ton)
        TextView tvsl_cv_ton;
        @BindView(R.id.tvcv_ton_chamtiendo)
        TextView tvcv_ton_chamtiendo;
        @BindView(R.id.tvtile_hoanthanh)
        TextView tvtile_hoanthanh;
        @BindView(R.id.tvmaycham_tudong)
        TextView tvmaycham_tudong;
        @BindView(R.id.tvCaNhanTuCham)
        TextView tvCaNhanTuCham;
        @BindView(R.id.tvcv_ton_tronghan)
        TextView tvcv_ton_tronghan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public interface OnItemClickListenerDanhGiaGiamDoc {
        void onItemClickDanhGiaGiamDoc(DanhGiaGD danhGiaGD, View view);
    }
}
