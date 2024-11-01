package services;

import model.Book;
import model.BorrowedBook;
import model.User;
import model.Membership; // Make sure to import the Membership enum

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BorrowingService {
    private List<BorrowedBook> borrowedBooks = new ArrayList<>();

    public void borrowBook(User user, Book book) {
        if (user.getBorrowedBooks() < getMaxBooks(user)) {
            BorrowedBook borrowedBook = new BorrowedBook(book, user, LocalDate.now());
            borrowedBooks.add(borrowedBook);
            user.incrementBorrowedBooks();
        } else {
            System.out.println("You cannot borrow more books than your membership allows.");
        }
    }

    private int getMaxBooks(User user) {
        // Use Membership enum for comparisons
        Membership membership = user.getMembership();
        switch (membership) {
            case GOLD:
                return 5;
            case SILVER:
                return 3;
            case STRIVER:
                return 2;
            default:
                return 0;
        }
    }

    public void returnBook(BorrowedBook borrowedBook, LocalDate returnDate) {
        borrowedBook.returnBook(returnDate);
    }
}
