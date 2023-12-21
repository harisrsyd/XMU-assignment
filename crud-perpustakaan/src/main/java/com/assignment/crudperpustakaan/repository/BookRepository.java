package com.assignment.crudperpustakaan.repository;

import com.assignment.crudperpustakaan.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select * from books where (title ilike %:cari% or author ilike %:cari% or publisher ilike %:cari%) order by id", nativeQuery = true)
    Page<Book> searchPage(Pageable pageable, String cari);
}
