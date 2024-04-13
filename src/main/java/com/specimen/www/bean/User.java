package com.specimen.www.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.List;

public class User {
    @TableId(type = IdType.AUTO)
    private int id;
    private String account;
    private String password;
    private List<Role> Roles;

    public User() {
    }

    public User(int id, String account, String password, List<Role> Roles) {
        this.id = id;
        this.account = account;
        this.password = password;
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
}
