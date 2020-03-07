package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GiayMoiCuaPhong implements Parcelable {
    @SerializedName("mavb")
    @Expose
    private Integer mavb;
    @SerializedName("loaiVB")
    @Expose
    private String loaiVB;
    @SerializedName("sodi")
    @Expose
    private Integer sodi;
    @SerializedName("kyhieu")
    @Expose
    private String kyhieu;
    @SerializedName("ngaythang")
    @Expose
    private String ngaythang;
    @SerializedName("trich_yeu")
    @Expose
    private String trichYeu;
    @SerializedName("nguoiky")
    @Expose
    private String nguoiky;
    @SerializedName("noinhan")
    @Expose
    private List<Noinhan> noinhan = null;
    @SerializedName("soden")
    @Expose
    private String soden;
    @SerializedName("duongdan")
    @Expose
    private String duongdan;


    protected GiayMoiCuaPhong(Parcel in) {
        if (in.readByte() == 0) {
            mavb = null;
        } else {
            mavb = in.readInt();
        }
        loaiVB = in.readString();
        if (in.readByte() == 0) {
            sodi = null;
        } else {
            sodi = in.readInt();
        }
        kyhieu = in.readString();
        ngaythang = in.readString();
        trichYeu = in.readString();
        nguoiky = in.readString();
        noinhan = in.createTypedArrayList(Noinhan.CREATOR);
        soden = in.readString();
        duongdan = in.readString();
    }

    public static final Creator<GiayMoiCuaPhong> CREATOR = new Creator<GiayMoiCuaPhong>() {
        @Override
        public GiayMoiCuaPhong createFromParcel(Parcel in) {
            return new GiayMoiCuaPhong(in);
        }

        @Override
        public GiayMoiCuaPhong[] newArray(int size) {
            return new GiayMoiCuaPhong[size];
        }
    };

    public Integer getMavb() {
        return mavb;
    }

    public void setMavb(Integer mavb) {
        this.mavb = mavb;
    }

    public String getLoaiVB() {
        return loaiVB;
    }

    public void setLoaiVB(String loaiVB) {
        this.loaiVB = loaiVB;
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

    public String getNgaythang() {
        return ngaythang;
    }

    public void setNgaythang(String ngaythang) {
        this.ngaythang = ngaythang;
    }

    public String getTrichYeu() {
        return trichYeu;
    }

    public void setTrichYeu(String trichYeu) {
        this.trichYeu = trichYeu;
    }

    public String getNguoiky() {
        return nguoiky;
    }

    public void setNguoiky(String nguoiky) {
        this.nguoiky = nguoiky;
    }

    public List<Noinhan> getNoinhan() {
        return noinhan;
    }

    public void setNoinhan(List<Noinhan> noinhan) {
        this.noinhan = noinhan;
    }

    public String getSoden() {
        return soden;
    }

    public void setSoden(String soden) {
        this.soden = soden;
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
        dest.writeString(loaiVB);
        if (sodi == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(sodi);
        }
        dest.writeString(kyhieu);
        dest.writeString(ngaythang);
        dest.writeString(trichYeu);
        dest.writeString(nguoiky);
        dest.writeTypedList(noinhan);
        dest.writeString(soden);
        dest.writeString(duongdan);
    }
}
