package com.pojo;

public class UserTest {
    private Integer id;
    private String username;
    private String password;
    private String CheckCode;

    public UserTest(Integer id, String username, String password, String checkCode) {
        this.id = id;
        this.username = username;
        this.password = password;
        CheckCode = checkCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckCode() {
        return CheckCode;
    }

    public void setCheckCode(String checkCode) {
        CheckCode = checkCode;
    }

    @Override
    public String toString() {
        return "UserTest{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", CheckCode='" + CheckCode + '\'' +
                '}';
    }
}

