package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.TraoDoiThongTinNoiBo;

import org.sufficientlysecure.htmltextview.HtmlAssetsImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterThongTinMoi extends RecyclerView.Adapter<AdapterThongTinMoi.ViewHolder> {
    private ArrayList<TraoDoiThongTinNoiBo> traoDoiThongTinNoiBoArrayList;
    private Context mContext;
    private OnItemClickListener listener;


    public AdapterThongTinMoi(Context mContext, ArrayList<TraoDoiThongTinNoiBo> traoDoiThongTinNoiBoArrayList, OnItemClickListener listener) {
        this.mContext = mContext;
        this.traoDoiThongTinNoiBoArrayList = traoDoiThongTinNoiBoArrayList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_traodoittnoibo3, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        TraoDoiThongTinNoiBo giaHanGiaiQuyet = traoDoiThongTinNoiBoArrayList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.textView6s.setText("NƠI GỬI");
        viewHolder.tvSKH.setText(String.valueOf(giaHanGiaiQuyet.getNoiGui()));
        viewHolder.tvnoigui.setText(String.valueOf(giaHanGiaiQuyet.getThoiGian()));
//        if (giaHanGiaiQuyet.get().isEmpty() || giaHanGiaiQuyet.getLoaiVanban() == null) {
        viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvLoaiVanBan.setText(String.valueOf("Loại văn bản: " + giaHanGiaiQuyet.getLoaiVanban()));
//        }

        viewHolder.tvMoTa.setHtml(giaHanGiaiQuyet.getNoiDung(), new HtmlAssetsImageGetter(viewHolder.tvMoTa));
        if (giaHanGiaiQuyet.getNoiDung() == null) {
            viewHolder.tvMoTa.setVisibility(View.GONE);
        } else {
            if (giaHanGiaiQuyet.getNoiDung().isEmpty()) {
                viewHolder.tvMoTa.setVisibility(View.GONE);
            } else {
                viewHolder.tvMoTa.setVisibility(View.VISIBLE);
            }
        }

//        if (giaHanGiaiQuyet.get().isEmpty() || giaHanGiaiQuyet.getNgaythang() == null) {
        viewHolder.tvNgayNhap.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvNgayNhap.setText(String.valueOf("Ngày nhập: " + giaHanGiaiQuyet.getNgaythang()));
//        }

//        if (giaHanGiaiQuyet.getHanGiaiQuyet().isEmpty() || giaHanGiaiQuyet.getHanGiaiQuyet() == null) {
        viewHolder.tvHanXuLy.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvHanXuLy.setText(String.valueOf("Hạn giải quyết: " + giaHanGiaiQuyet.getHanGiaiQuyet()));
//        }

//        if (giaHanGiaiQuyet.getNguoiky().isEmpty() || giaHanGiaiQuyet.getNguoiky() == null) {
        viewHolder.tvNguoiNhap.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvNguoiNhap.setText(String.valueOf("Người ký: " + giaHanGiaiQuyet.getNguoiky()));
//        }

//        if (giaHanGiaiQuyet.getn().isEmpty() || giaHanGiaiQuyet.getNoiDung() == null) {
        viewHolder.tvNoiDung.setVisibility(View.GONE);
        viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
//        } else {
//            viewHolder.tvNoiDung.setText(String.valueOf(giaHanGiaiQuyet.getNoiDung()));
//        }

//        if (giaHanGiaiQuyet.getSoTrang().isEmpty() || giaHanGiaiQuyet.getSoTrang() == null) {
//            if (giaHanGiaiQuyet.getGiayMoiGio().isEmpty() || giaHanGiaiQuyet.getGiayMoiGio() == null) {
        viewHolder.tvSoTrang.setVisibility(View.GONE);
//            } else {
//                viewHolder.tvSoTrang.setText(String.valueOf("(Vào hồi: "
//                        + giaHanGiaiQuyet.getGiayMoiGio() + " ngày " + giaHanGiaiQuyet.getGiayMoiNgay() + ", tại "
//                        + giaHanGiaiQuyet.getGiayMoiDiaDiem() + ")"));
//            }
//        } else {
//            if (giaHanGiaiQuyet.getGiayMoiGio().isEmpty() || giaHanGiaiQuyet.getGiayMoiGio() == null) {
//                viewHolder.tvSoTrang.setText(String.valueOf("(Số trang: " + giaHanGiaiQuyet.getSoTrang() + ")"));
//            } else {
//                viewHolder.tvSoTrang.setText(String.valueOf("(Số trang: " + giaHanGiaiQuyet.getSoTrang() + ") | (Vào hồi: "
//                        + giaHanGiaiQuyet.getGiayMoiGio() + " ngày " + giaHanGiaiQuyet.getGiayMoiNgay() + ", tại "
//                        + giaHanGiaiQuyet.getGiayMoiDiaDiem() + ")"));
//            }
//        }
        viewHolder.btnXemFile.setVisibility(View.GONE);
        viewHolder.btnXemFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (traoDoiThongTinNoiBoArrayList.size() > 0) {
                        listener.onItemClickXemFile(traoDoiThongTinNoiBoArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXuLy.setVisibility(View.GONE);
        viewHolder.btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (traoDoiThongTinNoiBoArrayList.size() > 0) {
                        listener.onItemClickXuLy(traoDoiThongTinNoiBoArrayList.get(position));
                    }
                }
            }
        });
        viewHolder.btnXemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (traoDoiThongTinNoiBoArrayList.size() > 0) {
                        listener.onItemClickXemChiTiet(traoDoiThongTinNoiBoArrayList.get(position));
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return traoDoiThongTinNoiBoArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvSTT)
        TextView tvSTT;
        @BindView(R.id.tvSKH)
        TextView tvSKH;
        @BindView(R.id.tvnoigui)
        TextView tvnoigui;
        @BindView(R.id.tvLoaiVanBan)
        TextView tvLoaiVanBan;
        @BindView(R.id.tvMoTa)
        HtmlTextView tvMoTa;
        @BindView(R.id.tvSoTrang)
        TextView tvSoTrang;
        @BindView(R.id.tvNguoiNhap)
        TextView tvNguoiNhap;
        @BindView(R.id.tvTieuDeNoiDung)
        TextView tvTieuDeNoiDung;
        @BindView(R.id.tvNoiDung)
        TextView tvNoiDung;
        @BindView(R.id.tvNgayNhap)
        TextView tvNgayNhap;
        @BindView(R.id.tvHanXuLy)
        TextView tvHanXuLy;
        @BindView(R.id.textView6s)
        TextView textView6s;

        @BindView(R.id.btnXemFile)
        Button btnXemFile;
        @BindView(R.id.btnXuLy)
        Button btnXuLy;
        @BindView(R.id.btnXemChiTiet)
        Button btnXemChiTiet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

    public interface OnItemClickListener {
        void onItemClickXemFile(TraoDoiThongTinNoiBo traoDoiThongTinNoiBo);

        void onItemClickXuLy(TraoDoiThongTinNoiBo traoDoiThongTinNoiBo);

        void onItemClickXemChiTiet(TraoDoiThongTinNoiBo traoDoiThongTinNoiBo);
    }
}
