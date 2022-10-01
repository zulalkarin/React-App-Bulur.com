package com.project.webApp.services;

import com.project.webApp.entity.il;
import com.project.webApp.entity.ilce;
import com.project.webApp.repos.ilceRepo;
import com.project.webApp.repos.ilRepo;
import com.project.webApp.requests.ilceCreateRequest;
import com.project.webApp.requests.ilceUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ilceService {
    private ilceRepo ilceRepo;

    private ilService ilService;

    public ilceService(ilceRepo ilceRepo, ilService ilService) {
        this.ilceRepo = ilceRepo;
        this.ilService = ilService;
    }

    public List<ilce> getAllilces(Optional<Long> ilId) {
        if (ilId.isPresent())
            return ilceRepo.findByIlId(ilId);
        else
            return ilceRepo.findAll();
    }

    public ilce getOneilce(Long ilceId) {
        return ilceRepo.findById(ilceId).orElse(null);
    }

    public ilce createOneilce(ilceCreateRequest request) {
        il il =ilService.getOneil(request.getIlId());
       if(il != null){
           ilce ilce=new ilce();
           ilce.setId(request.getId());
           ilce.setName(request.getName());
           ilce.setIl(il);
           return ilceRepo.save(ilce);

       }
       else return null;
    }

    public ilce updateOneilce(Long ilceId, ilceUpdateRequest request) {
        Optional<ilce> ilce = ilceRepo.findById(ilceId);

        if(ilce.isPresent()){
            ilce.get().setName(request.getName());
            return ilceRepo.save(ilce.get());

        }
        else return null;
    }

    public void deleteOneilce(Long ilceId) {
        Optional<ilce> ilce = ilceRepo.findById(ilceId);
        if(ilce.isPresent())
         ilceRepo.deleteById(ilceId);
    }
}