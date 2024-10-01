package com.sci_all.demo.configuration.twilio;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ConfigurationProperties(prefix = "twilio")
public class TwilioConfig {
    private String accountSid;
    private String authToken;
    private String phoneNumber;
    private String messagingServiceSid;
}
