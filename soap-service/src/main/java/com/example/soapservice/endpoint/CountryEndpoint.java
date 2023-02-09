package com.example.soapservice.endpoint;

import com.example.soapservice.models.GetCountryRequest;
import com.example.soapservice.models.GetCountryResponse;
import com.example.soapservice.models.GetTestRequest;
import com.example.soapservice.models.GetTestResponse;
import com.example.soapservice.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://soapservice.example.com/models";

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTestRequest")
    @ResponsePayload
    public GetTestResponse getTest(@RequestPayload GetTestRequest request) {
        GetTestResponse response = new GetTestResponse();
        response.setTest(request.getName());

        return response;
    }
}
