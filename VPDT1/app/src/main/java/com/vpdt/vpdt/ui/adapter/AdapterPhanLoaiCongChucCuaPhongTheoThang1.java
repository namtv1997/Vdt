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
import com.vpdt.vpdt.model.Chitiet;
import com.vpdt.vpdt.model.PhanLoaiCongChucCuaPhongTheoThang;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterPhanLoaiCongChucCuaPhongTheoThang1 extends RecyclerView.Adapter<AdapterPhanLoaiCongChucCuaPhongTheoThang1.ViewHolder> {
    private ArrayList<PhanLoaiCongChucCuaPhongTheoThang> phanLoaiCongChucCuaPhongTheoThangs;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    Context context;

    public AdapterPhanLoaiCongChucCuaPhongTheoThang1(Context context, ArrayList<PhanLoaiCongChucCuaPhongTheoThang> phanLoaiCongChucCuaPhongTheoThangs) {
        this.phanLoaiCongChucCuaPhongTheoThangs = phanLoaiCongChucCuaPhongTheoThangs;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_phanloaicongchuccuaphongtheothang1, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        PhanLoaiCongChucCuaPhongTheoThang baoCaoTongHop = phanLoaiCongChucCuaPhongTheoThangs.get(position);
        viewHolder.tvRCVName.setText(String.valueOf(baoCaoTongHop.getName()));
        viewHolder.tvRCVSTT.setText(String.valueOf(position + 1));
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                viewHolder.recyclerview.getContext(),
                LinearLayoutManager.VERTICAL,
                false);
        layoutManager.setInitialPrefetchItemCount(baoCaoTongHop.getChitiet().size());

        // Create sub item view adapter
        AdapterPhanLoaiCongChucCuaPhongTheoThang2 adapterPhanLoaiCongChucCuaPhongTheoThang2 = new AdapterPhanLoaiCongChucCuaPhongTheoThang2((ArrayList<Chitiet>) baoCaoTongHop.getChitiet());

        viewHolder.recyclerview.setLayoutManager(layoutManager);
        viewHolder.recyclerview.setAdapter(adapterPhanLoaiCongChucCuaPhongTheoThang2);
        viewHolder.recyclerview.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return phanLoaiCongChucCuaPhongTheoThangs.size();
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
