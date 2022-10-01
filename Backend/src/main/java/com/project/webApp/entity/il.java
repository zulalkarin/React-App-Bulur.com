package com.project.webApp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name= "il")
public class il {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

}
