package com.bestway.program.common.utils;


import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;


/**
 * Amqp消息接收
 */

@Service
public class AmqpReceiver {

    private static Logger logger = LoggerFactory.getLogger(AmqpReceiver.class);


    public void onMessage(Message message) {
        String body = new String(message.getBody());
        JSONObject json = JSONObject.parseObject(body);
        logger.info("接收消息：" + Result.toJSON(json));
    }


}
