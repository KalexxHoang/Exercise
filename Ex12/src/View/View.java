package View;

import Model.Vehicle;

import java.util.Scanner;

public class View {
    /*********************************
     *            printMenu          *
     *********************************/
    public void printMenu(){
        System.out.println("Menu:");
        System.out.println("\t1: Add vehicle");
        System.out.println("\t2: Delete vehicle");
        System.out.println("\t3: Search vehicle");
        System.out.println("\t4: Exit");
    }

    /*********************************
     *       printReplaceOption      *
     *********************************/
    public void printReplaceOption() {
        System.out.println("This ID already exists!");
        System.out.println("Do you want to replace?");
        System.out.println("\t1: YES");
        System.out.println("\t2: NO");
    }

    /*********************************
     *        printVehicleMenu       *
     *********************************/
    public void printVehicleMenu() {
        System.out.println("What type of vehicle do you want to add:");
        System.out.println("\t1: Car");
        System.out.println("\t2: Motor");
        System.out.println("\t3: Truck");
    }

    /*********************************
     *          createVehicle        *
     *********************************/
    public Vehicle createVehicle() {
        String ID = this.inputID();
        String brand = this.inputBrand();

        System.out.println("Year of Production: ");
        int productionYear = new Scanner(System.in).nextInt();

        System.out.println("Cost($): ");
        int cost = new Scanner(System.in).nextInt();

        String color = this.inputColor();

        return new Vehicle(ID,brand,productionYear,cost,color);
    }

    /*********************************
     *          Input Infor          *
     *********************************/
    public String inputID() {
        System.out.println("ID: ");
        return new Scanner(System.in).nextLine();
    }

    public String inputBrand() {
        System.out.println("Brand: ");
        return new Scanner(System.in).nextLine();
    }

    public String inputColor() {
        System.out.println("Color: ");
        return new Scanner(System.in).nextLine();
    }

    public int inputSeatNumber() {
        System.out.println("Number of seat: ");
        return new Scanner(System.in).nextInt();
    }

    public String inputEngineType() {
        System.out.println("Type of engine: ");
        return new Scanner(System.in).nextLine();
    }

    public int inputPower() {
        System.out.println("Power: ");
        return new Scanner(System.in).nextInt();
    }

    public int inputGrossTon() {
        System.out.println("Gross ton: ");
        return new Scanner(System.in).nextInt();
    }

    /*********************************
     *       showNoExistVehicle      *
     *********************************/
    public void showNoExistVehicle() {
        System.out.println("This vehicle don't exists!");
    }

    /*********************************
     *        showSearchOption       *
     *********************************/
    public void showSearchOption() {
        System.out.println("What do you want to search by?");
        System.out.println("\t1: Brand");
        System.out.println("\t2: Color");
    }
}
