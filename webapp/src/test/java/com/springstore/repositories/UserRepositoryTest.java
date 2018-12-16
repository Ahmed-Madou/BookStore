package com.springstore.repositories;

import com.springstore.models.*;
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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    User firstUser, secondUser;

    @Before
    public void setUp() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        firstUser = new User("Ahmed","Dghaies",sdf.parse("20/01/1996"),500,"Male");
        secondUser = new User("Mouhamed Amine","Samet",sdf.parse("20/01/1996"),500,"Male");

        userRepository.save(firstUser);
        userRepository.save(secondUser);
    }

    @Test
    public void contextLoads() {
        assertThat(userRepository.findByFirstName("Ahmed"), is(notNullValue()));
        assertThat(userRepository.findByLastName("Samet"), is(notNullValue()));
    }

    @After
    public void shutdown() {
        userRepository.deleteAll();
    }

}