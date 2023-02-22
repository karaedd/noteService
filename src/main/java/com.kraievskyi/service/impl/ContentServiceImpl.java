package com.kraievskyi.service.impl;

import com.kraievskyi.dto.ContentRequestDto;
import com.kraievskyi.dto.ContentResponseDto;
import com.kraievskyi.model.Content;
import com.kraievskyi.model.User;
import com.kraievskyi.repository.ContentRepository;
import com.kraievskyi.repository.UserRepository;
import com.kraievskyi.service.ContentService;
import com.kraievskyi.service.mapper.ContentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;
    private final UserRepository userRepository;
    private final ContentMapper contentMapper;

    public ContentServiceImpl(ContentRepository contentRepository, UserRepository userRepository, ContentMapper contentMapper) {
        this.contentRepository = contentRepository;
        this.userRepository = userRepository;
        this.contentMapper = contentMapper;
    }


    @Override
    public ContentResponseDto addContent(String userId, ContentRequestDto contentRequestDto) {
        Content model = contentRepository.save(contentMapper.toModel(contentRequestDto));
        User user = userRepository.findById(userId).orElseThrow();
        List<Content> content = user.getContent();
        content.add(model);
        user.setContent(content);
        userRepository.save(user);
        return contentMapper.toContentResponseDto(model);
    }

    @Override
    public List<ContentResponseDto> getAllContents() {
        return contentRepository.findAllByOrderByIdDesc()
                .stream()
                .map(contentMapper::toContentResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ContentResponseDto getById(String id) {
        return contentMapper.toContentResponseDto(contentRepository.findById(id).orElseThrow());
    }

    @Override
    public ContentResponseDto updateLikes(String id, String userId) {
        Content content = contentRepository.findById(id).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();
        if (!content.getUsersWhoLiked().contains(user.getId())) {
            content.getUsersWhoLiked().add(user.getId());
            content.setLike(content.getLike() + 1);
        } else if (content.getUsersWhoLiked().contains(user.getId()) && content.getLike() > 0){
            content.setLike(content.getLike() - 1);
            content.getUsersWhoLiked().remove(user.getId());
        }
        contentRepository.save(content);
        return contentMapper.toContentResponseDto(content);
    }

    @Override
    public void deleteById(String id) {

    }
}
