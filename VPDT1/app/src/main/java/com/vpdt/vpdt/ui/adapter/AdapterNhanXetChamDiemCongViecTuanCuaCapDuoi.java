package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.NhanXetChamDiemCongViecTuanCuaCapDuoi;

import org.sufficientlysecure.htmltextview.HtmlAssetsImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterNhanXetChamDiemCongViecTuanCuaCapDuoi extends RecyclerView.Adapter<AdapterNhanXetChamDiemCongViecTuanCuaCapDuoi.ViewHolder> {
    private ArrayList<NhanXetChamDiemCongViecTuanCuaCapDuoi> nhanXetChamDiemCongViecTuanCuaCapDuoiArrayList;
    private Context mContext;
    private OnItemClickListener listener;

    public AdapterNhanXetChamDiemCongViecTuanCuaCapDuoi(Context context, ArrayList<NhanXetChamDiemCongViecTuanCuaCapDuoi> nhanXetChamDiemCongViecTuanCuaCapDuoiArrayList, OnItemClickListener listener) {
        this.mContext = context;
        this.nhanXetChamDiemCongViecTuanCuaCapDuoiArrayList = nhanXetChamDiemCongViecTuanCuaCapDuoiArrayList;
        this.listener = listener;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_nhanxetcongtactuancuacapduoi, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        NhanXetChamDiemCongViecTuanCuaCapDuoi nhanXetChamDiemCongViecTuanCuaCapDuoi = nhanXetChamDiemCongViecTuanCuaCapDuoiArrayList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvMayCham.setText(String.valueOf("Máy chấm" + '\n' + nhanXetChamDiemCongViecTuanCuaCapDuoi.getMayChamDiemtong()));
        viewHolder.tvVanPhongDienTuMayCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getMayChamVPDT()));
        viewHolder.tvTongDiemMayCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getMayChamYThucTong()));
        viewHolder.tvChapHanhDuongLoiMayCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getMayChamYThucChaphanh()));
        viewHolder.tvKhongHachDichMayCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getMayChamYThucKHachDich()));
        viewHolder.tvCoPhamChatChinhTriMayCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getMayChamYThucChinhTri()));
        viewHolder.tvThucHienVanHoaNoiCongSoMayCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getMayChamYThucVHCongSo()));
        viewHolder.tvXayDungHinhAnhMayCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getMayChamYThucXDHinhAnh()));
        viewHolder.tvSuDungHieuQuaTGLamViecMayCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getMayChamYThucSuDungTgian()));
        viewHolder.tvTongDiemNangLucMayCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getMayChamNangLucTong()));
        viewHolder.tvThuongXuyenHocTapRenLuyenMayCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getMayChamNangLucHocTap()));
        viewHolder.tvXayDungCongTacTuanMayCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getMayChamNangLucXDKeHoach()));
        viewHolder.tvChiDaoDIeuHanhKiemSoatMayCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getMayChamNangLucChiDao()));
        viewHolder.tvKiemTraDonDocViecThucHienMayCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getMayChamNangLucKtraDonDoc()));
        viewHolder.tvCoNangLucQuyTuMayCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getMayChamNangLucQuyTuTapHopCC()));
        viewHolder.tvSuDungThanhThaoCacPhanMemMayCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getMayChamNangLucThanhThaoPM()));
        viewHolder.tvThietLapHoSoCongViecDayDuMayCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getMayChamNangLucThietLapHSo()));
        viewHolder.tvDiemThuongMayCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getMayChamDiemThuong()));
        viewHolder.tvCaNhanCham.setText(String.valueOf("Cá nhân chấm (" + nhanXetChamDiemCongViecTuanCuaCapDuoi.getCaNhanTgianCham() + ")" + '\n' + nhanXetChamDiemCongViecTuanCuaCapDuoi.getCaNhanDiemtong()));
        viewHolder.tvVanPhongDienTuCaNhanCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getCaNhanVPDT()));
        viewHolder.tvTongDiemCaNhanCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getCaNhanYThucTong()));
        viewHolder.tvChapHanhDuongLoiCaNhanCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getCaNhanYThucChaphanh()));
        viewHolder.tvKhongHachDichCaNhanCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getCaNhanYThucKHachDich()));
        viewHolder.tvCoPhamChatChinhTriCaNhanCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getCaNhanYThucChinhTri()));
        viewHolder.tvThucHienVanHoaNoiCongSoCaNhanCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getCaNhanYThucVHCongSo()));
        viewHolder.tvXayDungHinhAnhCaNhanCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getCaNhanYThucXDHinhAnh()));
        viewHolder.tvSuDungHieuQuaTGLamViecCaNhanCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getCaNhanYThucSuDungTgian()));
        viewHolder.tvTongDiemNangLucCaNhanCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getCaNhanNangLucTong()));
        viewHolder.tvThuongXuyenHocTapRenLuyenCaNhanCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getCaNhanNangLucHocTap()));
        viewHolder.tvXayDungCongTacTuanCaNhanCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getCaNhanNangLucXDKeHoach()));
        viewHolder.tvChiDaoDIeuHanhKiemSoatCaNhanCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getCaNhanNangLucChiDao()));
        viewHolder.tvKiemTraDonDocViecThucHienCaNhanCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getCaNhanNangLucKtraDonDoc()));
        viewHolder.tvCoNangLucQuyTuCaNhanCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getCaNhanNangLucQuyTuTapHopCC()));
        viewHolder.tvSuDungThanhThaoCacPhanMemCaNhanCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getCaNhanNangLucThanhThaoPM()));
        viewHolder.tvThietLapHoSoCongViecDayDuCaNhanCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getCaNhanNangLucThietLapHSo()));
        viewHolder.tvDiemThuongCaNhanCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getCaNhanDiemThuong()));
        viewHolder.tvTruongDonViCham.setText(String.valueOf("Trưởng đơn vị chấm (" + nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViTgianCham() + ")" + '\n'
                + nhanXetChamDiemCongViecTuanCuaCapDuoi.getTencb() + '\n' + nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViDiemtong() + " Điểm"));
        viewHolder.tvVanPhongDienTuTruongDonViCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViVPDT()));
        viewHolder.tvTongDiemTruongDonViCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViYThucTong()));
        viewHolder.tvChapHanhDuongLoiTruongDonViCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViYThucChaphanh()));
        viewHolder.tvKhongHachDichTruongDonViCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViYThucKHachDich()));
        viewHolder.tvCoPhamChatChinhTriTruongDonViCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViYThucChinhTri()));
        viewHolder.tvThucHienVanHoaNoiCongSoTruongDonViCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViYThucVHCongSo()));
        viewHolder.tvXayDungHinhAnhTruongDonViCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViYThucXDHinhAnh()));
        viewHolder.tvSuDungHieuQuaTGLamViecTruongDonViCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViYThucSuDungTgian()));
        viewHolder.tvTongDiemNangLucTruongDonViCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViNangLucTong()));
        viewHolder.tvThuongXuyenHocTapRenLuyenTruongDonViCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViNangLucHocTap()));
        viewHolder.tvXayDungCongTacTuanTruongDonViCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViNangLucXDKeHoach()));
        viewHolder.tvChiDaoDIeuHanhKiemSoatTruongDonViCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViNangLucChiDao()));
        viewHolder.tvKiemTraDonDocViecThucHienTruongDonViCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViNangLucKtraDonDoc()));
        viewHolder.tvCoNangLucQuyTuTruongDonViCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViNangLucQuyTuTapHopCC()));
        viewHolder.tvSuDungThanhThaoCacPhanMemTruongDonViCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViNangLucThanhThaoPM()));
        viewHolder.tvThietLapHoSoCongViecDayDuTruongDonViCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViNangLucThietLapHSo()));
        viewHolder.tvDiemThuongTruongDonViCham.setText(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViDiemThuong()));
        if (nhanXetChamDiemCongViecTuanCuaCapDuoi.getPhoPhongNhanxet().isEmpty() && nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViNhanxet().isEmpty()) {
            viewHolder.tvNhanXet.setHtml(String.valueOf(""), new HtmlAssetsImageGetter(viewHolder.tvNhanXet));
        } else if (nhanXetChamDiemCongViecTuanCuaCapDuoi.getPhoPhongNhanxet().isEmpty() && !nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViNhanxet().isEmpty()) {
            viewHolder.tvNhanXet.setHtml(String.valueOf("Nhận xét của trưởng phòng: " + '\n' + nhanXetChamDiemCongViecTuanCuaCapDuoi.getPhoPhongNhanxet()), new HtmlAssetsImageGetter(viewHolder.tvNhanXet));
        } else if (!nhanXetChamDiemCongViecTuanCuaCapDuoi.getPhoPhongNhanxet().isEmpty() && nhanXetChamDiemCongViecTuanCuaCapDuoi.getTruongDonViNhanxet().isEmpty()) {
            viewHolder.tvNhanXet.setHtml(String.valueOf(nhanXetChamDiemCongViecTuanCuaCapDuoi.getPhoPhongNhanxet()), new HtmlAssetsImageGetter(viewHolder.tvNhanXet));
        }

        viewHolder.tvTruongDonViCham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickPhongBan(nhanXetChamDiemCongViecTuanCuaCapDuoiArrayList.get(position));
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return nhanXetChamDiemCongViecTuanCuaCapDuoiArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvSTT)
        TextView tvSTT;
        @BindView(R.id.tvMayCham)
        TextView tvMayCham;
        @BindView(R.id.tvVanPhongDienTuMayCham)
        TextView tvVanPhongDienTuMayCham;
        @BindView(R.id.tvTongDiemMayCham)
        TextView tvTongDiemMayCham;
        @BindView(R.id.tvChapHanhDuongLoiMayCham)
        TextView tvChapHanhDuongLoiMayCham;
        @BindView(R.id.tvKhongHachDichMayCham)
        TextView tvKhongHachDichMayCham;
        @BindView(R.id.tvCoPhamChatChinhTriMayCham)
        TextView tvCoPhamChatChinhTriMayCham;
        @BindView(R.id.tvThucHienVanHoaNoiCongSoMayCham)
        TextView tvThucHienVanHoaNoiCongSoMayCham;
        @BindView(R.id.tvXayDungHinhAnhMayCham)
        TextView tvXayDungHinhAnhMayCham;
        @BindView(R.id.tvSuDungHieuQuaTGLamViecMayCham)
        TextView tvSuDungHieuQuaTGLamViecMayCham;
        @BindView(R.id.tvTongDiemNangLucMayCham)
        TextView tvTongDiemNangLucMayCham;
        @BindView(R.id.tvThuongXuyenHocTapRenLuyenMayCham)
        TextView tvThuongXuyenHocTapRenLuyenMayCham;
        @BindView(R.id.tvXayDungCongTacTuanMayCham)
        TextView tvXayDungCongTacTuanMayCham;
        @BindView(R.id.tvChiDaoDIeuHanhKiemSoatMayCham)
        TextView tvChiDaoDIeuHanhKiemSoatMayCham;
        @BindView(R.id.tvKiemTraDonDocViecThucHienMayCham)
        TextView tvKiemTraDonDocViecThucHienMayCham;
        @BindView(R.id.tvCoNangLucQuyTuMayCham)
        TextView tvCoNangLucQuyTuMayCham;
        @BindView(R.id.tvSuDungThanhThaoCacPhanMemMayCham)
        TextView tvSuDungThanhThaoCacPhanMemMayCham;
        @BindView(R.id.tvThietLapHoSoCongViecDayDuMayCham)
        TextView tvThietLapHoSoCongViecDayDuMayCham;
        @BindView(R.id.tvDiemThuongMayCham)
        TextView tvDiemThuongMayCham;
        @BindView(R.id.tvCaNhanCham)
        TextView tvCaNhanCham;
        @BindView(R.id.tvVanPhongDienTuCaNhanCham)
        TextView tvVanPhongDienTuCaNhanCham;
        @BindView(R.id.tvTongDiemCaNhanCham)
        TextView tvTongDiemCaNhanCham;
        @BindView(R.id.tvChapHanhDuongLoiCaNhanCham)
        TextView tvChapHanhDuongLoiCaNhanCham;
        @BindView(R.id.tvKhongHachDichCaNhanCham)
        TextView tvKhongHachDichCaNhanCham;
        @BindView(R.id.tvCoPhamChatChinhTriCaNhanCham)
        TextView tvCoPhamChatChinhTriCaNhanCham;
        @BindView(R.id.tvThucHienVanHoaNoiCongSoCaNhanCham)
        TextView tvThucHienVanHoaNoiCongSoCaNhanCham;
        @BindView(R.id.tvXayDungHinhAnhCaNhanCham)
        TextView tvXayDungHinhAnhCaNhanCham;
        @BindView(R.id.tvSuDungHieuQuaTGLamViecCaNhanCham)
        TextView tvSuDungHieuQuaTGLamViecCaNhanCham;
        @BindView(R.id.tvTongDiemNangLucCaNhanCham)
        TextView tvTongDiemNangLucCaNhanCham;
        @BindView(R.id.tvThuongXuyenHocTapRenLuyenCaNhanCham)
        TextView tvThuongXuyenHocTapRenLuyenCaNhanCham;
        @BindView(R.id.tvXayDungCongTacTuanCaNhanCham)
        TextView tvXayDungCongTacTuanCaNhanCham;
        @BindView(R.id.tvChiDaoDIeuHanhKiemSoatCaNhanCham)
        TextView tvChiDaoDIeuHanhKiemSoatCaNhanCham;
        @BindView(R.id.tvKiemTraDonDocViecThucHienCaNhanCham)
        TextView tvKiemTraDonDocViecThucHienCaNhanCham;
        @BindView(R.id.tvCoNangLucQuyTuCaNhanCham)
        TextView tvCoNangLucQuyTuCaNhanCham;
        @BindView(R.id.tvSuDungThanhThaoCacPhanMemCaNhanCham)
        TextView tvSuDungThanhThaoCacPhanMemCaNhanCham;
        @BindView(R.id.tvThietLapHoSoCongViecDayDuCaNhanCham)
        TextView tvThietLapHoSoCongViecDayDuCaNhanCham;
        @BindView(R.id.tvDiemThuongCaNhanCham)
        TextView tvDiemThuongCaNhanCham;
        @BindView(R.id.tvTruongDonViCham)
        TextView tvTruongDonViCham;
        @BindView(R.id.tvVanPhongDienTuTruongDonViCham)
        TextView tvVanPhongDienTuTruongDonViCham;
        @BindView(R.id.tvTongDiemTruongDonViCham)
        TextView tvTongDiemTruongDonViCham;
        @BindView(R.id.tvChapHanhDuongLoiTruongDonViCham)
        TextView tvChapHanhDuongLoiTruongDonViCham;
        @BindView(R.id.tvKhongHachDichTruongDonViCham)
        TextView tvKhongHachDichTruongDonViCham;
        @BindView(R.id.tvCoPhamChatChinhTriTruongDonViCham)
        TextView tvCoPhamChatChinhTriTruongDonViCham;
        @BindView(R.id.tvThucHienVanHoaNoiCongSoTruongDonViCham)
        TextView tvThucHienVanHoaNoiCongSoTruongDonViCham;
        @BindView(R.id.tvXayDungHinhAnhTruongDonViCham)
        TextView tvXayDungHinhAnhTruongDonViCham;
        @BindView(R.id.tvSuDungHieuQuaTGLamViecTruongDonViCham)
        TextView tvSuDungHieuQuaTGLamViecTruongDonViCham;
        @BindView(R.id.tvTongDiemNangLucTruongDonViCham)
        TextView tvTongDiemNangLucTruongDonViCham;
        @BindView(R.id.tvThuongXuyenHocTapRenLuyenTruongDonViCham)
        TextView tvThuongXuyenHocTapRenLuyenTruongDonViCham;
        @BindView(R.id.tvXayDungCongTacTuanTruongDonViCham)
        TextView tvXayDungCongTacTuanTruongDonViCham;
        @BindView(R.id.tvChiDaoDIeuHanhKiemSoatTruongDonViCham)
        TextView tvChiDaoDIeuHanhKiemSoatTruongDonViCham;
        @BindView(R.id.tvKiemTraDonDocViecThucHienTruongDonViCham)
        TextView tvKiemTraDonDocViecThucHienTruongDonViCham;
        @BindView(R.id.tvCoNangLucQuyTuTruongDonViCham)
        TextView tvCoNangLucQuyTuTruongDonViCham;
        @BindView(R.id.tvSuDungThanhThaoCacPhanMemTruongDonViCham)
        TextView tvSuDungThanhThaoCacPhanMemTruongDonViCham;
        @BindView(R.id.tvThietLapHoSoCongViecDayDuTruongDonViCham)
        TextView tvThietLapHoSoCongViecDayDuTruongDonViCham;
        @BindView(R.id.tvDiemThuongTruongDonViCham)
        TextView tvDiemThuongTruongDonViCham;
        @BindView(R.id.tvNhanXet)
        HtmlTextView tvNhanXet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public interface OnItemClickListener {
        void onItemClickPhongBan(NhanXetChamDiemCongViecTuanCuaCapDuoi nhanXetChamDiemCongViecTuanCuaCapDuoi);
    }
}
