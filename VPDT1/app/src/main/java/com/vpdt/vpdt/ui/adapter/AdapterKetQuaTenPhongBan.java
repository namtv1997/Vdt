package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.ThongKeLanhDaoChiDaoTheoPhong;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterKetQuaTenPhongBan extends RecyclerView.Adapter<AdapterKetQuaTenPhongBan.ViewHolder> {
    private ArrayList<ThongKeLanhDaoChiDaoTheoPhong> listTenGiamDoc;
    private Context mContext;
    private OnItemClickListenerKetQuaTenPhongBan listener;

    public AdapterKetQuaTenPhongBan(Context context, ArrayList<ThongKeLanhDaoChiDaoTheoPhong> listTenGiamDoc, OnItemClickListenerKetQuaTenPhongBan listener) {
        this.mContext = context;
        this.listTenGiamDoc = listTenGiamDoc;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thongke_theo_lanh_dao_chi_dao, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ThongKeLanhDaoChiDaoTheoPhong giamdocVaPhoGiamdoc = listTenGiamDoc.get(position);
        viewHolder.tvStt.setText(String.valueOf(position + 1));
        viewHolder.tvGiamdoc.setText(String.valueOf(giamdocVaPhoGiamdoc.getPhongBan()));
        viewHolder.tvSoluong.setText(String.valueOf(giamdocVaPhoGiamdoc.getSolgVB()));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickKetQuaTenPhongBan(listTenGiamDoc.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTenGiamDoc.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvStt)
        TextView tvStt;
        @BindView(R.id.tvGiamdoc)
        TextView tvGiamdoc;
        @BindView(R.id.tvSoluong)
        TextView tvSoluong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    public interface OnItemClickListenerKetQuaTenPhongBan {
        void onItemClickKetQuaTenPhongBan(ThongKeLanhDaoChiDaoTheoPhong thongKeLanhDaoChiDao);
    }
}
