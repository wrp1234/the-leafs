package com.wrp.study.mq.hello;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import com.wrp.study.mq.util.ConnectionUtil;

import static com.wrp.study.mq.util.ConnectionUtil.QUEUE_NAME;

/**
 * @author wrp
 * @date 2023年11月02日 10:14
 * @description
 */
public class RecvV2 {

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);


        // 消费消息的回调
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("成功消费消息,内容为:" + new String(message.getBody()));
        };
        // 取消消费的回调
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println("消息消费被中断");
        };

        /**
         * 消费者消费消息
         * 1.消费的队列名称
         * 2.消费成功之后是否要自动应答(true代表自动应答,false代表手动应答)
         * 3.消费者消费消息的回调(函数式接口)
         * 4.消费者取消消费的回调(函数式接口)
         */
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);

        // 获取消息
//        while (true) {
//            // nextDelivery阻塞
//            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//            String message = new String(delivery.getBody());
//            System.out.println(" [x] Received '" + message + "'");
//        }
    }
}
