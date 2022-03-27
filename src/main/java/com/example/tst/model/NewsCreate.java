package com.example.tst.model;

import com.example.tst.entity.NewsEntity;

public class NewsCreate {
    private Long typeId;
    private String name;
    private String shortDescription;
    private String longDescription;

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public TypeForNews type;

    public static NewsCreate toModel(NewsEntity entity) {
        NewsCreate news = new NewsCreate();
        news.setName(entity.getName());
        news.setShortDescription(entity.getShortDescription());
        news.setLongDescription(entity.getLongDescription());
        news.setType(TypeForNews.toModel(entity.getType()));
        return news;
    }

    public TypeForNews getType() {
        return type;
    }

    public void setType(TypeForNews type) {
        this.type = type;
    }

    public NewsCreate() {
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
