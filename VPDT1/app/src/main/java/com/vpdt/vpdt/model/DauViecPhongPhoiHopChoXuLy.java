package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DauViecPhongPhoiHopChoXuLy {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("items")
    @Expose
    private List<ItemDauViecPhoiHop> items = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public List<ItemDauViecPhoiHop> getItems() {
        return items;
    }

    public void setItems(List<ItemDauViecPhoiHop> items) {
        this.items = items;
    }
}
