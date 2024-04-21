package com.specimen.www.service;

import com.specimen.www.bean.UserIdToRoleId;

import java.util.List;

public interface UserIdToRoleIdService{
    List<UserIdToRoleId> getUserIdToRoleIdByUserId(int userId);
}
