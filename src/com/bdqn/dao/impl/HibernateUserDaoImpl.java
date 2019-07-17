package com.bdqn.dao.impl;

import com.bdqn.dao.UserDao;
import com.bdqn.entity.News_User;
import com.bdqn.utils.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: com.bdqn.dao.impl.HibernateUserDaoImpl
 * @Description:Hibernate框架实现User的数据库查询
 * @Author: Administrator
 * @CreateDate: 2019/6/1 0001 下午 2:32
 * @UpdateUser: Administrator
 * @Version: 1.0
 **/
public class  HibernateUserDaoImpl implements UserDao {


    @Override
    public News_User selectUser(News_User user) throws SQLException {
        return null;
    }

    @Override
    public Pager<News_User> findUsersPaged(News_User searchModel, int pageNum, int pageSize) {
        Pager<News_User> result = null;
        //存放参查询参数
        Map<String, Object> paramMap = new HashMap<String, Object>();
        //得到查询模式
        String userName = searchModel.getuName();
        Integer gender = searchModel.getGender();


        StringBuilder hql = new StringBuilder("from News_User where 1 = 1 ");
        StringBuilder countHql = new StringBuilder("SELECT COUNT(uid) FROM News_User WHERE 1=1");
        if (userName != null && !userName.equals("")) {
            hql.append(" AND uName LIKE :uName");
//            paramMap.add("%" + userName + "%");
            paramMap.put("uName", "%" + userName + "%");
        }
        if (gender == Constant.GENDER_MALE || gender == Constant.GENDER_FEMALE) {
            hql.append(" AND gender = :gender");
//            paramList.add(gender);
            paramMap.put("gender",gender);
        }
        //起始索引
        int fromIndex = pageSize * (pageNum - 1);
        //添加分页语句
//        hql.append(" limit ").append(fromIndex).append(",").append(pageSize);
//        hql.append(" limit ");
//        hql.append(" "+fromIndex);
//        hql.append(",");
//        hql.append(pageSize);


        List<News_User> listUser = new ArrayList<News_User>();//用户结果集合

        Session session = null;
        try {
            session = HibernateSessionFactory.getSession();
            //            获取Query对象

            Query hqlQuery = session.createQuery(hql.toString());
//            Query hqlQuery =session.createSQLQuery(hql.toString());
            Query countHqlQuery = session.createQuery(countHql.toString());
//            Query countHqlQuery  = session.createSQLQuery(countHql.toString());

            //从第几条记录开始
            hqlQuery.setFirstResult(fromIndex);
            //一共查询多少条记录(即每次查询的最大记录数)
            hqlQuery.setMaxResults(pageSize);

            //设置查询参数
            DatabaseUtil.setQueryParams(hqlQuery, paramMap);
//            DatabaseUtil.setQueryParams(countHqlQuery, paramMap);

            //查询用户的信息
            listUser = hqlQuery.list();
            //获取用户的总记录数
            List<?> countResult = countHqlQuery.list();
            int totalRecord = ((Number) countResult.get(0)).intValue();
            //组装page对象
            result = new Pager<News_User>(pageSize, pageNum, totalRecord, totalRecord, listUser);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            session.close();//关闭流，一定要关闭，不然会影响运行速度。
            HibernateSessionFactory.closeSession();
        }
        return result;
    }

    @Override
    public List<News_User> findUsers(News_User searchModel) throws SQLException {
        return null;
    }
}
