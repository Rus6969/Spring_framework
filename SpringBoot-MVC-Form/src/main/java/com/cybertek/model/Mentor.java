package com.cybertek.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Mentor {
    private String firstname;
    private String lastname;
    private String email;
    private String gender;
    private boolean graduated;
    private String batch;
    private String company;

}
