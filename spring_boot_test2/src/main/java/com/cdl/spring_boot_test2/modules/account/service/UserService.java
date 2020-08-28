package com.cdl.spring_boot_test2.modules.account.service;

import com.cdl.spring_boot_test2.modules.account.entity.User;
import com.cdl.spring_boot_test2.modules.common.vo.Result;
import com.cdl.spring_boot_test2.modules.common.vo.SearchVo;
import com.github.pagehelper.PageInfo;

public interface UserService {
    Result<User> insertUser(User user);

    Result<User> login(User user);

    PageInfo<User> getUsersBySearchVo(SearchVo searchVo);

    Result<User> updateUser(User user);

    Result<Object> deleteUser(int userId);

    User getUserByUserId(int userId);

}
