package com.akva.service;


import com.akva.dto.AkvakulturDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class AkvakulturService {

    private final RestTemplate akvakulturApiClient;

    @Autowired
    public AkvakulturService(RestTemplate akvakulturApiClient) {
        this.akvakulturApiClient = akvakulturApiClient;
    }

    public AkvakulturDTO getAkvakulturData(String orgNumber) {
        String url = "https://api.fiskeridir.no/pub-aqua/api/v1/entities?entity-nr=" + orgNumber;
        try {
            return akvakulturApiClient.getForObject(url, AkvakulturDTO.class);
        } catch (RestClientException e) {
            System.err.println("Error fetching data from Akvakultur API: " + e.getMessage());
            return null;
        }
    }
}