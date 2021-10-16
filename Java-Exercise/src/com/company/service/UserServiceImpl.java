package com.company.service;

import com.company.dto.UserDto;
import com.company.io.User;
import com.company.io.repositories.UserBase;
import com.company.io.repositories.UserRepository;

public class UserServiceImpl implements UserService {

    UserRepository userRepository = new UserBase();

    @Override
    public UserDto createUser(UserDto userDto) {
        if (userRepository.findByName(userDto.getName()) != null) throw new RuntimeException("There is client with this name");

        User user = new User(userDto);

        User storedUserDetails = userRepository.save(user);

        return new UserDto(storedUserDetails);
    }

    @Override
    public UserDto getUser(String name) {

        User user = userRepository.findByName(name);

        if(user == null) throw new RuntimeException("User not found");

        return new UserDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {

        if (userRepository.findByName(userDto.getName()) == null) throw new RuntimeException("User not found");

        User user = userRepository.findByName(userDto.getName());

        User updatedUserDetails = userRepository.update(user);

        return new UserDto(updatedUserDetails);
    }
}
