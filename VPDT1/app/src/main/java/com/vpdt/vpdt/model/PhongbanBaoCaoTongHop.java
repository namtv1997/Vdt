package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhongbanBaoCaoTongHop implements Parcelable {
    @SerializedName("mapb")
    @Expose
    private Integer mapb;
    @SerializedName("tenpb")
    @Expose
    private String tenpb;
    @SerializedName("tong")
    @Expose
    private Integer tong;
    @SerializedName("dtk_chuadenhan")
    @Expose
    private Integer dtkChuadenhan;
    @SerializedName("dtk_daquahan")
    @Expose
    private Integer dtkDaquahan;
    @SerializedName("ht_tronghan")
    @Expose
    private Integer htTronghan;
    @SerializedName("ht_quahan")
    @Expose
    private Integer htQuahan;
    @SerializedName("vanban")
    @Expose
    private List<VanbanBaoCaoTongHop> vanbanBaoCaoTongHop = null;

    protected PhongbanBaoCaoTongHop(Parcel in) {
        if (in.readByte() == 0) {
            mapb = null;
        } else {
            mapb = in.readInt();
        }
        tenpb = in.readString();
        if (in.readByte() == 0) {
            tong = null;
        } else {
            tong = in.readInt();
        }
        if (in.readByte() == 0) {
            dtkChuadenhan = null;
        } else {
            dtkChuadenhan = in.readInt();
        }
        if (in.readByte() == 0) {
            dtkDaquahan = null;
        } else {
            dtkDaquahan = in.readInt();
        }
        if (in.readByte() == 0) {
            htTronghan = null;
        } else {
            htTronghan = in.readInt();
        }
        if (in.readByte() == 0) {
            htQuahan = null;
        } else {
            htQuahan = in.readInt();
        }
        vanbanBaoCaoTongHop = in.createTypedArrayList(VanbanBaoCaoTongHop.CREATOR);
    }

    public static final Creator<PhongbanBaoCaoTongHop> CREATOR = new Creator<PhongbanBaoCaoTongHop>() {
        @Override
        public PhongbanBaoCaoTongHop createFromParcel(Parcel in) {
            return new PhongbanBaoCaoTongHop(in);
        }

        @Override
        public PhongbanBaoCaoTongHop[] newArray(int size) {
            return new PhongbanBaoCaoTongHop[size];
        }
    };

    public Integer getMapb() {
        return mapb;
    }

    public void setMapb(Integer mapb) {
        this.mapb = mapb;
    }

    public String getTenpb() {
        return tenpb;
    }

    public void setTenpb(String tenpb) {
        this.tenpb = tenpb;
    }

    public Integer getTong() {
        return tong;
    }

    public void setTong(Integer tong) {
        this.tong = tong;
    }

    public Integer getDtkChuadenhan() {
        return dtkChuadenhan;
    }

    public void setDtkChuadenhan(Integer dtkChuadenhan) {
        this.dtkChuadenhan = dtkChuadenhan;
    }

    public Integer getDtkDaquahan() {
        return dtkDaquahan;
    }

    public void setDtkDaquahan(Integer dtkDaquahan) {
        this.dtkDaquahan = dtkDaquahan;
    }

    public Integer getHtTronghan() {
        return htTronghan;
    }

    public void setHtTronghan(Integer htTronghan) {
        this.htTronghan = htTronghan;
    }

    public Integer getHtQuahan() {
        return htQuahan;
    }

    public void setHtQuahan(Integer htQuahan) {
        this.htQuahan = htQuahan;
    }

    public List<VanbanBaoCaoTongHop> getVanbanBaoCaoTongHop() {
        return vanbanBaoCaoTongHop;
    }

    public void setVanbanBaoCaoTongHop(List<VanbanBaoCaoTongHop> vanbanBaoCaoTongHop) {
        this.vanbanBaoCaoTongHop = vanbanBaoCaoTongHop;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (mapb == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(mapb);
        }
        dest.writeString(tenpb);
        if (tong == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(tong);
        }
        if (dtkChuadenhan == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(dtkChuadenhan);
        }
        if (dtkDaquahan == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(dtkDaquahan);
        }
        if (htTronghan == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(htTronghan);
        }
        if (htQuahan == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(htQuahan);
        }
        dest.writeTypedList(vanbanBaoCaoTongHop);
    }
}
