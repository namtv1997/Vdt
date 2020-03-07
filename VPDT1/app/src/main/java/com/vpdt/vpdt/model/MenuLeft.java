package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MenuLeft {
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("soluong")
    @Expose
    private Integer soluong;
    @SerializedName("index")
    @Expose
    private Integer index;
    @SerializedName("show_total")
    @Expose
    private Boolean showTotal;
    @SerializedName("menus")
    @Expose
    private List<Contact> menus = null;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Boolean getShowTotal() {
        return showTotal;
    }

    public void setShowTotal(Boolean showTotal) {
        this.showTotal = showTotal;
    }

    public List<Contact> getMenus() {
        return menus;
    }

    public void setMenus(List<Contact> menus) {
        this.menus = menus;
    }
}
