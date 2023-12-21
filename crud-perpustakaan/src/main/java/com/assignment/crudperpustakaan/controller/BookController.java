package com.assignment.crudperpustakaan.controller;

import com.assignment.crudperpustakaan.entity.Book;
import com.assignment.crudperpustakaan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable("id") Long id) {
        return bookService.getOne(id);
    }

    @PutMapping("/{id}")
    public Book update(@RequestBody Book book, @PathVariable("id") Long id) {
        return bookService.update(id, book);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id) {
        bookService.delete(id);
    }

    @GetMapping("/search")
    public Page<Book> search(@RequestParam(value = "page", defaultValue = "0") int page,
                             @RequestParam(value = "size", defaultValue = "3") int size,
                             @RequestParam(value = "search", defaultValue = "") String search) {
        Pageable pageable = PageRequest.of(page, size);
        return bookService.search(pageable, search);
    }
}
