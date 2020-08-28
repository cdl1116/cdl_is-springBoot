package com.cdl.spring_boot_test2.modules.account.service.impl;

import com.cdl.spring_boot_test2.modules.account.dao.UserDao;
import com.cdl.spring_boot_test2.modules.account.dao.UserRoleDao;
import com.cdl.spring_boot_test2.modules.account.entity.Role;
import com.cdl.spring_boot_test2.modules.account.entity.User;
import com.cdl.spring_boot_test2.modules.account.service.UserService;
import com.cdl.spring_boot_test2.modules.common.vo.Result;
import com.cdl.spring_boot_test2.modules.common.vo.SearchVo;
import com.cdl.spring_boot_test2.utils.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    @Transactional
    public Result<User> insertUser(User user) {
        User userTemp = userDao.getUserByUserName(user.getUserName());
        if (userTemp !=null){
            return new Result<User>(
                    Result.ResultStatus.FAILD.status,"User name is repeat..");
        }

        user.setCreateDate(LocalDateTime.now());
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        userDao.insertUser(user);

        userRoleDao.deleteUserRoleByUserId(user.getUserId());
        List<Role> roles = user.getRoles();
        if (roles !=null&& !roles.isEmpty()){
            roles.stream().forEach(item ->{
                userRoleDao.insertUserRole(user.getUserId(),item.getRoleId());
            });
        }

        return new Result<User>(
                Result.ResultStatus.SUCCESS.status,"Insert success.",user);
    }

    @Override
    public Result<User> login(User user) {
        User userTeme = userDao.getUserByUserName(user.getUserName());
        if (userTeme != null && userTeme.getPassword().equals(MD5Util.getMD5(user.getPassword()))){
            return new Result<User>(
                    Result.ResultStatus.SUCCESS.status,"Success",userTeme);
        }
        return new Result<User>(
                Result.ResultStatus.FAILD.status,"UserName or password is error");
    }

    @Override
    public PageInfo<User> getUsersBySearchVo(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<User>(
                Optional.ofNullable(userDao.getUsersBySearchVo(searchVo))
                        .orElse(Collections.emptyList()));
    }

    @Override
    @Transactional
    public Result<User> updateUser(User user) {
        User userTemp = userDao.getUserByUserName(user.getUserName());
        if (userTemp !=null && userTemp.getUserId()!=user.getUserId()){
            return new Result<User>(
                    Result.ResultStatus.FAILD.status,"User name is repeat..");
        }

        userDao.updateUser(user);

        userRoleDao.deleteUserRoleByUserId(user.getUserId());
        List<Role> roles = user.getRoles();
        if (roles !=null&& !roles.isEmpty()){
            roles.stream().forEach(item ->{
                userRoleDao.insertUserRole(user.getUserId(),item.getRoleId());
            });
        }
        return new Result<User>(
                Result.ResultStatus.SUCCESS.status,"Update success");
    }

    @Override
    public Result<Object> deleteUser(int userId) {
        userDao.deleteUser(userId);
        userRoleDao.deleteUserRoleByUserId(userId);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "Delete success");
    }

    @Override
    public User getUserByUserId(int userId) {
        return userDao.getUserByUserId(userId);
    }


}
