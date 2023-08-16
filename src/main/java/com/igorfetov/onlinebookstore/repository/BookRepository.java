package com.igorfetov.onlinebookstore.repository;

import com.igorfetov.onlinebookstore.entity.Book;
import java.util.List;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();
}
