package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VanBanHoanThanhChoLanhDaoPhongPheDuyet  implements Parcelable{
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
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("hanGiaiQuyet")
    @Expose
    private String hanGiaiQuyet;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("idNguoiHoanThanh")
    @Expose
    private String idNguoiHoanThanh;
    @SerializedName("tenNguoiHoanThanh")
    @Expose
    private String tenNguoiHoanThanh;
    @SerializedName("moTaHoanThanh")
    @Expose
    private String moTaHoanThanh;
    @SerializedName("lydoChuaHoanThanh")
    @Expose
    private String lydoChuaHoanThanh;
    @SerializedName("urlFileKetQua")
    @Expose
    private String urlFileKetQua;
    @SerializedName("trinhTuXuLy")
    @Expose
    private List<String> trinhTuXuLy = null;
    @SerializedName("vBCoDauRa")
    @Expose
    private Boolean vBCoDauRa;
    @SerializedName("canBoPheDuyet")
    @Expose
    private String canBoPheDuyet;
    @SerializedName("daPheDuyet")
    @Expose
    private Boolean daPheDuyet;
    @SerializedName("coSangTao")
    @Expose
    private Boolean coSangTao;
    @SerializedName("luuVaoKho")
    @Expose
    private Boolean luuVaoKho;

    protected VanBanHoanThanhChoLanhDaoPhongPheDuyet(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        ngayNhap = in.readString();
        soDen = in.readString();
        soKyHieu = in.readString();
        noiGui = in.readString();
        moTa = in.readString();
        hanGiaiQuyet = in.readString();
        urlFile = in.readString();
        idNguoiHoanThanh = in.readString();
        tenNguoiHoanThanh = in.readString();
        moTaHoanThanh = in.readString();
        lydoChuaHoanThanh = in.readString();
        urlFileKetQua = in.readString();
        trinhTuXuLy = in.createStringArrayList();
        byte tmpVBCoDauRa = in.readByte();
        vBCoDauRa = tmpVBCoDauRa == 0 ? null : tmpVBCoDauRa == 1;
        canBoPheDuyet = in.readString();
        byte tmpDaPheDuyet = in.readByte();
        daPheDuyet = tmpDaPheDuyet == 0 ? null : tmpDaPheDuyet == 1;
        byte tmpCoSangTao = in.readByte();
        coSangTao = tmpCoSangTao == 0 ? null : tmpCoSangTao == 1;
        byte tmpLuuVaoKho = in.readByte();
        luuVaoKho = tmpLuuVaoKho == 0 ? null : tmpLuuVaoKho == 1;
    }

    public static final Creator<VanBanHoanThanhChoLanhDaoPhongPheDuyet> CREATOR = new Creator<VanBanHoanThanhChoLanhDaoPhongPheDuyet>() {
        @Override
        public VanBanHoanThanhChoLanhDaoPhongPheDuyet createFromParcel(Parcel in) {
            return new VanBanHoanThanhChoLanhDaoPhongPheDuyet(in);
        }

        @Override
        public VanBanHoanThanhChoLanhDaoPhongPheDuyet[] newArray(int size) {
            return new VanBanHoanThanhChoLanhDaoPhongPheDuyet[size];
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

    public String getIdNguoiHoanThanh() {
        return idNguoiHoanThanh;
    }

    public void setIdNguoiHoanThanh(String idNguoiHoanThanh) {
        this.idNguoiHoanThanh = idNguoiHoanThanh;
    }

    public String getTenNguoiHoanThanh() {
        return tenNguoiHoanThanh;
    }

    public void setTenNguoiHoanThanh(String tenNguoiHoanThanh) {
        this.tenNguoiHoanThanh = tenNguoiHoanThanh;
    }

    public String getMoTaHoanThanh() {
        return moTaHoanThanh;
    }

    public void setMoTaHoanThanh(String moTaHoanThanh) {
        this.moTaHoanThanh = moTaHoanThanh;
    }

    public String getLydoChuaHoanThanh() {
        return lydoChuaHoanThanh;
    }

    public void setLydoChuaHoanThanh(String lydoChuaHoanThanh) {
        this.lydoChuaHoanThanh = lydoChuaHoanThanh;
    }

    public String getUrlFileKetQua() {
        return urlFileKetQua;
    }

    public void setUrlFileKetQua(String urlFileKetQua) {
        this.urlFileKetQua = urlFileKetQua;
    }

    public List<String> getTrinhTuXuLy() {
        return trinhTuXuLy;
    }

    public void setTrinhTuXuLy(List<String> trinhTuXuLy) {
        this.trinhTuXuLy = trinhTuXuLy;
    }

    public Boolean getVBCoDauRa() {
        return vBCoDauRa;
    }

    public void setVBCoDauRa(Boolean vBCoDauRa) {
        this.vBCoDauRa = vBCoDauRa;
    }

    public String getCanBoPheDuyet() {
        return canBoPheDuyet;
    }

    public void setCanBoPheDuyet(String canBoPheDuyet) {
        this.canBoPheDuyet = canBoPheDuyet;
    }

    public Boolean getDaPheDuyet() {
        return daPheDuyet;
    }

    public void setDaPheDuyet(Boolean daPheDuyet) {
        this.daPheDuyet = daPheDuyet;
    }

    public Boolean getCoSangTao() {
        return coSangTao;
    }

    public void setCoSangTao(Boolean coSangTao) {
        this.coSangTao = coSangTao;
    }

    public Boolean getLuuVaoKho() {
        return luuVaoKho;
    }

    public void setLuuVaoKho(Boolean luuVaoKho) {
        this.luuVaoKho = luuVaoKho;
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
        dest.writeString(moTa);
        dest.writeString(hanGiaiQuyet);
        dest.writeString(urlFile);
        dest.writeString(idNguoiHoanThanh);
        dest.writeString(tenNguoiHoanThanh);
        dest.writeString(moTaHoanThanh);
        dest.writeString(lydoChuaHoanThanh);
        dest.writeString(urlFileKetQua);
        dest.writeStringList(trinhTuXuLy);
        dest.writeByte((byte) (vBCoDauRa == null ? 0 : vBCoDauRa ? 1 : 2));
        dest.writeString(canBoPheDuyet);
        dest.writeByte((byte) (daPheDuyet == null ? 0 : daPheDuyet ? 1 : 2));
        dest.writeByte((byte) (coSangTao == null ? 0 : coSangTao ? 1 : 2));
        dest.writeByte((byte) (luuVaoKho == null ? 0 : luuVaoKho ? 1 : 2));
    }
}
