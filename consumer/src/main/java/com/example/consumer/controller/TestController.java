package com.example.consumer.controller;

import com.example.consumer.clients.TestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestClient testClient;

    @GetMapping("test")
    public String test(){
        testClient.getTest("hi test");
        return "hi";
    }
}
