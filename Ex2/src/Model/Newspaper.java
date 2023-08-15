package Model;

public class Newspaper extends Document{
    /**********************************
     *            Attribute           *
     **********************************/
    private int releaseDay;

    /*********************************
     *            Constructor        *
     *********************************/
    public Newspaper(String docID, String publishingCompany, int releaseNumber, String type, int releaseDay) {
        super(docID, publishingCompany, releaseNumber, type);
        this.releaseDay = releaseDay;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public int getReleaseDay() {
        return releaseDay;
    }

    public void setReleaseDay(int releaseDay) {
        this.releaseDay = releaseDay;
    }

    /*********************************
     *          Show Infor           *
     *********************************/
    @Override
    public void showInfor() {
        super.showInfor();
        System.out.println("Release Day: " + releaseDay);
        System.out.println("---------------------------------------");
    }
}
