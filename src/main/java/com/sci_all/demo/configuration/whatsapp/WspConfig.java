package com.sci_all.demo.configuration.whatsapp;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ConfigurationProperties("wsp")
public class WspConfig {

    private String authToken;
    private String metaEndpoint;

}
