package com.sam.hello_rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class HelloConsumer {

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = null;
        Channel channel = null;
        try {
            // 1.创建连接和通道
            connection = factory.newConnection();
            channel = connection.createChannel();

            // 2.为通道声明队列
            channel.queueDeclare(Provider.QUEUE_NAME, false, false, false, null);
            System.out.println(" **** keep alive ,waiting for messages, and then deal them");
            // 3.通过回调生成消费者
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                        com.rabbitmq.client.AMQP.BasicProperties properties, byte[] body) throws IOException {
                    
                    //获取消息内容然后处理
                    String msg = new String(body, "UTF-8");
                    System.out.println("*********** HelloConsumer" + " get message :[" + msg +"]");
                }
            };
            
            //4.消费消息
            channel.basicConsume(Provider.QUEUE_NAME, true, consumer);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}