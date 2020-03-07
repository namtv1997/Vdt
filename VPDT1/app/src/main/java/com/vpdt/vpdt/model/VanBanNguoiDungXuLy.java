package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VanBanNguoiDungXuLy implements Parcelable {
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
    @SerializedName("loaiVanBan")
    @Expose
    private String loaiVanBan;
    @SerializedName("giayMoiNgay")
    @Expose
    private String giayMoiNgay;
    @SerializedName("giayMoiGio")
    @Expose
    private String giayMoiGio;
    @SerializedName("giayMoiDiaDiem")
    @Expose
    private String giayMoiDiaDiem;
    @SerializedName("noiGui")
    @Expose
    private String noiGui;
    @SerializedName("nguoiNhap")
    @Expose
    private String nguoiNhap;
    @SerializedName("hanGiaiQuyet")
    @Expose
    private String hanGiaiQuyet;
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
    @SerializedName("phongChuTri")
    @Expose
    private String phongChuTri;
    @SerializedName("chuTri")
    @Expose
    private String chuTri;
    @SerializedName("soTrang")
    @Expose
    private String soTrang;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("allowTraLai")
    @Expose
    private Boolean allowTraLai;
    @SerializedName("ngayGiaiQuyet")
    @Expose
    private String ngayGiaiQuyet;

    protected VanBanNguoiDungXuLy(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        ngayNhap = in.readString();
        moTa = in.readString();
        soKyHieu = in.readString();
        soDen = in.readString();
        loaiVanBan = in.readString();
        giayMoiNgay = in.readString();
        giayMoiGio = in.readString();
        giayMoiDiaDiem = in.readString();
        noiGui = in.readString();
        nguoiNhap = in.readString();
        hanGiaiQuyet = in.readString();
        noiDung = in.readString();
        phongChuTri = in.readString();
        chuTri = in.readString();
        soTrang = in.readString();
        urlFile = in.readString();
        byte tmpAllowTraLai = in.readByte();
        allowTraLai = tmpAllowTraLai == 0 ? null : tmpAllowTraLai == 1;
        ngayGiaiQuyet = in.readString();
    }

    public static final Creator<VanBanNguoiDungXuLy> CREATOR = new Creator<VanBanNguoiDungXuLy>() {
        @Override
        public VanBanNguoiDungXuLy createFromParcel(Parcel in) {
            return new VanBanNguoiDungXuLy(in);
        }

        @Override
        public VanBanNguoiDungXuLy[] newArray(int size) {
            return new VanBanNguoiDungXuLy[size];
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

    public String getLoaiVanBan() {
        return loaiVanBan;
    }

    public void setLoaiVanBan(String loaiVanBan) {
        this.loaiVanBan = loaiVanBan;
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

    public String getNguoiNhap() {
        return nguoiNhap;
    }

    public void setNguoiNhap(String nguoiNhap) {
        this.nguoiNhap = nguoiNhap;
    }

    public String getHanGiaiQuyet() {
        return hanGiaiQuyet;
    }

    public void setHanGiaiQuyet(String hanGiaiQuyet) {
        this.hanGiaiQuyet = hanGiaiQuyet;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getPhongChuTri() {
        return phongChuTri;
    }

    public void setPhongChuTri(String phongChuTri) {
        this.phongChuTri = phongChuTri;
    }

    public String getChuTri() {
        return chuTri;
    }

    public void setChuTri(String chuTri) {
        this.chuTri = chuTri;
    }

    public String getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(String soTrang) {
        this.soTrang = soTrang;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public Boolean getAllowTraLai() {
        return allowTraLai;
    }

    public void setAllowTraLai(Boolean allowTraLai) {
        this.allowTraLai = allowTraLai;
    }

    public String getNgayGiaiQuyet() {
        return ngayGiaiQuyet;
    }

    public void setNgayGiaiQuyet(String ngayGiaiQuyet) {
        this.ngayGiaiQuyet = ngayGiaiQuyet;
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
        dest.writeString(loaiVanBan);
        dest.writeString(giayMoiNgay);
        dest.writeString(giayMoiGio);
        dest.writeString(giayMoiDiaDiem);
        dest.writeString(noiGui);
        dest.writeString(nguoiNhap);
        dest.writeString(hanGiaiQuyet);
        dest.writeString(noiDung);
        dest.writeString(phongChuTri);
        dest.writeString(chuTri);
        dest.writeString(soTrang);
        dest.writeString(urlFile);
        dest.writeByte((byte) (allowTraLai == null ? 0 : allowTraLai ? 1 : 2));
        dest.writeString(ngayGiaiQuyet);
    }
}
