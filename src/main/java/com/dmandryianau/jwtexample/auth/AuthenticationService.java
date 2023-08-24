package com.dmandryianau.jwtexample.auth;

import com.dmandryianau.jwtexample.auth.jwt.JwtAuthenticationResponse;

public interface AuthenticationService {
  JwtAuthenticationResponse signup(SignUpRequest request);

  JwtAuthenticationResponse signin(SignInRequest request);
}
