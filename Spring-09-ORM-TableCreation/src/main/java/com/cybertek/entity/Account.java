package com.cybertek.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

@MappedSuperclass
public class Account {
    @Id
    private long id;
    private String owner;
    private BigDecimal balance;
    private BigDecimal interestRate;
}
