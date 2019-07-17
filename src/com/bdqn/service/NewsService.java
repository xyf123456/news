package com.bdqn.service;

import com.bdqn.entity.News;

import java.util.List;

/**
 * @ClassName: NewsService
 * @Description: 新闻业务接口
 * @Author: xyf
 * @Date 2019/6/11 0011 上午 10:36
 */
public interface NewsService {


    List<News> findNewsForAdmin();
}
