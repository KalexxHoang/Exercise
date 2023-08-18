package View;

import Model.BorrowNote;
import Model.Student;

import java.util.Scanner;

public class View {
    /*********************************
     *            printMenu          *
     *********************************/
    public void printMenu(){
        System.out.println("Menu:");
        System.out.println("\t1: Add Borrow note");
        System.out.println("\t2: Delete Borrow note");
        System.out.println("\t3: Show Card information");
        System.out.println("\t4: Exit");
    }

    /*********************************
     *           createNote          *
     *********************************/
    public BorrowNote createNote() {
        System.out.println("Please enter borrow note you want to add: ");

        String borrowCode = this.inputBorrowCode();

        System.out.println("Borrow day: ");
        int borrowDay = new Scanner(System.in).nextInt();

        System.out.println("Deadline: ");
        int deadLine = new Scanner(System.in).nextInt();

        System.out.println("Book ID: ");
        String bookID = new Scanner(System.in).nextLine();

        return new BorrowNote(borrowCode,borrowDay,deadLine,bookID);
    }

    /*********************************
     *          Input Infor          *
     *********************************/
    public String inputCardID() {
        System.out.println("Card ID: ");
        return new Scanner(System.in).nextLine();
    }

    public String inputBorrowCode() {
        System.out.println("Borrow code: ");
        return new Scanner(System.in).nextLine();
    }

    /*********************************
     *          createStudent        *
     *********************************/
    public Student createStudent() {
        System.out.println("Full name: ");
        String fullName = new Scanner(System.in).nextLine();

        System.out.println("Age: ");
        int age = new Scanner(System.in).nextInt();

        System.out.println("Class: ");
        String classs = new Scanner(System.in).nextLine();

        return new Student(fullName,age,classs);
    }

    /*********************************
     *        showNoExistCard        *
     *********************************/
    public void showNoExistCard() {
        System.out.println("This card don't exists!");
        System.out.println("You need to create a new card. Please enter information about this card:");
    }
}
