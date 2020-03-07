package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailVanBanDenTongThe implements Parcelable{
    @SerializedName("PK_iMaVBDen")
    @Expose
    private Integer pKIMaVBDen;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;
    @SerializedName("tenlvb")
    @Expose
    private String tenlvb;
    @SerializedName("soden")
    @Expose
    private Integer soden;
    @SerializedName("kyhieu")
    @Expose
    private String kyhieu;
    @SerializedName("trichYeu")
    @Expose
    private TrichYeu trichYeu;
    @SerializedName("phongCT")
    @Expose
    private String phongCT;
    @SerializedName("noiGui")
    @Expose
    private String noiGui;
    @SerializedName("ketqua")
    @Expose
    private String ketqua;
    @SerializedName("xoa")
    @Expose
    private Integer xoa;
    @SerializedName("tra_lai")
    @Expose
    private Integer traLai;

    protected DetailVanBanDenTongThe(Parcel in) {
        if (in.readByte() == 0) {
            pKIMaVBDen = null;
        } else {
            pKIMaVBDen = in.readInt();
        }
        ngayNhap = in.readString();
        tenlvb = in.readString();
        if (in.readByte() == 0) {
            soden = null;
        } else {
            soden = in.readInt();
        }
        kyhieu = in.readString();
        trichYeu = in.readParcelable(TrichYeu.class.getClassLoader());
        phongCT = in.readString();
        noiGui = in.readString();
        ketqua = in.readString();
        if (in.readByte() == 0) {
            xoa = null;
        } else {
            xoa = in.readInt();
        }
        if (in.readByte() == 0) {
            traLai = null;
        } else {
            traLai = in.readInt();
        }
    }

    public static final Creator<DetailVanBanDenTongThe> CREATOR = new Creator<DetailVanBanDenTongThe>() {
        @Override
        public DetailVanBanDenTongThe createFromParcel(Parcel in) {
            return new DetailVanBanDenTongThe(in);
        }

        @Override
        public DetailVanBanDenTongThe[] newArray(int size) {
            return new DetailVanBanDenTongThe[size];
        }
    };

    public Integer getPKIMaVBDen() {
        return pKIMaVBDen;
    }

    public void setPKIMaVBDen(Integer pKIMaVBDen) {
        this.pKIMaVBDen = pKIMaVBDen;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getTenlvb() {
        return tenlvb;
    }

    public void setTenlvb(String tenlvb) {
        this.tenlvb = tenlvb;
    }

    public Integer getSoden() {
        return soden;
    }

    public void setSoden(Integer soden) {
        this.soden = soden;
    }

    public String getKyhieu() {
        return kyhieu;
    }

    public void setKyhieu(String kyhieu) {
        this.kyhieu = kyhieu;
    }

    public TrichYeu getTrichYeu() {
        return trichYeu;
    }

    public void setTrichYeu(TrichYeu trichYeu) {
        this.trichYeu = trichYeu;
    }

    public String getPhongCT() {
        return phongCT;
    }

    public void setPhongCT(String phongCT) {
        this.phongCT = phongCT;
    }

    public String getNoiGui() {
        return noiGui;
    }

    public void setNoiGui(String noiGui) {
        this.noiGui = noiGui;
    }

    public String getKetqua() {
        return ketqua;
    }

    public void setKetqua(String ketqua) {
        this.ketqua = ketqua;
    }

    public Integer getXoa() {
        return xoa;
    }

    public void setXoa(Integer xoa) {
        this.xoa = xoa;
    }

    public Integer getTraLai() {
        return traLai;
    }

    public void setTraLai(Integer traLai) {
        this.traLai = traLai;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (pKIMaVBDen == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(pKIMaVBDen);
        }
        dest.writeString(ngayNhap);
        dest.writeString(tenlvb);
        if (soden == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(soden);
        }
        dest.writeString(kyhieu);
        dest.writeParcelable(trichYeu, flags);
        dest.writeString(phongCT);
        dest.writeString(noiGui);
        dest.writeString(ketqua);
        if (xoa == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(xoa);
        }
        if (traLai == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(traLai);
        }
    }
}
