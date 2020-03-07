package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.Chitiet;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterPhanLoaiCongChucCuaPhongTheoThang2 extends RecyclerView.Adapter<AdapterPhanLoaiCongChucCuaPhongTheoThang2.ViewHolder> {
    private ArrayList<Chitiet> chitietArrayList;

    public AdapterPhanLoaiCongChucCuaPhongTheoThang2(ArrayList<Chitiet> chitietArrayList) {
        this.chitietArrayList = chitietArrayList;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_phanloaicongchuccuaphongtheothang, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Chitiet chitiets = chitietArrayList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvPhongBanDonVi.setText(String.valueOf(chitiets.getTencb()));
        viewHolder.tvTongSoViec.setText(String.valueOf(chitiets.getTsKehoach()));
        viewHolder.tvSoLuong.setText(String.valueOf(chitiets.getSlCvHoanthanh()));
        viewHolder.tvTronghan.setText(String.valueOf(chitiets.getCvHoanthanhTronghan()));
        viewHolder.tvQuaHan.setText(String.valueOf(chitiets.getCvHoanthanhQuahan()));
        viewHolder.tvDamBao.setText(String.valueOf(chitiets.getCvHoanthanhClDambao()));
        viewHolder.tvChuaDamBao.setText(String.valueOf(chitiets.getCvHoanthanhClChuadambao()));
        viewHolder.tvCoTinhSangTao.setText(String.valueOf(chitiets.getCvHoanthanhSangtao()));
        viewHolder.tvSoLuongCvConTon.setText(String.valueOf(chitiets.getSlCvTon()));
        viewHolder.tvTronghanCvConTon.setText(String.valueOf(chitiets.getCvTonTronghan()));
        viewHolder.tvChamTienDo.setText(String.valueOf(chitiets.getCvTonChamtiendo()));
        viewHolder.tvTyLeHoanThanh.setText(String.valueOf(chitiets.getTileHoanthanh() + "%"));
        viewHolder.tvDiemTrungBinhCuaThang.setText(String.valueOf(chitiets.getDiemTB()));
        String date = String.valueOf(chitiets.getDateCanhanDG());
        String date1 = String.valueOf(chitiets.getDateTruongphongDG());
        if (chitiets.getCanhanNhanxet().isEmpty() || chitiets.getCanhanNhanxet() == null) {
            if (date.isEmpty() || date == null || date == "null") {
                if (chitiets.getCanhanDanhgia().isEmpty() || chitiets.getCanhanDanhgia() == null) {
                    viewHolder.tvKetQuaPhanLoaiMucDoHoanThanhNVCaNhan.setText("");
                } else {
                    viewHolder.tvKetQuaPhanLoaiMucDoHoanThanhNVCaNhan.setText(String.valueOf(chitiets.getCanhanDanhgia()));
                }
            } else {
                viewHolder.tvKetQuaPhanLoaiMucDoHoanThanhNVCaNhan.setText(String.valueOf(chitiets.getDateCanhanDG() + '\n' + chitiets.getCanhanDanhgia()));
            }
        } else {
            viewHolder.tvKetQuaPhanLoaiMucDoHoanThanhNVCaNhan.setText(String.valueOf("Cá nhân tự nhận xét, đánh giá, phân loại: "
                    + chitiets.getCanhanNhanxet() + '\n' + chitiets.getDateCanhanDG() + '\n' + chitiets.getCanhanDanhgia()));
        }
        if (chitiets.getTruongphongNhanxet().isEmpty() || chitiets.getTruongphongNhanxet() == null) {
            if (date1.isEmpty() || date1 == null) {
                if (chitiets.getTruongphongDanhgia().isEmpty() || chitiets.getTruongphongDanhgia() == null) {
                    viewHolder.tvKetQuaPhanLoaiMucDoHoanThanhNVCaNhan.setText("");
                } else {
                    viewHolder.tvKetQuaPhanLoaiMucDoHoanThanhNVCaNhan.setText(String.valueOf(chitiets.getTruongphongDanhgia()));
                }
            } else {
                viewHolder.tvKetQuaPhanLoaiMucDoHoanThanhNVCaNhan.setText(String.valueOf(chitiets.getDateTruongphongDG() + '\n' + chitiets.getTruongphongDanhgia()));
            }
        } else {
            viewHolder.tvKetQuaPhanLoaiMucDoHoanThanhNVTruongPhong.setText(String.valueOf("Nhận xét, đánh giá, phân loại của trưởng phòng: "
                    + chitiets.getTruongphongNhanxet() + '\n' + chitiets.getDateTruongphongDG() + '\n' + chitiets.getTruongphongDanhgia()));
        }
    }

    @Override
    public int getItemCount() {
        return chitietArrayList.size();
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
        @BindView(R.id.tvDiemTrungBinhCuaThang)
        TextView tvDiemTrungBinhCuaThang;
        @BindView(R.id.tvKetQuaPhanLoaiMucDoHoanThanhNVCaNhan)
        TextView tvKetQuaPhanLoaiMucDoHoanThanhNVCaNhan;
        @BindView(R.id.tvKetQuaPhanLoaiMucDoHoanThanhNVTruongPhong)
        TextView tvKetQuaPhanLoaiMucDoHoanThanhNVTruongPhong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
