package com.example.logintest.retrofitTest;

public class RegisterData {
    private String telephone;
    private String code;
    private String password;

    public RegisterData(String telephone, String code, String password) {
        this.telephone = telephone;
        this.code = code;
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
