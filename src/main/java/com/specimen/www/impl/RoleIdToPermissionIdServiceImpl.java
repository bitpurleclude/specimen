package com.specimen.www.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.specimen.www.bean.RoleIdToPermissionId;
import com.specimen.www.mapper.RoleIdToPermissionIdServiceMapper;
import com.specimen.www.service.RoleIdToPermissionIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleIdToPermissionIdServiceImpl implements RoleIdToPermissionIdService {
    @Autowired
    RoleIdToPermissionIdServiceMapper roleIdToPermissionIdServiceMapper;
    @Override
    public List<RoleIdToPermissionId> getRoleIdToPermissionIdByRoleId(int roleId) {
        return roleIdToPermissionIdServiceMapper.selectList(new QueryWrapper<RoleIdToPermissionId>().eq("role_id", roleId));
    }
}
