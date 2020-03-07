package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BaoCaoKetQuaDaGuiDi implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("id_vb")
    @Expose
    private Integer idVb;
    @SerializedName("id_noidung")
    @Expose
    private Integer idNoidung;
    @SerializedName("ngay_phap")
    @Expose
    private String ngayPhap;
    @SerializedName("so_den")
    @Expose
    private String soDen;
    @SerializedName("so_ky_hieu")
    @Expose
    private String soKyHieu;
    @SerializedName("noi_gui")
    @Expose
    private String noiGui;
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("giay_moi_ngay")
    @Expose
    private String giayMoiNgay;
    @SerializedName("giay_moi_gio")
    @Expose
    private String giayMoiGio;
    @SerializedName("giay_moi_diadiem")
    @Expose
    private String giayMoiDiadiem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdVb() {
        return idVb;
    }

    public void setIdVb(Integer idVb) {
        this.idVb = idVb;
    }

    public Integer getIdNoidung() {
        return idNoidung;
    }

    public void setIdNoidung(Integer idNoidung) {
        this.idNoidung = idNoidung;
    }

    public String getNgayPhap() {
        return ngayPhap;
    }

    public void setNgayPhap(String ngayPhap) {
        this.ngayPhap = ngayPhap;
    }

    public String getSoDen() {
        return soDen;
    }

    public void setSoDen(String soDen) {
        this.soDen = soDen;
    }

    public String getSoKyHieu() {
        return soKyHieu;
    }

    public void setSoKyHieu(String soKyHieu) {
        this.soKyHieu = soKyHieu;
    }

    public String getNoiGui() {
        return noiGui;
    }

    public void setNoiGui(String noiGui) {
        this.noiGui = noiGui;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getGiayMoiNgay() {
        return giayMoiNgay;
    }

    public void setGiayMoiNgay(String giayMoiNgay) {
        this.giayMoiNgay = giayMoiNgay;
    }

    public String getGiayMoiGio() {
        return giayMoiGio;
    }

    public void setGiayMoiGio(String giayMoiGio) {
        this.giayMoiGio = giayMoiGio;
    }

    public String getGiayMoiDiadiem() {
        return giayMoiDiadiem;
    }

    public void setGiayMoiDiadiem(String giayMoiDiadiem) {
        this.giayMoiDiadiem = giayMoiDiadiem;
    }


}
