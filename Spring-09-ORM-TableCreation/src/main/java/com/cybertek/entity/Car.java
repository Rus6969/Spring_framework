package com.cybertek.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@Getter
@Setter
public class Car {

    // @id defines primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private String make ;
   private String model;
// we need here constructor with no id bc line 18 springBoot will create for us id. thats why we are not using @Allagrcontructor
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }
}
