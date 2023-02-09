package com.example.consumer.controller;

import com.example.consumer.wsdl.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConsumer {

    @Autowired
    private CountryClient countryClient;

    @GetMapping("test")
    public String test(){
        GetCountryResponse spain = countryClient.getCountry("Spain");
//        return spain;
        return "hi";
    }
}
