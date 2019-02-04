package com.library.Library;

import com.library.Library.domain.Author;
import com.library.Library.domain.Book;
import com.library.Library.repository.BookRepository;
import com.library.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@PropertySource("classpath:custom.properties")
@Component

public class AppStarter implements CommandLineRunner{

    @Autowired
    BookService bookService;


    @Override
    public void run(String... args) throws Exception {
        init();

    }

    public void init(){
        Book book = new Book("Przygody Witka", 2018, "Nova", "523 622 689", new Author("Jakiś tam"));
        Book book1 = new Book("Przygody Magdy", 2018, "Nova", "523 622 689", new Author("Cos yam"));
        bookService.saveBook(book);
        bookService.saveBook(book1);
    }
}
