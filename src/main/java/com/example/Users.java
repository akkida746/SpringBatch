package com.example;

/**
 * @author Akash Deep
 * @date 11/10/2019
 **/
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Users {

    @Id
    private Long userId;

    private String name;

    private String dept;

    private BigDecimal account;
}