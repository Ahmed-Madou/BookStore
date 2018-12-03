package ecommerce.repositories;

import ecommerce.models.Cart;
import ecommerce.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {

    List<Cart> findByUser (User user);

}
