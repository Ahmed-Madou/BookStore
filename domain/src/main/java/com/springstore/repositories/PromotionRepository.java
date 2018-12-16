package com.springstore.repositories;

import com.springstore.models.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends CrudRepository<Promotion,Long> {

    List<Promotion> findByBook(Book book);

}
