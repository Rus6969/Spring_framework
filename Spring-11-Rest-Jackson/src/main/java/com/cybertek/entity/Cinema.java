package com.cybertek.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@NoArgsConstructor
// do not pick up any values which are not described, {"hibernateLazyInitializer"} - whenever fetch is lazy it will add fieled hibernateinitilizer, if we do not want this fieled witthout it it will not run
@JsonIgnoreProperties(value ={"hibernateLazyInitializer"},ignoreUnknown = true)
//here we show how do we want see names in JSon sponsore_name
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Cinema extends BaseEntity {

    private String name;
    private String sponsoredName;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Location location;

    public Cinema(String name, String sponsoredName) {
        this.name = name;
        this.sponsoredName = sponsoredName;
    }
}