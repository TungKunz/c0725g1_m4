package org.example.book.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.book.entity.BorrowingCard;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String title;
    private String author;
    private int quantity;
    @OneToMany(mappedBy = "book")
    private List<BorrowingCard> borrowingCardList;
}
