package com.cybertek.entity;

import com.cybertek.enums.UserRole;
import com.cybertek.enums.UserState;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
/*
“soft delete” approach. That’s mean that when someone deletes any entity
it remains in a database but a special field (e.g. ‘isDeleted’)
changes its value to true. As you’ve already guessed in every SELECT operation for this kind of entities we need to apply condition:
WHERE isDeleted = false
It’s a little bit redundant and boring to append each time this condition to a SQL query. So I started look at solutions which could give me some elegant solution of the problem. Fortunately a colleague
 of mine have given me a hint how to deal with such cases. The answer is covered behind the Hibernate‘s annotation @Where.
 */
@Where(clause = "is_deleted=false")
public class User extends BaseEntity {
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false)

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private Boolean isVerified;

    @Enumerated(EnumType.STRING)
    private UserState state;
}
