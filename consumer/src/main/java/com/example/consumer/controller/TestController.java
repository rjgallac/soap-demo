package com.example.consumer.controller;

import com.example.consumer.wsdl.GetTestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestClient testClient;

    @GetMapping("test2")
    public GetTestResponse test(){
        return testClient.getTest("hi test");
    }
}
