package ecommerce.buisiness.interfaces;

import ecommerce.models.Book;
import ecommerce.models.User;

public interface BookBusiness  {

    public String buyBook(User buyer, Book book);

}
