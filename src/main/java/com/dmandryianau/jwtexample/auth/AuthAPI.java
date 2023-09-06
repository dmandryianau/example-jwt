package com.dmandryianau.jwtexample.auth;

import com.dmandryianau.jwtexample.auth.jwt.JwtAuthenticationResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;

@OpenAPIDefinition(
    info =
    @Info(
        title = "base.service.jwt",
        version = "1.0.0",
        description = "Base service for clients authentication and authorization",
        contact =
        @Contact(
            name = "Dzmitry Andryianau",
            email = "dm.andryianau@gmail.com")))
@SecurityScheme(
    name = "Authorization",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    scheme = "bearer")
@Tag(name = "Auth", description = "Auth API")
public interface AuthAPI {

  @Operation(
      operationId = "signUpUser",
      summary = "Create user and get JWT token",
      description = "Create user and get JWT token",
      security = @SecurityRequirement(name = "Authorization"))
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "Create user in db. Get JWT token",
              content = {
                  @Content(
                      mediaType = MediaType.APPLICATION_JSON_VALUE,
                      schema = @Schema(implementation = JwtAuthenticationResponse.class))
              }),
          @ApiResponse(
              responseCode = "404",
              description = "User not found")
      })
  JwtAuthenticationResponse signup(SignUpRequest request);

  @Operation(
      operationId = "signInUser",
      summary = "Try to sign in user and get JWT token",
      description = "Try to sign in user and get JWT token",
      security = @SecurityRequirement(name = "Authorization"))
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "Check if user exists in db. Get JWT token",
              content = {
                  @Content(
                      mediaType = MediaType.APPLICATION_JSON_VALUE,
                      schema = @Schema(implementation = JwtAuthenticationResponse.class))
              }),
          @ApiResponse(
              responseCode = "404",
              description = "User not found")
      })
  JwtAuthenticationResponse signin(SignInRequest request);
}
