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
    private String account;
    private String password;
    private String email;
    private List<Role> Roles;

    public User() {
    }

    public User(int id, String account, String password, List<Role> Roles) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.Roles = Roles;
    }

    public User(int id, String account, String password, String email, List<Role> Roles) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.email = email;
        this.Roles = Roles;
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
     * @return account
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置
     * @param account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return account;
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
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
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
        return "User{id = " + id + ", account = " + account + ", password = " + password + ", Roles = " + Roles + "}";
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
}
