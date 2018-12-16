package com.springstore.repositories;


import com.springstore.models.*;
import com.springstore.repositories.OrderRepository;
import com.springstore.repositories.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    User user = new User("Ahmed","Dghaies",sdf.parse("20/01/1998"),500,"Male");
    Book firstBook = new Book("Book1","Author1",2002,256,15);
    Book secondBook = new Book("Book2","Author2",2002,256,12);
    Order order = new Order(user.getId(),120);
    List<Book> books = new ArrayList<Book>();



    public OrderRepositoryTest() throws ParseException {
    }

    @Before
    public void setUp() throws Exception {
        books.add(firstBook);
        books.add(secondBook);
        order.setOrderBooks(books);
        orderRepository.save(order);
        user = userRepository.save(user);
    }

    @Test
    public void contectLoads() {
        assertThat(orderRepository.findByOwnerId(user.getId()), is(notNullValue()));
    }

    @After
    public void tearDown() throws Exception {
        orderRepository.deleteAll();
        userRepository.deleteAll();
    }
}