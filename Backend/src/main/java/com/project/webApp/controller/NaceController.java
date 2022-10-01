package com.project.webApp.controller;

import com.project.webApp.entity.Nace;
import com.project.webApp.requests.NaceCreateRequest;
import com.project.webApp.requests.NaceUpdateRequest;
import com.project.webApp.services.NaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/naceler")
public class NaceController {

    NaceService naceService;

    public NaceController(NaceService naceService) {
        this.naceService = naceService;
    }

    @GetMapping
    public List<Nace> getAllNaces(@RequestParam Optional<Long> categoryId){
        return naceService.getAllNaces(categoryId);
    }

    @GetMapping("/{id}")
    public Nace getOneNace(@PathVariable Long id){
        return naceService.getOneNace(id);
    }

    @PostMapping
    public Nace createOneNace(@RequestBody NaceCreateRequest request){
        return naceService.createOneNace(request);
    }


    @PutMapping("/{id}")
    public Nace updateOneNace(@PathVariable Long id, @RequestBody NaceUpdateRequest request){ //just update nace title
        return naceService.updateOneNace(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteOneNace(@PathVariable Long id){
         naceService.deleteOneNace(id);
    }
}
