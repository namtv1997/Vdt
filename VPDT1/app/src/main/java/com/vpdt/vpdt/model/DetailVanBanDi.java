package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailVanBanDi {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("noi_nhan")
    @Expose
    private String noiNhan;
    @SerializedName("so_kyhieu")
    @Expose
    private String soKyhieu;
    @SerializedName("loai_vanban")
    @Expose
    private String loaiVanban;
    @SerializedName("so_vanban")
    @Expose
    private String soVanban;
    @SerializedName("ngay_ky")
    @Expose
    private String ngayKy;
    @SerializedName("linh_vuc")
    @Expose
    private String linhVuc;
    @SerializedName("mo_ta")
    @Expose
    private String moTa;
    @SerializedName("nguoi_ky")
    @Expose
    private String nguoiKy;
    @SerializedName("nguoi_nhap")
    @Expose
    private String nguoiNhap;
    @SerializedName("ghi_chu")
    @Expose
    private String ghiChu;
    @SerializedName("soDens")
    @Expose
    private List<SoDen> soDens = null;
    @SerializedName("qua_trinh_xulys")
    @Expose
    private List<QuaTrinhXuly> quaTrinhXulys = null;
    @SerializedName("pho_hop_xulys")
    @Expose
    private List<PhoHopXuly> phoHopXulys = null;
    @SerializedName("tep_dinh_kems")
    @Expose
    private List<TepDinhKemVanBanDi> tepDinhKems = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoiNhan() {
        return noiNhan;
    }

    public void setNoiNhan(String noiNhan) {
        this.noiNhan = noiNhan;
    }

    public String getSoKyhieu() {
        return soKyhieu;
    }

    public void setSoKyhieu(String soKyhieu) {
        this.soKyhieu = soKyhieu;
    }

    public String getLoaiVanban() {
        return loaiVanban;
    }

    public void setLoaiVanban(String loaiVanban) {
        this.loaiVanban = loaiVanban;
    }

    public String getSoVanban() {
        return soVanban;
    }

    public void setSoVanban(String soVanban) {
        this.soVanban = soVanban;
    }

    public String getNgayKy() {
        return ngayKy;
    }

    public void setNgayKy(String ngayKy) {
        this.ngayKy = ngayKy;
    }

    public String getLinhVuc() {
        return linhVuc;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNguoiKy() {
        return nguoiKy;
    }

    public void setNguoiKy(String nguoiKy) {
        this.nguoiKy = nguoiKy;
    }

    public String getNguoiNhap() {
        return nguoiNhap;
    }

    public void setNguoiNhap(String nguoiNhap) {
        this.nguoiNhap = nguoiNhap;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public List<SoDen> getSoDens() {
        return soDens;
    }

    public void setSoDens(List<SoDen> soDens) {
        this.soDens = soDens;
    }

    public List<QuaTrinhXuly> getQuaTrinhXulys() {
        return quaTrinhXulys;
    }

    public void setQuaTrinhXulys(List<QuaTrinhXuly> quaTrinhXulys) {
        this.quaTrinhXulys = quaTrinhXulys;
    }

    public List<PhoHopXuly> getPhoHopXulys() {
        return phoHopXulys;
    }

    public void setPhoHopXulys(List<PhoHopXuly> phoHopXulys) {
        this.phoHopXulys = phoHopXulys;
    }

    public List<TepDinhKemVanBanDi> getTepDinhKems() {
        return tepDinhKems;
    }

    public void setTepDinhKems(List<TepDinhKemVanBanDi> tepDinhKems) {
        this.tepDinhKems = tepDinhKems;
    }
}
