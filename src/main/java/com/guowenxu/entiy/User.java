package com.guowenxu.entiy;

/**
 * 用户实体类
 */
public class User {

    private Integer id;
    private String user;
    private String pwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User() {
    }

    public User(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
    }

    public User(Integer id, String user, String pwd) {
        this.id = id;
        this.user = user;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
