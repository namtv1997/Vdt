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
import com.vpdt.vpdt.model.ItemThang;
import com.vpdt.vpdt.model.ThongKeKetQuaCongTacThang;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterThongKeKetQuaCongTacThang1 extends RecyclerView.Adapter<AdapterThongKeKetQuaCongTacThang1.ViewHolder> {
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private ArrayList<ThongKeKetQuaCongTacThang> thongKeKetQuaCongTacThangArrayList;
    private Context mContext;
//    private AdapterTuan.OnItemClickListener listener;

    public AdapterThongKeKetQuaCongTacThang1(Context context, ArrayList<ThongKeKetQuaCongTacThang> thongKeKetQuaCongTacThangArrayList) {
        this.mContext = context;
        this.thongKeKetQuaCongTacThangArrayList = thongKeKetQuaCongTacThangArrayList;
//        this.listener=listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_thongkeketquacongtacthang1, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ThongKeKetQuaCongTacThang itemThang = thongKeKetQuaCongTacThangArrayList.get(position);

        viewHolder.tvRCVSTT.setText(String.valueOf(position + 1));

        viewHolder.tvRCVName.setText(String.valueOf(itemThang.getName()));

        // Create layout manager with initial prefetch item count
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                viewHolder.recyclerview.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager.setInitialPrefetchItemCount(itemThang.getItemMores().size());

        // Create sub item view adapter
        AdapterThongKeKetQuaCongTacThang adapterThongKeKetQuaCongTacThang = new AdapterThongKeKetQuaCongTacThang((ArrayList<ItemThang>) itemThang.getItemMores());

        viewHolder.recyclerview.setLayoutManager(layoutManager);
        viewHolder.recyclerview.setAdapter(adapterThongKeKetQuaCongTacThang);
        viewHolder.recyclerview.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return thongKeKetQuaCongTacThangArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvRCVSTT)
        TextView tvRCVSTT;
        @BindView(R.id.tvRCVName)
        TextView tvRCVName;
        @BindView(R.id.recyclerview)
        RecyclerView recyclerview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }
}
