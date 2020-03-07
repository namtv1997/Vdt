package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KetGiaiQuyetPhongThuLy implements Parcelable {
    @SerializedName("can_bo_donvi")
    @Expose
    private String canBoDonvi;
    @SerializedName("noi_dung")
    @Expose
    private String noiDung;
    @SerializedName("duong_danfile")
    @Expose
    private String duongDanfile;
    @SerializedName("ngay_nhap")
    @Expose
    private String ngayNhap;
    @SerializedName("trang_thai")
    @Expose
    private Integer trangThai;

    protected KetGiaiQuyetPhongThuLy(Parcel in) {
        canBoDonvi = in.readString();
        noiDung = in.readString();
        duongDanfile = in.readString();
        ngayNhap = in.readString();
        if (in.readByte() == 0) {
            trangThai = null;
        } else {
            trangThai = in.readInt();
        }
    }

    public static final Creator<KetGiaiQuyetPhongThuLy> CREATOR = new Creator<KetGiaiQuyetPhongThuLy>() {
        @Override
        public KetGiaiQuyetPhongThuLy createFromParcel(Parcel in) {
            return new KetGiaiQuyetPhongThuLy(in);
        }

        @Override
        public KetGiaiQuyetPhongThuLy[] newArray(int size) {
            return new KetGiaiQuyetPhongThuLy[size];
        }
    };

    public String getCanBoDonvi() {
        return canBoDonvi;
    }

    public void setCanBoDonvi(String canBoDonvi) {
        this.canBoDonvi = canBoDonvi;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getDuongDanfile() {
        return duongDanfile;
    }

    public void setDuongDanfile(String duongDanfile) {
        this.duongDanfile = duongDanfile;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(canBoDonvi);
        dest.writeString(noiDung);
        dest.writeString(duongDanfile);
        dest.writeString(ngayNhap);
        if (trangThai == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(trangThai);
        }
    }
}
