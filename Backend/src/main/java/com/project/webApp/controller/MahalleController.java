package com.project.webApp.controller;

import com.project.webApp.entity.Mahalle;
import com.project.webApp.requests.MahalleCreateRequest;
import com.project.webApp.requests.MahalleUpdateRequest;
import com.project.webApp.services.MahalleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mahalleler")
public class MahalleController {

    private MahalleService mahalleService;

    public MahalleController(MahalleService mahalleService) {
        this.mahalleService = mahalleService;
    }
    @GetMapping
    public List<Mahalle> getAllMahalles(@RequestParam Optional<Long> ilId, @RequestParam Optional<Long> ilceId,
                                        @RequestParam Optional<Long> id){
        return mahalleService.getAllMahalles(ilId, ilceId, id);
    }

    @GetMapping("/{id}")
    public Mahalle getOneMahalle(@PathVariable Long id){
        return mahalleService.getOneMahalle(id);
    }

    @PostMapping
    public Mahalle createOneMahalle(@RequestBody MahalleCreateRequest request){
        return mahalleService.createOneMahalle(request);
    }

    @PutMapping("/{id}")
    public Mahalle updateOneMahalle(@PathVariable Long id, @RequestBody MahalleUpdateRequest request){
        return mahalleService.updateOneMahalle(id, request);
    }

    @DeleteMapping("/{id}")
    public  void deleteOneMahalle(@PathVariable Long id){
         mahalleService.deleteOneMahalle(id);
    }







}
