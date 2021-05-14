package com.cybertek.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "is_deleted")
    private Boolean isDeleted;


    /*
         @JsonIgnore do not see in api
         @Temporal Date we cam use eithe local time date ort DAte class
         This annotation must be specified for persistent fields or properties of type java.util.Date and java.util.Calendar.
         It may only be specified for fields or properties of these types.
         nullable = false,updatable = false - we use it when we update in DB if we do not add it data will be changed to null
     */
    @JsonIgnore
    @Column(name = "create_date",nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @JsonIgnore
    @Column(name = "updated_date",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @JsonIgnore
    @Column(name = "user_created",updatable = false)
    private Integer createUserId;

    @JsonIgnore
    @Column(name = "user_updated",nullable = false)
    private Integer updateUserId;

    @PrePersist
    private void onPersist(){
        this.createdDate=new Date();
        this.updatedDate=new Date();
        this.createUserId=1;
        this.updateUserId=1;
    }

    @PreUpdate
    private void onPreUpdate(){
        this.updatedDate=new Date();
        this.updateUserId=1;
    }
}