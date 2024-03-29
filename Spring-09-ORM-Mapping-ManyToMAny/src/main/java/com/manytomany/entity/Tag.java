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
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToMany(mappedBy = "tags",cascade = CascadeType.ALL)
    private Set<Post> posts = new HashSet<>();

    // many to many works only with additional table
    public Tag(String name) {
        this.name = name;
    }
}
