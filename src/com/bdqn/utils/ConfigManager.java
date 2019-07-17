package com.bdqn.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName: TestConnection
 * @Description: 数据库连接配置类(单例模式)
 * 单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。
 * 这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式；
 * 这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有
 * 单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，
 * 不需要实例化该类的对象。
 * @Author: xyf
 * @Date 2019/5/20 0020 下午 3:01
 */
public class ConfigManager {

    //Properties类型的属性
    private static Properties properties;

    private static ConfigManager configManager;

    /**
     * @Description: 构造方法
     * @param: []
     * @return:
     * @Date:
     */
    private ConfigManager() {
//        绝对路径:D:\workspace\javaWebDemo1\resources\database.properties
//        相对路径:database.properties
        String configFile = "database.properties";
        properties = new Properties();
//        Class configManagerClass=ConfigManager.class;
//        Class str = String.class;
        InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
        try {
            //读取配置文件
            properties.load(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 单例模式获取ConfigManager对象
     * @param: []
     * @return: com.bdqn.utils.ConfigManager
     * @Date: 2019/05/20 下午 5:14
     */
    public static ConfigManager getInstance() {
        if (configManager == null) {
            configManager = new ConfigManager();
        }
        return configManager;
    }

    /**
     * @Description: 通过配置属性文件中的键得到对应的值
     * @param: [key]
     * @return: java.lang.String
     * @Date: 2019/05/20 下午 5:15
     */
    public String getString(String key) {
        return properties.getProperty(key);
    }

}
