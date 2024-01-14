package com.example.springbootactivemq.consumer;

import com.example.springbootactivemq.dto.SystemMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private static final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @JmsListener(destination = "testQueue")
    public void messageListener(SystemMessage systemMessage) {
        logger.info("Message received. {}", systemMessage);
    }
}
