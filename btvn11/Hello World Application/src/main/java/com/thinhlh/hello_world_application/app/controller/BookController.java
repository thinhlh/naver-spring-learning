package com.thinhlh.hello_world_application.app.controller;

import com.thinhlh.hello_world_application.app.domain.entity.Book;
import com.thinhlh.hello_world_application.app.service.BookService;
import com.thinhlh.hello_world_application.base.BaseController;
import com.thinhlh.hello_world_application.base.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController extends BaseController {

    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    private List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/hello")
    private ResponseEntity<BaseResponse<String>> hello() {
        return successResponse("Hello");
    }

    @GetMapping("/notfound")
    private ResponseEntity<BaseResponse<String>> unauthorized() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(BaseResponse.error("Unauthorized"));
    }
}
