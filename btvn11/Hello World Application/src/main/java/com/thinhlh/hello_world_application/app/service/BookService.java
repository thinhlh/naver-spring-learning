package com.thinhlh.hello_world_application.app.service;

import com.thinhlh.hello_world_application.app.domain.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
}
