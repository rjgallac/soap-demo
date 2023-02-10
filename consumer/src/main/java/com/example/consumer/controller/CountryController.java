package com.example.consumer.controller;

import com.example.consumer.clients.CountryClient;
import com.example.consumer.clients.TestClient;
import com.example.consumer.wsdl.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @Autowired
    private CountryClient countryClient;

    @Autowired
    private TestClient testClient;

    @GetMapping("country")
    public GetCountryResponse test(){
        GetCountryResponse countryResponse = countryClient.getCountry("Spain");
        return countryResponse;
    }
}
