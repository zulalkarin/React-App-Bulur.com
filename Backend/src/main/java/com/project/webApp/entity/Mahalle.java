package com.project.webApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name= "mahalle")
@Data
public class Mahalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;


   // Long ilId;
    @ManyToOne
    @JoinColumn(name = "il_id")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    il il;

    //Long ilceId;
    @ManyToOne
    @JoinColumn(name = "ilce_id")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    ilce ilce;
}
