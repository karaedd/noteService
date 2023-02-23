package com.kraievskyi.service.impl;

import com.kraievskyi.dto.UserRequestDto;
import com.kraievskyi.dto.UserResponseDto;
import com.kraievskyi.model.User;
import com.kraievskyi.repository.UserRepository;
import com.kraievskyi.service.UserService;
import com.kraievskyi.service.mapper.UserMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {
        return userMapper.toUserResponseDto(userRepository
                .save(userMapper.toModel(userRequestDto)));
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getById(String id) {
        return userMapper.toUserResponseDto(userRepository.findById(id).orElseThrow());
    }

    @Override
    public UserResponseDto updateUser(String id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(userRequestDto.getName());
        user.setLogin(userRequestDto.getLogin());
        user.setPassword(userRequestDto.getPassword());
        return userMapper.toUserResponseDto(user);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
