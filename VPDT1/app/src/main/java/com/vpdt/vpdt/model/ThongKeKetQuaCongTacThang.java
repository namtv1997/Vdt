package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ThongKeKetQuaCongTacThang {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("item_mores")
    @Expose
    private List<ItemThang> itemThangs = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemThang> getItemMores() {
        return itemThangs;
    }

    public void setItemMores(List<ItemThang> itemThangs) {
        this.itemThangs = itemThangs;
    }
}
