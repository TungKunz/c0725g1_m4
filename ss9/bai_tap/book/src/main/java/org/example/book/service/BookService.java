package org.example.book.service;

import org.example.book.entity.Book;
import org.example.book.exception.NoBooksAvailableError;
import org.example.book.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;
    @Override
    public boolean addBook(Book book) {
        return bookRepository.save(book)!=null;
    }

    @Override
    public boolean updateBook(String actionName, Book book) throws NoBooksAvailableError {

        if ("borrow".equals(actionName)) {
            if (book.getQuantity() >= 1) {
                book.setQuantity(book.getQuantity() - 1);
                return bookRepository.save(book) != null;
            } else {
                throw new NoBooksAvailableError("Sách đã hết, không thể mượn.");
            }

        } else if ("returnBook".equals(actionName)) {
            book.setQuantity(book.getQuantity() + 1);
            return bookRepository.save(book) != null;

        } else {
            throw new IllegalArgumentException("Thao tác không hợp lệ: " + actionName);
        }
    }

    @Override
    public Page<Book> findAll(String name, Pageable pageable) {
        return bookRepository.findByTitleContaining(name,pageable);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }
}
