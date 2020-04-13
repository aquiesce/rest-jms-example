package com.aquiesce.restexample.service;

import com.aquiesce.restexample.model.Instrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

@Service
public class JmsServiceImpl implements JmsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JmsServiceImpl.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void send(Instrument message){

        LOGGER.info("sending message='{}'", message);

        try {
            JAXBContext context = JAXBContext.newInstance(Instrument.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            var s = new StringWriter();
            marshaller.marshal(message, s);

            jmsTemplate.convertAndSend("xml.q", s.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
