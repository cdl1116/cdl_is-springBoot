package com.cdl.spring_boot_test2.modules.test.dao;

import com.cdl.spring_boot_test2.modules.test.entity.Country;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import sun.awt.SunHints;

import java.util.List;

@Repository
@Mapper
public interface CountryDao {

    @Select("select * from m_country where country_id = #{countryId}")
    @Results(id = "countryResults",value = {
            @Result(column = "country_id",property = "countryId"),
            @Result(column = "country_id",property = "cities",
                    javaType = List.class,
                    many = @Many(select = "com.cdl.spring_boot_test2.modules.test.dao.CityDao.getCitiesByCountryId"))
    })
    Country getCountryByCountryId(int countryId);

    @Select("select * from m_country where country_name = #{countryName}")
    @ResultMap(value = "countryResults")
    Country getCountryByCountryName(String countryName);
}
