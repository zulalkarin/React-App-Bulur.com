package com.project.webApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "nace")
@Data
public class Nace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;

   // Long categoryId;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Category category;


}
