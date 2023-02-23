package com.kraievskyi.service;

import com.kraievskyi.dto.ContentRequestDto;
import com.kraievskyi.dto.ContentResponseDto;
import java.util.List;

public interface ContentService {

    ContentResponseDto addContent(String userId, ContentRequestDto contentRequestDto);

    List<ContentResponseDto> getAllContents();

    ContentResponseDto getById(String id);

    void updateLikes(String id, String userId);

    void deleteById(String id);
}
