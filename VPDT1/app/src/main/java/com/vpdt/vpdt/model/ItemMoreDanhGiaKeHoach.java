package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemMoreDanhGiaKeHoach {
    @SerializedName("nguoi_thuchien")
    @Expose
    private String nguoiThuchien;
    @SerializedName("ts_viec_theokehoach")
    @Expose
    private Integer tsViecTheokehoach;
    @SerializedName("ts_cv_hoanthanh")
    @Expose
    private Integer tsCvHoanthanh;
    @SerializedName("dht_tronghan")
    @Expose
    private Integer dhtTronghan;
    @SerializedName("dht_quahan")
    @Expose
    private Integer dhtQuahan;
    @SerializedName("dht_cl_dambao")
    @Expose
    private Integer dhtClDambao;
    @SerializedName("dht_cl_chua_dambao")
    @Expose
    private Integer dhtClChuaDambao;
    @SerializedName("dht_sangtao")
    @Expose
    private Integer dhtSangtao;
    @SerializedName("ts_cv_cht")
    @Expose
    private Integer tsCvCht;
    @SerializedName("cht_tronghan")
    @Expose
    private Integer chtTronghan;
    @SerializedName("cht_chamtiendo")
    @Expose
    private Integer chtChamtiendo;
    @SerializedName("tile_hoanthanh")
    @Expose
    private Double tileHoanthanh;
    @SerializedName("tile_hoanthanh_dunghan")
    @Expose
    private Double tileHoanthanhDunghan;
    @SerializedName("tile_hoanthanh_quahan")
    @Expose
    private Double tileHoanthanhQuahan;
    @SerializedName("diem_tudong")
    @Expose
    private Double diemTudong;
    @SerializedName("diem_canhan")
    @Expose
    private String diemCanhan;
    @SerializedName("diem_ld_so")
    @Expose
    private String diemLdSo;
    @SerializedName("canbo_nhanxet")
    @Expose
    private String canboNhanxet;
    @SerializedName("GD_nhanxet")
    @Expose
    private String gDNhanxet;
    @SerializedName("PGD_nhanxet")
    @Expose
    private String pGDNhanxet;
    @SerializedName("danh_gia")
    @Expose
    private String danhGia;

    public String getNguoiThuchien() {
        return nguoiThuchien;
    }

    public void setNguoiThuchien(String nguoiThuchien) {
        this.nguoiThuchien = nguoiThuchien;
    }

    public Integer getTsViecTheokehoach() {
        return tsViecTheokehoach;
    }

    public void setTsViecTheokehoach(Integer tsViecTheokehoach) {
        this.tsViecTheokehoach = tsViecTheokehoach;
    }

    public Integer getTsCvHoanthanh() {
        return tsCvHoanthanh;
    }

    public void setTsCvHoanthanh(Integer tsCvHoanthanh) {
        this.tsCvHoanthanh = tsCvHoanthanh;
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

    public Integer getDhtClDambao() {
        return dhtClDambao;
    }

    public void setDhtClDambao(Integer dhtClDambao) {
        this.dhtClDambao = dhtClDambao;
    }

    public Integer getDhtClChuaDambao() {
        return dhtClChuaDambao;
    }

    public void setDhtClChuaDambao(Integer dhtClChuaDambao) {
        this.dhtClChuaDambao = dhtClChuaDambao;
    }

    public Integer getDhtSangtao() {
        return dhtSangtao;
    }

    public void setDhtSangtao(Integer dhtSangtao) {
        this.dhtSangtao = dhtSangtao;
    }

    public Integer getTsCvCht() {
        return tsCvCht;
    }

    public void setTsCvCht(Integer tsCvCht) {
        this.tsCvCht = tsCvCht;
    }

    public Integer getChtTronghan() {
        return chtTronghan;
    }

    public void setChtTronghan(Integer chtTronghan) {
        this.chtTronghan = chtTronghan;
    }

    public Integer getChtChamtiendo() {
        return chtChamtiendo;
    }

    public void setChtChamtiendo(Integer chtChamtiendo) {
        this.chtChamtiendo = chtChamtiendo;
    }

    public Double getTileHoanthanh() {
        return tileHoanthanh;
    }

    public void setTileHoanthanh(Double tileHoanthanh) {
        this.tileHoanthanh = tileHoanthanh;
    }

    public Double getTileHoanthanhDunghan() {
        return tileHoanthanhDunghan;
    }

    public void setTileHoanthanhDunghan(Double tileHoanthanhDunghan) {
        this.tileHoanthanhDunghan = tileHoanthanhDunghan;
    }

    public Double getTileHoanthanhQuahan() {
        return tileHoanthanhQuahan;
    }

    public void setTileHoanthanhQuahan(Double tileHoanthanhQuahan) {
        this.tileHoanthanhQuahan = tileHoanthanhQuahan;
    }

    public Double getDiemTudong() {
        return diemTudong;
    }

    public void setDiemTudong(Double diemTudong) {
        this.diemTudong = diemTudong;
    }

    public String getDiemCanhan() {
        return diemCanhan;
    }

    public void setDiemCanhan(String diemCanhan) {
        this.diemCanhan = diemCanhan;
    }

    public String getDiemLdSo() {
        return diemLdSo;
    }

    public void setDiemLdSo(String diemLdSo) {
        this.diemLdSo = diemLdSo;
    }

    public String getCanboNhanxet() {
        return canboNhanxet;
    }

    public void setCanboNhanxet(String canboNhanxet) {
        this.canboNhanxet = canboNhanxet;
    }

    public String getGDNhanxet() {
        return gDNhanxet;
    }

    public void setGDNhanxet(String gDNhanxet) {
        this.gDNhanxet = gDNhanxet;
    }

    public String getPGDNhanxet() {
        return pGDNhanxet;
    }

    public void setPGDNhanxet(String pGDNhanxet) {
        this.pGDNhanxet = pGDNhanxet;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }
}
