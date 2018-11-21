package com.zxl.goodapp.base;

/**
 * @author zxl crazyZhangxl on 2018/9/25.
 * Describe:
 */
public class LoginResponse {

    /**
     * image : string
     * realname : string
     * register_time : 2018-09-25T06:10:57.094Z
     * role : string
     * token : string
     * user_id : 0
     * username : string
     */

    private String image;
    private String realname;
    private String register_time;
    private String role;
    private String token;
    private int user_id;
    private String username;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getRegister_time() {
        return register_time;
    }

    public void setRegister_time(String register_time) {
        this.register_time = register_time;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
