package model;

public enum Membership {
    GOLD(50, 5),
    SILVER(30, 3),
    STRIVER(10, 2);

    private final int dailyFee;
    private final int maxBooks;

    Membership(int dailyFee, int maxBooks) {
        this.dailyFee = dailyFee;
        this.maxBooks = maxBooks;
    }

    public int getDailyFee() {
        return dailyFee;
    }

    public int getMaxBooks() {
        return maxBooks;
    }
}
