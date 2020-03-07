package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DSVB_TheoPhong {
    @SerializedName("ten_phongban")
    @Expose
    private String tenPhongban;
    @SerializedName("tong_so_viec")
    @Expose
    private Integer tongSoViec;
    @SerializedName("dgq_tong_so")
    @Expose
    private Integer dgqTongSo;
    @SerializedName("dgq_dung_han")
    @Expose
    private Integer dgqDungHan;
    @SerializedName("dgq_qua_han")
    @Expose
    private Integer dgqQuaHan;
    @SerializedName("dgq_co_sang_tao")
    @Expose
    private Integer dgqCoSangTao;
    @SerializedName("cgq_tong_so")
    @Expose
    private Integer cgqTongSo;
    @SerializedName("cgq_trong_han")
    @Expose
    private Integer cgqTrongHan;
    @SerializedName("cgq_qua_han")
    @Expose
    private Integer cgqQuaHan;

    public String getTenPhongban() {
        return tenPhongban;
    }

    public void setTenPhongban(String tenPhongban) {
        this.tenPhongban = tenPhongban;
    }

    public Integer getTongSoViec() {
        return tongSoViec;
    }

    public void setTongSoViec(Integer tongSoViec) {
        this.tongSoViec = tongSoViec;
    }

    public Integer getDgqTongSo() {
        return dgqTongSo;
    }

    public void setDgqTongSo(Integer dgqTongSo) {
        this.dgqTongSo = dgqTongSo;
    }

    public Integer getDgqDungHan() {
        return dgqDungHan;
    }

    public void setDgqDungHan(Integer dgqDungHan) {
        this.dgqDungHan = dgqDungHan;
    }

    public Integer getDgqQuaHan() {
        return dgqQuaHan;
    }

    public void setDgqQuaHan(Integer dgqQuaHan) {
        this.dgqQuaHan = dgqQuaHan;
    }

    public Integer getDgqCoSangTao() {
        return dgqCoSangTao;
    }

    public void setDgqCoSangTao(Integer dgqCoSangTao) {
        this.dgqCoSangTao = dgqCoSangTao;
    }

    public Integer getCgqTongSo() {
        return cgqTongSo;
    }

    public void setCgqTongSo(Integer cgqTongSo) {
        this.cgqTongSo = cgqTongSo;
    }

    public Integer getCgqTrongHan() {
        return cgqTrongHan;
    }

    public void setCgqTrongHan(Integer cgqTrongHan) {
        this.cgqTrongHan = cgqTrongHan;
    }

    public Integer getCgqQuaHan() {
        return cgqQuaHan;
    }

    public void setCgqQuaHan(Integer cgqQuaHan) {
        this.cgqQuaHan = cgqQuaHan;
    }
}
