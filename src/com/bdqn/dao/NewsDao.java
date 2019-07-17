package com.bdqn.dao;

import com.bdqn.entity.News;

import java.util.List;

/**
 * @ClassName: NewsDao
 * @Description: 新闻DAO（数据存取对象）接口
 * @Author: xyf
 * @Date 2019/6/11 0011 上午 11:00
 */
public interface NewsDao {

    List<News> selectNewsForAdmin();
}
