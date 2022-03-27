package com.example.tst.model;

import com.example.tst.entity.NewsEntity;

public class News {
    private String name;
    private String shortDescription;
    public TypeForNews type;

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public TypeForNews getType() {
        return this.type;
    }

    public void setType(TypeForNews type) {
        this.type = type;
    }

    public static News toModel(NewsEntity entity) {
        News news = new News();
        news.setName(entity.getName());
        news.setShortDescription(entity.getShortDescription());
        news.setType(TypeForNews.toModel(entity.getType()));
        return news;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public News() {
    }
}