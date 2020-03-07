package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KeHoachCongTacTuan {
    @SerializedName("id_pb")
    @Expose
    private Integer idPb;
    @SerializedName("phong_ban")
    @Expose
    private String phongBan;
    @SerializedName("ts_kehoach")
    @Expose
    private Integer tsKehoach;
    @SerializedName("sl_cv_hoanthanh")
    @Expose
    private Integer slCvHoanthanh;
    @SerializedName("cv_hoanthanh_tronghan")
    @Expose
    private Integer cvHoanthanhTronghan;
    @SerializedName("cv_hoanthanh_quahan")
    @Expose
    private Integer cvHoanthanhQuahan;
    @SerializedName("cv_hoanthanh_cl_dambao")
    @Expose
    private Integer cvHoanthanhClDambao;
    @SerializedName("cv_hoanthanh_cl_chuadambao")
    @Expose
    private Integer cvHoanthanhClChuadambao;
    @SerializedName("cv_hoanthanh_sangtao")
    @Expose
    private Integer cvHoanthanhSangtao;
    @SerializedName("sl_cv_ton")
    @Expose
    private Integer slCvTon;
    @SerializedName("cv_ton_tronghan")
    @Expose
    private Integer cvTonTronghan;
    @SerializedName("cv_ton_chamtiendo")
    @Expose
    private Integer cvTonChamtiendo;
    @SerializedName("tile_hoanthanh")
    @Expose
    private Double tileHoanthanh;

    public Integer getIdPb() {
        return idPb;
    }

    public void setIdPb(Integer idPb) {
        this.idPb = idPb;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public Integer getTsKehoach() {
        return tsKehoach;
    }

    public void setTsKehoach(Integer tsKehoach) {
        this.tsKehoach = tsKehoach;
    }

    public Integer getSlCvHoanthanh() {
        return slCvHoanthanh;
    }

    public void setSlCvHoanthanh(Integer slCvHoanthanh) {
        this.slCvHoanthanh = slCvHoanthanh;
    }

    public Integer getCvHoanthanhTronghan() {
        return cvHoanthanhTronghan;
    }

    public void setCvHoanthanhTronghan(Integer cvHoanthanhTronghan) {
        this.cvHoanthanhTronghan = cvHoanthanhTronghan;
    }

    public Integer getCvHoanthanhQuahan() {
        return cvHoanthanhQuahan;
    }

    public void setCvHoanthanhQuahan(Integer cvHoanthanhQuahan) {
        this.cvHoanthanhQuahan = cvHoanthanhQuahan;
    }

    public Integer getCvHoanthanhClDambao() {
        return cvHoanthanhClDambao;
    }

    public void setCvHoanthanhClDambao(Integer cvHoanthanhClDambao) {
        this.cvHoanthanhClDambao = cvHoanthanhClDambao;
    }

    public Integer getCvHoanthanhClChuadambao() {
        return cvHoanthanhClChuadambao;
    }

    public void setCvHoanthanhClChuadambao(Integer cvHoanthanhClChuadambao) {
        this.cvHoanthanhClChuadambao = cvHoanthanhClChuadambao;
    }

    public Integer getCvHoanthanhSangtao() {
        return cvHoanthanhSangtao;
    }

    public void setCvHoanthanhSangtao(Integer cvHoanthanhSangtao) {
        this.cvHoanthanhSangtao = cvHoanthanhSangtao;
    }

    public Integer getSlCvTon() {
        return slCvTon;
    }

    public void setSlCvTon(Integer slCvTon) {
        this.slCvTon = slCvTon;
    }

    public Integer getCvTonTronghan() {
        return cvTonTronghan;
    }

    public void setCvTonTronghan(Integer cvTonTronghan) {
        this.cvTonTronghan = cvTonTronghan;
    }

    public Integer getCvTonChamtiendo() {
        return cvTonChamtiendo;
    }

    public void setCvTonChamtiendo(Integer cvTonChamtiendo) {
        this.cvTonChamtiendo = cvTonChamtiendo;
    }

    public Double getTileHoanthanh() {
        return tileHoanthanh;
    }

    public void setTileHoanthanh(Double tileHoanthanh) {
        this.tileHoanthanh = tileHoanthanh;
    }

}
