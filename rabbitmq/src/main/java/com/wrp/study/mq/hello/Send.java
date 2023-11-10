package com.wrp.study.mq.hello;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wrp.study.mq.util.ConnectionUtil;

import static com.wrp.study.mq.util.ConnectionUtil.QUEUE_NAME;

/**
 * @author wrp
 * @date 2023年11月02日 10:09
 * @description
 */
public class Send {

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();

        // 声明（创建）队列
        /**
         * 创建一个队列
         * 1.队列名称
         * 2.队列里面的消息是否持久化(默认为false,代表消息存储在内存中)
         * 3.该队列是否只供一个消费者进行消费,是否进行共享(true表示可以多个消费者消费)
         * 4.表示最后一个消费者断开连接以后,该队列是否自动删除(true表示自动删除)
         * 5.其他参数
         */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 消息内容
        String message = "Hello World!";
        /**
         * 发送一个消息
         * 1.发送到那个交换机(空代表默认交换机)
         * 2.路由key
         * 3.其他的参数信息
         * 4.发送消息的消息体
         */
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
