package com.example.book.book;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// uncomment this for new DB
@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository){
        return args->{
            Book book1 = new Book(
				"Da Vinci Code",
				"Da Vinci Duh",
                "Penguin Club",
				LocalDate.of(2002, 1, 26)
			);

            Book book2 = new Book(
                "Merchant of Venice",
				"Merchant",
                "Italy Journal",
				LocalDate.of(2002, 1, 22)
			);

            repository.saveAll(List.of(book1, book2));
        };
    }
}
