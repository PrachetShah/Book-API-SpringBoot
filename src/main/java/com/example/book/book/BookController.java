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

    @GetMapping
    public List<Book> getAll(){
        return bookService.getBooks();
    }

    // @GetMapping(path="get/{bookID}")
    // public List<Book> getSingle(@PathVariable("bookId") Long bookId){
    //     System.out.println(bookId);
    //     List<Book> res =  bookService.getBookById(bookId);
    //     return res;
    // }

    @PostMapping
    public String add(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping(path="{bookId}")
    public String delete(@PathVariable("bookId") Long bookId){
        String result = bookService.deleteBook(bookId);
        return result;  
    }
}
