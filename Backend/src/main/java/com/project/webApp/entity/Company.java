package com.project.webApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name= "company")
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String adress;
    String phoneNumber;
    String info;

   // Long categoryId;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)

    Category category;

    String title;

   // String ilId;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name="il_id")

    il il;

   //String ilceId;
   @ManyToOne (fetch = FetchType.EAGER)
   @JoinColumn(name="ilce_id")

    ilce ilce;

    //String mahalleId;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "mahalle_id")

    Mahalle mahalle;

    Long geocode; //long????

   // Long naceId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nace_id")

    @JsonIgnore
    Nace nace;




}
