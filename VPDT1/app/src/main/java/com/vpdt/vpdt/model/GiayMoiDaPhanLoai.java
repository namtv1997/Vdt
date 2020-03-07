package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GiayMoiDaPhanLoai implements Parcelable {
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
    @SerializedName("giayMoiGio")
    @Expose
    private String giayMoiGio;
    @SerializedName("giayMoiNgay")
    @Expose
    private String giayMoiNgay;
    @SerializedName("giayMoiDiaDiem")
    @Expose
    private String giayMoiDiaDiem;
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("hanGiaiQuyet")
    @Expose
    private String hanGiaiQuyet;
    @SerializedName("idGiamDoc")
    @Expose
    private Integer idGiamDoc;
    @SerializedName("tenGiamDoc")
    @Expose
    private String tenGiamDoc;
    @SerializedName("idPhoGiamDoc")
    @Expose
    private Integer idPhoGiamDoc;
    @SerializedName("tenPhoGiamDoc")
    @Expose
    private String tenPhoGiamDoc;
    @SerializedName("idPhongChuTri")
    @Expose
    private Integer idPhongChuTri;
    @SerializedName("tenPhongChuTri")
    @Expose
    private String tenPhongChuTri;
    @SerializedName("idPhongPhoiHop")
    @Expose
    private String idPhongPhoiHop;
    @SerializedName("chiDaoGiamDoc")
    @Expose
    private String chiDaoGiamDoc;
    @SerializedName("chiDaoPhoGiamDoc")
    @Expose
    private String chiDaoPhoGiamDoc;
    @SerializedName("chiChuTri")
    @Expose
    private String chiChuTri;
    @SerializedName("giamDocDuHop")
    @Expose
    private Integer giamDocDuHop;
    @SerializedName("PhongDuHop")
    @Expose
    private Integer phongDuHop;

    protected GiayMoiDaPhanLoai(Parcel in) {
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
        giayMoiGio = in.readString();
        giayMoiNgay = in.readString();
        giayMoiDiaDiem = in.readString();
        noiDung = in.readString();
        urlFile = in.readString();
        hanGiaiQuyet = in.readString();
        if (in.readByte() == 0) {
            idGiamDoc = null;
        } else {
            idGiamDoc = in.readInt();
        }
        tenGiamDoc = in.readString();
        if (in.readByte() == 0) {
            idPhoGiamDoc = null;
        } else {
            idPhoGiamDoc = in.readInt();
        }
        tenPhoGiamDoc = in.readString();
        if (in.readByte() == 0) {
            idPhongChuTri = null;
        } else {
            idPhongChuTri = in.readInt();
        }
        tenPhongChuTri = in.readString();
        idPhongPhoiHop = in.readString();
        chiDaoGiamDoc = in.readString();
        chiDaoPhoGiamDoc = in.readString();
        chiChuTri = in.readString();
        if (in.readByte() == 0) {
            giamDocDuHop = null;
        } else {
            giamDocDuHop = in.readInt();
        }
        if (in.readByte() == 0) {
            phongDuHop = null;
        } else {
            phongDuHop = in.readInt();
        }
    }

    public static final Creator<GiayMoiDaPhanLoai> CREATOR = new Creator<GiayMoiDaPhanLoai>() {
        @Override
        public GiayMoiDaPhanLoai createFromParcel(Parcel in) {
            return new GiayMoiDaPhanLoai(in);
        }

        @Override
        public GiayMoiDaPhanLoai[] newArray(int size) {
            return new GiayMoiDaPhanLoai[size];
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

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public String getHanGiaiQuyet() {
        return hanGiaiQuyet;
    }

    public void setHanGiaiQuyet(String hanGiaiQuyet) {
        this.hanGiaiQuyet = hanGiaiQuyet;
    }

    public Integer getIdGiamDoc() {
        return idGiamDoc;
    }

    public void setIdGiamDoc(Integer idGiamDoc) {
        this.idGiamDoc = idGiamDoc;
    }

    public String getTenGiamDoc() {
        return tenGiamDoc;
    }

    public void setTenGiamDoc(String tenGiamDoc) {
        this.tenGiamDoc = tenGiamDoc;
    }

    public Integer getIdPhoGiamDoc() {
        return idPhoGiamDoc;
    }

    public void setIdPhoGiamDoc(Integer idPhoGiamDoc) {
        this.idPhoGiamDoc = idPhoGiamDoc;
    }

    public String getTenPhoGiamDoc() {
        return tenPhoGiamDoc;
    }

    public void setTenPhoGiamDoc(String tenPhoGiamDoc) {
        this.tenPhoGiamDoc = tenPhoGiamDoc;
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

    public String getIdPhongPhoiHop() {
        return idPhongPhoiHop;
    }

    public void setIdPhongPhoiHop(String idPhongPhoiHop) {
        this.idPhongPhoiHop = idPhongPhoiHop;
    }

    public String getChiDaoGiamDoc() {
        return chiDaoGiamDoc;
    }

    public void setChiDaoGiamDoc(String chiDaoGiamDoc) {
        this.chiDaoGiamDoc = chiDaoGiamDoc;
    }

    public String getChiDaoPhoGiamDoc() {
        return chiDaoPhoGiamDoc;
    }

    public void setChiDaoPhoGiamDoc(String chiDaoPhoGiamDoc) {
        this.chiDaoPhoGiamDoc = chiDaoPhoGiamDoc;
    }

    public String getChiChuTri() {
        return chiChuTri;
    }

    public void setChiChuTri(String chiChuTri) {
        this.chiChuTri = chiChuTri;
    }

    public Integer getGiamDocDuHop() {
        return giamDocDuHop;
    }

    public void setGiamDocDuHop(Integer giamDocDuHop) {
        this.giamDocDuHop = giamDocDuHop;
    }

    public Integer getPhongDuHop() {
        return phongDuHop;
    }

    public void setPhongDuHop(Integer phongDuHop) {
        this.phongDuHop = phongDuHop;
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
        dest.writeString(giayMoiGio);
        dest.writeString(giayMoiNgay);
        dest.writeString(giayMoiDiaDiem);
        dest.writeString(noiDung);
        dest.writeString(urlFile);
        dest.writeString(hanGiaiQuyet);
        if (idGiamDoc == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idGiamDoc);
        }
        dest.writeString(tenGiamDoc);
        if (idPhoGiamDoc == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idPhoGiamDoc);
        }
        dest.writeString(tenPhoGiamDoc);
        if (idPhongChuTri == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idPhongChuTri);
        }
        dest.writeString(tenPhongChuTri);
        dest.writeString(idPhongPhoiHop);
        dest.writeString(chiDaoGiamDoc);
        dest.writeString(chiDaoPhoGiamDoc);
        dest.writeString(chiChuTri);
        if (giamDocDuHop == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(giamDocDuHop);
        }
        if (phongDuHop == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(phongDuHop);
        }
    }
}
