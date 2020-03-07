package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GiayMoiChoLanhDaoXuLy implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ngay_nhap")
    @Expose
    private String ngayNhap;
    @SerializedName("so_kyhieu")
    @Expose
    private String soKyhieu;
    @SerializedName("so_den")
    @Expose
    private String soDen;
    @SerializedName("noi_gui")
    @Expose
    private String noiGui;
    @SerializedName("noi_dung")
    @Expose
    private String noiDung;
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("giay_moi_ngay")
    @Expose
    private String giayMoiNgay;
    @SerializedName("giay_moi_gio")
    @Expose
    private String giayMoiGio;
    @SerializedName("giay_moi_diadiem")
    @Expose
    private String giayMoiDiadiem;
    @SerializedName("noidung_chidao_gd")
    @Expose
    private String noidungChidaoGd;
    @SerializedName("noidung_chidao_pho_gd")
    @Expose
    private String noidungChidaoPhoGd;
    @SerializedName("noidung_chidao_phong_chutri")
    @Expose
    private String noidungChidaoPhongChutri;
    @SerializedName("giamdoc_duhop")
    @Expose
    private Boolean giamdocDuhop;
    @SerializedName("phong_duhop")
    @Expose
    private Boolean phongDuhop;
    @SerializedName("id_giamdoc")
    @Expose
    private Integer idGiamdoc;
    @SerializedName("id_pho_giamdoc")
    @Expose
    private Integer idPhoGiamdoc;
    @SerializedName("id_phong_chutri")
    @Expose
    private Integer idPhongChutri;
    @SerializedName("han_giaquyet")
    @Expose
    private String hanGiaquyet;
    @SerializedName("tep_dinh_kems")
    @Expose
    private List<TepDinhKem> tepDinhKems = null;
    @SerializedName("ten_pho_giamdoc")
    @Expose
    private String tenPhoGiamdoc;
    @SerializedName("ten_phong_chutri")
    @Expose
    private String tenPhongChutri;

    protected GiayMoiChoLanhDaoXuLy(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        ngayNhap = in.readString();
        soKyhieu = in.readString();
        soDen = in.readString();
        noiGui = in.readString();
        noiDung = in.readString();
        mota = in.readString();
        giayMoiNgay = in.readString();
        giayMoiGio = in.readString();
        giayMoiDiadiem = in.readString();
        noidungChidaoGd = in.readString();
        noidungChidaoPhoGd = in.readString();
        noidungChidaoPhongChutri = in.readString();
        byte tmpGiamdocDuhop = in.readByte();
        giamdocDuhop = tmpGiamdocDuhop == 0 ? null : tmpGiamdocDuhop == 1;
        byte tmpPhongDuhop = in.readByte();
        phongDuhop = tmpPhongDuhop == 0 ? null : tmpPhongDuhop == 1;
        if (in.readByte() == 0) {
            idGiamdoc = null;
        } else {
            idGiamdoc = in.readInt();
        }
        if (in.readByte() == 0) {
            idPhoGiamdoc = null;
        } else {
            idPhoGiamdoc = in.readInt();
        }
        if (in.readByte() == 0) {
            idPhongChutri = null;
        } else {
            idPhongChutri = in.readInt();
        }
        hanGiaquyet = in.readString();
        tepDinhKems = in.createTypedArrayList(TepDinhKem.CREATOR);
        tenPhoGiamdoc = in.readString();
        tenPhongChutri = in.readString();
    }

    public static final Creator<GiayMoiChoLanhDaoXuLy> CREATOR = new Creator<GiayMoiChoLanhDaoXuLy>() {
        @Override
        public GiayMoiChoLanhDaoXuLy createFromParcel(Parcel in) {
            return new GiayMoiChoLanhDaoXuLy(in);
        }

        @Override
        public GiayMoiChoLanhDaoXuLy[] newArray(int size) {
            return new GiayMoiChoLanhDaoXuLy[size];
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

    public String getSoKyhieu() {
        return soKyhieu;
    }

    public void setSoKyhieu(String soKyhieu) {
        this.soKyhieu = soKyhieu;
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

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getGiayMoiNgay() {
        return giayMoiNgay;
    }

    public void setGiayMoiNgay(String giayMoiNgay) {
        this.giayMoiNgay = giayMoiNgay;
    }

    public String getGiayMoiGio() {
        return giayMoiGio;
    }

    public void setGiayMoiGio(String giayMoiGio) {
        this.giayMoiGio = giayMoiGio;
    }

    public String getGiayMoiDiadiem() {
        return giayMoiDiadiem;
    }

    public void setGiayMoiDiadiem(String giayMoiDiadiem) {
        this.giayMoiDiadiem = giayMoiDiadiem;
    }

    public String getNoidungChidaoGd() {
        return noidungChidaoGd;
    }

    public void setNoidungChidaoGd(String noidungChidaoGd) {
        this.noidungChidaoGd = noidungChidaoGd;
    }

    public String getNoidungChidaoPhoGd() {
        return noidungChidaoPhoGd;
    }

    public void setNoidungChidaoPhoGd(String noidungChidaoPhoGd) {
        this.noidungChidaoPhoGd = noidungChidaoPhoGd;
    }

    public String getNoidungChidaoPhongChutri() {
        return noidungChidaoPhongChutri;
    }

    public void setNoidungChidaoPhongChutri(String noidungChidaoPhongChutri) {
        this.noidungChidaoPhongChutri = noidungChidaoPhongChutri;
    }

    public Boolean getGiamdocDuhop() {
        return giamdocDuhop;
    }

    public void setGiamdocDuhop(Boolean giamdocDuhop) {
        this.giamdocDuhop = giamdocDuhop;
    }

    public Boolean getPhongDuhop() {
        return phongDuhop;
    }

    public void setPhongDuhop(Boolean phongDuhop) {
        this.phongDuhop = phongDuhop;
    }

    public Integer getIdGiamdoc() {
        return idGiamdoc;
    }

    public void setIdGiamdoc(Integer idGiamdoc) {
        this.idGiamdoc = idGiamdoc;
    }

    public Integer getIdPhoGiamdoc() {
        return idPhoGiamdoc;
    }

    public void setIdPhoGiamdoc(Integer idPhoGiamdoc) {
        this.idPhoGiamdoc = idPhoGiamdoc;
    }

    public Integer getIdPhongChutri() {
        return idPhongChutri;
    }

    public void setIdPhongChutri(Integer idPhongChutri) {
        this.idPhongChutri = idPhongChutri;
    }

    public String getHanGiaquyet() {
        return hanGiaquyet;
    }

    public void setHanGiaquyet(String hanGiaquyet) {
        this.hanGiaquyet = hanGiaquyet;
    }

    public List<TepDinhKem> getTepDinhKems() {
        return tepDinhKems;
    }

    public void setTepDinhKems(List<TepDinhKem> tepDinhKems) {
        this.tepDinhKems = tepDinhKems;
    }

    public String getTenPhoGiamdoc() {
        return tenPhoGiamdoc;
    }

    public void setTenPhoGiamdoc(String tenPhoGiamdoc) {
        this.tenPhoGiamdoc = tenPhoGiamdoc;
    }

    public String getTenPhongChutri() {
        return tenPhongChutri;
    }

    public void setTenPhongChutri(String tenPhongChutri) {
        this.tenPhongChutri = tenPhongChutri;
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
        dest.writeString(soKyhieu);
        dest.writeString(soDen);
        dest.writeString(noiGui);
        dest.writeString(noiDung);
        dest.writeString(mota);
        dest.writeString(giayMoiNgay);
        dest.writeString(giayMoiGio);
        dest.writeString(giayMoiDiadiem);
        dest.writeString(noidungChidaoGd);
        dest.writeString(noidungChidaoPhoGd);
        dest.writeString(noidungChidaoPhongChutri);
        dest.writeByte((byte) (giamdocDuhop == null ? 0 : giamdocDuhop ? 1 : 2));
        dest.writeByte((byte) (phongDuhop == null ? 0 : phongDuhop ? 1 : 2));
        if (idGiamdoc == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idGiamdoc);
        }
        if (idPhoGiamdoc == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idPhoGiamdoc);
        }
        if (idPhongChutri == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idPhongChutri);
        }
        dest.writeString(hanGiaquyet);
        dest.writeTypedList(tepDinhKems);
        dest.writeString(tenPhoGiamdoc);
        dest.writeString(tenPhongChutri);
    }
}
