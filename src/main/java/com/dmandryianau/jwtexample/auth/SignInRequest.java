package com.dmandryianau.jwtexample.auth;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignInRequest {

  private String email;
  private String password;
}
