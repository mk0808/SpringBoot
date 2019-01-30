package com.library.Library.repository;

import com.library.Library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class BookRepository{
    @PersistenceContext
    private EntityManager em;

    public Collection<Book> getBooks(){
        return em.createQuery("from Book", Book.class).getResultList();
    }
    public Book getBook(int id){
        return em.find(Book.class, id);
    }

    @Transactional
    public void saveBook(Book book){
        if(book != null) em.persist(book);
    }

    @Transactional
    public void updateBook(Book book){
        if(book != null) em.merge(book);
    }

    @Transactional
    public void deleteBook(Book book){
        if(book != null) em.remove(book);
    }

}
