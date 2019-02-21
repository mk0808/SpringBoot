package com.library.Library.service;

import com.library.Library.domain.Author;
import com.library.Library.domain.Book;
import com.library.Library.modelDTO.AuthorDTO;
import com.library.Library.modelDTO.BookDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    @Autowired
    BookService bookService;

    @Autowired
    ModelMapper modelMapper;


    public AuthorDTO convertAuthorToDTO(Author author){
        AuthorDTO authorDTO = modelMapper.map(author, AuthorDTO.class);
        return authorDTO;
    }

    public Author convertAuthorToEntity(AuthorDTO authorDTO){
        Author author = modelMapper.map(authorDTO, Author.class);
        return author;
    }

    public BookDTO convertBookToDTO(Book book){
        BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
        return bookDTO;
    }

    public Book convertBookToEntity(BookDTO bookDTO){
        Book book = modelMapper.map(bookDTO, Book.class);
        return book;
    }

}
