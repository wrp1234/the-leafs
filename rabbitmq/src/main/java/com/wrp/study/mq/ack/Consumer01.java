package com.wrp.study.mq.ack;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import com.wrp.study.mq.util.ConnectionUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author wrp
 * @date 2023年11月07日 9:09
 * @description
 */
public class Consumer01 {
    public static final String QUEUE_NAME = "prefetch";
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.basicQos(5);

        DeliverCallback deliverCallback = ((consumerTag, message) -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("内容：" + new String(message.getBody()));
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
        });

        CancelCallback cancelCallback = (consumerTag -> System.out.println("消息中断"));
        channel.basicConsume(QUEUE_NAME, false, deliverCallback, cancelCallback);

    }
}
