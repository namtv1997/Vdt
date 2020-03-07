package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VBPhoPhongPhoiHopChoXL implements Parcelable {
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
    @SerializedName("idPhoiHop")
    @Expose
    private Integer idPhoiHop;
    @SerializedName("idChuyenVienPhoiHops")
    @Expose
    private String idChuyenVienPhoiHops;
    @SerializedName("trinhTuXuLy")
    @Expose
    private List<String> trinhTuXuLy = null;

    protected VBPhoPhongPhoiHopChoXL(Parcel in) {
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
            idPhoPhong = null;
        } else {
            idPhoPhong = in.readInt();
        }
        tenPhoPhong = in.readString();
        chiDao = in.readString();
        chiDaoChuTri = in.readString();
        if (in.readByte() == 0) {
            idPhoiHop = null;
        } else {
            idPhoiHop = in.readInt();
        }
        idChuyenVienPhoiHops = in.readString();
        trinhTuXuLy = in.createStringArrayList();
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
        if (idPhoPhong == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idPhoPhong);
        }
        dest.writeString(tenPhoPhong);
        dest.writeString(chiDao);
        dest.writeString(chiDaoChuTri);
        if (idPhoiHop == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idPhoiHop);
        }
        dest.writeString(idChuyenVienPhoiHops);
        dest.writeStringList(trinhTuXuLy);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<VBPhoPhongPhoiHopChoXL> CREATOR = new Creator<VBPhoPhongPhoiHopChoXL>() {
        @Override
        public VBPhoPhongPhoiHopChoXL createFromParcel(Parcel in) {
            return new VBPhoPhongPhoiHopChoXL(in);
        }

        @Override
        public VBPhoPhongPhoiHopChoXL[] newArray(int size) {
            return new VBPhoPhongPhoiHopChoXL[size];
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

    public Integer getIdPhoiHop() {
        return idPhoiHop;
    }

    public void setIdPhoiHop(Integer idPhoiHop) {
        this.idPhoiHop = idPhoiHop;
    }

    public String getIdChuyenVienPhoiHops() {
        return idChuyenVienPhoiHops;
    }

    public void setIdChuyenVienPhoiHops(String idChuyenVienPhoiHops) {
        this.idChuyenVienPhoiHops = idChuyenVienPhoiHops;
    }

    public List<String> getTrinhTuXuLy() {
        return trinhTuXuLy;
    }

    public void setTrinhTuXuLy(List<String> trinhTuXuLy) {
        this.trinhTuXuLy = trinhTuXuLy;
    }
}
