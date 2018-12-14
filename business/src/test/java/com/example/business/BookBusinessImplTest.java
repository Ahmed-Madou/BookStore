package com.example.business;

import com.example.business.implementation.BookBusinessImpl;
import com.example.domain.Book;
import com.example.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookBusinessImplTest {

    @Autowired
    private BookBusinessImpl bookBusiness;


    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    User user = new User("Ahmed","Dghaies",sdf.parse("20/01/1998"),500,"Male");
    Book book = new Book("Book1","Author1",2002,250,15);

    public BookBusinessImplTest() throws ParseException {
    }

    @Before
    public void setUp() throws Exception {
        bookBusiness.buyBook(user,book);
    }

    @Test
    public void contextLoads() {
        assertEquals("User budget was not correct",250,user.getBudget(),0);
        assertEquals("Book Quantity was not correct ", 14,book.getQuantity(),0);
    }

    @After
    public void tearDown() throws Exception {
    }
}