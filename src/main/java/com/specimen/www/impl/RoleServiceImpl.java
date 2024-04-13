package com.specimen.www.impl;

import com.specimen.www.bean.Role;
import com.specimen.www.mapper.RoleMapper;
import com.specimen.www.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public List<Role> getAllRole() {
        //通过空条件查询所有role
        List<Role> roles=roleMapper.selectList(null);
        return roles;
    }
}
