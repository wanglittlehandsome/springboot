package com.bestway.program.common.utils;

import com.bestway.program.common.config.RabbitMQConfiguration;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * /**
 * Amqp消息注册监听
 */
@Configuration
public class AmqpListener {


    @Autowired
    private RabbitMQConfiguration rabbitMQConfiguration;
    @Autowired
    private AmqpReceiver amqpReceiver;

    @Bean
    public MessageListener exampleListener() {
        return new MessageListener() {
            public void onMessage(Message message) {
                amqpReceiver.onMessage(message);
            }
        };
    }

    @Bean
    public SimpleMessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(rabbitConnectionFactory());
        //设置监听的队列名，数组[]"abc","test4"
        String[] types = {rabbitMQConfiguration.getReceiverQueueName()};
        container.setQueueNames(types);
        container.setMessageListener(exampleListener());
        return container;
    }

    @Bean
    public ConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(rabbitMQConfiguration.getHost());
        connectionFactory.setUsername(rabbitMQConfiguration.getUserName());
        connectionFactory.setPassword(rabbitMQConfiguration.getPassword());
        connectionFactory.setPort(rabbitMQConfiguration.getPort());
        return connectionFactory;
    }

}
