package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class DSVB_QuaHan implements Serializable {

    @SerializedName("id_van_ban")
    @Expose
    private Integer idVanBan;
    @SerializedName("stt")
    @Expose
    private Integer stt;
    @SerializedName("ngay_nhap")
    @Expose
    private String ngayNhap;
    @SerializedName("so_den")
    @Expose
    private Integer soDen;
    @SerializedName("so_ky_hieu")
    @Expose
    private String soKyHieu;
    @SerializedName("noi_gui")
    @Expose
    private String noiGui;
    @SerializedName("trich_yeu")
    @Expose
    private String trichYeu;
    @SerializedName("loai_vanban")
    @Expose
    private String loaiVanban;
    @SerializedName("ngay_ky")
    @Expose
    private String ngayKy;
    @SerializedName("han_xu_ly")
    @Expose
    private String hanXuLy;
    @SerializedName("trinh_tu_kys")
    @Expose
    private List<TrinhTuKy> trinhTuKys = null;
    @SerializedName("tai_lieus")
    @Expose
    private List<String> taiLieus = null;
    @SerializedName("allow_themhan")
    @Expose
    private Boolean allowThemhan;
    @SerializedName("allow_tuchoi")
    @Expose
    private Boolean allowTuchoi;
    @SerializedName("allow_tuchoitp")
    @Expose
    private Boolean allowTuchoitp;
    @SerializedName("allow_tuchoicct")
    @Expose
    private Boolean allowTuchoicct;

    public Integer getIdVanBan() {
        return idVanBan;
    }

    public void setIdVanBan(Integer idVanBan) {
        this.idVanBan = idVanBan;
    }

    public Integer getStt() {
        return stt;
    }

    public void setStt(Integer stt) {
        this.stt = stt;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public Integer getSoDen() {
        return soDen;
    }

    public void setSoDen(Integer soDen) {
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

    public String getTrichYeu() {
        return trichYeu;
    }

    public void setTrichYeu(String trichYeu) {
        this.trichYeu = trichYeu;
    }

    public String getLoaiVanban() {
        return loaiVanban;
    }

    public void setLoaiVanban(String loaiVanban) {
        this.loaiVanban = loaiVanban;
    }

    public String getNgayKy() {
        return ngayKy;
    }

    public void setNgayKy(String ngayKy) {
        this.ngayKy = ngayKy;
    }

    public String getHanXuLy() {
        return hanXuLy;
    }

    public void setHanXuLy(String hanXuLy) {
        this.hanXuLy = hanXuLy;
    }

    public List<TrinhTuKy> getTrinhTuKys() {
        return trinhTuKys;
    }

    public void setTrinhTuKys(List<TrinhTuKy> trinhTuKys) {
        this.trinhTuKys = trinhTuKys;
    }

    public List<String> getTaiLieus() {
        return taiLieus;
    }

    public void setTaiLieus(List<String> taiLieus) {
        this.taiLieus = taiLieus;
    }

    public Boolean getAllowThemhan() {
        return allowThemhan;
    }

    public void setAllowThemhan(Boolean allowThemhan) {
        this.allowThemhan = allowThemhan;
    }

    public Boolean getAllowTuchoi() {
        return allowTuchoi;
    }

    public void setAllowTuchoi(Boolean allowTuchoi) {
        this.allowTuchoi = allowTuchoi;
    }

    public Boolean getAllowTuchoitp() {
        return allowTuchoitp;
    }

    public void setAllowTuchoitp(Boolean allowTuchoitp) {
        this.allowTuchoitp = allowTuchoitp;
    }

    public Boolean getAllowTuchoicct() {
        return allowTuchoicct;
    }

    public void setAllowTuchoicct(Boolean allowTuchoicct) {
        this.allowTuchoicct = allowTuchoicct;
    }
}
