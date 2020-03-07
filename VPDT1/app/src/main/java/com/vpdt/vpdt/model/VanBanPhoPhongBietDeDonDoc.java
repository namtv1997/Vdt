package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VanBanPhoPhongBietDeDonDoc implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("soKyHieu")
    @Expose
    private String soKyHieu;
    @SerializedName("soDen")
    @Expose
    private String soDen;
    @SerializedName("noiGui")
    @Expose
    private String noiGui;
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
    @SerializedName("hanGiaiQuyet")
    @Expose
    private String hanGiaiQuyet;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("idChuyenVien")
    @Expose
    private Integer idChuyenVien;
    @SerializedName("tenChuyenVien")
    @Expose
    private String tenChuyenVien;
    @SerializedName("chiDaoChuTri")
    @Expose
    private String chiDaoChuTri;
    @SerializedName("idChuyenVienPhoiHops")
    @Expose
    private String idChuyenVienPhoiHops;
    @SerializedName("hanXuLy")
    @Expose
    private String hanXuLy;

    protected VanBanPhoPhongBietDeDonDoc(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        ngayNhap = in.readString();
        moTa = in.readString();
        soKyHieu = in.readString();
        soDen = in.readString();
        noiGui = in.readString();
        noiDung = in.readString();
        hanGiaiQuyet = in.readString();
        urlFile = in.readString();
        if (in.readByte() == 0) {
            idChuyenVien = null;
        } else {
            idChuyenVien = in.readInt();
        }
        tenChuyenVien = in.readString();
        chiDaoChuTri = in.readString();
        idChuyenVienPhoiHops = in.readString();
        hanXuLy = in.readString();
    }

    public static final Creator<VanBanPhoPhongBietDeDonDoc> CREATOR = new Creator<VanBanPhoPhongBietDeDonDoc>() {
        @Override
        public VanBanPhoPhongBietDeDonDoc createFromParcel(Parcel in) {
            return new VanBanPhoPhongBietDeDonDoc(in);
        }

        @Override
        public VanBanPhoPhongBietDeDonDoc[] newArray(int size) {
            return new VanBanPhoPhongBietDeDonDoc[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getSoKyHieu() {
        return soKyHieu;
    }

    public void setSoKyHieu(String soKyHieu) {
        this.soKyHieu = soKyHieu;
    }

    public String getSoDen() {
        return soDen;
    }

    public void setSoDen(String soDen) {
        this.soDen = soDen;
    }

    public String getNoiGui() {
        return noiGui;
    }

    public void setNoiGui(String noiGui) {
        this.noiGui = noiGui;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getHanGiaiQuyet() {
        return hanGiaiQuyet;
    }

    public void setHanGiaiQuyet(String hanGiaiQuyet) {
        this.hanGiaiQuyet = hanGiaiQuyet;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public Integer getIdChuyenVien() {
        return idChuyenVien;
    }

    public void setIdChuyenVien(Integer idChuyenVien) {
        this.idChuyenVien = idChuyenVien;
    }

    public String getTenChuyenVien() {
        return tenChuyenVien;
    }

    public void setTenChuyenVien(String tenChuyenVien) {
        this.tenChuyenVien = tenChuyenVien;
    }

    public String getChiDaoChuTri() {
        return chiDaoChuTri;
    }

    public void setChiDaoChuTri(String chiDaoChuTri) {
        this.chiDaoChuTri = chiDaoChuTri;
    }

    public String getIdChuyenVienPhoiHops() {
        return idChuyenVienPhoiHops;
    }

    public void setIdChuyenVienPhoiHops(String idChuyenVienPhoiHops) {
        this.idChuyenVienPhoiHops = idChuyenVienPhoiHops;
    }

    public String getHanXuLy() {
        return hanXuLy;
    }

    public void setHanXuLy(String hanXuLy) {
        this.hanXuLy = hanXuLy;
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
        dest.writeString(ngayNhap);
        dest.writeString(moTa);
        dest.writeString(soKyHieu);
        dest.writeString(soDen);
        dest.writeString(noiGui);
        dest.writeString(noiDung);
        dest.writeString(hanGiaiQuyet);
        dest.writeString(urlFile);
        if (idChuyenVien == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idChuyenVien);
        }
        dest.writeString(tenChuyenVien);
        dest.writeString(chiDaoChuTri);
        dest.writeString(idChuyenVienPhoiHops);
        dest.writeString(hanXuLy);
    }
}
