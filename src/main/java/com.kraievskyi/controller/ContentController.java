package com.kraievskyi.controller;

import com.kraievskyi.dto.ContentRequestDto;
import com.kraievskyi.dto.ContentResponseDto;
import com.kraievskyi.service.ContentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ContentResponseDto create(@PathVariable String userId, @Valid @RequestBody ContentRequestDto contentRequestDto) {
        return contentService.addContent(userId, contentRequestDto);
    }

    @GetMapping
    public List<ContentResponseDto> getAll() {
        return contentService.getAllContents();
    }

    @PatchMapping("/likes/{id}/{userId}")
    public ContentResponseDto updateLikes(@PathVariable String id, @PathVariable String userId) {
       return contentService.updateLikes(id, userId);
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
