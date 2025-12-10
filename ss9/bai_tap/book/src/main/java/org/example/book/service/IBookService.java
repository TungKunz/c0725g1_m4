package org.example.book.service;

import org.example.book.dto.BookDTO;
import org.example.book.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    boolean addBook(Book book);
    boolean updateBook(String name, Book book);
    Page<Book> findAll(String name, Pageable pageable);
    Book findById(int id);

}
