package com.appsfortest.app.ws.ui.controller;

import com.appsfortest.app.ws.service.UserService;
import com.appsfortest.app.ws.shared.dto.UserDto;
import com.appsfortest.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsfortest.app.ws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser() {
        return("Welcome!");
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {

        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }

    @PutMapping
    public void updateUser() {

    }

    @DeleteMapping
    public void deleteUser() {

    }
}
