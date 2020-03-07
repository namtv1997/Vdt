package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.ItemLichHop;
import com.vpdt.vpdt.model.ItemmoreSang;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterLichHopSoChuTri extends RecyclerView.Adapter<AdapterLichHopSoChuTri.ViewHolder> implements AdapterSubLichHopSoChuTri.OnItemClickListener {
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private ArrayList<ItemLichHop> itemLichHopArrayList;
    ArrayList<Integer> counter = new ArrayList<Integer>();
    private Context mContext;

    int itemSang;
    int itemChieu;


    public AdapterLichHopSoChuTri(Context mContext, ArrayList<ItemLichHop> itemLichHopArrayList) {
        this.mContext = mContext;
        this.itemLichHopArrayList = itemLichHopArrayList;

        for (int i = 0; i < itemLichHopArrayList.size(); i++) {
            counter.add(0);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_thu_lich_hop_so_chu_tri, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ItemLichHop itemLichHop = itemLichHopArrayList.get(position);
        itemSang = itemLichHop.getItemmoreSangs().size();
        itemChieu = itemLichHop.getItemmoreChieus().size();
        viewHolder.tvThu_Ngay.setText(itemLichHop.getThu() + "-" + itemLichHop.getNgay());
        if (itemSang + itemChieu > 0) {
            viewHolder.tvNotifi.setText(String.valueOf(itemSang + itemChieu));
            viewHolder.tvNotifi.setVisibility(View.VISIBLE);
        }

        // Create layout manager with initial prefetch item count
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                viewHolder.rcvSang.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager.setInitialPrefetchItemCount(itemLichHop.getItemmoreSangs().size());

        // Create sub item view adapter
        AdapterSubLichHopSoChuTri adapterSubLichHopSoChuTri = new AdapterSubLichHopSoChuTri((ArrayList<ItemmoreSang>) itemLichHop.getItemmoreSangs(), this::onItemClick);

        viewHolder.rcvSang.setLayoutManager(layoutManager);
        viewHolder.rcvSang.setAdapter(adapterSubLichHopSoChuTri);
        viewHolder.rcvSang.setRecycledViewPool(viewPool);


        // Create layout manager with initial prefetch item count
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(
                viewHolder.rcvChieu.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager1.setInitialPrefetchItemCount(itemLichHop.getItemmoreSangs().size());

        // Create sub item view adapter
        AdapterSubLichHopSoChuTri adapterSubLichHopSoChuTri1 = new AdapterSubLichHopSoChuTri((ArrayList<ItemmoreSang>) itemLichHop.getItemmoreChieus(), this::onItemClick);

        viewHolder.rcvChieu.setLayoutManager(layoutManager1);
        viewHolder.rcvChieu.setAdapter(adapterSubLichHopSoChuTri1);
        viewHolder.rcvChieu.setRecycledViewPool(viewPool);

        viewHolder.tvThu_Ngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter.get(position) % 2 == 0) {
                    viewHolder.lnThu_Ngay.setVisibility(View.VISIBLE);
                } else {
                    viewHolder.lnThu_Ngay.setVisibility(View.GONE);
                }

                counter.set(position, counter.get(position) + 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemLichHopArrayList.size();
    }

    @Override
    public void onItemClick(ItemmoreSang itemmoreSang) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(itemmoreSang.getDuongdanfile()));
            mContext.startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(mContext, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvThu_Ngay)
        TextView tvThu_Ngay;
        @BindView(R.id.tvNotifi)
        TextView tvNotifi;

        @BindView(R.id.lnThu_Ngay)
        LinearLayout lnThu_Ngay;
        @BindView(R.id.rcvSang)
        RecyclerView rcvSang;
        @BindView(R.id.rcvChieu)
        RecyclerView rcvChieu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
