//package com.wrp.study.mq.hello;
//
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.QueueingConsumer;
//import com.wrp.study.mq.util.ConnectionUtil;
//
//import static com.wrp.study.mq.util.ConnectionUtil.QUEUE_NAME;
//
///**
// * @author wrp
// * @date 2023年11月02日 10:14
// * @description
// */
//public class Recv {
//
//    public static void main(String[] argv) throws Exception {
//
//        // 获取到连接以及mq通道
//        Connection connection = ConnectionUtil.getConnection();
//        // 从连接中创建通道
//        Channel channel = connection.createChannel();
//        // 声明队列
//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//
//        // 定义队列的消费者
//        QueueingConsumer consumer = new QueueingConsumer(channel);
//
//        // 监听队列
//        channel.basicConsume(QUEUE_NAME, true, consumer);
//
//        // 获取消息
//        while (true) {
//            // nextDelivery阻塞
//            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//            String message = new String(delivery.getBody());
//            System.out.println(" [x] Received '" + message + "'");
//        }
//    }
//}
