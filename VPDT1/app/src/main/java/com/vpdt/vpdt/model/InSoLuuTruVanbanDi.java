package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InSoLuuTruVanbanDi implements Parcelable {
    @SerializedName("mavb")
    @Expose
    private Integer mavb;
    @SerializedName("kyhieu")
    @Expose
    private String kyhieu;
    @SerializedName("ngayky")
    @Expose
    private String ngayky;
    @SerializedName("loaivb")
    @Expose
    private String loaivb;
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("nguoiky")
    @Expose
    private String nguoiky;
    @SerializedName("donvi")
    @Expose
    private String donvi;
    @SerializedName("noinhan")
    @Expose
    private List<Noinhan> noinhan = null;

    protected InSoLuuTruVanbanDi(Parcel in) {
        if (in.readByte() == 0) {
            mavb = null;
        } else {
            mavb = in.readInt();
        }
        kyhieu = in.readString();
        ngayky = in.readString();
        loaivb = in.readString();
        mota = in.readString();
        nguoiky = in.readString();
        donvi = in.readString();
        noinhan = in.createTypedArrayList(Noinhan.CREATOR);
    }

    public static final Creator<InSoLuuTruVanbanDi> CREATOR = new Creator<InSoLuuTruVanbanDi>() {
        @Override
        public InSoLuuTruVanbanDi createFromParcel(Parcel in) {
            return new InSoLuuTruVanbanDi(in);
        }

        @Override
        public InSoLuuTruVanbanDi[] newArray(int size) {
            return new InSoLuuTruVanbanDi[size];
        }
    };

    public Integer getMavb() {
        return mavb;
    }

    public void setMavb(Integer mavb) {
        this.mavb = mavb;
    }

    public String getKyhieu() {
        return kyhieu;
    }

    public void setKyhieu(String kyhieu) {
        this.kyhieu = kyhieu;
    }

    public String getNgayky() {
        return ngayky;
    }

    public void setNgayky(String ngayky) {
        this.ngayky = ngayky;
    }

    public String getLoaivb() {
        return loaivb;
    }

    public void setLoaivb(String loaivb) {
        this.loaivb = loaivb;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getNguoiky() {
        return nguoiky;
    }

    public void setNguoiky(String nguoiky) {
        this.nguoiky = nguoiky;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public List<Noinhan> getNoinhan() {
        return noinhan;
    }

    public void setNoinhan(List<Noinhan> noinhan) {
        this.noinhan = noinhan;
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
        dest.writeString(kyhieu);
        dest.writeString(ngayky);
        dest.writeString(loaivb);
        dest.writeString(mota);
        dest.writeString(nguoiky);
        dest.writeString(donvi);
        dest.writeTypedList(noinhan);
    }
}
