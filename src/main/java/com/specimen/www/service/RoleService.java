package com.specimen.www.service;

import com.specimen.www.bean.Role;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

public interface RoleService {
    @Bean
    HashMap<String, Role> getAllRoleName();

    @Bean
    HashMap<Integer, Role> getAllRoleId();
}
