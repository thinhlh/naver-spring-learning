package com.thinhlh.unit_test.service;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public Boolean isExistsAny() {
        return true;
    }
}
