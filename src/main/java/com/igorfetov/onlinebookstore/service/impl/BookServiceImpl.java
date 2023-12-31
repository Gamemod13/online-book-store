package com.igorfetov.onlinebookstore.service.impl;

import com.igorfetov.onlinebookstore.entity.Book;
import com.igorfetov.onlinebookstore.repository.BookRepository;
import com.igorfetov.onlinebookstore.service.BookService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
