package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.BaoCaoTongHop;
import com.vpdt.vpdt.model.PhongbanBaoCaoTongHop;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterBaoCaoTongHop1 extends RecyclerView.Adapter<AdapterBaoCaoTongHop1.ViewHolder> {
    private ArrayList<BaoCaoTongHop> baoCaoTongHopArrayList;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    Context context;

    public AdapterBaoCaoTongHop1(Context context, ArrayList<BaoCaoTongHop> baoCaoTongHopArrayList) {
        this.baoCaoTongHopArrayList = baoCaoTongHopArrayList;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_bao_cao_tong_hop1, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        BaoCaoTongHop baoCaoTongHop = baoCaoTongHopArrayList.get(position);
        viewHolder.tvTen.setText(String.valueOf(baoCaoTongHop.getName()));
//        viewHolder.tvQuaHanChuaGiaiQuyet.setText(String.valueOf(dsvb_quaHan.getCgqQuaHan()));
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                viewHolder.rcv1.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager.setInitialPrefetchItemCount(baoCaoTongHop.getPhongban().size());

        // Create sub item view adapter
        AdapterBaoCaoTongHop2 adapterBaoCaoTongHop2 = new AdapterBaoCaoTongHop2(context, (ArrayList<PhongbanBaoCaoTongHop>) baoCaoTongHop.getPhongban());

        viewHolder.rcv1.setLayoutManager(layoutManager);
        viewHolder.rcv1.setAdapter(adapterBaoCaoTongHop2);
        viewHolder.rcv1.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return baoCaoTongHopArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tvTen)
        TextView tvTen;
        @BindView(R.id.rcv1)
        RecyclerView rcv1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
