package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KetGiaiQuyetPhongPhoiHop implements Parcelable {
    @SerializedName("canbo")
    @Expose
    private String canbo;
    @SerializedName("phong_ban")
    @Expose
    private String phongBan;
    @SerializedName("noi_dung")
    @Expose
    private String noiDung;
    @SerializedName("duong_danfile")
    @Expose
    private String duongDanfile;
    @SerializedName("ngay_nhap")
    @Expose
    private String ngayNhap;

    protected KetGiaiQuyetPhongPhoiHop(Parcel in) {
        canbo = in.readString();
        phongBan = in.readString();
        noiDung = in.readString();
        duongDanfile = in.readString();
        ngayNhap = in.readString();
    }

    public static final Creator<KetGiaiQuyetPhongPhoiHop> CREATOR = new Creator<KetGiaiQuyetPhongPhoiHop>() {
        @Override
        public KetGiaiQuyetPhongPhoiHop createFromParcel(Parcel in) {
            return new KetGiaiQuyetPhongPhoiHop(in);
        }

        @Override
        public KetGiaiQuyetPhongPhoiHop[] newArray(int size) {
            return new KetGiaiQuyetPhongPhoiHop[size];
        }
    };

    public String getCanbo() {
        return canbo;
    }

    public void setCanbo(String canbo) {
        this.canbo = canbo;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(canbo);
        dest.writeString(phongBan);
        dest.writeString(noiDung);
        dest.writeString(duongDanfile);
        dest.writeString(ngayNhap);
    }
}
