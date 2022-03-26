package com.example.tst.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(
        name = "news"
)
public class NewsEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;
    private String s_description;
    private String l_description;
    @ManyToOne
    @JoinColumn(
            name = "type_id"
    )
    private TypeEntity type;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeEntity getType() {
        return this.type;
    }

    public void setType(TypeEntity type) {
        this.type = type;
    }

    public NewsEntity() {
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

    public String getL_description() {
        return this.l_description;
    }

    public void setL_description(String l_description) {
        this.l_description = l_description;
    }
}

