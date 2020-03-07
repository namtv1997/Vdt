package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.Pgd;

import org.sufficientlysecure.htmltextview.HtmlAssetsImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterPGD extends RecyclerView.Adapter<AdapterPGD.ViewHolder> {
    private ArrayList<Pgd> pgdArrayList;

    public AdapterPGD(ArrayList<Pgd> pgdArrayList) {
        this.pgdArrayList = pgdArrayList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pgd, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Pgd pgd = pgdArrayList.get(position);
        viewHolder.tvNguoiDanhGia.setHtml(pgd.getNguoidanhgia(), new HtmlAssetsImageGetter(viewHolder.tvNguoiDanhGia));
        viewHolder.tvNhanXet.setText(pgd.getNhanxet() + " - " + pgd.getThoigianDanhgia());

    }

    @Override
    public int getItemCount() {
        return pgdArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvNguoiDanhGia)
        HtmlTextView tvNguoiDanhGia;
        @BindView(R.id.tvNhanXet)
        TextView tvNhanXet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

}
