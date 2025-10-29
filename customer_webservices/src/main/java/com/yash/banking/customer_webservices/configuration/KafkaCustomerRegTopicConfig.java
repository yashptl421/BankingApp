package com.yash.banking.customer_webservices.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaCustomerRegTopicConfig {

    @Bean
    public NewTopic registrationTopic() {
        return TopicBuilder
                .name("registration-topic")
                .build();
    }
}
