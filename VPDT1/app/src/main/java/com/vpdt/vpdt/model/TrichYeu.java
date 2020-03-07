package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrichYeu implements Parcelable {
    @SerializedName("mota1")
    @Expose
    private String mota1;
    @SerializedName("iGiayMoi")
    @Expose
    private Integer iGiayMoi;
    @SerializedName("giomoi")
    @Expose
    private String giomoi;
    @SerializedName("ngaymoi")
    @Expose
    private String ngaymoi;
    @SerializedName("diadiemMoi")
    @Expose
    private String diadiemMoi;
    @SerializedName("sotrang")
    @Expose
    private Integer sotrang;
    @SerializedName("mota2")
    @Expose
    private String mota2;
    @SerializedName("nguoinhap")
    @Expose
    private String nguoinhap;
    @SerializedName("noidung")
    @Expose
    private String noidung;
    @SerializedName("file")
    @Expose
    private Integer file;
    @SerializedName("duongdan")
    @Expose
    private String duongdan;

    protected TrichYeu(Parcel in) {
        mota1 = in.readString();
        if (in.readByte() == 0) {
            iGiayMoi = null;
        } else {
            iGiayMoi = in.readInt();
        }
        giomoi = in.readString();
        ngaymoi = in.readString();
        diadiemMoi = in.readString();
        if (in.readByte() == 0) {
            sotrang = null;
        } else {
            sotrang = in.readInt();
        }
        mota2 = in.readString();
        nguoinhap = in.readString();
        noidung = in.readString();
        if (in.readByte() == 0) {
            file = null;
        } else {
            file = in.readInt();
        }
        duongdan = in.readString();
    }

    public static final Creator<TrichYeu> CREATOR = new Creator<TrichYeu>() {
        @Override
        public TrichYeu createFromParcel(Parcel in) {
            return new TrichYeu(in);
        }

        @Override
        public TrichYeu[] newArray(int size) {
            return new TrichYeu[size];
        }
    };

    public String getMota1() {
        return mota1;
    }

    public void setMota1(String mota1) {
        this.mota1 = mota1;
    }

    public Integer getIGiayMoi() {
        return iGiayMoi;
    }

    public void setIGiayMoi(Integer iGiayMoi) {
        this.iGiayMoi = iGiayMoi;
    }

    public String getGiomoi() {
        return giomoi;
    }

    public void setGiomoi(String giomoi) {
        this.giomoi = giomoi;
    }

    public String getNgaymoi() {
        return ngaymoi;
    }

    public void setNgaymoi(String ngaymoi) {
        this.ngaymoi = ngaymoi;
    }

    public String getDiadiemMoi() {
        return diadiemMoi;
    }

    public void setDiadiemMoi(String diadiemMoi) {
        this.diadiemMoi = diadiemMoi;
    }

    public Integer getSotrang() {
        return sotrang;
    }

    public void setSotrang(Integer sotrang) {
        this.sotrang = sotrang;
    }

    public String getMota2() {
        return mota2;
    }

    public void setMota2(String mota2) {
        this.mota2 = mota2;
    }

    public String getNguoinhap() {
        return nguoinhap;
    }

    public void setNguoinhap(String nguoinhap) {
        this.nguoinhap = nguoinhap;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public Integer getFile() {
        return file;
    }

    public void setFile(Integer file) {
        this.file = file;
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
        dest.writeString(mota1);
        if (iGiayMoi == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(iGiayMoi);
        }
        dest.writeString(giomoi);
        dest.writeString(ngaymoi);
        dest.writeString(diadiemMoi);
        if (sotrang == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(sotrang);
        }
        dest.writeString(mota2);
        dest.writeString(nguoinhap);
        dest.writeString(noidung);
        if (file == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(file);
        }
        dest.writeString(duongdan);
    }
}
