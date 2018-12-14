package com.example;

import com.example.domain.Book;
import com.example.repositories.BookRepository;
import com.example.repositories.UserRepository;
import com.example.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.text.SimpleDateFormat;

@SpringBootApplication
@EntityScan("com.example.domain")
@EnableJpaRepositories("com.example.repositories")
@ComponentScan(basePackages = "com")
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository, BookRepository bookRepository) {
        return args -> {
            // save a couple of customers
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            repository.save(new User("Jack", "Bauer",sdf.parse("20/01/1996") ,200,"Male"));
            repository.save(new User("Chloe", "O'Brian",sdf.parse("24/07/1996") ,300,"Female"));
            repository.save(new User("Kim", "Bauers",sdf.parse("12/01/2000") ,120,"Male"));
            repository.save(new User("David", "Palmer",sdf.parse("20/01/1998") ,300,"Female"));
            repository.save(new User("Michelle", "Dessler",sdf.parse("20/01/1996") ,100,"Male"));


            Book firstBook = new Book("Book1","Author1",2002,256,15);
            Book secondBook = new Book("Book2","Author2",2002,256,12);

            bookRepository.save(firstBook);
            bookRepository.save(secondBook);

            //fetch all Books
            log.info("Books found with findAll():");
            log.info("-------------------------------");
            for (Book book : bookRepository.findAll()) {
                log.info(book.toString());
            }
            log.info("");
            // fetch all customers
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (User user : repository.findAll()) {
                log.info(user.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            repository.findById(1L)
                    .ifPresent(user -> {
                        log.info("Users found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(user.toString());
                        log.info("");
                    });

            // fetch customers by last name
            log.info("Users found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> log.info(bauer.toString()));

            // fetch customers by first name
            log.info("Users found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByFirstName("Jack").forEach(bauer -> log.info(bauer.toString()));

            log.info("");
        };
    }
}
