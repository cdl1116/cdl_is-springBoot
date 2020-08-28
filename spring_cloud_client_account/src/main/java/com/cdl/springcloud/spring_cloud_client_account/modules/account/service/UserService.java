package com.cdl.springcloud.spring_cloud_client_account.modules.account.service;


import com.cdl.springcloud.spring_cloud_client_account.modules.account.commom.vo.Result;
import com.cdl.springcloud.spring_cloud_client_account.modules.account.commom.vo.SearchVo;
import com.cdl.springcloud.spring_cloud_client_account.modules.account.entity.User;
import com.github.pagehelper.PageInfo;

public interface UserService {
    Result<User> insertUser(User user);

    Result<User> login(User user);

    PageInfo<User> getUsersBySearchVo(SearchVo searchVo);

    Result<User> updateUser(User user);

    Result<Object> deleteUser(int userId);

    User getUserByUserId(int userId);

}
