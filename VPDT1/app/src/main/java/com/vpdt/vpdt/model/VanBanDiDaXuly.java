package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VanBanDiDaXuly implements Parcelable {
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
    @SerializedName("ngay_nhap")
    @Expose
    private String ngayNhap;
    @SerializedName("noinhan")
    @Expose
    private List<Noinhan> noinhan = null;
    @SerializedName("duongdan")
    @Expose
    private String duongdan;
    @SerializedName("hien_xoa")
    @Expose
    private Integer hienXoa;

    protected VanBanDiDaXuly(Parcel in) {
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
        ngayNhap = in.readString();
        noinhan = in.createTypedArrayList(Noinhan.CREATOR);
        duongdan = in.readString();
        if (in.readByte() == 0) {
            hienXoa = null;
        } else {
            hienXoa = in.readInt();
        }
    }

    public static final Creator<VanBanDiDaXuly> CREATOR = new Creator<VanBanDiDaXuly>() {
        @Override
        public VanBanDiDaXuly createFromParcel(Parcel in) {
            return new VanBanDiDaXuly(in);
        }

        @Override
        public VanBanDiDaXuly[] newArray(int size) {
            return new VanBanDiDaXuly[size];
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

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public List<Noinhan> getNoinhan() {
        return noinhan;
    }

    public void setNoinhan(List<Noinhan> noinhan) {
        this.noinhan = noinhan;
    }

    public String getDuongdan() {
        return duongdan;
    }

    public void setDuongdan(String duongdan) {
        this.duongdan = duongdan;
    }

    public Integer getHienXoa() {
        return hienXoa;
    }

    public void setHienXoa(Integer hienXoa) {
        this.hienXoa = hienXoa;
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
        dest.writeString(ngayNhap);
        dest.writeTypedList(noinhan);
        dest.writeString(duongdan);
        if (hienXoa == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(hienXoa);
        }
    }
}
