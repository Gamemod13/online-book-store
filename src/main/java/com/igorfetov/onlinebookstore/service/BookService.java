package com.igorfetov.onlinebookstore.service;

import com.igorfetov.onlinebookstore.entity.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
