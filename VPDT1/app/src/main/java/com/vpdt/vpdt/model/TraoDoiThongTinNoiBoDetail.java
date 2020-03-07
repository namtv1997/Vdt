package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TraoDoiThongTinNoiBoDetail {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ngay_nhap")
    @Expose
    private String ngayNhap;
    @SerializedName("nguoi_nhap")
    @Expose
    private String nguoiNhap;
    @SerializedName("so_kyhieu")
    @Expose
    private String soKyhieu;
    @SerializedName("loai_vanban")
    @Expose
    private String loaiVanban;
    @SerializedName("nguoi_ky")
    @Expose
    private String nguoiKy;
    @SerializedName("trich_yeu")
    @Expose
    private String trichYeu;
    @SerializedName("ykien_chidao")
    @Expose
    private String ykienChidao;
    @SerializedName("ghi_chu")
    @Expose
    private String ghiChu;
    @SerializedName("ngay_ky")
    @Expose
    private String ngayKy;
    @SerializedName("han_traloi")
    @Expose
    private String hanTraloi;
    @SerializedName("file_dinh_kems")
    @Expose
    private List<FileDinhKem> fileDinhKems = null;
    @SerializedName("van_ban_tra_lois")
    @Expose
    private List<VanBanTraLoi> vanBanTraLois = null;
    @SerializedName("ykien_phan_hois")
    @Expose
    private List<YkienPhanHoi> ykienPhanHois = null;

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

    public String getNguoiNhap() {
        return nguoiNhap;
    }

    public void setNguoiNhap(String nguoiNhap) {
        this.nguoiNhap = nguoiNhap;
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

    public String getNguoiKy() {
        return nguoiKy;
    }

    public void setNguoiKy(String nguoiKy) {
        this.nguoiKy = nguoiKy;
    }

    public String getTrichYeu() {
        return trichYeu;
    }

    public void setTrichYeu(String trichYeu) {
        this.trichYeu = trichYeu;
    }

    public String getYkienChidao() {
        return ykienChidao;
    }

    public void setYkienChidao(String ykienChidao) {
        this.ykienChidao = ykienChidao;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getNgayKy() {
        return ngayKy;
    }

    public void setNgayKy(String ngayKy) {
        this.ngayKy = ngayKy;
    }

    public String getHanTraloi() {
        return hanTraloi;
    }

    public void setHanTraloi(String hanTraloi) {
        this.hanTraloi = hanTraloi;
    }

    public List<FileDinhKem> getFileDinhKems() {
        return fileDinhKems;
    }

    public void setFileDinhKems(List<FileDinhKem> fileDinhKems) {
        this.fileDinhKems = fileDinhKems;
    }

    public List<VanBanTraLoi> getVanBanTraLois() {
        return vanBanTraLois;
    }

    public void setVanBanTraLois(List<VanBanTraLoi> vanBanTraLois) {
        this.vanBanTraLois = vanBanTraLois;
    }

    public List<YkienPhanHoi> getYkienPhanHois() {
        return ykienPhanHois;
    }

    public void setYkienPhanHois(List<YkienPhanHoi> ykienPhanHois) {
        this.ykienPhanHois = ykienPhanHois;
    }
}
