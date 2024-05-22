package com.akva.controller;


import com.akva.dto.AkvakulturDTO;
import com.akva.service.AkvakulturService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/akvakultur")
public class AkvakulturController {

    @Autowired
    private AkvakulturService akvakulturService;

    @GetMapping("/{orgNumber}")
    public AkvakulturDTO getAkvakulturData(@PathVariable String orgNumber) {
        return akvakulturService.getAkvakulturData(orgNumber);
    }
}