package com.example.book.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    // public List<Book> getBookById(Long bookId){
    //     boolean exists = bookRepository.existsById(bookId);
    //     if(!exists){
    //         throw new IllegalStateException("Book with id: "+bookId+" does not exists");
    //     }
    //     return bookRepository.findBookById(bookId);
    // }

    public String addBook(Book book){
        Optional<Book> optionalBook = bookRepository.findBookBybookName(book.getBookName());
        if(optionalBook.isPresent()){
           return "Book Already Present with name: "+book.getBookName();
        }
        bookRepository.save(book);
        return "Book with name: "+book.getBookName()+" added";
    }

    public String deleteBook(Long bookId){
        boolean exists = bookRepository.existsById(bookId);
        if(!exists){
            throw new IllegalStateException("Book with id: "+bookId+" does not exists");
        }
        bookRepository.deleteById(bookId);
        return "Book successfully deleted";
    }
}
