package com.example.business.implementation;

import com.example.business.interfaces.BookBusiness;
import com.example.domain.*;
import com.example.repositories.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookBusinessImpl implements BookBusiness {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public synchronized String buyBook(User buyer, Book book) {
        if (book.getQuantity()>0 && buyer.getBudget()>book.getPrice()) {
            book.setQuantity(book.getQuantity()-1);
            buyer.setBudget(buyer.getBudget () - book.getPrice());
            return "it has been a pleasure working with you, check for other books if you want." +
                    "You'll never know what you're missing.";
        }
        if (book.getQuantity()==0)
            return "We are soory but this book is no longer available";
        else if (buyer.getBudget()>book.getPrice())
            return "Your budget is not enough to buy this Book:" + book.getName();
        else return "Try again :( something went wrong";
    }
}
