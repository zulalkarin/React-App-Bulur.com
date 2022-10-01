package com.project.webApp.services;

import com.project.webApp.entity.Category;
import com.project.webApp.entity.Nace;
import com.project.webApp.repos.NaceRepo;
import com.project.webApp.requests.NaceCreateRequest;
import com.project.webApp.requests.NaceUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NaceService {

    private NaceRepo naceRepo;
    private CategoryService categoryService;

    public NaceService(NaceRepo naceRepo, CategoryService categoryService) {
        this.naceRepo = naceRepo;
        this.categoryService= categoryService;
    }

    public List<Nace> getAllNaces(Optional<Long> categoryId) {
        if(categoryId.isPresent()){
            return naceRepo.findByCategoryId(categoryId.get());
        }
        else
            return naceRepo.findAll();
    }

    public Nace getOneNace(Long id) {
        Optional<Nace> nace = naceRepo.findById(id);
        if(nace.isPresent()){
            return nace.get();
        }
        else return null;
    }

    public Nace createOneNace(NaceCreateRequest request) {
        Category category =categoryService.getOneCategory(request.getCategoryId());
        if(category != null){
          Nace nace=new Nace();
          nace.setCategory(category);
          nace.setId(request.getId());
          nace.setTitle(request.getTitle());
          return naceRepo.save(nace);
        }
        else return null;
    }

    public Nace updateOneNace(Long id, NaceUpdateRequest request) {
        Optional<Nace> nace = naceRepo.findById(id);
        if(nace.isPresent()){
            nace.get().setTitle(request.getTitle());
            return naceRepo.save(nace.get());
        }
        else return null;
    }

    public void deleteOneNace(Long id) {
       Optional<Nace> nace =naceRepo.findById(id);
       if(nace.isPresent())
           naceRepo.deleteById(id);
    }
}
