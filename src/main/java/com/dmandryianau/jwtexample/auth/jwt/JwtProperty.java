package com.dmandryianau.jwtexample.auth.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtProperty {

  private String signingKey;
  private Long expirationInMinutes;
}
