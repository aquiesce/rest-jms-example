package com.aquiesce.restexample.controller;

import com.aquiesce.restexample.model.Instrument;
import com.aquiesce.restexample.service.JmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    JmsService jmsService;

    public MessageController(JmsService jmsService) {
        this.jmsService = jmsService;
    }

    @PostMapping(path = "/new", consumes = "application/json", produces = "application/json")
    public void addMember(@RequestBody Instrument value) {

        LOGGER.info(value.getName());

        jmsService.send(value);
    }
}
