package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemLichHop {
    @SerializedName("thu")
    @Expose
    private String thu;
    @SerializedName("ngay")
    @Expose
    private String ngay;
    @SerializedName("itemmore_sangs")
    @Expose
    private List<ItemmoreSang> itemmoreSangs = null;
    @SerializedName("itemmore_chieus")
    @Expose
    private List<ItemmoreSang> itemmoreChieus = null;

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public List<ItemmoreSang> getItemmoreSangs() {
        return itemmoreSangs;
    }

    public void setItemmoreSangs(List<ItemmoreSang> itemmoreSangs) {
        this.itemmoreSangs = itemmoreSangs;
    }

    public List<ItemmoreSang> getItemmoreChieus() {
        return itemmoreChieus;
    }

    public void setItemmoreChieus(List<ItemmoreSang> itemmoreChieus) {
        this.itemmoreChieus = itemmoreChieus;
    }
}
