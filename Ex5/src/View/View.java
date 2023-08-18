package View;

import Model.Person;

import java.util.Optional;
import java.util.Scanner;

public class View {
    /*********************************
     *            printMenu        *
     *********************************/
    public void printMenu(){
        System.out.println("Menu:");
        System.out.println("\t1: Add person");
        System.out.println("\t2: Delete person");
        System.out.println("\t3: Compute rent");
        System.out.println("\t4: Show imformation of clients");
        System.out.println("\t5: Exit");
    }

    /*********************************
     *          addPerson            *
     *********************************/
    public Person addPerson(){
        System.out.println("Fullname: ");
        String fullName = new Scanner(System.in).nextLine();

        System.out.println("Age: ");
        int age = new Scanner(System.in).nextInt();

        int CCCD = this.inputCCCD();

        System.out.println("Rental days: ");
        int rentalDays = new Scanner(System.in).nextInt();

        System.out.println("Type of room: " );
        String typeRoom = new Scanner(System.in).nextLine();

        return new Person(fullName,age,CCCD,rentalDays,typeRoom);
    }

    /*********************************
     *          Input Infor          *
     *********************************/
    public int inputCCCD() {
        System.out.println("CCCD: ");
        return new Scanner(System.in).nextInt();
    }

    /*********************************
     *        showReplaceOption      *
     *********************************/
    public void showReplaceOption() {
        System.out.println("This person already exists!");
        System.out.println("Do you want to replace?");
        System.out.println("\t1: YES");
        System.out.println("\t2: NO");
    }

    /*********************************
     *             showRent          *
     *********************************/
    public void showRent(Optional<Person> check) {
        if (check.isPresent())
            System.out.println("Your rent: " + check.get().computeRent() + "$");
        else
            System.out.println("Cannot find person!");
    }
}
