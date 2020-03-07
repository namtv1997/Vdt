package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailLichHop {
    @SerializedName("ngay_bat_dau")
    @Expose
    private String ngayBatDau;
    @SerializedName("ngay_ket_thuc")
    @Expose
    private String ngayKetThuc;
    @SerializedName("items")
    @Expose
    private List<ItemLichHop> items = null;

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public List<ItemLichHop> getItems() {
        return items;
    }

    public void setItems(List<ItemLichHop> items) {
        this.items = items;
    }
}
