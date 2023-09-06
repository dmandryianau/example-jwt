package com.dmandryianau.jwtexample.auth;

import com.dmandryianau.jwtexample.auth.jwt.JwtAuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController implements AuthAPI {

  private final AuthenticationService authenticationService;

  @PostMapping("/signup")
  public JwtAuthenticationResponse signup(@RequestBody SignUpRequest request) {
    return authenticationService.signup(request);
  }

  @PostMapping("/signin")
  public JwtAuthenticationResponse signin(@RequestBody SignInRequest request) {
    return authenticationService.signin(request);
  }
}