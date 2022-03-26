package com.example.tst.model;

import com.example.tst.entity.NewsEntity;

public class News {
    private String name;
    private String s_description;
    public TypeForNews type;

    public TypeForNews getType() {
        return this.type;
    }

    public void setType(TypeForNews type) {
        this.type = type;
    }

    public static News toModel(NewsEntity entity) {
        News news = new News();
        news.setName(entity.getName());
        news.setS_description(entity.getS_description());
        news.setType(TypeForNews.toModel(entity.getType()));
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

    public News() {
    }
}