package com.cdl.spring_boot_test2.modules.test.service;

import com.cdl.spring_boot_test2.modules.test.entity.Country;

public interface CountryService {
    Country getCountryByCountryId(int countryId);

    Country getCountryByCountryName(String countryName);

    Country mograteCountryByRedis(int countryId);
}
