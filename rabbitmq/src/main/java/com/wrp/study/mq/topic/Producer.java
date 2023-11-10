package com.wrp.study.mq.topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import com.wrp.study.mq.util.ConnectionUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wrp
 * @date 2023年11月06日 15:25
 * @description
 */
public class Producer {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        // 创建channel
        Channel channel = connection.createChannel();
        // 声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        // 发送消息
        Map<String, String> messageMap = new HashMap<>();
        messageMap.put("quick.orange.rabbit", "被队列 Q1Q2 接收到");
        messageMap.put("lazy.orange.elephant", "被队列 Q1Q2 接收到");
        messageMap.put("quick.orange.fox", "被队列 Q1 接收到");
        messageMap.put("lazy.brown.fox", "被队列 Q2 接收到");
        messageMap.put("lazy.pink.rabbit", "虽然满足两个绑定但只被队列 Q2 接收一次");
        messageMap.put("quick.brown.fox", "不匹配任何绑定不会被任何队列接收到会被丢弃");
        messageMap.put("quick.orange.male.rabbit", "是四个单词不匹配任何绑定会被丢弃");
        messageMap.put("lazy.orange.male.rabbit", "是四个单词但匹配 Q2");
        for (Map.Entry<String, String> mes : messageMap.entrySet()) {
            String message = mes.getValue();
            String routingKey = mes.getKey();
//            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
            // 消息持久化，此时并不能保证消息不会丢失，准备写入磁盘时，消息还在缓存的一个间隔点
            channel.basicPublish(EXCHANGE_NAME, routingKey, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
            System.out.println("消息发送完毕" + message);
        }
    }
}
