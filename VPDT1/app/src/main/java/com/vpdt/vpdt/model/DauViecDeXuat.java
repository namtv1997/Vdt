package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DauViecDeXuat implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("id_vb")
    @Expose
    private Integer idVb;
    @SerializedName("ten_dauviec")
    @Expose
    private String tenDauviec;
    @SerializedName("nguoi_nhap")
    @Expose
    private String nguoiNhap;
    @SerializedName("ngay_nhap")
    @Expose
    private String ngayNhap;
    @SerializedName("han_vanban")
    @Expose
    private String hanVanban;
    @SerializedName("cb_dexuat")
    @Expose
    private String cbDexuat;
    @SerializedName("ly_do")
    @Expose
    private String lyDo;
    @SerializedName("han_cu")
    @Expose
    private String hanCu;
    @SerializedName("han_dexuat")
    @Expose
    private String hanDexuat;
    @SerializedName("trinhtu_chuyens")
    @Expose
    private List<String> trinhtuChuyens = null;

    protected DauViecDeXuat(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            idVb = null;
        } else {
            idVb = in.readInt();
        }
        tenDauviec = in.readString();
        nguoiNhap = in.readString();
        ngayNhap = in.readString();
        hanVanban = in.readString();
        cbDexuat = in.readString();
        lyDo = in.readString();
        hanCu = in.readString();
        hanDexuat = in.readString();
        trinhtuChuyens = in.createStringArrayList();
    }

    public static final Creator<DauViecDeXuat> CREATOR = new Creator<DauViecDeXuat>() {
        @Override
        public DauViecDeXuat createFromParcel(Parcel in) {
            return new DauViecDeXuat(in);
        }

        @Override
        public DauViecDeXuat[] newArray(int size) {
            return new DauViecDeXuat[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdVb() {
        return idVb;
    }

    public void setIdVb(Integer idVb) {
        this.idVb = idVb;
    }

    public String getTenDauviec() {
        return tenDauviec;
    }

    public void setTenDauviec(String tenDauviec) {
        this.tenDauviec = tenDauviec;
    }

    public String getNguoiNhap() {
        return nguoiNhap;
    }

    public void setNguoiNhap(String nguoiNhap) {
        this.nguoiNhap = nguoiNhap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getHanVanban() {
        return hanVanban;
    }

    public void setHanVanban(String hanVanban) {
        this.hanVanban = hanVanban;
    }

    public String getCbDexuat() {
        return cbDexuat;
    }

    public void setCbDexuat(String cbDexuat) {
        this.cbDexuat = cbDexuat;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getHanCu() {
        return hanCu;
    }

    public void setHanCu(String hanCu) {
        this.hanCu = hanCu;
    }

    public String getHanDexuat() {
        return hanDexuat;
    }

    public void setHanDexuat(String hanDexuat) {
        this.hanDexuat = hanDexuat;
    }

    public List<String> getTrinhtuChuyens() {
        return trinhtuChuyens;
    }

    public void setTrinhtuChuyens(List<String> trinhtuChuyens) {
        this.trinhtuChuyens = trinhtuChuyens;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        if (idVb == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idVb);
        }
        dest.writeString(tenDauviec);
        dest.writeString(nguoiNhap);
        dest.writeString(ngayNhap);
        dest.writeString(hanVanban);
        dest.writeString(cbDexuat);
        dest.writeString(lyDo);
        dest.writeString(hanCu);
        dest.writeString(hanDexuat);
        dest.writeStringList(trinhtuChuyens);
    }
}
