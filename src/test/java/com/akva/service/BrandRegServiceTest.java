package com.akva.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BrandRegServiceTest {

    @Mock
    private RestTemplate brandRegApiClient;

    @InjectMocks
    private BrandRegService brandRegService;

    public BrandRegServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetBrandRegData_Success() {
        BrandRegDTO expectedDTO = new BrandRegDTO();
        expectedDTO.setOrgNumber("987654321");
        expectedDTO.setName("Test Brand");
        expectedDTO.setRegistrationDate(LocalDate.of(2020, 1, 1));

        when(brandRegApiClient.getForObject(anyString(), eq(BrandRegDTO.class))).thenReturn(expectedDTO);

        BrandRegDTO actualDTO = brandRegService.getBrandRegData("987654321");
        assertNotNull(actualDTO);
        assertEquals("987654321", actualDTO.getOrgNumber());
        assertEquals("Test Brand", actualDTO.getName());
        assertEquals(LocalDate.of(2020, 1, 1), actualDTO.getRegistrationDate());

        verify(brandRegApiClient, times(1)).getForObject(anyString(), eq(BrandRegDTO.class));
    }

    @Test
    public void testGetBrandRegData_Failure() {
        when(brandRegApiClient.getForObject(anyString(), eq(BrandRegDTO.class))).thenThrow(new RestClientException("API error"));

        BrandRegDTO actualDTO = brandRegService.getBrandRegData("987654321");
        assertNull(actualDTO);

        verify(brandRegApiClient, times(1)).getForObject(anyString(), eq(BrandRegDTO.class));
    }
}
