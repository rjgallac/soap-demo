package com.example.consumer.controller;

import com.example.consumer.wsdl.GetCountryRequest;
import com.example.consumer.wsdl.GetCountryResponse;
import com.example.consumer.wsdl.GetTestRequest;
import com.example.consumer.wsdl.GetTestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class TestClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(TestClient.class);

    public GetTestResponse getTest(String test) {

        GetTestRequest request = new GetTestRequest();
        request.setName(test);

        log.info("Requesting location for " + test);

        GetTestResponse response = (GetTestResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries", request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));

        return response;
    }

}
