package com.kraievskyi.dto;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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
