package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailVanbanLanhDao {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ten")
    @Expose
    private String ten;
    @SerializedName("tongdangxuly")
    @Expose
    private Integer tongdangxuly;
    @SerializedName("demxuly_dunghan")
    @Expose
    private Integer demxulyDunghan;
    @SerializedName("demxuly_quahan")
    @Expose
    private Integer demxulyQuahan;
    @SerializedName("tongdaxuly")
    @Expose
    private Integer tongdaxuly;
    @SerializedName("demdaxuly_dunghan")
    @Expose
    private Integer demdaxulyDunghan;
    @SerializedName("demdaxuly_quahan")
    @Expose
    private Integer demdaxulyQuahan;

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

    public Integer getTongdangxuly() {
        return tongdangxuly;
    }

    public void setTongdangxuly(Integer tongdangxuly) {
        this.tongdangxuly = tongdangxuly;
    }

    public Integer getDemxulyDunghan() {
        return demxulyDunghan;
    }

    public void setDemxulyDunghan(Integer demxulyDunghan) {
        this.demxulyDunghan = demxulyDunghan;
    }

    public Integer getDemxulyQuahan() {
        return demxulyQuahan;
    }

    public void setDemxulyQuahan(Integer demxulyQuahan) {
        this.demxulyQuahan = demxulyQuahan;
    }

    public Integer getTongdaxuly() {
        return tongdaxuly;
    }

    public void setTongdaxuly(Integer tongdaxuly) {
        this.tongdaxuly = tongdaxuly;
    }

    public Integer getDemdaxulyDunghan() {
        return demdaxulyDunghan;
    }

    public void setDemdaxulyDunghan(Integer demdaxulyDunghan) {
        this.demdaxulyDunghan = demdaxulyDunghan;
    }

    public Integer getDemdaxulyQuahan() {
        return demdaxulyQuahan;
    }

    public void setDemdaxulyQuahan(Integer demdaxulyQuahan) {
        this.demdaxulyQuahan = demdaxulyQuahan;
    }
}
