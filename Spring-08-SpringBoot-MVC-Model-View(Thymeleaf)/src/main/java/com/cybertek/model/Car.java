package com.cybertek.model;

import com.cybertek.enums.Brand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Car {
    private Brand brand;
    private int year;
    private double engine;
    private String color;


}
