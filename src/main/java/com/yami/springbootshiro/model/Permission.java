package com.yami.springbootshiro.model;

public class Permission {
    private Integer pid;

    private String name;

    private String url;

    public Integer getId() {
        return pid;
    }

    public void setId(Integer id) {
        this.pid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
