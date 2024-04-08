package com.example.book.book;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    Optional<Book> findBookBybookName(String bookName);
    List<Book> findBookById(Long id);
}
