package com.bdqn.entity;

/**
 * @ClassName: User
 * @Description: 用户实体类
 * @Author: xyf
 * @Date 2019/6/6 0006 上午 8:29
 */
public class User {
    private String sessionIdString;

    private String ipString;

    private String firstTimeString;

    public String getSessionIdString() {
        return sessionIdString;
    }

    public void setSessionIdString(String sessionIdString) {
        this.sessionIdString = sessionIdString;
    }

    public String getIpString() {
        return ipString;
    }

    public void setIpString(String ipString) {
        this.ipString = ipString;
    }

    public String getFirstTimeString() {
        return firstTimeString;
    }

    public void setFirstTimeString(String firstTimeString) {
        this.firstTimeString = firstTimeString;
    }

    @Override
    public String toString() {
        return "User{" +
                "sessionIdString='" + sessionIdString + '\'' +
                ", ipString='" + ipString + '\'' +
                ", firstTimeString='" + firstTimeString + '\'' +
                '}';
    }
}
