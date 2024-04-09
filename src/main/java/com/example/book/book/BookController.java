package com.example.book.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    // get all books
    @GetMapping()
    public List<Book> getbook(Long bookId){
        return bookService.getBooks();
    }

    // post a new book if it does not exist
    @PostMapping
    public String addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    // get a single book from id if it exists
    @GetMapping(path="{bookId}")
    public Optional<Book> getSingle(@PathVariable("bookId") Long bookId){
        System.out.println(bookId);
        Optional<Book> res =  bookService.getBookById(bookId);
        return res;
    }

    // delete a book if it exists
    @DeleteMapping(path="{bookId}")
    public String deleteBook(@PathVariable("bookId") Long bookId){
        String result = bookService.deleteBook(bookId);
        return result;  
    }
}
