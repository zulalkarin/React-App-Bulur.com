package com.project.webApp.services;

import com.project.webApp.entity.*;
import com.project.webApp.repos.*;
import com.project.webApp.requests.CompanyCreateRequest;
import com.project.webApp.requests.CompanyUpdateRequest;
import com.project.webApp.responses.CompanyResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private CompanyRepo companyRepo;

    private CategoryRepo categoryRepo;

    private NaceRepo naceRepo;

    private ilRepo ilRepo;

    private ilceRepo ilceRepo;

    private  MahalleRepo mahalleRepo;

    public CompanyService(CompanyRepo companyRepo, CategoryRepo categoryRepo,
                          NaceRepo naceRepo, ilRepo ilRepo, ilceRepo ilceRepo, MahalleRepo mahalleRepo)
    {
        this.companyRepo = companyRepo;
        this.categoryRepo=categoryRepo;
        this.naceRepo=naceRepo;
        this.ilRepo=ilRepo;
        this.ilceRepo=ilceRepo;
        this.mahalleRepo=mahalleRepo;
    }

    public List<CompanyResponse> getAllCompaniesWithParam(Optional<Long> categoryId, Optional<Long> naceId, Optional<Long> ilId,
                                                          Optional<Long> ilceId, Optional<Long> mahalleId) {
        List <Company> list;
        //all information is given
        if (categoryId.isPresent() && naceId.isPresent() && ilId.isPresent() && ilceId.isPresent() && mahalleId.isPresent()) {
            list = companyRepo.findByCategoryIdAndNaceIdAndIlIdAndIlceIdAndMahalleId(categoryId.get(), naceId.get(), ilId.get(),
                    ilceId.get(), mahalleId.get());

        }
        //except mahalle
        else if(categoryId.isPresent() && naceId.isPresent() && ilId.isPresent() && ilceId.isPresent()){
            list= companyRepo.findByCategoryIdAndNaceIdAndIlIdAndIlceId(categoryId.get(), naceId.get(), ilId.get(),
                    ilceId.get());
        }
        //category- il-ilce
        else if(categoryId.isPresent() && ilId.isPresent() && ilceId.isPresent()){
            list= companyRepo.findByCategoryIdAndIlIdAndIlceId(categoryId.get(), ilId.get(), ilceId.get());
        }
        //category- il
        else if(categoryId.isPresent() && ilId.isPresent()){
            list= companyRepo.findByCategoryIdAndIlId(categoryId.get(), ilId.get());
        }
        //except mahalle and ilce and il
        else if(categoryId.isPresent() && naceId.isPresent()){
            list= companyRepo.findByCategoryIdAndNaceId(categoryId.get(), naceId.get());
        }
        //just category
        else if(categoryId.isPresent()){
            list= companyRepo.findByCategoryId(categoryId.get());
        }
        //except nace

      /* else if (categoryId.isPresent() && ilId.isPresent() && ilceId.isPresent() && mahalleId.isPresent()) {
            return companyRepo.findByCategoryIdAndIlIdAndIlceIdAndMahalleId(categoryId.get(), ilId.get(),
                    ilceId.get(), mahalleId.get());

        }*/
        else list= companyRepo.findAll();

        return list.stream().map(c -> new CompanyResponse(c)).collect(Collectors.toList());

    }

    public Company getOneCompanyById(Long companyId) {

        return companyRepo.findById(companyId).orElse(null);
    }

    public Company createOneCompany(CompanyCreateRequest request) {
       Category category =categoryRepo.findById(request.getCategoryId()).orElse(null);

       il il=ilRepo.findById(request.getIlId()).orElse(null);
       ilce ilce=ilceRepo.findById((request.getIlceId())).orElse(null);
       Mahalle mahalle=mahalleRepo.findById(request.getMahalleId()).orElse(null);

       if(category!=null  && il!=null && ilce!=null && mahalle!=null){
           Company company =new Company();
           company.setId(request.getId());
           company.setCategory(category);
           company.setTitle(request.getTitle());
           company.setIl(il);
           company.setIlce(ilce);
           company.setMahalle(mahalle);
           return companyRepo.save(company);

       }
       else return null;
    }
    public Company updateOneCompany(Long id, CompanyUpdateRequest request) {
        Category category = categoryRepo.findById(request.getCategoryId()).orElse(null);
       Nace nace= naceRepo.findById(request.getNaceId()).orElse(null);
        il il= ilRepo.findById(request.getIlId()).orElse(null);
        ilce ilce= ilceRepo.findById(request.getIlceId()).orElse(null);
        Mahalle mahalle= mahalleRepo.findById(request.getMahalleId()).orElse(null);
        String title= request.getTitle();
        Long geocode= request.getGeocode();
        Company company=companyRepo.findById(id).orElse(null);
        if(company !=null){
            if(category !=null)
                company.setCategory(category);
            if(nace!=null)
                company.setNace(nace);
            if(il!=null)
                company.setIl(il);
            if(ilce!=null)
                company.setIlce(ilce);
            if(mahalle!=null)
                company.setMahalle(mahalle);
            if(title!=null)
                company.setTitle(title);
            if(geocode!=null)
                company.setGeocode(geocode);

            return companyRepo.save(company);


        }
        else return null;


    }

    public void deleteOneComany(Long id) {
        Optional<Company> company = companyRepo.findById(id);
        if(company.isPresent())
            companyRepo.deleteById(id);
    }
}
