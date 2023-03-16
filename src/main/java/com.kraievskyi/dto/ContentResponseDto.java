package com.kraievskyi.dto;

import java.util.List;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentResponseDto {
    private String id;
    private String note;
    private Long like;
    private List<String> usersWhoLiked;
}
