package com.project.webApp.controller;

import com.project.webApp.entity.il;
import com.project.webApp.requests.ilUpdateRequest;
import com.project.webApp.services.ilService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/iller")
public class ilController {

    private ilService ilService;
    public ilController(com.project.webApp.services.ilService ilService) {
        this.ilService = ilService;
    }

    @GetMapping
    public List<il> getAllils(){
        return ilService.getAllills();
    }

    @GetMapping("/{ilId}")
    public il getOneil(@PathVariable Long ilId){
        return ilService.getOneil(ilId);
    }




    //add new il
    @PostMapping //add
    public il createOneil(@RequestBody il request){
        return ilService.createOneil(request);

    }
    @PutMapping("/{ilId}") //update
    public il updateOneil(@PathVariable Long ilId, @RequestBody ilUpdateRequest request){
        return ilService.updateOneil(ilId, request);
    }

    @DeleteMapping("/{ilId}")
    public void deleteOneIl(@PathVariable Long ilId){
        ilService.deleteOneIl(ilId);
    }

}
