package com.vpdt.vpdt.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.FileDinhKem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDanhSachFileDinhKem extends RecyclerView.Adapter<AdapterDanhSachFileDinhKem.ViewHolder> {
    private ArrayList<FileDinhKem> tepDinhKems;

    //    private Context mContext;
//    private OnItemClickListenerFileDinhKem listener;
    public AdapterDanhSachFileDinhKem(ArrayList<FileDinhKem> tepDinhKems) {
//        this.mContext=mContext;
        this.tepDinhKems = tepDinhKems;
//        this.listener=listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_danhsachfiledinhkem, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.tvSTT.setText(String.valueOf(position + 1));

        FileDinhKem tepDinhKem = tepDinhKems.get(position);

        viewHolder.tvTenFile.setText(String.valueOf(tepDinhKem.getTenFile()));

//        viewHolder.tvXoa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (listener != null) {
//                    listener.onItemClickFileDinhKem(tepDinhKems.get(position));
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return tepDinhKems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvSTT)
        TextView tvSTT;
        @BindView(R.id.tvTenFile)
        TextView tvTenFile;
        @BindView(R.id.tvXoa)
        TextView tvXoa;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
//    public interface OnItemClickListenerFileDinhKem {
//        void onItemClickFileDinhKem(FileDinhKem fileDinhKem);
//    }
}
