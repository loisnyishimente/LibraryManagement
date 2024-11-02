package model;

import java.time.LocalDate;

public class BorrowedBook {
    private Book book;
    private User user;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private int fine;

    public BorrowedBook(Book book, User user, LocalDate borrowDate) {
        this.book = book;
        this.user = user;
        this.borrowDate = borrowDate;
        this.returnDate = null;
        this.fine = 0;
    }



    public int getFine() {
        return fine;
    }
}
