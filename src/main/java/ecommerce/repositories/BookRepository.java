package ecommerce.repositories;

import ecommerce.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {

    List<Book> findByAuthor( String author);

    List<Book> findByName (String name);

 }
