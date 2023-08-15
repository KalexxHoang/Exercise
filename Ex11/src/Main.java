import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Complex number 1:");
        ComplexNumber complexNumber1 = createComplexNumber();
        complexNumber1.showComplexNumber();

        System.out.println("Complex number 2:");
        ComplexNumber complexNumber2 = createComplexNumber();
        complexNumber2.showComplexNumber();

        ComplexNumber complexNumber3 = addComplexNumber(complexNumber1,complexNumber2);
        System.out.print("ComplexNumber3 = ComplexNumber1 + ComplexNumber2 = ");
        complexNumber3.showComplexNumber();

        ComplexNumber complexNumber4 = multipleComplexNumber(complexNumber1,complexNumber2);
        System.out.print("ComplexNumber4 = ComplexNumber1*ComplexNumber2 = ");
        complexNumber4.showComplexNumber();
    }

    /*********************************
     *      createComplexNumber      *
     *********************************/
    public static ComplexNumber createComplexNumber() {
        System.out.println("Please enter a complex number: ");
        System.out.println("Real part: ");
        double realPart = new Scanner(System.in).nextDouble();

        System.out.println("Image part: ");
        double imagePart = new Scanner(System.in).nextDouble();

        return new ComplexNumber(realPart,imagePart);
    }

    /*********************************
     *        addComplexNumber       *
     *********************************/
    public static ComplexNumber addComplexNumber(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
        return new ComplexNumber((complexNumber1.getRealPart() + complexNumber2.getRealPart())
                ,(complexNumber1.getImagePart() + complexNumber2.getImagePart()));
    }

    /*********************************
     *     multipleComplexNumber     *
     *********************************/
    public static ComplexNumber multipleComplexNumber(ComplexNumber complexNumber1,ComplexNumber complexNumber2) {
        double realPart = complexNumber1.getRealPart()*complexNumber2.getRealPart()
                - complexNumber1.getImagePart()*complexNumber2.getImagePart();

        double imagePart = complexNumber1.getRealPart()*complexNumber2.getImagePart()
                + complexNumber1.getImagePart()*complexNumber2.getRealPart();

        return new ComplexNumber(realPart,imagePart);
    }
}