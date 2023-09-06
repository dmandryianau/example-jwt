package com.dmandryianau.jwtexample.auth.user;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
@Tag(name = "User", description = "User API")
public interface UserAPI {

  @Operation(
      operationId = "getUserById",
      summary = "Get user info by id",
      description = "Get user info by id",
      security = @SecurityRequirement(name = "Authorization"))
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "User exists. Get user info",
              content = {
                  @Content(
                      mediaType = MediaType.APPLICATION_JSON_VALUE,
                      schema = @Schema(implementation = UserDto.class))
              }),
          @ApiResponse(
              responseCode = "404",
              description = "User not found")
      })
  UserDto getUserById(
      @Parameter(
          description = "id of user to be searched",
          required = true,
          schema = @Schema(maxLength = 36)) Long id);
}
