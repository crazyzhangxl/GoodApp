package com.zxl.goodapp.base;

/**
 * @author zxl crazyZhangxl on 2018/9/25.
 * Describe: 登陆请求的 body
 */
public class LoginRequest {

    /**
     * password : string
     * username : string
     */

    private String password;
    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
