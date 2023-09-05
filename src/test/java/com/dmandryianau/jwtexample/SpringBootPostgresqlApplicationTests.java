package com.dmandryianau.jwtexample;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.dmandryianau.jwtexample.auth.SignUpRequest;
import com.dmandryianau.jwtexample.auth.user.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
@TestMethodOrder(OrderAnnotation.class)
class SpringBootPostgresqlApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ObjectMapper objectMapper;

  private final static List<SignUpRequest> employees = new ArrayList<>();

  @Container
  private static final PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(
      "postgres:11.1")
      .withDatabaseName("integration-tests-db").withUsername("username").withPassword("password");

  static {
    postgreSQLContainer.start();
  }

  static {

    SignUpRequest emp1 = SignUpRequest.builder()
        .firstName("test emp1")
        .email("address1")
        .password("password1")
        .build();

    employees.add(emp1);
  }

  @DynamicPropertySource
  static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
    dynamicPropertyRegistry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
    dynamicPropertyRegistry.add("spring.datasource.username", postgreSQLContainer::getUsername);
    dynamicPropertyRegistry.add("spring.datasource.password", postgreSQLContainer::getPassword);
  }

  @Test
  @Order(value = 1)
  void testConnectionToDatabase() {
    Assertions.assertNotNull(userRepository);
  }

  @Test
  @Order(value = 2)
  void testAddEmployees() throws Exception {
    for (SignUpRequest employee : employees) {
      String emp = objectMapper.writeValueAsString(employee);
      mockMvc.perform(
          MockMvcRequestBuilders.post("/api/v1/auth/signup").contentType(MediaType.APPLICATION_JSON)
              .content(emp)).andExpect(status().is2xxSuccessful());
    }
    Assertions.assertEquals(1, userRepository.findAll().size());
  }
}