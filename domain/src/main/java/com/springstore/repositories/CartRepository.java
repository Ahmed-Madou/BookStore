package com.springstore.repositories;

import com.springstore.models.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {

    List<Cart> findByUser(User user);

}
