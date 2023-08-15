public class ComplexNumber {
    /**********************************
     *            Attribute           *
     **********************************/
    private double realPart;
    private double imagePart;

    /*********************************
     *            Constructor        *
     *********************************/
    public ComplexNumber(double realPart, double imagePart) {
        this.realPart = realPart;
        this.imagePart = imagePart;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImagePart() {
        return imagePart;
    }

    public void setImagePart(double imagePart) {
        this.imagePart = imagePart;
    }

    /*********************************
     *       showComplexNumber       *
     *********************************/
    public void showComplexNumber() {
        System.out.println(String.format("%.2f",realPart) + " + " + String.format("%.2f",imagePart) + "i");
        System.out.println("----------------------------------------------------------------------------");
    }
}
