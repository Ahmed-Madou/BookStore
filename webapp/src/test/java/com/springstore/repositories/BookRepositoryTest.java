package com.springstore.repositories;

import com.springstore.models.*;
import com.springstore.repositories.BookRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    Book firstBook = new Book("Book1","Author1",2002,256,15);
    Book secondBook = new Book("Book2","Author2",2002,256,12);

    @Before
    public void setUp() throws Exception {
        bookRepository.save(firstBook);
        bookRepository.save(secondBook);
    }

    @Test
    public void contextLoads(){
        assertThat(bookRepository.findByAuthor("Author1"), is(notNullValue()));
        assertThat(bookRepository.findByName("Book1"),is(notNullValue()));
    }

    @After
    public void tearDown() throws Exception {
        bookRepository.deleteAll();
    }
}