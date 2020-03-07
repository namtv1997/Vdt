package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VanBanCacPhongChuyenLai implements Parcelable {
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
    @SerializedName("noiDungTuChoi")
    @Expose
    private String noiDungTuChoi;
    @SerializedName("ghiChu")
    @Expose
    private String ghiChu;
    @SerializedName("tenPhongGuiLai")
    @Expose
    private String tenPhongGuiLai;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
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
    @SerializedName("hanGiaiQuyet")
    @Expose
    private String hanGiaiQuyet;
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

    protected VanBanCacPhongChuyenLai(Parcel in) {
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
        noiDungTuChoi = in.readString();
        ghiChu = in.readString();
        tenPhongGuiLai = in.readString();
        urlFile = in.readString();
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
        hanGiaiQuyet = in.readString();
        idPhongPhoiHop = in.readString();
        chiDaoGiamDoc = in.readString();
        chiDaoPhoGiamDoc = in.readString();
        chiChuTri = in.readString();
    }

    public static final Creator<VanBanCacPhongChuyenLai> CREATOR = new Creator<VanBanCacPhongChuyenLai>() {
        @Override
        public VanBanCacPhongChuyenLai createFromParcel(Parcel in) {
            return new VanBanCacPhongChuyenLai(in);
        }

        @Override
        public VanBanCacPhongChuyenLai[] newArray(int size) {
            return new VanBanCacPhongChuyenLai[size];
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

    public String getNoiDungTuChoi() {
        return noiDungTuChoi;
    }

    public void setNoiDungTuChoi(String noiDungTuChoi) {
        this.noiDungTuChoi = noiDungTuChoi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTenPhongGuiLai() {
        return tenPhongGuiLai;
    }

    public void setTenPhongGuiLai(String tenPhongGuiLai) {
        this.tenPhongGuiLai = tenPhongGuiLai;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
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

    public String getHanGiaiQuyet() {
        return hanGiaiQuyet;
    }

    public void setHanGiaiQuyet(String hanGiaiQuyet) {
        this.hanGiaiQuyet = hanGiaiQuyet;
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
        dest.writeString(noiDungTuChoi);
        dest.writeString(ghiChu);
        dest.writeString(tenPhongGuiLai);
        dest.writeString(urlFile);
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
        dest.writeString(hanGiaiQuyet);
        dest.writeString(idPhongPhoiHop);
        dest.writeString(chiDaoGiamDoc);
        dest.writeString(chiDaoPhoGiamDoc);
        dest.writeString(chiChuTri);
    }
}
