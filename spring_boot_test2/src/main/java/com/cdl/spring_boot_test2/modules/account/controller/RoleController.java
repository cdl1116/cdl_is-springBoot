package com.cdl.spring_boot_test2.modules.account.controller;

import com.cdl.spring_boot_test2.modules.account.entity.Role;
import com.cdl.spring_boot_test2.modules.account.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 127.0.0.1/api/roles ---- get
     * @return
     */
    @GetMapping("/roles")
    public List<Role> getRoles(){
        return roleService.getRoles();
    }
}
