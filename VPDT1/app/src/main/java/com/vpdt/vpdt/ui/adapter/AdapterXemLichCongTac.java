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
import com.vpdt.vpdt.model.LichCongTac;
import com.vpdt.vpdt.model.SangLichcongtac;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterXemLichCongTac extends RecyclerView.Adapter<AdapterXemLichCongTac.ViewHolder> implements AdapterSubXemLichCongTac.OnItemClickXemFileListener {
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private ArrayList<LichCongTac> itemLichHopArrayList;
    ArrayList<Integer> counter = new ArrayList<Integer>();
    private Context mContext;

    int itemSang;
    int itemChieu;

    public AdapterXemLichCongTac(Context mContext, ArrayList<LichCongTac> itemLichHopArrayList) {
        this.mContext = mContext;
        this.itemLichHopArrayList = itemLichHopArrayList;

        for (int i = 0; i < itemLichHopArrayList.size(); i++) {
            counter.add(0);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_xem_lich_cong_tac, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        LichCongTac itemLichHop = itemLichHopArrayList.get(position);
        itemSang = itemLichHop.getSangLichcongtac().size();
        itemChieu = itemLichHop.getChieuLichcongtac().size();
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
        layoutManager.setInitialPrefetchItemCount(itemLichHop.getSangLichcongtac().size());

        // Create sub item view adapter
        AdapterSubXemLichCongTac adapterSubXemLichCongTac = new AdapterSubXemLichCongTac((ArrayList<SangLichcongtac>) itemLichHop.getSangLichcongtac(), this);

        viewHolder.rcvSang.setLayoutManager(layoutManager);
        viewHolder.rcvSang.setAdapter(adapterSubXemLichCongTac);
        viewHolder.rcvSang.setRecycledViewPool(viewPool);


        // Create layout manager with initial prefetch item count
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(
                viewHolder.rcvChieu.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager1.setInitialPrefetchItemCount(itemLichHop.getSangLichcongtac().size());
        AdapterSubXemLichCongTac adapterSubXemLichCongTac1 = new AdapterSubXemLichCongTac((ArrayList<SangLichcongtac>) itemLichHop.getChieuLichcongtac(), this);
        // Create sub item view adapter

        viewHolder.rcvChieu.setLayoutManager(layoutManager1);
        viewHolder.rcvChieu.setAdapter(adapterSubXemLichCongTac1);
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
    public void onItemXemFileClick(SangLichcongtac sangLichcongtac) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(sangLichcongtac.getDuongdan()));
            mContext.startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(mContext, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSoanBaoCaoClick(SangLichcongtac sangLichcongtac) {
        Util.showMessenger("chức năng đang hoàn thiện", mContext);
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
