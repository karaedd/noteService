package com.kraievskyi.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class UserResponseDto {
    private String id;
    private String name;
    private String login;
    private String password;
    private List<String> content;
}
