package com.kraievskyi.controller;

import com.kraievskyi.dto.UserRequestDto;
import com.kraievskyi.dto.UserResponseDto;
import com.kraievskyi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
