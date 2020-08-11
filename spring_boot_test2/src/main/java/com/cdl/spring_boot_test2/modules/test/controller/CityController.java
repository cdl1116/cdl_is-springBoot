package com.cdl.spring_boot_test2.modules.test.controller;


import com.cdl.spring_boot_test2.modules.common.vo.SearchVo;
import com.cdl.spring_boot_test2.modules.test.entity.City;
import com.cdl.spring_boot_test2.modules.test.service.CityService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     *127.0.0.1/api/cities/522 ----- get
     */

    @GetMapping("/cities/{countryId}")
    public List<City> getCitiesByCountryId(@PathVariable int countryId){
        return cityService.getCitiesByCountryId(countryId);
    }
    /**
     *127.0.0.1/api/cities/522 ----- post
     * {"currentPage":"1","pageSize":"5"}
     */
    @PostMapping(value = "/cities/{countryId}",consumes = "application/json")
    public PageInfo<City> getCitiesBySearchVo(@PathVariable int countryId, @RequestBody SearchVo searchVo){
        return cityService.getCitiesBySearchVo(countryId,searchVo);
    }
}
