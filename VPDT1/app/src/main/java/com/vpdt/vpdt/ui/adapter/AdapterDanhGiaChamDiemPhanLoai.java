package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.ItemMoreDanhGiaKeHoach;

import org.sufficientlysecure.htmltextview.HtmlAssetsImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDanhGiaChamDiemPhanLoai extends RecyclerView.Adapter<AdapterDanhGiaChamDiemPhanLoai.ViewHolder> {
    private ArrayList<ItemMoreDanhGiaKeHoach> itemMoreDanhGiaKeHoachArrayList;


    public AdapterDanhGiaChamDiemPhanLoai(ArrayList<ItemMoreDanhGiaKeHoach> itemMoreDanhGiaKeHoachArrayList) {
        this.itemMoreDanhGiaKeHoachArrayList = itemMoreDanhGiaKeHoachArrayList;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_danhgiachamdiemphanloaipgdtruongphong_sub, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ItemMoreDanhGiaKeHoach itemMoreDanhGiaKeHoach = itemMoreDanhGiaKeHoachArrayList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));

        viewHolder.tvNguoiThucHien.setText(String.valueOf(itemMoreDanhGiaKeHoach.getNguoiThuchien()));
        viewHolder.tvTongSoViecTheoKeHoach.setText(String.valueOf(itemMoreDanhGiaKeHoach.getTsViecTheokehoach()));
        viewHolder.tvSoLuong.setText(String.valueOf(itemMoreDanhGiaKeHoach.getTsCvHoanthanh()));
        viewHolder.tvTronghan.setText(String.valueOf(itemMoreDanhGiaKeHoach.getDhtTronghan()));
        viewHolder.tvQuaHan.setText(String.valueOf(itemMoreDanhGiaKeHoach.getDhtQuahan()));
        viewHolder.tvDamBao.setText(String.valueOf(itemMoreDanhGiaKeHoach.getDhtClDambao()));
        viewHolder.tvChuaDamBao.setText(String.valueOf(itemMoreDanhGiaKeHoach.getDhtClChuaDambao()));
        viewHolder.tvCoTinhSangTao.setText(String.valueOf(itemMoreDanhGiaKeHoach.getDhtSangtao()));
        viewHolder.tvSoLuongCvConTon.setText(String.valueOf(itemMoreDanhGiaKeHoach.getTsCvCht()));
        viewHolder.tvTronghanCvConTon.setText(String.valueOf(itemMoreDanhGiaKeHoach.getChtTronghan()));
        viewHolder.tvChamTienDo.setText(String.valueOf(itemMoreDanhGiaKeHoach.getChtChamtiendo()));
        viewHolder.tvTyLeHoanThanh.setText(String.valueOf(itemMoreDanhGiaKeHoach.getTileHoanthanh()));
        viewHolder.tvTyLeHoanThanhDungHan.setText(String.valueOf(itemMoreDanhGiaKeHoach.getTileHoanthanhDunghan()));
        viewHolder.tvTyLeHoanThanhQuaHan.setText(String.valueOf(itemMoreDanhGiaKeHoach.getTileHoanthanhQuahan()));
        viewHolder.tvDiemTuDong.setText(String.valueOf(itemMoreDanhGiaKeHoach.getDiemTudong()));
        viewHolder.tvDiemCaNhan.setText(String.valueOf(itemMoreDanhGiaKeHoach.getDiemCanhan()));
        viewHolder.tvDiemLDSo.setText(String.valueOf(itemMoreDanhGiaKeHoach.getDiemLdSo()));
        if (itemMoreDanhGiaKeHoach.getCanboNhanxet() != null) {
            viewHolder.tvCanBoTuNhanXet.setText(String.valueOf(itemMoreDanhGiaKeHoach.getCanboNhanxet()));
        }
        if (itemMoreDanhGiaKeHoach.getGDNhanxet() != null) {
            viewHolder.tvNhanXetCuaGiamDoc.setHtml(itemMoreDanhGiaKeHoach.getGDNhanxet(), new HtmlAssetsImageGetter(viewHolder.tvNhanXetCuaGiamDoc));
        }
        if (itemMoreDanhGiaKeHoach.getPGDNhanxet() != null) {
            viewHolder.tvNhanXetCuaPhoGiamDoc.setHtml(itemMoreDanhGiaKeHoach.getPGDNhanxet(), new HtmlAssetsImageGetter(viewHolder.tvNhanXetCuaPhoGiamDoc));
        }
        if (itemMoreDanhGiaKeHoach.getDanhGia() != null) {
            viewHolder.tvDanhGia.setText(itemMoreDanhGiaKeHoach.getDanhGia());
            viewHolder.tvDanhGia.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return itemMoreDanhGiaKeHoachArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvSTT)
        TextView tvSTT;
        @BindView(R.id.tvNguoiThucHienDanhGia)
        TextView tvNguoiThucHien;
        @BindView(R.id.tvTongSoViecTheoKeHoachDanhGia)
        TextView tvTongSoViecTheoKeHoach;
        @BindView(R.id.tvSoLuongDanhGia)
        TextView tvSoLuong;
        @BindView(R.id.tvTrongHanDanhGia)
        TextView tvTronghan;
        @BindView(R.id.tvQuaHanDanhGia)
        TextView tvQuaHan;
        @BindView(R.id.tvDamBaoDanhGia)
        TextView tvDamBao;
        @BindView(R.id.tvChuaDamBaoDanhGia)
        TextView tvChuaDamBao;
        @BindView(R.id.tvCoTinhSangTaoDanhGia)
        TextView tvCoTinhSangTao;
        @BindView(R.id.tvSoLuongCongViecTonDanhGia)
        TextView tvSoLuongCvConTon;
        @BindView(R.id.tvTrongHanCongViecTonDanhGia)
        TextView tvTronghanCvConTon;
        @BindView(R.id.tvChamTienDoDanhGia)
        TextView tvChamTienDo;
        @BindView(R.id.tvTyLeHoanThanhDanhGia)
        TextView tvTyLeHoanThanh;
        @BindView(R.id.tvTyLeHoanThanhDungHanDanhGia)
        TextView tvTyLeHoanThanhDungHan;
        @BindView(R.id.tvTyLeHoanThanhQuaHanDanhGia)
        TextView tvTyLeHoanThanhQuaHan;
        @BindView(R.id.tvDiemTuDongDanhGia)
        TextView tvDiemTuDong;
        @BindView(R.id.tvDiemCaNhanDanhGia)
        TextView tvDiemCaNhan;
        @BindView(R.id.tvDiemLDSoDanhGia)
        TextView tvDiemLDSo;
        @BindView(R.id.tvCanBoTuNhanXetDanhGia)
        TextView tvCanBoTuNhanXet;
        @BindView(R.id.tvNhanXetCuaPhoGiamDoc)
        HtmlTextView tvNhanXetCuaPhoGiamDoc;
        @BindView(R.id.tvNhanXetCuaGiamDoc)
        HtmlTextView tvNhanXetCuaGiamDoc;
        @BindView(R.id.tvDanhGia)
        TextView tvDanhGia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }
}
