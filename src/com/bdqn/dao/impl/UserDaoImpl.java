package com.bdqn.dao.impl;

import com.bdqn.dao.UserDao;
import com.bdqn.entity.News_User;
import com.bdqn.utils.BaseDao;
import com.bdqn.utils.Constant;
import com.bdqn.utils.Pager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserDaoImpl
 * @Description: 用户DAO接口
 * @Author: xyf
 * @Date 2019/5/28 0028 上午 10:57
 */
public class UserDaoImpl extends BaseDao implements UserDao {


    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    /**
     * @param user
     * @Description: 查询到用户
     * @param: [user]
     * @return: com.bdqn.entity.News_User
     * @Date: 2019/05/28 上午 11:02
     */
    @Override
    public News_User selectUser(News_User user) throws SQLException {
        News_User user1 = null;
        ResultSet resultSet = null;
//        try {
        String sql = "SELECT `uid`,`uname`,`upwd`  FROM `news_users` WHERE `uname`=? AND `upwd`=?";//SQL语句
        Object params[] = {user.getuName(), user.getuPwd()};
        resultSet = exeQuery(sql, params);
        //4、使用程序处理结果
        while (resultSet.next()) {
            String userName = resultSet.getString("uname");
            String userPwd = resultSet.getString("upwd");
            //通过查询得到的user表的信息，构造用户对象
            user1 = new News_User(userName, userPwd);
        }
      /*  }finally {
            DatabaseUtil.closeAll(null,null,resultSet);
        }*/

        return user1;
    }

    /**
     * @param searchModel
     * @param pageNum
     * @param pageSize
     * @Description: 查找到分页后的用户数据
     * @param: [searchModel, pageNum, pageSize]
     * @return: com.bdqn.utils.Pager<com.bdqn.entity.News_User>
     * @Date: 2019/05/30 上午 9:49
     */
    @Override
    public Pager<News_User> findUsersPaged(News_User searchModel, int pageNum, int pageSize) {
        List<News_User> allUsersList = findUsers(searchModel);
        Pager<News_User> pager = new Pager<News_User>(pageNum, pageSize, allUsersList);
        return pager;
    }

    /**
     * @param searchModel
     * @Description: 查询到所有用户数据
     * @param: [searchModel] 根据不同的业务模式
     * @return: java.util.List<org.apache.catalina.User>
     * @Date: 2019/05/30 上午 9:53
     */
    @Override
    public List<News_User> findUsers(News_User searchModel) {
        List<News_User> result = new ArrayList<News_User>();//用户结果集合
        List<Object> paramList = new ArrayList<Object>();//参数集合

        String userName = searchModel.getuName();
        Integer gender = searchModel.getGender();


        StringBuilder sql = new StringBuilder("SELECT * FROM `news_users` WHERE 1=1");
        if (userName != null && !userName.equals("")) {
            sql.append(" AND `uname` LIKE ?");
            paramList.add("%" + userName + "%");
        }
        if (gender == Constant.GENDER_MALE || gender == Constant.GENDER_FEMALE) {
            sql.append(" AND `gender` = ?");
            paramList.add(gender);
        }
        List<Map<String, Object>> mapList = null;
        try {
            mapList = findResult(sql.toString(), paramList);
            if (mapList != null) {
                for (Map<String, Object> map : mapList) {
                    News_User user = new News_User(map);
                    result.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有数据异常！", e);
        }

        return result;
    }

}
