package com.example.controller;

import com.example.model.MetaData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class interviewProjectController {

//CRUD application

    @PostMapping("/store-content")
    public void store(@RequestBody MetaData storeRequestMetadata){

    }
}
