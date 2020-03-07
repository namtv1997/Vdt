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
import com.vpdt.vpdt.model.ItemPhongChuTriChuyenVienChoXuLy;
import com.vpdt.vpdt.model.PhongChuTriChuyenVienChoXuLy;
import com.vpdt.vpdt.ui.activity.QuanLyDauViec.ChiTietDauViecChoXuLyActivity;
import com.vpdt.vpdt.ui.activity.QuanLyDauViec.NoiDungDauViecPhongChuTriChuyenVienChoXuLyActivity;
import com.vpdt.vpdt.ui.activity.QuanLyDauViec.TTVBDauViecChoXuLyActivity;
import com.vpdt.vpdt.util.PrefUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDanhSachDauViecPhongChuTriChuyenVienChoXuLy extends RecyclerView.Adapter<AdapterDanhSachDauViecPhongChuTriChuyenVienChoXuLy.ViewHolder> implements AdapterDauViecPhongChuTriChuyenVienChoXuLy.OnItemClickListener {
    private ArrayList<PhongChuTriChuyenVienChoXuLy> baoCaoTongHopArrayList;
    OnItemXemFileClickListener listener;
    int level;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    Context context;

    public AdapterDanhSachDauViecPhongChuTriChuyenVienChoXuLy(Context context, ArrayList<PhongChuTriChuyenVienChoXuLy> baoCaoTongHopArrayList, OnItemXemFileClickListener listener) {
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
        PhongChuTriChuyenVienChoXuLy baoCaoTongHop = baoCaoTongHopArrayList.get(position);
        level = PrefUtil.getInt(context, Key.LEVEL, 0);
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
        AdapterDauViecPhongChuTriChuyenVienChoXuLy adapterDauViecQuaHanCuaPhong = new AdapterDauViecPhongChuTriChuyenVienChoXuLy((ArrayList<ItemPhongChuTriChuyenVienChoXuLy>) baoCaoTongHop.getItems(), this);

        viewHolder.recyclerview1.setLayoutManager(layoutManager);
        viewHolder.recyclerview1.setAdapter(adapterDauViecQuaHanCuaPhong);
        viewHolder.recyclerview1.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return baoCaoTongHopArrayList.size();
    }

    @Override
    public void onItemClickXemFile(ItemPhongChuTriChuyenVienChoXuLy itemPhongChuTriChuyenVienChoXuLy) {

    }

    @Override
    public void onItemClickXuLy(ItemPhongChuTriChuyenVienChoXuLy itemPhongChuTriChuyenVienChoXuLy) {
        Intent intent = new Intent(context, NoiDungDauViecPhongChuTriChuyenVienChoXuLyActivity.class);
        intent.putExtra("itemPhongChuTriChuyenVienChoXuLy", itemPhongChuTriChuyenVienChoXuLy);
        context.startActivity(intent);
    }

    @Override
    public void onItemClickXemChiTiet(ItemPhongChuTriChuyenVienChoXuLy itemPhongChuTriChuyenVienChoXuLy) {
        if (level == 8) {
            Intent intent = new Intent(context, ChiTietDauViecChoXuLyActivity.class);
            intent.putExtra("idvb", itemPhongChuTriChuyenVienChoXuLy.getId());
            context.startActivity(intent);
        } else {
            Intent intent = new Intent(context, TTVBDauViecChoXuLyActivity.class);
            intent.putExtra("DauViecChoXuLy", itemPhongChuTriChuyenVienChoXuLy.getId());
            context.startActivity(intent);
        }
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
        void onItemClickXemFile(PhongChuTriChuyenVienChoXuLy phongChuTriChuyenVienChoXuLy);
    }
}
