package com.springstore.repositories;

import com.springstore.models.*;
import com.springstore.repositories.PromotionRepository;
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
public class PromotionRepositoryTest {

    @Autowired
    private PromotionRepository promotionRepository;

    Book firstBook = new Book("Book1","Author1",2015,215,4);
    Book secondBook = new Book("Book2","Author2",2015,215,61);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Promotion firstPromotion = new Promotion(0.5,sdf.parse("20/01/1996"),sdf.parse("20/01/1996"),firstBook);
    Promotion secondPromotion = new Promotion(0.5,sdf.parse("20/01/1996"),sdf.parse("20/01/1996"),secondBook);

    public PromotionRepositoryTest() throws ParseException {
    }

    @Before
    public void setUp() throws Exception {
        promotionRepository.save(firstPromotion);
        promotionRepository.save(secondPromotion);
    }

    @Test
    public void contextLoads(){
        assertThat(promotionRepository.findByBook(firstBook),is(notNullValue()));
    }

    @After
    public void tearDown() throws Exception {
        promotionRepository.deleteAll();
    }
}