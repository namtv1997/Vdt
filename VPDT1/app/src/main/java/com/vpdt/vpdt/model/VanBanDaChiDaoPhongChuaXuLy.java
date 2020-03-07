package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VanBanDaChiDaoPhongChuaXuLy implements Parcelable {
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
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
    @SerializedName("giayMoiGio")
    @Expose
    private String giayMoiGio;
    @SerializedName("giayMoiNgay")
    @Expose
    private String giayMoiNgay;
    @SerializedName("giayMoiDiaDiem")
    @Expose
    private String giayMoiDiaDiem;
    @SerializedName("noiGui")
    @Expose
    private String noiGui;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("idLanhDao")
    @Expose
    private Integer idLanhDao;
    @SerializedName("tenLanhDao")
    @Expose
    private String tenLanhDao;
    @SerializedName("idPhongChuTri")
    @Expose
    private Integer idPhongChuTri;
    @SerializedName("tenPhongChuTri")
    @Expose
    private String tenPhongChuTri;
    @SerializedName("idPhongPhoiHops")
    @Expose
    private String idPhongPhoiHops;
    @SerializedName("chidaoLanhDao")
    @Expose
    private String chidaoLanhDao;
    @SerializedName("chidaoPhong")
    @Expose
    private String chidaoPhong;
    @SerializedName("chiDaoPhoiHop")
    @Expose
    private String chiDaoPhoiHop;
    @SerializedName("hanGiaiQuyet")
    @Expose
    private String hanGiaiQuyet;

    protected VanBanDaChiDaoPhongChuaXuLy(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        ngayNhap = in.readString();
        soDen = in.readString();
        soKyHieu = in.readString();
        moTa = in.readString();
        noiDung = in.readString();
        giayMoiGio = in.readString();
        giayMoiNgay = in.readString();
        giayMoiDiaDiem = in.readString();
        noiGui = in.readString();
        urlFile = in.readString();
        if (in.readByte() == 0) {
            idLanhDao = null;
        } else {
            idLanhDao = in.readInt();
        }
        tenLanhDao = in.readString();
        if (in.readByte() == 0) {
            idPhongChuTri = null;
        } else {
            idPhongChuTri = in.readInt();
        }
        tenPhongChuTri = in.readString();
        idPhongPhoiHops = in.readString();
        chidaoLanhDao = in.readString();
        chidaoPhong = in.readString();
        chiDaoPhoiHop = in.readString();
        hanGiaiQuyet = in.readString();
    }

    public static final Creator<VanBanDaChiDaoPhongChuaXuLy> CREATOR = new Creator<VanBanDaChiDaoPhongChuaXuLy>() {
        @Override
        public VanBanDaChiDaoPhongChuaXuLy createFromParcel(Parcel in) {
            return new VanBanDaChiDaoPhongChuaXuLy(in);
        }

        @Override
        public VanBanDaChiDaoPhongChuaXuLy[] newArray(int size) {
            return new VanBanDaChiDaoPhongChuaXuLy[size];
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getGiayMoiGio() {
        return giayMoiGio;
    }

    public void setGiayMoiGio(String giayMoiGio) {
        this.giayMoiGio = giayMoiGio;
    }

    public String getGiayMoiNgay() {
        return giayMoiNgay;
    }

    public void setGiayMoiNgay(String giayMoiNgay) {
        this.giayMoiNgay = giayMoiNgay;
    }

    public String getGiayMoiDiaDiem() {
        return giayMoiDiaDiem;
    }

    public void setGiayMoiDiaDiem(String giayMoiDiaDiem) {
        this.giayMoiDiaDiem = giayMoiDiaDiem;
    }

    public String getNoiGui() {
        return noiGui;
    }

    public void setNoiGui(String noiGui) {
        this.noiGui = noiGui;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public Integer getIdLanhDao() {
        return idLanhDao;
    }

    public void setIdLanhDao(Integer idLanhDao) {
        this.idLanhDao = idLanhDao;
    }

    public String getTenLanhDao() {
        return tenLanhDao;
    }

    public void setTenLanhDao(String tenLanhDao) {
        this.tenLanhDao = tenLanhDao;
    }

    public Integer getIdPhongChuTri() {
        return idPhongChuTri;
    }

    public void setIdPhongChuTri(Integer idPhongChuTri) {
        this.idPhongChuTri = idPhongChuTri;
    }

    public String getTenPhongChuTri() {
        return tenPhongChuTri;
    }

    public void setTenPhongChuTri(String tenPhongChuTri) {
        this.tenPhongChuTri = tenPhongChuTri;
    }

    public String getIdPhongPhoiHops() {
        return idPhongPhoiHops;
    }

    public void setIdPhongPhoiHops(String idPhongPhoiHops) {
        this.idPhongPhoiHops = idPhongPhoiHops;
    }

    public String getChidaoLanhDao() {
        return chidaoLanhDao;
    }

    public void setChidaoLanhDao(String chidaoLanhDao) {
        this.chidaoLanhDao = chidaoLanhDao;
    }

    public String getChidaoPhong() {
        return chidaoPhong;
    }

    public void setChidaoPhong(String chidaoPhong) {
        this.chidaoPhong = chidaoPhong;
    }

    public String getChiDaoPhoiHop() {
        return chiDaoPhoiHop;
    }

    public void setChiDaoPhoiHop(String chiDaoPhoiHop) {
        this.chiDaoPhoiHop = chiDaoPhoiHop;
    }

    public String getHanGiaiQuyet() {
        return hanGiaiQuyet;
    }

    public void setHanGiaiQuyet(String hanGiaiQuyet) {
        this.hanGiaiQuyet = hanGiaiQuyet;
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
        dest.writeString(moTa);
        dest.writeString(noiDung);
        dest.writeString(giayMoiGio);
        dest.writeString(giayMoiNgay);
        dest.writeString(giayMoiDiaDiem);
        dest.writeString(noiGui);
        dest.writeString(urlFile);
        if (idLanhDao == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idLanhDao);
        }
        dest.writeString(tenLanhDao);
        if (idPhongChuTri == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idPhongChuTri);
        }
        dest.writeString(tenPhongChuTri);
        dest.writeString(idPhongPhoiHops);
        dest.writeString(chidaoLanhDao);
        dest.writeString(chidaoPhong);
        dest.writeString(chiDaoPhoiHop);
        dest.writeString(hanGiaiQuyet);
    }
}
