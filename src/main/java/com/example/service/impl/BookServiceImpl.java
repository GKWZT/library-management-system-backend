package com.example.service.impl;

import com.example.entity.RestBean;
import com.example.mapper.BookMapper;
import com.example.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wzt
 */
@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper mapper;


    @Override
    public RestBean<String> createBook(long isbn, String category, String author, String press, String description) {

        // if (mapper.createBook(isbn,category,author,press,description) == 1){
        //     return RestBean.success();
        // }
        System.out.println("mapper"+mapper.createBook(isbn,category,author,press,description));
        return RestBean.failure(400,"创建失败");
    }
}
