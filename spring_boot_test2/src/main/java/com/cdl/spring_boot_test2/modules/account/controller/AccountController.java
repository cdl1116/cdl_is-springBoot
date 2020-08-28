package com.cdl.spring_boot_test2.modules.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description AccountController
 * @Author HymanHu
 * @Date 2020/8/17 13:41
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    /**
     * 127.0.0.1/account/login ---- get
     */
    @GetMapping("/login")
    public String loginPage(){
        return "indexSimple";
    }

    /**
     * 127.0.0.1/account/register ---- get
     */
    @GetMapping("/register")
    public String registerPage() {
        return "indexSimple";
    }




    /**
     * 127.0.0.1/account/users ---- get
     */
    @GetMapping("/users")
    public String usersPage() {
        return "index";
    }
}
