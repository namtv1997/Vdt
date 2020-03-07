package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Detail {
    @SerializedName("mavb")
    @Expose
    private Integer mavb;
    @SerializedName("mapb")
    @Expose
    private Integer mapb;
    @SerializedName("sodi")
    @Expose
    private Integer sodi;
    @SerializedName("kyhieu")
    @Expose
    private String kyhieu;
    @SerializedName("ngayVbdi")
    @Expose
    private String ngayVbdi;
    @SerializedName("loaivanban")
    @Expose
    private String loaivanban;
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("nguoiky")
    @Expose
    private String nguoiky;
    @SerializedName("tenPb")
    @Expose
    private String tenPb;

    public Integer getMavb() {
        return mavb;
    }

    public void setMavb(Integer mavb) {
        this.mavb = mavb;
    }

    public Integer getMapb() {
        return mapb;
    }

    public void setMapb(Integer mapb) {
        this.mapb = mapb;
    }

    public Integer getSodi() {
        return sodi;
    }

    public void setSodi(Integer sodi) {
        this.sodi = sodi;
    }

    public String getKyhieu() {
        return kyhieu;
    }

    public void setKyhieu(String kyhieu) {
        this.kyhieu = kyhieu;
    }

    public String getNgayVbdi() {
        return ngayVbdi;
    }

    public void setNgayVbdi(String ngayVbdi) {
        this.ngayVbdi = ngayVbdi;
    }

    public String getLoaivanban() {
        return loaivanban;
    }

    public void setLoaivanban(String loaivanban) {
        this.loaivanban = loaivanban;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getNguoiky() {
        return nguoiky;
    }

    public void setNguoiky(String nguoiky) {
        this.nguoiky = nguoiky;
    }

    public String getTenPb() {
        return tenPb;
    }

    public void setTenPb(String tenPb) {
        this.tenPb = tenPb;
    }
}
