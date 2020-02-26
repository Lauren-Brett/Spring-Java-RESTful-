package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/named/{name}/whiskies/aged/{age}")
    public List<Distillery> getAllWhiskiesForDistilleryForYear(@PathVariable String name, @PathVariable int age){
        return distilleryRepository.getAllWhiskiesForDistilleryForYear(name, age);
    }





}
