package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VanBanPhoiHopTraLai implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;
    @SerializedName("soDen")
    @Expose
    private String soDen;
    @SerializedName("soKyHieu")
    @Expose
    private String soKyHieu;
    @SerializedName("noiGui")
    @Expose
    private String noiGui;
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
    @SerializedName("noiDungTuChoi")
    @Expose
    private String noiDungTuChoi;
    @SerializedName("idCanBoTuchoi")
    @Expose
    private Integer idCanBoTuchoi;
    @SerializedName("tenCanBoTuChoi")
    @Expose
    private String tenCanBoTuChoi;
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("hanGiaiQuyet")
    @Expose
    private String hanGiaiQuyet;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("idPhoPhong")
    @Expose
    private Integer idPhoPhong;
    @SerializedName("tenPhoPhong")
    @Expose
    private String tenPhoPhong;
    @SerializedName("chiDao")
    @Expose
    private String chiDao;
    @SerializedName("chiDaoChuTri")
    @Expose
    private String chiDaoChuTri;

    protected VanBanPhoiHopTraLai(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        ngayNhap = in.readString();
        soDen = in.readString();
        soKyHieu = in.readString();
        noiGui = in.readString();
        noiDung = in.readString();
        noiDungTuChoi = in.readString();
        if (in.readByte() == 0) {
            idCanBoTuchoi = null;
        } else {
            idCanBoTuchoi = in.readInt();
        }
        tenCanBoTuChoi = in.readString();
        moTa = in.readString();
        hanGiaiQuyet = in.readString();
        urlFile = in.readString();
        if (in.readByte() == 0) {
            idPhoPhong = null;
        } else {
            idPhoPhong = in.readInt();
        }
        tenPhoPhong = in.readString();
        chiDao = in.readString();
        chiDaoChuTri = in.readString();
    }

    public static final Creator<VanBanPhoiHopTraLai> CREATOR = new Creator<VanBanPhoiHopTraLai>() {
        @Override
        public VanBanPhoiHopTraLai createFromParcel(Parcel in) {
            return new VanBanPhoiHopTraLai(in);
        }

        @Override
        public VanBanPhoiHopTraLai[] newArray(int size) {
            return new VanBanPhoiHopTraLai[size];
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

    public String getSoDen() {
        return soDen;
    }

    public void setSoDen(String soDen) {
        this.soDen = soDen;
    }

    public String getSoKyHieu() {
        return soKyHieu;
    }

    public void setSoKyHieu(String soKyHieu) {
        this.soKyHieu = soKyHieu;
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

    public String getNoiDungTuChoi() {
        return noiDungTuChoi;
    }

    public void setNoiDungTuChoi(String noiDungTuChoi) {
        this.noiDungTuChoi = noiDungTuChoi;
    }

    public Integer getIdCanBoTuchoi() {
        return idCanBoTuchoi;
    }

    public void setIdCanBoTuchoi(Integer idCanBoTuchoi) {
        this.idCanBoTuchoi = idCanBoTuchoi;
    }

    public String getTenCanBoTuChoi() {
        return tenCanBoTuChoi;
    }

    public void setTenCanBoTuChoi(String tenCanBoTuChoi) {
        this.tenCanBoTuChoi = tenCanBoTuChoi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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

    public Integer getIdPhoPhong() {
        return idPhoPhong;
    }

    public void setIdPhoPhong(Integer idPhoPhong) {
        this.idPhoPhong = idPhoPhong;
    }

    public String getTenPhoPhong() {
        return tenPhoPhong;
    }

    public void setTenPhoPhong(String tenPhoPhong) {
        this.tenPhoPhong = tenPhoPhong;
    }

    public String getChiDao() {
        return chiDao;
    }

    public void setChiDao(String chiDao) {
        this.chiDao = chiDao;
    }

    public String getChiDaoChuTri() {
        return chiDaoChuTri;
    }

    public void setChiDaoChuTri(String chiDaoChuTri) {
        this.chiDaoChuTri = chiDaoChuTri;
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
        dest.writeString(soDen);
        dest.writeString(soKyHieu);
        dest.writeString(noiGui);
        dest.writeString(noiDung);
        dest.writeString(noiDungTuChoi);
        if (idCanBoTuchoi == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idCanBoTuchoi);
        }
        dest.writeString(tenCanBoTuChoi);
        dest.writeString(moTa);
        dest.writeString(hanGiaiQuyet);
        dest.writeString(urlFile);
        if (idPhoPhong == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idPhoPhong);
        }
        dest.writeString(tenPhoPhong);
        dest.writeString(chiDao);
        dest.writeString(chiDaoChuTri);
    }
}
