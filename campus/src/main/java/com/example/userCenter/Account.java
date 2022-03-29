package com.example.userCenter;


import java.io.Serializable;


public class Account implements Serializable {

    private String account_num;
    private String passwordHashStr;
    //private

    public String getAccount_num() {
        return account_num;
    }

    public void setAccount_num(String account_num) {
        this.account_num = account_num;
    }

    public String getPassword() {
        return passwordHashStr;
    }

    public void setPassword(String password) {
        this.passwordHashStr = password;
    }


}
