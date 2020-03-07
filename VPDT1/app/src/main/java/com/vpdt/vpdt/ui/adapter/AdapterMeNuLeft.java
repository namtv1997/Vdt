package com.vpdt.vpdt.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.Contact;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterMeNuLeft extends RecyclerView.Adapter<AdapterMeNuLeft.ViewHolder> {

    private ArrayList<Contact> contactsList;
    private Context mContext;
    private OnItemClickListener listener;

    public AdapterMeNuLeft(Context mContext, ArrayList<Contact> contactsList, OnItemClickListener listener) {
        this.mContext = mContext;
        this.contactsList = contactsList;
        this.listener = listener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_menu, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Contact contact = contactsList.get(position);

        Glide.with(mContext)
                .load(contact.getIcon())
                .into(viewHolder.ivIcon);
//        Glide.with(mContext)
//                .load(contact.getIcon())
//                .into(viewHolder.ivRight);
        if (contact.getKey().equals(Key.XLVB) || contact.getKey().equals(Key.XLGM) || contact.getKey().equals(Key.VBDen) ||
                contact.getKey().equals(Key.VBDi) || contact.getKey().equals(Key.TDTTNB) || contact.getKey().equals(Key.QLDV) ||
                contact.getKey().equals(Key.QLCB)) {
            viewHolder.ivRight.setVisibility(View.VISIBLE);
        } else {
            viewHolder.ivRight.setVisibility(View.GONE);
        }
        viewHolder.tvTenDeMuc.setText(contact.getName());
        if (contact.getShowTotal()) {
            viewHolder.tvNotifiContact.setVisibility(View.VISIBLE);
            viewHolder.tvNotifiContact.setText(String.valueOf(contact.getSoluong()));
            if (contact.getKey().equals(Key.dSVB_QuaHanDoLanhDaoChiDao)) {
                viewHolder.tvTinQuaHan.setVisibility(View.VISIBLE);
                viewHolder.tvTinQuaHan.setText(String.valueOf(contact.getSoluong()));
                viewHolder.tvNotifiContact.setVisibility(View.GONE);
            }
        }

    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivIcon)
        ImageView ivIcon;
        @BindView(R.id.ivRight)
        ImageView ivRight;

        @BindView(R.id.tvTenDeMuc)
        TextView tvTenDeMuc;
        @BindView(R.id.tvNotifiContact)
        TextView tvNotifiContact;
        @BindView(R.id.tvTinQuaHan)
        TextView tvTinQuaHan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(contactsList.get(getAdapterPosition()), v);
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Contact contact, View v);
    }
}