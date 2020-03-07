package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThongKeTheoPhong {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ten")
    @Expose
    private String ten;
    @SerializedName("tongSV")
    @Expose
    private Integer tongSV;
    @SerializedName("dgq_tong")
    @Expose
    private Integer dgqTong;
    @SerializedName("dgq_dunghan")
    @Expose
    private Integer dgqDunghan;
    @SerializedName("dgq_quahan")
    @Expose
    private Integer dgqQuahan;
    @SerializedName("dgq_sangtao")
    @Expose
    private Integer dgqSangtao;
    @SerializedName("cgq_tong")
    @Expose
    private Integer cgqTong;
    @SerializedName("cgq_tronghan")
    @Expose
    private Integer cgqTronghan;
    @SerializedName("cgq_quahan")
    @Expose
    private Integer cgqQuahan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getTongSV() {
        return tongSV;
    }

    public void setTongSV(Integer tongSV) {
        this.tongSV = tongSV;
    }

    public Integer getDgqTong() {
        return dgqTong;
    }

    public void setDgqTong(Integer dgqTong) {
        this.dgqTong = dgqTong;
    }

    public Integer getDgqDunghan() {
        return dgqDunghan;
    }

    public void setDgqDunghan(Integer dgqDunghan) {
        this.dgqDunghan = dgqDunghan;
    }

    public Integer getDgqQuahan() {
        return dgqQuahan;
    }

    public void setDgqQuahan(Integer dgqQuahan) {
        this.dgqQuahan = dgqQuahan;
    }

    public Integer getDgqSangtao() {
        return dgqSangtao;
    }

    public void setDgqSangtao(Integer dgqSangtao) {
        this.dgqSangtao = dgqSangtao;
    }

    public Integer getCgqTong() {
        return cgqTong;
    }

    public void setCgqTong(Integer cgqTong) {
        this.cgqTong = cgqTong;
    }

    public Integer getCgqTronghan() {
        return cgqTronghan;
    }

    public void setCgqTronghan(Integer cgqTronghan) {
        this.cgqTronghan = cgqTronghan;
    }

    public Integer getCgqQuahan() {
        return cgqQuahan;
    }

    public void setCgqQuahan(Integer cgqQuahan) {
        this.cgqQuahan = cgqQuahan;
    }
}
