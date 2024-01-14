package com.example.springbootactivemq.controller;

import com.example.springbootactivemq.dto.SystemMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PublishController {

    private JmsTemplate jmsTemplate;

    public PublishController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping("/publish/message")
    public ResponseEntity<String> publishMessage(@RequestBody SystemMessage systemMessage) {
        try{
            jmsTemplate.convertAndSend("testQueue", systemMessage);
            return new ResponseEntity<>("Sent", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
