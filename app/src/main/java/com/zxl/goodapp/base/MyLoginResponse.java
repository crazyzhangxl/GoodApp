package com.zxl.goodapp.base;

/**
 * @author crazyZhangxl on 2018/11/1.
 * Describe:
 */
public class MyLoginResponse {
    private int code;
    private String msg;
    private LoginResponse data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LoginResponse getData() {
        return data;
    }

    public void setData(LoginResponse data) {
        this.data = data;
    }
}
