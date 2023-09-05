package com.dmandryianau.jwtexample.auth.user;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserDto toUserDto(User user);
}
