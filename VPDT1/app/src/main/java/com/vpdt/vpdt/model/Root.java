package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Root {
    @SerializedName("tieuDeDauViec")
    @Expose
    private String tieuDeDauViec;
    @SerializedName("itemMores")
    @Expose
    private List<ItemMore1> itemMores = null;

    public String getTieuDeDauViec() {
        return tieuDeDauViec;
    }

    public void setTieuDeDauViec(String tieuDeDauViec) {
        this.tieuDeDauViec = tieuDeDauViec;
    }

    public List<ItemMore1> getItemMores() {
        return itemMores;
    }

    public void setItemMores(List<ItemMore1> itemMores) {
        this.itemMores = itemMores;
    }
}
