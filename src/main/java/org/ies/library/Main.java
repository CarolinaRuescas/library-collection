package org.ies.library;

import org.ies.library.model.BookLend;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        var book = new BookLend(
                "32563",
                LocalDate.now(),
                "4563225K"
        );
        System.out.println(book);
    }
}