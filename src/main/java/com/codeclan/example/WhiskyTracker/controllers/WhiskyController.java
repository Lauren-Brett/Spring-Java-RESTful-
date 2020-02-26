package com.codeclan.example.WhiskyTracker.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {



    //    @GetMapping(value = "/{year}")
//    public List<Distillery> getAllWhiskeyForYear(@PathVariable int year){
//        return distilleryRepository.getAllWhiskeyForYear(year);
//    }

}
