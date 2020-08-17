package com.cdl.spring_boot_test2.modules.test.service.impl;

import com.cdl.spring_boot_test2.modules.test.dao.CountryDao;
import com.cdl.spring_boot_test2.modules.test.entity.Country;
import com.cdl.spring_boot_test2.modules.test.service.CountryService;
import com.cdl.spring_boot_test2.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Country getCountryByCountryId(int countryId) {
        return countryDao.getCountryByCountryId(countryId);
    }

    @Override
    public Country getCountryByCountryName(String countryName) {
        return countryDao.getCountryByCountryName(countryName);
    }

    @Override
    public Country mograteCountryByRedis(int countryId) {
        Country country = countryDao.getCountryByCountryId(countryId);
        String countryKey = String.format("countryId",countryId);
//        redisTemplate.opsForValue().set(countryKey,country);
//        return (Country) redisTemplate.opsForValue().get(countryKey);
        redisUtils.set(countryKey,country);
        return (Country)redisUtils.get(countryKey);
    }
}
