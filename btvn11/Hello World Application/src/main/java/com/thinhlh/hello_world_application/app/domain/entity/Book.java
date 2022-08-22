package com.thinhlh.hello_world_application.app.domain.entity;

import java.util.UUID;

public class Book {
    private final UUID id;
    private final String title;

    public Book(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public UUID getId() {
        return id;
    }
}
