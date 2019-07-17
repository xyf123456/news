package com.bdqn.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: News
 * @Description: 新闻实体类
 * @Author: xyf
 * @Date 2019/5/25 0025 上午 10:00
 */
public class News implements Serializable{

    private static final long serialVersionUID = 6662630624876848949L;
    private int nid;
    private int ntid;
    private String ntname;
    private List<Comment> comments;
    private String ntitle;
    private String nauthor;
    private Date ncreatedate;
    private String npicpath;
    private String ncontent;
    private Date nmodifydate;
    private String nsummary;

    public News() {
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public int getNtid() {
        return ntid;
    }

    public void setNtid(int ntid) {
        this.ntid = ntid;
    }

    public String getNtname() {
        return ntname;
    }

    public void setNtname(String ntname) {
        this.ntname = ntname;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    public String getNauthor() {
        return nauthor;
    }

    public void setNauthor(String nauthor) {
        this.nauthor = nauthor;
    }

    public Date getNcreatedate() {
        return ncreatedate;
    }

    public void setNcreatedate(Date ncreatedate) {
        this.ncreatedate = ncreatedate;
    }

    public String getNpicpath() {
        return npicpath;
    }

    public void setNpicpath(String npicpath) {
        this.npicpath = npicpath;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    public Date getNmodifydate() {
        return nmodifydate;
    }

    public void setNmodifydate(Date nmodifydate) {
        this.nmodifydate = nmodifydate;
    }

    public String getNsummary() {
        return nsummary;
    }

    public void setNsummary(String nsummary) {
        this.nsummary = nsummary;
    }

    @Override
    public String toString() {
        return "News{" +
                "nid=" + nid +
                ", ntid=" + ntid +
                ", ntname='" + ntname + '\'' +
                ", comments=" + comments +
                ", ntitle='" + ntitle + '\'' +
                ", nauthor='" + nauthor + '\'' +
                ", ncreatedate=" + ncreatedate +
                ", npicpath='" + npicpath + '\'' +
                ", ncontent='" + ncontent + '\'' +
                ", nmodifydate=" + nmodifydate +
                ", nsummary='" + nsummary + '\'' +
                '}';
    }
}
