package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VanbanBaoCaoTongHop implements Parcelable {
    @SerializedName("mavb")
    @Expose
    private Integer mavb;
    @SerializedName("soden")
    @Expose
    private Integer soden;
    @SerializedName("kyhieu")
    @Expose
    private String kyhieu;
    @SerializedName("ngay_ban_hanh")
    @Expose
    private String ngayBanHanh;
    @SerializedName("noidung")
    @Expose
    private String noidung;
    @SerializedName("duongdan_noidung")
    @Expose
    private String duongdanNoidung;
    @SerializedName("ngaygiao")
    @Expose
    private String ngaygiao;
    @SerializedName("donvi")
    @Expose
    private String donvi;
    @SerializedName("donvi_phoihop")
    @Expose
    private String donviPhoihop;
    @SerializedName("tgian_ht")
    @Expose
    private String tgianHt;
    @SerializedName("tgian_giahan")
    @Expose
    private String tgianGiahan;
    @SerializedName("ketqua")
    @Expose
    private String ketqua;
    @SerializedName("duongdan_ketqua")
    @Expose
    private String duongdanKetqua;
    @SerializedName("dangtrienkhai_tronghan")
    @Expose
    private String dangtrienkhaiTronghan;
    @SerializedName("dangtrienkhai_quahan")
    @Expose
    private String dangtrienkhaiQuahan;
    @SerializedName("hoanthanh_tronghan")
    @Expose
    private String hoanthanhTronghan;
    @SerializedName("hoanthanh_quahan")
    @Expose
    private String hoanthanhQuahan;

    protected VanbanBaoCaoTongHop(Parcel in) {
        if (in.readByte() == 0) {
            mavb = null;
        } else {
            mavb = in.readInt();
        }
        if (in.readByte() == 0) {
            soden = null;
        } else {
            soden = in.readInt();
        }
        kyhieu = in.readString();
        ngayBanHanh = in.readString();
        noidung = in.readString();
        duongdanNoidung = in.readString();
        ngaygiao = in.readString();
        donvi = in.readString();
        donviPhoihop = in.readString();
        tgianHt = in.readString();
        tgianGiahan = in.readString();
        ketqua = in.readString();
        duongdanKetqua = in.readString();
        dangtrienkhaiTronghan = in.readString();
        dangtrienkhaiQuahan = in.readString();
        hoanthanhTronghan = in.readString();
        hoanthanhQuahan = in.readString();
    }

    public static final Creator<VanbanBaoCaoTongHop> CREATOR = new Creator<VanbanBaoCaoTongHop>() {
        @Override
        public VanbanBaoCaoTongHop createFromParcel(Parcel in) {
            return new VanbanBaoCaoTongHop(in);
        }

        @Override
        public VanbanBaoCaoTongHop[] newArray(int size) {
            return new VanbanBaoCaoTongHop[size];
        }
    };

    public Integer getMavb() {
        return mavb;
    }

    public void setMavb(Integer mavb) {
        this.mavb = mavb;
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

    public String getNgayBanHanh() {
        return ngayBanHanh;
    }

    public void setNgayBanHanh(String ngayBanHanh) {
        this.ngayBanHanh = ngayBanHanh;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getDuongdanNoidung() {
        return duongdanNoidung;
    }

    public void setDuongdanNoidung(String duongdanNoidung) {
        this.duongdanNoidung = duongdanNoidung;
    }

    public String getNgaygiao() {
        return ngaygiao;
    }

    public void setNgaygiao(String ngaygiao) {
        this.ngaygiao = ngaygiao;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public String getDonviPhoihop() {
        return donviPhoihop;
    }

    public void setDonviPhoihop(String donviPhoihop) {
        this.donviPhoihop = donviPhoihop;
    }

    public String getTgianHt() {
        return tgianHt;
    }

    public void setTgianHt(String tgianHt) {
        this.tgianHt = tgianHt;
    }

    public String getTgianGiahan() {
        return tgianGiahan;
    }

    public void setTgianGiahan(String tgianGiahan) {
        this.tgianGiahan = tgianGiahan;
    }

    public String getKetqua() {
        return ketqua;
    }

    public void setKetqua(String ketqua) {
        this.ketqua = ketqua;
    }

    public String getDuongdanKetqua() {
        return duongdanKetqua;
    }

    public void setDuongdanKetqua(String duongdanKetqua) {
        this.duongdanKetqua = duongdanKetqua;
    }

    public String getDangtrienkhaiTronghan() {
        return dangtrienkhaiTronghan;
    }

    public void setDangtrienkhaiTronghan(String dangtrienkhaiTronghan) {
        this.dangtrienkhaiTronghan = dangtrienkhaiTronghan;
    }

    public String getDangtrienkhaiQuahan() {
        return dangtrienkhaiQuahan;
    }

    public void setDangtrienkhaiQuahan(String dangtrienkhaiQuahan) {
        this.dangtrienkhaiQuahan = dangtrienkhaiQuahan;
    }

    public String getHoanthanhTronghan() {
        return hoanthanhTronghan;
    }

    public void setHoanthanhTronghan(String hoanthanhTronghan) {
        this.hoanthanhTronghan = hoanthanhTronghan;
    }

    public String getHoanthanhQuahan() {
        return hoanthanhQuahan;
    }

    public void setHoanthanhQuahan(String hoanthanhQuahan) {
        this.hoanthanhQuahan = hoanthanhQuahan;
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
        if (soden == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(soden);
        }
        dest.writeString(kyhieu);
        dest.writeString(ngayBanHanh);
        dest.writeString(noidung);
        dest.writeString(duongdanNoidung);
        dest.writeString(ngaygiao);
        dest.writeString(donvi);
        dest.writeString(donviPhoihop);
        dest.writeString(tgianHt);
        dest.writeString(tgianGiahan);
        dest.writeString(ketqua);
        dest.writeString(duongdanKetqua);
        dest.writeString(dangtrienkhaiTronghan);
        dest.writeString(dangtrienkhaiQuahan);
        dest.writeString(hoanthanhTronghan);
        dest.writeString(hoanthanhQuahan);
    }
}
