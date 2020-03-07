package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaoCaoKetQuaCuocHop implements  Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("id_vb")
    @Expose
    private Integer idVb;
    @SerializedName("id_noidung")
    @Expose
    private Integer idNoidung;
    @SerializedName("ngay_phap")
    @Expose
    private String ngayPhap;
    @SerializedName("noi_gui")
    @Expose
    private String noiGui;
    @SerializedName("so_den")
    @Expose
    private String soDen;
    @SerializedName("so_kyhieu")
    @Expose
    private String soKyhieu;
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
    @SerializedName("noi_dung")
    @Expose
    private String noiDung;
    @SerializedName("noi_dung_chuyen")
    @Expose
    private String noiDungChuyen;
    @SerializedName("gui_phongs")
    @Expose
    private List<String> guiPhongs = null;
    @SerializedName("trinh_tus")
    @Expose
    private List<String> trinhTus = null;
    @SerializedName("dexuat_phong")
    @Expose
    private String dexuatPhong;
    @SerializedName("ketluan_cuochop")
    @Expose
    private String ketluanCuochop;
    @SerializedName("file_baocao")
    @Expose
    private String fileBaocao;
    @SerializedName("ykien_giamdoc")
    @Expose
    private String ykienGiamdoc;

    protected BaoCaoKetQuaCuocHop(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            idVb = null;
        } else {
            idVb = in.readInt();
        }
        if (in.readByte() == 0) {
            idNoidung = null;
        } else {
            idNoidung = in.readInt();
        }
        ngayPhap = in.readString();
        noiGui = in.readString();
        soDen = in.readString();
        soKyhieu = in.readString();
        mota = in.readString();
        giayMoiNgay = in.readString();
        giayMoiGio = in.readString();
        giayMoiDiadiem = in.readString();
        noiDung = in.readString();
        noiDungChuyen = in.readString();
        guiPhongs = in.createStringArrayList();
        trinhTus = in.createStringArrayList();
        dexuatPhong = in.readString();
        ketluanCuochop = in.readString();
        fileBaocao = in.readString();
        ykienGiamdoc = in.readString();
    }

    public static final Creator<BaoCaoKetQuaCuocHop> CREATOR = new Creator<BaoCaoKetQuaCuocHop>() {
        @Override
        public BaoCaoKetQuaCuocHop createFromParcel(Parcel in) {
            return new BaoCaoKetQuaCuocHop(in);
        }

        @Override
        public BaoCaoKetQuaCuocHop[] newArray(int size) {
            return new BaoCaoKetQuaCuocHop[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdVb() {
        return idVb;
    }

    public void setIdVb(Integer idVb) {
        this.idVb = idVb;
    }

    public Integer getIdNoidung() {
        return idNoidung;
    }

    public void setIdNoidung(Integer idNoidung) {
        this.idNoidung = idNoidung;
    }

    public String getNgayPhap() {
        return ngayPhap;
    }

    public void setNgayPhap(String ngayPhap) {
        this.ngayPhap = ngayPhap;
    }

    public String getNoiGui() {
        return noiGui;
    }

    public void setNoiGui(String noiGui) {
        this.noiGui = noiGui;
    }

    public String getSoDen() {
        return soDen;
    }

    public void setSoDen(String soDen) {
        this.soDen = soDen;
    }

    public String getSoKyhieu() {
        return soKyhieu;
    }

    public void setSoKyhieu(String soKyhieu) {
        this.soKyhieu = soKyhieu;
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

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNoiDungChuyen() {
        return noiDungChuyen;
    }

    public void setNoiDungChuyen(String noiDungChuyen) {
        this.noiDungChuyen = noiDungChuyen;
    }

    public List<String> getGuiPhongs() {
        return guiPhongs;
    }

    public void setGuiPhongs(List<String> guiPhongs) {
        this.guiPhongs = guiPhongs;
    }

    public List<String> getTrinhTus() {
        return trinhTus;
    }

    public void setTrinhTus(List<String> trinhTus) {
        this.trinhTus = trinhTus;
    }

    public String getDexuatPhong() {
        return dexuatPhong;
    }

    public void setDexuatPhong(String dexuatPhong) {
        this.dexuatPhong = dexuatPhong;
    }

    public String getKetluanCuochop() {
        return ketluanCuochop;
    }

    public void setKetluanCuochop(String ketluanCuochop) {
        this.ketluanCuochop = ketluanCuochop;
    }

    public String getFileBaocao() {
        return fileBaocao;
    }

    public void setFileBaocao(String fileBaocao) {
        this.fileBaocao = fileBaocao;
    }

    public String getYkienGiamdoc() {
        return ykienGiamdoc;
    }

    public void setYkienGiamdoc(String ykienGiamdoc) {
        this.ykienGiamdoc = ykienGiamdoc;
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
        if (idVb == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idVb);
        }
        if (idNoidung == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idNoidung);
        }
        dest.writeString(ngayPhap);
        dest.writeString(noiGui);
        dest.writeString(soDen);
        dest.writeString(soKyhieu);
        dest.writeString(mota);
        dest.writeString(giayMoiNgay);
        dest.writeString(giayMoiGio);
        dest.writeString(giayMoiDiadiem);
        dest.writeString(noiDung);
        dest.writeString(noiDungChuyen);
        dest.writeStringList(guiPhongs);
        dest.writeStringList(trinhTus);
        dest.writeString(dexuatPhong);
        dest.writeString(ketluanCuochop);
        dest.writeString(fileBaocao);
        dest.writeString(ykienGiamdoc);
    }
}
