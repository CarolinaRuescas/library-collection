package org.ies.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.w3c.dom.ls.LSException;

import java.time.LocalDate;
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

    // Dado un nif y un ISBN, crea un préstamo para un socio.
    // Crea un BookLend con la fecha actual.

    public void addBookLend(String nif, String isbn){
        bookLends.add(
                new BookLend(isbn, LocalDate.now(),nif)
        );
    }

    // Dado un ISBN y un genero, elimina el genero del libro
    // containsKey
    // get
    // remove

    public boolean removeGenre (String isbn, String genre){
        if(booksByIsbn.containsKey(isbn)){
            Book book = booksByIsbn.get(isbn);
            return book.getGenres().remove(genre);
        }else{
            return false;
        }
    }

    // Dado un ISBN y un número de socio (no NIF), devuelve si el socio ha tomado
    // prestado el libro o no (boolean).
    // Foreach

    public boolean customerHasLentBook (int customerNumber, String isbn){
        var customer = findCustomer(customerNumber);
        if (customer != null){
            for (var bookLend : bookLends){
                if (bookLend.getNif().equals(customer.getNif()) &&
                        bookLend.getIsbn().equals(isbn)){
                    return true;
                }
            }
        }
        return false;
    }

    //Metodo de apoyo para buscar un cliente con el numero

    public Customer findCustomer(int customerNumber){
        for(var customer : customers){
            if(customer.getCustomerNumber()== customerNumber){
                return customer;
            }
        }
        return null;
    }


    // Dado un ISBN, devuelve los generos del libro. Si no existe el libro, devuleve null.
    public Set<String> getBookGenres(String isbn){
        if (booksByIsbn.containsKey(isbn)){
            var book = booksByIsbn.get(isbn);
            return book.getGenres();
        }
        return null;
    }

    // Dado un ISBN, devuelve todos los préstamos de ese libro. Si no existe el libro,
    // devuelve null.
    public List<BookLend> getBookLendsByIsbn(String isbn){
        if (booksByIsbn.containsKey(isbn)){
            List<BookLend> lends = new ArrayList<>();
            for (var bookLend: bookLends){
                if(bookLend.getIsbn().equals(isbn)){
                    lends.add(bookLend);
                }
            }
            return lends;
        }else{
            return null;
        }
    }
}


