package com.example.tst.model;

import com.example.tst.entity.NewsEntity;

public class NewsForType {
    private String name;

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    private String shortDescription;

    public static NewsForType toModel(NewsEntity entity) {
        NewsForType news = new NewsForType();
        news.setName(entity.getName());
        news.setShortDescription(entity.getShortDescription());
        return news;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NewsForType() {
    }
}