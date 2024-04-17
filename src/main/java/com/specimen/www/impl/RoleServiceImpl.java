package com.specimen.www.impl;

import com.specimen.www.bean.Role;
import com.specimen.www.mapper.RoleMapper;
import com.specimen.www.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    @Bean
    public HashMap<String, Role> getAllRoleName() {
        //通过空条件查询所有role
        List<Role> roles = roleMapper.selectList(null);
        HashMap<String,Role> roleHashMap = new HashMap<>();
       for (Role role : roles) {
           roleHashMap.put(role.getRoleName(),role);
       }
        return roleHashMap;
    }
    @Override
    @Bean
    public HashMap<Integer, Role> getAllRoleId() {
        //通过空条件查询所有role
        List<Role> roles = roleMapper.selectList(null);
        HashMap<Integer,Role> roleHashMap = new HashMap<>();
        for (Role role : roles) {
            roleHashMap.put(role.getId(),role);
        }
        return roleHashMap;
    }
    public void insertRoleToUser(int userId,Role role){

    }
}
