package com.assignment.crudperpustakaan.service;

import com.assignment.crudperpustakaan.entity.Book;
import com.assignment.crudperpustakaan.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepo;

    public Book save(Book book) {
        return bookRepo.save(book);
    }

    public Book getOne(Long id) {
        return bookRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
    }

    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    public Book update(Long id, Book book) {
        Book registeredBook = bookRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        registeredBook.setTitle(book.getTitle());
        registeredBook.setPublishYear(book.getPublishYear());
        registeredBook.setPublisher(book.getPublisher());
        registeredBook.setAuthor(book.getAuthor());
        registeredBook.setIsbn(book.getIsbn());
        registeredBook.setLanguage(book.getLanguage());
        registeredBook.setNotes(book.getNotes());
        return bookRepo.save(registeredBook);
    }

    public void delete(Long id) {
        Book book = bookRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        bookRepo.delete(book);
    }

    public Page<Book> search(Pageable pageable, String search) {
        return bookRepo.searchPage(pageable, search);
    }
}
