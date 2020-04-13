package com.aquiesce.restexample.service;

import com.aquiesce.restexample.model.Instrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsServiceImpl implements JmsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JmsServiceImpl.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void send(Instrument message){

        LOGGER.info("sending message='{}'", message);
        jmsTemplate.convertAndSend("helloworld.q", message);
    }
}
