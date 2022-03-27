package com.example.tst.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(
        name = "type"
)
public class TypeEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String name;
    private String color;
    @OneToMany(
            cascade = {CascadeType.ALL},
            mappedBy = "type"
    )
    private List<NewsEntity> news;

    public List<NewsEntity> getNews() {
        return this.news;
    }

    public void setNews(List<NewsEntity> news) {
        this.news = news;
    }

    public TypeEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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
