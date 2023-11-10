package com.wrp.study.mq.topic;

import com.rabbitmq.client.*;
import com.wrp.study.mq.util.ConnectionUtil;

/**
 * @author wrp
 * @date 2023年11月06日 15:29
 * @description
 */
public class Consumer02 {
    private static final String EXCHANGE_NAME = "topic_logs";
    private static final String QUEUE_NAME = "Q2";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        // 创建channel
        Channel channel = connection.createChannel();
        // 声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        // 创建Q1队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 绑定队列与交换机
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "*.*.rabbit");
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "lazy.#");
        // 消费消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("获得消息:" + new String(message.getBody()));
        };
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println("消息消费被中断");
        };

        //每个消费者只能处理完当前消息才能接受新的消息
        channel.basicQos(1);
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }
}
