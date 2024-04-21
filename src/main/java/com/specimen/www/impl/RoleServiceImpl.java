package com.specimen.www.impl;

import com.specimen.www.bean.Permission;
import com.specimen.www.bean.Role;
import com.specimen.www.bean.RoleIdToPermissionId;
import com.specimen.www.mapper.RoleMapper;
import com.specimen.www.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    HashMap<Integer, Permission> permissionHashMap;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    RoleIdToPermissionIdServiceImpl roleIdToPermissionIdService;
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
            getRolePermission(role);
            roleHashMap.put(role.getId(),role);
        }
        return roleHashMap;
    }
    @Override
    public void getRolePermission(Role role){
        List<RoleIdToPermissionId> roleIdToPermissionIdByRoleId = roleIdToPermissionIdService.getRoleIdToPermissionIdByRoleId(role.getId());
        for (RoleIdToPermissionId roleIdToPermissionId : roleIdToPermissionIdByRoleId) {
            Permission permission = permissionHashMap.get(roleIdToPermissionId.getPermissionId());
            role.getPermissions().add(permission);
        }
    }
    public void insertRoleToUser(int userId,Role role){

    }
}
