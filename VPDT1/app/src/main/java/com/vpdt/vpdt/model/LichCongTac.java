package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LichCongTac {
    @SerializedName("thu")
    @Expose
    private String thu;
    @SerializedName("ngay")
    @Expose
    private String ngay;
    @SerializedName("sang_lichcongtac")
    @Expose
    private List<SangLichcongtac> sangLichcongtac = null;
    @SerializedName("chieu_lichcongtac")
    @Expose
    private List<SangLichcongtac> chieuLichcongtac = null;

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public List<SangLichcongtac> getSangLichcongtac() {
        return sangLichcongtac;
    }

    public void setSangLichcongtac(List<SangLichcongtac> sangLichcongtac) {
        this.sangLichcongtac = sangLichcongtac;
    }

    public List<SangLichcongtac> getChieuLichcongtac() {
        return chieuLichcongtac;
    }

    public void setChieuLichcongtac(List<SangLichcongtac> chieuLichcongtac) {
        this.chieuLichcongtac = chieuLichcongtac;
    }
}
