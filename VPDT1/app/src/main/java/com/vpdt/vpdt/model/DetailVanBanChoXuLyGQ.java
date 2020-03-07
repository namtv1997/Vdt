package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailVanBanChoXuLyGQ {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("khuVuc")
    @Expose
    private String khuVuc;
    @SerializedName("noiGuiDen")
    @Expose
    private String noiGuiDen;
    @SerializedName("soKyHieu")
    @Expose
    private String soKyHieu;
    @SerializedName("ngayKy")
    @Expose
    private String ngayKy;
    @SerializedName("loaiVanBan")
    @Expose
    private String loaiVanBan;
    @SerializedName("linhVuc")
    @Expose
    private String linhVuc;
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("tenNguoiKy")
    @Expose
    private String tenNguoiKy;
    @SerializedName("ngayNhan")
    @Expose
    private String ngayNhan;
    @SerializedName("chucVu")
    @Expose
    private String chucVu;
    @SerializedName("hanGiaiQuyet")
    @Expose
    private String hanGiaiQuyet;
    @SerializedName("giayMoiDiaDiem")
    @Expose
    private String giayMoiDiaDiem;
    @SerializedName("giayMoiGio")
    @Expose
    private String giayMoiGio;
    @SerializedName("giayMoiNgay")
    @Expose
    private String giayMoiNgay;
    @SerializedName("soDen")
    @Expose
    private String soDen;
    @SerializedName("doMat")
    @Expose
    private String doMat;
    @SerializedName("doKhan")
    @Expose
    private String doKhan;
    @SerializedName("showFrom")
    @Expose
    private Boolean showFrom;
    @SerializedName("trinhTuGiaiQuyets")
    @Expose
    private List<TrinhTuGiaiQuyetPPH> trinhTuGiaiQuyets = null;
    @SerializedName("tepTinVanBanDens")
    @Expose
    private List<TepTinVanBanDen> tepTinVanBanDens = null;
    @SerializedName("ketQuaGiaiQuyetPhongThuLys")
    @Expose
    private List<KetQuaGiaiQuyetPhongThuLy1> ketQuaGiaiQuyetPhongThuLys = null;
    @SerializedName("ketQuaGiaiQuyetPhongPhoiHops")
    @Expose
    private List<KetQuaGiaiQuyetPhongPhoiHop1> ketQuaGiaiQuyetPhongPhoiHops = null;
    @SerializedName("lyDoChamMuonPhongThuLys")
    @Expose
    private List<LyDoChamMuonPhongThuLy> lyDoChamMuonPhongThuLys = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(String khuVuc) {
        this.khuVuc = khuVuc;
    }

    public String getNoiGuiDen() {
        return noiGuiDen;
    }

    public void setNoiGuiDen(String noiGuiDen) {
        this.noiGuiDen = noiGuiDen;
    }

    public String getSoKyHieu() {
        return soKyHieu;
    }

    public void setSoKyHieu(String soKyHieu) {
        this.soKyHieu = soKyHieu;
    }

    public String getNgayKy() {
        return ngayKy;
    }

    public void setNgayKy(String ngayKy) {
        this.ngayKy = ngayKy;
    }

    public String getLoaiVanBan() {
        return loaiVanBan;
    }

    public void setLoaiVanBan(String loaiVanBan) {
        this.loaiVanBan = loaiVanBan;
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

    public String getTenNguoiKy() {
        return tenNguoiKy;
    }

    public void setTenNguoiKy(String tenNguoiKy) {
        this.tenNguoiKy = tenNguoiKy;
    }

    public String getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(String ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getHanGiaiQuyet() {
        return hanGiaiQuyet;
    }

    public void setHanGiaiQuyet(String hanGiaiQuyet) {
        this.hanGiaiQuyet = hanGiaiQuyet;
    }

    public String getGiayMoiDiaDiem() {
        return giayMoiDiaDiem;
    }

    public void setGiayMoiDiaDiem(String giayMoiDiaDiem) {
        this.giayMoiDiaDiem = giayMoiDiaDiem;
    }

    public String getGiayMoiGio() {
        return giayMoiGio;
    }

    public void setGiayMoiGio(String giayMoiGio) {
        this.giayMoiGio = giayMoiGio;
    }

    public String getGiayMoiNgay() {
        return giayMoiNgay;
    }

    public void setGiayMoiNgay(String giayMoiNgay) {
        this.giayMoiNgay = giayMoiNgay;
    }

    public String getSoDen() {
        return soDen;
    }

    public void setSoDen(String soDen) {
        this.soDen = soDen;
    }

    public String getDoMat() {
        return doMat;
    }

    public void setDoMat(String doMat) {
        this.doMat = doMat;
    }

    public String getDoKhan() {
        return doKhan;
    }

    public void setDoKhan(String doKhan) {
        this.doKhan = doKhan;
    }

    public Boolean getShowFrom() {
        return showFrom;
    }

    public void setShowFrom(Boolean showFrom) {
        this.showFrom = showFrom;
    }

    public List<TrinhTuGiaiQuyetPPH> getTrinhTuGiaiQuyets() {
        return trinhTuGiaiQuyets;
    }

    public void setTrinhTuGiaiQuyets(List<TrinhTuGiaiQuyetPPH> trinhTuGiaiQuyets) {
        this.trinhTuGiaiQuyets = trinhTuGiaiQuyets;
    }

    public List<TepTinVanBanDen> getTepTinVanBanDens() {
        return tepTinVanBanDens;
    }

    public void setTepTinVanBanDens(List<TepTinVanBanDen> tepTinVanBanDens) {
        this.tepTinVanBanDens = tepTinVanBanDens;
    }

    public List<KetQuaGiaiQuyetPhongThuLy1> getKetQuaGiaiQuyetPhongThuLys() {
        return ketQuaGiaiQuyetPhongThuLys;
    }

    public void setKetQuaGiaiQuyetPhongThuLys(List<KetQuaGiaiQuyetPhongThuLy1> ketQuaGiaiQuyetPhongThuLys) {
        this.ketQuaGiaiQuyetPhongThuLys = ketQuaGiaiQuyetPhongThuLys;
    }

    public List<KetQuaGiaiQuyetPhongPhoiHop1> getKetQuaGiaiQuyetPhongPhoiHops() {
        return ketQuaGiaiQuyetPhongPhoiHops;
    }

    public void setKetQuaGiaiQuyetPhongPhoiHops(List<KetQuaGiaiQuyetPhongPhoiHop1> ketQuaGiaiQuyetPhongPhoiHops) {
        this.ketQuaGiaiQuyetPhongPhoiHops = ketQuaGiaiQuyetPhongPhoiHops;
    }

    public List<LyDoChamMuonPhongThuLy> getLyDoChamMuonPhongThuLys() {
        return lyDoChamMuonPhongThuLys;
    }

    public void setLyDoChamMuonPhongThuLys(List<LyDoChamMuonPhongThuLy> lyDoChamMuonPhongThuLys) {
        this.lyDoChamMuonPhongThuLys = lyDoChamMuonPhongThuLys;
    }
}
