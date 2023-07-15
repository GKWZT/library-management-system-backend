package com.example.controller;

import com.example.entity.RestBean;
import com.example.entity.book.Book;
import com.example.mapper.BookMapper;
import com.example.service.BookService;
import com.example.service.impl.BookServiceImpl;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wzt
 */
@Validated
@RestController
@RequestMapping("/api/auth/upload")
public class BookManagerController {

    BookService bookService = new BookServiceImpl();

    @Resource
    BookMapper mapper;


    @PostMapping("/create")
    public RestBean<String> createBook(@RequestParam("isbn") long isbn,
                                       @RequestParam("category") String category,
                                       @RequestParam("author") String author,
                                       @RequestParam("press") String press,
                                       @RequestParam("description") String description){

        // System.out.println("到service啦");
        // System.out.println(isbn+" "+category+"  "+author);
        mapper.createBook(isbn, category, author, press, description);
        // RestBean<String> book1 = bookService.createBook(isbn, category, author, press, description);
        return RestBean.success("上传成功啦");
    }

    @PostMapping("/getAllBook")
    public RestBean<List> getAllBook(){
        List bookAll = mapper.findBookAll();
        return RestBean.success(bookAll);
    }

}
