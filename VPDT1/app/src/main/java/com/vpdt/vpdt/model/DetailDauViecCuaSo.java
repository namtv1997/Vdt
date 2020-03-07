package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailDauViecCuaSo {
    @SerializedName("ts_vanban")
    @Expose
    private Integer tsVanban;
    @SerializedName("ts_dauviec")
    @Expose
    private Integer tsDauviec;
    @SerializedName("ts_dth_tronghan")
    @Expose
    private Integer tsDthTronghan;
    @SerializedName("ts_dth_quahan")
    @Expose
    private Integer tsDthQuahan;
    @SerializedName("ts_dht_tronghan")
    @Expose
    private Integer tsDhtTronghan;
    @SerializedName("ts_dht_quahan")
    @Expose
    private Integer tsDhtQuahan;
    @SerializedName("ts_sapden_han")
    @Expose
    private Integer tsSapdenHan;
    @SerializedName("items")
    @Expose
    private List<ItemDauViecCuaSo> items = null;

    public Integer getTsVanban() {
        return tsVanban;
    }

    public void setTsVanban(Integer tsVanban) {
        this.tsVanban = tsVanban;
    }

    public Integer getTsDauviec() {
        return tsDauviec;
    }

    public void setTsDauviec(Integer tsDauviec) {
        this.tsDauviec = tsDauviec;
    }

    public Integer getTsDthTronghan() {
        return tsDthTronghan;
    }

    public void setTsDthTronghan(Integer tsDthTronghan) {
        this.tsDthTronghan = tsDthTronghan;
    }

    public Integer getTsDthQuahan() {
        return tsDthQuahan;
    }

    public void setTsDthQuahan(Integer tsDthQuahan) {
        this.tsDthQuahan = tsDthQuahan;
    }

    public Integer getTsDhtTronghan() {
        return tsDhtTronghan;
    }

    public void setTsDhtTronghan(Integer tsDhtTronghan) {
        this.tsDhtTronghan = tsDhtTronghan;
    }

    public Integer getTsDhtQuahan() {
        return tsDhtQuahan;
    }

    public void setTsDhtQuahan(Integer tsDhtQuahan) {
        this.tsDhtQuahan = tsDhtQuahan;
    }

    public Integer getTsSapdenHan() {
        return tsSapdenHan;
    }

    public void setTsSapdenHan(Integer tsSapdenHan) {
        this.tsSapdenHan = tsSapdenHan;
    }

    public List<ItemDauViecCuaSo> getItems() {
        return items;
    }

    public void setItems(List<ItemDauViecCuaSo> items) {
        this.items = items;
    }
}
