package com.project.webApp.controller;

import com.project.webApp.entity.Company;
import com.project.webApp.requests.CompanyCreateRequest;
import com.project.webApp.requests.CompanyUpdateRequest;
import com.project.webApp.responses.CompanyResponse;
import com.project.webApp.services.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
@CrossOrigin(origins = "http://localhost:3000/addCompany")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping
    public List<CompanyResponse> getAllCompanies(@RequestParam Optional<Long> categoryId, @RequestParam Optional<Long> naceId,
                                                 @RequestParam Optional<Long> ilId, @RequestParam Optional<Long> ilceId,
                                                 @RequestParam Optional<Long> mahalleId){
        return companyService.getAllCompaniesWithParam(categoryId, naceId, ilId, ilceId, mahalleId);
    }

    @GetMapping("/{id}")
    public Company getOneCompany(@PathVariable Long id){
        return companyService.getOneCompanyById(id);
    }



    //create a company
    @PostMapping
    public Company createOneCompany(@RequestBody CompanyCreateRequest request){
        return companyService.createOneCompany(request);
    }

    @PutMapping("/{id}")
    public Company updateOneCompany(@PathVariable Long id, @RequestBody CompanyUpdateRequest request){
        return companyService.updateOneCompany(id, request);

    }

    @DeleteMapping("/{id}")
    public void deleteOneCompany(@PathVariable Long id){
        companyService.deleteOneComany(id);
    }









}
