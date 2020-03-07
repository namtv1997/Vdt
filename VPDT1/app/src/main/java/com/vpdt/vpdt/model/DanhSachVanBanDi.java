package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DanhSachVanBanDi implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("loaiVanBan")
    @Expose
    private String loaiVanBan;
    @SerializedName("soKyHieu")
    @Expose
    private String soKyHieu;
    @SerializedName("soVBDi")
    @Expose
    private String soVBDi;
    @SerializedName("ngayVanBanDi")
    @Expose
    private String ngayVanBanDi;
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("soDen")
    @Expose
    private String soDen;
    @SerializedName("nguoiKy")
    @Expose
    private String nguoiKy;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;
    @SerializedName("noiNhan")
    @Expose
    private String noiNhan;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("allowDelete")
    @Expose
    private Boolean allowDelete;
    @SerializedName("allowDuyet")
    @Expose
    private Boolean allowDuyet;

    protected DanhSachVanBanDi(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        loaiVanBan = in.readString();
        soKyHieu = in.readString();
        soVBDi = in.readString();
        ngayVanBanDi = in.readString();
        moTa = in.readString();
        soDen = in.readString();
        nguoiKy = in.readString();
        ngayNhap = in.readString();
        noiNhan = in.readString();
        urlFile = in.readString();
        byte tmpAllowDelete = in.readByte();
        allowDelete = tmpAllowDelete == 0 ? null : tmpAllowDelete == 1;
        byte tmpAllowDuyet = in.readByte();
        allowDuyet = tmpAllowDuyet == 0 ? null : tmpAllowDuyet == 1;
    }

    public static final Creator<DanhSachVanBanDi> CREATOR = new Creator<DanhSachVanBanDi>() {
        @Override
        public DanhSachVanBanDi createFromParcel(Parcel in) {
            return new DanhSachVanBanDi(in);
        }

        @Override
        public DanhSachVanBanDi[] newArray(int size) {
            return new DanhSachVanBanDi[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoaiVanBan() {
        return loaiVanBan;
    }

    public void setLoaiVanBan(String loaiVanBan) {
        this.loaiVanBan = loaiVanBan;
    }

    public String getSoKyHieu() {
        return soKyHieu;
    }

    public void setSoKyHieu(String soKyHieu) {
        this.soKyHieu = soKyHieu;
    }

    public String getSoVBDi() {
        return soVBDi;
    }

    public void setSoVBDi(String soVBDi) {
        this.soVBDi = soVBDi;
    }

    public String getNgayVanBanDi() {
        return ngayVanBanDi;
    }

    public void setNgayVanBanDi(String ngayVanBanDi) {
        this.ngayVanBanDi = ngayVanBanDi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getSoDen() {
        return soDen;
    }

    public void setSoDen(String soDen) {
        this.soDen = soDen;
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

    public String getNoiNhan() {
        return noiNhan;
    }

    public void setNoiNhan(String noiNhan) {
        this.noiNhan = noiNhan;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public Boolean getAllowDelete() {
        return allowDelete;
    }

    public void setAllowDelete(Boolean allowDelete) {
        this.allowDelete = allowDelete;
    }

    public Boolean getAllowDuyet() {
        return allowDuyet;
    }

    public void setAllowDuyet(Boolean allowDuyet) {
        this.allowDuyet = allowDuyet;
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
        dest.writeString(loaiVanBan);
        dest.writeString(soKyHieu);
        dest.writeString(soVBDi);
        dest.writeString(ngayVanBanDi);
        dest.writeString(moTa);
        dest.writeString(soDen);
        dest.writeString(nguoiKy);
        dest.writeString(ngayNhap);
        dest.writeString(noiNhan);
        dest.writeString(urlFile);
        dest.writeByte((byte) (allowDelete == null ? 0 : allowDelete ? 1 : 2));
        dest.writeByte((byte) (allowDuyet == null ? 0 : allowDuyet ? 1 : 2));
    }
}
