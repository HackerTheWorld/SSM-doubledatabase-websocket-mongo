package com.cn.hnust.pojo;

public class AdverEntity {
    private Integer id;

    private String adver_path;

    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdver_path() {
        return adver_path;
    }

    public void setAdver_path(String adver_path) {
        this.adver_path = adver_path == null ? null : adver_path.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}