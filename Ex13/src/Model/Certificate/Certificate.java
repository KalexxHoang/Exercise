package Model.Certificate;

public class Certificate {
    /**********************************
     *            Attribute           *
     **********************************/
    private String certificateID;
    private String certificateName;
    private String certificateRank;
    private String certificatedDate;

    /*********************************
     *            Constructor        *
     *********************************/
    public Certificate(String certificateID) {
        this.certificateID = certificateID;
    }

    public Certificate(String certificateID, String certificateName, String certificateRank, String certificatedDate) {
        this.certificateID = certificateID;
        this.certificateName = certificateName;
        this.certificateRank = certificateRank;
        this.certificatedDate = certificatedDate;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public String getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(String certificateID) {
        this.certificateID = certificateID;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateRank() {
        return certificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        this.certificateRank = certificateRank;
    }

    public String getCertificatedDate() {
        return certificatedDate;
    }

    public void setCertificatedDate(String certificatedDate) {
        this.certificatedDate = certificatedDate;
    }

    /*********************************
     *        showCertificate        *
     *********************************/
    public void showCertificate() {
        System.out.println("Certificate ID: " + certificateID);
        System.out.println("Certificate name: " + certificateName);
        System.out.println("Certificate rank: " + certificateRank);
        System.out.println("Certificate date: " + certificatedDate);
        System.out.println();
    }

    /*********************************
     *          equals               *
     *********************************/
    @Override
    public boolean equals(Object obj) {
        return this.certificateID.equals(((Certificate) obj).getCertificateID());
    }

    /*********************************
     *          hashCode             *
     *********************************/
    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + certificateID.hashCode();

        return result;
    }
}
