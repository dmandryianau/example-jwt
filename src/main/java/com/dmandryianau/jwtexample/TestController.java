package com.dmandryianau.jwtexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/resource")
public class TestController {

  @GetMapping
  public String sayHello() {
    return "Here is your resource";
  }
}
