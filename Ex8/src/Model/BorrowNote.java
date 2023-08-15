package Model;

public class BorrowNote {
    /**********************************
     *            Attribute           *
     **********************************/
    private String borrowCode;
    private int borrowDay;
    private int deadLine;
    private String bookID;

    /*********************************
     *            Constructor        *
     *********************************/
    public BorrowNote(String borrowCode) {
        this.borrowCode = borrowCode;
    }

    public BorrowNote(String borrowCode, int borrowDay, int deadLine, String bookID) {
        this.borrowCode = borrowCode;
        this.borrowDay = borrowDay;
        this.deadLine = deadLine;
        this.bookID = bookID;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public String getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(String borrowCode) {
        this.borrowCode = borrowCode;
    }

    public int getBorrowDay() {
        return borrowDay;
    }

    public void setBorrowDay(int borrowDay) {
        this.borrowDay = borrowDay;
    }

    public int getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(int deadLine) {
        this.deadLine = deadLine;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    /*********************************
     *          equals               *
     *********************************/
    @Override
    public boolean equals(Object obj) {
        return this.borrowCode.equals(((BorrowNote) obj).getBorrowCode());
    }

    /*********************************
     *          hashCode             *
     *********************************/
    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + borrowCode.hashCode();

        return result;
    }

    /*********************************
     *          showInfor            *
     *********************************/
    public void showInfor() {
        System.out.println("\tBorrow code: " + borrowCode);
        System.out.println("\tBorrow day: " + borrowDay);
        System.out.println("\tDeadline: " + deadLine);
        System.out.println("\tBook ID: " + bookID);
        System.out.println("--------------------------------");
    }
}
