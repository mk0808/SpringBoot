package com.library.Library.controller;

import com.library.Library.domain.Book;
import com.library.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "/books")
    public String getBooks(Model model){
        List<Book> books = bookService.getBooks();
        //przekazywanie obiektów book do html za pomocą klasy Model
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping(value = "/books/delete/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping(value = "/books/add")
    public String addBook(Model model){
        Book book = bookService.getNewBook();
        model.addAttribute("book", book);
        return "book";
    }

    @PostMapping(value = "/books")
    public String saveBook(@Valid Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "book";
        }else {
            bookService.saveBook(book);
            return "redirect:/books";
        }
    }

    @GetMapping(value = "/books/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Book book = bookService.getBook(id);
        model.addAttribute("book",book);
        return "book";
    }

}
