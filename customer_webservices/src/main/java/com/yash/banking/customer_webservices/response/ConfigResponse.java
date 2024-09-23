package com.yash.banking.customer_webservices.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("customer")
public class ConfigResponse {
    @Setter
    @Getter
    private String role;
    @Getter
    @Setter
    private String message;

}
