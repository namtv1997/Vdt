package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailDanhSachVanBanSoThamMuuTrinhThanhPho {
    @SerializedName("ma")
    @Expose
    private Integer ma;
    @SerializedName("ten")
    @Expose
    private String ten;
    @SerializedName("solg")
    @Expose
    private Integer solg;
    @SerializedName("detail")
    @Expose
    private List<Detail> detail = null;

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getSolg() {
        return solg;
    }

    public void setSolg(Integer solg) {
        this.solg = solg;
    }

    public List<Detail> getDetail() {
        return detail;
    }

    public void setDetail(List<Detail> detail) {
        this.detail = detail;
    }
}
