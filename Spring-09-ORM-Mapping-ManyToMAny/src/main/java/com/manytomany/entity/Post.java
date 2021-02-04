package com.manytomany.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    // many to many works only with additionla table
  //  when we work many to many we use set , bc of performance issue , if use lists hibernate will run queries twice
    @ManyToMany
    private Set<Tag> tags = new HashSet<>();

    public Post(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
