package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KetquaGiaiquyetPhongThuly {
    @SerializedName("can_bo_donvi")
    @Expose
    private String canBoDonvi;
    @SerializedName("noi_dung")
    @Expose
    private String noiDung;
    @SerializedName("tai_lieu")
    @Expose
    private String taiLieu;
    @SerializedName("ngay_nhap")
    @Expose
    private String ngayNhap;
    @SerializedName("trang_thai")
    @Expose
    private Integer trangThai;

    public String getCanBoDonvi() {
        return canBoDonvi;
    }

    public void setCanBoDonvi(String canBoDonvi) {
        this.canBoDonvi = canBoDonvi;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getTaiLieu() {
        return taiLieu;
    }

    public void setTaiLieu(String taiLieu) {
        this.taiLieu = taiLieu;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
}
