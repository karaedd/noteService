package com.kraievskyi.service.mapper;

import com.kraievskyi.dto.ContentRequestDto;
import com.kraievskyi.dto.ContentResponseDto;
import com.kraievskyi.model.Content;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class ContentMapper {

    public ContentResponseDto toContentResponseDto(Content content) {
        ContentResponseDto contentResponseDto = new ContentResponseDto();
        contentResponseDto.setId(content.getId());
        contentResponseDto.setNote(content.getNote());
        contentResponseDto.setLike(content.getLike());
        contentResponseDto.setUsersWhoLiked(content.getUsersWhoLiked());
        return contentResponseDto;
    }

    public Content toModel(ContentRequestDto contentRequestDto) {
        Content content = new Content();
        content.setNote(contentRequestDto.getNote());
        content.setLike(0);
        content.setUsersWhoLiked(new ArrayList<>());
        return content;
    }
}
