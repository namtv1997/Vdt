package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.TepDinhKem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterFileDinhKemChoLanhDaoXuLy extends RecyclerView.Adapter<AdapterFileDinhKemChoLanhDaoXuLy.ViewHolder> {
    private ArrayList<TepDinhKem> tepDinhKems;
    private Context mContext;
    private OnItemClickListenerFileDinhKem listener;


    public AdapterFileDinhKemChoLanhDaoXuLy(Context mContext, ArrayList<TepDinhKem> tepDinhKems, OnItemClickListenerFileDinhKem listener) {
        this.mContext = mContext;
        this.tepDinhKems = tepDinhKems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_file_dinh_kem, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        int stt = position + 1;
        viewHolder.tvFileDinhKem.setText("Xem file đính kèm " + stt);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickFileDinhKem(tepDinhKems.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return tepDinhKems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvFileDinhKem)
        TextView tvFileDinhKem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public interface OnItemClickListenerFileDinhKem {
        void onItemClickFileDinhKem(TepDinhKem dinhKem);
    }
}
