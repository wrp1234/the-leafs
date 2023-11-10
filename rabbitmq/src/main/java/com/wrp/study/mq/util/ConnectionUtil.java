package com.wrp.study.mq.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author wrp
 * @date 2023年11月02日 10:08
 * @description
 */
public class ConnectionUtil {
    public final static String QUEUE_NAME = "q_test_01";
    public static Connection getConnection() throws Exception {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
        factory.setHost("localhost");
        //端口
        factory.setPort(5672);
        //设置账号信息，用户名、密码、vhost
        factory.setVirtualHost("mq-study");
        factory.setUsername("wrp");
        factory.setPassword("123");
        // 通过工程获取连接
        Connection connection = factory.newConnection();
        return connection;
    }
}
