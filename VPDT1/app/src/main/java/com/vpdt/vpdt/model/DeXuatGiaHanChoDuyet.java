package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DeXuatGiaHanChoDuyet  implements Parcelable{
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("nguoiNhap")
    @Expose
    private String nguoiNhap;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;
    @SerializedName("hanVanBan")
    @Expose
    private String hanVanBan;
    @SerializedName("tenCanBoDeXuat")
    @Expose
    private String tenCanBoDeXuat;
    @SerializedName("lyDoChuyen")
    @Expose
    private String lyDoChuyen;
    @SerializedName("hanCu")
    @Expose
    private String hanCu;
    @SerializedName("hanDeXuat")
    @Expose
    private String hanDeXuat;
    @SerializedName("idDeXuat")
    @Expose
    private Integer idDeXuat;
    @SerializedName("allowDeXuatGiaHan")
    @Expose
    private Boolean allowDeXuatGiaHan;
    @SerializedName("trinhTuChuyen")
    @Expose
    private List<String> trinhTuChuyen = null;

    protected DeXuatGiaHanChoDuyet(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        moTa = in.readString();
        nguoiNhap = in.readString();
        ngayNhap = in.readString();
        hanVanBan = in.readString();
        tenCanBoDeXuat = in.readString();
        lyDoChuyen = in.readString();
        hanCu = in.readString();
        hanDeXuat = in.readString();
        if (in.readByte() == 0) {
            idDeXuat = null;
        } else {
            idDeXuat = in.readInt();
        }
        byte tmpAllowDeXuatGiaHan = in.readByte();
        allowDeXuatGiaHan = tmpAllowDeXuatGiaHan == 0 ? null : tmpAllowDeXuatGiaHan == 1;
        trinhTuChuyen = in.createStringArrayList();
    }

    public static final Creator<DeXuatGiaHanChoDuyet> CREATOR = new Creator<DeXuatGiaHanChoDuyet>() {
        @Override
        public DeXuatGiaHanChoDuyet createFromParcel(Parcel in) {
            return new DeXuatGiaHanChoDuyet(in);
        }

        @Override
        public DeXuatGiaHanChoDuyet[] newArray(int size) {
            return new DeXuatGiaHanChoDuyet[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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

    public String getHanVanBan() {
        return hanVanBan;
    }

    public void setHanVanBan(String hanVanBan) {
        this.hanVanBan = hanVanBan;
    }

    public String getTenCanBoDeXuat() {
        return tenCanBoDeXuat;
    }

    public void setTenCanBoDeXuat(String tenCanBoDeXuat) {
        this.tenCanBoDeXuat = tenCanBoDeXuat;
    }

    public String getLyDoChuyen() {
        return lyDoChuyen;
    }

    public void setLyDoChuyen(String lyDoChuyen) {
        this.lyDoChuyen = lyDoChuyen;
    }

    public String getHanCu() {
        return hanCu;
    }

    public void setHanCu(String hanCu) {
        this.hanCu = hanCu;
    }

    public String getHanDeXuat() {
        return hanDeXuat;
    }

    public void setHanDeXuat(String hanDeXuat) {
        this.hanDeXuat = hanDeXuat;
    }

    public Integer getIdDeXuat() {
        return idDeXuat;
    }

    public void setIdDeXuat(Integer idDeXuat) {
        this.idDeXuat = idDeXuat;
    }

    public Boolean getAllowDeXuatGiaHan() {
        return allowDeXuatGiaHan;
    }

    public void setAllowDeXuatGiaHan(Boolean allowDeXuatGiaHan) {
        this.allowDeXuatGiaHan = allowDeXuatGiaHan;
    }

    public List<String> getTrinhTuChuyen() {
        return trinhTuChuyen;
    }

    public void setTrinhTuChuyen(List<String> trinhTuChuyen) {
        this.trinhTuChuyen = trinhTuChuyen;
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
        dest.writeString(moTa);
        dest.writeString(nguoiNhap);
        dest.writeString(ngayNhap);
        dest.writeString(hanVanBan);
        dest.writeString(tenCanBoDeXuat);
        dest.writeString(lyDoChuyen);
        dest.writeString(hanCu);
        dest.writeString(hanDeXuat);
        if (idDeXuat == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idDeXuat);
        }
        dest.writeByte((byte) (allowDeXuatGiaHan == null ? 0 : allowDeXuatGiaHan ? 1 : 2));
        dest.writeStringList(trinhTuChuyen);
    }
}
