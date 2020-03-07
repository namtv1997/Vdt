package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailDanhGiaKeHoach {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("item_mores")
    @Expose
    private List<ItemMoreDanhGiaKeHoach> itemMores = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemMoreDanhGiaKeHoach> getItemMores() {
        return itemMores;
    }

    public void setItemMores(List<ItemMoreDanhGiaKeHoach> itemMores) {
        this.itemMores = itemMores;
    }
}
