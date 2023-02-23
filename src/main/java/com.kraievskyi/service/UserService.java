package com.kraievskyi.service;

import com.kraievskyi.dto.UserRequestDto;
import com.kraievskyi.dto.UserResponseDto;
import java.util.List;

public interface UserService {
    UserResponseDto save(UserRequestDto userRequestDto);

    List<UserResponseDto> getAllUsers();

    UserResponseDto getById(String id);

    UserResponseDto updateUser(String id, UserRequestDto userRequestDto);

    void deleteById(String id);
}
