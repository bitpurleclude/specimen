package com.specimen.www;

import com.specimen.www.bean.ImageWithSignPath;
import com.specimen.www.bean.Role;
import com.specimen.www.bean.User;
import com.specimen.www.impl.RoleServiceImpl;
import com.specimen.www.impl.UserServiceImpl;
import com.specimen.www.mapper.ImageWithSignMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpecimenApplication.class)
class SpecimenApplicationTests {
    @Autowired
    private ImageWithSignMapper imageWithSignMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        ImageWithSignPath a=new ImageWithSignPath(0,"a");
        imageWithSignMapper.insert(a);
    }
    @Autowired
    private RoleServiceImpl roleService;
    @Test
    void roleServiceTest(){
        HashMap allRole = roleService.getAllRoleName();
        System.out.println(allRole);
    }
    @Autowired
    UserServiceImpl userService;
    @Test
    void userServiceTest(){
        User user=new User();
        user.setEmail("test1");
        user.setPassword(passwordEncoder.encode("123456"));
        userService.checkHasResign("test");
        userService.insertUser(user);
    }
}
