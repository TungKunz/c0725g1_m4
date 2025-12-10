package org.example.book.repository;

import org.example.book.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book,Integer> {
    Page<Book> findByTitleContaining(String title, Pageable pageable);
    @Query(value = "select * from book where name like :searchName",nativeQuery = true)
    List<Book> searchName(@Param("searchName") String name);
}
