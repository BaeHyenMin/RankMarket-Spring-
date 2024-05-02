package com.market.rank.config.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties("google.login")
public class GoogleLoginProperties {
    private String clientId;
    private String clientSecret;
    private String redirectUri;
}
