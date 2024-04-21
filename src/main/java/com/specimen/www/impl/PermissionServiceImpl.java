package com.specimen.www.impl;

import com.specimen.www.bean.Permission;
import com.specimen.www.mapper.PermissionMapper;
import com.specimen.www.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    @Bean
    public HashMap<Integer, Permission> getAllPermission(){
        //通过空条件查询所有permission
        List<Permission> permissions = permissionMapper.selectList(null);
        HashMap<Integer,Permission> permissionHashMap = new HashMap<>();
        for (Permission permission : permissions) {
            permissionHashMap.put(permission.getId(),permission);
        }
        return permissionHashMap;
    }

}
