package com.thinhlh.unit_test.controller;

import com.thinhlh.unit_test.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/exists")
    private Boolean isExistsAnyBook() {
        return bookService.isExistsAny();
    }
}
