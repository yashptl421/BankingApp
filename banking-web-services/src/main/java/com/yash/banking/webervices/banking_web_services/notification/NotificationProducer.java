package com.yash.banking.webervices.banking_web_services.notification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationProducer {
    private final KafkaTemplate<String, AccountCreatedRequest> kafkaTemplate;

    public void sendNotification(AccountCreatedRequest request){
        log.info("Sending notification with body = < {} >", request);
        Message<AccountCreatedRequest> message = MessageBuilder
                .withPayload(request)
                .setHeader(TOPIC, "account-topic")
                .build();

        kafkaTemplate.send(message);
    }
}
