package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class CanBo implements Serializable {
    @SerializedName("PK_iMaCB")
    @Expose
    private Integer pKIMaCB;
    @SerializedName("sHoTen")
    @Expose
    private String sHoTen;
    @SerializedName("FK_iMaPhongHD")
    @Expose
    private Integer fKIMaPhongHD;
    @SerializedName("FK_iMaPhongPT")
    @Expose
    private String fKIMaPhongPT;
    @SerializedName("FK_iMaCV")
    @Expose
    private Integer fKIMaCV;
    @SerializedName("sTaiKhoan")
    @Expose
    private String sTaiKhoan;
    @SerializedName("sMatKhau")
    @Expose
    private String sMatKhau;
    @SerializedName("sBanRo")
    @Expose
    private String sBanRo;
    @SerializedName("sDienThoai")
    @Expose
    private String sDienThoai;
    @SerializedName("sEmail")
    @Expose
    private String sEmail;
    @SerializedName("iQuyenHan_DHNB")
    @Expose
    private Integer iQuyenHanDHNB;
    @SerializedName("iQuyenHan_TNVB")
    @Expose
    private Integer iQuyenHanTNVB;
    @SerializedName("iQuyenDB")
    @Expose
    private Integer iQuyenDB;
    @SerializedName("iPhanMem")
    @Expose
    private Integer iPhanMem;
    @SerializedName("iTrangThai")
    @Expose
    private Integer iTrangThai;
    @SerializedName("FK_iMaPhongCC")
    @Expose
    private Integer fKIMaPhongCC;
    @SerializedName("donvi_caphai")
    @Expose
    private Integer donviCaphai;
    @SerializedName("quyenhan_caphai")
    @Expose
    private Integer quyenhanCaphai;
    @SerializedName("phong_caphai")
    @Expose
    private Integer phongCaphai;
    @SerializedName("tendinhdanh")
    @Expose
    private String tendinhdanh;
    @SerializedName("sapxep")
    @Expose
    private Integer sapxep;

    public Integer getPKIMaCB() {
        return pKIMaCB;
    }

    public void setPKIMaCB(Integer pKIMaCB) {
        this.pKIMaCB = pKIMaCB;
    }

    public String getSHoTen() {
        return sHoTen;
    }

    public void setSHoTen(String sHoTen) {
        this.sHoTen = sHoTen;
    }

    public Integer getFKIMaPhongHD() {
        return fKIMaPhongHD;
    }

    public void setFKIMaPhongHD(Integer fKIMaPhongHD) {
        this.fKIMaPhongHD = fKIMaPhongHD;
    }

    public String getFKIMaPhongPT() {
        return fKIMaPhongPT;
    }

    public void setFKIMaPhongPT(String fKIMaPhongPT) {
        this.fKIMaPhongPT = fKIMaPhongPT;
    }

    public Integer getFKIMaCV() {
        return fKIMaCV;
    }

    public void setFKIMaCV(Integer fKIMaCV) {
        this.fKIMaCV = fKIMaCV;
    }

    public String getSTaiKhoan() {
        return sTaiKhoan;
    }

    public void setSTaiKhoan(String sTaiKhoan) {
        this.sTaiKhoan = sTaiKhoan;
    }

    public String getSMatKhau() {
        return sMatKhau;
    }

    public void setSMatKhau(String sMatKhau) {
        this.sMatKhau = sMatKhau;
    }

    public String getSBanRo() {
        return sBanRo;
    }

    public void setSBanRo(String sBanRo) {
        this.sBanRo = sBanRo;
    }

    public String getSDienThoai() {
        return sDienThoai;
    }

    public void setSDienThoai(String sDienThoai) {
        this.sDienThoai = sDienThoai;
    }

    public String getSEmail() {
        return sEmail;
    }

    public void setSEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public Integer getIQuyenHanDHNB() {
        return iQuyenHanDHNB;
    }

    public void setIQuyenHanDHNB(Integer iQuyenHanDHNB) {
        this.iQuyenHanDHNB = iQuyenHanDHNB;
    }

    public Integer getIQuyenHanTNVB() {
        return iQuyenHanTNVB;
    }

    public void setIQuyenHanTNVB(Integer iQuyenHanTNVB) {
        this.iQuyenHanTNVB = iQuyenHanTNVB;
    }

    public Integer getIQuyenDB() {
        return iQuyenDB;
    }

    public void setIQuyenDB(Integer iQuyenDB) {
        this.iQuyenDB = iQuyenDB;
    }

    public Integer getIPhanMem() {
        return iPhanMem;
    }

    public void setIPhanMem(Integer iPhanMem) {
        this.iPhanMem = iPhanMem;
    }

    public Integer getITrangThai() {
        return iTrangThai;
    }

    public void setITrangThai(Integer iTrangThai) {
        this.iTrangThai = iTrangThai;
    }

    public Integer getFKIMaPhongCC() {
        return fKIMaPhongCC;
    }

    public void setFKIMaPhongCC(Integer fKIMaPhongCC) {
        this.fKIMaPhongCC = fKIMaPhongCC;
    }

    public Integer getDonviCaphai() {
        return donviCaphai;
    }

    public void setDonviCaphai(Integer donviCaphai) {
        this.donviCaphai = donviCaphai;
    }

    public Integer getQuyenhanCaphai() {
        return quyenhanCaphai;
    }

    public void setQuyenhanCaphai(Integer quyenhanCaphai) {
        this.quyenhanCaphai = quyenhanCaphai;
    }

    public Integer getPhongCaphai() {
        return phongCaphai;
    }

    public void setPhongCaphai(Integer phongCaphai) {
        this.phongCaphai = phongCaphai;
    }

    public String getTendinhdanh() {
        return tendinhdanh;
    }

    public void setTendinhdanh(String tendinhdanh) {
        this.tendinhdanh = tendinhdanh;
    }

    public Integer getSapxep() {
        return sapxep;
    }

    public void setSapxep(Integer sapxep) {
        this.sapxep = sapxep;
    }
}
