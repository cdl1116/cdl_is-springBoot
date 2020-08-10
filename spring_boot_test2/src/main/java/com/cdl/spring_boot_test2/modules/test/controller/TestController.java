package com.cdl.spring_boot_test2.modules.test.controller;

import com.cdl.spring_boot_test2.modules.test.vo.ApplicationTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//重新提交
@Controller
@RequestMapping("/test")
public class TestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Value("${server.port}")
    private int port;
    @Value("${com.name}")
    private String name;
    @Value("${com.age}")
    private int age;
    @Value("${com.desc}")
    private String desc;
    @Value("${com.random}")
    private String random;

    @Autowired
    private ApplicationTest applicationTest;
    /**
     *127.0.0.1:8086/test/logTest -------get
     */
    @GetMapping("/logTest")
    @ResponseBody
    public String logTest(){
        LOGGER.trace("This is trace log");
        LOGGER.debug("This is debug log");
        LOGGER.info("This is info log");
        LOGGER.error("This is error log");
        return "这是一个log测试";
    }

    /**
     *127.0.0.1:8086/test/config
     */
    @GetMapping("/config")
    @ResponseBody
    public String configTest(){
        StringBuffer sb = new StringBuffer();
        sb.append(port).append("-----")
                .append(name).append("-----")
                .append(age).append("-----")
                .append(desc).append("-----")
                .append(random).append("-----").append("<br>");
        sb.append(applicationTest.getPort()).append("-----")
                .append(applicationTest.getName()).append("-----")
                .append(applicationTest.getAge()).append("-----")
                .append(applicationTest.getDesc()).append("-----")
                .append(applicationTest.getRandom()).append("-----").append("<br>");
        return sb.toString();

    }


    /**
     * 127.0.0.1:8080/test/testDesc----get
     */
    @GetMapping("/testDesc")
    @ResponseBody
    public String testDesc(){
        return "This is test module desc";
    }
}
