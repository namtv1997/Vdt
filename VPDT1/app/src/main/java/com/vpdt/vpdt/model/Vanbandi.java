package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vanbandi implements Parcelable {
    @SerializedName("so_van_ban_di")
    @Expose
    private String soVanBanDi;
    @SerializedName("ngay_van_ban")
    @Expose
    private String ngayVanBan;
    @SerializedName("trich_yeu")
    @Expose
    private String trichYeu;
    @SerializedName("duongdanfile")
    @Expose
    private String duongdanfile;

    protected Vanbandi(Parcel in) {
        soVanBanDi = in.readString();
        ngayVanBan = in.readString();
        trichYeu = in.readString();
        duongdanfile = in.readString();
    }

    public static final Creator<Vanbandi> CREATOR = new Creator<Vanbandi>() {
        @Override
        public Vanbandi createFromParcel(Parcel in) {
            return new Vanbandi(in);
        }

        @Override
        public Vanbandi[] newArray(int size) {
            return new Vanbandi[size];
        }
    };

    public String getSoVanBanDi() {
        return soVanBanDi;
    }

    public void setSoVanBanDi(String soVanBanDi) {
        this.soVanBanDi = soVanBanDi;
    }

    public String getNgayVanBan() {
        return ngayVanBan;
    }

    public void setNgayVanBan(String ngayVanBan) {
        this.ngayVanBan = ngayVanBan;
    }

    public String getTrichYeu() {
        return trichYeu;
    }

    public void setTrichYeu(String trichYeu) {
        this.trichYeu = trichYeu;
    }

    public String getDuongdanfile() {
        return duongdanfile;
    }

    public void setDuongdanfile(String duongdanfile) {
        this.duongdanfile = duongdanfile;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(soVanBanDi);
        dest.writeString(ngayVanBan);
        dest.writeString(trichYeu);
        dest.writeString(duongdanfile);
    }
}
