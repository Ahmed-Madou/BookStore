package com.example.repositories;

import com.example.domain.Cart;
import com.example.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {

    List<Cart> findByUser (User user);

}
