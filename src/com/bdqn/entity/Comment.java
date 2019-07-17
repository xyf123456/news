package com.bdqn.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Comment
 * @Description: 评论实体类
 * @Author: xyf
 * @Date 2019/5/25 0025 上午 10:02
 */
public class Comment implements Serializable{

    private static final long serialVersionUID = -1372323965314415375L;
    private int cid;
    private int cnid;
    private String ccontent;
    private Date cdate;
    private String cip;
    private String cauthor;

    public Comment() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getCnid() {
        return cnid;
    }

    public void setCnid(int cnid) {
        this.cnid = cnid;
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getCauthor() {
        return cauthor;
    }

    public void setCauthor(String cauthor) {
        this.cauthor = cauthor;
    }
}
