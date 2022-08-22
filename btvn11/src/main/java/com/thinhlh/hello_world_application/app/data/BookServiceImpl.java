package com.thinhlh.hello_world_application.app.data;

import com.thinhlh.hello_world_application.app.domain.entity.Book;
import com.thinhlh.hello_world_application.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Autowired
    private BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> getBooks() {
        return repository.getBooks();
    }
}
