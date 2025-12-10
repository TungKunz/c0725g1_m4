package org.example.book.repository;

import org.example.book.entity.BorrowingCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBorrowingCard extends JpaRepository<BorrowingCard,Integer> {
    Page<BorrowingCard> findByCodeContaining(String code, Pageable pageable);
    @Modifying
    @Query(value = "DELETE FROM borrowing_card WHERE code = :borrowCode", nativeQuery = true)
    void deleteByBorrowingCode(@Param("borrowCode") String code);
    BorrowingCard findByCode(String code);
}
