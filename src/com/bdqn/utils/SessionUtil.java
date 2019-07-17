package com.bdqn.utils;

import com.bdqn.entity.User;

import java.util.ArrayList;

/**
 * @ClassName: SessionUtil
 * @Description: Session相关的工具类
 * @Author: xyf
 * @Date 2019/6/6 0006 上午 8:30
 */
public class SessionUtil {

    public static Object getUserBySessionId(ArrayList<User> userList, String sessionIdString) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getSessionIdString().equals(sessionIdString)) {
                return user;
            }
        }
        return null;
    }
}
