package com.jaycedam.websiteadmin.domain;

import javax.persistence.*;

@Entity
@Table
public class Area {
    @Id
    @SequenceGenerator(
            name="area_sequence",
            sequenceName = "area_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "area_sequence"
    )
    private Long id;
    private String name;

    public Area() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Area(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
