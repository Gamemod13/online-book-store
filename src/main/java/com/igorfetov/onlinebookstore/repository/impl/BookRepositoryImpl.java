package com.igorfetov.onlinebookstore.repository.impl;

import com.igorfetov.onlinebookstore.entity.Book;
import com.igorfetov.onlinebookstore.exception.BookEntityException;
import com.igorfetov.onlinebookstore.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final SessionFactory sessionFactory;

    public BookRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Book save(Book book) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(book);
            transaction.commit();
            return book;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new BookEntityException("Can't add book: " + book + " to DB", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            books.addAll(session.createQuery("from Book", Book.class)
                    .getResultList());
        } catch (Exception e) {
            throw new BookEntityException("Can't pull all books from DB", e);
        }
        return books;
    }
}
