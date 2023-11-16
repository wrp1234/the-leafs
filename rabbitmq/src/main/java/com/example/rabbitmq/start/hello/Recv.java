package com.example.rabbitmq.start.hello;

import com.example.rabbitmq.util.MqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.example.rabbitmq.start.hello.Send.QUEUE_NAME;

/**
 * @author wrp
 * @date 2023年11月14日 14:47
 * @description
 */
public class Recv {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = MqUtils.getChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }
}
