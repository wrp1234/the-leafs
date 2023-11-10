package com.wrp.study.mq.ack;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wrp.study.mq.util.ConnectionUtil;

/**
 * @author wrp
 * @date 2023年11月07日 9:43
 * @description
 */
public class Producer {
    public static String QUEUE_NAME = "prefetch";

    public static void main(String[] args) throws Exception {
        // 创建channel
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // 发送消息
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        for (int i = 0; i < 10; i++) {
            String message = i + "";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("消息发送完毕" + message);
        }

        channel.close();
        connection.close();
    }
}
