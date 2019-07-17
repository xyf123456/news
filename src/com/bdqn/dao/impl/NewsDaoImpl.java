package com.bdqn.dao.impl;

import com.bdqn.dao.NewsDao;
import com.bdqn.entity.News;
import com.bdqn.entity.Topic;
import com.bdqn.utils.BaseDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: NewsDaoImpl
 * @Description: 新闻DAO（数据存取对象）接口实现类
 * @Author: xyf
 * @Date 2019/6/11 0011 上午 11:00
 */
public class NewsDaoImpl extends BaseDao implements NewsDao{

    public NewsDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<News> selectNewsForAdmin() {
        ResultSet resultSet = null;
        List<News> list = new ArrayList<News>();
        // 获取新闻信息，包含，标题、作者、id
        String sql = "SELECT `nid`,`ntitle`,`nauthor`,`ncreateDate` FROM `news`";
        Object params[] = {};

        resultSet = exeQuery(sql, params);
        News news = null;
        try {
            while (resultSet.next()) {
                news = new News();
                news.setNid(resultSet.getInt("nid"));
                news.setNtitle(resultSet.getString("ntitle"));
                news.setNauthor(resultSet.getString("nauthor"));
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                news.setNcreatedate(dateFormat.parse(resultSet.getString("ncreateDate")));
                list.add(news);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return list;
    }
}
