package com.cdl.springcloud.springCloudClientTest.modules.test.service;

import com.cdl.springcloud.springCloudClientTest.modules.common.vo.Result;
import com.cdl.springcloud.springCloudClientTest.modules.common.vo.SearchVo;
import com.cdl.springcloud.springCloudClientTest.modules.common.vo.Result;
import com.cdl.springcloud.springCloudClientTest.modules.common.vo.SearchVo;
import com.cdl.springcloud.springCloudClientTest.modules.test.entity.City;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CityService {

    List<City> getCitiesByCountryId(int countryId);

    PageInfo<City> getCitiesBySearchVo(int countryId, SearchVo searchVo);

    PageInfo<City> getCitiesBySearchVo(SearchVo searchVo);

    Result<City> insertCity(City city);

    Result<City> updateCity(City city);

    Result<Object> deleteCity(int cityId);
}
