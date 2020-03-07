package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ToCongTac {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ngay_nhap")
    @Expose
    private String ngayNhap;
    @SerializedName("loai_vanban")
    @Expose
    private String loaiVanban;
    @SerializedName("so_den")
    @Expose
    private String soDen;
    @SerializedName("ky_hieu")
    @Expose
    private String kyHieu;
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("nguoinhap")
    @Expose
    private String nguoinhap;
    @SerializedName("noi_gui")
    @Expose
    private String noiGui;
    @SerializedName("tep_dinh_kems")
    @Expose
    private List<TepDinhKem> tepDinhKems = null;
    @SerializedName("phong_chu_tri")
    @Expose
    private String phongChuTri;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getLoaiVanban() {
        return loaiVanban;
    }

    public void setLoaiVanban(String loaiVanban) {
        this.loaiVanban = loaiVanban;
    }

    public String getSoDen() {
        return soDen;
    }

    public void setSoDen(String soDen) {
        this.soDen = soDen;
    }

    public String getKyHieu() {
        return kyHieu;
    }

    public void setKyHieu(String kyHieu) {
        this.kyHieu = kyHieu;
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

    public String getNoiGui() {
        return noiGui;
    }

    public void setNoiGui(String noiGui) {
        this.noiGui = noiGui;
    }

    public List<TepDinhKem> getTepDinhKems() {
        return tepDinhKems;
    }

    public void setTepDinhKems(List<TepDinhKem> tepDinhKems) {
        this.tepDinhKems = tepDinhKems;
    }

    public String getPhongChuTri() {
        return phongChuTri;
    }

    public void setPhongChuTri(String phongChuTri) {
        this.phongChuTri = phongChuTri;
    }

}
