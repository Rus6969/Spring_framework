package com.cybertek.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value ={"hibernateLazyInitializer"},ignoreUnknown = true)
public class Genre extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "genreList")
    //bhere we have manyToMany relationship also used MappedBy which allowed us use JsonIgnore
    @JsonIgnore
    private List<Movie> movieList = new ArrayList<>();

    public Genre(String name) {
        this.name = name;
    }
}