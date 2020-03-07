package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.ThongKeLanhDaoChiDao;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterTenPhoGiamDoc extends RecyclerView.Adapter<AdapterTenPhoGiamDoc.ViewHolder> {
    private ArrayList<ThongKeLanhDaoChiDao> listTenGiamDoc;
    private Context mContext;
    private OnItemClickListenerTenPhoGiamDoc listener;

    public AdapterTenPhoGiamDoc(Context context, ArrayList<ThongKeLanhDaoChiDao> listTenGiamDoc, OnItemClickListenerTenPhoGiamDoc listener) {
        this.mContext = context;
        this.listTenGiamDoc = listTenGiamDoc;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ten_giam_doc, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ThongKeLanhDaoChiDao giamdocVaPhoGiamdoc = listTenGiamDoc.get(position);
        viewHolder.tvTenGiamDoc.setText(String.valueOf(giamdocVaPhoGiamdoc.getPhoGD()));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickTenPhoGiamDoc(listTenGiamDoc.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTenGiamDoc.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvTenGiamDoc)
        TextView tvTenGiamDoc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    public interface OnItemClickListenerTenPhoGiamDoc {
        void onItemClickTenPhoGiamDoc(ThongKeLanhDaoChiDao thongKeLanhDaoChiDao);
    }
}
