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
import com.vpdt.vpdt.model.DauViecChoXuLy;
import com.vpdt.vpdt.model.Item;
import com.vpdt.vpdt.ui.activity.QuanLyDauViec.NDVBDauViecDaXuLyActivity;
import com.vpdt.vpdt.ui.activity.QuanLyDauViec.TTVBDauViecChoXuLyActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDauViecDaXuLy extends RecyclerView.Adapter<AdapterDauViecDaXuLy.ViewHolder> implements AdapterDauViecDaXuLySub.OnItemClickListener {
    private ArrayList<DauViecChoXuLy> danhSachDauViecPhongPhoiHopArrayList;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private Context mContext;
    OnItemXemFileClickListener listener;


    public AdapterDauViecDaXuLy(Context mContext, ArrayList<DauViecChoXuLy> danhSachDauViecPhongPhoiHopArrayList, OnItemXemFileClickListener listener) {
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
        DauViecChoXuLy danhSachDauViecPhongPhoiHop = danhSachDauViecPhongPhoiHopArrayList.get(position);
        viewHolder.tvSTT.setText(String.valueOf(position + 1));
        viewHolder.tvContent.setText(String.valueOf(danhSachDauViecPhongPhoiHop.getNoiDung()));
        if (!danhSachDauViecPhongPhoiHop.getFile().isEmpty()) {
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
        AdapterDauViecDaXuLySub adapterDanhSachDauViecPhongPhoiHop1 = new AdapterDauViecDaXuLySub((ArrayList<Item>) danhSachDauViecPhongPhoiHop.getItems(), this);

        viewHolder.recyclerview1.setLayoutManager(layoutManager);
        viewHolder.recyclerview1.setAdapter(adapterDanhSachDauViecPhongPhoiHop1);
        viewHolder.recyclerview1.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return danhSachDauViecPhongPhoiHopArrayList.size();
    }

    @Override
    public void onItemClickXemFile(Item item) {

    }

    @Override
    public void onItemClickXuLy(Item item) {
        Intent i = new Intent(mContext, NDVBDauViecDaXuLyActivity.class);
        i.putExtra("item", item);
        mContext.startActivity(i);
    }

    @Override
    public void onItemClickXemChiTiet(Item item) {
        Intent intent = new Intent(mContext, TTVBDauViecChoXuLyActivity.class);
        intent.putExtra("DauViecChoXuLy", item.getId());
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
        void onItemClickXemFile(DauViecChoXuLy dauViecChoXuLy);
    }
}
