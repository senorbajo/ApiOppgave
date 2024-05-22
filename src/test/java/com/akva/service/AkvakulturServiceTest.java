package com.akva.service;

import com.akva.dto.AkvakulturDTO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AkvakulturServiceTest {

    @Mock
    private RestTemplate akvakulturApiClient;

    @InjectMocks
    private AkvakulturService akvakulturService;

    public AkvakulturServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAkvakulturData_Success() {
        AkvakulturDTO expectedDTO = new AkvakulturDTO();
        expectedDTO.setOrgNumber("123456789");
        expectedDTO.setName("Test Organization");
        expectedDTO.setBusinessType("Aquaculture");

        when(akvakulturApiClient.getForObject(anyString(), eq(AkvakulturDTO.class))).thenReturn(expectedDTO);

        AkvakulturDTO actualDTO = akvakulturService.getAkvakulturData("123456789");
        assertNotNull(actualDTO);
        assertEquals("123456789", actualDTO.getOrgNumber());
        assertEquals("Test Organization", actualDTO.getName());
        assertEquals("Aquaculture", actualDTO.getBusinessType());

        verify(akvakulturApiClient, times(1)).getForObject(anyString(), eq(AkvakulturDTO.class));
    }

    @Test
    public void testGetAkvakulturData_Failure() {
        when(akvakulturApiClient.getForObject(anyString(), eq(AkvakulturDTO.class))).thenThrow(new RestClientException("API error"));

        AkvakulturDTO actualDTO = akvakulturService.getAkvakulturData("123456789");
        assertNull(actualDTO);

        verify(akvakulturApiClient, times(1)).getForObject(anyString(), eq(AkvakulturDTO.class));
    }
}
