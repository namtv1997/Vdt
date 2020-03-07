package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NguoiKy {
    @SerializedName("id_nguoiky")
    @Expose
    private Integer idNguoiky;
    @SerializedName("ten_nguoiky")
    @Expose
    private String tenNguoiky;
    @SerializedName("chon_nguoiky")
    @Expose
    private Integer chonNguoiky;
    @SerializedName("chucvu")
    @Expose
    private String chucvu;

    public Integer getIdNguoiky() {
        return idNguoiky;
    }

    public void setIdNguoiky(Integer idNguoiky) {
        this.idNguoiky = idNguoiky;
    }

    public String getTenNguoiky() {
        return tenNguoiky;
    }

    public void setTenNguoiky(String tenNguoiky) {
        this.tenNguoiky = tenNguoiky;
    }

    public Integer getChonNguoiky() {
        return chonNguoiky;
    }

    public void setChonNguoiky(Integer chonNguoiky) {
        this.chonNguoiky = chonNguoiky;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }
}
