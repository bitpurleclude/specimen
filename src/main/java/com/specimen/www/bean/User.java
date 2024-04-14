package com.specimen.www.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class User implements UserDetails {
    @TableId(type = IdType.AUTO)
    private int id;
    private String password;
    private String email;
    @TableField(exist = false)
    private List<Role> Roles;

    public User() {
    }

    public User(int id, String password, String email, List<Role> Roles) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.Roles = Roles;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取
     * @return Roles
     */
    public List<Role> getRoles() {
        return Roles;
    }

    /**
     * 设置
     * @param Roles
     */
    public void setRoles(List<Role> Roles) {
        this.Roles = Roles;
    }

    public String toString() {
        return "User{id = " + id + ", password = " + password + ", email = " + email + ", Roles = " + Roles + "}";
    }
}
