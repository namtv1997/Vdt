package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Root1 {
    @SerializedName("tieuDeDauViec")
    @Expose
    private String tieuDeDauViec;
    @SerializedName("linhVuc")
    @Expose
    private String linhVuc;
    @SerializedName("linhVucChiTiet")
    @Expose
    private String linhVucChiTiet;
    @SerializedName("itemMores")
    @Expose
    private List<ItemMore1> itemMores = null;

    public String getTieuDeDauViec() {
        return tieuDeDauViec;
    }

    public void setTieuDeDauViec(String tieuDeDauViec) {
        this.tieuDeDauViec = tieuDeDauViec;
    }

    public String getLinhVuc() {
        return linhVuc;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }

    public String getLinhVucChiTiet() {
        return linhVucChiTiet;
    }

    public void setLinhVucChiTiet(String linhVucChiTiet) {
        this.linhVucChiTiet = linhVucChiTiet;
    }

    public List<ItemMore1> getItemMores() {
        return itemMores;
    }

    public void setItemMores(List<ItemMore1> itemMores) {
        this.itemMores = itemMores;
    }
}
