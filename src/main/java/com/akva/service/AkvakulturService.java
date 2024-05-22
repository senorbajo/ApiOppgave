package com.akva.service;

import com.akva.dto.AkvakulturDTO;
import com.akva.model.Akvakultur;
import com.akva.repository.AkvakulturRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AkvakulturService {

    private static final Logger log = LoggerFactory.getLogger(AkvakulturService.class);
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AkvakulturRepository akvakulturRepository;

    public Optional<AkvakulturDTO> fetchAkvakulturFromApi(String orgNumber) {
        try {
            String url = "https://api.fiskeridir.no/pub-aqua/api/v1/entities?entity-nr=" + orgNumber;
            AkvakulturDTO akvakulturDTO = restTemplate.getForObject(url, AkvakulturDTO.class);
            if (akvakulturDTO != null) {
                Akvakultur akvakultur = convertToEntity(akvakulturDTO);
                akvakulturRepository.save(akvakultur);
                log.info("Fetched Akvakultur : {}", akvakulturDTO);
                return Optional.of(akvakulturDTO);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            // Handle the exception or log it
            return Optional.empty();
        }
    }

    private Akvakultur convertToEntity(AkvakulturDTO akvakulturDTO) {
        Akvakultur akvakultur = new Akvakultur();
        akvakultur.setId(akvakulturDTO.getId());
        akvakultur.setVersionId(akvakulturDTO.getVersionId());
        akvakultur.setOpenNr(akvakulturDTO.getOpenNr());
        akvakultur.setTypeName(akvakulturDTO.getTypeName());
        akvakultur.setTypeValue(akvakulturDTO.getTypeValue());
        akvakultur.setName(akvakulturDTO.getName());
        akvakultur.setOfficialSourceType(akvakulturDTO.getOfficialSourceType());
        akvakultur.setVersionValidFrom(akvakulturDTO.getVersionValidFrom());
        akvakultur.setVersionValidUntil(akvakulturDTO.getVersionValidUntil());
        akvakultur.setVersionRegisteredTime(akvakulturDTO.getVersionRegisteredTime());
        akvakultur.setVersionRegisteredBy(akvakulturDTO.getVersionRegisteredBy());
        akvakultur.setStatus(akvakulturDTO.getStatus());

        akvakultur.setBusinessTypes(akvakulturDTO.getBusinessTypes().stream().map(businessTypeDTO -> {
            Akvakultur.BusinessType businessType = new Akvakultur.BusinessType();
            businessType.setValue(businessTypeDTO.getValue());
            businessType.setName(businessTypeDTO.getName());
            return businessType;
        }).collect(Collectors.toList()));

        akvakultur.setAddresses(akvakulturDTO.getAddresses().stream().map(addressDTO -> {
            Akvakultur.Address address = new Akvakultur.Address();
            address.setId(addressDTO.getId());
            address.setType(addressDTO.getType());
            address.setValue(addressDTO.getValue());
            address.setZipCode(addressDTO.getZipCode());
            address.setZipName(addressDTO.getZipName());
            address.setCountyCode(addressDTO.getCountyCode());
            address.setCountyName(addressDTO.getCountyName());
            address.setCountryCode(addressDTO.getCountryCode());
            address.setCountryName(addressDTO.getCountryName());
            address.setOfficialSourceType(addressDTO.getOfficialSourceType());
            return address;
        }).collect(Collectors.toList()));

        return akvakultur;
    }

    public Optional<Akvakultur> getAkvakulturByOrgNumber(String orgNumber) {
        return akvakulturRepository.findById(Long.valueOf(orgNumber));
    }
}

