package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhanLoaiCongChucCuaPhongTheoThang {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("chitiet")
    @Expose
    private List<Chitiet> chitiet = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Chitiet> getChitiet() {
        return chitiet;
    }

    public void setChitiet(List<Chitiet> chitiet) {
        this.chitiet = chitiet;
    }
}
