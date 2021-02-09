package cinemaLab.entity;

import cinemaLab.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
// gave different name bc user reserved word in Spring boot
@Table(name = "user_account")
public class User extends  BaseEntity{
    private String email;
    private String password;
    private String username;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_detailed_id")
    private Account account ;

    @Enumerated(EnumType.STRING)
    private UserRole userRole = UserRole.USER;


    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
