package com.library.Library.restController;

import com.library.Library.domain.Book;
import com.library.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {

    @Autowired
    BookService bookService;

    @GetMapping(path = "/books")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> books = bookService.getBooks();

        if(books == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @DeleteMapping(path = "/books/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id){
        Book book = bookService.getBook(id);

        if(book == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PostMapping(path = "/books/add")
    public ResponseEntity<Void> addBook(@RequestBody Book book){
        if(book == null)
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

        bookService.saveBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/books/edit/{id}")
    public ResponseEntity<Void> editBook(@PathVariable("id") int id, @RequestBody Book book){
        Book updateBook = bookService.getBook(id);

        if(updateBook == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        if(book == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        book.setId(updateBook.getId());
        book.getAuthor().setId(updateBook.getAuthor().getId());

        bookService.saveBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(path = "/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id){
        Book book = bookService.getBook(id);

        if(book == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping(path = "/books/author")
    @ResponseBody
    public ResponseEntity<List<Book>> getBooksByAuthor(@RequestParam(value = "name", required = true) String nameAuthor){
        List<Book> books = bookService.getBooksByAuthor(nameAuthor);
        if(books == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping(path = "/books/get")
    @ResponseBody
    public ResponseEntity<List<Book>> getBooks(@RequestParam(value = "isbn", required = false) String isbn,
                                               @RequestParam(value = "publisher", required = false) String publisher,
                                               @RequestParam(value = "year", required = false) Integer year){
        List<Book> books = bookService.getBooks(isbn, publisher, year);
        if(books == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping(path = "/books/getByTitle")
    @ResponseBody
    public ResponseEntity<List<Book>> getBooksBTitle(@RequestParam(value = "title", required = true) String title){
        List<Book> books = bookService.getBooksByTitle(title);
        if(books == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ExceptionDetail> exceptionHandler(MissingServletRequestParameterException ex){
        ExceptionDetail exceptionDetail = new ExceptionDetail(ex.getClass().getSimpleName(), ex.getMessage());
        return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);
    }
}
