package com.project.webApp.responses;

import com.project.webApp.entity.Company;
import lombok.Data;

@Data
public class CompanyResponse {

    Long id;
    String adress;
    String phoneNumber;
    String info;
    String title;
    Long categoryID;
    String categoryName;
    Long ilId;
    String ilName;
    Long ilceId;
    String ilceName;
    Long mahalleId;
    String mahalleName;

    public CompanyResponse(Company entity){
        this.id=entity.getId();
        this.adress= entity.getAdress();
        this.phoneNumber = entity.getPhoneNumber();
        this.info= entity.getInfo();
        this.title= entity.getTitle();
        this.categoryID=entity.getCategory().getId();
        this.categoryName=entity.getCategory().getTitle();
        this.ilId=entity.getIl().getId();
        this.ilName=entity.getIl().getName();
        this.ilceId=entity.getIlce().getId();
        this.ilceName=entity.getIlce().getName();
        this.mahalleId=entity.getMahalle().getId();
        this.mahalleName = entity.getMahalle().getName();
    }

}
