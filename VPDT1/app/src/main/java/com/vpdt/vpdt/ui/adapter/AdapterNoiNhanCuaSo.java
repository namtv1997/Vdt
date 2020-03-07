package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.Noinhan;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterNoiNhanCuaSo extends RecyclerView.Adapter<AdapterNoiNhanCuaSo.ViewHolder> {
    private ArrayList<Noinhan> noinhanArrayList;
    private Context mContext;

    public AdapterNoiNhanCuaSo(Context mContext, ArrayList<Noinhan> noinhanArrayList) {
        this.mContext = mContext;
        this.noinhanArrayList = noinhanArrayList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_noinhan_cua_so, parent, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Noinhan noinhan = noinhanArrayList.get(position);
        viewHolder.tvNoiNhan.setText(String.valueOf(noinhan.getMthu()));


    }

    @Override
    public int getItemCount() {
        return noinhanArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tvNoiNhan)
        TextView tvNoiNhan;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }


}
