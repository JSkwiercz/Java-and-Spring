package com.company.service;

import com.company.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUser(String name);
    UserDto updateUser(UserDto userDto);
}
