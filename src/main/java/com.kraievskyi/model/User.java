package com.kraievskyi.model;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@EqualsAndHashCode
public class User {

    @Id
    @Indexed(unique = true)
    private String id;
    private String name;
    private String login;
    private String password;
    private List<Content> content;
}
