package com.example.sockert.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Users {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String userName;
}
