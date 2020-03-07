package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DetailVanBanDiTongThe implements Parcelable {
    @SerializedName("PK_iMaVBDi")
    @Expose
    private Integer pKIMaVBDi;
    @SerializedName("sodi")
    @Expose
    private Integer sodi;
    @SerializedName("tenloaivanban")
    @Expose
    private String tenloaivanban;
    @SerializedName("ngaynhap")
    @Expose
    private String ngaynhap;
    @SerializedName("ngayVBdi")
    @Expose
    private String ngayVBdi;
    @SerializedName("kyhieu")
    @Expose
    private String kyhieu;
    @SerializedName("ty")
    @Expose
    private Ty ty;
    @SerializedName("noinhan")
    @Expose
    private List<Noinhan> noinhan = null;
    @SerializedName("soden")
    @Expose
    private String soden;

    protected DetailVanBanDiTongThe(Parcel in) {

        if (in.readByte() == 0) {
            pKIMaVBDi = null;
        } else {
            pKIMaVBDi = in.readInt();
        }
        if (in.readByte() == 0) {
            sodi = null;
        } else {
            sodi = in.readInt();
        }
        tenloaivanban = in.readString();
        ngaynhap = in.readString();
        ngayVBdi = in.readString();
        kyhieu = in.readString();
        soden = in.readString();
        if (noinhan == null) {
            noinhan = new ArrayList<>();
        }
        in.readTypedList(noinhan, Noinhan.CREATOR);
        ty= in.readTypedObject(Ty.CREATOR);
    }

    public static final Creator<DetailVanBanDiTongThe> CREATOR = new Creator<DetailVanBanDiTongThe>() {
        @Override
        public DetailVanBanDiTongThe createFromParcel(Parcel in) {
            return new DetailVanBanDiTongThe(in);
        }

        @Override
        public DetailVanBanDiTongThe[] newArray(int size) {
            return new DetailVanBanDiTongThe[size];
        }
    };

    public Integer getPKIMaVBDi() {
        return pKIMaVBDi;
    }

    public void setPKIMaVBDi(Integer pKIMaVBDi) {
        this.pKIMaVBDi = pKIMaVBDi;
    }

    public Integer getSodi() {
        return sodi;
    }

    public void setSodi(Integer sodi) {
        this.sodi = sodi;
    }

    public String getTenloaivanban() {
        return tenloaivanban;
    }

    public void setTenloaivanban(String tenloaivanban) {
        this.tenloaivanban = tenloaivanban;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public String getNgayVBdi() {
        return ngayVBdi;
    }

    public void setNgayVBdi(String ngayVBdi) {
        this.ngayVBdi = ngayVBdi;
    }

    public String getKyhieu() {
        return kyhieu;
    }

    public void setKyhieu(String kyhieu) {
        this.kyhieu = kyhieu;
    }

    public Ty getTy() {
        return ty;
    }

    public void setTy(Ty ty) {
        this.ty = ty;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (pKIMaVBDi == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(pKIMaVBDi);
        }
        if (sodi == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(sodi);
        }
        dest.writeString(tenloaivanban);
        dest.writeString(ngaynhap);
        dest.writeString(ngayVBdi);
        dest.writeString(kyhieu);
        dest.writeString(soden);
        dest.writeTypedList(noinhan);
        dest.writeTypedObject(ty,flags);
    }
}
