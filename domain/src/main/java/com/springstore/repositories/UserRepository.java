package com.springstore.repositories;

import com.springstore.models.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    List<User> findByLastName(String lastName);

    List<User> findByFirstName(String firstName);

}
