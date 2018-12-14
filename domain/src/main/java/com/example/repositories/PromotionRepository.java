package com.example.repositories;

import com.example.domain.Book;
import com.example.domain.Promotion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends CrudRepository<Promotion,Long> {

    List<Promotion> findByBook(Book book);

}
