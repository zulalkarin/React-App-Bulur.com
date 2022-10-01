package com.project.webApp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity  //class'ı databas'e mapleyen annotation
@Table(name= "user")
@Data //lombok(getter setter otomatik oluşturur)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String userName;
    String password;
    String userRole; //admin or user
    String phoneNumber;
    String email;


}
