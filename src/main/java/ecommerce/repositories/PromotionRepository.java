package ecommerce.repositories;

import ecommerce.models.Book;
import ecommerce.models.Promotion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends CrudRepository<Promotion,Long> {

    List<Promotion> findByBook(Book book);

}
