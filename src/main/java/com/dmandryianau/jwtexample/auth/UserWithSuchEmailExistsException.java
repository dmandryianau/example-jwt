package com.dmandryianau.jwtexample.auth;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserWithSuchEmailExistsException extends RuntimeException {

  public UserWithSuchEmailExistsException() {
    super("User with such email already exists");
  }
}
