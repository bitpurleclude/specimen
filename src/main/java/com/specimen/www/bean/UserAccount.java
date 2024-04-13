package com.specimen.www.bean;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("user_account_password")
public class UserAccount {
    private int id;
    private String account;
    private String password;

    public UserAccount() {
    }

    public UserAccount(String account, String password) {
        this.account = account;
        this.password = password;
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

    public String toString() {
        return "UserAccount{account = " + account + ", password = " + password + "}";
    }
}
