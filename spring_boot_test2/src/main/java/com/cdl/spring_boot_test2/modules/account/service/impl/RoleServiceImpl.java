package com.cdl.spring_boot_test2.modules.account.service.impl;

import com.cdl.spring_boot_test2.modules.account.dao.RoleDao;
import com.cdl.spring_boot_test2.modules.account.entity.Role;
import com.cdl.spring_boot_test2.modules.account.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> getRoles() {
        return Optional.ofNullable(roleDao.getRoles())
                .orElse(Collections.emptyList());
    }
}
