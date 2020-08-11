package com.cdl.spring_boot_test2.modules.test.controller;

import com.cdl.spring_boot_test2.modules.test.entity.Country;
import com.cdl.spring_boot_test2.modules.test.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    private CountryService countryService;

    /**
     *127.0.0.1/api/country/522  ------  get
     */
    @GetMapping("/country/{countryId}")
    public Country getCountryByCountryId(@PathVariable int countryId){
        return countryService.getCountryByCountryId(countryId);
    }

    /**
     *127.0.0.1/api/country?countryName=China ---- get
     */
    @GetMapping("/country")
    public Country  getCountryByCountryName(@RequestParam String countryName){
        return countryService.getCountryByCountryName(countryName);
    }

}
