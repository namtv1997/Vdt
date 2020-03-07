package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhongChuTriDaChiDao implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("soKyHieu")
    @Expose
    private String soKyHieu;
    @SerializedName("soDen")
    @Expose
    private String soDen;
    @SerializedName("noiGui")
    @Expose
    private String noiGui;
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
    @SerializedName("hanGiaiQuyet")
    @Expose
    private String hanGiaiQuyet;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("vanBanQuanTrong")
    @Expose
    private Boolean vanBanQuanTrong;
    @SerializedName("idPhoPhong")
    @Expose
    private Integer idPhoPhong;
    @SerializedName("tenPhoPhong")
    @Expose
    private String tenPhoPhong;
    @SerializedName("idChuyenVien")
    @Expose
    private Integer idChuyenVien;
    @SerializedName("tenChuyenVien")
    @Expose
    private String tenChuyenVien;
    @SerializedName("phoGiamDocDonDoc")
    @Expose
    private Boolean phoGiamDocDonDoc;
    @SerializedName("chiDao")
    @Expose
    private String chiDao;
    @SerializedName("chiDaoChuTri")
    @Expose
    private String chiDaoChuTri;
    @SerializedName("idPhoPhongPhoiHops")
    @Expose
    private String idPhoPhongPhoiHops;
    @SerializedName("idChuyenVienPhoiHops")
    @Expose
    private String idChuyenVienPhoiHops;
    @SerializedName("vanBanDauRaTruongPhong")
    @Expose
    private String vanBanDauRaTruongPhong;

    protected PhongChuTriDaChiDao(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        ngayNhap = in.readString();
        moTa = in.readString();
        soKyHieu = in.readString();
        soDen = in.readString();
        noiGui = in.readString();
        noiDung = in.readString();
        hanGiaiQuyet = in.readString();
        urlFile = in.readString();
        byte tmpVanBanQuanTrong = in.readByte();
        vanBanQuanTrong = tmpVanBanQuanTrong == 0 ? null : tmpVanBanQuanTrong == 1;
        if (in.readByte() == 0) {
            idPhoPhong = null;
        } else {
            idPhoPhong = in.readInt();
        }
        tenPhoPhong = in.readString();
        if (in.readByte() == 0) {
            idChuyenVien = null;
        } else {
            idChuyenVien = in.readInt();
        }
        tenChuyenVien = in.readString();
        byte tmpPhoGiamDocDonDoc = in.readByte();
        phoGiamDocDonDoc = tmpPhoGiamDocDonDoc == 0 ? null : tmpPhoGiamDocDonDoc == 1;
        chiDao = in.readString();
        chiDaoChuTri = in.readString();
        idPhoPhongPhoiHops = in.readString();
        idChuyenVienPhoiHops = in.readString();
        vanBanDauRaTruongPhong = in.readString();
    }

    public static final Creator<PhongChuTriDaChiDao> CREATOR = new Creator<PhongChuTriDaChiDao>() {
        @Override
        public PhongChuTriDaChiDao createFromParcel(Parcel in) {
            return new PhongChuTriDaChiDao(in);
        }

        @Override
        public PhongChuTriDaChiDao[] newArray(int size) {
            return new PhongChuTriDaChiDao[size];
        }
    };

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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getSoKyHieu() {
        return soKyHieu;
    }

    public void setSoKyHieu(String soKyHieu) {
        this.soKyHieu = soKyHieu;
    }

    public String getSoDen() {
        return soDen;
    }

    public void setSoDen(String soDen) {
        this.soDen = soDen;
    }

    public String getNoiGui() {
        return noiGui;
    }

    public void setNoiGui(String noiGui) {
        this.noiGui = noiGui;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getHanGiaiQuyet() {
        return hanGiaiQuyet;
    }

    public void setHanGiaiQuyet(String hanGiaiQuyet) {
        this.hanGiaiQuyet = hanGiaiQuyet;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public Boolean getVanBanQuanTrong() {
        return vanBanQuanTrong;
    }

    public void setVanBanQuanTrong(Boolean vanBanQuanTrong) {
        this.vanBanQuanTrong = vanBanQuanTrong;
    }

    public Integer getIdPhoPhong() {
        return idPhoPhong;
    }

    public void setIdPhoPhong(Integer idPhoPhong) {
        this.idPhoPhong = idPhoPhong;
    }

    public String getTenPhoPhong() {
        return tenPhoPhong;
    }

    public void setTenPhoPhong(String tenPhoPhong) {
        this.tenPhoPhong = tenPhoPhong;
    }

    public Integer getIdChuyenVien() {
        return idChuyenVien;
    }

    public void setIdChuyenVien(Integer idChuyenVien) {
        this.idChuyenVien = idChuyenVien;
    }

    public String getTenChuyenVien() {
        return tenChuyenVien;
    }

    public void setTenChuyenVien(String tenChuyenVien) {
        this.tenChuyenVien = tenChuyenVien;
    }

    public Boolean getPhoGiamDocDonDoc() {
        return phoGiamDocDonDoc;
    }

    public void setPhoGiamDocDonDoc(Boolean phoGiamDocDonDoc) {
        this.phoGiamDocDonDoc = phoGiamDocDonDoc;
    }

    public String getChiDao() {
        return chiDao;
    }

    public void setChiDao(String chiDao) {
        this.chiDao = chiDao;
    }

    public String getChiDaoChuTri() {
        return chiDaoChuTri;
    }

    public void setChiDaoChuTri(String chiDaoChuTri) {
        this.chiDaoChuTri = chiDaoChuTri;
    }

    public String getIdPhoPhongPhoiHops() {
        return idPhoPhongPhoiHops;
    }

    public void setIdPhoPhongPhoiHops(String idPhoPhongPhoiHops) {
        this.idPhoPhongPhoiHops = idPhoPhongPhoiHops;
    }

    public String getIdChuyenVienPhoiHops() {
        return idChuyenVienPhoiHops;
    }

    public void setIdChuyenVienPhoiHops(String idChuyenVienPhoiHops) {
        this.idChuyenVienPhoiHops = idChuyenVienPhoiHops;
    }

    public String getVanBanDauRaTruongPhong() {
        return vanBanDauRaTruongPhong;
    }

    public void setVanBanDauRaTruongPhong(String vanBanDauRaTruongPhong) {
        this.vanBanDauRaTruongPhong = vanBanDauRaTruongPhong;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(ngayNhap);
        dest.writeString(moTa);
        dest.writeString(soKyHieu);
        dest.writeString(soDen);
        dest.writeString(noiGui);
        dest.writeString(noiDung);
        dest.writeString(hanGiaiQuyet);
        dest.writeString(urlFile);
        dest.writeByte((byte) (vanBanQuanTrong == null ? 0 : vanBanQuanTrong ? 1 : 2));
        if (idPhoPhong == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idPhoPhong);
        }
        dest.writeString(tenPhoPhong);
        if (idChuyenVien == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idChuyenVien);
        }
        dest.writeString(tenChuyenVien);
        dest.writeByte((byte) (phoGiamDocDonDoc == null ? 0 : phoGiamDocDonDoc ? 1 : 2));
        dest.writeString(chiDao);
        dest.writeString(chiDaoChuTri);
        dest.writeString(idPhoPhongPhoiHops);
        dest.writeString(idChuyenVienPhoiHops);
        dest.writeString(vanBanDauRaTruongPhong);
    }
}
