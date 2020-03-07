package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeXuatCongViecPhoiHopChoDuyet implements Parcelable {
    @SerializedName("idVB")
    @Expose
    private Integer idVB;
    @SerializedName("idPH")
    @Expose
    private Integer idPH;
    @SerializedName("soDen")
    @Expose
    private String soDen;
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("hanVanBan")
    @Expose
    private String hanVanBan;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
    @SerializedName("UrlFileTraLoi")
    @Expose
    private String urlFileTraLoi;
    @SerializedName("UrlFileYeuCau")
    @Expose
    private String urlFileYeuCau;
    @SerializedName("nguoiChuyen")
    @Expose
    private String nguoiChuyen;
    @SerializedName("thoiGianChuyen")
    @Expose
    private String thoiGianChuyen;
    @SerializedName("IdPhongPhoiHop")
    @Expose
    private Integer idPhongPhoiHop;
    @SerializedName("type")
    @Expose
    private Integer type;

    protected DeXuatCongViecPhoiHopChoDuyet(Parcel in) {
        if (in.readByte() == 0) {
            idVB = null;
        } else {
            idVB = in.readInt();
        }
        if (in.readByte() == 0) {
            idPH = null;
        } else {
            idPH = in.readInt();
        }
        soDen = in.readString();
        moTa = in.readString();
        hanVanBan = in.readString();
        urlFile = in.readString();
        noiDung = in.readString();
        urlFileTraLoi = in.readString();
        urlFileYeuCau = in.readString();
        nguoiChuyen = in.readString();
        thoiGianChuyen = in.readString();
        if (in.readByte() == 0) {
            idPhongPhoiHop = null;
        } else {
            idPhongPhoiHop = in.readInt();
        }
        if (in.readByte() == 0) {
            type = null;
        } else {
            type = in.readInt();
        }
    }

    public static final Creator<DeXuatCongViecPhoiHopChoDuyet> CREATOR = new Creator<DeXuatCongViecPhoiHopChoDuyet>() {
        @Override
        public DeXuatCongViecPhoiHopChoDuyet createFromParcel(Parcel in) {
            return new DeXuatCongViecPhoiHopChoDuyet(in);
        }

        @Override
        public DeXuatCongViecPhoiHopChoDuyet[] newArray(int size) {
            return new DeXuatCongViecPhoiHopChoDuyet[size];
        }
    };

    public Integer getIdVB() {
        return idVB;
    }

    public void setIdVB(Integer idVB) {
        this.idVB = idVB;
    }

    public Integer getIdPH() {
        return idPH;
    }

    public void setIdPH(Integer idPH) {
        this.idPH = idPH;
    }

    public String getSoDen() {
        return soDen;
    }

    public void setSoDen(String soDen) {
        this.soDen = soDen;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHanVanBan() {
        return hanVanBan;
    }

    public void setHanVanBan(String hanVanBan) {
        this.hanVanBan = hanVanBan;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getUrlFileTraLoi() {
        return urlFileTraLoi;
    }

    public void setUrlFileTraLoi(String urlFileTraLoi) {
        this.urlFileTraLoi = urlFileTraLoi;
    }

    public String getUrlFileYeuCau() {
        return urlFileYeuCau;
    }

    public void setUrlFileYeuCau(String urlFileYeuCau) {
        this.urlFileYeuCau = urlFileYeuCau;
    }

    public String getNguoiChuyen() {
        return nguoiChuyen;
    }

    public void setNguoiChuyen(String nguoiChuyen) {
        this.nguoiChuyen = nguoiChuyen;
    }

    public String getThoiGianChuyen() {
        return thoiGianChuyen;
    }

    public void setThoiGianChuyen(String thoiGianChuyen) {
        this.thoiGianChuyen = thoiGianChuyen;
    }

    public Integer getIdPhongPhoiHop() {
        return idPhongPhoiHop;
    }

    public void setIdPhongPhoiHop(Integer idPhongPhoiHop) {
        this.idPhongPhoiHop = idPhongPhoiHop;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (idVB == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idVB);
        }
        if (idPH == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idPH);
        }
        dest.writeString(soDen);
        dest.writeString(moTa);
        dest.writeString(hanVanBan);
        dest.writeString(urlFile);
        dest.writeString(noiDung);
        dest.writeString(urlFileTraLoi);
        dest.writeString(urlFileYeuCau);
        dest.writeString(nguoiChuyen);
        dest.writeString(thoiGianChuyen);
        if (idPhongPhoiHop == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idPhongPhoiHop);
        }
        if (type == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(type);
        }
    }
}
