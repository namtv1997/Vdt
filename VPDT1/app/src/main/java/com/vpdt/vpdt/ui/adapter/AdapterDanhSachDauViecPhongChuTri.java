package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.DanhSachDauViecPhongPhoiHop;
import com.vpdt.vpdt.model.ItemDauViec;
import com.vpdt.vpdt.ui.activity.QuanLyDauViec.NDVBDanhSachDauViecPhongChuTriActivity;
import com.vpdt.vpdt.ui.activity.QuanLyDauViec.TTVBDauViecChoXuLyActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDanhSachDauViecPhongChuTri extends RecyclerView.Adapter<AdapterDanhSachDauViecPhongChuTri.ViewHolder> implements
        AdapterDanhSachDauViecPhongChuTri1.OnItemClickListener {
    private ArrayList<DanhSachDauViecPhongPhoiHop> danhSachDauViecPhongPhoiHopArrayList;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private Context mContext;
    OnItemXemFileClickListener listener;


    public AdapterDanhSachDauViecPhongChuTri(Context mContext, ArrayList<DanhSachDauViecPhongPhoiHop> danhSachDauViecPhongPhoiHopArrayList, OnItemXemFileClickListener listener) {
        this.mContext = mContext;
        this.danhSachDauViecPhongPhoiHopArrayList = danhSachDauViecPhongPhoiHopArrayList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_to, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        DanhSachDauViecPhongPhoiHop danhSachDauViecPhongPhoiHop = danhSachDauViecPhongPhoiHopArrayList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvContent.setText(String.valueOf(danhSachDauViecPhongPhoiHop.getNoiDung()));
        if (!danhSachDauViecPhongPhoiHop.getUrlFile().isEmpty()) {
            viewHolder.tvXemFile.setVisibility(View.VISIBLE);
        }
        viewHolder.tvXemFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickXemFile(danhSachDauViecPhongPhoiHopArrayList.get(position));
                }
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                viewHolder.recyclerview1.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager.setInitialPrefetchItemCount(danhSachDauViecPhongPhoiHop.getItems().size());

        // Create sub item view adapter
        AdapterDanhSachDauViecPhongChuTri1 adapterDanhSachDauViecPhongPhoiHop1 = new AdapterDanhSachDauViecPhongChuTri1(mContext, (ArrayList<ItemDauViec>) danhSachDauViecPhongPhoiHop.getItems(), this);

        viewHolder.recyclerview1.setLayoutManager(layoutManager);
        viewHolder.recyclerview1.setAdapter(adapterDanhSachDauViecPhongPhoiHop1);
        viewHolder.recyclerview1.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return danhSachDauViecPhongPhoiHopArrayList.size();
    }

    @Override
    public void onItemClickXemFile(ItemDauViec itemDauViec) {

    }

    @Override
    public void onItemClickXuLy(ItemDauViec itemDauViec) {
        Intent intent = new Intent(mContext, NDVBDanhSachDauViecPhongChuTriActivity.class);
        intent.putExtra("itemDauViecChuTri", itemDauViec);
        mContext.startActivity(intent);
    }

    @Override
    public void onItemClickXemChiTiet(ItemDauViec itemDauViec) {
        Intent intent = new Intent(mContext, TTVBDauViecChoXuLyActivity.class);
        intent.putExtra("DauViecChoXuLy", itemDauViec.getId());
        mContext.startActivity(intent);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvStt)
        TextView tvSTT;
        @BindView(R.id.tvContent)
        TextView tvContent;
        @BindView(R.id.tvXemFile)
        TextView tvXemFile;
        @BindView(R.id.recyclerview1)
        RecyclerView recyclerview1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public interface OnItemXemFileClickListener {
        void onItemClickXemFile(DanhSachDauViecPhongPhoiHop danhSachDauViecPhongPhoiHop);
    }
}
