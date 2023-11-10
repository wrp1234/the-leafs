package com.wrp.study.mq.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.wrp.study.mq.util.ConnectionUtil;

/**
 * @author wrp
 * @date 2023年11月02日 13:51
 * @description
 */
public class Send {

    public static final String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true);

        String message = "更新商品";
        channel.basicPublish(EXCHANGE_NAME, "update", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
