package com.sam.hello_rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Provider {

    //定义队列名
    static String QUEUE_NAME = "helloRabbit";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = null;
        Channel channel = null;
        try {
            //1.创建连接和通道
            connection = factory.newConnection();
            channel = connection.createChannel();
            
            //2.为通道声明队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            
            //3.发布消息
            String msg = " hello rabbitmq, welcome to sam's blog.";
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            System.out.println("provider send a msg: " + msg);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            //4.关闭连接
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}