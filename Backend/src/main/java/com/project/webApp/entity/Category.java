package com.project.webApp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= "category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //otomatik 1 artan id ler oluşturur.
    Long id;

    String title;

}
