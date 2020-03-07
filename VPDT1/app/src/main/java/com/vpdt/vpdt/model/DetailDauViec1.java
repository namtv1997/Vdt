package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailDauViec1 {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("soKyHieu")
    @Expose
    private String soKyHieu;
    @SerializedName("loaiVanBan")
    @Expose
    private String loaiVanBan;
    @SerializedName("ngayVanBan")
    @Expose
    private String ngayVanBan;
    @SerializedName("fileVanBan")
    @Expose
    private String fileVanBan;
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
    @SerializedName("ketLuan")
    @Expose
    private String ketLuan;
    @SerializedName("lanhDaoChuTri")
    @Expose
    private String lanhDaoChuTri;
    @SerializedName("nguoiKy")
    @Expose
    private String nguoiKy;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;
    @SerializedName("roots")
    @Expose
    private List<Root> roots = null;
    @SerializedName("trangThai")
    @Expose
    private Integer trangThai;
    @SerializedName("trinhTuGiaiQuyets")
    @Expose
    private List<TrinhTuGiaiQuyetDauViec1> trinhTuGiaiQuyets = null;
    @SerializedName("trinhTuDeXuatHans")
    @Expose
    private List<TrinhTuDeXuatHan1> trinhTuDeXuatHans = null;
    @SerializedName("ketQuaGiaiQuyets")
    @Expose
    private List<KetQuaGiaiQuyet1> ketQuaGiaiQuyets = null;
    @SerializedName("ketQuaPhoiHops")
    @Expose
    private List<KetQuaPhoiHop1> ketQuaPhoiHops = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSoKyHieu() {
        return soKyHieu;
    }

    public void setSoKyHieu(String soKyHieu) {
        this.soKyHieu = soKyHieu;
    }

    public String getLoaiVanBan() {
        return loaiVanBan;
    }

    public void setLoaiVanBan(String loaiVanBan) {
        this.loaiVanBan = loaiVanBan;
    }

    public String getNgayVanBan() {
        return ngayVanBan;
    }

    public void setNgayVanBan(String ngayVanBan) {
        this.ngayVanBan = ngayVanBan;
    }

    public String getFileVanBan() {
        return fileVanBan;
    }

    public void setFileVanBan(String fileVanBan) {
        this.fileVanBan = fileVanBan;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getKetLuan() {
        return ketLuan;
    }

    public void setKetLuan(String ketLuan) {
        this.ketLuan = ketLuan;
    }

    public String getLanhDaoChuTri() {
        return lanhDaoChuTri;
    }

    public void setLanhDaoChuTri(String lanhDaoChuTri) {
        this.lanhDaoChuTri = lanhDaoChuTri;
    }

    public String getNguoiKy() {
        return nguoiKy;
    }

    public void setNguoiKy(String nguoiKy) {
        this.nguoiKy = nguoiKy;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public List<Root> getRoots() {
        return roots;
    }

    public void setRoots(List<Root> roots) {
        this.roots = roots;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public List<TrinhTuGiaiQuyetDauViec1> getTrinhTuGiaiQuyets() {
        return trinhTuGiaiQuyets;
    }

    public void setTrinhTuGiaiQuyets(List<TrinhTuGiaiQuyetDauViec1> trinhTuGiaiQuyets) {
        this.trinhTuGiaiQuyets = trinhTuGiaiQuyets;
    }

    public List<TrinhTuDeXuatHan1> getTrinhTuDeXuatHans() {
        return trinhTuDeXuatHans;
    }

    public void setTrinhTuDeXuatHans(List<TrinhTuDeXuatHan1> trinhTuDeXuatHans) {
        this.trinhTuDeXuatHans = trinhTuDeXuatHans;
    }

    public List<KetQuaGiaiQuyet1> getKetQuaGiaiQuyets() {
        return ketQuaGiaiQuyets;
    }

    public void setKetQuaGiaiQuyets(List<KetQuaGiaiQuyet1> ketQuaGiaiQuyets) {
        this.ketQuaGiaiQuyets = ketQuaGiaiQuyets;
    }

    public List<KetQuaPhoiHop1> getKetQuaPhoiHops() {
        return ketQuaPhoiHops;
    }

    public void setKetQuaPhoiHops(List<KetQuaPhoiHop1> ketQuaPhoiHops) {
        this.ketQuaPhoiHops = ketQuaPhoiHops;
    }
}
