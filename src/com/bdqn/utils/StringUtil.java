package com.bdqn.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: com.bdqn.utils.StringUtil
 * @Description: 字符串工具类
 * @Author:      Administrator
 * @CreateDate: 2019/5/30 0030 下午 9:45
 * @UpdateUser:   Administrator
 * @Version:        1.0
 **/
public class StringUtil {

    public static boolean isNum(String string){
        Pattern pattern = Pattern.compile("[1-9]{1}\\d*");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
