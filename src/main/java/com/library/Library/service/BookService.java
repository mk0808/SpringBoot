package com.library.Library.service;

import com.library.Library.domain.Author;
import com.library.Library.domain.Book;
import com.library.Library.repository.AuthorRepository;
import com.library.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public List<Book> getBooks(){
        return new ArrayList<>(bookRepository.getBooks());
    }

    public void saveBook(Book book){
        if(book != null) {
            if(bookRepository.getBook(book.getId()) != null){
                authorRepository.updateAuthor(book.getAuthor());
                bookRepository.updateBook(book);
            }
            else{
                authorRepository.saveAuthor(book.getAuthor());
                bookRepository.saveBook(book);
            }
        }
    }

    public void deleteBook(int id){
        Author authorToRemove = bookRepository.getBook(id).getAuthor();
        bookRepository.deleteBook(bookRepository.getBook(id));
        authorRepository.deleteAuthor(authorToRemove);
    }

    public Book getNewBook(){
        Book newBook = new Book();
        newBook.setAuthor(new Author());
        return new Book();
    }

    public Book getBook(int id){
        return bookRepository.getBook(id);
    }
}
