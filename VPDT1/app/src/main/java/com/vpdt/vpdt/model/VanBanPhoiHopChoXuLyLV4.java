package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VanBanPhoiHopChoXuLyLV4 implements Parcelable {
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
    @SerializedName("idChuyenVienPhoiHops")
    @Expose
    private String idChuyenVienPhoiHops;
    @SerializedName("chiDaoChuyenVienPhoiHops")
    @Expose
    private String chiDaoChuyenVienPhoiHops;
    @SerializedName("hanGiaiQuyet")
    @Expose
    private String hanGiaiQuyet;
    @SerializedName("CT_PH")
    @Expose
    private Integer cTPH;

    protected VanBanPhoiHopChoXuLyLV4(Parcel in) {
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
        idChuyenVienPhoiHops = in.readString();
        chiDaoChuyenVienPhoiHops = in.readString();
        hanGiaiQuyet = in.readString();
        if (in.readByte() == 0) {
            cTPH = null;
        } else {
            cTPH = in.readInt();
        }
    }

    public static final Creator<VanBanPhoiHopChoXuLyLV4> CREATOR = new Creator<VanBanPhoiHopChoXuLyLV4>() {
        @Override
        public VanBanPhoiHopChoXuLyLV4 createFromParcel(Parcel in) {
            return new VanBanPhoiHopChoXuLyLV4(in);
        }

        @Override
        public VanBanPhoiHopChoXuLyLV4[] newArray(int size) {
            return new VanBanPhoiHopChoXuLyLV4[size];
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

    public Integer getCTPH() {
        return cTPH;
    }

    public void setCTPH(Integer cTPH) {
        this.cTPH = cTPH;
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
        dest.writeString(idChuyenVienPhoiHops);
        dest.writeString(chiDaoChuyenVienPhoiHops);
        dest.writeString(hanGiaiQuyet);
        if (cTPH == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(cTPH);
        }
    }
}
