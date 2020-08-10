package com.cdl.spring_boot_test2.modules.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    /**
     * 127.0.0.1:8080/test/testDesc----get
     */
    @GetMapping("/testDesc")
    @ResponseBody
    public String testDesc(){
        return "This is test module desc";
    }
}
