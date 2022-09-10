package com.example.demo;

import com.example.demo.service.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@EnableJms
@SpringBootApplication
public class SpringBootActivemqApplication implements CommandLineRunner {

    final
    JmsTemplate jmsTemplate;

    public SpringBootActivemqApplication(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootActivemqApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        jmsTemplate.send("activemq-listener", new Msg());
    }
}
