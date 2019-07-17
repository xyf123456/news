package com.bdqn.entity;

import java.io.Serializable;

/**
 * @ClassName: Topic
 * @Description: 主题实体类
 * @Author: xyf
 * @Date 2019/5/25 0025 上午 10:04
 */
public class Topic implements Serializable {

    private static final long serialVersionUID = 9028296542619742524L;
    private int tid;
    private String tname;

    public Topic() {
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }


    @Override
    public String toString() {
        return "Topic{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                '}';
    }
}
