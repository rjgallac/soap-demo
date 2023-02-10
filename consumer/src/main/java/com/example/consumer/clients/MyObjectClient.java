package com.example.consumer.clients;

import com.example.consumer.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class MyObjectClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(MyObjectClient.class);

    public GetObjectResponse getObject(MyObject myObject) {
        GetObjectRequest getObjectRequest = new GetObjectRequest();
        getObjectRequest.setName(myObject);
//        log.info("Requesting location for " + test);
        GetObjectResponse response = (GetObjectResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries", getObjectRequest);

        return response;
    }

}
