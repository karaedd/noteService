package com.kraievskyi.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class ContentResponseDto {
    private String id;
    private String note;
    private Long like;
    private List<String> usersWhoLiked;
}
