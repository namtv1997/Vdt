package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrichYeuVanBanTheoLanhDao {
    @SerializedName("igiaymoi")
    @Expose
    private Integer igiaymoi;
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("nguoinhap")
    @Expose
    private String nguoinhap;
    @SerializedName("ngaynhap")
    @Expose
    private String ngaynhap;
    @SerializedName("sGiayMoiNgay")
    @Expose
    private String sGiayMoiNgay;
    @SerializedName("sGiayMoiGio")
    @Expose
    private String sGiayMoiGio;
    @SerializedName("sGiayMoiDiaDiem")
    @Expose
    private String sGiayMoiDiaDiem;
    @SerializedName("sGiayMoiChuTri")
    @Expose
    private String sGiayMoiChuTri;

    public Integer getIgiaymoi() {
        return igiaymoi;
    }

    public void setIgiaymoi(Integer igiaymoi) {
        this.igiaymoi = igiaymoi;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getNguoinhap() {
        return nguoinhap;
    }

    public void setNguoinhap(String nguoinhap) {
        this.nguoinhap = nguoinhap;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public String getSGiayMoiNgay() {
        return sGiayMoiNgay;
    }

    public void setSGiayMoiNgay(String sGiayMoiNgay) {
        this.sGiayMoiNgay = sGiayMoiNgay;
    }

    public String getSGiayMoiGio() {
        return sGiayMoiGio;
    }

    public void setSGiayMoiGio(String sGiayMoiGio) {
        this.sGiayMoiGio = sGiayMoiGio;
    }

    public String getSGiayMoiDiaDiem() {
        return sGiayMoiDiaDiem;
    }

    public void setSGiayMoiDiaDiem(String sGiayMoiDiaDiem) {
        this.sGiayMoiDiaDiem = sGiayMoiDiaDiem;
    }

    public String getSGiayMoiChuTri() {
        return sGiayMoiChuTri;
    }

    public void setSGiayMoiChuTri(String sGiayMoiChuTri) {
        this.sGiayMoiChuTri = sGiayMoiChuTri;
    }
}
