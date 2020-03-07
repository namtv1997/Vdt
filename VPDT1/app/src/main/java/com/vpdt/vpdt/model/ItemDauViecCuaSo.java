package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemDauViecCuaSo {
    @SerializedName("so_kyhieu")
    @Expose
    private String soKyhieu;
    @SerializedName("ngay_banhanh")
    @Expose
    private String ngayBanhanh;
    @SerializedName("trich_yeu")
    @Expose
    private String trichYeu;
    @SerializedName("tong_so")
    @Expose
    private Integer tongSo;
    @SerializedName("dth_tronghan")
    @Expose
    private Integer dthTronghan;
    @SerializedName("dth_quahan")
    @Expose
    private Integer dthQuahan;
    @SerializedName("dht_tronghan")
    @Expose
    private Integer dhtTronghan;
    @SerializedName("dht_quahan")
    @Expose
    private Integer dhtQuahan;
    @SerializedName("sapden_han")
    @Expose
    private Integer sapdenHan;

    public String getSoKyhieu() {
        return soKyhieu;
    }

    public void setSoKyhieu(String soKyhieu) {
        this.soKyhieu = soKyhieu;
    }

    public String getNgayBanhanh() {
        return ngayBanhanh;
    }

    public void setNgayBanhanh(String ngayBanhanh) {
        this.ngayBanhanh = ngayBanhanh;
    }

    public String getTrichYeu() {
        return trichYeu;
    }

    public void setTrichYeu(String trichYeu) {
        this.trichYeu = trichYeu;
    }

    public Integer getTongSo() {
        return tongSo;
    }

    public void setTongSo(Integer tongSo) {
        this.tongSo = tongSo;
    }

    public Integer getDthTronghan() {
        return dthTronghan;
    }

    public void setDthTronghan(Integer dthTronghan) {
        this.dthTronghan = dthTronghan;
    }

    public Integer getDthQuahan() {
        return dthQuahan;
    }

    public void setDthQuahan(Integer dthQuahan) {
        this.dthQuahan = dthQuahan;
    }

    public Integer getDhtTronghan() {
        return dhtTronghan;
    }

    public void setDhtTronghan(Integer dhtTronghan) {
        this.dhtTronghan = dhtTronghan;
    }

    public Integer getDhtQuahan() {
        return dhtQuahan;
    }

    public void setDhtQuahan(Integer dhtQuahan) {
        this.dhtQuahan = dhtQuahan;
    }

    public Integer getSapdenHan() {
        return sapdenHan;
    }

    public void setSapdenHan(Integer sapdenHan) {
        this.sapdenHan = sapdenHan;
    }
}
