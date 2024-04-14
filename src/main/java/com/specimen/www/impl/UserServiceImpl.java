package com.specimen.www.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.specimen.www.bean.User;
import com.specimen.www.mapper.UserMapper;
import com.specimen.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService , UserDetailsService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getUserByUsername(String username) {
       QueryWrapper<User> query = new QueryWrapper(User.class);
       query.eq("email",username);
       return userMapper.selectOne(query);
   }
    public boolean checkHasResign(String email) {
         return getUserByUsername(email)!=null;
    }
    @Override
    public void insertUser(User user) {
       user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.insert(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userMapper.selectOne(new QueryWrapper<User>().eq("email",username));
        if (user==null){
            try {
                throw UsernameNotFoundException.class.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        else return user;
    }
}
