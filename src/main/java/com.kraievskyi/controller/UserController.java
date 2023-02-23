package com.kraievskyi.controller;

import com.kraievskyi.dto.UserRequestDto;
import com.kraievskyi.dto.UserResponseDto;
import com.kraievskyi.service.UserService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto create(@RequestBody UserRequestDto userRequestDto) {
        return userService.save(userRequestDto);
    }

    @GetMapping("/{id}")
    public UserResponseDto getById(@PathVariable String id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public UserResponseDto update(@PathVariable String id,
                                  @RequestBody UserRequestDto userRequestDto) {
        return userService.updateUser(id, userRequestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.deleteById(id);
    }
}
