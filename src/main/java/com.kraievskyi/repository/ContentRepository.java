package com.kraievskyi.repository;

import com.kraievskyi.model.Content;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContentRepository extends MongoRepository<Content, String> {
    List<Content> findAllByOrderByIdDesc();
}
