package com.dmandryianau.jwtexample.auth.user;

import lombok.Data;

@Data
public class UserDto {

  private String firstName;
  private String lastName;
  private String email;
}
