package org.example.book.service;

import org.example.book.entity.Book;
import org.example.book.entity.BorrowingCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBorrowingService {
    String generateBorrowCode();
    boolean addBorrow(BorrowingCard borrowingCard);
    Page<BorrowingCard> findAll(String name, Pageable pageable);
    void returnBook(String code);
    BorrowingCard findByCode(String code);
}
