package com.wrp.study.mq.subscribe;

import com.rabbitmq.client.*;
import com.wrp.study.mq.util.ConnectionUtil;

/**
 * @author wrp
 * @date 2023年11月06日 15:19
 * @description
 */
public class Consumer01 {
    public static void main(String[] args) throws Exception {
        // 创建channel
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // 声明交换机
        channel.exchangeDeclare("logs", BuiltinExchangeType.FANOUT);
        // 声明临时队列
        String queueName = channel.queueDeclare().getQueue();
        // 绑定队列与交换机
        channel.queueBind(queueName, "logs", "");
        // 消费消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("获得消息:" + new String(message.getBody()));
        };
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println("消息消费被中断");
        };
        channel.basicConsume(queueName, true, deliverCallback, cancelCallback);
    }
}
