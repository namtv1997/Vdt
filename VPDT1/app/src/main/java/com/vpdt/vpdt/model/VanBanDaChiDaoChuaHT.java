package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VanBanDaChiDaoChuaHT implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("idChiCuc")
    @Expose
    private Integer idChiCuc;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;
    @SerializedName("hanGiaiQuyet")
    @Expose
    private String hanGiaiQuyet;
    @SerializedName("hanThongKe")
    @Expose
    private String hanThongKe;
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
    @SerializedName("tenChiCucPho")
    @Expose
    private String tenChiCucPho;
    @SerializedName("idChiCucPho")
    @Expose
    private Integer idChiCucPho;
    @SerializedName("tenTruongPhong")
    @Expose
    private String tenTruongPhong;
    @SerializedName("idTruongPhong")
    @Expose
    private Integer idTruongPhong;
    @SerializedName("idTruongPhongPPs")
    @Expose
    private String idTruongPhongPPs;
    @SerializedName("chiDaoChiCucPho")
    @Expose
    private String chiDaoChiCucPho;
    @SerializedName("chiDaoChuTri")
    @Expose
    private String chiDaoChuTri;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;

    protected VanBanDaChiDaoChuaHT(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            idChiCuc = null;
        } else {
            idChiCuc = in.readInt();
        }
        ngayNhap = in.readString();
        hanGiaiQuyet = in.readString();
        hanThongKe = in.readString();
        moTa = in.readString();
        soKyHieu = in.readString();
        soDen = in.readString();
        noiGui = in.readString();
        noiDung = in.readString();
        tenChiCucPho = in.readString();
        if (in.readByte() == 0) {
            idChiCucPho = null;
        } else {
            idChiCucPho = in.readInt();
        }
        tenTruongPhong = in.readString();
        if (in.readByte() == 0) {
            idTruongPhong = null;
        } else {
            idTruongPhong = in.readInt();
        }
        idTruongPhongPPs = in.readString();
        chiDaoChiCucPho = in.readString();
        chiDaoChuTri = in.readString();
        urlFile = in.readString();
    }

    public static final Creator<VanBanDaChiDaoChuaHT> CREATOR = new Creator<VanBanDaChiDaoChuaHT>() {
        @Override
        public VanBanDaChiDaoChuaHT createFromParcel(Parcel in) {
            return new VanBanDaChiDaoChuaHT(in);
        }

        @Override
        public VanBanDaChiDaoChuaHT[] newArray(int size) {
            return new VanBanDaChiDaoChuaHT[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdChiCuc() {
        return idChiCuc;
    }

    public void setIdChiCuc(Integer idChiCuc) {
        this.idChiCuc = idChiCuc;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getHanGiaiQuyet() {
        return hanGiaiQuyet;
    }

    public void setHanGiaiQuyet(String hanGiaiQuyet) {
        this.hanGiaiQuyet = hanGiaiQuyet;
    }

    public String getHanThongKe() {
        return hanThongKe;
    }

    public void setHanThongKe(String hanThongKe) {
        this.hanThongKe = hanThongKe;
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

    public String getTenChiCucPho() {
        return tenChiCucPho;
    }

    public void setTenChiCucPho(String tenChiCucPho) {
        this.tenChiCucPho = tenChiCucPho;
    }

    public Integer getIdChiCucPho() {
        return idChiCucPho;
    }

    public void setIdChiCucPho(Integer idChiCucPho) {
        this.idChiCucPho = idChiCucPho;
    }

    public String getTenTruongPhong() {
        return tenTruongPhong;
    }

    public void setTenTruongPhong(String tenTruongPhong) {
        this.tenTruongPhong = tenTruongPhong;
    }

    public Integer getIdTruongPhong() {
        return idTruongPhong;
    }

    public void setIdTruongPhong(Integer idTruongPhong) {
        this.idTruongPhong = idTruongPhong;
    }

    public String getIdTruongPhongPPs() {
        return idTruongPhongPPs;
    }

    public void setIdTruongPhongPPs(String idTruongPhongPPs) {
        this.idTruongPhongPPs = idTruongPhongPPs;
    }

    public String getChiDaoChiCucPho() {
        return chiDaoChiCucPho;
    }

    public void setChiDaoChiCucPho(String chiDaoChiCucPho) {
        this.chiDaoChiCucPho = chiDaoChiCucPho;
    }

    public String getChiDaoChuTri() {
        return chiDaoChuTri;
    }

    public void setChiDaoChuTri(String chiDaoChuTri) {
        this.chiDaoChuTri = chiDaoChuTri;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
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
        if (idChiCuc == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idChiCuc);
        }
        dest.writeString(ngayNhap);
        dest.writeString(hanGiaiQuyet);
        dest.writeString(hanThongKe);
        dest.writeString(moTa);
        dest.writeString(soKyHieu);
        dest.writeString(soDen);
        dest.writeString(noiGui);
        dest.writeString(noiDung);
        dest.writeString(tenChiCucPho);
        if (idChiCucPho == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idChiCucPho);
        }
        dest.writeString(tenTruongPhong);
        if (idTruongPhong == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idTruongPhong);
        }
        dest.writeString(idTruongPhongPPs);
        dest.writeString(chiDaoChiCucPho);
        dest.writeString(chiDaoChuTri);
        dest.writeString(urlFile);
    }
}
