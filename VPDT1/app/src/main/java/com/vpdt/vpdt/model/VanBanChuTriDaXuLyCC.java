package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VanBanChuTriDaXuLyCC implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("soKyHieu")
    @Expose
    private String soKyHieu;
    @SerializedName("soVBDi")
    @Expose
    private Integer soVBDi;
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("nguoiNhap")
    @Expose
    private String nguoiNhap;
    @SerializedName("noiNhan")
    @Expose
    private String noiNhan;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("allowDelete")
    @Expose
    private String allowDelete;

    protected VanBanChuTriDaXuLyCC(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        soKyHieu = in.readString();
        if (in.readByte() == 0) {
            soVBDi = null;
        } else {
            soVBDi = in.readInt();
        }
        moTa = in.readString();
        nguoiNhap = in.readString();
        noiNhan = in.readString();
        ngayNhap = in.readString();
        urlFile = in.readString();
        allowDelete = in.readString();
    }

    public static final Creator<VanBanChuTriDaXuLyCC> CREATOR = new Creator<VanBanChuTriDaXuLyCC>() {
        @Override
        public VanBanChuTriDaXuLyCC createFromParcel(Parcel in) {
            return new VanBanChuTriDaXuLyCC(in);
        }

        @Override
        public VanBanChuTriDaXuLyCC[] newArray(int size) {
            return new VanBanChuTriDaXuLyCC[size];
        }
    };

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

    public Integer getSoVBDi() {
        return soVBDi;
    }

    public void setSoVBDi(Integer soVBDi) {
        this.soVBDi = soVBDi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNguoiNhap() {
        return nguoiNhap;
    }

    public void setNguoiNhap(String nguoiNhap) {
        this.nguoiNhap = nguoiNhap;
    }

    public String getNoiNhan() {
        return noiNhan;
    }

    public void setNoiNhan(String noiNhan) {
        this.noiNhan = noiNhan;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public String getAllowDelete() {
        return allowDelete;
    }

    public void setAllowDelete(String allowDelete) {
        this.allowDelete = allowDelete;
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
        dest.writeString(soKyHieu);
        if (soVBDi == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(soVBDi);
        }
        dest.writeString(moTa);
        dest.writeString(nguoiNhap);
        dest.writeString(noiNhan);
        dest.writeString(ngayNhap);
        dest.writeString(urlFile);
        dest.writeString(allowDelete);
    }
}
