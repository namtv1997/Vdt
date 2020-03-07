package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VanBanDiChuaXuLy implements Parcelable {
    @SerializedName("mavb")
    @Expose
    private Integer mavb;
    @SerializedName("sodi")
    @Expose
    private Integer sodi;
    @SerializedName("kyhieu")
    @Expose
    private String kyhieu;
    @SerializedName("trich_yeu")
    @Expose
    private String trichYeu;
    @SerializedName("nguoinhap")
    @Expose
    private String nguoinhap;
    @SerializedName("y_kien")
    @Expose
    private String yKien;
    @SerializedName("nguoigui")
    @Expose
    private String nguoigui;
    @SerializedName("thoigian")
    @Expose
    private String thoigian;
    @SerializedName("duongdan")
    @Expose
    private String duongdan;

    protected VanBanDiChuaXuLy(Parcel in) {
        if (in.readByte() == 0) {
            mavb = null;
        } else {
            mavb = in.readInt();
        }
        if (in.readByte() == 0) {
            sodi = null;
        } else {
            sodi = in.readInt();
        }
        kyhieu = in.readString();
        trichYeu = in.readString();
        nguoinhap = in.readString();
        yKien = in.readString();
        nguoigui = in.readString();
        thoigian = in.readString();
        duongdan = in.readString();
    }

    public static final Creator<VanBanDiChuaXuLy> CREATOR = new Creator<VanBanDiChuaXuLy>() {
        @Override
        public VanBanDiChuaXuLy createFromParcel(Parcel in) {
            return new VanBanDiChuaXuLy(in);
        }

        @Override
        public VanBanDiChuaXuLy[] newArray(int size) {
            return new VanBanDiChuaXuLy[size];
        }
    };

    public Integer getMavb() {
        return mavb;
    }

    public void setMavb(Integer mavb) {
        this.mavb = mavb;
    }

    public Integer getSodi() {
        return sodi;
    }

    public void setSodi(Integer sodi) {
        this.sodi = sodi;
    }

    public String getKyhieu() {
        return kyhieu;
    }

    public void setKyhieu(String kyhieu) {
        this.kyhieu = kyhieu;
    }

    public String getTrichYeu() {
        return trichYeu;
    }

    public void setTrichYeu(String trichYeu) {
        this.trichYeu = trichYeu;
    }

    public String getNguoinhap() {
        return nguoinhap;
    }

    public void setNguoinhap(String nguoinhap) {
        this.nguoinhap = nguoinhap;
    }

    public String getYKien() {
        return yKien;
    }

    public void setYKien(String yKien) {
        this.yKien = yKien;
    }

    public String getNguoigui() {
        return nguoigui;
    }

    public void setNguoigui(String nguoigui) {
        this.nguoigui = nguoigui;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getDuongdan() {
        return duongdan;
    }

    public void setDuongdan(String duongdan) {
        this.duongdan = duongdan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (mavb == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(mavb);
        }
        if (sodi == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(sodi);
        }
        dest.writeString(kyhieu);
        dest.writeString(trichYeu);
        dest.writeString(nguoinhap);
        dest.writeString(yKien);
        dest.writeString(nguoigui);
        dest.writeString(thoigian);
        dest.writeString(duongdan);
    }
}
