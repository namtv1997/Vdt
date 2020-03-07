package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.FileBaoCao;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterFileBaoCao extends RecyclerView.Adapter<AdapterFileBaoCao.ViewHolder> {
    private ArrayList<FileBaoCao> tepDinhKems;
    private OnItemClickListenerFileDinhKem listener;

    public AdapterFileBaoCao(ArrayList<FileBaoCao> tepDinhKems, OnItemClickListenerFileDinhKem listener) {

        this.tepDinhKems = tepDinhKems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filebaocao, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        FileBaoCao tepDinhKem = tepDinhKems.get(position);

        viewHolder.tvTenFile.setText(String.valueOf("Xem file " + tepDinhKem.getTenFile()));

        viewHolder.tvXemFile.setOnClickListener(new View.OnClickListener() {
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

        @BindView(R.id.tvTenFile)
        TextView tvTenFile;
        @BindView(R.id.tvXemFile)
        TextView tvXemFile;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public interface OnItemClickListenerFileDinhKem {
        void onItemClickFileDinhKem(FileBaoCao fileDinhKem);
    }
}
