package com.project.webApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="ilce")
@Data
public class ilce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    //Long ilId;
    @ManyToOne
    @JoinColumn(name = "il_id")
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    il il;


}
