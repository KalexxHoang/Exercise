package Model;

public class Book extends Document{
    /**********************************
     *            Attribute           *
     **********************************/
    private String author;
    private int pageNumber;

    /*********************************
     *            Constructor        *
     *********************************/
    public Book(String docID, String publishingCompany, int releaseNumber, String type, String author, int pageNumber) {
        super(docID, publishingCompany, releaseNumber, type);
        this.author = author;
        this.pageNumber = pageNumber;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    /*********************************
     *          Show Infor           *
     *********************************/
    public void showInfor() {
        super.showInfor();
        System.out.println("Author: " + author);
        System.out.println("Number of Page: " + pageNumber);
        System.out.println("---------------------------------------");
    }
}
