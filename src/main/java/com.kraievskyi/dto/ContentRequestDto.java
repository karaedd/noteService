package com.kraievskyi.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentRequestDto {
    private String note;
    private Long like;
    private List<String> usersWhoLiked;
}
