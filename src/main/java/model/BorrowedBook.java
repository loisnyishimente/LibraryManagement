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

    public void returnBook(LocalDate returnDate) {
        this.returnDate = returnDate;
        calculateFine();
    }

    private void calculateFine() {
        if (returnDate != null && returnDate.isAfter(borrowDate.plusDays(7))) { // Assuming 7 days borrowing period
            long daysLate = returnDate.toEpochDay() - borrowDate.plusDays(7).toEpochDay();
            switch (user.getMembership()) {
                case GOLD:
                    fine = (int) daysLate * 50;
                    break;
                case SILVER:
                    fine = (int) daysLate * 30;
                    break;
                case STRIVER:
                    fine = (int) daysLate * 10;
                    break;
                default:
                    fine = 0;
            }
        }
    }

    public int getFine() {
        return fine;
    }
}
