package com.kraievskyi.service.mapper;

import com.kraievskyi.dto.UserRequestDto;
import com.kraievskyi.dto.UserResponseDto;
import com.kraievskyi.model.Content;
import com.kraievskyi.model.User;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto toUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setLogin(user.getLogin());
        userResponseDto.setPassword(user.getPassword());
        userResponseDto.setContent(user.getContent()
                .stream()
                .map(Content::getId)
                .collect(Collectors.toList()));
        return userResponseDto;
    }

    public User toModel(UserRequestDto userRequestDto) {
        User user = new User();
        user.setName(userRequestDto.getName());
        user.setLogin(userRequestDto.getLogin());
        user.setPassword(userRequestDto.getPassword());
        user.setContent(new ArrayList<>());
        return user;
    }
}
