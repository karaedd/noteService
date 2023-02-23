package com.kraievskyi.dto;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ContentResponseDto {
    private String id;
    private String note;
    private Long like;
    private List<String> usersWhoLiked;
}
