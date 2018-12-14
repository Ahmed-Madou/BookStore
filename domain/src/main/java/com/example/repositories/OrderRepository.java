package com.example.repositories;

import com.example.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {

    List<Order> findByOwnerId(Long ownerId);
}
