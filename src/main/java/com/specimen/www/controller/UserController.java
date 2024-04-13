package com.specimen.www.controller;
import com.specimen.www.bean.User;
import com.specimen.www.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/user/register")
    public String register(@RequestBody User user) {
        boolean isRegistered;
        isRegistered = userService.checkHasResign(user.getEmail());
        if (!isRegistered) {
            userService.insertUser(user);
            return "注册成功";
        }else {
            return "已经注册";
        }
    }
}
