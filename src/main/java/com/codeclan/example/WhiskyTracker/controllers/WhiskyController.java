package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {


    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/getAllWhiskyFromRegion")
    public List<Whisky> getAllWhiskyFromRegion(@RequestParam String region){
        return whiskyRepository.getAllWhiskyFromRegion(region);
    }

}
