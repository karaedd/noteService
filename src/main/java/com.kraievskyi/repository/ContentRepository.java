package com.kraievskyi.repository;

import com.kraievskyi.model.Content;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContentRepository extends MongoRepository<Content, String> {
    List<Content> findAllByOrderByIdDesc();
}
