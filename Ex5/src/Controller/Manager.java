package Controller;

import Model.Hotel;
import Model.Person;
import View.ROOM;
import View.MENU;
import java.util.Scanner;

public class Manager {
    /**********************************
     *            Attribute           *
     **********************************/
    private Hotel manager;

    /*********************************
     *            Constructor        *
     *********************************/
    public Manager() {
        this.manager = new Hotel();
    }

    /*********************************
     *            userMenu           *
     *********************************/
    public void userMenu(){
        int menuOp;
        boolean condition = true;
        while (condition){
            printMenu();
            menuOp = new Scanner(System.in).nextInt();
            MENU menu = MENU.getEnumMenu(menuOp);
            switch (menu){
                case ADD_PERSON:
                    System.out.println("Please enter imformation of person you want to add: ");
                    addPerson();
                    break;
                case DELETE_PERSON:
                    System.out.println("Please enter CCCD of person you want to delete: ");
                    int CCCD = new Scanner(System.in).nextInt();
                    this.manager.deletePerson(CCCD);
                    break;
                case COMPUTE_RENT:
                    System.out.println("Please enter CCCD of person you want to compute rent: ");
                    int CCCD1 = new Scanner(System.in).nextInt();
                    this.manager.computeRent(CCCD1);
                    break;
                case SHOW_INFOR:
                    System.out.println("Information of clients");
                    this.manager.showInfor();
                    break;
                case EXIT:
                    condition = false;
                    break;

            }
        }
    }

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
    public void addPerson(){
        System.out.println("Fullname: ");
        String fullName = new Scanner(System.in).nextLine();

        System.out.println("Age: ");
        int age = new Scanner(System.in).nextInt();

        System.out.println("CCCD: ");
        int CCCD = new Scanner(System.in).nextInt();

        System.out.println("Rental days: ");
        int rentalDays = new Scanner(System.in).nextInt();

        System.out.println("Type of room: " );
        String typeRoom = new Scanner(System.in).nextLine();

        Person person1 = new Person(fullName,age,CCCD,rentalDays,typeRoom);
        this.manager.addPerson(person1);
    }
}
