package View;

import Controller.Check;
import Model.Exception.InvalidDOBException;
import Model.Exception.InvalidFullNameException;
import Model.Exception.InvalidPhoneNumberException;
import Model.Student.Student;

import java.util.Scanner;

public class View {
    /*********************************
     *            printMenu          *
     *********************************/
    public void printMenu(){
        System.out.println("Menu:");
        System.out.println("\t1: Add student");
        System.out.println("\t2: Show choosed candidates");
        System.out.println("\t3: Show total candidates list");
        System.out.println("\t4: Exit");
    }

    /*********************************
     *           Input Infor         *
     *********************************/
    public double inputGPA() {
        System.out.println("GPA: ");
        return new Scanner(System.in).nextDouble();
    }

    public String inputBestRewardName() {
        System.out.println("Best reward: ");
        return new Scanner(System.in).nextLine();
    }

    public int inputEnglishScore() {
        System.out.println("Toeic: ");
        return new Scanner(System.in).nextInt();
    }

    public double inputEntryScore() {
        System.out.println("Entry test score: ");
        return new Scanner(System.in).nextDouble();
    }

    /*********************************
     *            addStudent         *
     *********************************/
    public Student addStudent() throws InvalidFullNameException, InvalidDOBException, InvalidPhoneNumberException {
        System.out.println("Please enter information of student you want to add:");
        System.out.println("Full name: ");
        String fullName = new Scanner(System.in).nextLine();
        Check.checkFullName(fullName);

        System.out.println("Date of Birth: ");
        String doB = new Scanner(System.in).nextLine();
        Check.checkDOB(doB);

        System.out.println("Sex: ");
        String sex = new Scanner(System.in).nextLine();

        System.out.println("Phone number: ");
        String phoneNumber = new Scanner(System.in).nextLine();
        Check.checkPhoneNumber(phoneNumber);

        System.out.println("University: ");
        String university = new Scanner(System.in).nextLine();

        return new Student(fullName,doB,sex,phoneNumber,university);
    }

    /*********************************
     *        printGradeOption       *
     *********************************/
    public void printGradeOption() {
        System.out.println("Grade level: ");
        System.out.println("\t1: Good");
        System.out.println("\t2: Normal");
    }

    /*********************************
     *         printShowOption       *
     *********************************/
    public void printShowOption() {
        System.out.println("Do you want to show by?");
        System.out.println("\t1: Full name");
        System.out.println("\t2: Phone number");
    }

    /*********************************
     *          inputQuantity        *
     *********************************/
    public int inputQuantity() {
        System.out.println("Please enter quantity of candidate (11 <= n <= 15) you want to choose: ");
        return new Scanner(System.in).nextInt();
    }
}
