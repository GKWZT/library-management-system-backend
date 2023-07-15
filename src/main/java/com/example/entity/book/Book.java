package com.example.entity.book;

import lombok.Data;

/**
 * @author wzt
 */
@Data
public class Book {

    private long id;
    private long isbn;
    private String category;
    private String author;
    private String press;
    private String description;


}
