package com.specimen.www.service;

import com.specimen.www.bean.Permission;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;

public interface PermissionService {
    HashMap<Integer, Permission> getAllPermission();
}
