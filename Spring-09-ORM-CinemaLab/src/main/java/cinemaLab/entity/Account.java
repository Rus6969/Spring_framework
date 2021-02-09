package cinemaLab.entity;

import cinemaLab.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Account extends BaseEntity {

    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    @Column(name = "postal_code")
    private String postalCode;


    @Enumerated(EnumType.STRING)
    private UserRole userRole = UserRole.USER;

    public Account(String name, String address, String country, String state, String city, Integer age, String postalCode, User user) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.state = state;
        this.city = city;
        this.age = age;
        this.postalCode = postalCode;
        this.user = user;
    }

    @OneToOne(mappedBy = "account")
    private User user;


}
