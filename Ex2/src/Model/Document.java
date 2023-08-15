package Model;

public class Document {
    /**********************************
     *            Attribute           *
     **********************************/
    // ID is the only one
    private String docID;
    private String publishingCompany;
    private int releaseNumber;
    private String type;

    /*********************************
     *            Constructor        *
     *********************************/
    public Document(String docID) {
        this.docID = docID;
    }

    public Document(String docID, String publishingCompany, int releaseNumber, String type) {
        this.docID = docID;
        this.publishingCompany = publishingCompany;
        this.releaseNumber = releaseNumber;
        this.type = type;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public String getDocID() {
        return docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public int getReleaseNumber() {
        return releaseNumber;
    }

    public void setReleaseNumber(int releaseNumber) {
        this.releaseNumber = releaseNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /*********************************
     *          equals               *
     *********************************/
    @Override
    public boolean equals(Object obj) {
        return this.docID.equals(((Document) obj).getDocID());
    }

    /*********************************
     *          hashCode             *
     *********************************/
    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + docID.hashCode();

        return result;
    }

    /*********************************
     *          Show Infor           *
     *********************************/
    public void showInfor() {
        System.out.println("ID: " + docID);
        System.out.println("Publishing Company: " + publishingCompany);
        System.out.println("Release Number: " + releaseNumber);
        System.out.println("Type: " + type);
    }
}
