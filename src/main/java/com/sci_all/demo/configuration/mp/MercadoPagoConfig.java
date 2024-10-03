package com.sci_all.demo.configuration.mp;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ConfigurationProperties(prefix = "mp")
public class MercadoPagoConfig {

    private String accessToken;

}
