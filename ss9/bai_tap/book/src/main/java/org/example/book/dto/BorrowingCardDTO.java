package org.example.book.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.book.entity.Book;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingCardDTO {
    private String code;
    private Book book;
}
