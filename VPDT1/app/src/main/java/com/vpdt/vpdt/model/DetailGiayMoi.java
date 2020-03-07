package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailGiayMoi {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("is_vb_qppl")
    @Expose
    private Boolean isVbQppl;
    @SerializedName("is_stc_chutri")
    @Expose
    private Boolean isStcChutri;
    @SerializedName("is_tbkl")
    @Expose
    private Boolean isTbkl;
    @SerializedName("khu_vuc")
    @Expose
    private String khuVuc;
    @SerializedName("noi_gui_den")
    @Expose
    private String noiGuiDen;
    @SerializedName("so_kyhieu")
    @Expose
    private String soKyhieu;
    @SerializedName("ngay_ky")
    @Expose
    private String ngayKy;
    @SerializedName("loai_vanban")
    @Expose
    private String loaiVanban;
    @SerializedName("linh_vuc")
    @Expose
    private String linhVuc;
    @SerializedName("trich_yeu")
    @Expose
    private String trichYeu;
    @SerializedName("giay_moi_ngay")
    @Expose
    private String giayMoiNgay;
    @SerializedName("giay_moi_gio")
    @Expose
    private String giayMoiGio;
    @SerializedName("giay_dia_diem")
    @Expose
    private String giayDiaDiem;
    @SerializedName("nguoi_chu_tri")
    @Expose
    private String nguoiChuTri;
    @SerializedName("noi_dung")
    @Expose
    private String noiDung;
    @SerializedName("nguoi_ky")
    @Expose
    private String nguoiKy;
    @SerializedName("ngay_nhan")
    @Expose
    private String ngayNhan;
    @SerializedName("chuc_vu")
    @Expose
    private String chucVu;
    @SerializedName("han_giai_quet")
    @Expose
    private String hanGiaiQuet;
    @SerializedName("so_den")
    @Expose
    private String soDen;
    @SerializedName("do_mat")
    @Expose
    private String doMat;
    @SerializedName("do_mat2")
    @Expose
    private String doMat2;
    @SerializedName("so_trang")
    @Expose
    private String soTrang;
    @SerializedName("trinh_tu_giai_quyets")
    @Expose
    private List<TrinhTuGiaiQuyetGiayMoi> trinhTuGiaiQuyets = null;
    @SerializedName("tep_dinh_kems")
    @Expose
    private List<TepDinhKem> tepDinhKems = null;
    @SerializedName("chuyen_nhan_luu_vets")
    @Expose
    private List<ChuyenNhanLuuVet> chuyenNhanLuuVets = null;
    @SerializedName("ketqua_giaiquyet_phong_phoihops")
    @Expose
    private List<KetquaGiaiquyetPhongPhoihop> ketquaGiaiquyetPhongPhoihops = null;
    @SerializedName("ketqua_giaiquyet_phong_thulys")
    @Expose
    private List<KetquaGiaiquyetPhongThuly> ketquaGiaiquyetPhongThulys = null;
    @SerializedName("hoan_thanh_luu_vets")
    @Expose
    private List<HoanThanhLuuVet> hoanThanhLuuVets = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsVbQppl() {
        return isVbQppl;
    }

    public void setIsVbQppl(Boolean isVbQppl) {
        this.isVbQppl = isVbQppl;
    }

    public Boolean getIsStcChutri() {
        return isStcChutri;
    }

    public void setIsStcChutri(Boolean isStcChutri) {
        this.isStcChutri = isStcChutri;
    }

    public Boolean getIsTbkl() {
        return isTbkl;
    }

    public void setIsTbkl(Boolean isTbkl) {
        this.isTbkl = isTbkl;
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

    public String getSoKyhieu() {
        return soKyhieu;
    }

    public void setSoKyhieu(String soKyhieu) {
        this.soKyhieu = soKyhieu;
    }

    public String getNgayKy() {
        return ngayKy;
    }

    public void setNgayKy(String ngayKy) {
        this.ngayKy = ngayKy;
    }

    public String getLoaiVanban() {
        return loaiVanban;
    }

    public void setLoaiVanban(String loaiVanban) {
        this.loaiVanban = loaiVanban;
    }

    public String getLinhVuc() {
        return linhVuc;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }

    public String getTrichYeu() {
        return trichYeu;
    }

    public void setTrichYeu(String trichYeu) {
        this.trichYeu = trichYeu;
    }

    public String getGiayMoiNgay() {
        return giayMoiNgay;
    }

    public void setGiayMoiNgay(String giayMoiNgay) {
        this.giayMoiNgay = giayMoiNgay;
    }

    public String getGiayMoiGio() {
        return giayMoiGio;
    }

    public void setGiayMoiGio(String giayMoiGio) {
        this.giayMoiGio = giayMoiGio;
    }

    public String getGiayDiaDiem() {
        return giayDiaDiem;
    }

    public void setGiayDiaDiem(String giayDiaDiem) {
        this.giayDiaDiem = giayDiaDiem;
    }

    public String getNguoiChuTri() {
        return nguoiChuTri;
    }

    public void setNguoiChuTri(String nguoiChuTri) {
        this.nguoiChuTri = nguoiChuTri;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNguoiKy() {
        return nguoiKy;
    }

    public void setNguoiKy(String nguoiKy) {
        this.nguoiKy = nguoiKy;
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

    public String getHanGiaiQuet() {
        return hanGiaiQuet;
    }

    public void setHanGiaiQuet(String hanGiaiQuet) {
        this.hanGiaiQuet = hanGiaiQuet;
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

    public String getDoMat2() {
        return doMat2;
    }

    public void setDoMat2(String doMat2) {
        this.doMat2 = doMat2;
    }

    public String getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(String soTrang) {
        this.soTrang = soTrang;
    }

    public List<TrinhTuGiaiQuyetGiayMoi> getTrinhTuGiaiQuyets() {
        return trinhTuGiaiQuyets;
    }

    public void setTrinhTuGiaiQuyets(List<TrinhTuGiaiQuyetGiayMoi> trinhTuGiaiQuyets) {
        this.trinhTuGiaiQuyets = trinhTuGiaiQuyets;
    }

    public List<TepDinhKem> getTepDinhKems() {
        return tepDinhKems;
    }

    public void setTepDinhKems(List<TepDinhKem> tepDinhKems) {
        this.tepDinhKems = tepDinhKems;
    }

    public List<ChuyenNhanLuuVet> getChuyenNhanLuuVets() {
        return chuyenNhanLuuVets;
    }

    public void setChuyenNhanLuuVets(List<ChuyenNhanLuuVet> chuyenNhanLuuVets) {
        this.chuyenNhanLuuVets = chuyenNhanLuuVets;
    }

    public List<KetquaGiaiquyetPhongPhoihop> getKetquaGiaiquyetPhongPhoihops() {
        return ketquaGiaiquyetPhongPhoihops;
    }

    public void setKetquaGiaiquyetPhongPhoihops(List<KetquaGiaiquyetPhongPhoihop> ketquaGiaiquyetPhongPhoihops) {
        this.ketquaGiaiquyetPhongPhoihops = ketquaGiaiquyetPhongPhoihops;
    }

    public List<KetquaGiaiquyetPhongThuly> getKetquaGiaiquyetPhongThulys() {
        return ketquaGiaiquyetPhongThulys;
    }

    public void setKetquaGiaiquyetPhongThulys(List<KetquaGiaiquyetPhongThuly> ketquaGiaiquyetPhongThulys) {
        this.ketquaGiaiquyetPhongThulys = ketquaGiaiquyetPhongThulys;
    }

    public List<HoanThanhLuuVet> getHoanThanhLuuVets() {
        return hoanThanhLuuVets;
    }

    public void setHoanThanhLuuVets(List<HoanThanhLuuVet> hoanThanhLuuVets) {
        this.hoanThanhLuuVets = hoanThanhLuuVets;
    }
}
