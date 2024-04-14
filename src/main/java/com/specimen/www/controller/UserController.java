package com.specimen.www.controller;
import com.specimen.www.bean.Role;
import com.specimen.www.bean.User;
import com.specimen.www.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private List<Role> roles;
    @RequestMapping("/user/register")
    public String register(@RequestBody User user) {
        boolean isRegistered;
        isRegistered = userService.checkHasResign(user.getEmail());
        if (!isRegistered) {
            userService.insertUser(user);
            System.out.println(roles);
            return "注册成功";
        }else {
            return "已经注册";
        }
    }
}
