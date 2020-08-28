package com.cdl.spring_boot_test2.modules.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description CommonController
 * @Author HymanHu
 * @Date 2020/8/20 15:33
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    /**
     * 127.0.0.1/common/dashboard ---- get
     */
    @GetMapping("/dashboard")
    public String dashboardPage() {
        return "index";
    }
}
