package com.akva.controller;

import com.akva.dto.BrandRegDTO;
import com.akva.service.BrandRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brandreg")
public class BrandRegController {

    @Autowired
    private BrandRegService brandRegService;

    @GetMapping("/{orgNumber}")
    public BrandRegDTO getBrandRegData(@PathVariable String orgNumber) {
        return brandRegService.getBrandRegData(orgNumber);
    }
}