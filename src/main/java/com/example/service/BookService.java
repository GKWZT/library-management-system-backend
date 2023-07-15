package com.example.service;

import com.example.entity.RestBean;
import org.springframework.stereotype.Service;


public interface BookService {
    RestBean<String> createBook(long isbn, String category, String author, String press, String description);
}
