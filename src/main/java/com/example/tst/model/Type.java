package com.example.tst.model;
import com.example.tst.entity.TypeEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Type {
    private String name;
    private String color;
    private List<NewsForType> newsList;

    public List<NewsForType> getNewsList() {
        return this.newsList;
    }

    public void setNewsList(List<NewsForType> newsList) {
        this.newsList = newsList;
    }

    public static Type toModel(TypeEntity entity) {
        Type type = new Type();
        type.setName(entity.getName());
        type.setColor(entity.getColor());
        type.setNewsList((List)entity.getNews().stream().map(NewsForType::toModel).collect(Collectors.toList()));
        return type;
    }

    public Type() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}