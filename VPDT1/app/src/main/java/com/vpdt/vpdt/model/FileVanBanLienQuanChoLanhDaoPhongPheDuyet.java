package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FileVanBanLienQuanChoLanhDaoPhongPheDuyet {
    @SerializedName("tenCanBo")
    @Expose
    private String tenCanBo;
    @SerializedName("donVi")
    @Expose
    private String donVi;
    @SerializedName("tenTepTin")
    @Expose
    private String tenTepTin;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;

    public String getTenCanBo() {
        return tenCanBo;
    }

    public void setTenCanBo(String tenCanBo) {
        this.tenCanBo = tenCanBo;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

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
}
