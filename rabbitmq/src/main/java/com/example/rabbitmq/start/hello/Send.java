package com.example.rabbitmq.start.hello;

import com.example.rabbitmq.util.MqUtils;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author wrp
 * @date 2023年11月14日 14:36
 * @description
 */
public class Send {
    public final static String QUEUE_NAME = "hello";
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = MqUtils.getChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
    }
}
