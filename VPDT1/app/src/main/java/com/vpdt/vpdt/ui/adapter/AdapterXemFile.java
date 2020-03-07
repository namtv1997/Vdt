package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.File;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterXemFile extends RecyclerView.Adapter<AdapterXemFile.ViewHolder> {
    private ArrayList<File> FileList;
    private Context mContext;
    private AdapterXemFile.OnItemClickListener listener;
    int index = 0;

    public AdapterXemFile(Context mContext, ArrayList<File> FileList, AdapterXemFile.OnItemClickListener listener) {
        this.mContext = mContext;
        this.FileList = FileList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_xemfile, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        File trinhTuGiaiQuyet = FileList.get(position);
        index++;
        viewHolder.tvXemFile.setText(String.valueOf(trinhTuGiaiQuyet.getTenFile()));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClickFileDinhKem(FileList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return FileList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvXemFile)
        TextView tvXemFile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public interface OnItemClickListener {
        void onItemClickFileDinhKem(File file);
    }
}
