package com.example.consumer.controller;

import com.example.consumer.clients.MyObjectClient;
import com.example.consumer.clients.TestClient;
import com.example.consumer.wsdl.GetObjectResponse;
import com.example.consumer.wsdl.MyObject;
import com.example.consumer.wsdl.MyObject2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyObjectController {

    @Autowired
    private MyObjectClient myObjectClient;

    @GetMapping("myobject")
    public GetObjectResponse test(){
        MyObject myObject = new MyObject();
        myObject.setName("test");
        myObject.setTime(1);
        MyObject2 myObject2 = new MyObject2();
        myObject2.setName("obj2 name");
        myObject2.setTime(3);
        myObject.setMyobject2(myObject2);
        GetObjectResponse getObjectResponse = myObjectClient.getObject(myObject);
        return getObjectResponse;
    }
}
