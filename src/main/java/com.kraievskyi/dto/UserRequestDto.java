package com.kraievskyi.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class UserRequestDto {
    private String name;
    private String login;
    private String password;
    private String content;
}
