package com.example.book.book;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

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

    // adds new book into db
    public String addBook(Book book){
        Optional<Book> optionalBook = bookRepository.findBookBybookName(book.getBookName());
        if(optionalBook.isPresent()){
           throw new IllegalStateException("Book Already Present with name: "+book.getBookName());
        }
        bookRepository.save(book);
        return "Book with name: "+book.getBookName()+" added";
    }

    // returns given id book from DB
    public Optional<Book> getBookById(Long bookId){
        boolean exists = bookRepository.existsById(bookId);
        if(!exists){
            throw new IllegalStateException("Book with id: "+bookId+" does not exists");
        }
        return bookRepository.findById(bookId);
    }

    // deletes a book from db
    public String deleteBook(Long bookId){
        boolean exists = bookRepository.existsById(bookId);
        if(!exists){
            throw new IllegalStateException("Book with id: "+bookId+" does not exists");
        }
        bookRepository.deleteById(bookId);
        return "Book with bookId:"+ bookId + " successfully deleted";
    }

    // updates a book with id from db
    @Transactional
    public String editBook(Long bookId, String bookName, String author, String publication, LocalDate dop){
        boolean exists = bookRepository.existsById(bookId);
        if(!exists){
            throw new IllegalStateException("Book with Id: "+bookId+" does not exist");
        }

        Book book = bookRepository.getReferenceById(bookId);
        if(bookName != null && bookName.length()>0){
            book.setBookName(bookName);
        }

        if(author != null && author.length()>0 && !author.equals(book.getAuthor())){
            book.setAuthor(author);
        }

        if(publication != null && publication.length()>0 && !publication.equals(book.getPublication())){
            book.setPublication(publication);
        }

        if(dop != null && !dop.equals(book.getPublishDate())){
            book.setPublishDate(dop);
        }
        return "Book with "+bookId +" updated";
    }
}
