package org.ies.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.w3c.dom.ls.LSException;

import java.util.*;

@Data
 @AllArgsConstructor

public class Library {
    private String name;
    private Map<String, Book> booksByIsbn;
    private List<Customer> customers;
    private TreeSet<BookLend> bookLends;

    // //Dado un género, devuelve todos los libros que tengan ese género (List<Book>).
    public List<Book> listGenreBooks (String genres){
        List<Book> genreBooks = new ArrayList<>();
        for (Book book : booksByIsbn.values()){
            if(book.getGenres().contains(genres)){
                genreBooks.add(book);
            }
        }
        return genreBooks;
    }

    // Dado un código postal, devuelve los socios que viven ahí (List<Customer>)
    public List<Customer> customersByZipCode (int zipCode){
        List<Customer> listCustomer = new ArrayList<>();
        for (Customer customer : customers){
            if (customer.getZipCode() == (zipCode)){
                listCustomer.add(customer);
            }
        }
        return listCustomer;
    }

    // Dado un nif y un ISBN, crea un préstamo para un socio. Crea un BookLend con la fecha actual.
    //1º metodo para encontrar un libro por ISBN





}


