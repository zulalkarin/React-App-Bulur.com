package com.project.webApp.controller;


import com.project.webApp.entity.ilce;
import com.project.webApp.requests.ilceCreateRequest;
import com.project.webApp.requests.ilceUpdateRequest;
import com.project.webApp.services.ilceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/ilceler")
public class ilceController {

    private ilceService ilceService;

    public ilceController(ilceService ilceService) {
        this.ilceService = ilceService;
    }


    @GetMapping
    public List<ilce> getAllilces(@RequestParam Optional<Long> ilId ){
        return ilceService.getAllilces(ilId);
    }

    @GetMapping("/{id}")
    public ilce getOneilce(@PathVariable Long id){
        return ilceService.getOneilce(id);
    }

    @PostMapping
    public ilce createOneilce(@RequestBody ilceCreateRequest request){
        return ilceService.createOneilce(request);

    }

    @PutMapping("/{id}")
    public ilce updateOneilce(@PathVariable Long id, @RequestBody ilceUpdateRequest request){
        return ilceService.updateOneilce(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteOneilce(@PathVariable Long id){
        ilceService.deleteOneilce(id);
    }








}
