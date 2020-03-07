package com.vpdt.vpdt.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.DetailVanBanDenTongThe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDanhSachCongTacDang extends RecyclerView.Adapter<AdapterDanhSachCongTacDang.ViewHolder> {

    private ArrayList<DetailVanBanDenTongThe> detailVanBanDenTongTheArrayList;
    private Context mContext;
    private OnItemClickListener listener;


    public AdapterDanhSachCongTacDang(Context mContext, ArrayList<DetailVanBanDenTongThe> detailVanBanDenTongTheArrayList, OnItemClickListener listener) {
        this.mContext = mContext;
        this.detailVanBanDenTongTheArrayList = detailVanBanDenTongTheArrayList;
        this.listener = listener;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_xulyvanban5, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        if (detailVanBanDenTongTheArrayList.size() > 0) {
            DetailVanBanDenTongThe dsvb_daChiDao = detailVanBanDenTongTheArrayList.get(position);
            viewHolder.tvSTT.setText(String.valueOf(position + 1));
            viewHolder.tvSKH.setText(String.valueOf(dsvb_daChiDao.getKyhieu()));
            viewHolder.tvsodendo.setText(String.valueOf(dsvb_daChiDao.getSoden()));
            viewHolder.tvnoigui.setText(String.valueOf(dsvb_daChiDao.getNoiGui()));
            viewHolder.tvLoaiVanBan.setText(String.valueOf("Loại văn bản: " + dsvb_daChiDao.getTenlvb()));
            if (dsvb_daChiDao.getTenlvb() == null) {
                viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
            } else {
                if (dsvb_daChiDao.getTenlvb().isEmpty()) {
                    viewHolder.tvLoaiVanBan.setVisibility(View.GONE);
                } else {
                    viewHolder.tvLoaiVanBan.setVisibility(View.VISIBLE);
                }
            }

            viewHolder.tvMoTa.setText(String.valueOf(dsvb_daChiDao.getTrichYeu().getMota1()));
            if (dsvb_daChiDao.getTrichYeu().getMota1() == null) {
                viewHolder.tvMoTa.setVisibility(View.GONE);
            } else {
                if (dsvb_daChiDao.getTrichYeu().getMota1().isEmpty()) {
                    viewHolder.tvMoTa.setVisibility(View.GONE);
                } else {
                    viewHolder.tvMoTa.setVisibility(View.VISIBLE);
                }
            }

            viewHolder.tvNgayNhap.setText(String.valueOf("Ngày nhập: " + dsvb_daChiDao.getNgayNhap()));
            if (dsvb_daChiDao.getNgayNhap() == null) {
                viewHolder.tvNgayNhap.setVisibility(View.GONE);
            } else {
                if (dsvb_daChiDao.getNgayNhap().isEmpty()) {
                    viewHolder.tvNgayNhap.setVisibility(View.GONE);
                } else {
                    viewHolder.tvNgayNhap.setVisibility(View.VISIBLE);
                }
            }

//            if (dsvb_daChiDao.getTrichYeu().get.isEmpty() || dsvb_daChiDao.getHanGiaiQuyet() == null) {
            viewHolder.tvHanXuLy.setVisibility(View.GONE);
//            } else {
//                viewHolder.tvHanXuLy.setText(String.valueOf("Hạn giải quyết: " + dsvb_daChiDao.getHanGiaiQuyet()));
//            }

            viewHolder.tvNguoiNhap.setText(String.valueOf("Người nhập: " + dsvb_daChiDao.getTrichYeu().getNguoinhap()));
            if (dsvb_daChiDao.getTrichYeu().getNguoinhap() == null) {
                viewHolder.tvNguoiNhap.setVisibility(View.GONE);
            } else {
                if (dsvb_daChiDao.getTrichYeu().getNguoinhap().isEmpty()) {
                    viewHolder.tvNguoiNhap.setVisibility(View.GONE);
                } else {
                    viewHolder.tvNguoiNhap.setVisibility(View.VISIBLE);
                }
            }

            viewHolder.tvNoiDung.setText(String.valueOf(dsvb_daChiDao.getTrichYeu().getNoidung()));
            if (dsvb_daChiDao.getTrichYeu().getNoidung() == null) {
                viewHolder.tvNoiDung.setVisibility(View.GONE);
                viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
            } else {
                if (dsvb_daChiDao.getTrichYeu().getNoidung().isEmpty()) {
                    viewHolder.tvNoiDung.setVisibility(View.GONE);
                    viewHolder.tvTieuDeNoiDung.setVisibility(View.GONE);
                } else {
                    viewHolder.tvNoiDung.setVisibility(View.VISIBLE);
                    viewHolder.tvTieuDeNoiDung.setVisibility(View.VISIBLE);
                }
            }

            if (dsvb_daChiDao.getTrichYeu().getSotrang() == null) {
                if (dsvb_daChiDao.getTrichYeu().getGiomoi() == null) {
                    viewHolder.tvSoTrang.setVisibility(View.GONE);
                } else {
                    if (dsvb_daChiDao.getTrichYeu().getGiomoi().isEmpty()) {
                        viewHolder.tvSoTrang.setVisibility(View.GONE);
                    } else {
                        viewHolder.tvSoTrang.setVisibility(View.VISIBLE);
                        viewHolder.tvSoTrang.setText(String.valueOf("(Vào hồi: "
                                + dsvb_daChiDao.getTrichYeu().getGiomoi() + " ngày " + dsvb_daChiDao.getTrichYeu().getNgaymoi() + ", tại "
                                + dsvb_daChiDao.getTrichYeu().getDiadiemMoi() + ") "+dsvb_daChiDao.getTrichYeu().getMota2()));
                    }
                }
            } else {
                if (dsvb_daChiDao.getTrichYeu().getSotrang().toString().isEmpty()) {
                    if (dsvb_daChiDao.getTrichYeu().getGiomoi() == null) {
                        viewHolder.tvSoTrang.setVisibility(View.GONE);
                    } else {
                        if (dsvb_daChiDao.getTrichYeu().getGiomoi().isEmpty()) {
                            viewHolder.tvSoTrang.setVisibility(View.GONE);
                        } else {
                            viewHolder.tvSoTrang.setVisibility(View.VISIBLE);
                            viewHolder.tvSoTrang.setText(String.valueOf("(Vào hồi: "
                                    + dsvb_daChiDao.getTrichYeu().getGiomoi() + " ngày " + dsvb_daChiDao.getTrichYeu().getNgaymoi() + ", tại "
                                    + dsvb_daChiDao.getTrichYeu().getDiadiemMoi() + ") "+dsvb_daChiDao.getTrichYeu().getMota2()));
                        }
                    }
                } else {
                    if (dsvb_daChiDao.getTrichYeu().getGiomoi() == null) {
                        viewHolder.tvSoTrang.setVisibility(View.VISIBLE);
                        viewHolder.tvSoTrang.setText(String.valueOf("(Số trang: " + dsvb_daChiDao.getTrichYeu().getSotrang() + ") "+dsvb_daChiDao.getTrichYeu().getMota2()));
                    } else {
                        if (dsvb_daChiDao.getTrichYeu().getGiomoi().isEmpty()) {
                            viewHolder.tvSoTrang.setVisibility(View.VISIBLE);
                            viewHolder.tvSoTrang.setText(String.valueOf("(Số trang: " + dsvb_daChiDao.getTrichYeu().getSotrang() + ") "+dsvb_daChiDao.getTrichYeu().getMota2()));
                        } else {
                            viewHolder.tvSoTrang.setVisibility(View.VISIBLE);
                            viewHolder.tvSoTrang.setText(String.valueOf("(Số trang: " + dsvb_daChiDao.getTrichYeu().getSotrang() + ") | (Vào hồi: "
                                    + dsvb_daChiDao.getTrichYeu().getGiomoi() + " ngày " + dsvb_daChiDao.getTrichYeu().getNgaymoi() + ", tại "
                                    + dsvb_daChiDao.getTrichYeu().getDiadiemMoi() + ") " +dsvb_daChiDao.getTrichYeu().getMota2()));
                        }
                    }
                }
            }

            viewHolder.btnXemFile.setVisibility(View.GONE);
            viewHolder.btnXemFile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        if (detailVanBanDenTongTheArrayList.size() > 0) {
                            listener.onItemClickXemFile(detailVanBanDenTongTheArrayList.get(position));
                        }
                    }
                }
            });
            viewHolder.btnXuLy.setVisibility(View.GONE);
            viewHolder.btnXuLy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        if (detailVanBanDenTongTheArrayList.size() > 0) {
                            listener.onItemClickXuLy(detailVanBanDenTongTheArrayList.get(position));
                        }
                    }
                }
            });
            viewHolder.btnXemChiTiet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        if (detailVanBanDenTongTheArrayList.size() > 0) {
                            listener.onItemClickXemChiTiet(detailVanBanDenTongTheArrayList.get(position));
                        }
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return detailVanBanDenTongTheArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvSTT)
        TextView tvSTT;
        @BindView(R.id.tvSKH)
        TextView tvSKH;
        @BindView(R.id.tvsodendo)
        TextView tvsodendo;
        @BindView(R.id.tvnoigui)
        TextView tvnoigui;
        @BindView(R.id.tvLoaiVanBan)
        TextView tvLoaiVanBan;
        @BindView(R.id.tvMoTa)
        TextView tvMoTa;
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
        void onItemClickXemFile(DetailVanBanDenTongThe detailVanBanDenTongThe);

        void onItemClickXuLy(DetailVanBanDenTongThe detailVanBanDenTongThe);

        void onItemClickXemChiTiet(DetailVanBanDenTongThe detailVanBanDenTongThe);
    }
}
