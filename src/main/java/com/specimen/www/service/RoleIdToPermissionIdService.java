package com.specimen.www.service;

import com.specimen.www.bean.RoleIdToPermissionId;

import java.util.List;

public interface RoleIdToPermissionIdService {
    List<RoleIdToPermissionId> getRoleIdToPermissionIdByRoleId(int roleId);
}
