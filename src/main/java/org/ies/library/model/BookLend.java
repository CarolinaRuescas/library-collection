package org.ies.library.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor

public class BookLend implements  Comparable<BookLend>{
    private String isbn;
    private LocalDate date;
    private String nif;

    @Override
    public int compareTo(BookLend bookLend) {
        int compare = this.date.compareTo(bookLend.date);
        if(compare == 0){
            compare = this.isbn.compareTo(bookLend.isbn);
            if(compare == 0){
                compare = this.nif.compareTo(bookLend.nif);
            }
        }
        return compare;

    }
}
