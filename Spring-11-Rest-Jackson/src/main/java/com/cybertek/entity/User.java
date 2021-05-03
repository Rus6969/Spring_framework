package com.cybertek.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_account")
// do not pick up any values which are not described, {"hibernateLazyInitializer"} - whenever fetch is lazy it will add fieled hibernateinitilizer, if we do not want this fieled witthout it it will not run
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"}, ignoreUnknown = true)
public class User extends BaseEntity {

    private String email;
    // we do not want ignore password but we do not want to show password when we are getting password :getter =ignore/ setter show password(GET?POST)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String username;
    // if fetchtype lazy is used you should add {"hibernateLazyInitializer"}  to avoid spring triing serialize desirialize fieled which automaticzlly created with fettchtype/Lazy
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "account_details_id")
    // we do not show user account
    @JsonManagedReference
    private Account account;

    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
