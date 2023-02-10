package com.example.consumer.clients;

import com.example.consumer.wsdl.GetTestRequest;
import com.example.consumer.wsdl.GetTestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class TestClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(TestClient.class);

    public GetTestResponse getTest(String test) {
        GetTestRequest request = new GetTestRequest();
        request.setName(test);
        log.info("Requesting location for " + test);
        GetTestResponse response = (GetTestResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries", request);

        return response;
    }

}
