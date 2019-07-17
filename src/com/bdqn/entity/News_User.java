package com.bdqn.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

/**
 * @ClassName: News_User
 * @Description: 用户实体类
 * @Author: xyf
 * @Date 2019/5/28 0028 上午 11:13
 */
@Entity
@Table(name = "news_users")
public class News_User implements Serializable {


    private Integer uId;
    private String uName;
    private String uPwd;
    private int gender;

    public News_User(String uName, String uPwd) {
        this.uName = uName;
        this.uPwd = uPwd;
    }

    public News_User() {
    }

    public News_User(Integer uId, String uName, String uPwd, int gender) {
        this.uId = uId;
        this.uName = uName;
        this.uPwd = uPwd;
        this.gender = gender;
    }

    public News_User(Map<String, Object> map) {
        this.uId = (Integer) map.get("uid");
        this.uName = (String) map.get("uname");
        this.uPwd = (String) map.get("upwd");
        this.gender = (Integer) map.get("gender");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Column(name = "uname")
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Column(name = "upwd")
    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    @Column(name = "gender")
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "News_User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPwd='" + uPwd + '\'' +
                ", gender=" + gender +
                '}';
    }
}
