package org.example.book.service;

import jakarta.transaction.Transactional;
import org.example.book.entity.Book;
import org.example.book.entity.BorrowingCard;
import org.example.book.repository.IBorrowingCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BorrowingCardService implements IBorrowingService{
    @Autowired
    private IBorrowingCard borrowingCardRepository;
    @Autowired
    private IBookService bookService;
    @Override
    public String generateBorrowCode() {
        Random random = new Random();
        int codeRandom= random.nextInt(10000);
        return String.format("%05d",codeRandom);
    }

    @Override
    public boolean addBorrow(BorrowingCard borrowingCard) {
        return borrowingCardRepository.save(borrowingCard)!=null;
    }

    @Override
    public Page<BorrowingCard> findAll(String name, Pageable pageable) {
        return borrowingCardRepository.findByCodeContaining(name,pageable);
    }

    // Trong BorrowingCardService.java

    @Override
    @Transactional
    public void returnBook(String borrowingCode) {

        BorrowingCard card = borrowingCardRepository.findByCode(borrowingCode);

        if (card == null) {

            throw new RuntimeException("Không tìm thấy thẻ mượn với mã: " + borrowingCode);
        }

        Book bookToReturn = bookService.findById(card.getBook().getId());

        if (bookToReturn == null) {
            throw new RuntimeException("Lỗi dữ liệu: Không tìm thấy sách liên kết.");
        }

        borrowingCardRepository.deleteByBorrowingCode(borrowingCode);
        try {
            bookService.updateBook("returnBook", bookToReturn);
        } catch (Exception e) {
            throw new RuntimeException("Cập nhật số lượng sách thất bại: " + e.getMessage(), e);
        }

    }

    @Override
    public BorrowingCard findByCode(String code) {
        return borrowingCardRepository.findByCode(code);
    }
}
