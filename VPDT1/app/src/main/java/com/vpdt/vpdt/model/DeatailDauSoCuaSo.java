package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DeatailDauSoCuaSo implements Parcelable {
    @SerializedName("mavb")
    @Expose
    private Integer mavb;
    @SerializedName("loaiVB")
    @Expose
    private String loaiVB;
    @SerializedName("kyhieu")
    @Expose
    private String kyhieu;
    @SerializedName("trichyeu")
    @Expose
    private TrichyeuChoSoCuaSo trichyeu;
    @SerializedName("noinhan")
    @Expose
    private List<Noinhan> noinhan = null;
    @SerializedName("iFile")
    @Expose
    private Integer iFile;
    @SerializedName("duongdan")
    @Expose
    private String duongdan;
    @SerializedName("sua_AND_xoa")
    @Expose
    private Integer suaANDXoa;
    @SerializedName("duyet")
    @Expose
    private Integer duyet;

    protected DeatailDauSoCuaSo(Parcel in) {
        if (in.readByte() == 0) {
            mavb = null;
        } else {
            mavb = in.readInt();
        }
        loaiVB = in.readString();
        kyhieu = in.readString();
        trichyeu = in.readParcelable(TrichyeuChoSoCuaSo.class.getClassLoader());
        noinhan = in.createTypedArrayList(Noinhan.CREATOR);
        if (in.readByte() == 0) {
            iFile = null;
        } else {
            iFile = in.readInt();
        }
        duongdan = in.readString();
        if (in.readByte() == 0) {
            suaANDXoa = null;
        } else {
            suaANDXoa = in.readInt();
        }
        if (in.readByte() == 0) {
            duyet = null;
        } else {
            duyet = in.readInt();
        }
    }

    public static final Creator<DeatailDauSoCuaSo> CREATOR = new Creator<DeatailDauSoCuaSo>() {
        @Override
        public DeatailDauSoCuaSo createFromParcel(Parcel in) {
            return new DeatailDauSoCuaSo(in);
        }

        @Override
        public DeatailDauSoCuaSo[] newArray(int size) {
            return new DeatailDauSoCuaSo[size];
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

    public String getKyhieu() {
        return kyhieu;
    }

    public void setKyhieu(String kyhieu) {
        this.kyhieu = kyhieu;
    }

    public TrichyeuChoSoCuaSo getTrichyeu() {
        return trichyeu;
    }

    public void setTrichyeu(TrichyeuChoSoCuaSo trichyeu) {
        this.trichyeu = trichyeu;
    }

    public List<Noinhan> getNoinhan() {
        return noinhan;
    }

    public void setNoinhan(List<Noinhan> noinhan) {
        this.noinhan = noinhan;
    }

    public Integer getIFile() {
        return iFile;
    }

    public void setIFile(Integer iFile) {
        this.iFile = iFile;
    }

    public String getDuongdan() {
        return duongdan;
    }

    public void setDuongdan(String duongdan) {
        this.duongdan = duongdan;
    }

    public Integer getSuaANDXoa() {
        return suaANDXoa;
    }

    public void setSuaANDXoa(Integer suaANDXoa) {
        this.suaANDXoa = suaANDXoa;
    }

    public Integer getDuyet() {
        return duyet;
    }

    public void setDuyet(Integer duyet) {
        this.duyet = duyet;
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
        dest.writeString(kyhieu);
        dest.writeParcelable(trichyeu, flags);
        dest.writeTypedList(noinhan);
        if (iFile == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(iFile);
        }
        dest.writeString(duongdan);
        if (suaANDXoa == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(suaANDXoa);
        }
        if (duyet == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(duyet);
        }
    }
}
