package com.cybertek.entity;

import com.cybertek.enums.Gender;
import org.springframework.dao.DataAccessException;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "studentFirstName")
    private String firstName;  //first_name
    @Column(name = "studentLastName")
    private String lastName;
    @Column(name = "studentEmailAddres")
    private String email;
    // we use Transient annotaion to do not map this pojo to DB
    @Transient
    private String city;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Temporal(TemporalType.TIME)
    private Date birthTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDateTime;
// better put column defintion might cause a problem in MVC
    @Column(columnDefinition = "DATE")
    private LocalDate localDate;
    @Column(columnDefinition = "TIME")
    private LocalTime localTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime;
   // will take it as Integer need to convert to String

    @Enumerated(EnumType.STRING)
    private Gender gender ;


}
