package com.cdl.spring_boot_test2.modules.test.service;

import com.cdl.spring_boot_test2.modules.common.vo.SearchVo;
import com.cdl.spring_boot_test2.modules.test.entity.City;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CityService {

    List<City> getCitiesByCountryId(int countryId);

    PageInfo<City> getCitiesBySearchVo(int countryId,SearchVo searchVo);
}
