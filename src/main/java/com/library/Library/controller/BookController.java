package com.library.Library.controller;

import com.library.Library.domain.Book;
import com.library.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getBooks(Model model){
        List<Book> books = bookService.getBooks();
        //przekazywanie obiektów book do html za pomocą klasy Model
        model.addAttribute("books", books);
        return "books";
    }

    @RequestMapping(value = "/books/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.GET)
    public String addBook(Model model){
        Book book = bookService.getNewBook();
        model.addAttribute("book", book);
        return "book";
    }
}
