package com.specimen.www.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.specimen.www.bean.UserIdToRoleId;
import com.specimen.www.mapper.UserIdToRoleIdMapper;
import com.specimen.www.service.UserIdToRoleIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserIdToRoleIdServiceImpl implements UserIdToRoleIdService {
    @Autowired
    private UserIdToRoleIdMapper userIdToRoleIdMapper;
    @Override
    public List<UserIdToRoleId> getUserIdToRoleIdByUserId(int userId) {
        return userIdToRoleIdMapper.selectList(new QueryWrapper<UserIdToRoleId>().eq("user_id", userId));
    }
}
