package com.library.Library;

import com.library.Library.domain.Author;
import com.library.Library.domain.Book;
import com.library.Library.service.BookService;
import com.library.Library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@PropertySource("classpath:custom.properties")
@Component
public class AppStarter implements CommandLineRunner {

    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;

    @Override
    public void run(String... args) throws Exception {
        init();
        initUsers();
    }

    public void initUsers() {
        userService.createUser("admin", "pass");
        userService.addRoleToUser("admin", "ADMIN");
        userService.addRoleToUser("admin", "DEV");
        userService.addRoleToUser("admin", "USER");

        userService.createUser("user", "pass");
        userService.addRoleToUser("user", "USER");
    }

    public void init() {
        Book book = new Book("Przygody Witka", 2018, "Nova", "5236226891", new Author("Jakiś tam"));
        Book book1 = new Book("Przygody Magdy", 2018, "Nova", "5235622689", new Author("Cos yam"));
        bookService.saveBook(book);
        bookService.saveBook(book1);
    }
}
