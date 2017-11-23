package com.bestway.program.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 *  @Description:  rabbitmq连接的配置信息
 */
@Configuration
@PropertySource("classpath:rabbitmq.properties")
public class RabbitMQConfiguration {
    @Value("${rabbitmq.host}")
    private String host;
    @Value("${rabbitmq.userName}")
    private String userName;
    @Value("${rabbitmq.password}")
    private String password;
    @Value("${rabbitmq.port}")
    private Integer port;
    @Value("${rabbitmq.sendQueueName}")
    private String sendQueueName;
    @Value("${rabbitmq.receiverQueueName}")
    private String receiverQueueName;

    public String getReceiverQueueName() {
        return receiverQueueName;
    }

    public void setReceiverQueueName(String receiverQueueName) {
        this.receiverQueueName = receiverQueueName;
    }

    public String getSendQueueName() {
        return sendQueueName;
    }

    public void setSendQueueName(String sendQueueName) {
        this.sendQueueName = sendQueueName;
    }

    public Integer getPort() {
        return port;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
