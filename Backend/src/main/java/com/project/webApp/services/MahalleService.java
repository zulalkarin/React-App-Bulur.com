package com.project.webApp.services;

import com.project.webApp.entity.Mahalle;
import com.project.webApp.entity.Nace;
import com.project.webApp.entity.il;
import com.project.webApp.entity.ilce;
import com.project.webApp.repos.MahalleRepo;
import com.project.webApp.requests.MahalleCreateRequest;
import com.project.webApp.requests.MahalleUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MahalleService {
    private MahalleRepo mahalleRepo;
    private ilService ilService;
    private ilceService ilceService;

    public MahalleService(MahalleRepo mahalleRepo, ilService ilService, ilceService ilceService) {
        this.mahalleRepo = mahalleRepo;
        this.ilService =ilService;
        this.ilceService= ilceService;
    }

    public List<Mahalle> getAllMahalles(Optional<Long> ilId, Optional<Long> ilceId, Optional<Long> id) {
        if(ilId.isPresent() && ilceId.isPresent() && id.isPresent())
            return mahalleRepo.findByIlIdAndIlceIdAndId(ilId.get(), ilceId.get(), id.get());
        else if(ilId.isPresent() && ilceId.isPresent() )
            return mahalleRepo.findByIlIdAndIlceId(ilId.get(), ilceId.get());
        else if(ilId.isPresent())
            return mahalleRepo.findByIlId(ilId.get());
        else
            return mahalleRepo.findAll();


    }

    public Mahalle getOneMahalle(Long id) {
        Optional<Mahalle> mahalle = mahalleRepo.findById(id);
        if(mahalle.isPresent()){
            return mahalle.get();
        }
        else return null;
    }

    public Mahalle createOneMahalle(MahalleCreateRequest request) {
        il il=ilService.getOneil(request.getIlId());
        ilce ilce= ilceService.getOneilce(request.getIlceId());
        if(il !=null && ilce!=null){
            Mahalle mahalle =new Mahalle();
            mahalle.setId(request.getId());
            mahalle.setName(request.getName());
            mahalle.setIl(il);
            mahalle.setIlce(ilce);
            return mahalleRepo.save(mahalle);
        }
        else return null;
    }

    public Mahalle updateOneMahalle(Long id, MahalleUpdateRequest request) {
        Optional<Mahalle> mahalle = mahalleRepo.findById(id);
        if(mahalle.isPresent()){
            mahalle.get().setName(request.getName());
            return mahalleRepo.save(mahalle.get());

        }
        else return null;

    }
    public void deleteOneMahalle(Long id) {
        Optional<Mahalle> mahalle = mahalleRepo.findById(id);
        if(mahalle.isPresent())
           mahalleRepo.deleteById(id);
    }
}



