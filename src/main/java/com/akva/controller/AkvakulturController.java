package com.akva.controller;


import com.akva.dto.AkvakulturDTO;
import com.akva.service.AkvakulturService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/akvakultur")
public class AkvakulturController {

    @Autowired
    private AkvakulturService akvakulturService;

    //fetching data for a particular Organisation
    @RequestMapping(value = "/{orgNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AkvakulturDTO> findOneCompany(@PathVariable String orgNumber) {
        Optional<AkvakulturDTO> akvakulturDTO = akvakulturService.fetchAkvakulturFromApi(orgNumber);
        return akvakulturDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    } //supposed to map it to the Data Transfer Object -> Map to Repository



}
