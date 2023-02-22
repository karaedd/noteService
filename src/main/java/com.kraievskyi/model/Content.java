package com.kraievskyi.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter
@EqualsAndHashCode
public class Content {

    @Id
    @Indexed(unique = true)
    private String id;
    private String Note;
    private long like;
    private List<String> usersWhoLiked;
}
