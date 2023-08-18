package View;

import java.util.Scanner;

public class View {
    /*********************************
     *         inputQuantity         *
     *********************************/
    public int inputQuantity() {
        System.out.println("Please enter quantity of family of the street");
        return new Scanner(System.in).nextInt();
    }

    /*********************************
     *        showReplaceOption      *
     *********************************/
    public void showReplaceOption() {
        System.out.println("This apartment number already exists!");
        System.out.println("Do you want to replace?");
        System.out.println("\t1: YES");
        System.out.println("\t2: NO");
    }

    /*********************************
     *           Input Infor         *
     *********************************/
    public int inputNumberMember() {
        System.out.println("\tNumber of Member: ");
        return new Scanner(System.in).nextInt();
    }

    public String inputApartmentNumber() {
        System.out.println("\tApartment Number: ");
        return new Scanner(System.in).nextLine();
    }
}
