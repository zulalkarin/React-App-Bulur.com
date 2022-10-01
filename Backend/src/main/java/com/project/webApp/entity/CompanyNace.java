package com.project.webApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name ="CompanyNace")
@Data
public class CompanyNace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // Long companyId;
    @ManyToOne
    @JoinColumn(name = "company_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Company company;

     //Long naceId;
     @ManyToOne
     @JoinColumn(name = "nace_id")
     @OnDelete(action = OnDeleteAction.CASCADE)
     @JsonIgnore
     Nace nace;


}
