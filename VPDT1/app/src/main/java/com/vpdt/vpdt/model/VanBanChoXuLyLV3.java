package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VanBanChoXuLyLV3 implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;
    @SerializedName("soDen")
    @Expose
    private String soDen;
    @SerializedName("soKyHieu")
    @Expose
    private String soKyHieu;
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("noiDungVanBan")
    @Expose
    private String noiDungVanBan;
    @SerializedName("giayMoiGio")
    @Expose
    private String giayMoiGio;
    @SerializedName("giayMoiNgay")
    @Expose
    private String giayMoiNgay;
    @SerializedName("giayMoiDiaDiem")
    @Expose
    private String giayMoiDiaDiem;
    @SerializedName("noiGui")
    @Expose
    private String noiGui;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("canBoChiDao")
    @Expose
    private String canBoChiDao;
    @SerializedName("noiDungChiDao")
    @Expose
    private String noiDungChiDao;
    @SerializedName("idPhoPhong")
    @Expose
    private Integer idPhoPhong;
    @SerializedName("tenPhoPhong")
    @Expose
    private String tenPhoPhong;
    @SerializedName("chiDaoPhoPhong")
    @Expose
    private String chiDaoPhoPhong;
    @SerializedName("idPhoPhongPhoiHops")
    @Expose
    private String idPhoPhongPhoiHops;
    @SerializedName("chiDaoPhoPhongPhoiHops")
    @Expose
    private String chiDaoPhoPhongPhoiHops;
    @SerializedName("idChuyenVien")
    @Expose
    private Integer idChuyenVien;
    @SerializedName("tenChuyenVien")
    @Expose
    private String tenChuyenVien;
    @SerializedName("chiDaoChuyenVien")
    @Expose
    private String chiDaoChuyenVien;
    @SerializedName("idChuyenVienPhoiHops")
    @Expose
    private String idChuyenVienPhoiHops;
    @SerializedName("chiDaoChuyenVienPhoiHops")
    @Expose
    private String chiDaoChuyenVienPhoiHops;
    @SerializedName("hanGiaiQuyet")
    @Expose
    private String hanGiaiQuyet;

    protected VanBanChoXuLyLV3(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        ngayNhap = in.readString();
        soDen = in.readString();
        soKyHieu = in.readString();
        moTa = in.readString();
        noiDungVanBan = in.readString();
        giayMoiGio = in.readString();
        giayMoiNgay = in.readString();
        giayMoiDiaDiem = in.readString();
        noiGui = in.readString();
        urlFile = in.readString();
        canBoChiDao = in.readString();
        noiDungChiDao = in.readString();
        if (in.readByte() == 0) {
            idPhoPhong = null;
        } else {
            idPhoPhong = in.readInt();
        }
        tenPhoPhong = in.readString();
        chiDaoPhoPhong = in.readString();
        idPhoPhongPhoiHops = in.readString();
        chiDaoPhoPhongPhoiHops = in.readString();
        if (in.readByte() == 0) {
            idChuyenVien = null;
        } else {
            idChuyenVien = in.readInt();
        }
        tenChuyenVien = in.readString();
        chiDaoChuyenVien = in.readString();
        idChuyenVienPhoiHops = in.readString();
        chiDaoChuyenVienPhoiHops = in.readString();
        hanGiaiQuyet = in.readString();
    }

    public static final Creator<VanBanChoXuLyLV3> CREATOR = new Creator<VanBanChoXuLyLV3>() {
        @Override
        public VanBanChoXuLyLV3 createFromParcel(Parcel in) {
            return new VanBanChoXuLyLV3(in);
        }

        @Override
        public VanBanChoXuLyLV3[] newArray(int size) {
            return new VanBanChoXuLyLV3[size];
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

    public String getSoDen() {
        return soDen;
    }

    public void setSoDen(String soDen) {
        this.soDen = soDen;
    }

    public String getSoKyHieu() {
        return soKyHieu;
    }

    public void setSoKyHieu(String soKyHieu) {
        this.soKyHieu = soKyHieu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNoiDungVanBan() {
        return noiDungVanBan;
    }

    public void setNoiDungVanBan(String noiDungVanBan) {
        this.noiDungVanBan = noiDungVanBan;
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

    public String getGiayMoiDiaDiem() {
        return giayMoiDiaDiem;
    }

    public void setGiayMoiDiaDiem(String giayMoiDiaDiem) {
        this.giayMoiDiaDiem = giayMoiDiaDiem;
    }

    public String getNoiGui() {
        return noiGui;
    }

    public void setNoiGui(String noiGui) {
        this.noiGui = noiGui;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public String getCanBoChiDao() {
        return canBoChiDao;
    }

    public void setCanBoChiDao(String canBoChiDao) {
        this.canBoChiDao = canBoChiDao;
    }

    public String getNoiDungChiDao() {
        return noiDungChiDao;
    }

    public void setNoiDungChiDao(String noiDungChiDao) {
        this.noiDungChiDao = noiDungChiDao;
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

    public String getChiDaoPhoPhong() {
        return chiDaoPhoPhong;
    }

    public void setChiDaoPhoPhong(String chiDaoPhoPhong) {
        this.chiDaoPhoPhong = chiDaoPhoPhong;
    }

    public String getIdPhoPhongPhoiHops() {
        return idPhoPhongPhoiHops;
    }

    public void setIdPhoPhongPhoiHops(String idPhoPhongPhoiHops) {
        this.idPhoPhongPhoiHops = idPhoPhongPhoiHops;
    }

    public String getChiDaoPhoPhongPhoiHops() {
        return chiDaoPhoPhongPhoiHops;
    }

    public void setChiDaoPhoPhongPhoiHops(String chiDaoPhoPhongPhoiHops) {
        this.chiDaoPhoPhongPhoiHops = chiDaoPhoPhongPhoiHops;
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

    public String getChiDaoChuyenVien() {
        return chiDaoChuyenVien;
    }

    public void setChiDaoChuyenVien(String chiDaoChuyenVien) {
        this.chiDaoChuyenVien = chiDaoChuyenVien;
    }

    public String getIdChuyenVienPhoiHops() {
        return idChuyenVienPhoiHops;
    }

    public void setIdChuyenVienPhoiHops(String idChuyenVienPhoiHops) {
        this.idChuyenVienPhoiHops = idChuyenVienPhoiHops;
    }

    public String getChiDaoChuyenVienPhoiHops() {
        return chiDaoChuyenVienPhoiHops;
    }

    public void setChiDaoChuyenVienPhoiHops(String chiDaoChuyenVienPhoiHops) {
        this.chiDaoChuyenVienPhoiHops = chiDaoChuyenVienPhoiHops;
    }

    public String getHanGiaiQuyet() {
        return hanGiaiQuyet;
    }

    public void setHanGiaiQuyet(String hanGiaiQuyet) {
        this.hanGiaiQuyet = hanGiaiQuyet;
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
        dest.writeString(soDen);
        dest.writeString(soKyHieu);
        dest.writeString(moTa);
        dest.writeString(noiDungVanBan);
        dest.writeString(giayMoiGio);
        dest.writeString(giayMoiNgay);
        dest.writeString(giayMoiDiaDiem);
        dest.writeString(noiGui);
        dest.writeString(urlFile);
        dest.writeString(canBoChiDao);
        dest.writeString(noiDungChiDao);
        if (idPhoPhong == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idPhoPhong);
        }
        dest.writeString(tenPhoPhong);
        dest.writeString(chiDaoPhoPhong);
        dest.writeString(idPhoPhongPhoiHops);
        dest.writeString(chiDaoPhoPhongPhoiHops);
        if (idChuyenVien == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idChuyenVien);
        }
        dest.writeString(tenChuyenVien);
        dest.writeString(chiDaoChuyenVien);
        dest.writeString(idChuyenVienPhoiHops);
        dest.writeString(chiDaoChuyenVienPhoiHops);
        dest.writeString(hanGiaiQuyet);
    }
}