package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InSoLuuTruVanBanDen implements Parcelable {
    @SerializedName("mavb")
    @Expose
    private Integer mavb;
    @SerializedName("ngaynhan")
    @Expose
    private String ngaynhan;
    @SerializedName("soden")
    @Expose
    private Integer soden;
    @SerializedName("donviBH")
    @Expose
    private String donviBH;
    @SerializedName("kyhieu")
    @Expose
    private String kyhieu;
    @SerializedName("ngayky")
    @Expose
    private String ngayky;
    @SerializedName("loaiVB")
    @Expose
    private String loaiVB;
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("nguoiky")
    @Expose
    private String nguoiky;
    @SerializedName("hangiaiquyet")
    @Expose
    private String hangiaiquyet;
    @SerializedName("trangthai")
    @Expose
    private String trangthai;
    @SerializedName("nguoigiaiquyetcuoicung")
    @Expose
    private String nguoigiaiquyetcuoicung;
    @SerializedName("ld_chidao")
    @Expose
    private String ldChidao;
    @SerializedName("tenpb")
    @Expose
    private String tenpb;

    protected InSoLuuTruVanBanDen(Parcel in) {
        if (in.readByte() == 0) {
            mavb = null;
        } else {
            mavb = in.readInt();
        }
        ngaynhan = in.readString();
        if (in.readByte() == 0) {
            soden = null;
        } else {
            soden = in.readInt();
        }
        donviBH = in.readString();
        kyhieu = in.readString();
        ngayky = in.readString();
        loaiVB = in.readString();
        mota = in.readString();
        nguoiky = in.readString();
        hangiaiquyet = in.readString();
        trangthai = in.readString();
        nguoigiaiquyetcuoicung = in.readString();
        ldChidao = in.readString();
        tenpb = in.readString();
    }

    public static final Creator<InSoLuuTruVanBanDen> CREATOR = new Creator<InSoLuuTruVanBanDen>() {
        @Override
        public InSoLuuTruVanBanDen createFromParcel(Parcel in) {
            return new InSoLuuTruVanBanDen(in);
        }

        @Override
        public InSoLuuTruVanBanDen[] newArray(int size) {
            return new InSoLuuTruVanBanDen[size];
        }
    };

    public Integer getMavb() {
        return mavb;
    }

    public void setMavb(Integer mavb) {
        this.mavb = mavb;
    }

    public String getNgaynhan() {
        return ngaynhan;
    }

    public void setNgaynhan(String ngaynhan) {
        this.ngaynhan = ngaynhan;
    }

    public Integer getSoden() {
        return soden;
    }

    public void setSoden(Integer soden) {
        this.soden = soden;
    }

    public String getDonviBH() {
        return donviBH;
    }

    public void setDonviBH(String donviBH) {
        this.donviBH = donviBH;
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

    public String getLoaiVB() {
        return loaiVB;
    }

    public void setLoaiVB(String loaiVB) {
        this.loaiVB = loaiVB;
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

    public String getHangiaiquyet() {
        return hangiaiquyet;
    }

    public void setHangiaiquyet(String hangiaiquyet) {
        this.hangiaiquyet = hangiaiquyet;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getNguoigiaiquyetcuoicung() {
        return nguoigiaiquyetcuoicung;
    }

    public void setNguoigiaiquyetcuoicung(String nguoigiaiquyetcuoicung) {
        this.nguoigiaiquyetcuoicung = nguoigiaiquyetcuoicung;
    }

    public String getLdChidao() {
        return ldChidao;
    }

    public void setLdChidao(String ldChidao) {
        this.ldChidao = ldChidao;
    }

    public String getTenpb() {
        return tenpb;
    }

    public void setTenpb(String tenpb) {
        this.tenpb = tenpb;
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
        dest.writeString(ngaynhan);
        if (soden == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(soden);
        }
        dest.writeString(donviBH);
        dest.writeString(kyhieu);
        dest.writeString(ngayky);
        dest.writeString(loaiVB);
        dest.writeString(mota);
        dest.writeString(nguoiky);
        dest.writeString(hangiaiquyet);
        dest.writeString(trangthai);
        dest.writeString(nguoigiaiquyetcuoicung);
        dest.writeString(ldChidao);
        dest.writeString(tenpb);
    }
}
