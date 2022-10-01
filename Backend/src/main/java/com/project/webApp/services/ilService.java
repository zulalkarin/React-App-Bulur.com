package com.project.webApp.services;


import com.project.webApp.entity.il;
import com.project.webApp.requests.ilUpdateRequest;
import org.springframework.stereotype.Service;
import com.project.webApp.repos.ilRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ilService {

    private ilRepo ilRepo;

    public ilService(ilRepo ilRepo) {
        this.ilRepo = ilRepo;
    }

    public List<il> getAllills() {
        return ilRepo.findAll();

    }

    public il getOneil(Long ilId) {
        return ilRepo.findById(ilId).orElse(null);
    }



    public il createOneil(il request) {
       return ilRepo.save(request);
    }

    public il updateOneil(Long ilId, ilUpdateRequest request) {
        Optional<il> il= ilRepo.findById(ilId);
        if(il.isPresent()){
            il.get().setName(request.getName());
            ilRepo.save(il.get());
            return il.get();
        }
        return null;


    }

    public void deleteOneIl(Long ilId) {
        Optional<il> il= ilRepo.findById(ilId);
        if(il.isPresent())
            ilRepo.deleteById(ilId);
    }



}
