package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NguoiNhan {
    @SerializedName("ten_canbo")
    @Expose
    private String tenCanbo;
    @SerializedName("thoi_gian_xem")
    @Expose
    private String thoiGianXem;

    public String getTenCanbo() {
        return tenCanbo;
    }

    public void setTenCanbo(String tenCanbo) {
        this.tenCanbo = tenCanbo;
    }

    public String getThoiGianXem() {
        return thoiGianXem;
    }

    public void setThoiGianXem(String thoiGianXem) {
        this.thoiGianXem = thoiGianXem;
    }
}
