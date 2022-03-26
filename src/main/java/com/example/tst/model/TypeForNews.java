package com.example.tst.model;

import com.example.tst.entity.TypeEntity;

public class TypeForNews {
    private String name;
    private String color;

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

    public TypeForNews() {
    }

    public static TypeForNews toModel(TypeEntity entity) {
        TypeForNews type = new TypeForNews();
        type.setName(entity.getName());
        type.setColor(entity.getColor());
        return type;
    }
}