package com.thinhlh.hello_world_application.app.data;

import com.thinhlh.hello_world_application.app.domain.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class BookRepository {
    public List<Book> getBooks() {
        return new ArrayList<>() {{
            add(new Book(UUID.randomUUID(), "Book No 1"));
            add(new Book(UUID.randomUUID(), "Book No 2"));
        }};
    }
}
