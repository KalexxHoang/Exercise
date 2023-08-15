package Model;

public class Magazine extends Document{
    /**********************************
     *            Attribute           *
     **********************************/
    private int issueNumber;
    private int releaseMonth;

    /*********************************
     *            Constructor        *
     *********************************/
    public Magazine(String docID, String publishingCompany, int releaseNumber, String type, int issueNumber, int releaseMonth) {
        super(docID, publishingCompany, releaseNumber, type);
        this.issueNumber = issueNumber;
        this.releaseMonth = releaseMonth;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public int getReleaseMonth() {
        return releaseMonth;
    }

    public void setReleaseMonth(int releaseMonth) {
        this.releaseMonth = releaseMonth;
    }

    /*********************************
     *          Show Infor           *
     *********************************/
    @Override
    public void showInfor() {
        super.showInfor();
        System.out.println("Issue Number: " + issueNumber);
        System.out.println("Release Month: " + releaseMonth);
        System.out.println("---------------------------------------");
    }
}
