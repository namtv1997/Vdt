package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DauViecPhongPhoiHopChoXuLyCC {
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
    private List<ItemDauViecPhongPhoiHopChoXuLyCC> items = null;

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

    public List<ItemDauViecPhongPhoiHopChoXuLyCC> getItems() {
        return items;
    }

    public void setItems(List<ItemDauViecPhongPhoiHopChoXuLyCC> items) {
        this.items = items;
    }
}
