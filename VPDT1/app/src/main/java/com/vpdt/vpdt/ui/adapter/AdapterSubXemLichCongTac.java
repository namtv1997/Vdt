package com.vpdt.vpdt.ui.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.Chidao;
import com.vpdt.vpdt.model.SangLichcongtac;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterSubXemLichCongTac extends RecyclerView.Adapter<AdapterSubXemLichCongTac.ViewHolder> {
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private ArrayList<SangLichcongtac> itemmoreSangArrayList;
    OnItemClickXemFileListener listener;

    public AdapterSubXemLichCongTac(ArrayList<SangLichcongtac> itemmoreSangArrayList, OnItemClickXemFileListener listener) {

        this.itemmoreSangArrayList = itemmoreSangArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sang_chieu, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {

        SangLichcongtac itemmoreSang = itemmoreSangArrayList.get(position);
        viewHolder.tvThoiGian.setText(String.valueOf(itemmoreSang.getGioHop()));
        viewHolder.tvdonvi.setText(String.valueOf(itemmoreSang.getDonvi()));
        viewHolder.tvlanhdao.setText(String.valueOf(itemmoreSang.getLanhdao()));
        viewHolder.tvGMso.setText("GM số: " + itemmoreSang.getGMso());
        viewHolder.tvmota.setText(String.valueOf(itemmoreSang.getMota()));
        viewHolder.tvNoiDung.setText(String.valueOf(itemmoreSang.getNoiDung()));
        if (itemmoreSang.getGhichu() != null) {

            viewHolder.tvghichu.setText(String.valueOf(itemmoreSang.getGhichu()));
        }
        viewHolder.tvdiadiem_hop.setText("Địa điểm: " + itemmoreSang.getDiadiemHop());
        viewHolder.tvphong_phoihop.setText("Phòng phối hợp: " + itemmoreSang.getPhongPhoihop());

        viewHolder.tvduongdan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemXemFileClick(itemmoreSangArrayList.get(position));
                }
            }
        });
        viewHolder.tvSoanBaoCao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemSoanBaoCaoClick(itemmoreSangArrayList.get(position));
                }
            }
        });

        // Create layout manager with initial prefetch item count
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(
                viewHolder.rcvChiDaotruocCuocHop.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager1.setInitialPrefetchItemCount(itemmoreSang.getChidaoS().size());
        AdapterChiDaoTruocCuocHop adapterSubXemLichCongTac1 = new AdapterChiDaoTruocCuocHop((ArrayList<Chidao>) itemmoreSang.getChidaoS());
        // Create sub item view adapter

        viewHolder.rcvChiDaotruocCuocHop.setLayoutManager(layoutManager1);
        viewHolder.rcvChiDaotruocCuocHop.setAdapter(adapterSubXemLichCongTac1);
        viewHolder.rcvChiDaotruocCuocHop.setRecycledViewPool(viewPool);

    }

    @Override
    public int getItemCount() {
        return itemmoreSangArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvThoiGian)
        TextView tvThoiGian;
        @BindView(R.id.tvdonvi)
        TextView tvdonvi;
        @BindView(R.id.tvGMso)
        TextView tvGMso;
        @BindView(R.id.tvmota)
        TextView tvmota;
        @BindView(R.id.tvNoiDung)
        TextView tvNoiDung;
        @BindView(R.id.tvghichu)
        TextView tvghichu;
        @BindView(R.id.tvdiadiem_hop)
        TextView tvdiadiem_hop;
        @BindView(R.id.tvduongdan)
        TextView tvduongdan;
        @BindView(R.id.tvphong_phoihop)
        TextView tvphong_phoihop;
        @BindView(R.id.tvSoanBaoCao)
        TextView tvSoanBaoCao;
        @BindView(R.id.tvlanhdao)
        TextView tvlanhdao;

        @BindView(R.id.rcvChiDaotruocCuocHop)
        RecyclerView rcvChiDaotruocCuocHop;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public interface OnItemClickXemFileListener {
        void onItemXemFileClick(SangLichcongtac sangLichcongtac);

        void onItemSoanBaoCaoClick(SangLichcongtac sangLichcongtac);
    }
}
