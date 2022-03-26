package com.example.tst.model;

import com.example.tst.entity.NewsEntity;

public class NewsForType {
    private String name;
    private String s_description;

    public static NewsForType toModel(NewsEntity entity) {
        NewsForType news = new NewsForType();
        news.setName(entity.getName());
        news.setS_description(entity.getS_description());
        return news;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getS_description() {
        return this.s_description;
    }

    public void setS_description(String s_description) {
        this.s_description = s_description;
    }

    public NewsForType() {
    }
}