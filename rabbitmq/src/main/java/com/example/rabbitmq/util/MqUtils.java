package com.example.rabbitmq.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author wrp
 * @date 2023年11月14日 14:36
 * @description
 */
public class MqUtils {

    private final static ConnectionFactory factory;

    static {
        factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setVirtualHost("mq-study");
        factory.setUsername("wrp");
        factory.setPassword("123");
    }

    public static Channel getChannel() throws IOException, TimeoutException {
        return factory.newConnection().createChannel();
    }
}
