package com.kraievskyi.controller;

import com.kraievskyi.dto.ContentRequestDto;
import com.kraievskyi.dto.ContentResponseDto;
import com.kraievskyi.service.ContentService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/content")
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ContentResponseDto create(@PathVariable String userId,
                                     @RequestBody ContentRequestDto contentRequestDto) {
        return contentService.addContent(userId, contentRequestDto);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ContentResponseDto createWithoutRegistration(
            @RequestBody ContentRequestDto contentRequestDto) {
        return contentService.addContentWithoutRegistration(contentRequestDto);
    }

    @GetMapping
    public List<ContentResponseDto> getAll() {
        return contentService.getAllContents();
    }

    @PatchMapping("/likes/{id}/{userId}")
    public void updateLikes(@PathVariable String id,
                                          @PathVariable String userId) {
        contentService.updateLikes(id, userId);
    }

    @GetMapping("/{id}")
    public ContentResponseDto getById(@PathVariable String id) {
        return contentService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        contentService.deleteById(id);
    }
}
