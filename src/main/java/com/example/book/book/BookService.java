package com.example.book.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    // dependency injection
    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    // returns all books from db
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    // returns given id book from DB
    public Optional<Book> getBookById(Long bookId){
        boolean exists = bookRepository.existsById(bookId);
        if(!exists){
            throw new IllegalStateException("Book with id: "+bookId+" does not exists");
        }
        return bookRepository.findById(bookId);
    }

    // adds new book into db
    public String addBook(Book book){
        Optional<Book> optionalBook = bookRepository.findBookBybookName(book.getBookName());
        if(optionalBook.isPresent()){
           return "Book Already Present with name: "+book.getBookName();
        }
        bookRepository.save(book);
        return "Book with name: "+book.getBookName()+" added";
    }

    // deletes a book from db
    public String deleteBook(Long bookId){
        boolean exists = bookRepository.existsById(bookId);
        if(!exists){
            throw new IllegalStateException("Book with id: "+bookId+" does not exists");
        }
        bookRepository.deleteById(bookId);
        return "Book successfully deleted";
    }
}
