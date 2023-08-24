package com.dmandryianau.jwtexample.auth.jwt;

import java.util.Arrays;

public enum SystemFrom {
  WEB,
  UNDEFINED;

  public SystemFrom get(String name) {
    return Arrays.stream(SystemFrom.values())
        .filter(item -> item.name().equals(name))
        .findFirst().orElse(UNDEFINED);
  }
}
