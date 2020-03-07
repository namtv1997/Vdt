package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TepTinVanBanDen {
    @SerializedName("tenTepTin")
    @Expose
    private String tenTepTin;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;
    @SerializedName("nguoiNhap")
    @Expose
    private String nguoiNhap;

    public String getTenTepTin() {
        return tenTepTin;
    }

    public void setTenTepTin(String tenTepTin) {
        this.tenTepTin = tenTepTin;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getNguoiNhap() {
        return nguoiNhap;
    }

    public void setNguoiNhap(String nguoiNhap) {
        this.nguoiNhap = nguoiNhap;
    }
}
