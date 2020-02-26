package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;


    @GetMapping(value = "/region/{region}")
    public List<Distillery> getAllDistilleriesForRegion(@PathVariable String region){
        return distilleryRepository.getAllDistilleriesForRegion(region);
    }

    @GetMapping(value = "/whiskies/year/{year}")
    public List<Distillery> getAllWhiskiesForYear(@PathVariable int year){
        return distilleryRepository.getAllWhiskiesForYear(year);
    }

//    @GetMapping(value = "/named/{name}/whiskies/aged/{age}")
//    public List<Distillery> getAllWhiskiesForDistilleryForAge(@PathVariable String name, @PathVariable int age){
//        return distilleryRepository.getAllWhiskiesForDistilleryForYear(name, age);
//    }

    @GetMapping(value = "/getAllWhiskiesForDistilleryForAge")
    public List<Distillery> getAllWhiskiesForDistilleryForAge(@RequestParam String name, @RequestParam int age){
        return distilleryRepository.getAllWhiskiesForDistilleryForAge(name, age);
    }





}
