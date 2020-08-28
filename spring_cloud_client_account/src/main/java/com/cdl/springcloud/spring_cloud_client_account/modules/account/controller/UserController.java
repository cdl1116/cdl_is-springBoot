package com.cdl.springcloud.spring_cloud_client_account.modules.account.controller;

import com.cdl.springcloud.spring_cloud_client_account.modules.account.commom.vo.Result;
import com.cdl.springcloud.spring_cloud_client_account.modules.account.commom.vo.SearchVo;
import com.cdl.springcloud.spring_cloud_client_account.modules.account.entity.User;
import com.cdl.springcloud.spring_cloud_client_account.modules.account.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 127.0.0.1:8762/api/user/10 -----get
     */
    @GetMapping("/user/{userId}")
    public User getUserByUserId(@PathVariable int userId) {
        return userService.getUserByUserId(userId);
    }

}
