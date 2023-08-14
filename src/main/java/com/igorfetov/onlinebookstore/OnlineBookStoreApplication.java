package com.igorfetov.onlinebookstore;

import com.igorfetov.onlinebookstore.entity.Book;
import com.igorfetov.onlinebookstore.service.BookService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineBookStoreApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(OnlineBookStoreApplication.class, args);
    }

    @Bean
    CommandLineRunner getCommandLineRunner() {
        return args -> {
            Book book = new Book().setTitle("Title").setAuthor("Author")
                    .setDescription("Description").setPrice(BigDecimal.valueOf(299))
                    .setIsbn("isbn").setCoverImage("cover_image");
            bookService.save(book);
        };
    }
}
