package com.springstore.repositories;

import com.springstore.models.*;
import com.springstore.repositories.BookRepository;
import com.springstore.repositories.CartRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private BookRepository bookRepository;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    User firstUser = new User("Ahmed","Dghaies",sdf.parse("20/01/1998"),500,"Male");
    Book book = new Book("Book1","Author1",2005,201,21);

    public CartRepositoryTest() throws ParseException {
    }

    @Before
    public void setUp() throws Exception {
        bookRepository.save(book);
        Cart cart = new Cart(firstUser,0);
        cartRepository.save(cart);
    }

    @Test
    public void contextLoads() {
        assertThat(cartRepository.findByUser(firstUser), is(notNullValue()));
    }

    @After
    public void tearDown() throws Exception {
        cartRepository.deleteAll();
        bookRepository.deleteAll();
    }
}