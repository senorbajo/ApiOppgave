package com.akva.service;

import com.akva.dto.BrandRegDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class BrandRegService {

    private final RestTemplate brandRegApiClient;

    @Autowired
    public BrandRegService(RestTemplate brandRegApiClient) {
        this.brandRegApiClient = brandRegApiClient;
    }

    public BrandRegDTO getBrandRegData(String orgNumber) {
        String url = "https://api.fiskeridir.no/pub-aqua/api/v1/entities?entity-nr=" + orgNumber;
        try {
            return brandRegApiClient.getForObject(url, BrandRegDTO.class);
        } catch (RestClientException e) {
            System.err.println("Error fetching data from BrandReg API: " + e.getMessage());
            return null;
        }
    }
}