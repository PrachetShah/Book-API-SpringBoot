package com.example.book.book;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
        /*
     * To find the conevention of writing it see online, it follows
     * "findAllBy---" or "findBy---" based on what to get
     * with --- replaced with "NAME OF VARIABLE in Table in DB"
     */
    Optional<Book> findBookBybookName(String bookName);
}
