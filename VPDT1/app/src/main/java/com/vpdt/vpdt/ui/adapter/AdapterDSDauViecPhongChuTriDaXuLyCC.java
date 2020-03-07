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

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.DSDauViecPhongChuTriDaXuLyCC;
import com.vpdt.vpdt.model.ItemDSDauViecPhongChuTriDaXuLyCC;
import com.vpdt.vpdt.ui.activity.QuanLyDauViec.NDVBDSDauViecPhongChuTriDaXuLyCCActivity;
import com.vpdt.vpdt.ui.activity.QuanLyDauViec.TTVBDauViecChoXuLyActivity;
import com.vpdt.vpdt.util.PrefUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDSDauViecPhongChuTriDaXuLyCC extends RecyclerView.Adapter<AdapterDSDauViecPhongChuTriDaXuLyCC.ViewHolder> implements AdapterDSDauViecPhongChuTriDaXuLyCC1.OnItemClickListener {
    private ArrayList<DSDauViecPhongChuTriDaXuLyCC> baoCaoTongHopArrayList;
    OnItemXemFileClickListener listener;
    int level;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    Context context;

    public AdapterDSDauViecPhongChuTriDaXuLyCC(Context context, ArrayList<DSDauViecPhongChuTriDaXuLyCC> baoCaoTongHopArrayList, OnItemXemFileClickListener listener) {
        this.baoCaoTongHopArrayList = baoCaoTongHopArrayList;
        this.context = context;
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
        DSDauViecPhongChuTriDaXuLyCC baoCaoTongHop = baoCaoTongHopArrayList.get(position);
        viewHolder.tvStt.setText(String.valueOf(position + 1));
        viewHolder.tvContent.setText(String.valueOf(baoCaoTongHop.getNoiDung()));
        if (!baoCaoTongHop.getUrlFile().isEmpty()) {
            viewHolder.tvXemFile.setVisibility(View.VISIBLE);
        }
        viewHolder.tvXemFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickXemFile(baoCaoTongHopArrayList.get(position));
                }
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                viewHolder.recyclerview1.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager.setInitialPrefetchItemCount(baoCaoTongHop.getItems().size());

        // Create sub item view adapter
        AdapterDSDauViecPhongChuTriDaXuLyCC1 adapterDauViecQuaHanCuaPhong = new AdapterDSDauViecPhongChuTriDaXuLyCC1((ArrayList<ItemDSDauViecPhongChuTriDaXuLyCC>) baoCaoTongHop.getItems(), this);

        viewHolder.recyclerview1.setLayoutManager(layoutManager);
        viewHolder.recyclerview1.setAdapter(adapterDauViecQuaHanCuaPhong);
        viewHolder.recyclerview1.setRecycledViewPool(viewPool);
        level = PrefUtil.getInt(context, Key.LEVEL, 0);
    }

    @Override
    public int getItemCount() {
        return baoCaoTongHopArrayList.size();
    }

    @Override
    public void onItemClickXemFile(ItemDSDauViecPhongChuTriDaXuLyCC itemDSDauViecPhongChuTriDaXuLyCC) {

    }

    @Override
    public void onItemClickXuLy(ItemDSDauViecPhongChuTriDaXuLyCC itemDSDauViecPhongChuTriDaXuLyCC) {
        Intent intent = new Intent(context, NDVBDSDauViecPhongChuTriDaXuLyCCActivity.class);
        intent.putExtra("itemDauViecPhongChuTriChoXuLyCC", itemDSDauViecPhongChuTriDaXuLyCC);
        context.startActivity(intent);
    }

    @Override
    public void onItemClickXemChiTiet(ItemDSDauViecPhongChuTriDaXuLyCC itemDSDauViecPhongChuTriDaXuLyCC) {
        Intent intent = new Intent(context, TTVBDauViecChoXuLyActivity.class);
        intent.putExtra("DauViecChoXuLy", itemDSDauViecPhongChuTriDaXuLyCC.getId());
        context.startActivity(intent);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvStt)
        TextView tvStt;
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
        void onItemClickXemFile(DSDauViecPhongChuTriDaXuLyCC dsDauViecPhongChuTriDaXuLyCC);
    }
}
